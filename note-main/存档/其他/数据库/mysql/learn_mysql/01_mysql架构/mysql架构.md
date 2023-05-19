## 一、了解 mysql 的安装目录

### [#](https://ydlclass.com/doc21xnv/database/dir/#_1、windows中的目录)1、windows 中的目录

#### [#](https://ydlclass.com/doc21xnv/database/dir/#_1-整体的目录结构)（1）整体的目录结构

![image-20201201151814062](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-image-20201201151814062.82ec67ba.png)

#### [#](https://ydlclass.com/doc21xnv/database/dir/#_2-数据文件目录)（2）数据文件目录

![image-20201124143358592](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-image-20201124143358592.e6ead470.png)

-   1、`bin`目录
-   用于放置一些可执行文件，如 mysql.exe、mysqld.exe、mysqlshow.exe 等。
-   2、`data`目录
-   用于放置一些日志文件以及数据库。
-   3、`include`目录
-   用于放置一些头文件，如：mysql.h、mysql_ername.h 等。
-   4、`lib`目录
-   用于放置一系列库文件。
-   5、`share`目录
-   用于存放字符集、语言等信息。
-   6、`my.ini`这个很重要
-   是 MySQL 数据库中使用的配置文件。

配置文件很重要，所谓配置文件就是配置一下你的 mysql 让他成为你想要的的样子。

### [#](https://ydlclass.com/doc21xnv/database/dir/#_2、linux中的文件目录)2、linux 中的文件目录

咱们当时使用的是 rpm 安装，他会有个默认的路径。

#### [#](https://ydlclass.com/doc21xnv/database/dir/#_1-bin)（1）bin

![image-20201124144036825](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-image-20201124144036825.f6083823.png)

#### [#](https://ydlclass.com/doc21xnv/database/dir/#_2-配置文件)（2）配置文件

![image-20201124144308513](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-image-20201124144308513.1edc6745.png)

#### [#](https://ydlclass.com/doc21xnv/database/dir/#_3-pid文件)（3）pid 文件

这个文件用来指导当前运行的 mysql 实例的进程号！

![image-20201124145129705](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-image-20201124145129705.3d57ca1b.png)

#### [#](https://ydlclass.com/doc21xnv/database/dir/#_4-数据库文件)（4）数据库文件

![image-20201124145235600](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-image-20201124145235600.2b47a32d.png)

### [#](https://ydlclass.com/doc21xnv/database/dir/#_3、附录-常用配置)3、附录：常用配置

-   port：端口
-   server-id：数据库唯一标识码
-   datadir：数据目录路径
-   basedir：基本路径
-   socket：指定 socket 文件路径
-   skip-name-resolve：禁止 mysql 对外部连接进行 DNS 解析，启用时所有远程连接都要使用 ip 地址方式
-   skip-external-locking：避免外部锁，默认开启
-   skip-grant-tables：mysql 启动时不使用 grant-tables 授权表，常用于忘记密码情况下
-   user：使用的用户
-   sql_mode：约束 SQL 语法模式
-   show_query_log_file：慢日志存储路径，5.6 及以上版本，log-slow-queries 是 5.6 以下版本
-   long_query_time：设置慢查询时间，默认 10s
-   log-queries-not-using-indexes：记录未使用索引查询
-   log_throttle_queries_not_using_indexs：5.6.5 版本新增参数，设定每分钟记录到日志未使用索引的语句数目，超过则之后只记录语句数量和花费总时间
-   log_output：日志存储方式，默认 FILE，TABLE 表示写入到 mysql.slow_log 表
-   expire_logs_days：二进制日志保留的时间
-   log-bin：设置日志文件路径及名称
-   log-bin-index：日志文件后缀形式
-   relay-bin：中继日志文件
-   relay-bin-index：中继日志文件后缀形式
-   max_connections：mysql 最大连接数（超出会报 Too many connections）
-   back_log：mysql 暂存的连接数量(每个连接占用 256kb)
-   wait_timeout：关闭一个非交互的连接之前所需要等待的秒数
-   max_connect_errors：最大错误连接数，flush host 进行解禁
-   max_allowed_packet：接受数据包大小，需要是才会分配内存，设置过大会造成内存溢出
-   max_heap_table_size：用户可以创建的内存表大小
-   tmp_table_size：mysql 的 heap 表缓冲大小
-   read_rnd_buffer_size：mysql 随机读缓冲区大小
-   sort_buffer_size：mysql 执行排序使用的缓冲大小
-   join_buffer_size：联合查询操作所能使用的缓冲区大小

