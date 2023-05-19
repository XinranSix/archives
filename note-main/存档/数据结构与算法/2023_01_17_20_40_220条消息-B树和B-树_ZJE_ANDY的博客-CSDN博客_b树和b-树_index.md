---
title: (220条消息) B树和B+树_ZJE_ANDY的博客-CSDN博客_b树和b+树
url: https://blog.csdn.net/u014453898/article/details/112469113?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166651727716800186558581%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=166651727716800186558581&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-12-112469113-null-null.142%5Ev59%5Ejs_top,201%5Ev3%5Econtrol_2&utm_term=%E6%A0%91&spm=1018.2226.3001.4187
clipped_at: 2023-01-17 20:40:55
category: default
tags: 
 - None
---

# (220 条消息) B 树和 B+树\_ZJE_ANDY 的博客-CSDN 博客\_b 树和 b+树

**目录**

[一、BST 树到 AVL 树到 B 树的简介](#t0)

[1.1  BST 树 --- 二叉排序树](#t1)

[1.2 AVL 树 --- 平衡二叉树](#t2)

[1.3  B 树 --- 平衡多路查找树](#t3)

[1.3.1  B 树的查找结点过程](#t4)

[1.3.2  B 树的添加结点过程（和结点分裂过程）](#t5)

[1.3.3 B 树的删除结点过程](#t6)

[二、B+树](#t7)

[2.1  B 树和 B+树](#t8)

---

# 一、BST 树到[AVL 树](https://so.csdn.net/so/search?q=AVL%E6%A0%91&spm=1001.2101.3001.7020)到 B 树的简介

## 1.1  BST 树 --- [二叉排序树](https://so.csdn.net/so/search?q=%E4%BA%8C%E5%8F%89%E6%8E%92%E5%BA%8F%E6%A0%91&spm=1001.2101.3001.7020)

**特点：**

> 1\. 根节点的值大于其左子树中任意一个节点的值
>
> 2\. 根结点的值小于其右节点中任意一节点的值
>
> 3\. 这一规则适用于[二叉查找树](https://so.csdn.net/so/search?q=%E4%BA%8C%E5%8F%89%E6%9F%A5%E6%89%BE%E6%A0%91&spm=1001.2101.3001.7020)中的每一个节点。

**好处：**

> 查询的[时间复杂度](https://so.csdn.net/so/search?q=%E6%97%B6%E9%97%B4%E5%A4%8D%E6%9D%82%E5%BA%A6&spm=1001.2101.3001.7020)比链表快，链表的查询时间复杂度是 O(n)，二叉排序树平均是 O(logn)。二叉排序树越平衡，越能模拟二分法，所以越能想二分法的查询的时间复杂度 O(logn)。
>
> 二叉排序树如下图：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-fa05442d9e4cae0a3384ec60ba13a0cb.png)

**不足：**

> 但是 BST 树有一个不足的地方，就是如果插入的结点的值的顺序，是越来越小或者越来越大的，那么 BST 就会退化为一条链表，那么其查询的时间复杂度就会降为 O(n)。
>
> 如下图：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-9affd5fa5bb75baad4cedd3974219217.png)

## 1.2 AVL 树 --- 平衡二叉树

由于 BST 树存在上述的不足，所以 AVL 树就出来了。

**特点：**

> 1\. 拥有 BST 树的特点：根节点的值大于其左子树中任意一个节点的值，小于其右节点中任意一节点的值，这一规则适用于二叉查找树中的每一个节点。
>
> 2\. AVL 树上任意结点的左、右子树的高度差最大为 1。

由于 AVL 树的第二个特点，使得，AVL 树的形状肯定不会退化成一条链表的，而是“矮胖”型的树。所以能确保 AVL 的查找、添加、删除的时间复杂度都是 O(logn)。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-305755921959b615135c910fe0ecf8a0.png)

## 1.3  [B 树](https://so.csdn.net/so/search?q=B%E6%A0%91&spm=1001.2101.3001.7020) --- 平衡多路查找树

B 树和 AVL 树(平衡二叉树) 的差别就是 B 树 属于多叉树，又名平衡多路查找树，即一个结点的查找路径不止左、右两个，而是有多个。数据库索引技术里大量使用者 B 树和 B+树的数据结构。一个结点存储多个值(索引)。

B 树的阶数：M 阶表示 一个 B 树的结最多有多少个查找路径(即这个结点有多少个子节点)。M=M 路，M=2 是二叉树，M=3 则是三叉树。

一棵**M 阶 B 树**有以下特点。

**特点：**

> 1.    每个结点的值(索引) 都是按递增次序排列存放的，并遵循左小右大原则。
>
> 2.  **根结点**  的 子节点 个数为 \[2，**M**\]。
>
> 3\. 除 **根结点** 以外 的 **非叶子结点** 的子节点个数 为\[ **Math.ceil(M/2)**，**M**\]。 Math.ceil() 为向上取整。
>
> 4\. 每个 **非叶子结点** 的值(索引) 个数 = **子节点个数 -1** 。最小为  **Math.ceil(M/2)-1**    最大为 **M-1** 个。
>
> 5\. B 树的所有叶子结点都位于同一层。

下图是一个 3 阶 B 树：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-09fa93e948a8d30501f9e94f02b815a0.png)

可以看到：

> 1\. 除 根结点 外，所有   非叶子结点   都至少有 M/2 = 1.5 取整 = 2 个结点。
>
> 2\. 每个 结点中 的索引值 都是从小到大排序的。
>
> 3\. 所有叶子结点都在同一层中。

### 1.3.1  B 树的查找结点过程

从上述的 3 阶 B 树 中，查找 结点 5 的过程：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-f54b0ef0c161f300287a3ad6ad0ff9f9.png)

（1） 第一次读 IO，把 9 的结点读到内存，再与目标数 5 比较，5 是小于 9 的，因此往 9 的左边走。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-0996e1f585c8433aedd5c1275510d2ad.png)

（2） 第二次读 IO，还是把结点读到内存中，然后比较结点中的 2 和 6 与目标值 5。发现 5 是大于 2 小于 6 的，因此往中间路径走。

（3）第三次读 IO，还是把结点读到内存中，然后发现结点中有 5，因此找到目标值。

**好处：**

> 1\. 在数据库查询中，以树存储数据。树有多少层，就意味着要读多少次磁盘 IO。
>
> 所以树的高度越矮，就意味着查询数据时，需要读 IO 的次数就越少。（众所周知，读 IO 是一件费事的操作）
>
> 当数据量大的时候，用 AVL 树存的话，就算 AVL 是平衡树，但是也扛不住数据量大，数据量大，AVL 树的树高肯定很高，那么读取数据的 IO 次数也会多。那么有没有办法能压缩 AVL 树的树高呢？这时候 B 树就出来了。B 树的一个结点可以装多个值，读取时，是把整个结点读到内存，然后在内存中，对结点的值进行处理，在内存中处理速度肯定比磁盘快。所以只要树的高度低，IO 少，就能够提升查询效率，这是 B 树的好处之一。
>
> 2\. B 树的每一个结点都包含 key(索引值) 和 value(对应数据)，因此方位离根结点近的元素会更快速。（相对于 B+树）

### 1.3.2  B 树的添加结点过程（和结点分裂过程）

下面以 5 阶 B 树为例：

> （a）在空树中插入 39：
>
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-ee459626120d44cc8f87f76538220a33.png)

此时根结点只有一个索引值。

> （b）继续插入 22，97 和 41：
>
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-ef58c0ae5f31d984d3b24b45d1b51abd.png)

根结点此时有 4 个索引值。

> （c）继续插入 53：
>
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-f1083610fce35093863feeb70f8e1ff2.png)
>
> 此时已经超过了最大允许的索引个数 4，即 4 个。所以以其中心（41）分裂。结果如下图所示：
>
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-4427cdceea836d594d974dc7c22bd982.png)

（d）然后在上图的基础上，再依次插入 13，21，40，那么 41 所在结点的左子结点里的值就为 13、21、22、39、40，一共五个，所以会以 22 为中心进行分裂，结果如下图所示：

> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-2cf81e25c2eb03f12551f1c96f373aef.png)
>
> 分裂的中心 22 会进位到上一层的结点中。

