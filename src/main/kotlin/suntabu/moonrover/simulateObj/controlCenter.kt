package suntabu.moonrover.simulateObj

import suntabu.moonrover.simulateObj.Vector2
import java.io.File

/**
 * Created by gouzhun on 2017/2/10.
 */

class ControlCenter(){
    fun startup(){

        val runnable = Runnable {
            while (true){
                println("send a message")

                Thread.sleep(2000L)
            }
        }

        Thread(runnable).start()



    }
}


/**
 * every second the transform information of rover
 * id, position, direction, velocity, angle, timestamp
 */
data class Transform(val routeId:Int, val position: Vector2, val direction: Vector2, val speed: Vector2, val rotate:Float, val time:Int) {
    var pos: Vector2 = position
    var dir: Vector2 = direction
    var velocity: Vector2 = speed
    var angle:Float=rotate
    var timeStamp: Int = time
    var id:Int = routeId

}