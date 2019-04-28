> 作者：林冠宏 / 指尖下的幽灵

> 掘金：https://juejin.im/user/587f0dfe128fe100570ce2d8

> 博客：http://www.cnblogs.com/linguanh/

> GitHub ： https://github.com/af913337456/

> 为了您的直观体验，请务必看完下面 gif 图，源码 gitHub 链接在其之后。

为了避免大家浪费时间，直接先看下面的 Gif，略大，请耐心点。看完后，若你觉得会需要到，那么就请听我继续。

gif 演示太大，github 显示不了。看视频链接可以去文章：https://juejin.im/post/59006c76a0bb9f0065dbc835 中看

### 引用库(use library)

```java
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}
compile 'com.github.af913337456:WeChatVideoView:1.0'
```

### 功能点

如果你看完上面的gif图，你会发现如下几点功能 (Function list)：

1，<strong>直观的</strong>
* 播放前，可以显示封面缩略图
* 播放时，如果还没有本地缓存，那么先进行下载
* 下载过程中，显示圆型区域进度效果
* 下载后，播放完毕后可以循环播放
* 播放已经播放过的，是具备本地缓存的，也就是既能播放网络，也能播放本地

2，<strong>隐藏的</strong>
* 低耗电量
* 低内存占用
* 无延迟图与视频切换
* 低耦合，高内聚，几行代码接入

### 解析
直观的功能点，几乎就是和新版<strong>```微信```</strong>的一样，从朋友圈点击一个视频，然后进入到一个 Activity 页面进行加载以及播放。

##### 为什么低耗电量和低内存占用？
因为采用的是 SurfaceView 而不是 TextureView，图与视频切换的切换延迟也是这个原因。

##### 在你的 Activity 中这样使用
![](https://dn-mhke0kuv.qbox.me/3c1516f88ed7d3d89a74)
这样就会以 id 为 activity_main 的 Relativelayout 为父容器装载。
因为要避免内存泄露，所以你还需要做完下面的一些步骤，不会超过6行代码。
![](https://dn-mhke0kuv.qbox.me/b1f9ce326062f328b711)
