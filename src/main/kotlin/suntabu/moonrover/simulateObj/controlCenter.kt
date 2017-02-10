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



data class Transform(val position: Vector2, val direction: Vector2, val speed: Vector2, val rotate:Float, val time:Int) {
    var pos: Vector2 = Vector2()
    var dir: Vector2 = Vector2()
    var velocity: Vector2 = Vector2()
    var angle:Float=0f
    var timeStamp: Int = 0

}