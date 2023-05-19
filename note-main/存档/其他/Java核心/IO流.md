---
title: IO流
author: Lemon
top: true
cover: true
toc: true
mathjax: false
summary: 介绍Java的IO技术和对象的序列化
tags:
  - Java
  - IO流
categories:
  - Java
reprintPolicy: cc_by
abbrlink: fed4c017
date: 2021-12-14 00:00:00
coverImg:
img:
password:
---

## 一、`File` 类的使用

### 1.1 `File` 的常用方法

[File 类脑图](https://www.yuque.com/lemonsama/zm0p2q/cd50d0?view=doc_embed)

### 1.2 练习

#### 1. 利用 `File` 构造器，new 一个文件目录 file

1.  在其中创建多个文件和目录
2.  编写方法，实现删除 file 中指定文件的操作

```java
import java.io.File;
import java.io.IOException;

/**
 * 1. 利用File构造器，new一个文件目录file
 *  1)在其中创建多个文件和目录
 *  2)编写方法，实现删除file中指定文件的操作
 * */

public class FileTest1 {
    public static void main(String[] args) {
        File file = new File("D:\\test");
        File destFile  = new File(file.getAbsolutePath(), "hello.txt");
        try {
            System.out.println(destFile.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
         deleteFile(file, "hello.txt");
    }

    public static void deleteFile(File parent, String file) {
        File deleteFile = new File(parent, file);
        if (deleteFile.exists()) {
            deleteFile.delete();
        } else {
            System.out.println("文件不存在删除失败");
        }
    }
}

```

#### 2. 判断指定目录下是否有后缀名为 .jpg 的文件，如果有，就输出该文件名称

```java
import java.io.File;
import java.io.FilenameFilter;

/**
 *  2. 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 */

public class FileTest2 {
    public static void main(String[] args) {
    }

    public static void test1() {
        File srcFile = new File("D:\\images");
        File[] files = srcFile.listFiles();
        for (File file : files) {
            if (file.getName().endsWith("jpg")) {
                System.out.println(file.getName());
            }
        }
    }

    public static void test2() {
        File srcFile = new File("D:\\images");
        String[] list = srcFile.list();
        for (String str : list) {
            if (str.endsWith(".jpg")) {
                System.out.println(str);
            }
        }
    }

    /**
     * File类提供了两个文件过滤器方法
     * public String[] list(FilenameFilter filter)
     * public File[] listFiles(FileFilter filter)
     */
    public static void test3(){
        File srcFile = new File("D:\\images");
        File[] files = srcFile.listFiles((fir, name) -> name.endsWith(".jpg"));
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
```

#### 3. 遍历指定目录所有文件名称，包括子文件目录中的文件

1.  拓展 1：并计算指定目录占用空间的大小
2.  拓展 2：删除指定文件目录及其下的所有文件

```java
import java.io.File;

public class FileTest3 {
    public static void main(String[] args) {
        //printSubFile(new File("C:\\Users\\lemon\\Desktop\\Desktop\\stduy"));
        //System.out.println(getDirectorySize(new File("C:\\Users\\lemon\\Desktop\\Desktop\\stduy")));
        deleteDirectory(new File("C:\\Users\\lemon\\Desktop\\C++小游戏项目"));
    }

    /**
     * 递归实现
     */
    public static void printSubFile(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                printSubFile(file);
            } else {
                System.out.println(file.getAbsoluteFile());
            }
        }
    }

    //拓展一
    public static long getDirectorySize(File file) {
        File[] files = file.listFiles();
        long size = 0;
        for (File f : files) {
            if (f.isFile()) {
                size += f.length();
            } else {
                size += getDirectorySize(f);
            }
        }
        return size;
    }

    //拓展二
    public static void deleteDirectory(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                f.delete();
            } else {
                deleteDirectory(f);
            }
        }
        file.delete();
    }
}
```

## 二、`IO`流原理及流的分类

### 2.1 `Java IO` 原理

-   \*\*输入 input：\*\*读取外部数据（磁盘、光盘等存储设备的数据）到程序（内存）中
-   \*\*输出 output：\*\*将程序（内存）数据输出到磁盘、光盘等存储设备中

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-a2c1d2dd.png)

