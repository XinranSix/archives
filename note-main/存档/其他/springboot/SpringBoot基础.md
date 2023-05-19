# SpringBoot 基础

![37d12f2eb9389b503a80d4b38b35e5dde6116ed7](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/37d12f2eb9389b503a80d4b38b35e5dde6116ed7.png)

## 一、创建 SprinBoot 项目

这里记录 4 种创建 SpringBoot 项目的方式。

### 1.1 直接在 IDEA 中创建

**步骤 1**：创建新模块，选择 Spring Initializr，并配置模块相关基础信息。

![image-20211116125259385](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211116125259385.png)

> 此处 IDEA 要联网。

**步骤 2**：选择当前模块需要使用的技术集。

![image-20211116125615728](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211116125615728.png)

> 此处选择需要的功能，例如如果需要 Spring MVC 的功能，就在 Web 中选择 Spring Web.

**步骤 3**：开发控制器类。

```java
//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public String getById(){
        System.out.println("springboot is running...");
        return "springboot is running...";
    }
}
```

> `@RestController` 注解是 `@Controller` 注解和 `@ResponseBody` 注解的组合。

**步骤 4**：运行自动生成的 Application 类.

![image-20211116130152452](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211116130152452.png)

使用带 main 方法的 Java 程序的运行形式来运行程序，运行完毕后，控制台输出上述信息。

> 选择了 Web 模块的 SpringBoot 程序会内嵌 Tomcat 服务器，所以此处无需配置 Tomcat 服务器即可运行 Web 程序。

### 1.2 在 SpringBoot 官网中制作 SpringBoot 程序

