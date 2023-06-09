---

* [http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&amp;mid=2247505352&amp;idx=2&amp;sn=a8cd87f1e85799499f7478b706b84d17&amp;chksm=903bd1a5a74c58b33310204af85894ca7d18466bae904888516d6be114bcc656a27177a98b38&amp;mpshare=1&amp;scene=1&amp;srcid=10201cmozTSNgqkya892hE3q&amp;sharer_sharetime=1666273757254&amp;sharer_shareid=11c46305be36f8c23bd557e8c7bec8c9#rd - 微信公众平台](http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&mid=2247505352&idx=2&sn=a8cd87f1e85799499f7478b706b84d17&chksm=903bd1a5a74c58b33310204af85894ca7d18466bae904888516d6be114bcc656a27177a98b38&mpshare=1&scene=1&srcid=10201cmozTSNgqkya892hE3q&sharer_sharetime=1666273757254&sharer_shareid=11c46305be36f8c23bd557e8c7bec8c9#rd)
* 2022-10-20 21:49:30

---

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-0247f891.jpeg)​

TCP 协议是大厂面试必问的知识点。今天这篇文章整理了 15 道非常经典的 TCP 面试题，非常清晰易懂并且也比较全面，希望能对大家有所帮助。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-59c1150a.png)​

### 1. 讲下 TCP 三次握手流程

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-61bb1a07.png)​

开始客户端和服务器都处于 CLOSED 状态，然后服务端开始监听某个端口，进入 LISTEN 状态

-   第一次握手(SYN=1, seq=x)，发送完毕后，客户端进入 SYN_SEND 状态
-   第二次握手(SYN=1, ACK=1, seq=y, ACKnum=x+1)， 发送完毕后，服务器端进入 SYN_RCVD 状态。
-   第三次握手(ACK=1，ACKnum=y+1)，发送完毕后，客户端进入 ESTABLISHED 状态，当服务器端接收到这个包时,也进入 ESTABLISHED 状态，TCP 握手，即可以开始数据传输。

### 2.TCP 握手为什么是三次，不能是两次？不能是四次？

TCP 握手为什么是三次呢？为了方便理解，我们以谈恋爱为例子：两个人能走到一起，最重要的事情就是相爱，就是 **我爱你，并且我知道，你也爱我** ，接下来我们以此来模拟三次握手的过程：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-c200825e.png)​

**为什么握手不能是两次呢？**

如果只有两次握手，女孩子可能就不知道，她的那句 **我也爱你** ，男孩子是否 **收到** ，恋爱关系就不能愉快展开。

**为什么握手不能是四次呢？**

因为握手不能是四次呢？因为三次已经够了，三次已经能让双方都知道：你爱我，我也爱你。而四次就多余了。

### 3. 讲下 TCP 四次挥手过程

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-994da078.png)​

1. 第一次挥手(FIN=1，seq=u)，发送完毕后，客户端进入 FIN_WAIT_1 状态
2. 第二次挥手(ACK=1，ack=u+1,seq =v)，发送完毕后，服务器端进入 CLOSE_WAIT 状态，客户端接收到这个确认包之后，进入 FIN_WAIT_2 状态
3. 第三次挥手(FIN=1，ACK1,seq=w,ack=u+1)，发送完毕后，服务器端进入 LAST_ACK 状态，等待来自客户端的最后一个 ACK。
4. 第四次挥手(ACK=1，seq=u+1,ack=w+1)，客户端接收到来自服务器端的关闭请求，发送一个确认包，并进入 TIME_WAIT 状态， **等待了某个固定时间（两个最大段生命周期，2MSL，2 Maximum Segment Lifetime）之后** ，没有收到服务器端的 ACK ，认为服务器端已经正常关闭连接，于是自己也关闭连接，进入 CLOSED 状态。服务器端接收到这个确认包之后，关闭连接，进入 CLOSED 状态。

### 4. TCP 挥手为什么需要四次呢？

举个例子吧!

> ★ 小明和小红打电话聊天，通话差不多要结束时，小红说“我没啥要说的了”，小明回答“我知道了”。但是小明可能还会有要说的话，小红不能要求小明跟着自己的节奏结束通话，于是小明可能又叽叽歪歪说了一通，最后小明说“我说完了”，小红回答“知道了”，这样通话才算结束。
>
> ”

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-46274e2f.png)​

### 5. TIME-WAIT 状态为什么需要等待 2MSL

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-f4242713.png)​

