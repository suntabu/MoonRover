package suntabu.moonrover.models

import suntabu.moonrover.utils.Vector2

/**
 * Created by gouzhun on 2017/2/12.
 */

data class Message(val fromId:Int,val pos:Vector2,val angle:Float,val speed:Float,val msg:String,val time:Long){

}