[点我](https://start.spring.io/)

**步骤 1**：进入创建 SpringBoot 程序的界面上，下面是输入信息的过程，和前面的一样，只是界面变了而已，根据自己的要求，在左侧选择对应信息和输入对应的信息即可。

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211122150608039.png" alt="image-20211122150608039"  />

**步骤 2**：右侧的 ADD DEPENDENCIES 用于选择使用何种技术，和之前勾选的 Spring WEB 是在做同一件事，仅仅是界面不同而已，点击后打开网页版的技术选择界面。

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211122161257361.png" alt="image-20211122161257361" style="zoom:50%;" />

**步骤 3**：所有信息设置完毕后，点击下面左侧按钮，生成一个文件包。

**步骤 4**：保存后得到一个压缩文件，这个文件打开后就是创建的 SpringBoot 工程文件夹了。

**步骤 5**：解压缩此文件后，得到工程目录，在 IDEA 中导入即可使用，和之前创建的东西完全一样。下面就可以自己创建一个 Controller 测试一下是否能用了。

> 从这里可以看出，IDEA 在创建 SpringBoot 工程的时候，实际上是连接到了 SpringBoot 的官网。

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211122162443035.png" alt="image-20211122162443035" style="zoom: 67%;" />

### 1.3 基于阿里云制作 SpringBoot 程序。

创建工程时，切换选择 starter 服务路径，然后手工收入阿里云提供给我们的使用地址即可。地址：http://start.aliyun.com 或 https://start.aliyun.com

![image-20211122163605950](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211122163605950.png)

然后选择要用的功能即可创建项目。

### 1.4 手动创建项目

**步骤 1**：先创建一个空的 Maven 工程。

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211122165341684.png" alt="image-20211122165341684" style="zoom:50%;" />

**步骤 2**：参照标准 SpringBoot 工程的 pom 文件，书写自己的 pom 文件即可。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.4</version>
    </parent>

    <groupId>自己的 groupId</groupId>
    <artifactId>自己的 artifactId</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

</project>
```

**步骤 4**：之前运行 SpringBoot 工程需要一个类，这个缺不了，自己手写一个就行了，建议按照之前的目录结构来创建，先别玩花样，先学走后学跑。类名可以自定义，关联的名称一切修改即可。

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(<Application.class);
    }
}
```

> 注意：引导类上的 `@SpringBootApplication` 注解不要忘记写了。

### 1.5 SpringBoot 简介

SpringBoot 是由 Pivotal 团队提供的全新框架，其设计目的是用来<font color="#ff0000"><b>简化 Spring 应用的初始搭建以及开发过程</b></font>。

都简化了了哪些东西呢？其实就是针对原始的 Spring 程序制作的两个方面进行了简化：

-   Spring 程序缺点:
    -   依赖设置繁琐
        -   以前写 Spring 程序，使用的技术都要自己一个一个的写，现在不需要了。
    -   配置繁琐
        -   以前写配置类或者配置文件，然后用什么东西就要自己写加载 bean 这些东西，现在不需要了。

这些简化操作在 SpringBoot 中有专业的用语，也是 SpringBoot 程序的核心功能及优点：

-   起步依赖（简化依赖配置）
    -   依赖配置的书写简化就是靠这个起步依赖达成的。
-   自动配置（简化常用工程相关配置）
    -   配置过于繁琐，使用自动配置就可以做响应的简化，但是内部还是很复杂的，后面具体展开说。
-   辅助功能（内置服务器，……）
    -   除了上面的功能，其实 SpringBoot 程序还有其他的一些优势，比如我们没有配置 Tomcat 服务器，但是能正常运行，这是 SpringBoot 程序的一个可以感知到的功能，也是 SpringBoot 的辅助功能之一。

下面结合入门程序来说说这些简化操作都在哪些方面进行体现的，一共分为 4 个方面：

-   parent
-   starter
-   引导类
-   内嵌 tomcat

#### 1.5.1 parent

SpringBoot 关注到开发者在进行开发时，往往对依赖版本的选择具有固定的搭配格式，并且这些依赖版本的选择还不能乱搭配。比如 A 技术的 2.0 版与 B 技术的 3.5 版可以合作在一起，但是和 B 技术的 3.7 版合并使用时就有冲突。其实很多开发者都一直想做一件事情，就是将各种各样的技术配合使用的常见依赖版本进行收集整理，制作出了最合理的依赖版本配置方案，这样使用起来就方便多了。

SpringBoot 一看这种情况 so easy 啊，于是将所有的技术版本的常见使用方案都给开发者整理了出来，以后开发者使用时直接用它提供的版本方案，就不用担心冲突问题了，相当于 SpringBoot 做了无数个技术版本搭配的列表，这个技术搭配列表的名字叫做 <font color="#ff0000"><b>parent</b></font>。

<font color="#ff0000"><b>parent</b></font> 自身具有很多个版本，每个 <font color="#ff0000"><b>parent</b></font> 版本中包含有几百个其他技术的版本号，不同的 parent 间使用的各种技术的版本号有可能会发生变化。当开发者使用某些技术时，直接使用 SpringBoot 提供的 <font color="#ff0000"><b>parent</b></font> 就行了，由 <font color="#ff0000"><b>parent</b></font> 帮助开发者统一的进行各种技术的版本管理

比如你现在要使用 Spring 配合 MyBatis 开发，没有 parent 之前怎么做呢？选个 Spring 的版本，再选个 MyBatis 的版本，再把这些技术使用时关联的其他技术的版本逐一确定下来。当你 Spring 的版本发生变化需要切换时，你的 MyBatis 版本有可能也要跟着切换，关联技术呢？可能都要切换，而且切换后还可能出现问题。现在这一切工作都可以交给 parent 来做了。你无需关注这些技术间的版本冲突问题，你只需要关注你用什么技术就行了，冲突问题由 <font color="#ff0000"><b>parent</b></font> 负责处理。

有人可能会提出来，万一 <font color="#ff0000"><b>parent</b></font> 给我导入了一些我不想使用的依赖怎么办？记清楚，这一点很关键，<font color="#ff0000"><b>parent</b></font> 仅仅帮我们进行版本管理，它不负责帮你导入坐标，说白了用什么还是你自己定，只不过版本不需要你管理了。整体上来说，<font color="#ff0000"><b>使用 parent 可以帮助开发者进行版本的统一管理</b></font>。

<font color="#ff0000"><b>关注</b></font>：parent 定义出来以后，并不是直接使用的，仅仅给了开发者一个说明书，但是并没有实际使用，这个一定要确认清楚。

那 SpringBoot 又是如何做到这一点的呢？可以查阅 SpringBoot 的配置源码，看到这些定义。

-   项目中的 pom.xml 中继承了一个坐标。

```XML
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.5.4</version>
</parent>
```

-   打开后可以查阅到其中又继承了一个坐标。

```XML
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-dependencies</artifactId>
    <version>2.5.4</version>
</parent>
```

-   这个坐标中定义了两组信息，第一组是各式各样的依赖版本号属性，下面列出依赖版本属性的局部，可以看的出来，定义了若干个技术的依赖版本号。

```XML
<properties>
    <activemq.version>5.16.3</activemq.version>
    <aspectj.version>1.9.7</aspectj.version>
    <assertj.version>3.19.0</assertj.version>
    <commons-codec.version>1.15</commons-codec.version>
    <commons-dbcp2.version>2.8.0</commons-dbcp2.version>
    <commons-lang3.version>3.12.0</commons-lang3.version>
    <commons-pool.version>1.6</commons-pool.version>
    <commons-pool2.version>2.9.0</commons-pool2.version>
    <h2.version>1.4.200</h2.version>
    <hibernate.version>5.4.32.Final</hibernate.version>
    <hibernate-validator.version>6.2.0.Final</hibernate-validator.version>
    <httpclient.version>4.5.13</httpclient.version>
    <jackson-bom.version>2.12.4</jackson-bom.version>
    <javax-jms.version>2.0.1</javax-jms.version>
    <javax-json.version>1.1.4</javax-json.version>
    <javax-websocket.version>1.1</javax-websocket.version>
    <jetty-el.version>9.0.48</jetty-el.version>
    <junit.version>4.13.2</junit.version>
</properties>
```

第二组是各式各样的的依赖坐标信息，可以看出依赖坐标定义中没有具体的依赖版本号，而是引用了第一组信息中定义的依赖版本属性值。

```XML
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>${hibernate.version}</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```

<font color="#ff0000"><b>关注</b></font>：上面的依赖坐标定义是出现在 \<dependencyManagement\> 标签中的，其实是对引用坐标的依赖管理，并不是实际使用的坐标。因此当你的项目中继承了这组 parent 信息后，在不使用对应坐标的情况下，前面的这组定义是不会具体导入某个依赖的。

<font color="#ff0000"><b>关注</b></font>：因为在 maven 中继承机会只有一次，上述继承的格式还可以切换成导入的形式进行，并且在阿里云的 starter 创建工程时就使用了此种形式。

```XML
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>${spring-boot.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

**总结**

1. 开发 SpringBoot 程序要继承 spring-boot-starter-parent；
2. spring-boot-starter-parent 中定义了若干个依赖管理；
3. 继承 parent 模块可以避免多个依赖使用相同技术时出现依赖版本冲突；
4. 继承 parent 的形式也可以采用引入依赖的形式实现效果。

#### 1.5.2 starter

SpringBoot 关注到开发者在实际开发时，对于依赖坐标的使用往往都有一些固定的组合方式，比如使用 spring-webmvc 就一定要使用 spring-web。每次都要固定搭配着写，非常繁琐，而且格式固定，没有任何技术含量。

SpringBoot 一看这种情况，看来需要给开发者带来一些帮助了。安排，把所有的技术使用的固定搭配格式都给开发出来，以后你用某个技术，就不用一次写一堆依赖了，还容易写错，我给你做一个东西，代表一堆东西，开发者使用的时候，直接用我做好的这个东西就好了，对于这样的固定技术搭配，SpringBoot 给它起了个名字叫做 <font color="#ff0000"><b>starter</b></font>。

starter 定义了使用某种技术时对于依赖的固定搭配格式，也是一种最佳解决方案，<font color="#ff0000"><b>使用 starter 可以帮助开发者减少依赖配置</b></font>。

这个东西其实在入门案例里面已经使用过了，入门案例中的 web 功能就是使用这种方式添加依赖的。可以查阅 SpringBoot 的配置源码，看到这些定义

-   项目中的 pom.xml 定义了使用 SpringMVC 技术，但是并没有写 SpringMVC 的坐标，而是添加了一个名字中包含 starter 的依赖。

```XML
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

-   在 spring-boot-starter-web 中又定义了若干个具体依赖的坐标。

```XML
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
        <version>2.5.4</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-json</artifactId>
        <version>2.5.4</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <version>2.5.4</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>5.3.9</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.3.9</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

之前提到过开发 SpringMVC 程序需要导入 spring-webmvc 的坐标和 spring 整合 web 开发的坐标，就是上面这组坐标中的最后两个了。

但是我们发现除了这两个还有其他的，比如第二个，叫做 s pring-boot-starter-json。看名称就知道，这个是与 json 有关的坐标了，但是看名字发现和最后两个又不太一样，它的名字中也有 starter，打开看看里面有什么？

```XML
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
        <version>2.5.4</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>5.3.9</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.12.4</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.datatype</groupId>
        <artifactId>jackson-datatype-jdk8</artifactId>
        <version>2.12.4</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.datatype</groupId>
        <artifactId>jackson-datatype-jsr310</artifactId>
        <version>2.12.4</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.module</groupId>
        <artifactId>jackson-module-parameter-names</artifactId>
        <version>2.12.4</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

我们可以发现，这个 starter 中又包含了若干个坐标，其实就是使用 SpringMVC 开发通常都会使用到 json，使用 json 又离不开这里面定义的这些坐标，看来还真是方便，SpringBoot 把我们开发中使用的东西能用到的都给提前做好了。你仔细看完会发现，里面有一些你没用过的。的确会出现这种过量导入的可能性，没关系，可以通过 maven 中的排除依赖剔除掉一部分。不过你不管它也没事，大不了就是过量导入呗。

到这里基本上得到了一个信息，使用 starter 可以帮开发者快速配置依赖关系。以前写依赖 3 个坐标的，现在写导入一个就搞定了，就是加速依赖配置的。

**starter 与 parent 的区别**

朦朦胧胧中感觉 starter 与 parent 好像都是帮助我们简化配置的，但是功能又不一样，梳理一下。

<font color="#ff0000"><b>starter</b></font> 是一个坐标中定了若干个坐标，以前写多个的，现在写一个，<font color="#ff0000"><b>是用来减少依赖配置的书写量的</b></font>。

<font color="#ff0000"><b>parent</b></font> 是定义了几百个依赖版本号，以前写依赖需要自己手工控制版本，现在由 SpringBoot 统一管理，这样就不存在版本冲突了，<font color="#ff0000"><b>是用来减少依赖冲突的</b></font>。

**实际开发应用方式**

-   实际开发中如果需要用什么技术，先去找有没有这个技术对应的 starter.

    -   如果有对应的 starter，直接写 starter，而且无需指定版本，版本由 parent 提供.
    -   如果没有对应的 starter，手写坐标即可

-   实际开发中如果发现坐标出现了冲突现象，确认你要使用的可行的版本号，使用手工书写的方式添加对应依赖，覆盖 SpringBoot 提供给我们的配置管理

    -   方式一：直接写坐标
    -   方式二：覆盖 \<properties\>中定义的版本号，就是下面这堆东西了，哪个冲突了覆盖哪个就 OK 了。

    ```XML
    <properties>
        <activemq.version>5.16.3</activemq.version>
        <aspectj.version>1.9.7</aspectj.version>
        <assertj.version>3.19.0</assertj.version>
        <commons-codec.version>1.15</commons-codec.version>
        <commons-dbcp2.version>2.8.0</commons-dbcp2.version>
        <commons-lang3.version>3.12.0</commons-lang3.version>
        <commons-pool.version>1.6</commons-pool.version>
        <commons-pool2.version>2.9.0</commons-pool2.version>
        <h2.version>1.4.200</h2.version>
        <hibernate.version>5.4.32.Final</hibernate.version>
        <hibernate-validator.version>6.2.0.Final</hibernate-validator.version>
        <httpclient.version>4.5.13</httpclient.version>
        <jackson-bom.version>2.12.4</jackson-bom.version>
        <javax-jms.version>2.0.1</javax-jms.version>
        <javax-json.version>1.1.4</javax-json.version>
        <javax-websocket.version>1.1</javax-websocket.version>
        <jetty-el.version>9.0.48</jetty-el.version>
        <junit.version>4.13.2</junit.version>
    </properties>
    ```

<font color="#f0f"><b>温馨提示</b></font>

SpringBoot 官方给出了好多个 starter 的定义，方便我们使用，而且名称都是如下格式。

```JAVA
命名规则：spring-boot-starter-技术名称
```

所以以后见了 spring-boot-starter-aaa 这样的名字，这就是 SpringBoot 官方给出的 starter 定义。那非官方定义的也有吗？有的，具体命名方式到整合章节再说。

**总结**

1. 开发 SpringBoot 程序需要导入坐标时通常导入对应的 starter.
2. 每个不同的 starter 根据功能不同，通常包含多个依赖坐标；
3. 使用 starter 可以实现快速配置的效果，达到简化配置的目的；

#### 1.5.3 引导类

配置说完了，我们发现 SpringBoot 确实帮助我们减少了很多配置工作，下面说一下程序是如何运行的。目前程序运行的入口就是 SpringBoot 工程创建时自带的那个类了，带有 main 方法的那个类，运行这个类就可以启动 SpringBoot 工程的运行。

```java
@SpringBootApplication
public class Springboot0101QuickstartApplication {
    public static void main(String[] args) {
        SpringApplication.run(Springboot0101QuickstartApplication.class, args);
    }
}
```

SpringBoot 本身是为了加速 Spring 程序的开发的，而 Spring 程序运行的基础是需要创建自己的 Spring 容器对象（IoC 容器）并将所有的对象交给 Spring 的容器管理，也就是一个一个的 Bean。那还了 SpringBoot 加速开发 Spring 程序，这个容器还在吗？这个疑问不用说，一定在。当前这个类运行后就会产生一个 Spring 容器对象，并且可以将这个对象保存起来，通过容器对象直接操作 Bean。

```JAVA
@SpringBootApplication
public class Springboot0101QuickstartApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot0101QuickstartApplication.class, args);
        BookController bean = ctx.getBean(BookController.class);
        System.out.println("bean======>" + bean);
    }
}
```

通过上述操作不难看出，其实 SpringBoot 程序启动还是创建了一个 Spring 容器对象。这个类在 SpringBoot 程序中是所有功能的入口，称这个类为<font color="#ff0000"><b>引导类</b></font>。

作为一个引导类最典型的特征就是当前类上方声明了一个注解 <font color="#ff0000"><b>@SpringBootApplication</b></font>

**总结**

1. SpringBoot 工程提供引导类用来启动程序；
2. SpringBoot 工程启动后创建并初始化 Spring 容器。

#### 1.5.4 内嵌 Tomcat

当前我们做的 SpringBoot 入门案例勾选了 Spirng-web 的功能，并且导入了对应的 starter。

```XML
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

SpringBoot 发现，既然你要做 web 程序，肯定离不开使用 web 服务器，这样吧，帮人帮到底，送佛送到西。我帮你搞一个 web 服务器，你要愿意用的，直接使用就好了，干脆我再多给你几种选择，你随便切换。万一你不想用我给你提供的，也行，你可以自己搞。

由于这个功能不属于程序的主体功能，可用可不用，于是乎 SpringBoot 将其定位成辅助功能，别小看这么一个辅助功能，它可是帮我们开发者又减少了好多的设置性工作。

下面就围绕着这个内置的 web 服务器，也可以说是内置的 Tomcat 服务器来研究几个问题。

1. 这个服务器在什么位置定义的
2. 这个服务器是怎么运行的
3. 这个服务器如果想换怎么换？虽然这个需求很垃圾，搞得开发者会好多 web 服务器一样，用别人提供好的不香么？非要自己折腾

**内嵌 Tomca t 定义位置**

说到定义的位置，我们就想，如果我们不开发 web 程序，用的着 web 服务器吗？肯定用不着啊。那如果这个东西被加入到你的程序中，伴随着什么技术进来的呢？肯定是 web 相关的功能啊，没错，就是前面导入的 web 相关的 starter 做的这件事。

```XML
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

打开查看 web 的 starter 导入了哪些东西：

```XML
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
        <version>2.5.4</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-json</artifactId>
        <version>2.5.4</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <version>2.5.4</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>5.3.9</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.3.9</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

第三个依赖就是这个 Tomcat 对应的东西了，居然也是一个 starter，再打开看看：

```XML
<dependencies>
    <dependency>
        <groupId>jakarta.annotation</groupId>
        <artifactId>jakarta.annotation-api</artifactId>
        <version>1.3.5</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-core</artifactId>
        <version>9.0.52</version>
        <scope>compile</scope>
        <exclusions>
            <exclusion>
                <artifactId>tomcat-annotations-api</artifactId>
                <groupId>org.apache.tomcat</groupId>
            </exclusion>
        </exclusions>
    </dependency>
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-el</artifactId>
        <version>9.0.52</version>
        <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-websocket</artifactId>
        <version>9.0.52</version>
        <scope>compile</scope>
        <exclusions>
            <exclusion>
                <artifactId>tomcat-annotations-api</artifactId>
                <groupId>org.apache.tomcat</groupId>
            </exclusion>
        </exclusions>
    </dependency>
</dependencies>
```

这里面有一个核心的坐标，tomcat-embed-core，叫做 Tomcat 内嵌核心。就是这个东西把 Tomcat 功能引入到了我们的程序中。目前解决了第一个问题，找到根儿了，谁把 Tomcat 引入到程序中的？spring-boot-starter-web 中的 spring-boot-starter-tomcat 做的。之所以你感觉很奇妙的原因就是，这个东西是默认加入到程序中了，所以感觉很神奇，居然什么都不做，就有了 web 服务器对应的功能，再来说第二个问题，这个服务器是怎么运行的。

**内嵌 Tomcat 运行原理**

Tomcat 服务器是一款软件，而且是一款使用 Java 语言开发的软件，熟悉的小伙伴可能有印象，Tomcat 安装目录中保存有 jar。

下面的问题来了，既然是使用 Java 语言开发的，运行的时候肯定符合 Java 程序运行的原理，Java 程序运行靠的是什么？对象呀，一切皆对象，万物皆对象。那 Tomcat 运行起来呢？也是对象。

如果是对象，那 Spring 容器是用来管理对象的，这个对象能不能交给 Spring 容器管理呢？把吗去掉，是个对象都可以交给 Spring 容器管理，行了，这下通了。 Tomcat 服务器运行其实是以对象的形式在 Spring 容器中运行的，怪不得我们没有安装这个 Tomcat，而且还能用。闹了白天这东西最后是以一个对象的形式存在，保存在 Spring 容器中悄悄运行的。具体运行的是什么呢？其实就是上前面提到的那个 Tomcat 内嵌核心。

```XML
<dependencies>
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-core</artifactId>
        <version>9.0.52</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```

那既然是个对象，如果把这个对象从 Spring 容器中去掉是不是就没有 web 服务器的功能呢？是这样的，通过依赖排除可以去掉这个 web 服务器功能。

```XML
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <exclusions>
            <exclusion>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-tomcat</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
</dependencies>
```

上面对 web-starter 做了一个操作，使用 maven 的排除依赖去掉了使用 Tomcat 的 starter。这下好了，容器中肯定没有这个对象了，重新启动程序可以观察到程序运行了，但是并没有像之前那样运行后会等着用户发请求，而是直接停掉了，就是这个原因了。

**更换内嵌 Tomcat**

那根据上面的操作我们思考是否可以换个服务器呢？必须的嘛。根据 SpringBoot 的工作机制，用什么技术，加入什么依赖就行了。SpringBoot 提供了 3 款内置的服务器

-   Tomcat（默认）：Apache 出品，粉丝多，应用面广，负载了若干较重的组件。

-   Jetty：更轻量级，负载性能远不及 Tomcat.

-   Undertow：负载性能勉强跑赢 Tomcat.

想用哪个，加个坐标就 OK。前提是把 Tomcat 排除掉，因为 Tomcat 是默认加载的。

```XML
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <exclusions>
            <exclusion>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-tomcat</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jetty</artifactId>
    </dependency>
</dependencies>
```

现在就已经成功替换了 web 服务器，核心思想就是用什么加入对应坐标就可以了。如果有 starter，优先使用 starter。

**总结**

1. 内嵌 Tomcat 服务器是 SpringBoot 辅助功能之一。
2. 内嵌 Tomcat 工作原理是将 Tomcat 服务器作为对象运行，并将该对象交给 Spring 容器管理。
3. 变更内嵌服务器思想是去除现有服务器，添加全新的服务器。

## 二、SpringBoot 基础配置

### 2.1 属性配置

SpringBoot 通过配置文件 application.properties 就可以修改默认的配置，先找个简单的配置下手，当前访问 tomcat 的默认端口是 8080，可以改成 80.

![image-20211123165428245](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211123165428245.png)

输入 port，会提示 `server.port` 设置为 80 就将端口设置为了 80.

```properties
server.port=80
```

到这里可以得到如下三个信息：

1. SpringBoot 程序可以在 application.properties 文件中进行属性配置。
2. application.properties 文件中只要输入要配置的属性关键字就可以根据提示进行设置。
3. SpringBoot 将配置信息集中在一个文件中写，不管你是服务器的配置，还是数据库的配置，总之都写在一起，逃离一个项目十几种配置文件格式的尴尬局面。

**总结**

1. SpringBoo t 默认配置文件是 application.properties.

来看看其他配置。

**关闭运行日志图表（banner)**

```properties
spring.main.banner-mode=off
```

**设置运行日志的显示级别**

```properties
logging.level.root=debug
```

如果要查询配置，可以打开 SpringBoot 的官网，找到 SpringBoot 官方文档，打开查看附录中的 Application Properties 就可以获取到对应的配置项了，[网址](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties)。

<font color="#f0f"><b>温馨提示</b></font>

所有的 starter 中都会依赖下面这个 starter，叫做 spring-boot-starter。这个 starter 是所有的 SpringBoot 的 starter 的基础依赖，里面定义了 SpringBoot 相关的基础配置。

```JAVA
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>2.5.4</version>
    <scope>compile</scope>
</dependency>
```

**总结**

1. SpringBoot 中导入对应 starter 后，提供对应配置属性。
2. 书写 SpringBoot 配置采用关键字+提示形式书写。

### 2.2 配置文件分类

SpringBoot 三种格式的配置文件，分别如下:

-   properties 格式
-   yml 格式
-   yaml 格式

分别使用上面 3 种格式配置 Tomcat 端口号如下：

-   application.properties（properties 格式）

```properties
server.port=80
```

-   application.yml（yml 格式）

```YML
server:
  port: 81
```

-   application.yaml（yaml 格式）

```yaml
server:
  port: 82
```

**总结**

1. SpringBoot 提供了 3 种配置文件的格式：
    - properties（传统格式/默认格式）
    - **yml**（主流格式）
    - yaml

#### 2.2.1 配置文件优先级

1. 配置文件间的加载优先级 properties（最高）> yml > yaml（最低）。
2. 不同配置文件中相同配置按照加载优先级相互覆盖，不同配置文件中不同配置全部保留。

#### 2.2.2 **自动提示功能消失解决方案**

**步骤 1**：打开设置，【Files】→【Project Structure...】

![image-20211126160548690](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211126160548690.png)

**步骤 2**：在弹出窗口中左侧选择【Facets】，右侧选中 Spring 路径下对应的模块名称，也就是你自动提示功能消失的那个模块。

![image-20211126160726589](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211126160726589.png)![image-20211126160844372](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211126160844372.png)

**步骤 3**：点击 Customize Spring Boot 按钮，此时可以看到当前模块对应的配置文件是哪些了。如果没有你想要称为配置文件的文件格式，就有可能无法弹出提示。

![image-20211126160946448](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211126160946448.png)![image-20211126160954338](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211126160954338.png)

**步骤 4**：选择添加配置文件，然后选中要作为配置文件的具体文件就 OK 了。

![image-20211126161145082](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211126161145082.png)<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211126161156324.png" alt="image-20211126161156324" style="zoom:80%;" />

**总结**

1. 指定 SpringBoot 配置文件

    - Setting → Project Structure → Facets
    - 选中对应项目/工程
    - Customize Spring Boot
    - 选择配置文件

### 2.3 yaml 文件

YAML（YAML Ain't Markup Language），一种数据序列化格式。具有容易阅读、容易与脚本语言交互、以数据为核心，重数据轻格式的特点。常见的文件扩展名有两种：

-   .yml 格式（主流）;
-   .yaml 格式。

对于文件自身在书写时，具有严格的语法格式要求，具体如下：

1. 大小写敏感；
2. 属性层级关系使用多行描述，**每行结尾使用冒号结束**；
3. 使用缩进表示层级关系，同层级左侧对齐，只允许使用空格（不允许使用 Tab 键）；
4. 属性值前面添加空格（属性名与属性值之间使用冒号 + 空格作为分隔）。
5. \# 号表示注释

上述规则不要死记硬背，按照书写习惯慢慢适应，并且在 IDEA 下由于具有提示功能，慢慢适应着写格式就行了。核心的一条规则要记住，<font color="#ff0000"><b>数据前面要加空格与冒号隔开。</b></font>

下面列出常见的数据书写格式，熟悉一下：

```YAML
boolean: TRUE  						#TRUE,true,True,FALSE,false，False均可
float: 3.14    						#6.8523015e+5  #支持科学计数法
int: 123       						#0b1010_0111_0100_1010_1110    #支持二进制、八进制、十六进制
null: ~        						#使用~表示null
string: HelloWorld      			#字符串可以直接书写
string2: "Hello World"  			#可以使用双引号包裹特殊字符
date: 2018-02-17        			#日期必须使用yyyy-MM-dd格式
datetime: 2018-02-17T15:02:31+08:00  #时间和日期之间使用T连接，最后使用+代表时区
```

此外，yaml 格式中也可以表示数组，在属性名书写位置的下方使用减号作为数据开始符号，每行书写一个数据，减号与数据间空格分隔。

```YAML
subject:
	- Java
	- 前端
	- 大数据
enterprise:
	name: itcast
    age: 16
    subject:
    	- Java
        - 前端
        - 大数据
likes: [王者荣耀,刺激战场]			#数组书写缩略格式
users:							 #对象数组格式一
  - name: Tom
   	age: 4
  - name: Jerry
    age: 5
users:							 #对象数组格式二
  -
    name: Tom
    age: 4
  -
    name: Jerry
    age: 5
users2: [ { name:Tom , age:4 } , { name:Jerry , age:5 } ]	#对象数组缩略格式
```

**总结**

1. yaml 语法规则：
    - 大小写敏感；
    - 属性层级关系使用多行描述，每行结尾使用冒号结束；
    - 使用缩进表示层级关系，同层级左侧对齐，只允许使用空格（不允许使用 Tab 键）；
    - 属性值前面添加空格（属性名与属性值之间使用冒号 + 空格作为分隔）；
    - \# 号 表示注释。
2. 注意属性名冒号后面与数据之间有一个**空格**；
3. 字面值、对象数据格式、数组数据格式。

### 2.4 yaml 数据读取

对于 yaml 文件中的数据，其实你就可以想象成这就是一个小型的数据库，里面保存有若干数据，每个数据都有一个独立的名字，如果你想读取里面的数据，肯定是支持的，下面就介绍 3 种读取数据的方式。

#### 2.4.1 读取单一数据

yaml 中保存的单个数据，可以使用 Spring 中的注解直接读取，使用可以读取单个数据，属性名引用方式：<font color="#ff0000"><b>${一级属性名.二级属性名……}</b></font>

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211126180433356.png" alt="image-20211126180433356" style="zoom:80%;" />

记得使用 `@Value` 注解时，要将该注入写在某一个指定的 Spring 管控的 bean 的属性名上方。现在就可以读取到对应的单一数据了。

**总结**

1. 使用 `@Value` 配合 SpEL 读取单个数据；
2. 如果数据存在多层级，依次书写层级名称即可。

#### 2.4.2 读取全部数据

读取单一数据可以解决读取数据的问题，但是如果定义的数据量过大，这么一个一个书写肯定会累死人的，SpringBoot 提供了一个对象，能够把所有的数据都封装到这一个对象中，这个对象叫做 Environment，使用自动装配注解可以将所有的 yaml 数据封装到这个对象中。

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211126180738569.png" alt="image-20211126180738569" style="zoom:80%;" />

数据封装到了 Environment 对象中，获取属性时，通过 Environment 的接口操作进行，具体方法时 `getProperties(String)`，参数填写属性名即可。

**总结**

1. 使用 `Environment` 对象封装全部配置信息；
2. 使用 `@Autowired` 自动装配数据到 `Environmnt` 对象中。

#### 2.4.3 读取对象数据

单一数据读取书写比较繁琐，全数据封装又封装的太厉害了，每次拿数据还要一个一个的 `getProperties()`，总之用起来都不是很舒服。由于 Java 是一个面向对象的语言，很多情况下，我们会将一组数据封装成一个对象。SpringBoot 也提供了可以将一组 yaml 对象数据封装一个 Java 对象的操作

首先定义一个对象，并将该对象纳入 Spring 管控的范围，也就是定义成一个 bean，然后使用注解 `@ConfigurationProperties` 指定该对象加载哪一组 yaml 中配置的信息。

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211126181126382.png" alt="image-20211126181126382" style="zoom:80%;" />

`@ConfigurationProperties` 必须告诉他加载的数据前缀是什么，这样当前前缀下的所有属性就封装到这个对象中。记得数据属性名要与对象的变量名一一对应啊，不然没法封装。其实以后如果你要定义一组数据自己使用，就可以先写一个对象，然后定义好属性，下面到配置中根据这个格式书写即可。

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211126181423432.png" alt="image-20211126181423432" style="zoom:80%;" />

**总结**

1. 使用 `@ConfigurationProperties` 注解绑定配置信息到封装类中。
2. 封装类需要定义为 Spring 管理的 bean，否则无法进行属性注入。

#### 2.4.4 yaml 文件中的数据引用

如果你在书写 yaml 数据时，经常出现如下现象，比如很多个文件都具有相同的目录前缀。

```YAML
center:
	dataDir: /usr/local/fire/data
    tmpDir: /usr/local/fire/tmp
    logDir: /usr/local/fire/log
    msgDir: /usr/local/fire/msgDir
```

或者

```YAML
center:
	dataDir: D:/usr/local/fire/data
    tmpDir: D:/usr/local/fire/tmp
    logDir: D:/usr/local/fire/log
    msgDir: D:/usr/local/fire/msgDir
```

这个时候你可以使用引用格式来定义数据，其实就是搞了个变量名，然后引用变量了，格式如下：

```YAML
baseDir: /usr/local/fire
center:
    dataDir: ${baseDir}/data
    tmpDir: ${baseDir}/tmp
    logDir: ${baseDir}/log
    msgDir: ${baseDir}/msgDir
```

还有一个注意事项，在书写字符串时，如果需要使用转义字符，需要将数据字符串使用双引号包裹起来。

```YAML
lesson: "Spring\tboot\nlesson"
```

**总结**

1. 在配置文件中可以使用${属性名}方式引用属性值；
2. 如果属性中出现特殊字符，可以使用双引号包裹起来作为字符解析。

## 三、SpringBoot 整合 JUnit、MyBatis、MyBatis-Plus、Druid

### 3.1 整合 JUnit

在不用 SpringBoot 的前提下，Spring 整合 JUnit 的方式如下：

```java
//加载spring整合junit专用的类运行器
@RunWith(SpringJUnit4ClassRunner.class)
//指定对应的配置信息
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTestCase {
    //注入你要测试的对象
    @Autowired
    private AccountService accountService;
    @Test
    public void testGetById(){
        //执行要测试的对象对应的方法
        System.out.println(accountService.findById(2));
    }
}

```

使用 SpringBoot 整合 JUnit 的方式如下：

```java
@SpringBootTest
class Springboot04JunitApplicationTests {
    //注入你要测试的对象
    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        //执行要测试的对象对应的方法
        bookDao.save();
        System.out.println("two...");
    }
}
```

如果测试类不在引导类的同一包或子包下，需要指定引导类，在 SpringBoot 中可以直接在 `@SpringBootTest` 的 `classes` 属性中指定，方式如下所示：

```java
@SpringBootTest(classes = Springboot04JunitApplication.class)
class Springboot04JunitApplicationTests {
    //注入你要测试的对象
    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        //执行要测试的对象对应的方法
        bookDao.save();
        System.out.println("two...");
    }
}
```

或者使用原始的 `@ContextConfiguration` 注解进行指定：

```java
@SpringBootTest
@ContextConfiguration(classes = Springboot04JunitApplication.class)
class Springboot04JunitApplicationTests {
    //注入你要测试的对象
    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        //执行要测试的对象对应的方法
        bookDao.save();
        System.out.println("two...");
    }
}
```

> 注意：使用 SpringBoot 整合 JUnit 需要保障导入 test 对应的 starter.

**总结**

1. 导入测试对应的 starter；
2. 测试类使用 `@SpringBootTest` 修饰；
3. 使用自动装配的形式添加要测试的对象；
4. 测试类如果存在于引导类所在包或子包中无需指定引导类；
5. 测试类如果不存在于引导类所在的包或子包中需要通过 `classes` 属性指定引导类。

### 3.2 整合 MyBatis

**步骤 1**：创建模块时勾选要使用的技术，MyBatis，由于要操作数据库，还要勾选对应数据库驱动。

![image-20211129092156020](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211129092156020.png)

![image-20211129092210993](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211129092210993.png)

或者手工导入对应技术的 starter，和对应数据库的坐标。

```xml
<dependencies>
    <!--1.导入对应的starter-->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.2.0</version>
    </dependency>

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