### [#](https://ydlclass.com/doc21xnv/database/dir/#_4、mysql修改配置的方法)4、mysql 修改配置的方法

（1）设置全局变量方法 1(不推荐): 修改参数文件, 然后重启 mysqld

```text
# vi /etc/my.cnf
[mysqld]
wait_timeout=10
# service mysqld restart
```

1
2
3
4

不过这个方法太生硬了, 线上服务重启无论如何都应该尽可能避免.

（2）设置全局变量方法 2(推荐): 在命令行里通过 SET 来设置, 然后再修改参数文件\*\*

如果要修改全局变量, 必须要显示指定"GLOBAL"或者"@@global.", 同时必须要有 SUPER 权限.

```text
mysql> set global wait_timeout=10;
mysql> set @@global.wait_timeout=10;
```

1
2

然后查看设置是否成功:

```text
mysql> select @@global.wait_timeout=10;
or
mysql> show global variables like 'wait_timeout';
```

1
2
3

如果查询时使用的是 show variables 的话, 会发现设置并没有生效, 除非重新登录再查看. 这是因为使用 show variables 的话就等同于使用 show session variables, 查询的是会话变量, 只有使用 show global variables 查询的才是全局变量. 如果仅仅想修改会话变量的话, 可以使用类似 set wait_timeout=10;或者 set session wait_timeout=10;这样的语法.

当前只修改了正在运行的 MySQL 实例参数, 但下次重启 mysqld 又会回到默认值, 所以别忘了修改参数文件:

```text
# vi /etc/my.cnf
[mysqld]
wait_timeout=10
```

1
2
3

（3）设置会话变量方法: 在命令行里通过 SET 来设置

如果要修改会话变量值, 可以指定"SESSION"或者"@@session."或者"@@"或者"LOCAL"或者"@@local.", 或者什么都不使用.

```sql
mysql> set wait_timeout=10;
mysql> set session wait_timeout=10;
mysql> set local wait_timeout=10;
mysql> set @@wait_timeout=10;
mysql> set @@session.wait_timeout=10;
mysql> set @@local.wait_timeout=10;
```

1
2
3
4
5
6

然后查看设置是否成功:

```sql
mysql> select @@wait_timeout;
mysql> select @@session.wait_timeout;
mysql> select @@local.wait_timeout;
mysql> show variables like 'wait_timeout';
mysql> show local variables like 'wait_timeout';
mysql> show session variables like 'wait_timeout';
```

1
2
3
4
5
6

（4）会话变量和全局变量转换方法:

在命令行里通过 SET 来设置

```bash
# 将会话变量值设置为对应的全局变量值呢:
mysql> set @@session.wait_timeout=@@global.wait_timeout;
# 将会话变量值设置为MySQL编译时的默认值(wait_timeout=28800):
mysql> set wait_timeout=DEFAULT;
```

1
2
3
4

这里要注意的是, 并不是所有的系统变量都能被设置为 DEFAULT, 如果设置这些变量为 DEFAULT 则会返回错误.

## [#](https://ydlclass.com/doc21xnv/database/dir/#二、mysql的系统架构)二、mysql 的系统架构

### [#](https://ydlclass.com/doc21xnv/database/dir/#_1、-数据库和数据库实例)1、 数据库和数据库实例

在 MySQL 的学习研究中，存在两个非常容易混淆的概念，即`数据库`和`数据库实例`。在 MySQL 中，数据库和数据库实例定义如下：

