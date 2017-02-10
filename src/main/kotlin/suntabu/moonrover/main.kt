/**
 * Created by gouzhun on 2017/2/10.
1.月球车移动之前会将当前坐标（X,Y），目标坐标（X1,Y1），移动速度发送给地面控制中心，然后开始直线向目标移动
2.每隔1秒钟月球车会向地面控制中心发一次自己的位置坐标，方向和速度
3.如果遇到障碍物月球车会自动绕开障碍物，每次月球车改变方向都会发送按顺时针计算的转向角度给地面控制中心。
4.月地通讯有2秒延迟，控制中心需要根据方向和速度预测当前月球车位置
5.编程模拟月球车和地面控制中心，月球车按固定线路进行模拟就行，地面控制中心每500ms在标准输出上输出一次各个月球车的报告位置、预测位置和方向
6.要求模拟5辆月球车和一个控制中心。
7.程序启动时从一个文本文件中读取5条线路数据分配给5辆月球车进行模拟，线路数据包含了每秒位置，方向，速度以及转向角度，每条线路的运行时间不小于15分钟,具体文件格式请给出说明
8.请将说明和程序代码提交到Github并发回链接，在2月14日之前完成。

 */

package suntabu.moonrover

import suntabu.moonrover.simulateObj.*
import java.io.File
import java.nio.charset.Charset
import java.util.*

val CONTROL_INTERVAL = 500L   //control center print info interval.
val ROVER_INTERVAL = 1000L    //rover report it's info interval.
val TRANSPORT_DELAY = 2000L   //the delay of transport between lunar and earth.
val FILE_PATH = "routes.txt"  //the file recorded routes.


fun main(args:Array<String>){
    val simulate = RoverSimulate(5)
    simulate.run()
}



class RoverSimulate(val count:Int){
    val rovers: ArrayList<MoonRover> = arrayListOf()
    val control: ControlCenter = ControlCenter()


    fun run(){
        for (i in 0..count - 1){
            var rover = MoonRover(i)
            rovers.add(rover)

            rover.startup()
        }


        control.startup()
        File(FILE_PATH).printWriter().use { out ->

            for (i in 0..15*60)
            {
                val t = Transform(Vector2(), Vector2(),Vector2(),20f,i)

                out.println(t)
            }


        }
    }
}



fun GenerateRoute(){
   /* File(FILE_PATH).readLines().forEach {

    }*/
}