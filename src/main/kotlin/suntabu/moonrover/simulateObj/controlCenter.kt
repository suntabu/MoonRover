package suntabu.moonrover.simulateObj

import suntabu.moonrover.CONTROL_INTERVAL
import suntabu.moonrover.simulateObj.Vector2
import java.io.File

/**
 * Created by gouzhun on 2017/2/10.
 */

class ControlCenter(){
    fun startup(){

        val runnable = Runnable {
            while (true){
                //println("send a message")

                Thread.sleep(CONTROL_INTERVAL)
            }
        }

        Thread(runnable).start()



    }
}


/**
 * every second the transform information of rover
 * id,
 * position,
 * nextPosDir,
 * speed,
 * angle,
 * timestamp
 */
data class Transform(val routeId:Int,
                     val position: Vector2,
                     val nextPosDir: Vector2,
                     val inSpeed: Float,
                     val inAngle:Float,
                     val time:Int) {
    var id = routeId
    var pos = position
    var routeDir = nextPosDir
    var speed = inSpeed
    var angle = inAngle
    var timeStamp = time




}