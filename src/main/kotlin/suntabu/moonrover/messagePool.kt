package suntabu.moonrover

import suntabu.moonrover.models.Message
import suntabu.moonrover.simulateObj.ControlCenter

/**
 * Created by gouzhun on 2017/2/12.
 */

object MessagePool {

    var messageQueue: MutableList<Message> = mutableListOf()

    var controlCenter:ControlCenter? = null

    fun registerDevice(cc:ControlCenter) {
        controlCenter = cc
    }


    fun init() {
        Thread(Runnable {
            while (true) {
                Thread.sleep(TRANSPORT_DELAY)

                dispatch(messageQueue[0])
                messageQueue.removeAt(0)
            }

        }).start()
    }


    fun dispatchMessage(msg: Message) {
        messageQueue.add(msg)
    }

    private fun dispatch(msg: Message) {
        //println(msg)
        controlCenter?.receivedMessage(msg)
    }

}