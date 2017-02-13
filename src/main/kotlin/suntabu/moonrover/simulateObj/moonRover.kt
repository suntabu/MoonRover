/**
 * Created by gouzhun on 2017/2/10.
 */

package suntabu.moonrover.simulateObj

import suntabu.moonrover.*
import suntabu.moonrover.models.Message
import suntabu.moonrover.models.Transform
import suntabu.moonrover.utils.Vector2
import suntabu.moonrover.utils.Vector3
import suntabu.moonrover.utils.format

class MoonRover(val roverid: Int) {
    public var id = roverid;

    /***********Circle Collider************/

    public var collider:CircleCollider= CircleCollider(ROVER_WIDTH,this)

    /*********Transform***********/
    public var postion: Vector2 = Vector2()
    public var speed: Float = 0f
    public var angle: Float = 0f
    public var targetPos: Vector2 = Vector2()


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
        setTransformInfo(route[routeInx])

        Thread(Runnable {
            mTimeStartup = System.currentTimeMillis()

            while (mWorking) {
                mTimeFrameStart = getTimeSinceStartup()

                mReportInterval += mTimeDelta
                if (mReportInterval >= ROVER_INTERVAL) {
                    report()
                    mReportInterval = 0L



                    routeInx++
                    if (routeInx >= route.size) {
                        mWorking = false
                    }
                    var tran = route[routeInx]
                    setTransformInfo(tran)
                }



                translate()

                Thread.sleep(FRAME_INTERVAL - getTimeSinceStartup() % FRAME_INTERVAL)


                mTimeFrameEnd = getTimeSinceStartup()
                mTimeDelta = mTimeFrameEnd - mTimeFrameStart
            }


        }).start()
    }

    fun translate() {
        var dir = (targetPos - this.postion).normalize()

        rovers.forEach {
            if (it.id != this.id){
                if (it.collider.isIntersectWithRay(dir,this.postion)){
                    dir = Vector3(dir).cross(Vector3(0f,1f,0f)).toVector2()
                }
            }
        }


        this.postion += dir * speed * (mTimeDelta.toFloat() / 1000)
    }

    fun getTimeSinceStartup(): Long {
        return System.currentTimeMillis() - mTimeStartup;
    }

    fun setRoute(data: List<Transform>?) {
        if (data != null) {
            this.route = data
        } else throw Exception("given route of ${id} is null")
    }

    fun setTransformInfo(tran:Transform){
        this.angle = tran.angle
        this.speed = tran.speed
        this.targetPos = tran.pos
    }

    fun report() {
        MessagePool.dispatchMessage(Message(id,postion,angle,speed, "report to control center with Route $id / pos $postion / angle ${angle.format(2)} / speed ${speed.format(2)}", System.currentTimeMillis()))
    }


}