### 2.2 流的分类

-   按操作**数据单位**不同分为：**字节流(8 bit)，字符流(16 bit)**
-   按数据流的**流向**不同分为：**输入流，输出流**
-   按流的**角色**的不同分为：**节点流，处理流**
    \| **抽象基类** | 字节流 | 字符流 |
    \| ------------ | -------------- | -------- |
    \| 输入流 | `InputStream` | `Reader` |
    \| 输出流 | `OutputStream` | `Writer` |

1.  `Java` 的 `IO` 流共涉及 40 多个类，实际上非常规则，都是从以上 4 个抽象基类派生的
2.  由这四个类派生出来的子类名称都是以其父类名作为子类名后缀

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-36edb92e.png)

### 2.3 节点流和处理流

-   节点流：直接从数据源或目的地读写数据

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-259fd22e.png)

-   处理流：不直接连接到数据源或目的地，而是“连接”在已存 在的流（节点流或处理流）之上，通过对数据的处理为程序提供更为强大的读写功能。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-973bc41b.png)

### 2.4 IO 流体系

| **分类**       | **字节输入流**          | **字节输出流**          | **字符输入流**      | **字符输出流**       |
| -------------- | ----------------------- | ----------------------- | ------------------- | -------------------- |
| **抽象基类**   | `InputStream`           | `OutputStream`          | `Reander`           | `Writer`             |
| **访问文件**   | `FileInputStream`       | `FileOutputStream`      | `FileReader`        | `FileWriter`         |
| **访问数组**   | `ByteArrayInputStreram` | `ByteArrayOutputStream` | `CharArrayReader`   | `CharArrayWriter`    |
| **访问管道**   | `PipedInputStream`      | `PipedOutputStream`     | `PipedReader`       | `PipedWriter`        |
| **访问字符串** |                         |                         | `StringReader`      | `StringWriter`       |
| **缓冲流**     | `BufferedInputStream`   | `BufferedOutPutStream`  | `BufferedReader`    | `BufferedWriter`     |
| **转换流**     |                         |                         | `InputStreamReader` | `OutputStreamWriter` |
| **对象流**     | `ObjectInputStream`     | `ObjectOutStream`       |                     |                      |
|                | `FilterInputStream`     | `FilterOutputStream`    | `FilterReader`      | `FilterWriter`       |
| **打印流**     |                         | `PrintStream`           |                     | `PrintWriter`        |
| **推回输入流** | `PushbackInputStream`   |                         | `PushbackReader`    |                      |
| **特殊流**     | `DataInputStream`       | `DataOutputStream`      |                     |                      |

### 2.5 `InputStream` & `Reader`

`InputStream` 和 `Reader` 是所有输入流的基类。
程序中打开的文件 IO 资源不属于内存里的资源，垃圾回收机制无法回收该资 源，所以应该显式关闭文件 IO 资源。
`FileInputStream`从文件系统中的某个文件中获得输入字节。`FileInputStream` 用于读取非文本数据之类的原始字节流。要读取字符流，需要使用 `FileReader`.

#### 2.5.1 InputStream

