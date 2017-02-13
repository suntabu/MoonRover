# MoonRover
**This is a Kotlin learning project built with [Gradle](http://kotlinlang.org/docs/reference/using-gradle.html). You can find Kotlin gradle examples at [here](https://github.com/JetBrains/kotlin-examples/tree/master/gradle/hello-world)**

### Goals
- 1.月球车移动之前会将当前坐标（X,Y），目标坐标（X1,Y1），移动速度发送给地面控制中心，然后开始直线向目标移动
- 2.每隔1秒钟月球车会向地面控制中心发一次自己的位置坐标，方向和速度
- 3.如果遇到障碍物月球车会自动绕开障碍物，每次月球车改变方向都会发送按顺时针计算的转向角度给地面控制中心。
- 4.月地通讯有2秒延迟，控制中心需要根据方向和速度预测当前月球车位置
- 5.编程模拟月球车和地面控制中心，月球车按固定线路进行模拟就行，地面控制中心每500ms在标准输出上输出一次各个月球车的报告位置、预测位置和方向
- 6.要求模拟5辆月球车和一个控制中心。
- 7.程序启动时从一个文本文件中读取5条线路数据分配给5辆月球车进行模拟，线路数据包含了每秒位置，方向，速度以及转向角度，每条线路的运行时间不小于15分钟,具体文件格式请给出说明

### Route File Formate
File Content Example:
> 0,342.00,481.00,-0.37,0.11,2.32,0.54,751
  0,284.00,228.00,0.22,0.15,0.88,1.13,752
  0,85.00,115.00,-0.29,-0.12,0.53,-0.41,753
  0,342.00,173.00,0.34,0.47,2.21,0.63,754
  0,480.00,291.00,-0.30,-0.27,0.46,-3.90,755
  0,356.00,122.00,-0.11,0.33,0.89,-0.22,756
  0,91.00,40.00,0.03,0.49,2.15,1.33,757
  0,195.00,156.00,0.47,0.08,0.65,-2.10,758

Numbers in line stand for:
>id, postion.x, postion.y, routeDirection.x, routeDirection.y, speed, angle, timestamp





#### How to Start
Linux/Mac
``` gradle
	./gradlew build
```
Windows
``` gradle
	gradlew.bat build
```


#### How to Run it
Linux/Mac
``` gradle
	./gradlew run
```
Windows
``` gradle
	gradlew.bat run
```
or
```
	In Run/Debug Configurations for Kotlin, set Main Class as 'suntabu.moonrover.MainKt'
```