2MSL，2 Maximum Segment Lifetime，即两个最大段生命周期

> ★\* 1 个 MSL 保证四次挥手中主动关闭方最后的 ACK 报文能最终到达对端
>
> -   1 个 MSL 保证对端没有收到 ACK 那么进行重传的 FIN 报文能够到达
>
> ”

### 6.TCP 和 UDP 的区别

1. TCP 面向连接（（如打电话要先拨号建立连接）;UDP 是无连接的，即发送数据之前不需要建立连接。
2. TCP 要求安全性，提供可靠的服务，通过 TCP 连接传送的数据，不丢失、不重复、安全可靠。而 UDP 尽最大努力交付，即不保证可靠交付。
3. TCP 是点对点连接的，UDP 一对一，一对多，多对多都可以
4. TCP 传输效率相对较低,而 UDP 传输效率高，它适用于对高速传输和实时性有较高的通信或广播通信。
5. TCP 适合用于网页，邮件等;UDP 适合用于视频，语音广播等
6. TCP 面向字节流，UDP 面向报文

### 7. TCP 报文首部有哪些字段，说说其作用

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-ed7d0f01.png)​

-   **16 位端口号** ：源端口号，主机该报文段是来自哪里；目标端口号，要传给哪个上层协议或应用程序
-   **32 位序号** ：一次 TCP 通信（从 TCP 连接建立到断开）过程中某一个传输方向上的字节流的每个字节的编号。
-   **32 位确认号** ：用作对另一方发送的 tcp 报文段的响应。其值是收到的 TCP 报文段的序号值加 1。
-   **4 位头部长度** ：表示 tcp 头部有多少个 32bit 字（4 字节）。因为 4 位最大能标识 15，所以 TCP 头部最长是 60 字节。
-   **6 位标志位** ：URG(紧急指针是否有效)，ACk（表示确认号是否有效），PSH（缓冲区尚未填满），RST（表示要求对方重新建立连接），SYN（建立连接消息标志接），FIN（表示告知对方本端要关闭连接了）
-   **16 位窗口大小** ：是 TCP 流量控制的一个手段。这里说的窗口，指的是接收通告窗口。它告诉对方本端的 TCP 接收缓冲区还能容纳多少字节的数据，这样对方就可以控制发送数据的速度。
-   **16 位校验和** ：由发送端填充，接收端对 TCP 报文段执行 CRC 算法以检验 TCP 报文段在传输过程中是否损坏。注意，这个校验不仅包括 TCP 头部，也包括数据部分。这也是 TCP 可靠传输的一个重要保障。
-   **16 位紧急指针** ：一个正的偏移量。它和序号字段的值相加表示最后一个紧急数据的下一字节的序号。因此，确切地说，这个字段是紧急指针相对当前序号的偏移，不妨称之为紧急偏移。TCP 的紧急指针是发送端向接收端发送紧急数据的方法。

### 8. TCP 是如何保证可靠性的

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-adc29d3e.png)​

-   首先，TCP 的连接是基于 **三次握手** ，而断开则是 **四次挥手** 。确保连接和断开的可靠性。
-   其次，TCP 的可靠性，还体现在 **有状态** ;TCP 会记录哪些数据发送了，哪些数据被接受了，哪些没有被接受，并且保证数据包按序到达，保证数据传输不出差错。
-   再次，TCP 的可靠性，还体现在 **可控制** 。它有报文校验、ACK 应答、 **超时重传(发送方)** 、失序数据重传（接收方）、丢弃重复数据、流量控制（滑动窗口）和拥塞控制等机制。

### 9. TCP 重传机制

#### 超时重传

TCP 为了实现可靠传输，实现了重传机制。最基本的重传机制，就是 **超时重传** ，即在发送数据报文时，设定一个定时器，每间隔一段时间，没有收到对方的 ACK 确认应答报文，就会重发该报文。

这个间隔时间，一般设置为多少呢？我们先来看下什么叫 **RTT（Round-Trip Time，往返时间）** 。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-dddf931f.png)​

RTT 就是，一个数据包从发出去到回来的时间，即 **数据包的一次往返时间** 。超时重传时间，就是 Retransmission Timeout ，简称 **RTO** 。

**RTO 设置多久呢？**

-   如果 RTO 比较小，那很可能数据都没有丢失，就重发了，这会导致网络阻塞，会导致更多的超时出现。
-   如果 RTO 比较大，等到花儿都谢了还是没有重发，那效果就不好了。

