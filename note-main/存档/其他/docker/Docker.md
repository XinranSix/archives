# Docker

## 初识 Docker

我们写的代码会接触到好几个环境：开发环境、测试环境以及生产环境：

![image-20230121211251753](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121211251753.png)

### Docker 概念

-   Docker 是一个开源的应用容器引擎；
-   诞生于 2013 年初，基于 Go 语言实现， dotCloud 公司出品（后改名为 Docker Inc）
-   Docker 可以让开发者打包他们的应用以及依赖包到一个轻量级、可移植的容器中，然后发布到任何流行的 Linux 机器上。

-   容器是完全使用沙箱机制，相互隔离

-   容器性能开销极低。

-   Docker 从 17.03 版本之后分为 CE（Community Edition: 社区版） 和 EE（Enterprise Edition: 企业版）

### 安装 Docker

```shell
# 1、yum 包更新到最新
yum update
# 2、安装需要的软件包， yum-util 提供yum-config-manager功能，另外两个是devicemapper驱动依赖的
yum install -y yum-utils device-mapper-persistent-data lvm2
# 3、 设置yum源
yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
# 4、 安装docker，出现输入的界面都按 y
yum install -y docker-ce
# 5、 查看docker版本，验证是否验证成功
docker -v

```

### Docker 架构

![image-20230121211438452](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121211438452.png)

-   镜像（Image）：Docker 镜像（Image），就相当于是一个 root 文件系统。比如官方镜像 ubuntu:16.04 就包含了完整的一套 Ubuntu16.04 最小系统的 root 文件系统。
-   容器（Container）：镜像（Image）和容器（Container）的关系，就像是面向对象程序设计中的类和对象一样，镜像是静态的定义，容器是镜像运行时的实体。容器可以被创建、启动、停止、删除、暂停等。

-   仓库（Repository）：仓库可看成一个代码控制中心，用来保存镜像。

### 配置 Docker 镜像加速器

![image-20230121211959567](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121211959567.png)

## Docker 命令

### Docker 进程相关命令

```shell
#启动docker服务:
systemctl start docker
#停止docker服务:
systemctl stop docker
#重启docker服务:
systemctl restart docker
#查看docker服务状态:
systemctl status docker
#设置开机启动docker服务:
systemctl enable docker
```

### Docker 镜像相关命令

```shell
#查看镜像: 查看本地所有的镜像
docker images
docker images –q # 查看所用镜像的id
#搜索镜像:从网络中查找需要的镜像
docker search 镜像名称
#拉取镜像:从Docker仓库下载镜像到本地，镜像名称格式为 名称:版本号，如果版本号不指定则是最新的版本。如果不知道镜像版本，可以去docker hub 搜索对应镜像查看。
docker pull 镜像名称
#删除镜像: 删除本地镜像
docker rmi 镜像id # 删除指定本地镜像
docker rmi `docker images -q`# 删除所有本地镜像
```

### Docker 容器相关命令

```shell
# 查看容器
docker ps # 查看正在运行的容器
docker ps –a # 查看所有容器
# 创建并启动容器
docker run 参数
```

参数说明：

-   `-i`：保持容器运行。通常与 -t 同时使用。加入 it 这两个参数后，容器创建后自动进入容器中，退出容器后，容器自动关闭。
-   `-t`：为容器重新分配一个伪输入终端，通常与 `-i` 同时使用。
-   `-d`：以守护（后台）模式运行容器。创建一个容器在后台运行，需要使用 docker exec 进入容器。退出后，容器不会关闭。
-   `-it`：创建的容器一般称为交互式容器，`-id` 创建的容器一般称为守护式容器
-   `--name`：为创建的容器命名。

```shell
# 进入容器
docker exec 参数 # 退出容器，容器不会关闭
# 停止容器
docker stop 容器名称
# 启动容器
docker start 容器名称
# 删除容器：如果容器是运行状态则删除失败，需要停止容器才能删除
docker rm 容器名称
# 查看容器信息
docker inspect 容器名称
```

## Docker 容器的数据卷

### 数据卷概念

思考：

-   Docker 容器删除后，在容器中产生的数据还在吗？
-   Docker 容器和外部机器可以直接交换文件吗？
-   容器之间想要进行数据交互？

![image-20230121212637080](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121212637080.png)

![image-20230121212646351](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121212646351.png)

**数据卷**：

