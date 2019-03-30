# PlaneGame-v_0.9
项目包括 源代码 、exe可执行程序、及将Jar文件转化为exe的EXE4J 软件。

可以将项目源代码打包为jar文件后通过EXE4J自行转化为exe程序。

源码中的UI部分尚未加入，后续完善。

源码简介：
  源码中包括八个类，其中PlaneGameFrame为主类，内涵main方法入口、程序窗口的加载。
  以及一些类的调用，线程的声明等。
  GameObject为游戏根类，是所有游戏对象的父类，具有基础属性。shell与plane类是其子类。
  Plane、shell、bigshell为封装的游戏对象。
  constant为静态常量数据，保存了一些static量以供其他类调用，方便程序更改。
  GameUtil为工具类，实现了图片的加载功能。

*************************
          栾佳乐
update 2019.3.30