一般情况下，RTO 略大于 RTT，效果是最好的。一些小伙伴会问，超时时间有没有计算公式呢?有的！有个标准方法算 RTO 的公式，也叫 **Jacobson / Karels 算法** 。我们一起来看下计算 RTO 的公式

**1. 先计算 SRTT（计算平滑的 RTT）**

```
SRTT = (1 - α) * SRTT + α * RTT  //求 SRTT 的加权平均
```

**2. 再计算 RTTVAR (round-trip time variation)**

```
RTTVAR = (1 - β) * RTTVAR + β * (|RTT - SRTT|) //计算 SRTT 与真实值的差距
```

**3. 最终的 RTO**

```
RTO = µ * SRTT + ∂ * RTTVAR  =  SRTT + 4·RTTVAR  
```

其中，`α = 0.125，β = 0.25， μ = 1，∂ = 4`​，这些参数都是大量结果得出的最优参数。

但是，超时重传会有这些缺点：

> ★\* 当一个报文段丢失时，会等待一定的超时周期然后才重传分组，增加了端到端的时延。
>
> -   当一个报文段丢失时，在其等待超时的过程中，可能会出现这种情况：其后的报文段已经被接收端接收但却迟迟得不到确认，发送端会认为也丢失了，从而引起不必要的重传，既浪费资源也浪费时间。
>
> ”

并且，TCP 有个策略，就是超时时间间隔会加倍。超时重传需要 **等待很长时间** 。因此，还可以使用**快速重传** 机制。

#### 快速重传

**快速重传** 机制，它不以时间驱动，而是以数据驱动。它基于接收端的反馈信息来引发重传。

一起来看下快速重传流程：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-eb5c9061.png)  
快速重传流程

发送端发送了 1，2，3，4，5,6 份数据:

-   第一份 Seq=1 先送到了，于是就 Ack 回 2；
-   第二份 Seq=2 也送到了，假设也正常，于是 ACK 回 3；
-   第三份 Seq=3 由于网络等其他原因，没送到；
-   第四份 Seq=4 也送到了，但是因为 Seq3 没收到。所以 ACK 回 3；
-   后面的 Seq=4,5 的也送到了，但是 ACK 还是回复 3，因为 Seq=3 没收到。
-   发送端连着收到三个重复冗余 ACK=3 的确认（实际上是 4 个，但是前面一个是正常的 ACK，后面三个才是重复冗余的），便知道哪个报文段在传输过程中丢失了，于是在定时器过期之前，重传该报文段。
-   最后，接收到收到了 Seq3，此时因为 Seq=4，5，6 都收到了，于是 ACK 回 7.

但**快速重传** 还可能会有个问题：ACK 只向发送端告知最大的有序报文段，到底是哪个报文丢失了呢？ **并不确定** ！那到底该重传多少个包呢？

> ★ 是重传 Seq3 呢？还是重传 Seq3、Seq4、Seq5、Seq6 呢？因为发送端并不清楚这三个连续的 ACK3 是谁传回来的。
>
> ”

#### 带选择确认的重传（SACK）

为了解决快速重传的问题： **应该重传多少个包** ? TCP 提供了 **SACK 方法** （带选择确认的重传，Selective Acknowledgment）。

**SACK 机制**就是，在快速重传的基础上，接收端返回最近收到的报文段的序列号范围，这样发送端就知道接收端哪些数据包没收到，酱紫就很清楚该重传哪些数据包啦。SACK 标记是加在 TCP 头部**选项**字段里面的。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-2a5a1668.png)  
SACK 机制

如上图中，发送端收到了三次同样的 ACK=30 的确认报文，于是就会触发快速重发机制，通过 SACK 信息发现只有`30~39`​ 这段数据丢失，于是重发时就只选择了这个`30~39`​ 的 TCP 报文段进行重发。

#### D-SACK

D-SACK，即 Duplicate SACK（重复 SACK），在 SACK 的基础上做了一些扩展，，主要用来告诉发送方，有哪些数据包自己重复接受了。DSACK 的目的是帮助发送方判断，是否发生了包失序、ACK 丢失、包重复或伪重传。让 TCP 可以更好的做网络流控。来看个图吧：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-c6c97cde.png)  
D-SACK 简要流程

### 10. 聊聊 TCP 的滑动窗口

