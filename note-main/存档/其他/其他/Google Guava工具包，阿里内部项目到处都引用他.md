---

* [http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&amp;mid=2247505336&amp;idx=1&amp;sn=3712b0ec5c1b5d285c499c98e873cffb&amp;chksm=903bd1d5a74c58c3dbbb2e95cca200509c9640c8659c6f7360d9d7c436f8d9341ecc466e01e1&amp;mpshare=1&amp;scene=1&amp;srcid=1019m9KgOve88m0okhK6nNVI&amp;sharer_sharetime=1666178048753&amp;sharer_shareid=11c46305be36f8c23bd557e8c7bec8c9#rd - 微信公众平台](http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&mid=2247505336&idx=1&sn=3712b0ec5c1b5d285c499c98e873cffb&chksm=903bd1d5a74c58c3dbbb2e95cca200509c9640c8659c6f7360d9d7c436f8d9341ecc466e01e1&mpshare=1&scene=1&srcid=1019m9KgOve88m0okhK6nNVI&sharer_sharetime=1666178048753&sharer_shareid=11c46305be36f8c23bd557e8c7bec8c9#rd)
* 、
* 2022-10-19 19:14:17

---

[来源：jianshu.com/p/97778b21bd00](https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247487551&idx=1&sn=18f64ba49f3f0f9d8be9d1fdef8857d9&scene=21#wechat_redirect)

-   [以面向对象思想处理字符串:Joiner/Splitter/CharMatcher](https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247487551&idx=1&sn=18f64ba49f3f0f9d8be9d1fdef8857d9&chksm=fa496f8ecd3ee698f4954c00efb80fe955ec9198fff3ef4011e331aa37f55a6a17bc8c0335a8&scene=21&token=899450012&lang=zh_CN#wechat_redirect)
-   [对基本类型进行支持](https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247487551&idx=1&sn=18f64ba49f3f0f9d8be9d1fdef8857d9&chksm=fa496f8ecd3ee698f4954c00efb80fe955ec9198fff3ef4011e331aa37f55a6a17bc8c0335a8&scene=21&token=899450012&lang=zh_CN#wechat_redirect)
-   [对 JDK 集合的有效补充](https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247487551&idx=1&sn=18f64ba49f3f0f9d8be9d1fdef8857d9&chksm=fa496f8ecd3ee698f4954c00efb80fe955ec9198fff3ef4011e331aa37f55a6a17bc8c0335a8&scene=21&token=899450012&lang=zh_CN#wechat_redirect)
-   [函数式编程：Functions](https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247487551&idx=1&sn=18f64ba49f3f0f9d8be9d1fdef8857d9&chksm=fa496f8ecd3ee698f4954c00efb80fe955ec9198fff3ef4011e331aa37f55a6a17bc8c0335a8&scene=21&token=899450012&lang=zh_CN#wechat_redirect)
-   [断言：Predicate](https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247487551&idx=1&sn=18f64ba49f3f0f9d8be9d1fdef8857d9&chksm=fa496f8ecd3ee698f4954c00efb80fe955ec9198fff3ef4011e331aa37f55a6a17bc8c0335a8&scene=21&token=899450012&lang=zh_CN#wechat_redirect)
-   [check null and other：Optional、Preconditions](https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247487551&idx=1&sn=18f64ba49f3f0f9d8be9d1fdef8857d9&chksm=fa496f8ecd3ee698f4954c00efb80fe955ec9198fff3ef4011e331aa37f55a6a17bc8c0335a8&scene=21&token=899450012&lang=zh_CN#wechat_redirect)
-   [Cache is king](https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247487551&idx=1&sn=18f64ba49f3f0f9d8be9d1fdef8857d9&chksm=fa496f8ecd3ee698f4954c00efb80fe955ec9198fff3ef4011e331aa37f55a6a17bc8c0335a8&scene=21&token=899450012&lang=zh_CN#wechat_redirect)
-   [让异步回调更加简单](https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247487551&idx=1&sn=18f64ba49f3f0f9d8be9d1fdef8857d9&chksm=fa496f8ecd3ee698f4954c00efb80fe955ec9198fff3ef4011e331aa37f55a6a17bc8c0335a8&scene=21&token=899450012&lang=zh_CN#wechat_redirect)
-   [Summary](https://mp.weixin.qq.com/s?__biz=MzUzMTA2NTU2Ng==&mid=2247487551&idx=1&sn=18f64ba49f3f0f9d8be9d1fdef8857d9&chksm=fa496f8ecd3ee698f4954c00efb80fe955ec9198fff3ef4011e331aa37f55a6a17bc8c0335a8&scene=21&token=899450012&lang=zh_CN#wechat_redirect)

## **前言**

阿里巴巴的项目中经常会引用 Google Guava 工具包（接触过阿里项目的人都懂），因为实在太好用了，大家不用自己重复造轮子，谷歌大神们已经造好了。

目前 Google Guava 在实际应用中非常广泛，本篇博客将以博主对 Guava 使用的认识以及在项目中的经验来给大家分享！学习使用 Google Guava 可以让你快乐编程，写出优雅的 JAVA 代码！

## **面向对象思想处理字符串**

## **Joiner/Splitter/CharMatcher**

JDK 提供的 String 还不够好么？

也许还不够友好，至少让我们用起来还不够爽，还得操心！

> 举个栗子，比如 String 提供的 split 方法，我们得关心空字符串吧，还得考虑返回的结果中存在 null 元素吧，只提供了前后 trim 的方法（如果我想对中间元素进行 trim 呢）。

**1）Joiner/Splitter**

那么，看下面的代码示例，guava 让你不必在操心这些：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-109b1329.jpeg)​

Joiner 是连接器，Splitter 是分割器，通常我们会把它们定义为 static final，利用 on 生成对象后在应用到 String 进行处理，这是可以复用的。要知道 apache commons StringUtils 提供的都是 static method。

更加重要的是，guava 提供的 Joiner/Splitter 是经过充分测试，它的稳定性和效率要比 apache 高出不少，这个你可以自行测试下~

发现没有我们想对 String 做什么操作，就是生成自己定制化的 Joiner/Splitter，多么直白，简单，流畅的 API！

**对于 Joiner，常用的方法是跳过 NULL 元素：**

skipNulls() / 对于 NULL 元素使用其他替代：useForNull(String)

**对于 Splitter，常用的方法是：**

trimResults()/omitEmptyStrings()。注意拆分的方式，有字符串，还有正则，还有固定长度分割（太贴心了！）

**2）CharMatcher**

其实除了 Joiner/Splitter 外，guava 还提供了字符串匹配器：CharMatcher

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-cd3e65ca.jpeg)​

## CharMatcher，将字符的匹配和处理解耦，并提供丰富的方法供你使用！

## **对基本类型进行支持**

guava 对 JDK 提供的原生类型操作进行了扩展，使得功能更加强大！

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1d313824.jpeg)​

google guava 中提供了

Bytes/Shorts/Ints/Iongs/Floats/Doubles/Chars/Booleans 这些基本数据类型的扩展支持，只有你想不到的，没有它没有的！

## **JDK 集合的有效补充**

## **灰色地带:Multiset**

JDK 的集合，提供了有序且可以重复的 List，无序且不可以重复的 Set。那这里其实对于集合涉及到了 2 个概念，一个 order，一个 dups。那么 List vs Set，and then some ?

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-d965b2bd.jpeg)​

Multiset 是什么，我想上面的图，你应该了解它的概念了。Multiset 就是无序的，但是可以重复的集合，它就是游离在 List/Set 之间的“灰色地带”！（至于有序的，不允许重复的集合嘛，guava 还没有提供，当然在未来应该会提供 UniqueList，我猜的，哈哈）

来看一个 Multiset 的示例：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-254be046.jpeg)​

## Multiset 自带一个有用的功能，就是可以跟踪每个对象的数量。

## **Immutable vs unmodifiable**

来我们先看一个 unmodifiable 的例子：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-886e2901.jpeg)​

你看到 JDK 提供的 unmodifiable 的缺陷了吗？

实际上，Collections.unmodifiableXxx 所返回的集合和源集合是同一个对象，只不过可以对集合做出改变的 API 都被 override，会抛出 UnsupportedOperationException。

也即是说我们改变源集合，导致不可变视图（unmodifiable View）也会发生变化，oh my god!

当然，在不使用 guava 的情况下，我们是怎么避免上面的问题的呢？

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-69a7f179.jpeg)​

上面揭示了一个概念：Defensive Copies，保护性拷贝。

OK，unmodifiable 看上去没有问题呢，但是 guava 依然觉得可以改进，于是提出了 Immutable 的概念，来看：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-8f064691.jpeg)​

就一个 copyOf，你不会忘记，如此 cheap~

用 Google 官方的说法是：**we&apos;re using just one class,just say exactly what we mean**，很了不起吗（不仅仅是个概念，Immutable 在 COPY 阶段还考虑了线程的并发性等，很智能的！），O(∩_∩)O 哈哈~

> guava 提供了很多 Immutable 集合，比如
>
> ImmutableList/ImmutableSet/ImmutableSortedSet/ImmutableMap/…

看一个 ImmutableMap 的例子：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-50d14b60.jpeg)​

## **可不可以一对多：Multimap**

JDK 提供给我们的 Map 是一个键，一个值，一对一的，那么在实际开发中，显然存在一个 KEY 多个 VALUE 的情况（比如一个分类下的书本），我们往往这样表达：Map<k,List<v>>，好像有点臃肿！臃肿也就算了，更加不爽的事，我们还得判断 KEY 是否存在来决定是否 new 一个 LIST 出来，有点麻烦！更加麻烦的事情还在后头，比如遍历，比如删除，so hard......

来看 guava 如何替你解决这个大麻烦的：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-e8446a2f.jpeg)​

**友情提示下，guava 所有的集合都有 create 方法**，这样的好处在于简单，而且我们不必在重复泛型信息了。

get()/keys()/keySet()/values()/entries()/asMap()都是非常有用的返回 view collection 的方法。

> Multimap 的实现类有：  
> ArrayListMultimap/HashMultimap/LinkedHashMultimap/TreeMultimap/ImmutableMultimap/…

## **可不可以双向：BiMap**

JDK 提供的 MAP 让我们可以 find value by key，那么能不能通过 find key by value 呢，能不能 KEY 和 VALUE 都是唯一的呢。这是一个双向的概念，即 forward+backward。

在实际场景中有这样的需求吗？比如通过用户 ID 找到 mail，也需要通过 mail 找回用户名。没有 guava 的时候，我们需要 create forward map AND create backward map，and now just let guava do that for you.

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-e65edf61.jpeg)​

