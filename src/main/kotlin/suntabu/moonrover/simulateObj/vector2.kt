package suntabu.moonrover.simulateObj

/**
 * Created by gouzhun on 2017/2/10.
 */


class Vector2(val ix: Float = 0f, val iy: Float = 0f) {
    var x: Float = ix
    var y: Float = iy


    override fun toString(): String {
        return "($x,$y)"
    }

    fun magnitude(): Float {
        return Math.sqrt(x * x + y * y.toDouble()).toFloat()
    }
}