package suntabu.moonrover.simulateObj

import suntabu.moonrover.utils.Vector2

/**
 * Created by gouzhun on 2017/2/13.
 */
/**
 * 使用圆形碰撞盒和月球车边界射线是否相交判断障碍物
 *
 *
 */
class CircleCollider(val radius:Float,val rover:MoonRover){

    fun isIntersectWithRay(dir:Vector2, point:Vector2):Boolean{
        //根据点到直线距离公式推算出：
        var a = dir.y
        var b =  - dir.x
        var c = dir.x * point.y - point.x * dir.y

        var p = a * rover.postion.x + b * rover.postion.y + c


        var d = Math.abs(p)/Math.sqrt(a * a + b* b.toDouble()).toFloat()


        var vertical = Vector2()
        if (p >0){
            vertical = Vector2(-dir.y,dir.x)
        }else{
            vertical = Vector2(dir.y, - dir.x)
        }

        var intersectPoint = rover.postion + vertical.normalize().times(d)

        var newDir = intersectPoint - point
        if (d <= radius && dir.dot(newDir) > 0)
            return  true


        return false
    }
}
