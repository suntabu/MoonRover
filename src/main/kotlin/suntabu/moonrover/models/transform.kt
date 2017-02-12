package suntabu.moonrover.models

import suntabu.moonrover.utils.Vector2

/**
 * Created by gouzhun on 2017/2/12.
 */
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