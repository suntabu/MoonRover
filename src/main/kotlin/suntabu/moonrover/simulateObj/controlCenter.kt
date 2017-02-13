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

    var printInfos:MutableMap<Int,PrintInfo> = mutableMapOf()
    fun startup() {

        val runnable = Runnable {
            while (true) {
                //println("send a message")
                roversInfo.forEach {
//                    println("Rover ${it.key} run at ${it.value.last()}" )

                    predictRover(it.value.last())
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



    fun predictRover(msg:Message){
        var pi:PrintInfo?
        if (printInfos.containsKey(msg.fromId)){
             pi = printInfos[msg.fromId]

        }else{
             pi = PrintInfo()
            pi?.id = msg.fromId
            printInfos.put(msg.fromId,pi)
        }

        pi?.reportPos = msg.pos
        pi?.direction= Vector2.from(msg.speed,msg.angle)
        pi?.predictPos = msg.pos + pi?.direction!! * ((System.currentTimeMillis() - msg.time)/1000f)
        println("Rover " +pi?.id +
                "\t\t\treport pos: " + pi?.reportPos +
                "\t\t\tpredictPos: " + pi?.predictPos +
                "\t\t\tdirection: " + pi?.direction)
    }
}


class PrintInfo{
    var id:Int = 0
    var reportPos:Vector2 = Vector2()
    var predictPos:Vector2 = Vector2()
    var direction :Vector2 = Vector2()
}