**biMap/biMap.inverse()/biMap.inverse().inverse()它们是什么关系呢？**

你可以稍微看一下 BiMap 的源码实现，实际上，当你创建 BiMap 的时候，在内部维护了 2 个 map，一个 forward map，一个 backward map，并且设置了它们之间的关系。因此，biMap.inverse() != biMap ；biMap.inverse().inverse() == biMap

## **可不可以多个 KEY：Table**

我们知道数据库除了主键外，还提供了复合索引，而且实际中这样的多级关系查找也是比较多的，当然我们可以利用嵌套的 Map 来实现：Map<k1,Map<k2,v2>>。为了让我们的代码看起来不那么丑陋，guava 为我们提供了 Table。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-be05d5b6.jpeg)​

Table 涉及到 3 个概念：**rowKey，columnKey，value**，并提供了多种视图以及操作方法让你更加轻松的处理多个 KEY 的场景。

## **函数式编程：Functions**

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-b9b1bd9d.jpeg)​

对集合的 transform 操作可以通过 Function 完成。

上面的代码是为了完成将 List 集合中的元素，先截取 5 个长度，然后转成大写。

函数式编程的好处在于在集合遍历操作中提供自定义 Function 的操作，比如 transform 转换。我们再也不需要一遍遍的遍历集合，显著的简化了代码！

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-f057a6af.jpeg)​