[InputStream](https://www.yuque.com/lemonsama/zm0p2q/strh83?view=doc_embed)

#### 2.5.2 Reader

[Reader](https://www.yuque.com/lemonsama/zm0p2q/xt0ub9?view=doc_embed)

### 2.6 OutputStream & Writer

`FileOutputStream` 从文件系统中的某个文件中获得输出字节。`FileOutputStream` 用于写出非文本数据之类的原始字节流。要写出字符流，需要使用 `FileWriter`

---

#### 2.6.1 OutputStream

[OutputStream](https://www.yuque.com/lemonsama/zm0p2q/pab9b6?view=doc_embed)

#### 2.6.2 Writer

[Writer](https://www.yuque.com/lemonsama/zm0p2q/xwrrlw?view=doc_embed)

## 三、节点流(或文件流)

### 3.1 `FileInputTest`

```java
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        //1. 造文件
        File file = new File("hello.txt");

        try {
            //2.造流
            fis = new FileInputStream(file);
            //3.读数据
            byte[] buffer = new byte[5];
            int len;//记录每次读取的字节的个数
            while((len = fis.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                //4.关闭资源
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### 3.2 `FileInputOutputTest`

```java
import java.io.*;

public class FileInputOutStream {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("爱情与友情.jpg");
            File destFile = new File("爱情与友情2.jpg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### 3.3 FileReaderTest

```java
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file = new File("hello.txt");//相较于当前Module
            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            //read():返回读入的一个字符。如果达到文件末尾，返回-1
            int data;
            while((data = fr.read()) != -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //对read()操作升级：使用read的重载方法
    public static void fileReaderTest()  {
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                //4.资源的关闭
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
```

### 3.4 FileWriterTest

```java
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");
            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file,false);
            //3.写出的操作
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### 3.5 FileReaderFileWriterTest

```java
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderFileWriterTest {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");
            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符的个数
            while((len = fr.read(cbuf)) != -1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

### 3.6 注意点

1.  定义文件路径时，注意：可以用“/”或者“\”。
2.  在写入一个文件时，如果使用构造器`FileOutputStream(file)`，则目录下有同名文件将被覆盖。
3.  如果使用构造器`FileOutputStream(file,true)`，则目录下的同名文件不会被覆盖，在文件内容末尾追加内容。
4.  在读取文件时，必须保证该文件已存在，否则报异常。
5.  字节流操作字节，比如：.mp3，.avi，.rmvb，mp4，.jpg，.doc，.ppt
6.  字符流操作字符，只能操作普通文本文件。最常见的文本文件：.txt，.java，.c，.cpp 等语言的源代码。尤其注意.doc, excel, ppt 这些不是文本文件。

## 四、缓冲流

-   为了提高数据读写的速度，Java API 提供了带缓冲功能的流类，在使用这些流类时，会创建一个内部缓冲区数组，缺省使用 8192 个字节(8Kb)的缓冲区。

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-1225260a.png)

-   缓冲流要“套接”在相应的节点流之上，根据数据操作单位可以把缓冲流分为：
    -   `BufferedInputStream` 和 `BufferedOutputStream`
    -   `BufferedReader`和 `BufferedWriter`
-   当读取数据时，数据按块读入缓冲区，其后的读操作则直接访问缓冲区。
-   当使用`BufferedInputStream`读取字节文件时，`BufferedInputStream`会一次性从文件中读取 8192 个(8Kb)，存在缓冲区中，直到缓冲区装满了，才重新从文件中读取下一个 8192 个字节数组。
-   向流中写入字节时，不会直接写到文件，先写到缓冲区中直到缓冲区写满，`BufferedOutputStream`才会把缓冲区中的数据一次性写到文件里。使用方法`flush()`可以强制将缓冲区的内容全部写入输出流。
-   关闭流的顺序和打开流的顺序相反。只要关闭最外层流即可，关闭最外层流也会相应关闭内层节点流。
-   `flush()`方法的使用：手动将 buffer 中内容写入文件
-   如果是带缓冲区的流对象的`close()`方法，不但会关闭流，还会在关闭流之前刷新缓冲区，关闭后不能再写出

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-fecda346.png)

### 4.1 BufferedTest

```java
package java_test.stream;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) {

    }

    /*
    实现非文本文件的复制
     */
    public static void BufferedStreamTest() throws FileNotFoundException {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("爱情与友情.jpg");
            File destFile = new File("爱情与友情3.jpg");
            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream((srcFile));
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //以上几步可写成下面一步：
//            bis = new BufferedInputStream(new FileInputStream(new File("爱情与友情.jpg")));
//            bos = new BufferedOutputStream(new FileOutputStream((new File("爱情与友情3.jpg"))));

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fos.close();
//        fis.close();
        }
    }

    //实现文件复制的方法
    public static void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream((srcFile));
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层的流，再关闭内层的流
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略.
//        fos.close();
//        fis.close();
        }
    }


    /*
    使用BufferedReader和BufferedWriter实现文本文件的复制
     */

    public static void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写操作
            //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//    //            bw.flush();
//            }

            //方式二：使用String
            String data;
            while((data = br.readLine()) != null){
                //方法一：
//                bw.write(data + "\n");//data中不包含换行符
                //方法二：
                bw.write(data);//data中不包含换行符
                bw.newLine();//提供换行的操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### 4.2 练习

#### 4.2.1 分别使用节点流：FileInputStream、FileOutputStream 和缓冲流：BufferedInputStream、BufferedOutputStream 实现文本文件/图片/视频文件的复制。并比较二者在数据复制方面的效率

```java
import java.io.*;

public class Exercise1 {
    public static void main(String[] args) {
        //copyFileWithStream("D:\\Download\\aDrive\\视频\\yt1s.com - 米津玄師  MVLemon.mp4", "C:\\Users\\lemon\\Desktop\\米津玄師  MVLemon.mp4");
        //copyFileWithBuffered("D:\\Download\\aDrive\\视频\\yt1s.com - 米津玄師  MVLemon.mp4", "C:\\Users\\lemon\\Desktop\\MVLemon.mp4");

    }

    public static void copyFileWithStream(String scr, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(new File(scr));
            fos = new FileOutputStream(new File(dest));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void copyFileWithBuffered(String scr, String dest) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(new File(scr)));
            bos = new BufferedOutputStream(new FileOutputStream(new File(dest)));

            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

#### 4.2.1 实现图片加密操作

```java
import java.io.*;

public class Exercise2 {
    public static void main(String[] args) {
        encryption("C:\\Users\\lemon\\Desktop\\0e5c0ea1457e0719547a87e9d70fde97f40837d7.jpg", "C:\\Users\\lemon\\Desktop\\test.jpg");
        encryption("C:\\Users\\lemon\\Desktop\\test.jpg", "C:\\Users\\lemon\\Desktop\\test1.jpg");
    }

    public static void encryption(String scr, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(new File(scr));
            fos = new FileOutputStream(new File(dest));

            int b = 0;
            while ((b = fis.read()) != -1) {
                fos.write(b ^ 5);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

#### 4.2.3 获取文本上每个字符出现的次数

```java
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Exercise4 {
    public static void main(String[] args) {
        wordCount("C:\\Users\\lemon\\Desktop\\新建文本文档.txt");
    }

    public static void wordCount(String filePath) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        Map<Character, Integer> map = new HashMap<>();

        try {
            br = new BufferedReader(new FileReader(new File(filePath)));
            bw = new BufferedWriter(new FileWriter(new File("file\\text\\wordCount.txt")));

            int b = 0;
            while ((b = br.read()) != -1) {
                char ch = (char)b;
                if (!map.containsKey(ch)) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }

            Set<Map.Entry<Character, Integer>> entries = map.entrySet();

            for (Map.Entry<Character, Integer> entry : entries) {
                switch (entry.getKey()) {
                    case ' ':
                        bw.write("空格=" + entry.getValue());
                        break;
                    case '\t':
                        bw.write("tab键=" + entry.getValue());
                        break;
                    case '\r':
                        bw.write("回车键=" + entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行符" + entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey() + "=" + entry.getValue());
                }
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

## 五、转换流

-   转换流提供了在字节流和字符流之间的转换。
-   Java API 提供了两个转换流：
    -   `InputStreamReader`：将`InputStream`转换为`Reader`
    -   `OutputStreamWriter：将`**Writer**`转换为`**OutputStream**\`
-   字节流中的数据都是字符时，转成字符流操作更高效。
-   很多时候我们使用转换流来处理文件乱码问题。实现编码和解码的功能。

### 5.1 `InputStreamReade`

-   实现将字节的输入流按指定字符集转换为字符的输入流。

-   需要和`InputStream`“套接”。

-   构造器
    -   `public InputStreamReader(InputStream in)`
    -   `public InputSreamReader(InputStream in, String charsetName)`

如： `Reader isr = new InputStreamReader(System.in,"gbk");`

---

### 5.2 OutputStreamWriter

-   实现将字符的输出流按指定字符集转换为字节的输出流。

-   需要和`OutputStream`“套接”。

-   构造器
    -   `public OutputStreamWriter(OutputStream out)`
    -   `public OutputSreamWriter(OutputStream out, String charsetName)`

![](https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/8919/yank-note-picgo-4999a74a.png)

### 5.3 InputStreamReaderOutStreamWriterTest

```java
import java.io.*;

public class InputStreamReaderOutStreamWriterTest {
    public static void main(String[] args) {
        inputStreamReaderOutStreamWriterTest();
    }

    public static void inputStreamReaderTest() {
        InputStreamReader isr = null;

        try {
            isr = new InputStreamReader(new FileInputStream(new File("file\\text\\wordCount.txt")));

            char[] cbuf = new char[20];
            int len;

            while ((len = isr.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void inputStreamReaderOutStreamWriterTest() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;

        try {
            isr = new InputStreamReader(new FileInputStream(new File("file\\text\\text1.txt")), "UTF-8");
            osw = new OutputStreamWriter(new FileOutputStream(new File("file\\text\\text2.txt")), "GBK");

            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

## 六、标准输入、输出流

-   `System.in`和`System.out`分别代表了系统标准的输入和输出设备
-   默认输入设备是：键盘，输出设备是：显示器
-   `System.in`的类型是`InputStream`
-   `System.out`的类型是`PrintStream`，其是`OutputStream`的子类、`FilterOutputStream` 的子类
-   重定向：通过`System`类的`setIn()`，`setOut()`方法对默认设备进行改变
    -   `public static void setIn(InputStream in)`
    -   `public static void setOut(PrintStream out)`

---

### 6.1 例题

从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Examples {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true) {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### 6.2 练习

Create a program named MyInput.java: Contain the methods for reading int, double, float, boolean, short, byte and String values from the keyboard.

```java
// MyInput.java: Contain the methods for reading int, double, float, boolean, short, byte and
// string values from the keyboard

import java.io.*;

public class MyInput {
    // Read a string from the keyboard
    public static String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Declare and initialize the string
        String string = "";

        // Get the string from the keyboard
        try {
            string = br.readLine();

        } catch (IOException ex) {
            System.out.println(ex);
        }

        // Return the string obtained from the keyboard
        return string;
    }

    // Read an int value from the keyboard
    public static int readInt() {
        return Integer.parseInt(readString());
    }

    // Read a double value from the keyboard
    public static double readDouble() {
        return Double.parseDouble(readString());
    }

    // Read a byte value from the keyboard
    public static double readByte() {
        return Byte.parseByte(readString());
    }

    // Read a short value from the keyboard
    public static double readShort() {
        return Short.parseShort(readString());
    }

    // Read a long value from the keyboard
    public static double readLong() {
        return Long.parseLong(readString());
    }

    // Read a float value from the keyboard
    public static double readFloat() {
        return Float.parseFloat(readString());
    }
}
```

## 七、打印流

-   实现将基本数据类型的数据格式转化为字符串输出
-   打印流：`PrintStream`和`PrintWriter`
    -   提供了一系列重载的`print()`和`println()`方法，用于多种数据类型的输出
    -   `PrintStream`和`PrintWriter的输出不会抛出`IOException 异常
    -   `PrintStream和`PrintWriter`有自动 `flush\` 功能
    -   `PrintStream`打印的所有字符都使用平台的默认字符编码转换为字节。 在需要写入字符而不是写入字节的情况下，应该使用 `PrintWriter` 类
    -   `System.out`返回的是`PrintStream`的实例

### 7.1 PrintStreamTest

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
    public static void main(String[] args) {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\IO\\text.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }

            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }
}
```

## 八、数据流

-   为了方便地操作 Java 语言的基本数据类型和 String 的数据，可以使用数据流
-   数据流有两个类：(用于读取和写出基本数据类型、String 类的数据）
    -   `DataInputStream` 和 `DataOutputStream`
    -   分别“套接”在 `InputStream `和 `OutputStream` 子类的流上
-   `DataInputStream`中的方法：
    -   `boolean readBoolean()`
    -   `char readChar()`
    -   `double readDouble()`
    -   `long readLong()`
    -   `String readUTF()`
    -   `byte readByte()`
    -   `float readFloat()`
    -   `short readShort()`
    -   `int readInt()`
    -   `void readFully(byte[] b)`
-   `DataOutputStream`中的方法
    -   将上述的方法的 read 改为相应的 write 即可

### 8.1 DataInputStreamDataOutputStreamTest

```java
import java.io.*;

public class DataInputStreamDataOutputStreamTest {
    public static void main(String[] args) {

    }

    public static void dataOutputStreamTest() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data.txt"));
            dos.writeUTF("刘建辰");
            dos.flush();//刷新操作，将内存中的数据写入文件
            dos.writeInt(23);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void dataInputStreamTest() {
        //1.
        DataInputStream dis = null;
        //2.
        try {
            dis = new DataInputStream(new FileInputStream("data.txt"));
            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();
            System.out.println("name = " + name);
            System.out.println("age = " + age);
            System.out.println("isMale = " + isMale);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

## 九、对象流

### 9.1 `ObjectInputStream`和`OjbectOutputSteam`

-   用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把 Java 中的对象写入到数据源中，也能把对象从数据源中还原回来。

-   序列化：用`ObjectOutputStream`类保存基本类型数据或对象的机制

-   反序列化：用`ObjectInputStream`类读取基本类型数据或对象的机制

-   `ObjectOutputStream`和`ObjectInputStream`不能序列化`static`和`transient`修饰的成员变量

### 9.2 对象的序列化

-   对象序列化机制允许把内存中的 Java 对象转换成平台无关的二进制流，从 而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。当其它程序获取了这种二进制流，就可以恢复成原来的 Java 对象
-   序列化的好处在于可将任何实现了`Serializable`接口的对象转化为字节数据， 使其在保存和传输时可被还原
-   序列化是 RMI（Remote Method Invoke – 远程方法调用）过程的参数和返回值都必须实现的机制，而 RMI 是 JavaEE 的基础。因此序列化机制是 JavaEE 平台的基础
-   如果需要让某个对象支持序列化机制，则必须让对象所属的类及其属性是可序列化的，为了让某个类是可序列化的，该类必须实现如下两个接口之一。 否则，会抛出`NotSerializableException`异常
    -   `Serializable`
    -   `Externalizable`
-   凡是实现`Serializable`接口的类都有一个表示序列化版本标识符的静态变量：
    -   `private static final long serialVersionUID;`
    -   `serialVersionUID`用来表明类的不同版本间的兼容性。简言之，其目的是以序列化对象进行版本控制，有关各版本反序列化时是否兼容
    -   如果类没有显示定义这个静态常量，它的值是 Java 运行时环境根据类的内部细节自 动生成的。若类的实例变量做了修改，`serialVersionUID`可能发生变化。故建议， 显式声明。
-   简单来说，Java 的序列化机制是通过在运行时判断类的`serialVersionUID`来验 证版本一致性的。在进行反序列化时，JVM 会把传来的字节流中的 `serialVersionUID`与本地相应实体类的`serialVersionUID`进行比较，如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常。(`InvalidCastException`)

### 9.3 使用对象流序列化对象

-   若某个类实现了 `Serializable`接口，该类的对象就是可序列化的：
    -   创建一个 `ObjectOutputStream`
    -   调用 `ObjectOutputStream`对象的 `writeObject` 方法输出可序列化对象
    -   注意写出一次，操作`flush()`一次
-   反序列化
    -   创建一个 `ObjectInputStream`
    -   调用 `readObject()` 方法读取流中的对象
-   强调：如果某个类的属性不是基本数据类型或 String 类型，而是另一个引用类型，那么这个引用类型必须是可序列化的，否则拥有该类型的 `Field` 的类也不能序列化

### 9.4 ObjectInputOutputStreamTest

```java
import java.io.*;

public class ObjectInputOutputStreamTest {
    public static void main(String[] args) {

    }

    public void objectOutputStreamTest(){
        ObjectOutputStream oos = null;

        try {
            //1.
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //2.
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("王铭",23));
            oos.flush();

            oos.writeObject(new Person("张学良",23,1001,new Account(5000)));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null){

                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    反序列化：将磁盘文件中的对象还原为内存中的一个java对象
    使用ObjectInputStream来实现
     */

    public void objectInputStreamTest(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;

            Person p = (Person) ois.readObject();
            Person p1 = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
            System.out.println(p1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Person implements Serializable {
    private static final long serialVersionUID = 4541184984945647898L;
    private String name;
    private int age;
    private int id;
    private Account account;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Account account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public Person(String name, int age, int id, Account account) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.account = account;
    }

    public Person() {
    }
}

class Account implements Serializable {
    private static final long serialVersionUID = 5894554948144646879L;
    int money;

    public Account(int money) {
        this.money = money;
    }

    public Account() {
    }
}
```

## 十、随机存取文件流

### 10.1 RandomAccessFile 类

-   `RandomAccessFile` 声明在`java.io`包下，但直接继承于`java.lang.Object`类。并 且它实现了`DataInput`、`DataOutput`这两个接口，也就意味着这个类既可以读也可以写
-   `RandomAccessFile` 类支持 “随机访问” 的方式，程序可以直接跳到文件的任意地方来读、写文件
    -   支持只访问文件的部分内容
    -   可以向已存在的文件后追加内容
-   `RandomAccessFile` 对象包含一个记录指针，用以标示当前读写处的位置
-   `RandomAccessFile` 类对象可以自由移动记录指针：
    -   `long getFilePointer()`:获取文件记录指针的当前位置
    -   `void seek(long pos)`:将文件记录指针定位到 pos 位置
-   构造器：
    -   `public RandomAccessFile(File file, String mode)`
    -   `public RandomAccessFile(String name, String mode)`
-   创建 `RandomAccessFile` 类实例需要指定一个 `mode` 参数，该参数指 定 `RandomAccessFile` 的访问模式：
    -   r：以只读方式打开
    -   rw：打开以便读取和写入
    -   rwd：打开以便读取和写入；同步文件内容的更新
    -   rws：打开以便读取和写入；同步文件内容和元数据的更新
-   如果模式为只读 r。则不会创建文件，而是会去读取一个已经存在的文件， 如果读取的文件不存在则会出现异常。 如果模式为 rw 读写。如果文件不 存在则会去创建文件，如果存在则不会创建

我们可以用`RandomAccessFile`这个类，来实现一个多线程断点下载的功能，用过下载工具的朋友们都知道，下载前都会建立两个临时文件，一个是与被下载文件大小相同的空文件，另一个是记录文件指针的位置文件，每次暂停的时候，都会保存上一次的指针，然后断点下载的时候，会继续从上 一次的地方下载，从而实现断点下载或上传的功能，有兴趣的朋友们可以自己实现下

### 10.2 RandomAccessFileTest

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) {

    }

    public static void randomAccessFileInputOutputTest() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            //1.
            raf1 = new RandomAccessFile(new File("爱情与友情.jpg"),"r");
            raf2 = new RandomAccessFile(new File("爱情与友情1.jpg"),"rw");
            //2.
            byte[] buffer = new byte[1024];
            int len;
            while((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void seekTest() {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("hello.txt","rw");
            raf1.seek(3);//将指针调到角标为3的位置
            raf1.write("xyz".getBytes());//
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    使用RandomAccessFile实现数据的插入效果
     */
    public static void insertTest() {
        RandomAccessFile raf1 = null;

        try {
            raf1 = new RandomAccessFile("hello.txt","rw");
            raf1.seek(3);//将指针调到角标为3的位置
            //保存指针3后面的所有数据到StringBuilder中
            StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());
            byte[] buffer = new byte[20];
            int len;
            while((len = raf1.read(buffer)) != -1){
                builder.append(new String(buffer,0,len)) ;
            }
            //调回指针，写入“xyz”
            raf1.seek(3);
            raf1.write("xyz".getBytes());

            //将StringBuilder中的数据写入到文件中
            raf1.write(builder.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //思考：将StringBuilder替换为ByteArrayOutputStream
    }
}
```

## 十一、 `NIO.2`中`Path`、 `Paths`、`Files`类的使用

### 11.1 Java NIO 概述

-   `Java NIO (New IO，Non-Blocking IO)`是从 Java 1.4 版本开始引入的一套新的 IO API，可以替代标准的 Java IO API。NIO 与原来的 IO 有同样的作用和目的，但是使用的方式完全不同，`NIO`支持面向缓冲区的(IO 是面向流的)、基于通道的 IO 操作。NIO 将以更加高效的方式进行文件的读写操作。
-   Java API 中提供了两套`NIO`，一套是针对标准输入输出`NIO`，另一套就是网络编程`NIO`
    -   \|-----`java.nio.channels.Channel`
        -   \|-----`FileChannel`:处理本地文件
        -   \|-----`SocketChannel`：TCP 网络编程的客户端的 Channel
        -   \|-----`ServerSocketChannel`：TCP 网络编程的服务器端的 Channel
        -   \|-----`DatagramChannel`：UDP 网络编程中发送端和接收端的 Channel

### 11.2 NIO. 2

随着 JDK 7 的发布，Java 对 NIO 进行了极大的扩展，增强了对文件处理和文件系统特性的支持，以至于我们称他们为 NIO.2。 因为 NIO 提供的一些功能，NIO 已经成为文件处理中越来越重要的部分

### 11.3 Path、Paths 和 Files 核心 API

-   早期的 Java 只提供了一个`File`类来访问文件系统，但`File`类的功能比较有限，所提供的方法性能也不高。而且，大多数方法在出错时仅返回失败，并不会提供异常信息
-   `NIO. 2`为了弥补这种不足，引入了`Path`接口，代表一个平台无关的平台路径，描述了目录结构中文件的位置。Path 可以看成是 File 类的升级版本，实际引用的资源也可以不存在
-   在以前 IO 操作都是这样写的：

```java
import java.io.File;
File file = new File("index.html");
```

-   但在 Java7 中，我们可以这样写：

```java
import java.nio.file.Path;
import java.nio.file.Paths;
Path path = Paths.get("index.html");
```

-   同时，`NIO.2`在`java.nio.file`包下还提供了`Files`、`Paths`工具类`Files`包含了大量静态的工具方法来操作文件；`Paths`则包含了两个返回`Path`的静态工厂方法
-   `Paths` 类提供的静态 `get() 方法用来获取 `**Path**\`对象：
    -   `static Path get(String first, String … more)` : 用于将多个字符串串连成路径
    -   `static Path get(URI uri)`：返回指定`uri`对应的`Path`路径

### 11.4 `Path` 接口

[Path 接口](https://www.yuque.com/lemonsama/zm0p2q/zk2xk6?view=doc_embed)

### 11.5 Files 类

[Files 类](https://www.yuque.com/lemonsama/zm0p2q/pkp6dg?view=doc_embed)