TCP 发送一个数据，需要收到确认应答，才会发送下一个数据。这样有个缺点，就是效率会比较低。

> ★ 这就好像我们面对面聊天，你说完一句，我应答后，你才会说下一句。那么，如果我在忙其他事情，没有能够及时回复你。你说完一句后，要等到我忙完回复你，你才说下句，这显然很不现实。
>
> ”

为了解决这个问题，TCP 引入了 **窗口** ，它是操作系统开辟的一个缓存空间。窗口大小值表示无需等待确认应答，而可以继续发送数据的最大值。

TCP 头部有个字段叫 win，也即那个 **16 位的窗口大小** ，它告诉对方本端的 TCP 接收缓冲区还能容纳多少字节的数据，这样对方就可以控制发送数据的速度，从而达到**流量控制**的目的。

> ★ 通俗点讲，就是接受方每次收到数据包，在发送确认报文的时候，同时告诉发送方，自己的缓存区还有多少空余空间，缓冲区的空余空间，我们就称之为接受窗口大小。这就是 win。
>
> ”

TCP 滑动窗口分为两种: 发送窗口和接收窗口。**发送端的滑动窗口**包含四大部分，如下：

-   已发送且已收到 ACK 确认
-   已发送但未收到 ACK 确认
-   未发送但可以发送
-   未发送也不可以发送

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1963cac9.png)​

-   虚线矩形框，就是发送窗口。
-   SND.WND: 表示发送窗口的大小,上图虚线框的格子数就是 14 个。
-   SND.UNA: 一个绝对指针，它指向的是已发送但未确认的第一个字节的序列号。
-   SND.NXT：下一个发送的位置，它指向未发送但可以发送的第一个字节的序列号。

接收方的滑动窗口包含三大部分，如下：

-   已成功接收并确认
-   未收到数据但可以接收
-   未收到数据并不可以接收的数据

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-eb820479.png)​

-   虚线矩形框，就是接收窗口。
-   REV.WND: 表示接收窗口的大小,上图虚线框的格子就是 9 个。
-   REV.NXT:下一个接收的位置，它指向未收到但可以接收的第一个字节的序列号。

### 11. 聊聊 TCP 的流量控制

TCP 三次握手，发送端和接收端进入到 ESTABLISHED 状态，它们即可以愉快地传输数据啦。

但是发送端不能疯狂地向接收端发送数据，因为接收端接收不过来的话，接收方只能把处理不过来的数据存在缓存区里。如果缓存区都满了，发送方还在疯狂发送数据的话，接收方只能把收到的数据包丢掉，这就浪费了网络资源啦。

> ★TCP 提供一种机制可以让发送端根据接收端的实际接收能力控制发送的数据量，这就是 **流量控制** 。
>
> ”

TCP 通过滑动窗口来控制流量，我们看下流量控制的**简要流程**吧：

首先双方三次握手，初始化各自的窗口大小，均为 400 个字节。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-09662753.png)  
TCP 的流量控制

1. 假如当前发送方给接收方发送了 200 个字节，那么，发送方的`SND.NXT`​ 会右移 200 个字节，也就是说当前的可用窗口减少了 200 个字节。
2. 接受方收到后，放到缓冲队列里面，REV.WND =400-200=200 字节，所以 win=200 字节返回给发送方。接收方会在 ACK 的报文首部带上缩小后的滑动窗口 200 字节
3. 发送方又发送 200 字节过来，200 字节到达，继续放到缓冲队列。不过这时候，由于大量负载的原因，接受方处理不了这么多字节，只能处理 100 字节，剩余的 100 字节继续放到缓冲队列。这时候，REV.WND = 400-200-100=100 字节，即 win=100 返回发送方。
4. 发送方继续干活，发送 100 字节过来，这时候，接受窗口 win 变为 0。
5. 发送方停止发送，开启一个定时任务，每隔一段时间，就去询问接受方，直到 win 大于 0，才继续开始发送。

### 12. TCP 的拥塞控制

拥塞控制是 **作用于网络的，防止过多的数据包注入到网络中，避免出现网络负载过大的情况** 。它的目标主要是最大化利用网络上瓶颈链路的带宽。它跟**流量控制**又有什么区别呢？流量控制是作用于接收者的，根据 **接收端的实际接收能力控制发送速度** ，防止分组丢失的。