**步骤 3**：配置数据源相关信息。

```yml
#2.配置相关信息
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://ip:port/database
    username: username
    password: password
```

至此，配置完成，接下来给出一个示例。

**实体类**

```java
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
```

**映射接口（Dao）**

```java
@Mapper
public interface BookDao {
    @Select("select * from tbl_book where id = #{id}")
    public Book getById(Integer id);
}
```

**测试类**

```java
@SpringBootTest
class BooKDaoTests {
    @Autowired
    private BookDao bookDao;
    @Test
    void contextLoads() {
        System.out.println(bookDao.getById(1));
    }
}
```

注意：当前使用的 SpringBoot 版本是 2.5.4，对应的坐标设置中 Mysql 驱动使用的是 8.x 版本。当 SpringBoot2.4.3（不含）版本之前会出现一个小 BUG，就是 MySQL 驱动升级到 8 以后要求强制配置时区，如果不设置会出问题。解决方案很简单，驱动 url 上面添加上对应设置就行了

```yml
#2.配置相关信息
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/ssm_db?serverTimezone=UTC
    username: root
    password: root
```

**总结**

1. 整合操作需要勾选 MyBatis 技术，也就是导入 MyBatis 对应的 starter；

2. 数据库连接相关信息转换成配置；

3. 数据库 SQL 映射需要添加 `@Mapper` 被容器识别到；