（e）再在上图的基础上，插入 30，27，33，那么其中有一个结点内的值为 27、30、33、39、40，那么就会以 33 为中心引起一次分裂。

然后再插入 36，35，34，那么就又会有一个结点内的值为 34、35、36、39、40，那么就会以 36 为中心分裂。

然后再插入 24、29，如下图所示：

> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-b627f19615f593bb8cf3f79158caa101.png)
>
> 此时拥有 24、27、29、30 的结点只要再插入一个索引值，就又会发生分裂。

（f） 插入 26

> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-6f1277cd7ccdb79a917b79867b3561f1.png)
>
> 插入 26 后，结点以 27 为中心分裂，并且 27 进位到上一层父结点中。

（g）27 进位到父节点后，父节点里的索引值也超过了 4 个，因此也要分裂，分裂后如下：

> 27 进位后的 B 树：
>
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-03101b0754e63a187e88e346baed2c79.png)
>
> 根结点分裂后的 B 树：
>
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-acb79e7ca03c69c202c17becbb50252b.png)

### 1.3.3 B 树的删除结点过程

（a）原始状态

> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-d220dee4ba8e60ab57e773f854f1982a.png)

（b）再上图的树中，删除 21

> 由于删除 21 后的结点的索引值个数仍然大于 2（Math.ceil( 5/2 ) -1 =2），因此删除结束。
>
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-7f0d93e2828df5a497dce972072c862d.png)