我们可以把网络链路比喻成一根水管，如果我们想最大化利用网络来传输数据，那就是尽快让水管达到最佳充满状态。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-9f648619.png)​

发送方维护一个**拥塞窗口 cwnd（congestion window）** 的变量，用来估算在一段时间内这条链路（水管）可以承载和运输的数据（水）的数量。它大小代表着网络的拥塞程度，并且是动态变化的，但是为了达到最大的传输效率，我们该如何知道这条水管的运送效率是多少呢？

一个比较简单的方法就是不断增加传输的水量，直到水管快要爆裂为止（对应到网络上就是发生丢包），用 TCP 的描述就是：

> ★ 只要网络中没有出现拥塞，拥塞窗口的值就可以再增大一些，以便把更多的数据包发送出去，但只要网络出现拥塞，拥塞窗口的值就应该减小一些，以减少注入到网络中的数据包数。
>
> ”

实际上，拥塞控制主要有这几种常用算法

-   慢启动
-   拥塞避免
-   拥塞发生
-   快速恢复

#### 慢启动算法

慢启动算法，表面意思就是，别急慢慢来。它表示 TCP 建立连接完成后，一开始不要发送大量的数据，而是先探测一下网络的拥塞程度。由小到大逐渐增加拥塞窗口的大小，如果没有出现丢包， **每收到一个 ACK，就将拥塞窗口 cwnd 大小就加 1（单位是 MSS）** 。**每轮次**发送窗口增加一倍，呈指数增长，如果出现丢包，拥塞窗口就减半，进入拥塞避免阶段。

-   TCP 连接完成，初始化 cwnd = 1，表明可以传一个 MSS 单位大小的数据。
-   每当收到一个 ACK，cwnd 就加一;
-   每当过了一个 RTT，cwnd 就增加一倍; 呈指数让升

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-88be7f12.png)​

为了防止 cwnd 增长过大引起网络拥塞，还需设置一个 **慢启动阀值 ssthresh** （slow start threshold）状态变量。当`cwnd`​ 到达该阀值后，就好像水管被关小了水龙头一样，减少拥塞状态。即当**cwnd &gt;ssthresh**时，进入了**拥塞避免**算法。

#### 拥塞避免算法

一般来说，慢启动阀值 ssthresh 是 65535 字节，`cwnd`​ 到达**慢启动阀值**后

-   每收到一个 ACK 时，cwnd = cwnd + 1/cwnd
-   当每过一个 RTT 时，cwnd = cwnd + 1

显然这是一个线性上升的算法，避免过快导致网络拥塞问题。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-5ef5e455.png)​

#### 拥塞发生

当网络拥塞发生**丢包**时，会有两种情况：

-   RTO 超时重传
-   快速重传

如果是发生了 **RTO 超时重传** ，就会使用拥塞发生算法

-   慢启动阀值 sshthresh = cwnd /2
-   cwnd 重置为 1
-   进入新的慢启动过程

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-bb09523b.png)​

这真的是 **辛辛苦苦几十年，一朝回到解放前** 。其实还有更好的处理方式，就是 **快速重传** 。发送方收到 3 个连续重复的 ACK 时，就会快速地重传，不必等待**RTO 超时**再重传。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-396ad937.png)  
image.png

慢启动阀值 ssthresh 和 cwnd 变化如下：

-   拥塞窗口大小 cwnd = cwnd/2
-   慢启动阀值 ssthresh = cwnd
-   进入快速恢复算法

#### 快速恢复

快速重传和快速恢复算法一般同时使用。快速恢复算法认为，还有 3 个重复 ACK 收到，说明网络也没那么糟糕，所以没有必要像 RTO 超时那么强烈。

正如前面所说，进入快速恢复之前，cwnd 和 sshthresh 已被更新：

```
- cwnd = cwnd /2
- sshthresh = cwnd
```

然后，真正的快速算法如下：

-   cwnd = sshthresh + 3
-   重传重复的那几个 ACK（即丢失的那几个数据包）
-   如果再收到重复的 ACK，那么 cwnd = cwnd +1
-   如果收到新数据的 ACK 后, cwnd = sshthresh。因为收到新数据的 ACK，表明恢复过程已经结束，可以再次进入了拥塞避免的算法了。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-795b7c8b.png)​

### 13. 半连接队列和 SYN Flood 攻击的关系

TCP 进入三次握手前，服务端会从**CLOSED**状态变为**LISTEN**状态,同时在内部创建了两个队列：半连接队列（SYN 队列）和全连接队列（ACCEPT 队列）。