-   数据卷是宿主机中的一个目录或文件
-   当容器目录和数据卷目录绑定后，对方的修改会立即同步
-   一个数据卷可以被多个容器同时挂载
-   一个容器也可以被挂载多个数据卷

数据卷作用：

-   容器数据持久化
-   外部机器和容器间接通信
-   容器之间数据交换

![image-20230121212750776](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121212750776.png)

### 配置数据卷

-   创建启动容器时，使用 –v 参数 设置数据卷

```shell
docker run ... –v 宿主机目录(文件):容器内目录(文件) ...
```

注意事项：

1. 目录必须是绝对路径
2. 如果目录不存在，会自动创建
3. 可以挂载多个数据卷

![image-20230121212855218](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121212855218.png)

### 数据卷容器

多容器进行数据交换

1. 多个容器挂载同一个数据卷
2. 数据卷容器

![image-20230121212939763](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121212939763.png)

### 配置数据卷容器

1. 创建启动 c3 数据卷容器，使用 –v 参数 设置数据卷

```shell
docker run –it --name=c3 –v /volume centos:7 /bin/bash
```

2. 创建启动 c1 c2 容器，使用 –-volumes-from 参数 设置数据卷

```shell
docker run –it --name=c1 --volumes-from c3 centos:7 /bin/bash
docker run –it --name=c2 --volumes-from c3 centos:7 /bin/bash
```

### 数据卷小结

1. 数据卷概念
    - 宿主机的一个目录或文件
2. 数据卷作用
    - 容器数据持久化
    - 客户端和容器数据交换
    - 容器间数据交换
3. 数据卷容器
    - 创建一个容器，挂载一个目录，让其他容器继承自该容器( --volume-from )。
    - 通过简单方式实现数据卷配置

## Docker 应用部署

### 一、部署 MySQL

1. 搜索 mysql 镜像

```shell
docker search mysql
```

2. 拉取 mysql 镜像

```shell
docker pull mysql:5.6
```

3. 创建容器，设置端口映射、目录映射

```shell
# 在/root目录下创建mysql目录用于存储mysql数据信息
mkdir ~/mysql
cd ~/mysql
```

```shell
docker run -id \
-p 3307:3306 \
--name=c_mysql \
-v $PWD/conf:/etc/mysql/conf.d \
-v $PWD/logs:/logs \
-v $PWD/data:/var/lib/mysql \
-e MYSQL_ROOT_PASSWORD=123456 \
mysql:5.6
```

-   参数说明：
    -   **-p 3307:3306**：将容器的 3306 端口映射到宿主机的 3307 端口。
    -   **-v $PWD/conf:/etc/mysql/conf.d**：将主机当前目录下的 conf/my.cnf 挂载到容器的 /etc/mysql/my.cnf。配置目录
    -   **-v $PWD/logs:/logs**：将主机当前目录下的 logs 目录挂载到容器的 /logs。日志目录
    -   **-v $PWD/data:/var/lib/mysql** ：将主机当前目录下的 data 目录挂载到容器的 /var/lib/mysql 。数据目录
    -   **-e MYSQL_ROOT_PASSWORD=123456：**初始化 root 用户的密码。

4. 进入容器，操作 mysql

```shell
docker exec –it c_mysql /bin/bash
```

5. 使用外部机器连接容器中的 mysql

![1573636765632](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1573636765632.png)

### 二、部署 Tomcat

1. 搜索 tomcat 镜像

```shell
docker search tomcat
```

2. 拉取 tomcat 镜像

```shell
docker pull tomcat
```

3. 创建容器，设置端口映射、目录映射

```shell
# 在/root目录下创建tomcat目录用于存储tomcat数据信息
mkdir ~/tomcat
cd ~/tomcat
```

```shell
docker run -id --name=c_tomcat \
-p 8080:8080 \
-v $PWD:/usr/local/tomcat/webapps \
tomcat
```

-   参数说明：

    -   **-p 8080:8080：**将容器的 8080 端口映射到主机的 8080 端口

        **-v $PWD:/usr/local/tomcat/webapps：**将主机中当前目录挂载到容器的 webapps

4. 使用外部机器访问 tomcat

![1573649804623](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1573649804623.png)

### 三、部署 Nginx

1. 搜索 nginx 镜像

```shell
docker search nginx
```

2. 拉取 nginx 镜像

```shell
docker pull nginx
```

3. 创建容器，设置端口映射、目录映射

