/**
 * Created by gouzhun on 2017/2/10.
 */

package suntabu.moonrover.simulateObj

import suntabu.moonrover.FRAME_INTERVAL
import suntabu.moonrover.MessagePool
import suntabu.moonrover.ROVER_INTERVAL
import suntabu.moonrover.models.Message
import suntabu.moonrover.models.Transform
import suntabu.moonrover.utils.Vector2

class MoonRover(val roverid: Int) {
    public var id = roverid;

    /*********Transform***********/
    public var postion: Vector2 = Vector2()
    public var speed: Float = 0f
    public var angle: Float = 0f


    /***Engine fields***/
    private var mWorking = true
    private var mTimeStartup = 0L
    private var mTimeDelta = 0L
    private var mTimeFrameStart = 0L
    private var mTimeFrameEnd = 0L

    private var mReportInterval = 0L

    private var route: List<Transform> = mutableListOf()

    fun startup() {
        println("Rover $id start working now!")

        var routeInx = 0;

        Thread(Runnable {
            mTimeStartup = System.currentTimeMillis()

            while (mWorking) {
                mTimeFrameStart = getTimeSinceStartup()

                mReportInterval += mTimeDelta
                if (mReportInterval >= ROVER_INTERVAL) {
                    report()
                    mReportInterval = 0L

                    var tran = route[routeInx]
                    this.angle = tran.angle
                    this.speed = tran.speed
                    var targetPos = tran.pos //TODO: how to use it.

                    routeInx++
                }



                translate()

                Thread.sleep(FRAME_INTERVAL - getTimeSinceStartup() % FRAME_INTERVAL)


                mTimeFrameEnd = getTimeSinceStartup()
                mTimeDelta = mTimeFrameEnd - mTimeFrameStart
            }


        }).start()
    }

    fun translate() {
        this.postion += Vector2.from(speed, angle) * (mTimeDelta.toFloat() / 1000)
    }

    fun getTimeSinceStartup(): Long {
        return System.currentTimeMillis() - mTimeStartup;
    }

    fun setRoute(data: List<Transform>?) {
        if (data != null) {
            this.route = data
        } else throw Exception("given route of ${id} is null")
    }


    fun report() {
        MessagePool.dispatchMessage(Message(id, "report to control center with $id $postion $angle $speed info", System.currentTimeMillis()))
    }


}