什么是**半连接队列（SYN 队列）** 呢? 什么是 **全连接队列（ACCEPT 队列）** 呢？回忆下 TCP 三次握手的图：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-6af881da.png)  
三次握手

-   TCP 三次握手时，客户端发送 SYN 到服务端，服务端收到之后，便回复 **ACK 和 SYN** ，状态由 **LISTEN 变为 SYN_RCVD** ，此时这个连接就被推入了 **SYN 队列** ，即半连接队列。
-   当客户端回复 ACK, 服务端接收后，三次握手就完成了。这时连接会等待被具体的应用取走，在被取走之前，它被推入 ACCEPT 队列，即全连接队列。

SYN Flood 是一种典型的 DoS (Denial of Service，拒绝服务) 攻击，它在短时间内，伪造 **不存在的 IP 地址** ,向服务器大量发起 SYN 报文。当服务器回复 SYN+ACK 报文后，不会收到 ACK 回应报文，导致服务器上建立大量的半连接半连接队列满了，这就无法处理正常的 TCP 请求啦。

主要有 **syn cookie**和**SYN Proxy 防火墙**等方案应对。

-   **syn cookie** ：在收到 SYN 包后，服务器根据一定的方法，以数据包的源地址、端口等信息为参数计算出一个 cookie 值作为自己的 SYNACK 包的序列号，回复 SYN+ACK 后，服务器并不立即分配资源进行处理，等收到发送方的 ACK 包后，重新根据数据包的源地址、端口计算该包中的确认序列号是否正确，如果正确则建立连接，否则丢弃该包。
-   **SYN Proxy 防火墙** ：服务器防火墙会对收到的每一个 SYN 报文进行代理和回应，并保持半连接。等发送方将 ACK 包返回后，再重新构造 SYN 包发到服务器，建立真正的 TCP 连接。

### 14. Nagle 算法与延迟确认

#### Nagle 算法

如果发送端疯狂地向接收端发送很小的包，比如就 1 个字节，那么亲爱的小伙伴，你们觉得会有什么问题呢？

> ★TCP/IP 协议中，无论发送多少数据，总是要在数据前面加上协议头，同时，对方接收到数据，也需要发送 ACK 表示确认。为了尽可能的利用网络带宽，TCP 总是希望尽可能的发送足够大的数据。**Nagle 算法**就是为了尽可能发送大块数据，避免网络中充斥着许多小数据块。
>
> ”

Nagle 算法的基本定义是： **任意时刻，最多只能有一个未被确认的小段** 。所谓“小段”，指的是小于 MSS 尺寸的数据块，所谓“未被确认”，是指一个数据块发送出去后，没有收到对方发送的 ACK 确认该数据已收到。

Nagle 算法的实现规则：

-   如果包长度达到 MSS，则允许发送；
-   如果该包含有 FIN，则允许发送；
-   设置了 TCP_NODELAY 选项，则允许发送；
-   未设置 TCP_CORK 选项时，若所有发出去的小数据包（包长度小于 MSS）均被确认，则允许发送；
-   上述条件都未满足，但发生了超时（一般为 200ms），则立即发送。

#### 延迟确认

如果接受方刚接收到发送方的数据包，在很短很短的时间内，又接收到第二个包。那么请问接收方是一个一个地回复好点，还是合并一起回复好呢？

> ★ 接收方收到数据包后，如果暂时没有数据要发给对端，它可以等一段时再确认（Linux 上默认是 40ms）。如果这段时间刚好有数据要传给对端，ACK 就随着数据传输，而不需要单独发送一次 ACK。如果超过时间还没有数据要发送，也发送 ACK，避免对端以为丢包。
>
> ”

但是有些场景不能延迟确认，比如发现了 **乱序包** 、**接收到了大于一个 frame 的报文，且需要调整窗口大小**等。

一般情况下，**Nagle 算法和延迟确认**不能一起使用，Nagle 算法意味着延迟发，**延迟确认**意味着延迟接收，酱紫就会造成更大的延迟，会产生性能问题。

### 15. TCP 的粘包和拆包

TCP 是面向流，没有界限的一串数据。TCP 底层并不了解上层业务数据的具体含义，它会根据 TCP 缓冲区的实际情况进行包的划分，所以在业务上认为，一 **个完整的包可能会被 TCP 拆分成多个包进行发送** ， **也有可能把多个小的包封装成一个大的数据包发送** ，这就是所谓的 TCP 粘包和拆包问题。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-feeb546a.png)  
TCP 的粘包和拆包