```shell
# 在/root目录下创建nginx目录用于存储nginx数据信息
mkdir ~/nginx
cd ~/nginx
mkdir conf
cd conf
# 在~/nginx/conf/下创建nginx.conf文件,粘贴下面内容
vim nginx.conf
```

```shell

user  nginx;
worker_processes  1;

error_log  /var/log/nginx/error.log warn;
pid        /var/run/nginx.pid;


events {
    worker_connections  1024;
}


http {
    include       /etc/nginx/mime.types;
    default_type  application/octet-stream;

    log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
                      '$status $body_bytes_sent "$http_referer" '
                      '"$http_user_agent" "$http_x_forwarded_for"';

    access_log  /var/log/nginx/access.log  main;

    sendfile        on;
    #tcp_nopush     on;

    keepalive_timeout  65;

    #gzip  on;

    include /etc/nginx/conf.d/*.conf;
}


```

```shell
docker run -id --name=c_nginx \
-p 80:80 \
-v $PWD/conf/nginx.conf:/etc/nginx/nginx.conf \
-v $PWD/logs:/var/log/nginx \
-v $PWD/html:/usr/share/nginx/html \
nginx
```

-   参数说明：
    -   **-p 80:80**：将容器的 80 端口映射到宿主机的 80 端口。
    -   **-v $PWD/conf/nginx.conf:/etc/nginx/nginx.conf**：将主机当前目录下的 /conf/nginx.conf 挂载到容器的 :/etc/nginx/nginx.conf。配置目录
    -   **-v $PWD/logs:/var/log/nginx**：将主机当前目录下的 logs 目录挂载到容器的/var/log/nginx。日志目录

4. 使用外部机器访问 nginx

![1573652396669](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1573652396669.png)

### 四、部署 Redis

1. 搜索 redis 镜像

```shell
docker search redis
```

2. 拉取 redis 镜像

```shell
docker pull redis:5.0
```

3. 创建容器，设置端口映射

```shell
docker run -id --name=c_redis -p 6379:6379 redis:5.0
```

4. 使用外部机器连接 redis

```shell
./redis-cli.exe -h 192.168.149.135 -p 6379
```

## Dockerfile

### Docker 镜像原理

思考：

-   Docker 镜像本质是什么？\
    -   是一个分层文件系统
-   Docker 中一个 centos 镜像为什么只有 200MB，而一个 centos 操作系统的 iso 文件要几个个 G？
    -   Centos 的 iso 镜像文件包含 bootfs 和 rootfs，而 docker 的 centos 镜像复用操作系统的 bootfs，只有 rootfs 和其他镜像层
-   Docker 中一个 tomcat 镜像为什么有 500MB，而一个 tomcat 安装包只有 70 多 MB？
    -   由于 docker 中镜像是分层的，tomcat 虽然只有 70 多 MB，但他需要依赖于父镜像和基础镜像，所有整个对外暴露的 tomcat 镜像大小 500 多 MB

操作系统组成部分：

-   进程调度子系统
-   进程通信子系统
-   内存管理子系统
-   设备管理子系统
-   网络通信子系统
-   作业控制子系统

Linux 文件系统由 bootfs 和 rootfs 两部分组成

-   bootfs：包含 bootloader（引导加载程序）和 kernel（内核）
-   rootfs： root 文件系统，包含的就是典型 Linux 系统中的/dev，/proc，/bin，/etc 等标准目录和文件
-   不同的 linux 发行版，bootfs 基本一样，而 rootfs 不同，如 ubuntu，centos 等

![image-20230121213417141](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121213417141.png)

-   Docker 镜像是由特殊的文件系统叠加而成
-   最底端是 bootfs，并使用宿主机的 bootfs
-   第二层是 root 文件系统 rootfs,称为 base image
-   然后再往上可以叠加其他的镜像文件
-   统一文件系统（Union File System）技术能够将不同的层整合成一个文件系统，为这些层提供了一个统一的视角，这样就隐藏了多层的存在，在用户的角度看来，只存在一个文件系统。
-   一个镜像可以放在另一个镜像的上面。位于下面的镜像称为父镜像，最底部的镜像成为基础镜像。
-   当从一个镜像启动容器时，Docker 会在最顶层加载一个读写文件系统作为容器

![image-20230121213535506](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121213535506.png)

### 镜像制作

Docker 镜像如何制作？

1. 容器转为镜像

```shell
docker commit 容器id 镜像名称:版本号
docker save -o 压缩文件名称 镜像名称:版本号
docker load –i 压缩文件名称
```