（c）接着删除 27

> 从上图可知，由于 27 是非叶子结点，所以要删除 27 的话，需要用 27 的后继替代它。从上图可以看出，27 的后继是 28，因此我们用 28 来替代 27，再删除原来的 28，如下图：
>
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-59d1562865b4550caffbd7e9f0d61f86.png)
>
> 删除后发现，当前结点(当前结点如上图所示)的索引值个数小于 2 个，而它的兄弟结点有 3 个索引值（当前结点还有一个右兄弟，选择右兄弟的话，会出现合并结点的情况，不论选哪一个都可以，只是最后的 B 树形态会不一样而已），那么就向左兄弟借一个索引值，注意这里的借并非直接从左兄弟结点处拿一个索引值过来，如果是这样的话，就破坏了 B 树父节点左子树比根结点小，右子树比根结点大的特性了。借是 把当前结点的父节点的 28 下移，然后把左兄弟结点的 26 上移到父节点，删除结束。如下图：
>
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-c49229f1d538c56b80f851e918e49d4c.png)

（d）在上述情况接着删除 32：如下图

> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-3b865cecc22f14e186ec327c3a822a4f.png)
>
> 在删除 32 后，当前结点剩下 31，即索引值数目小于 2。这时候，它的兄弟结点，也仅仅有 2 个索引值，所以不能向兄弟结点借。
>
> 那只能够让父结点下移一个值(30)，并和兄弟结合合并成一个新的结点，如下图：
>
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-ade87b38cc74ec65bca18c1f417c46d6.png)
>
> 当前结点的索引值个数不小于 2 （Math.ceil( 5/2 ) -1 =2），满足条件，删除结束。

（e）接着删除 40：

> 删除 40 后，如下图所示：
>
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-2144106ea5d8a648eab7b4ccb9deabd6.png)
>
> 当前结点由于索引值小于 2，因此需要像父结点借，父结点下移 36 到当前结点，然后和兄弟结点合并(选择左兄弟或右兄弟都可以，这里我选择了左兄弟)，如下图：
>
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-fe801a63117119c64297b6dc2e994f09.png)
>
> 但这时候发现，新的当前结点的索引值个数又小于 2 了，那么只能向其父结点借了，所以其父结点下移 33，然后当前结点和其兄弟结点合并，如下图：
>
> ![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-5c1c87af565f6dad428cea4b6eaab8e6.png)
>
> 删除结束。

# 二、B+树

## 2.1  B 树和 B+树

B+树是基于 B 树的基础提出的。

下图是一棵 4 阶 B+树：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1673959255-03d1c8787d598653f9f7e58739505313.png)

**B+树和 B 树最大的不同是：**

1.  B+树内部有两种结点，一种是索引结点，一种是叶子结点。
2.  B+树的索引结点并不会保存记录，只用于索引，所有的数据都保存在 B+树的叶子结点中。而 B 树则是所有结点都会保存数据。
3.  B+树的叶子结点都会被连成一条链表。叶子本身按索引值的大小从小到大进行排序。即这条链表是 从小到大的。多了条链表方便范围查找数据。
4.  B 树的所有索引值是不会重复的，而 B+树 非叶子结点的索引值 最终一定会全部出现在 叶子结点中。

**为什么要有 B+树：**

要说明这个问题，首先要从 B 树的好处和不足出发。

> **B 树好处：**
>
> B 树的每一个结点都包含 key(索引值) 和 value(对应数据)，因此方位离根结点近的元素会更快速。（相对于 B+树）
>
> **B 树的不足：**
>
> 不利于范围查找(区间查找)，如果要找 0~100 的索引值，那么 B 树需要多次从根结点开始逐个查找。
>
> 而 B+树由于叶子结点都有链表，且链表是以从小到大的顺序排好序的，因此可以直接通过遍历链表实现范围查找。

文章知识点与官方知识档案匹配，可进一步学习相关知识

[算法技能树](https://edu.csdn.net/skill/algorithm/)[首页](https://edu.csdn.net/skill/algorithm/)[概览](https://edu.csdn.net/skill/algorithm/)35245 人正在系统学习中
