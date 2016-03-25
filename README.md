##几个View的用法
####NavigationView(侧滑菜单栏）：<br>
*添加侧滑菜单栏的头View-->>app:headerLayout<br>
*添加侧滑菜单栏的menu-->>app:menu<br>
Java代码：
<br>NavigationView一般在DrawerLayout中，所以首先需要实例化DrawerLayout，
<br>还需要new一个ActionBarDrawerToggle，传入五个参数：
<br>new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
<br>最后在加上--drawertoggle.syncState();
<br>
<br>
####RecyclerView(滑动的List):<br>
和ListView一样，先定义一个RecyclerView的Adapter，在Adapter下可以内部建一个ViewHolder的类（方法和ListView雷同)。<br>
<br>
<br>
####SwipeRefreshLayout(下拉刷新):<br>
一个下拉刷新的动作，XML中在Swipe下放一可滑动的View，像ListView，RecyclerView，ScollView等。<br>
在Java中需要设定刷新完整动作，包括刷新时间、内容等。
