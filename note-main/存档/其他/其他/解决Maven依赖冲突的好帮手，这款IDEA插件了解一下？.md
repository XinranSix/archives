--- _ [http://mp.weixin.qq.com/s?\_\_biz=MzA4NzQ0Njc4Ng==&amp;mid=2247505402&amp;idx=1&amp;sn=0e9756ac1c51b07b91a939f2a8b4b1ed&amp;chksm=903bd197a74c58810772a10fa165d2128f063bce62b0edb8217dae4cc27865b34a0cf88fbef3&amp;mpshare=1&amp;scene=1&amp;srcid=1027wyliXLJ2Vdd0IwF0NcTf&amp;sharer_sharetime=1666843833110&amp;sharer_shareid=11c46305be36f8c23bd557e8c7bec8c9#rd - 微信公众平台](http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&mid=2247505402&idx=1&sn=0e9756ac1c51b07b91a939f2a8b4b1ed&chksm=903bd197a74c58810772a10fa165d2128f063bce62b0edb8217dae4cc27865b34a0cf88fbef3&mpshare=1&scene=1&srcid=1027wyliXLJ2Vdd0IwF0NcTf&sharer_sharetime=1666843833110&sharer_shareid=11c46305be36f8c23bd557e8c7bec8c9#rd) _ 2022-10-27 12:10:42 --- ![](/FILES/image/77929e43.png)​

*作者：*桔子 214032\*\*

_segmentfault.com/a/1190000017542396_

## 1、何为依赖冲突

Maven 是个很好用的依赖管理工具，但是再好的东西也不是完美的。Maven 的依赖机制会导致 Jar 包的冲突。

举个例子，现在你的项目中，使用了两个 Jar 包，分别是 A 和 B。现在 A 需要依赖另一个 Jar 包 C，B 也需要依赖 C。但是 A 依赖的 C 的版本是 1.0，B 依赖的 C 的版本是 2.0。这时候，Maven 会将这 1.0 的 C 和 2.0 的 C 都下载到你的项目中，这样你的项目中就存在了不同版本的 C，这时 Maven 会依据 ​**依赖路径最短优先原则**​，来决定使用哪个版本的 Jar 包，而另一个无用的 Jar 包则未被使用，这就是所谓的 ​**依赖冲突**​。

在大多数时候，依赖冲突可能并不会对系统造成什么异常，因为 Maven 始终选择了一个 Jar 包来使用。但是，不排除在某些特定条件下，会出现类似 ​**找不到类的异常**​，所以，只要存在依赖冲突，在我看来，最好还是解决掉，不要给系统留下隐患。

## 2、解决方法

解决依赖冲突的方法，就是使用 Maven 提供的 `<exclusion>`​ 标签，`<exclusion>`​ 标签需要放在`<exclusions>`​ 标签内部，就像下面这样：

```
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.10.0</version>
    <exclusions>
        <exclusion>
        <artifactId>log4j-api</artifactId>
        <groupId>org.apache.logging.log4j</groupId>
        </exclusion>
    </exclusions>
</dependency>
```

​`log4j-core`​ 本身是依赖了`log4j-api`​ 的，但是因为一些其他的模块也依赖了`log4j-api`​，并且两个`log4j-api`​ 版本不同，所以我们使用`<exclusion>`​ 标签排除掉`log4j-core`​ 所依赖的`log4j-api`​，这样 Maven 就不会下载`log4j-core`​ 所依赖的`log4j-api`​ 了，也就保证了我们的项目中只有一个版本的`log4j-api`​。

## 3、Maven Helper

看到这里，你可能会有一个疑问。如何才能知道自己的项目中哪些依赖的 Jar 包冲突了呢？Maven Helper 这个 InteliJ IDEA 的插件帮我们解决了这个问题。插件的安装方法我就不讲了，既然你都会 Maven 了，我相信你也是会安装插件的。

在插件安装好之后，我们打开 pom.xml 文件，在底部会多出一个**Dependency Analyzer**选项

![](/FILES/image/6ebfbef7.png)  
img

点开这个选项

![](/FILES/image/3ea3f471.png)  
img

找到冲突，点击右键，然后选择**Exclude**即可排除冲突版本的 Jar 包。

## 4、小技巧

除了使用 Maven Helper 查看依赖冲突，也可以使用 IDEA 提供的方法——Maven 依赖结构图，打开 Maven 窗口，选择 Dependencies，然后点击那个图标（Show Dependencies）或者使用快捷键（Ctrl+Alt+Shift+U），即可打开 Maven 依赖关系结构图

![](/FILES/image/73337714.png)  
img

在图中，我们可以看到有一些红色的实线，这些红色实线就是依赖冲突，蓝色实线则是正常的依赖。

![](/FILES/image/d0a0b8d2.png)  
img

<pre><pre><section data-tool="mdnice编辑器" data-website="https://www.mdnice.com"><h2 data-tool="mdnice编辑器"><span>程序汪资料链接</span></h2></section><section data-recommend-title="t" data-recommend-content="t" data-mid=""><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&mid=2247501524&idx=1&sn=2cb28e7b64ab77c55bcc1a172b82a2ad&chksm=903bc2b9a74c4baf5737cd430560ee3c5a357bb37864257a05a72e3cccf41db5bd221ccc63d8&scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click">程序汪接的7个私活都在这里，经验整理</a></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=Mzg2ODU0NTA2Mw==&mid=2247488419&idx=2&sn=0b80c7f9f73fca89b91e257a269cfada&chksm=ceabf4ebf9dc7dfdaa605a9bb92d31c9fc0a10a7a94351234181a89ba5800672c6e7da2ebfbe&scene=21#wechat_redirect" textvalue="Java项目分享  最新整理全集，找项目不累啦 07版" linktype="text" imgurl="" imgdata="null" data-itemshowtype="0" tab="innerlink" data-linktype="2" wah-hotarea="click" hasload="1"><span><strong>Java项目分享  最新整理全集，找项目不累啦 07版</strong><strong></strong></span></a><br/></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&mid=2247494170&idx=1&sn=5181a5277946be31478b1b9425c93f63&chksm=903bee77a74c67614b2772248e8b5e912d323bfe42a0e576dd157a4752f5fed88d6b439ec52f&scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click"><strong>堪称神级的Spring Boot手册，从基础入门到实战进阶</strong></a></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&mid=2247492941&idx=1&sn=2ff31fec735d7c5d6f3483c346d5ca69&chksm=903be120a74c68361fd9afad178e7338315041a2cd4459f2165a8faa20e995a3477af3eda2bb&scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click"><strong>卧槽！字节跳动《算法中文手册》火了，完整版 PDF 开放下载！</strong></a></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&mid=2247496297&idx=2&sn=d253dda2160821262d9f6fc1a9a637d0&chksm=903bf604a74c7f126ab936e374a1f22b9b7cb26a7964b6cc837c3f73af516139064e522a1294&scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click"><strong>卧槽！阿里大佬总结的《图解Java》火了，完整版PDF开放下载！</strong></a></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&mid=2247490715&idx=2&sn=7f2c5de11bebaecfbaf1ce4b945a4d6f&chksm=903818f6a74f91e0fde557b75bd44adfd5d378612f682aa3eef6766927aebb9e5afc72c91a9e&scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click"><strong>字节跳动总结的设计模式 PDF 火了，完整版开放下载！</strong></a></p><section class=""><mp-common-profile class="js_uneditable js_wx_tap_highlight" data-pluginname="mpprofile" data-id="MzA4NzQ0Njc4Ng==" data-headimg="http://mmbiz.qpic.cn/mmbiz_png/obDoO79MTFFj7yxAU4nibk9t37xxUNx4PRy8QKpqibgry1mqiaYu5NLaoAibgHHkCtrKvgoEu6xz63UNQRAGBxF2Mg/0?wx_fmt=png" data-nickname="我是程序汪" data-alias="woshichengxuwang" data-signature="深耕IT咨询，10年开发老兵帮你少走弯路，分享我的工作和接私活经验，更关注底层码农 转行、培训、自学的小白程序员" data-from="2" data-is_biz_ban="0" has-insert-preloading="1" data-index="0" data-origin_num="202" data-isban="0"></mp-common-profile></section></section></pre><p data-tool="mdnice编辑器"><span>欢迎添加程序汪个人微信 itwang009  进粉丝群或围观朋友圈</span></p></pre>

![](/FILES/image/ccd927c3.gif)​