![image-20230121213731160](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121213731160.png)

2. dockerfile

### Dockerfile 概念

-   Dockerfile 是一个文本文件
-   包含了一条条的指令
-   每一条指令构建一层，基于基础镜像，最终构建出一个新的镜像
-   对于开发人员：可以为开发团队提供一个完全一致的开发环境
-   对于测试人员：可以直接拿开发时所构建的镜像或者通过 Dockerfile 文件构建一个新的镜像开始工作了
-   对于运维人员：在部署时，可以实现应用的无缝移植

### Dockerfile 关键字

| 关键字      | 作用                     | 备注                                                                                                                          |
| ----------- | ------------------------ | ----------------------------------------------------------------------------------------------------------------------------- |
| FROM        | 指定父镜像               | 指定 dockerfile 基于那个 image 构建                                                                                           |
| MAINTAINER  | 作者信息                 | 用来标明这个 dockerfile 谁写的                                                                                                |
| LABEL       | 标签                     | 用来标明 dockerfile 的标签 可以使用 Label 代替 Maintainer 最终都是在 docker image 基本信息中可以查看                          |
| RUN         | 执行命令                 | 执行一段命令 默认是/bin/sh 格式: RUN command 或者 RUN ["command" , "param1","param2"]                                         |
| CMD         | 容器启动命令             | 提供启动容器时候的默认命令 和 ENTRYPOINT 配合使用.格式 CMD command param1 param2 或者 CMD ["command" , "param1","param2"]     |
| ENTRYPOINT  | 入口                     | 一般在制作一些执行就关闭的容器中会使用                                                                                        |
| COPY        | 复制文件                 | build 的时候复制文件到 image 中                                                                                               |
| ADD         | 添加文件                 | build 的时候添加文件到 image 中 不仅仅局限于当前 build 上下文 可以来源于远程服务                                              |
| ENV         | 环境变量                 | 指定 build 时候的环境变量 可以在启动的容器的时候 通过-e 覆盖 格式 ENV name=value                                              |
| ARG         | 构建参数                 | 构建参数 只在构建的时候使用的参数 如果有 ENV 那么 ENV 的相同名字的值始终覆盖 arg 的参数                                       |
| VOLUME      | 定义外部可以挂载的数据卷 | 指定 build 的 image 那些目录可以启动的时候挂载到文件系统中 启动容器的时候使用 -v 绑定 格式 VOLUME ["目录"]                    |
| EXPOSE      | 暴露端口                 | 定义容器运行的时候监听的端口 启动容器的使用-p 来绑定暴露端口 格式: EXPOSE 8080 或者 EXPOSE 8080/udp                           |
| WORKDIR     | 工作目录                 | 指定容器内部的工作目录 如果没有创建则自动创建 如果指定/ 使用的是绝对地址 如果不是/开头那么是在上一条 workdir 的路径的相对路径 |
| USER        | 指定执行用户             | 指定 build 或者启动的时候 用户 在 RUN CMD ENTRYPONT 执行的时候的用户                                                          |
| HEALTHCHECK | 健康检查                 | 指定监测当前容器的健康监测的命令 基本上没用 因为很多时候 应用本身有健康监测机制                                               |
| ONBUILD     | 触发器                   | 当存在 ONBUILD 关键字的镜像作为基础镜像的时候 当执行 FROM 完成之后 会执行 ONBUILD 的命令 但是不影响当前镜像 用处也不怎么大    |
| STOPSIGNAL  | 发送信号量到宿主机       | 该 STOPSIGNAL 指令设置将发送到容器的系统调用信号以退出。                                                                      |
| SHELL       | 指定执行脚本的 shell     | 指定 RUN CMD ENTRYPOINT 执行命令的时候 使用的 shell                                                                           |

### Dockerfile 案例

![image-20230121213857896](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121213857896.png)

![image-20230121213902417](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121213902417.png)

## Docker 服务编排

### 服务编排

微服务架构的应用系统中一般包含若干个微服务，每个微服务一般都会部署多个实例，如果每个微服务都要手动启停，维护的工作量会很大。

-   要从 Dockerfile build image 或者去 dockerhub 拉取 image
-   要创建多个 container
-   要管理这些 container（启动停止删除）

**服务编排**：按照一定的业务规则批量管理容器

### Docker Compose