4. MySQL 8.X 驱动强制要求设置时区；

    - 修改 url，添加 serverTimezone 设定；
    - 修改 MySQL 数据库配置；

5. 驱动类过时，提醒更换为 com.mysql.cj.jdbc.Driver

### 3.3 整合 MyBatis-Plus

**步骤 1**：导入对应的 starter.

```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus-boot-starter</artifactId>
    <version>3.4.3</version>
</dependency>
```

**步骤 2**：配置数据源相关信息。

```yml
#2.配置相关信息
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://ip:port/database
    username: username
    password: password
```

配置完成，下面给出一个示例程序。

**映射接口（Dao）**

```java
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
```

核心在于 Dao 接口继承了一个 BaseMapper 的接口，这个接口中帮助开发者预定了若干个常用的 API 接口，简化了通用 API 接口的开发工作。

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211129100313919.png" alt="image-20211129100313919" style="zoom:80%;" />

下面就可以写一个测试类进行测试了，此处省略。

<font color="#f0f"><b>温馨提示</b></font>

目前数据库的表名定义规则是 tbl\_ 模块名称，为了能和实体类相对应，需要做一个配置。配置 application.yml 文件，添加如下配置即可，设置所有表名的通用前缀名

```yml
mybatis-plus:
  global-config:
    db-config:
      table-prefix: tbl_		#设置所有表的通用前缀名称为tbl_
```

**总结**

1. 手工添加 MyBatis-Plus 对应的 starter
2. 数据层接口使用 BaseMapper 简化开发
3. 需要使用的第三方技术无法通过勾选确定时，需要手工添加坐标

### 3.4 整合 Druid

**步骤 1**：导入对应的坐标（注意，是坐标，此处不是 starter）。

```xml
<dependencies>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.1.16</version>
    </dependency>
</dependencies>
```

**步骤 2**：修改配置，在数据源配置中有一个 type 属性，专用于指定数据源类型。

