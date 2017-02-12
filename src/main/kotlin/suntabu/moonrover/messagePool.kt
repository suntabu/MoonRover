package suntabu.moonrover

/**
 * Created by gouzhun on 2017/2/12.
 */

object MessagePool {

    var messageQueue: MutableList<String> = mutableListOf()

    fun registerDevice() {

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


    fun dispatchMessage(msg: String) {
        messageQueue.add(msg)
    }

    private fun dispatch(msg: String) {
        println(msg)
    }

}