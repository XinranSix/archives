#### 教你一招：在 Idea 中隐藏指定文件/文件夹

​ 创建 SpringBoot 工程时，使用 SpringBoot 向导也好，阿里云也罢，其实都是为了一个目的，得到一个标准的 SpringBoot 工程文件结构。这个时候就有新的问题出现了，标准的工程结构中包含了一些未知的文件夹，在开发的时候看起来特别别扭，这一节就来说说这些文件怎么处理。

​ 处理方案无外乎两种，如果你对每一个文件/目录足够了解，没有用的完全可以删除掉，或者不删除，但是看着别扭，就设置文件为看不到就行了。删除不说了，直接 Delete 掉就好了，这一节说说如何隐藏指定的文件或文件夹信息。

​ 既然是在 Idea 下做隐藏功能，肯定隶属于 Idea 的设置，设置方式如下。

**步骤 ①**：打开设置，【Files】→【Settings】

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211122173835517.png" alt="image-20211122173835517" style="zoom:80%;" />

**步骤 ②**：打开文件类型设置界面，【Editor】→【File Types】→【Ignored Files and Folders】，忽略文件或文件夹显示

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211122174020028.png" alt="image-20211122174020028" style="zoom: 67%;" />

**步骤 ③**：添加你要隐藏的文件名称或文件夹名称，可以使用\*号通配符，表示任意，设置完毕即可

​ 到这里就做完了，其实就是 Idea 的一个小功能

**总结**

1. Idea 中隐藏指定文件或指定类型文件
    1. 【Files】→【Settings】
    2. 【Editor】→【File Types】→【Ignored Files and Folders】
    3. 输入要隐藏的名称，支持\*号通配符
    4. 回车确认添加