```xml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://ip:port/database
    username: username
    password: password
    type: com.alibaba.druid.pool.DruidDataSource
```

还有一种配置方式，更加推荐这种方式，如下所示：

**步骤 1**：导入对应的 starter.

```xml
<dependencies>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid-spring-boot-starter</artifactId>
        <version>1.2.6</version>
    </dependency>
</dependencies>
```

**步骤 2**：修改配置。

```xml
spring:
  datasource:
    druid:
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://ip:port/database
        username: username
        password: password
```

**总结**

1. 整合 Druid 需要导入 Druid 对应的 starter；
2. 根据 Druid 提供的配置方式进行配置；
3. 整合第三方技术通用方式。
    - 导入对应的 starter；
    - 根据提供的配置格式，配置非默认值对应的配置项。

## 四、SSMP 整合综合案例

[页面.zip](..\files\页面.zip)

1. 实体类开发————使用 Lombok 快速制作实体类。
2. Dao 开发————整合 MyBatisPlus，制作数据层测试。
3. Service 开发————基于 MyBatisPlus 进行增量开发，制作业务层测试类。
4. Controller 开发————基于 Restful 开发，使用 PostMan 测试接口功能。
5. Controller 开发————前后端开发协议制作。
6. 页面开发————基于 Vue+ElementUI 制作，前后端联调，页面数据处理，页面消息处理。
    - 列表；
    - 新增；
    - 修改；
    - 删除；
    - 分页；
    - 查询；
7. 项目异常处理。
8. 按条件查询————页面功能调整、Controller 修正功能、Service 修正功能。

### 4.1 模块创建

对于这个案例如果按照企业开发的形式进行应该制作后台微服务，前后端分离的开发。

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211129114306062.png" alt="image-20211129114306062" style="zoom:80%;" />

简化一下，后台做单体服务器，前端不使用前后端分离的制作了。

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211129114328967.png" alt="image-20211129114328967" style="zoom:80%;" />

一个服务器即充当后台服务调用，又负责前端页面展示，降低学习的门槛。

下面我们就可以创建一个新的模块，加载要使用的技术对应的 starter，修改配置文件格式为 yml 格式，并把 web 访问端口先设置成 80。

**pom.xml**

```XML
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

**application.yml**

```yaml
server:
  port: 80
```

### 4.2 实体类开发

本案例对应的模块表结构如下：

```sql
-- ----------------------------
-- Table structure for tbl_book
-- ----------------------------
DROP TABLE IF EXISTS `tbl_book`;
CREATE TABLE `tbl_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_book
-- ----------------------------
INSERT INTO `tbl_book` VALUES (1, '计算机理论', 'Spring实战 第5版', 'Spring入门经典教程，深入理解Spring原理技术内幕');
INSERT INTO `tbl_book` VALUES (2, '计算机理论', 'Spring 5核心原理与30个类手写实战', '十年沉淀之作，手写Spring精华思想');
INSERT INTO `tbl_book` VALUES (3, '计算机理论', 'Spring 5 设计模式', '深入Spring源码剖析Spring源码中蕴含的10大设计模式');
INSERT INTO `tbl_book` VALUES (4, '计算机理论', 'Spring MVC+MyBatis开发从入门到项目实战', '全方位解析面向Web应用的轻量级框架，带你成为Spring MVC开发高手');
INSERT INTO `tbl_book` VALUES (5, '计算机理论', '轻量级Java Web企业应用实战', '源码级剖析Spring框架，适合已掌握Java基础的读者');
INSERT INTO `tbl_book` VALUES (6, '计算机理论', 'Java核心技术 卷I 基础知识（原书第11版）', 'Core Java 第11版，Jolt大奖获奖作品，针对Java SE9、10、11全面更新');
INSERT INTO `tbl_book` VALUES (7, '计算机理论', '深入理解Java虚拟机', '5个维度全面剖析JVM，大厂面试知识点全覆盖');
INSERT INTO `tbl_book` VALUES (8, '计算机理论', 'Java编程思想（第4版）', 'Java学习必读经典,殿堂级著作！赢得了全球程序员的广泛赞誉');
INSERT INTO `tbl_book` VALUES (9, '计算机理论', '零基础学Java（全彩版）', '零基础自学编程的入门图书，由浅入深，详解Java语言的编程思想和核心技术');
INSERT INTO `tbl_book` VALUES (10, '市场营销', '直播就该这么做：主播高效沟通实战指南', '李子柒、李佳琦、薇娅成长为网红的秘密都在书中');
INSERT INTO `tbl_book` VALUES (11, '市场营销', '直播销讲实战一本通', '和秋叶一起学系列网络营销书籍');
INSERT INTO `tbl_book` VALUES (12, '市场营销', '直播带货：淘宝、天猫直播从新手到高手', '一本教你如何玩转直播的书，10堂课轻松实现带货月入3W+');
```

根据上述表结构，制作对应的实体类

**实体类**

```JAVA
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
```

实体类的开发可以自动通过工具手工生成 get/set 方法，然后覆盖 toString()方法，方便调试，等等。不过这一套操作书写很繁琐，有对应的工具可以帮助我们简化开发，介绍一个小工具，lombok。

Lombok，一个 Java 类库，提供了一组注解，简化 POJO 实体类开发，SpringBoot 目前默认集成了 lombok 技术，并提供了对应的版本控制，所以只需要提供对应的坐标即可，在 pom.xml 中添加 lombok 的坐标。

```XML
<dependencies>
    <!--lombok-->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
    </dependency>
</dependencies>
```

使用 lombok 可以通过一个注解 `@Data` 完成一个实体类对应的 getter，setter，toString，equals，hashCode 等操作的快速添加。

```JAVA
import lombok.Data;
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
```

到这里实体类就做好了，是不是比不使用 lombok 简化好多，这种工具在 Java 开发中还有 N 多，后面课程中遇到了能用的东西时，在不增加各位小伙伴大量的学习时间的情况下，尽量多给大家介绍一些。

**总结**

1. 实体类制作；
2. 使用 lombok 简化开发。
    - 导入 lombok 无需指定版本，由 SpringBoot 提供版本；
    - `@Data` 注解。

### 4.3 数据层开发——基础 CRUD

数据层开发本次使用 MyBatis-Plus 技术，数据源 Druid.

**步骤 1**：导入 MyBati-sPlus 与 Druid 对应的 starter，当然 MySQL 的驱动不能少。

```xml
<dependencies>
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>3.4.3</version>
    </dependency>
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid-spring-boot-starter</artifactId>
        <version>1.2.6</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

**步骤 2**：配置数据库连接相关的数据源配置。

```YAML
server:
  port: 80

spring:
  datasource:
    druid:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://localhost:3306/ssm_db?serverTimezone=UTC
      username: root
      password: root
```

**步骤 3**：使用 MP 的标准通用接口 BaseMapper 加速开发，别忘了 `@Mapper` 和泛型的指定。

```JAVA
@Mapper
public interface BookDao extends BaseMapper<Book> {
}
```

**步骤 4**：制作测试类测试结果。

```JAVA
package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(17);
        book.setType("测试数据abcdefg");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(16);
    }

    @Test
    void testGetAll(){
        bookDao.selectList(null);
    }
}
```

<font color="#f0f"><b>温馨提示</b></font>

MP 技术默认的主键生成策略为雪花算法，生成的主键 ID 长度较大，和目前的数据库设定规则不相符，需要配置一下使 MP 使用数据库的主键生成策略，方式嘛还是老一套，做配置。在 application.yml 中添加对应配置即可，具体如下

```yaml
server:
  port: 80

spring:
  datasource:
    druid:
      driver-class-name: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://localhost:3306/ssm_db?serverTimezone=UTC
      username: root
      password: root

mybatis-plus:
  global-config:
    db-config:
      table-prefix: tbl_		#设置表名通用前缀
      id-type: auto				#设置主键id字段的生成策略为参照数据库设定的策略，当前数据库设置id生成策略为自增
```

#### 查看 MP 运行日志

在进行数据层测试的时候，因为基础的 CRUD 操作均由 MP 给我们提供了，所以就出现了一个局面，开发者不需要书写 SQL 语句了，这样程序运行的时候总有一种感觉，一切的一切都是黑盒的，作为开发者我们啥也不知道就完了。如果程序正常运行还好，如果报错了，这个时候就很崩溃，你甚至都不知道从何下手，因为传递参数、封装 SQL 语句这些操作完全不是你干预开发出来的，所以查看执行期运行的 SQL 语句就成为当务之急。

SpringBoot 整合 MP 的时候充分考虑到了这点，通过配置的形式就可以查阅执行期 SQL 语句，配置如下。

```yml
mybatis-plus:
  global-config:
    db-config:
      table-prefix: tbl_
      id-type: auto
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

再来看运行结果，此时就显示了运行期执行 SQL 的情况。

```shell
Creating a new SqlSession
SqlSession [org.apache.ibatis.session.defaults.DefaultSqlSession@2c9a6717] was not registered for synchronization because synchronization is not active
JDBC Connection [com.mysql.cj.jdbc.ConnectionImpl@6ca30b8a] will not be managed by Spring
==>  Preparing: SELECT id,type,name,description FROM tbl_book
==> Parameters:
<==    Columns: id, type, name, description
<==        Row: 1, 计算机理论, Spring实战 第5版, Spring入门经典教程，深入理解Spring原理技术内幕
<==        Row: 2, 计算机理论, Spring 5核心原理与30个类手写实战, 十年沉淀之作，手写Spring精华思想
<==        Row: 3, 计算机理论, Spring 5 设计模式, 深入Spring源码剖析Spring源码中蕴含的10大设计模式
<==        Row: 4, 计算机理论, Spring MVC+MyBatis开发从入门到项目实战, 全方位解析面向Web应用的轻量级框架，带你成为Spring MVC开发高手
<==        Row: 5, 计算机理论, 轻量级Java Web企业应用实战, 源码级剖析Spring框架，适合已掌握Java基础的读者
<==        Row: 6, 计算机理论, Java核心技术 卷I 基础知识（原书第11版）, Core Java 第11版，Jolt大奖获奖作品，针对Java SE9、10、11全面更新
<==        Row: 7, 计算机理论, 深入理解Java虚拟机, 5个维度全面剖析JVM，大厂面试知识点全覆盖
<==        Row: 8, 计算机理论, Java编程思想（第4版）, Java学习必读经典,殿堂级著作！赢得了全球程序员的广泛赞誉
<==        Row: 9, 计算机理论, 零基础学Java（全彩版）, 零基础自学编程的入门图书，由浅入深，详解Java语言的编程思想和核心技术
<==        Row: 10, 市场营销, 直播就该这么做：主播高效沟通实战指南, 李子柒、李佳琦、薇娅成长为网红的秘密都在书中
<==        Row: 11, 市场营销, 直播销讲实战一本通, 和秋叶一起学系列网络营销书籍
<==        Row: 12, 市场营销, 直播带货：淘宝、天猫直播从新手到高手, 一本教你如何玩转直播的书，10堂课轻松实现带货月入3W+
<==        Row: 13, 测试类型, 测试数据, 测试描述数据
<==        Row: 14, 测试数据update, 测试数据update, 测试数据update
<==        Row: 15, -----------------, 测试数据123, 测试数据123
<==      Total: 15
```