Docker Compose 是一个编排多容器分布式部署的工具，提供命令集管理容器化应用的完整开发周期，包括服务构建，启动和停止。使用步骤：

1. 利用 Dockerfile 定义运行环境镜像
2. 使用 docker-compose.yml 定义组成应用的各服务
3. 运行 docker-compose up 启动应用

![image-20230121214039425](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121214039425.png)

### Docker Compose 安装使用

#### 一、安装 Docker Compose

```shell
# Compose目前已经完全支持Linux、Mac OS和Windows，在我们安装Compose之前，需要先安装Docker。下面我 们以编译好的二进制包方式安装在Linux系统中。
curl -L https://github.com/docker/compose/releases/download/1.22.0/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose
# 设置文件可执行权限
chmod +x /usr/local/bin/docker-compose
# 查看版本信息
docker-compose -version
```

#### 二、卸载 Docker Compose

```shell
# 二进制包方式安装的，删除二进制文件即可
rm /usr/local/bin/docker-compose
```

#### 三、 使用 docker compose 编排 nginx+springboot 项目

1. 创建 docker-compose 目录

```shell
mkdir ~/docker-compose
cd ~/docker-compose
```

2. 编写 docker-compose.yml 文件

```shell
version: '3'
services:
  nginx:
   image: nginx
   ports:
    - 80:80
   links:
    - app
   volumes:
    - ./nginx/conf.d:/etc/nginx/conf.d
  app:
    image: app
    expose:
      - "8080"
```

3. 创建./nginx/conf.d 目录

```shell
mkdir -p ./nginx/conf.d
```

4. 在./nginx/conf.d 目录下 编写 itheima.conf 文件

```shell
server {
    listen 80;
    access_log off;

    location / {
        proxy_pass http://app:8080;
    }

}
```

5. 在~/docker-compose 目录下 使用 docker-compose 启动容器

```shell
docker-compose up
```

6. 测试访问

```shell
http://192.168.149.135/hello
```

## Docker 私有仓库

Docker 官方的 Docker hub（https://hub.docker.com）是一个用于管理公共镜像的仓库，我们可以从上面拉取镜像到本地，也可以把我们自己的镜像推送上去。但是，有时候我们的服务器无法访问互联网，或者你不希望将自己的镜像放到公网当中，那么我们就需要搭建自己的私有仓库来存储和管理自己的镜像。

### 一、私有仓库搭建

```shell
# 1、拉取私有仓库镜像
docker pull registry
# 2、启动私有仓库容器
docker run -id --name=registry -p 5000:5000 registry
# 3、打开浏览器 输入地址http://私有仓库服务器ip:5000/v2/_catalog，看到{"repositories":[]} 表示私有仓库 搭建成功
# 4、修改daemon.json
vim /etc/docker/daemon.json
# 在上述文件中添加一个key，保存退出。此步用于让 docker 信任私有仓库地址；注意将私有仓库服务器ip修改为自己私有仓库服务器真实ip
{"insecure-registries":["私有仓库服务器ip:5000"]}
# 5、重启docker 服务
systemctl restart docker
docker start registry

```

### 二、将镜像上传至私有仓库

```shell
# 1、标记镜像为私有仓库的镜像
docker tag centos:7 私有仓库服务器IP:5000/centos:7

# 2、上传标记的镜像
docker push 私有仓库服务器IP:5000/centos:7

```

### 三、 从私有仓库拉取镜像

```shell
#拉取镜像
docker pull 私有仓库服务器ip:5000/centos:7
```

## Docker 相关概念

### docker 容器虚拟化 与 传统虚拟机比较

容器就是将软件打包成标准化单元，以用于开发、交付和部署。

-   容器镜像是轻量的、可执行的独立软件包 ，包含软件运行所需的所有内容：代码、运行时环境、系统工具、系统库和设置。
-   容器化软件在任何环境中都能够始终如一地运行
-   容器赋予了软件独立性，使其免受外在环境差异的影响，从而有助于减少团队间在相同基础设施上运行不同软件时的冲突

![image-20230121214302398](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121214302398.png)

相同：

-   容器和虚拟机具有相似的资源隔离和分配优势

不同：

-   容器虚拟化的是操作系统，虚拟机虚拟化的是硬件
-   传统虚拟机可以运行不同的操作系统，容器只能运行同一类型操作系统

![image-20230121214338005](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121214338005.png)

![image-20230121214342418](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121214342418.png)

![image-20230121214346500](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20230121214346500.png)
