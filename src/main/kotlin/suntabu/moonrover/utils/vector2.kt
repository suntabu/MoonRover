package suntabu.moonrover.utils

/**
 * Created by gouzhun on 2017/2/10.
 */


/**
 * TIPS：angle 在项目中是使用的顺时针值，所以需要注意！
 */
class Vector2(val ix: Float = 0f, val iy: Float = 0f) {
    var x: Float = ix
    var y: Float = iy


    override fun toString(): String {
        return "(${x.format(2)},${y.format(2)})"
    }

    fun magnitude(): Float {
        return Math.sqrt(x * x + y * y.toDouble()).toFloat()
    }

    fun angle(): Float {
        if (x == 0f) {
            if (y == 0f){
                return 0f
            }
            return -(y / Math.abs(y) * Math.PI / 2).toFloat()
        }

        if (x > 0f) {
            return -Math.atan(y / x.toDouble()).toFloat()
        }

        if (x < 0) {
            return -(Math.PI - Math.atan(y / -x.toDouble())).toFloat()
        }

        return 0f;
    }


    fun normalize():Vector2{
        var mag = magnitude()
        if (mag != 0f)
            return this .times(1/mag)
        else{
            return this
        }
    }

    operator fun times(scale: Float): Vector2 {
        return Vector2(x * scale, y * scale)
    }

/*    operator fun plusAssign(other: Vector2) {
        x += other.x
        y += other.y
    }*/


    operator fun minus(other:Vector2):Vector2{
        return Vector2(this.x - other.x, this.y - other.y)
    }

    companion object {
        fun from(magnitude: Float, angle: Float): Vector2 {
            val sin = Math.sin(-angle.toDouble()).toFloat()
            val cos = Math.cos(-angle.toDouble()).toFloat()
            if (sin == 0f) {
                return Vector2(cos * magnitude, 0f)
            }

            if (cos == 0f) {
                return Vector2(0f, sin * magnitude)
            }

            return Vector2(cos * magnitude, sin * magnitude)
        }
    }

    infix operator fun plus(other: Vector2): Vector2 {
        return Vector2(x + other.x,y + other.y)
    }
}


