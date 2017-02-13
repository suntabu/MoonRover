package suntabu.moonrover.utils

/**
 * Created by gouzhun on 2017/2/13.
 */
fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)


fun Float.format(digits: Int) = java.lang.String.format("%.${digits}f", this)