## **断言：Predicate**

## ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-b726047c.jpeg)​

Predicate 最常用的功能就是运用在集合的过滤当中！

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-5d108023.jpeg)​

需要注意的是 Lists 并没有提供 filter 方法，不过你可以使用 Collections2.filter 完成！

## **check null and other**

在 guava 中，对于 null 的处理手段是快速失败，你可以看看 guava 的源码，很多方法的第一行就是：`Preconditions.checkNotNull(elements);`​

要知道 null 是模糊的概念，是成功呢，还是失败呢，还是别的什么含义呢？

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-ab9e5b6d.jpeg)​

## **Cache is king**

对于大多数互联网项目而言，缓存的重要性，不言而喻！

如果我们的应用系统，并不想使用一些第三方缓存组件（如 redis），我们仅仅想在本地有一个功能足够强大的缓存，很可惜 JDK 提供的那些 SET/MAP 还不行！

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-3ba8442a.jpeg)​

**首先，这是一个本地缓存，guava 提供的 cache 是一个简洁、高效，易于维护的。为什么这么说呢？**

因为并没有一个单独的线程用于刷新 OR 清理 cache，对于 cache 的操作，都是通过访问/读写带来的，也就是说在读写中完成缓存的刷新操作！

其次，我们看到了，我们非常通俗的告诉 cache，我们的缓存策略是什么，SO EASY！在如此简单的背后，是 guava 帮助我们做了很多事情，比如线程安全。

