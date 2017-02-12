package suntabu.moonrover.simulateObj

import suntabu.moonrover.CONTROL_INTERVAL
import suntabu.moonrover.models.Message
import suntabu.moonrover.utils.Vector2
import java.io.File

/**
 * Created by gouzhun on 2017/2/10.
 */

class ControlCenter() {

    var roversInfo: MutableMap<Int, MutableList<Message>> = mutableMapOf()


    fun startup() {

        val runnable = Runnable {
            while (true) {
                //println("send a message")
                roversInfo.forEach {
                    println("${it.key} run at ${it.value.last()}" )
                }
                Thread.sleep(CONTROL_INTERVAL)
            }
        }

        Thread(runnable).start()

    }


    fun receivedMessage(msg: Message) {
        if (roversInfo.containsKey(msg.fromId)) {
            var list = roversInfo[msg.fromId]
            if (list == null) {
                list = mutableListOf()
            }
            list.add(msg)
        }

        roversInfo.put(msg.fromId, mutableListOf(msg))
    }
}