**为什么会产生粘包和拆包呢?**

-   要发送的数据小于 TCP 发送缓冲区的大小，TCP 将多次写入缓冲区的数据一次发送出去，将会发生粘包；
-   接收数据端的应用层没有及时读取接收缓冲区中的数据，将发生粘包；
-   要发送的数据大于 TCP 发送缓冲区剩余空间大小，将会发生拆包；
-   待发送数据大于 MSS（最大报文长度），TCP 在传输前将进行拆包。即 TCP 报文长度-TCP 头部长度>MSS。

**解决方案：**

-   发送端将每个数据包封装为固定长度
-   在数据尾部增加特殊字符进行分割
-   将数据分为两部分，一部分是头部，一部分是内容体；其中头部结构大小固定，且有一个字段声明内容体的大小。

### 参考阅读

[1] TCP 的那些事儿（下）: https://coolshell.cn/articles/11609.html  
[2] 面试头条你需要懂的 TCP 拥塞控制原理: https://zhuanlan.zhihu.com/p/76023663  
[3] 30 张图解：TCP 重传、滑动窗口、流量控制、拥塞控制发愁: https://zhuanlan.zhihu.com/p/133307545  
[4] TCP 协议灵魂之问，巩固你的网路底层基础: https://juejin.cn/post/6844904070889603085  
[5] TCP 粘包和拆包: https://blog.csdn.net/ailunlee/article/details/95944377

