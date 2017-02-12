package suntabu.moonrover.simulateObj

import suntabu.moonrover.CONTROL_INTERVAL
import suntabu.moonrover.utils.Vector2
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