-   数据库：存储数据的；
-   数据库实例：操作数据库的。

如上定义很清楚了，数据库是用来存储数据的，数据库实例是用来操作数据的，从操作系统的角度，数据库实例表现为一个进程，对应多个线程，

在非集群数据库架构中，数据库与数据库实例存在一 一对应关系，在数据库集群中，可能存在多个数据库实例操作一个数据库情况，即多对一关系。

### [#](https://ydlclass.com/doc21xnv/database/dir/#_2、mysql架构)2、MySQL 架构

复杂的架构是为了更好的工作，架构中的每一个角色都可以高效的单独处理一类事件，举个例子。

你去拜访你朋友当然朋友自己迎接你即可。

但是你要拜访市长，可能就要门卫处做身份认证、传达室负责接通电话确认可以、市长办公室负责接待、你可能需要排队等候、你的事情如果办公室就能解决可能就不用见市长了，最后轮到你了，你才能见上市长。

对于 MySQL 来说，虽然经历了多个版本迭代（MySQL5.5,MySQL 5.6,MySQL 5.7,MySQL 8）,但每次的迭代，都是基于 MySQL

基架的，MySQL 基架大致包括如下几大模块组件：

**（1）MySQL 向外提供的交互接口（Connectors）**

Connectors 组件，是 MySQL 向外提供的交互组件，如 java,.net,php 等语言可以通过该组件来操作 SQL 语句，实现与 SQL 的交互。

**（2）管理服务组件和工具组件(Management Service & Utilities)**

提供对 MySQL 的集成管理，如备份(Backup),恢复(Recovery),安全管理(Security)等

**（3）连接池组件(Connection Pool)**

负责监听对客户端向 MySQL Server 端的各种请求，接收请求，转发请求到目标模块。每个成功连接 MySQL Server 的客户请求都会被

创建或分配一个线程，该线程负责客户端与 MySQL Server 端的通信，接收客户端发送的命令，传递服务端的结果信息等。

**（4）SQL 接口组件(SQL Interface)**

接收用户 SQL 命令，如 DML,DDL 和存储过程等，并将最终结果返回给用户。

**（5）查询分析器组件(Parser)**

首先分析 SQL 命令语法的合法性，并尝试将 SQL 命令分解成数据结构，若分解失败，则提示 SQL 语句不合理。

**（6）优化器组件（Optimizer）**

对 SQL 命令按照标准流程进行优化分析。

**（7）缓存主件（Caches & Buffers）**

缓存和缓冲组件

![image-20201208160336839](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-image-20201208160336839.6d0236a8.png)

![image-20201208160226331](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-image-20201208160226331.a43090d0.png)

**（8）MySQL 存储引擎**

> 什么是 MySQL 存储引擎

MySQL 属于关系型数据库，而关系型数据库的存储是以表的形式进行的，对于表的创建，数据的存储，检索，更新等都是由 MySQL

存储引擎完成的，这也是 MySQL 存储引擎在 MySQL 中扮演的重要角色。

研究过 SQL Server 和 Oracle 的读者可能很清楚，这两种数据库的存储引擎只有一个，而 MySQL 的存储引擎种类比较多，如 MyISAM 存储引擎，InnoDB 存储引擎和 Memory 存储引擎.

MySQL 之所以有多种存储引擎，是因为 MySQL 的开源性决定的。MySQL 存储引擎，从种类上来说，大致可归结为官方存储引擎和第三方存储引起。MySQL 的开源性，允许第三方基于 MySQL 骨架，开发适合自己业务需求的存储引擎。

> MySQL 存储引擎作用

```
 MySQL存储引擎在MySQL中扮演重要角色，其作比较重要作用，大致归结为如下两方面：
```

作用一：管理表创建，数据检索，索引创建等

作用二：满足自定义存储引擎开发。

> MySQL 引擎种类

不同种类的存储引擎，在存储表时的存储引擎表机制也有所不同，从 MySQL 存储引擎种类上来说，可以分为官方存储引擎和第三方存储引擎。