其中清晰的标注了当前执行的 SQL 语句是什么，携带了什么参数，对应的执行结果是什么，所有信息应有尽有。

此处设置的是日志的显示形式，当前配置的是控制台输出，当然还可以由更多的选择，根据需求切换即可。

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211129143207295.png" alt="image-20211129143207295" style="zoom:80%;" />

**总结**

1. 手工导入 starter 坐标（2 个），MySQL 驱动（1 个）;

2. 配置数据源与 MyBatisPlus 对应的配置；

3. 开发 Dao 接口（继承 BaseMapper）；

4. 制作测试类测试 Dao 功能是否有效；

5. 使用配置方式开启日志，设置日志输出方式为标准输出即可查阅 SQL 执行日志；

### 4.4 数据层开发——分页功能制作

前面仅仅是使用了 MP 提供的基础 CRUD 功能，实际上 MP 给我们提供了几乎所有的基础操作，这一节说一下如果实现数据库端的分页操作。

MP 提供的分页操作 API 如下

```JAVA
@Test
void testGetPage(){
    IPage page = new Page(2,5);
    bookDao.selectPage(page, null);
    System.out.println(page.getCurrent());
    System.out.println(page.getSize());
    System.out.println(page.getTotal());
    System.out.println(page.getPages());
    System.out.println(page.getRecords());
}
```

其中 selectPage 方法需要传入一个封装分页数据的对象，可以通过 new 的形式创建这个对象，当然这个对象也是 MP 提供的，别选错包了。创建此对象时就需要指定分页的两个基本数据。

-   当前显示第几页；
-   每页显示几条数据。

可以通过创建 Page 对象时利用构造方法初始化这两个数据

```JAVA
IPage page = new Page(2,5);
```

将该对象传入到查询方法 selectPage 后，可以得到查询结果，但是我们会发现当前操作查询结果返回值仍然是一个 IPage 对象，这又是怎么回事？

```JAVA
IPage page = bookDao.selectPage(page, null);
```

原来这个 IPage 对象中封装了若干个数据，而查询的结果作为 IPage 对象封装的一个数据存在的，可以理解为查询结果得到后，又塞到了这个 IPage 对象中，其实还是为了高度的封装，一个 IPage 描述了分页所有的信息。下面 5 个操作就是 IPage 对象中封装的所有信息了

```JAVA
@Test
void testGetPage(){
    IPage page = new Page(2,5);
    bookDao.selectPage(page, null);
    System.out.println(page.getCurrent());		//当前页码值
    System.out.println(page.getSize());			//每页显示数
    System.out.println(page.getTotal());		//数据总量
    System.out.println(page.getPages());		//总页数
    System.out.println(page.getRecords());		//详细数据
}
```

到这里就知道这些数据如何获取了，但是当你去执行这个操作时，你会发现并不像我们分析的这样，实际上这个分页当前是无效的。为什么这样呢？这个要源于 MP 的内部机制。

对于 MySQL 的分页操作使用 limit 关键字进行，而并不是所有的数据库都使用 limit 关键字实现的，这个时候 MP 为了制作的兼容性强，将分页操作设置为基础查询操作的升级版，你可以理解为 IPhone6 与 IPhone6S-PLUS 的关系。

基础操作中有查询全部的功能，而在这个基础上只需要升级一下（PLUS）就可以得到分页操作。所以 MP 将分页操作做成了一个开关，你用分页功能就把开关开启，不用就不需要开启这个开关。而我们现在没有开启这个开关，所以分页操作是没有的。这个开关是通过 MP 的拦截器的形式存在的，其中的原理这里不分析了，有兴趣的小伙伴可以学习 MyBatisPlus 这门课程进行详细解读。具体设置方式如下

**定义 MP 拦截器并将其设置为 Spring 管控的 bean**

```JAVA
@Configuration
public class MPConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
```

上述代码第一行是创建 MP 的拦截器栈，这个时候拦截器栈中没有具体的拦截器，第二行是初始化了分页拦截器，并添加到拦截器栈中。如果后期开发其他功能，需要添加全新的拦截器，按照第二行的格式继续 add 进去新的拦截器就可以了。

**总结**

1. 使用 IPage 封装分页数据；
2. 分页操作依赖 MyBatisPlus 分页拦截器实现功能；
3. 借助 MyBatisPlus 日志查阅执行 SQL 语句。

### 4.5 数据层开发——条件查询功能制作

除了分页功能，MP 还提供有强大的条件查询功能。以往我们写条件查询要自己动态拼写复杂的 SQL 语句，现在简单了，MP 将这些操作都制作成 API 接口，调用一个又一个的方法就可以实现各种套件的拼装。

下面的操作就是执行一个模糊匹配对应的操作，由 l ike 条件书写变为了 like 方法的调用

```JAVA
@Test
void testGetBy(){
    QueryWrapper<Book> qw = new QueryWrapper<>();
    qw.like("name","Spring");
    bookDao.selectList(qw);
}
```

其中第一句 QueryWrapper 对象是一个用于封装查询条件的对象，该对象可以动态使用 API 调用的方法添加条件，最终转化成对应的 SQL 语句。第二句就是一个条件了，需要什么条件，使用 QueryWapper 对象直接调用对应操作即可。比如做大于小于关系，就可以使用 lt 或 gt 方法，等于使用 eq 方法，等等，此处不做更多的解释了。

这组 API 使用还是比较简单的，但是关于属性字段名的书写存在着安全隐患，比如查询字段 name，当前是以字符串的形态书写的，万一写错，编译器还没有办法发现，只能将问题抛到运行器通过异常堆栈告诉开发者，不太友好。

MP 针对字段检查进行了功能升级，全面支持 Lambda 表达式，就有了下面这组 API。由 QueryWrapper 对象升级为 LambdaQueryWrapper 对象，这下就变了上述问题的出现。

```JAVA
@Test
void testGetBy2(){
    String name = "1";
    LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
    lqw.like(Book::getName,name);
    bookDao.selectList(lqw);
}
```

为了便于开发者动态拼写 SQL，防止将 null 数据作为条件使用，MP 还提供了动态拼装 SQL 的快捷书写方式

```JAVA
@Test
void testGetBy2(){
    String name = "1";
    LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
    //if(name != null) lqw.like(Book::getName,name);		//方式一：JAVA代码控制
    lqw.like(name != null,Book::getName,name);				//方式二：API接口提供控制开关
    bookDao.selectList(lqw);
}
```

**总结**

1. 使用 QueryWrapper 对象封装查询条件；

2. 推荐使用 LambdaQueryWrapper 对象；

3. 所有查询操作封装成方法调用；

4. 查询条件支持动态条件拼装。

### 4.6 业务层开发

数据层开发告一段落，下面进行业务层开发，其实标准业务层开发很多初学者认为就是调用数据层，怎么说呢？这个理解是没有大问题的，更精准的说法应该是<font color="#ff0000"><b>组织业务逻辑功能，并根据业务需求，对数据持久层发起调用</b></font>。有什么差别呢？目标是为了组织出符合需求的业务逻辑功能，至于调不调用数据层还真不好说，有需求就调用，没有需求就不调用。

一个常识性的知识普及一下，业务层的方法名定义一定要与业务有关，例如登录操作。

```JAVA
login(String username, String password);
```

而数据层的方法名定义一定与业务无关，是一定，不是可能，也不是有可能，例如根据用户名密码查询。

```JAVA
selectByUserNameAndPassword(String username,String password);
```

我们在开发的时候是可以根据完成的工作不同划分成不同职能的开发团队的。比如一个哥们制作数据层，他就可以不知道业务是什么样子，拿到的需求文档要求可能是这样的

```tex
接口：传入用户名与密码字段，查询出对应结果，结果是单条数据
接口：传入ID字段，查询出对应结果，结果是单条数据
接口：传入离职字段，查询出对应结果，结果是多条数据
```

但是进行业务功能开发的哥们，拿到的需求文档要求差别就很大

```tex
接口：传入用户名与密码字段，对用户名字段做长度校验，4-15位，对密码字段做长度校验，8到24位，对喵喵喵字段做特殊字符校验，不允许存在空格，查询结果为对象。如果为null，返回BusinessException，封装消息码INFO_LOGON_USERNAME_PASSWORD_ERROR
```

你比较一下，能是一回事吗？差别太大了，所以说业务层方法定义与数据层方法定义差异化很大，只不过有些入门级的开发者手懒或者没有使用过公司相关的 ISO 标准化文档而已。

多余的话不说了，咱们做案例就简单制作了，业务层接口定义如下：

```JAVA
public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    IPage<Book> getPage(int currentPage,int pageSize);
}
```

业务层实现类如下，转调数据层即可

```JAVA
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }
}
```

别忘了对业务层接口进行测试，测试类如下

```JAVA
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private IBookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.save(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(17);
        book.setType("-----------------");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.updateById(book);
    }
    @Test
    void testDelete(){
        bookService.removeById(18);
    }

    @Test
    void testGetAll(){
        bookService.list();
    }

    @Test
    void testGetPage(){
        IPage<Book> page = new Page<Book>(2,5);
        bookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

}
```

**总结**

1. Service 接口名称定义成业务名称，并与 Dao 接口名称进行区分
2. 制作测试类测试 Service 功能是否有效

#### 业务层快速开发

其实 MP 技术不仅提供了数据层快速开发方案，业务层 MP 也给了一个通用接口。

业务层接口快速开发：

