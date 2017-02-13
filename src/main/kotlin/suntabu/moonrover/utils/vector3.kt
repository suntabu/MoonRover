package suntabu.moonrover.utils

/**
 * Created by gouzhun on 2017/2/13.
 */


class Vector3(val ix: Float = 0f, val iy: Float = 0f,val iz:Float = 0f) {
    var x: Float = ix
    var y: Float = iy
    var z: Float = iz

    constructor(ve:Vector2) : this() {
        x = ve.x
        y = 0f
        z = ve.y
    }

    fun cross(other:Vector3):Vector3{

        return Vector3(y*other.z-other.y * z,z * other.x -other.z * x,x * other.y -other.x * y)
    }

    fun toVector2():Vector2{
        return Vector2(x,z)
    }

}