<pre><h2><section mpa-from-tpl="t" data-id="94155"><section mpa-from-tpl="t"><img class="__bg_gif rich_pages wxw-img" data-ratio="0.9831460674157303" data-src="https://mmbiz.qpic.cn/mmbiz_gif/b96CibCt70iabwjyojLhA03PtxUnkNPREnt2F48ywfXLpDdDAjicOTPI8Q94tVLbJ58tbRs12iaXDKhUOW9gd4NlFA/640?wx_fmt=gif&amp;wxfrom=5&amp;wx_lazy=1" data-type="gif" data-w="178" data-width="100%" width="102" data-index="26" data-origin-display="block" _width="102px" src="https://mmbiz.qpic.cn/mmbiz_gif/b96CibCt70iabwjyojLhA03PtxUnkNPREnt2F48ywfXLpDdDAjicOTPI8Q94tVLbJ58tbRs12iaXDKhUOW9gd4NlFA/640?wx_fmt=gif&amp;wxfrom=5&amp;wx_lazy=1"/><span class="js_img_placeholder wx_widget_placeholder" data-src="https://mmbiz.qpic.cn/mmbiz_gif/b96CibCt70iabwjyojLhA03PtxUnkNPREnt2F48ywfXLpDdDAjicOTPI8Q94tVLbJ58tbRs12iaXDKhUOW9gd4NlFA/640?wx_fmt=gif&amp;wxfrom=5&amp;wx_lazy=1" data-index="26"><span class="weui-primary-loading"><span class=""></span></span></span></section><pre><pre><section data-tool="mdnice编辑器" data-website="https://www.mdnice.com"><h2 data-tool="mdnice编辑器"><span>程序汪资料链接</span></h2></section><section data-recommend-title="t" data-recommend-content="t" data-mid=""><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&amp;mid=2247501524&amp;idx=1&amp;sn=2cb28e7b64ab77c55bcc1a172b82a2ad&amp;chksm=903bc2b9a74c4baf5737cd430560ee3c5a357bb37864257a05a72e3cccf41db5bd221ccc63d8&amp;scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click">程序汪接的7个私活都在这里，经验整理</a></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=Mzg2ODU0NTA2Mw==&amp;mid=2247488419&amp;idx=2&amp;sn=0b80c7f9f73fca89b91e257a269cfada&amp;chksm=ceabf4ebf9dc7dfdaa605a9bb92d31c9fc0a10a7a94351234181a89ba5800672c6e7da2ebfbe&amp;scene=21#wechat_redirect" textvalue="Java项目分享  最新整理全集，找项目不累啦 07版" linktype="text" imgurl="" imgdata="null" data-itemshowtype="0" tab="innerlink" data-linktype="2" wah-hotarea="click" hasload="1"><span><strong>Java项目分享  最新整理全集，找项目不累啦 07版</strong><strong></strong></span></a><br /></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&amp;mid=2247494170&amp;idx=1&amp;sn=5181a5277946be31478b1b9425c93f63&amp;chksm=903bee77a74c67614b2772248e8b5e912d323bfe42a0e576dd157a4752f5fed88d6b439ec52f&amp;scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click"><strong>堪称神级的Spring Boot手册，从基础入门到实战进阶</strong></a></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&amp;mid=2247492941&amp;idx=1&amp;sn=2ff31fec735d7c5d6f3483c346d5ca69&amp;chksm=903be120a74c68361fd9afad178e7338315041a2cd4459f2165a8faa20e995a3477af3eda2bb&amp;scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click"><strong>卧槽！字节跳动《算法中文手册》火了，完整版 PDF 开放下载！</strong></a></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&amp;mid=2247496297&amp;idx=2&amp;sn=d253dda2160821262d9f6fc1a9a637d0&amp;chksm=903bf604a74c7f126ab936e374a1f22b9b7cb26a7964b6cc837c3f73af516139064e522a1294&amp;scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click"><strong>卧槽！阿里大佬总结的《图解Java》火了，完整版PDF开放下载！</strong></a></p><p><a target="_blank" href="http://mp.weixin.qq.com/s?__biz=MzA4NzQ0Njc4Ng==&amp;mid=2247490715&amp;idx=2&amp;sn=7f2c5de11bebaecfbaf1ce4b945a4d6f&amp;chksm=903818f6a74f91e0fde557b75bd44adfd5d378612f682aa3eef6766927aebb9e5afc72c91a9e&amp;scene=21#wechat_redirect" data-itemshowtype="0" tab="innerlink" data-linktype="2" hasload="1" wah-hotarea="click"><strong>字节跳动总结的设计模式 PDF 火了，完整版开放下载！</strong></a></p><section class=""><mp-common-profile class="js_uneditable js_wx_tap_highlight" data-pluginname="mpprofile" data-id="MzA4NzQ0Njc4Ng==" data-headimg="http://mmbiz.qpic.cn/mmbiz_png/obDoO79MTFFj7yxAU4nibk9t37xxUNx4PRy8QKpqibgry1mqiaYu5NLaoAibgHHkCtrKvgoEu6xz63UNQRAGBxF2Mg/0?wx_fmt=png" data-nickname="我是程序汪" data-alias="woshichengxuwang" data-signature="深耕IT咨询，10年开发老兵帮你少走弯路，分享我的工作和接私活经验，更关注底层码农 转行、培训、自学的小白程序员" data-from="2" data-is_biz_ban="0" has-insert-preloading="1" data-index="0" data-origin_num="202" data-isban="0"></mp-common-profile></section></section></pre><p data-tool="mdnice编辑器"><span>欢迎添加程序汪个人微信 itwang009  进粉丝群或围观朋友圈</span></p></pre><p><img class="rich_pages wxw-img __bg_gif" data-galleryid="" data-ratio="0.2777777777777778" data-src="https://mmbiz.qpic.cn/mmbiz_gif/CKvMdchsUwlkU1ysoMgG69dVYbCQcI6Byneb8ibzZWPfUCr3T8CuBicCSGyFE6SpAtxpxtDCp6VlZ4F1hEL1BNyg/640?wx_fmt=gif&amp;wxfrom=5&amp;wx_lazy=1" data-type="gif" data-w="1080" data-index="27" data-origin-display="initial" _width="677px" src="https://mmbiz.qpic.cn/mmbiz_gif/CKvMdchsUwlkU1ysoMgG69dVYbCQcI6Byneb8ibzZWPfUCr3T8CuBicCSGyFE6SpAtxpxtDCp6VlZ4F1hEL1BNyg/640?wx_fmt=gif&amp;wxfrom=5&amp;wx_lazy=1"/><span class="js_img_placeholder wx_widget_placeholder" data-src="https://mmbiz.qpic.cn/mmbiz_gif/CKvMdchsUwlkU1ysoMgG69dVYbCQcI6Byneb8ibzZWPfUCr3T8CuBicCSGyFE6SpAtxpxtDCp6VlZ4F1hEL1BNyg/640?wx_fmt=gif&amp;wxfrom=5&amp;wx_lazy=1" data-index="27"><span class="weui-primary-loading"><span class=""></span></span></span></p></section></h2></pre>
