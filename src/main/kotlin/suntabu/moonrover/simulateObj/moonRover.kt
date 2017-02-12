/**
 * Created by gouzhun on 2017/2/10.
 */

package suntabu.moonrover.simulateObj

import suntabu.moonrover.FRAME_INTERVAL
import suntabu.moonrover.MessagePool
import suntabu.moonrover.ROVER_INTERVAL

class MoonRover(val roverid: Int) {
    public var id = roverid;






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

        Thread(Runnable {
            mTimeStartup = System.currentTimeMillis()

            while (mWorking) {
                mTimeFrameStart = getTimeSinceStartup()

                mReportInterval += mTimeDelta
                if (mReportInterval >= ROVER_INTERVAL) {
                    report()
                    mReportInterval = 0L
                }

                Thread.sleep(FRAME_INTERVAL - getTimeSinceStartup() % FRAME_INTERVAL)


                mTimeFrameEnd = getTimeSinceStartup()
                mTimeDelta = mTimeFrameEnd - mTimeFrameStart
            }


        }).start()
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
        MessagePool.dispatchMessage("report to control center with $id info")
    }


}