## **让异步回调更加简单**

JDK 中提供了 Future/FutureTask/Callable 来对异步回调进行支持，但是还是看上去挺复杂的，能不能更加简单呢？比如注册一个监听回调。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-15f1a02d.jpeg)​

## 我们可以通过 guava 对 JDK 提供的线程池进行装饰，让其具有异步回调监听功能，然后在设置监听器即可！

## **Summary**

到这里，这篇文章也只介绍了 guava 的冰山一角，其实还有很多内容：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-6e9e0cb4.jpeg)​

比如反射、注解、网络、并发、IO 等等。

作者：张丰哲  
www.jianshu.com/p/97778b21bd00

<pre><pre><section data-tool="mdnice编辑器" data-website="https://www.mdnice.com"><h2 data-tool="mdnice编辑器"><span>程序汪资料链接</span></h2></section><section data-recommend-title="t" data-recommend-content="t" data-mid=""><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&mid=2247501524&idx=1&sn=2cb28e7b64ab77c55bcc1a172b82a2ad&chksm=903bc2b9a74c4baf5737cd430560ee3c5a357bb37864257a05a72e3cccf41db5bd221ccc63d8&scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click">程序汪接的7个私活都在这里，经验整理</a></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=Mzg2ODU0NTA2Mw==&mid=2247488419&idx=2&sn=0b80c7f9f73fca89b91e257a269cfada&chksm=ceabf4ebf9dc7dfdaa605a9bb92d31c9fc0a10a7a94351234181a89ba5800672c6e7da2ebfbe&scene=21#wechat_redirect" textvalue="Java项目分享  最新整理全集，找项目不累啦 07版" linktype="text" imgurl="" imgdata="null" data-itemshowtype="0" tab="innerlink" data-linktype="2" wah-hotarea="click" hasload="1"><span><strong>Java项目分享  最新整理全集，找项目不累啦 07版</strong><strong></strong></span></a><br/></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&mid=2247494170&idx=1&sn=5181a5277946be31478b1b9425c93f63&chksm=903bee77a74c67614b2772248e8b5e912d323bfe42a0e576dd157a4752f5fed88d6b439ec52f&scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click"><strong>堪称神级的Spring Boot手册，从基础入门到实战进阶</strong></a></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&mid=2247492941&idx=1&sn=2ff31fec735d7c5d6f3483c346d5ca69&chksm=903be120a74c68361fd9afad178e7338315041a2cd4459f2165a8faa20e995a3477af3eda2bb&scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click"><strong>卧槽！字节跳动《算法中文手册》火了，完整版 PDF 开放下载！</strong></a></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&mid=2247496297&idx=2&sn=d253dda2160821262d9f6fc1a9a637d0&chksm=903bf604a74c7f126ab936e374a1f22b9b7cb26a7964b6cc837c3f73af516139064e522a1294&scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click"><strong>卧槽！阿里大佬总结的《图解Java》火了，完整版PDF开放下载！</strong></a></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&mid=2247490715&idx=2&sn=7f2c5de11bebaecfbaf1ce4b945a4d6f&chksm=903818f6a74f91e0fde557b75bd44adfd5d378612f682aa3eef6766927aebb9e5afc72c91a9e&scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click"><strong>字节跳动总结的设计模式 PDF 火了，完整版开放下载！</strong></a></p><section class=""><mp-common-profile class="js_uneditable js_wx_tap_highlight" data-pluginname="mpprofile" data-id="MzA4NzQ0Njc4Ng==" data-headimg="http://mmbiz.qpic.cn/mmbiz_png/obDoO79MTFFj7yxAU4nibk9t37xxUNx4PRy8QKpqibgry1mqiaYu5NLaoAibgHHkCtrKvgoEu6xz63UNQRAGBxF2Mg/0?wx_fmt=png" data-nickname="我是程序汪" data-alias="woshichengxuwang" data-signature="深耕IT咨询，10年开发老兵帮你少走弯路，分享我的工作和接私活经验，更关注底层码农 转行、培训、自学的小白程序员" data-from="2" data-is_biz_ban="0" has-insert-preloading="1" data-index="1" data-origin_num="202" data-isban="0"></mp-common-profile></section></section></pre><p data-tool="mdnice编辑器"><span>欢迎添加程序汪个人微信 itwang009  进粉丝群或围观朋友圈</span></p></pre>

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-ccd927c3.gif)​