```JAVA
public interface IBookService extends IService<Book> {
    //添加非通用操作API接口
}
```

业务层接口实现类快速开发，关注继承的类需要传入两个泛型，一个是数据层接口，另一个是实体类。

```JAVA
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
    private BookDao bookDao;
	//添加非通用操作API
}
```

如果感觉 MP 提供的功能不足以支撑你的使用需要，其实是一定不能支撑的，因为需求不可能是通用的，在原始接口基础上接着定义新的 API 接口就行了，此处不再说太多了，就是自定义自己的操作了，但是不要和已有的 API 接口名冲突即可。

**总结**

1. 使用通用接口（ISerivce\<T\>）快速开发 Service.
2. 使用通用实现类（ServiceImpl\<M,T\>）快速开发 ServiceImpl.
3. 可以在通用接口基础上做功能重载或功能追加。
4. 注意重载时不要覆盖原始操作，避免原始提供的功能丢失。

### 4.7 表现层开发

终于做到表现层了，做了这么多都是基础工作。其实你现在回头看看，哪里还有什么 SpringBoot 的影子？前面 1，2 步就搞完了。继续完成表现层制作吧，咱们表现层的开发使用基于 Restful 的表现层接口开发，功能测试通过 Postman 工具进行。

表现层接口如下:

```JAVA
@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.modify(book);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return bookService.delete(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        return bookService.getPage(currentPage,pageSize, null);
    }
}
```

在实用 Postman 测试时关注提交类型，对应上即可，不然就会报 405 的错误码了。

**普通 GET 请求**

![image-20211129152237371](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211129152237371.png)

**PUT 请求传递 json 数据，后台实用 `@RequestBody` 接收数据**

![image-20211129152300177](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211129152300177.png)

**GET 请求传递路径变量，后台实用 `@PathVariable` 接收数据**

**总结**

1. 基于 Restfu l 制作表现层接口：
    - 新增：POST.
    - 删除：DELETE.
    - 修改：PUT.
    - 查询：GET.
2. 接收参数：
    - 实体数据：`@RequestBody`.
    - 路径变量：`@PathVariable`.

### 4.8 表现层消息一致性处理

目前我们通过 Postman 测试后业务层接口功能时通的，但是这样的结果给到前端开发者会出现一个小问题。不同的操作结果所展示的数据格式差异化严重。

**增删改操作结果**

```tex
true
```

**查询单个数据操作结果**

```json
{
    "id": 1,
    "type": "计算机理论",
    "name": "Spring实战 第5版",
    "description": "Spring入门经典教程"
}
```

**查询全部数据操作结果**

```json
[
    {
        "id": 1,
        "type": "计算机理论",
        "name": "Spring实战 第5版",
        "description": "Spring入门经典教程"
    },
    {
        "id": 2,
        "type": "计算机理论",
        "name": "Spring 5核心原理与30个类手写实战",
        "description": "十年沉淀之作"
    }
]
```

每种不同操作返回的数据格式都不一样，而且还不知道以后还会有什么格式，这样的结果让前端人员看了是很容易让人崩溃的，必须将所有操作的操作结果数据格式统一起来，需要设计表现层返回结果的模型类，用于后端与前端进行数据格式统一，也称为**前后端数据协议**。

```JAVA
@Data
public class R {
    private Boolean flag;
    private Object data;
}
```

其中 flag 用于标识操作是否成功，data 用于封装操作数据，现在的数据格式就变了。

```JSON
{
    "flag": true,
    "data":{
        "id": 1,
        "type": "计算机理论",
        "name": "Spring实战 第5版",
        "description": "Spring入门经典教程"
    }
}
```

表现层开发格式也需要转换一下：

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211129153301262.png" alt="image-20211129153301262" style="zoom:80%;" />

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211129153319052.png" alt="image-20211129153319052" style="zoom:80%;" />

<img src="https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211129153332499.png" alt="image-20211129153332499" style="zoom:80%;" />

结果这么一折腾，全格式统一，现在后端发送给前端的数据格式就统一了，免去了不少前端解析数据的麻烦。

**总结**

1. 设计统一的返回值结果类型便于前端开发读取数据；

2. 返回值结果类型可以根据需求自行设定，没有固定格式；

3. 返回值结果模型类用于后端与前端进行数据格式统一，也称为前后端数据协议。

### 4.9 前后端联通性测试

后端的表现层接口开发完毕，就可以进行前端的开发了。

将前端人员开发的页面保存到 l resources 目录下的 static 目录中，建议执行 maven 的 clean 生命周期，避免缓存的问题出现。

![image-20211129153831990](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/image-20211129153831990.png)

在进行具体的功能开发之前，先做联通性的测试，通过页面发送异步提交（axios），这一步调试通过后再进行进一步的功能开发。

```js
//列表
getAll() {
	axios.get("/books").then((res)=>{
		console.log(res.data);
	});
},
```

只要后台代码能够正常工作，前端能够在日志中接收到数据，就证明前后端是通的，也就可以进行下一步的功能开发了。

**总结**

1. 单体项目中页面放置在 resources/static 目录下；
2. created 钩子函数用于初始化页面时发起调用；
3. 页面使用 axios 发送异步请求获取数据后确认前后端是否联通。

### 4.10 页面基础功能开发

#### 4.10.1 列表功能（非分页版）

列表功能主要操作就是加载完数据，将数据展示到页面上，此处要利用 VUE 的数据模型绑定，发送请求得到数据，然后页面上读取指定数据即可。

**页面数据模型定义**

```vue
data:{
	dataList: [],//当前页要展示的列表数据
	...
},
```

异步请求获取数据。

```JS
//列表
getAll() {
    axios.get("/books").then((res)=>{
        this.dataList = res.data.data;
    });
},
```

​ 这样在页面加载时就可以获取到数据，并且由 vue 将数据展示到页面上了。

总结：

1. 将查询数据返回到页面，利用前端数据绑定进行数据展示。

#### 4.10.2 添加功能

添加功能用于收集数据的表单是通过一个弹窗展示的，因此在添加操作前首先要进行弹窗的展示，添加后隐藏弹窗即可。因为这个弹窗一直存在，因此当页面加载时首先设置这个弹窗为不可显示状态，需要展示，切换状态即可。

**默认状态**

```vue
data:{
	dialogFormVisible: false,//添加表单是否可见
	...
},
```

**切换为显示状态**

```JS
//弹出添加窗口
handleCreate() {
	this.dialogFormVisible = true;
},
```

由于每次添加数据都是使用同一个弹窗录入数据，所以每次操作的痕迹将在下一次操作时展示出来，需要在每次操作之前清理掉上次操作的痕迹。

**定义清理数据操作**

```js
//重置表单
resetForm() {
    this.formData = {};
},
```

**切换弹窗状态时清理数据**

```js
//弹出添加窗口
handleCreate() {
    this.dialogFormVisible = true;
    this.resetForm();
},
```

至此准备工作完成，下面就要调用后台完成添加操作了。

**添加操作**

```js
//添加
handleAdd () {
    //发送异步请求
    axios.post("/books",this.formData).then((res)=>{
        //如果操作成功，关闭弹层，显示数据
        if(res.data.flag){
            this.dialogFormVisible = false;
            this.$message.success("添加成功");
        }else {
            this.$message.error("添加失败");
        }
    }).finally(()=>{
        this.getAll();
    });
},
```

1. 将要保存的数据传递到后台，通过 post 请求的第二个参数传递 json 数据到后台；
2. 根据返回的操作结果决定下一步操作；
    - 如何是 true 就关闭添加窗口，显示添加成功的消息；
    - 如果是 false 保留添加窗口，显示添加失败的消息；
3. 无论添加是否成功，页面均进行刷新，动态加载数据（对 getAll 操作发起调用）。

**取消添加操作**

```JS
//取消
cancel(){
    this.dialogFormVisible = false;
    this.$message.info("操作取消");
},
```

**总结**

1. 请求方式使用 POST 调用后台对应操作；
2. 添加操作结束后动态刷新页面加载数据；
3. 根据操作结果不同，显示对应的提示信息；
4. 弹出添加 Div 时清除表单数据。

#### 4.10.3 删除功能

模仿添加操作制作删除功能，差别之处在于删除操作仅传递一个待删除的数据 id 到后台即可。

**删除操作**

```JS
// 删除
handleDelete(row) {
    axios.delete("/books/"+row.id).then((res)=>{
        if(res.data.flag){
            this.$message.success("删除成功");
        }else{
            this.$message.error("删除失败");
        }
    }).finally(()=>{
        this.getAll();
    });
},
```

**删除操作提示信息**

```JS
// 删除
handleDelete(row) {
    //1.弹出提示框
    this.$confirm("此操作永久删除当前数据，是否继续？","提示",{
        type:'info'
    }).then(()=>{
        //2.做删除业务
        axios.delete("/books/"+row.id).then((res)=>{
       		if(res.data.flag){
            	this.$message.success("删除成功");
        	}else{
            	this.$message.error("删除失败");
        	}
        }).finally(()=>{
            this.getAll();
        });
    }).catch(()=>{
        //3.取消删除
        this.$message.info("取消删除操作");
    });
}，
```

**总结**

1. 请求方式使用 Delete 调用后台对应操作；
2. 删除操作需要传递当前行数据对应的 id 值到后台；
3. 删除操作结束后动态刷新页面加载数据；
4. 根据操作结果不同，显示对应的提示信息；
5. 删除操作前弹出提示框避免误操作。

#### 4.10.4 修改功能

修改功能可以说是列表功能、删除功能与添加功能的合体。几个相似点如下：

1. 页面也需要有一个弹窗用来加载修改的数据，这一点与添加相同，都是要弹窗；
2. 弹出窗口中要加载待修改的数据，而数据需要通过查询得到，这一点与查询全部相同，都是要查数据；
3. 查询操作需要将要修改的数据 id 发送到后台，这一点与删除相同，都是传递 id 到后台；
4. 查询得到数据后需要展示到弹窗中，这一点与查询全部相同，都是要通过数据模型绑定展示数据；
5. 修改数据时需要将被修改的数据传递到后台，这一点与添加相同，都是要传递数据；

所以整体上来看，修改功能就是前面几个功能的大合体。

**查询并展示数据**