比较常用的存储引擎包括 InnoDB 存储引擎，MyISAM 存储引擎和 Momery 存储引擎。

（九）物理文件（File System）

实际存储`MySQL 数据库文件`和一些`日志文件`等的系统。

## [#](https://ydlclass.com/doc21xnv/database/dir/#三、mysql的存储引擎)三、mysql 的存储引擎

> 能看懂多少看多少，以后会一点点了解

### [#](https://ydlclass.com/doc21xnv/database/dir/#_1、mysql常用存储引擎及特点)1、MySQL 常用存储引擎及特点

#### [#](https://ydlclass.com/doc21xnv/database/dir/#_1-、innodb存储引擎)（1）、InnoDB 存储引擎

从 MySQL5.5 版本之后，MySQL 的默认内置存储引擎已经是 InnoDB 了，他的主要特点有：

（1）支持事务。默认的事务隔离级别为可重复度，通过 MVCC（并发版本控制）来实现的。 （2）使用的锁粒度为行级锁，可以支持更高的并发； （3）支持外键； （4）在 InnoDB 中存在着缓冲管理，通过缓冲池，将索引和数据全部缓存起来，加快查询的速度； （5）对于 InnoDB 类型的表，其数据的物理组织形式是聚簇表。所有的数据按照主键来组织。数据和索引放在一块，都位于 B+数的叶子节点上；

#### 2）、MyISAM 存储引擎

在 5.5 版本之前，MyISAM 是 MySQL 的默认存储引擎，该存储引擎并发性差，不支持事务，所以使用场景比较少，主要特点为：

（1）不支持事务； （2）不支持外键，如果强行增加外键，不会提示错误，只是外键不其作用； （3）对数据的查询缓存只会缓存索引，不会像 InnoDB 一样缓存数据，而且是利用操作系统本身的缓存； （4）默认的锁粒度为表级锁，所以并发度很差，加锁快，锁冲突较少，所以不太容易发生死锁； （5）支持全文索引（MySQL5.6 之后，InnoDB 存储引擎也对全文索引做了支持），但是 MySQL 的全文索引基本不会使用，对于全文索引，现在有其他成熟的解决方案，比如：ElasticSearch，Solr，Sphinx 等。 （6）数据库所在主机如果宕机，MyISAM 的数据文件容易损坏，而且难恢复；

### 2、两种引擎的对比

1、由于锁粒度的不同，InnoDB 比 MyISAM 支持更高的并发；

2、InnoDB 为行级锁，MyISAM 为表级锁，所以 InnoDB 相对于 MyISAM 来说，更容易发生死锁，锁冲突的概率更大，而且上锁的开销也更大，因为需要为每一行加锁；

3、在备份容灾上，InnoDB 支持在线热备，有很成熟的在线热备解决方案；

4、查询性能上，MyISAM 的查询效率高于 InnoDB，因为 InnoDB 在查询过程中，是需要维护数据缓存，而且查询过程是先定位到行所在的数据块，然后在从数据块中定位到要查找的行；而 MyISAM 可以直接定位到数据所在的内存地址，可以直接找到数据；

5、SELECT COUNT(\*)语句，如果行数在千万级别以上，MyISAM 可以快速查出，而 InnoDB 查询的特别慢，因为 MyISAM 将行数单独存储了，而 InnoDB 需要逐行去统计行数；所以如果使用 InnoDB，而且需要查询行数，则需要对行数进行特殊处理，如：离线查询并缓存；

6、MyISAM 的表结构文件包括：.frm(表结构定义),.MYI(索引),.MYD(数据)；而 InnoDB 的表数据文件为:.ibd 和.frm(表结构定义)；

### 3、选择合适的存储引擎

1、使用场景是否需要事务支持；

2、是否需要支持高并发，InnoDB 的并发度远高于 MyISAM；

3、是否需要支持外键；

4、高效缓冲数据，InnoDB 对数据和索引都做了缓冲，而 MyISAM 只缓冲了索引；

5、索引，不同存储引擎的索引并不太一样；