```JS
//弹出编辑窗口
handleUpdate(row) {
    axios.get("/books/"+row.id).then((res)=>{
        if(res.data.flag){
            //展示弹层，加载数据
            this.formData = res.data.data;
            this.dialogFormVisible4Edit = true;
        }else{
            this.$message.error("数据同步失败，自动刷新");
        }
    });
},
```

**修改操作**

```JS
//修改
handleEdit() {
    axios.put("/books",this.formData).then((res)=>{
        //如果操作成功，关闭弹层并刷新页面
        if(res.data.flag){
            this.dialogFormVisible4Edit = false;
            this.$message.success("修改成功");
        }else {
            this.$message.error("修改失败，请重试");
        }
    }).finally(()=>{
        this.getAll();
    });
},
```

**总结**

1. 加载要修改数据通过传递当前行数据对应的 id 值到后台查询数据（同删除与查询全部）；
2. 利用前端双向数据绑定将查询到的数据进行回显（同查询全部）；
3. 请求方式使用 PUT 调用后台对应操作（同新增传递数据）；
4. 修改操作结束后动态刷新页面加载数据（同新增）；
5. 根据操作结果不同，显示对应的提示信息（同新增）。

### 4.11 业务消息一致性处理

目前的功能制作基本上达成了正常使用的情况，什么叫正常使用呢？也就是这个程序不出 BUG，如果我们搞一个 BUG 出来，你会发现程序马上崩溃掉。比如后台手工抛出一个异常，看看前端接收到的数据什么样子。

```json
{
    "timestamp": "2021-09-15T03:27:31.038+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "path": "/books"
}
```

面对这种情况，前端的同学又不会了，这又是什么格式？怎么和之前的格式不一样？

```json
{
    "flag": true,
    "data":{
        "id": 1,
        "type": "计算机理论",
        "name": "Spring实战 第5版",
        "description": "Spring入门经典教程"
    }
}
```

看来不仅要对正确的操作数据格式做处理，还要对错误的操作数据格式做同样的格式处理。

首先在当前的数据结果中添加消息字段，用来兼容后台出现的操作消息。

```JAVA
@Data
public class R{
    private Boolean flag;
    private Object data;
    private String msg;		//用于封装消息
}
```

后台代码也要根据情况做处理，当前是模拟的错误。

```JAVA
@PostMapping
public R save(@RequestBody Book book) throws IOException {
    Boolean flag = bookService.insert(book);
    return new R(flag , flag ? "添加成功^_^" : "添加失败-_-!");
}
```

然后在表现层做统一的异常处理，使用 SpringMVC 提供的异常处理器做统一的异常处理。

```JAVA
@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public R doOtherException(Exception ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        ex.printStackTrace();
        return new R(false,null,"系统错误，请稍后再试！");
    }
}
```

页面上得到数据后，先判定是否有后台传递过来的消息，标志就是当前操作是否成功，如果返回操作结果 false，就读取后台传递的消息。

```JS
//添加
handleAdd () {
	//发送ajax请求
    axios.post("/books",this.formData).then((res)=>{
        //如果操作成功，关闭弹层，显示数据
        if(res.data.flag){
            this.dialogFormVisible = false;
            this.$message.success("添加成功");
        }else {
            this.$message.error(res.data.msg);			//消息来自于后台传递过来，而非固定内容
        }
    }).finally(()=>{
        this.getAll();
    });
},
```

**总结**

1. 使用注解 `@RestControllerAdvice` 定义 SpringMVC 异常处理器用来处理异常的；
2. 异常处理器必须被扫描加载，否则无法生效；
3. 表现层返回结果的模型类中添加消息属性用来传递消息到页面；

### 4.12 页面功能开发

#### 4.12.1 分页功能

分页功能的制作用于替换前面的查询全部，其中要使用到 elementUI 提供的分页组件。

```js
<!--分页组件-->
<div class="pagination-container">
    <el-pagination
		class="pagiantion"
		@current-change="handleCurrentChange"
		:current-page="pagination.currentPage"
		:page-size="pagination.pageSize"
		layout="total, prev, pager, next, jumper"
		:total="pagination.total">
    </el-pagination>
</div>
```

为了配合分页组件，封装分页对应的数据模型：

```vue
data:{
	pagination: {
		//分页相关模型数据
		currentPage: 1,	//当前页码
		pageSize:10,	//每页显示的记录数
		total:0,		//总记录数
	}
},
```

修改查询全部功能为分页查询，通过路径变量传递页码信息参数：

```JS
getAll() {
    axios.get("/books/"+this.pagination.currentPage+"/"+this.pagination.pageSize).then((res) => {
    });
},
```

后台提供对应的分页功能：

```JAVA
@GetMapping("/{currentPage}/{pageSize}")
public R getAll(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
    IPage<Book> pageBook = bookService.getPage(currentPage, pageSize);
    return new R(null != pageBook ,pageBook);
}
```

页面根据分页操作结果读取对应数据，并进行数据模型绑定：

```JS
getAll() {
    axios.get("/books/"+this.pagination.currentPage+"/"+this.pagination.pageSize).then((res) => {
        this.pagination.total = res.data.data.total;
        this.pagination.currentPage = res.data.data.current;
        this.pagination.pagesize = res.data.data.size;
        this.dataList = res.data.data.records;
    });
},
```

对切换页码操作设置调用当前分页操作：

```JS
//切换页码
handleCurrentChange(currentPage) {
    this.pagination.currentPage = currentPage;
    this.getAll();
},
```

**总结**

1. 使用 el 分页组件；
2. 定义分页组件绑定的数据模型；
3. 异步调用获取分页数据；
4. 分页数据页面回显。

#### 4.12.2 删除功能维护

由于使用了分页功能，当最后一页只有一条数据时，删除操作就会出现 BUG，最后一页无数据但是独立展示，对分页查询功能进行后台功能维护，如果当前页码值大于最大页码值，重新执行查询。其实这个问题解决方案很多，这里给出比较简单的一种处理方案。

```JAVA
@GetMapping("{currentPage}/{pageSize}")
public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
    IPage<Book> page = bookService.getPage(currentPage, pageSize);
    //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
    if( currentPage > page.getPages()){
        page = bookService.getPage((int)page.getPages(), pageSize);
    }
    return new R(true, page);
}
```

#### 4.12.3 条件查询功能

最后一个功能来做条件查询，其实条件查询可以理解为分页查询的时候除了携带分页数据再多带几个数据的查询。这些多带的数据就是查询条件。比较一下不带条件的分页查询与带条件的分页查询差别之处，这个功能就好做了。

-   页面封装的数据：带不带条件影响的仅仅是一次性传递到后台的数据总量，由传递 2 个分页相关的数据转换成 2 个分页数据加若干个条件；

-   后台查询功能：查询时由不带条件，转换成带条件，反正不带条件的时候查询条件对象使用的是 null，现在换成具体条件，差别不大；

-   查询结果：不管带不带条件，出来的数据只是有数量上的差别，其他都差别，这个可以忽略。

    经过上述分析，看来需要在页面发送请求的格式方面做一定的修改，后台的调用数据层操作时发送修改，其他没有区别。

    页面发送请求时，两个分页数据仍然使用路径变量，其他条件采用动态拼装 url 参数的形式传递。

**页面封装查询条件字段**

```vue
pagination: {
//分页相关模型数据
	currentPage: 1,		//当前页码
	pageSize:10,		//每页显示的记录数
	total:0,			//总记录数
	name: "",
	type: "",
	description: ""
},
```

页面添加查询条件字段对应的数据模型绑定名称。

```HTML
<div class="filter-container">
    <el-input placeholder="图书类别" v-model="pagination.type" class="filter-item"/>
    <el-input placeholder="图书名称" v-model="pagination.name" class="filter-item"/>
    <el-input placeholder="图书描述" v-model="pagination.description" class="filter-item"/>
    <el-button @click="getAll()" class="dalfBut">查询</el-button>
    <el-button type="primary" class="butT" @click="handleCreate()">新建</el-button>
</div>
```

将查询条件组织成 url 参数，添加到请求 url 地址中，这里可以借助其他类库快速开发，当前使用手工形式拼接，降低学习要求。

```JS
getAll() {
    //1.获取查询条件,拼接查询条件
    param = "?name="+this.pagination.name;
    param += "&type="+this.pagination.type;
    param += "&description="+this.pagination.description;
    console.log("-----------------"+ param);
    axios.get("/books/"+this.pagination.currentPage+"/"+this.pagination.pageSize+param).then((res) => {
        this.dataList = res.data.data.records;
    });
},
```

后台代码中定义实体类封查询条件。

```JAVA
@GetMapping("{currentPage}/{pageSize}")
public R getAll(@PathVariable int currentPage,@PathVariable int pageSize,Book book) {
    System.out.println("参数=====>"+book);
    IPage<Book> pageBook = bookService.getPage(currentPage,pageSize);
    return new R(null != pageBook ,pageBook);
}
```

对应业务层接口与实现类进行修正

```JAVA
public interface IBookService extends IService<Book> {
    IPage<Book> getPage(Integer currentPage,Integer pageSize,Book queryBook);
}
```

```JAVA
@Service
public class BookServiceImpl2 extends ServiceImpl<BookDao,Book> implements IBookService {
    public IPage<Book> getPage(Integer currentPage,Integer pageSize,Book queryBook){
        IPage page = new Page(currentPage,pageSize);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(Strings.isNotEmpty(queryBook.getName()),Book::getName,queryBook.getName());
        lqw.like(Strings.isNotEmpty(queryBook.getType()),Book::getType,queryBook.getType());
        lqw.like(Strings.isNotEmpty(queryBook.getDescription()),Book::getDescription,queryBook.getDescription());
        return bookDao.selectPage(page,lqw);
    }
}
```

页面回显数据：

```js
getAll() {
    //1.获取查询条件,拼接查询条件
    param = "?name="+this.pagination.name;
    param += "&type="+this.pagination.type;
    param += "&description="+this.pagination.description;
    console.log("-----------------"+ param);
    axios.get("/books/"+this.pagination.currentPage+"/"+this.pagination.pageSize+param).then((res) => {
        this.pagination.total = res.data.data.total;
        this.pagination.currentPage = res.data.data.current;
        this.pagination.pagesize = res.data.data.size;
        this.dataList = res.data.data.records;
    });
},
```

**总结**

1. 定义查询条件数据模型（当前封装到分页数据模型中）；
2. 异步调用分页功能并通过请求参数传递数据到后台。
