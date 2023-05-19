---
title: Java GUI
author: Lemon
top: false
cover: false
toc: true
mathjax: false
summary: 介绍Java的GUI编程
tags:
  - Java
  - GUI
  - AWT
  - Swing
categories:
  - Java
reprintPolicy: cc_by
abbrlink: 94bc9262
date: 2021-12-14 21:13:40
coverImg:
img:
password:
---

告诉大家该什么学？

-   这是什么？
-   它什么玩？
-   该如何去在我们平时运用？

组件

-   窗口
-   弹窗
-   面板
-   文本框
-   列表框
-   按钮
-   图片
-   监听事件
-   鼠标
-   键盘
-   破解工具

## 1、简介

GUI 的核心：Swing 和 AWT

1. 界面不美观
2. 需要 JRE 环境

为什么要学习？

1. 了解 MVC 架构，了解监听
2. 可以写出自己心中的一些小工具
3. 工作的时候也可能需要维护到 Swing 界面（虽然概率不大）

## 2、AWT

### 2.1 AWT 介绍

1. 包含了很多类和接口，用于 GUI（图像用户编程）编程
2. 包含很多元素：窗口、按钮、文本框等
3. java.awt

![image-20211215162841693](/FILES/image/6cde93be.png)

### 2.2 组件和容器

#### 1、Frame

```java
import java.awt.*;

public class FrameTest {
    public static void main(String[] args) {
        Frame frame = new Frame("第一个GUI界面");
        //设置窗口大小
        frame.setSize(400, 400);
        //设置颜色
        frame.setBackground(Color.GREEN);
        //设置弹出初始位置
        frame.setLocation(200, 200);
        //设置大小固定
        frame.setResizable(false);
        //必须设置可见性
        frame.setVisible(true);
    }
}

```

![image-20211224094339646](/FILES/image/9e478d07.png)

问题：无法关闭窗口，只能停止 java 程序

-   如何一次性输出多个 frame

##### 封装一个 JFrame 类，创建多个窗口

```java
import java.awt.*;

public class MyFrameTest {
    public static void main(String[] args) {
        MyFrame myFrame1 = new MyFrame(100, 100, 200, 200, Color.blue);
        MyFrame myFrame2 = new MyFrame(300, 100, 200, 200, Color.YELLOW);
        MyFrame myFrame3 = new MyFrame(100, 300, 200, 200, Color.PINK);
        MyFrame myFrame4 = new MyFrame(300, 300, 200, 200, Color.MAGENTA);
    }
}
```

```java
import java.awt.*;

public class MyFrame extends Frame {
    static int count = 0;
    public MyFrame(int x, int y, int w, int h, Color color) {
        super("MyFrame" + (++count));
        setBackground(color);
        this.setVisible(true);
        this.setBounds(x, y, w, h);
    }
}
```

![image-20211224095513762](/FILES/image/8d1de355.png)

#### 2、面板（Panel）

frame 中放置一个固定面板

```java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PanelTest {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel = new Panel();

        frame.setLayout(null);
        frame.setBounds(300, 300, 500, 500);
        frame.setBackground(new Color(0x43FF02));

        //panel 坐标设置，相对于 frame
        panel.setBounds(50, 50, 400, 400);
        panel.setBackground(new Color(0xFFA2161B, true));

        frame.add(panel);
        frame.setVisible(true);

        //事件监听，监听窗口结束
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
```

![image-20211224100635380](/FILES/image/4ba708e0.png)

> 由于写了添加了事件监听器，所以点击关闭可以退出窗口

### 2.3 布局管理器

#### 1、流式布局

```java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FlowLayoutTest {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //按钮组件
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        //设置为流式布局
        frame.setLayout(new FlowLayout());

        frame.setSize(200, 200);
        //添加按钮
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}

```

![image-20211224101554575](/FILES/image/e65b36cb.png)

注意：流式布局默认为居中，如果想要靠左或靠右请将 `frame.setLayout(new FlowLayout());` 改为 `frame.setLayout(new FlowLayout(FlowLayout.LEFT));` 或 `frame.setLayout(new FlowLayout(FlowLayout.RIGHT));`，效果如下：

![image-20211224101824287](/FILES/image/4f8fcaaf.png)

![image-20211224101906916](/FILES/image/86797c30.png)

#### 2、东南西北中

```java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderLayoutTest {
    public static void main(String[] args) {
        Frame frame = new Frame("BorderLayoutTest");

        Button east = new Button("East");
        Button west = new Button("West");
        Button south = new Button("South");
        Button north = new Button("North");
        Button center = new Button("Center");

        frame.add(east, BorderLayout.EAST);
        frame.add(west, BorderLayout.WEST);
        frame.add(south, BorderLayout.NORTH);
        frame.add(north, BorderLayout.SOUTH);
        frame.add(center, BorderLayout.CENTER);

        frame.setSize(200, 200);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}
```

![image-20211224102907465](/FILES/image/8016bbc8.png)

#### 3、表格布局（Grid）

```java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridLayoutTest {
    public static void main(String[] args) {
        Frame frame = new Frame("GridLayoutTest");

        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn3");
        Button btn4 = new Button("btn4");
        Button btn5 = new Button("btn5");
        Button btn6 = new Button("btn6");

        frame.setLayout(new GridLayout(3, 2));

        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);
        //自动填充
        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}
```

![image-20211224103409532](/FILES/image/00bd7ffe.png)

#### 4、练习

分析：

![kuangstudyabc62467-a3df-4e48-8aa6-b758a2369961](/FILES/image/5c904b20.png)

```java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Exercise1 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setLayout(new GridLayout(2, 1));

        Panel panel1 = new Panel(new BorderLayout());
        Panel panel2 = new Panel(new GridLayout(2, 1));
        Panel panel3 = new Panel(new BorderLayout());
        Panel panel4 = new Panel(new GridLayout(2, 2));

        panel1.add(new Button("East-1"), BorderLayout.EAST);
        panel1.add(new Button("West-1"), BorderLayout.WEST);

        panel2.add(new Button("p2-btn-1"));
        panel2.add(new Button("p2-btn-2"));

        panel1.add(panel2, BorderLayout.CENTER);

        panel3.add(new Button("East-2"), BorderLayout.EAST);
        panel3.add(new Button("West-2"), BorderLayout.WEST);

        for (int i = 0; i < 4; i++) {
            panel4.add(new Button("for-" + i));
        }
        panel3.add(panel4);

        frame.add(panel1);
        frame.add(panel3);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}
```

![image-20211224122950937](/FILES/image/b787f1d5.png)

#### 5、总结

1. Frame 是一个顶级窗口
2. Panel 无法单独显示，必须添加到某个容器中
3. 布局管理器
    1. 流式
    2. 东西南北中
    3. 表格
4. 大小、定位、背景颜色、可见性、监听

### 2.4 事件监听

> 事件监听：当某个事件发生的时候做点什么

##### 关闭事件和单个按钮事件

```java
package com.lemonsama.lesson2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Test");
    }
}
```

```java
package com.lemonsama.lesson2;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyActionListenerTest {
    public static void main(String[] args) {
        //按下按钮，触发事件
        Frame frame = new Frame("ActionEventTest");
        Button button = new Button();
        button.addActionListener(new MyActionListener());
        frame.setLayout(new BorderLayout());
        frame.add(button, BorderLayout.CENTER);
        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }

    public static void closeWindow(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
```

效果如下：

![](/FILES/image/67740cdd.png)

点击按钮后输出：

![image-20211224124607977](/FILES/image/43287f73.png)

##### 两个按钮和关闭事件

```java
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMonitor implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("按钮被点击了：msg=>"+ e.getActionCommand());
    }
}
```

```java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ActionEventTest {
    public static void main(String[] args) {
        //开始按钮，实现同一个事件
        //开始  停止
        Frame frame = new Frame("开始-停止");
        Button button1 = new Button("start");
        Button button2 = new Button("stop");
        MyMonitor myMonitor = new MyMonitor();
        //可以显示定义触发返回的命令，不写则返回 label 的值
        //可以实现都个按钮只写一个监听类
        button2.setActionCommand("button2-stop");
        button1.addActionListener(myMonitor);
        button2.addActionListener(myMonitor);
        frame.add(button1, BorderLayout.NORTH);
        frame.add(button2, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        closeWindow(frame);
    }

    public static void closeWindow(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
```

效果如下：

![image-20211224125819525](/FILES/image/ed9331fc.png)

分别点击 start 和 stop 按钮后输出如下：

![image-20211224125855193](/FILES/image/8da94316.png)

### 2.5 输入框（TextField）监听

```java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener1 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        TextField source = (TextField) e.getSource();
        String text = source.getText();
        System.out.println(text);
        //回车设置为空
        source.setText("");
    }
}
```

```java
import java.awt.*;

public class MyFrame extends Frame {
    public MyFrame() {
        TextField textField = new TextField();
        this.add(textField);
        MyActionListener1 myActionListener1 = new MyActionListener1();
        textField.addActionListener(myActionListener1);
        //设置替换码
        textField.setEchoChar('*');
        this.setVisible(true);
        this.pack();
    }
}
```

```java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextFieldTest {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        closeWindow(myFrame);
    }

    public static void closeWindow(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
```

效果如下：

![image-20211224131223725](/FILES/image/d0be7d79.png)

输入一些内容并回车：

![image-20211224131248616](/FILES/image/5248d46e.png)

![image-20211224131301777](/FILES/image/26e52290.png)

![image-20211224131310675](/FILES/image/da800d27.png)

### 2.6 简易计算器（加法）的实现

```java
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator extends Frame {
    TextField textField1;
    TextField textField2;
    TextField textField3;

    public void loadFrame() {
        textField1 = new TextField(10);
        textField2 = new TextField(10);
        textField3 = new TextField(20);

        Button button = new Button("=");

        Label label = new Label("+");

        this.setLayout(new FlowLayout());
        this.add(textField1);
        this.add(label);
        this.add(textField2);
        this.add(button);
        this.add(textField3);
        pack();
        setVisible(true);

        button.addActionListener(new CalculatorListener());
        closeWindow(this);
    }

    private class CalculatorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int a = Integer.parseInt(textField1.getText());
            int b = Integer.parseInt(textField2.getText());
            textField3.setText((a + b) + "");
            textField1.setText("");
            textField2.setText("");
        }
    }

    public static void closeWindow(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
```

```java
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.loadFrame();
    }
}
```

效果如下：

![image-20211224134141937](/FILES/image/0dfb53a9.png)

演示：

![image-20211224134207913](/FILES/image/d1dc2463.png)

![image-20211224134212776](/FILES/image/f7ba6d39.png)

### 2.7 画笔

```java
import java.awt.*;

public class MyPaint extends Frame {

    public void loadFrame() {
        setBounds(200, 200, 600, 500);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        //画笔需要有颜色
        g.setColor(Color.RED);
        g.drawOval(100, 100, 100, 100);
        g.fillOval(100, 100, 100, 100);//实心圆

        g.setColor(Color.GREEN);
        g.fillRect(150, 200, 200, 200);

        //画笔用完，还原到最初的颜色
        g.setColor(Color.BLACK);
    }
}
```

```java
public class PaintTest {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}
```

效果如下：

![image-20211224192221700](/FILES/image/ada8f8e7.png)

### 2.8 鼠标监听

目的：鼠标画画

![kuangstudyf0e355a9-8f80-4ab0-ae00-1d9848188922](/FILES/image/88b4edb2.png)

```java
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class MyFrame extends Frame {
    //画画需要画笔，需要监听鼠标的位置，需要集合来存储这个点
    ArrayList points;
    //我的窗口
    public MyFrame(String title) {
        super(title);
        setBounds(200, 200, 400, 400);
        //存鼠标点击的点
        points = new ArrayList<>();
        //鼠标监听器，针对与这个窗口
        this.addMouseListener(new MyMouseListener());
        setVisible(true);
    }
    //画笔事件
    @Override
    public void paint(Graphics g) {
        //画画需要监听鼠标事件
        Iterator iterator = points.iterator();
        while (iterator.hasNext()) {
            Point next = (Point) iterator.next();
            g.setColor(Color.BLUE);
            g.fillRect(next.x, next.y, 10, 10);
        }
    }
    //添加一个点到界面上
    public void addPaint(Point point) {
        points.add(point);
    }
    //适配器模式
    //鼠标监听器
    private class MyMouseListener extends MouseAdapter {
        //鼠标点击
        @Override
        public void mousePressed(MouseEvent e) {
            MyFrame myFrame = (MyFrame) e.getSource();
            //我们在点击的时候，就会在界面上产生一个点
            //这个点就是当前鼠标
            myFrame.addPaint(new Point(e.getX(), e.getY()));
            //每次点击都需要刷新画笔重新画点
            myFrame.repaint();
        }
    }
}
```

```java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseListenerTest {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("画");
        shoutWindow(myFrame);
    }
    //窗口关闭监听器
    public static void shoutWindow(Frame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
```

效果如下：

![image-20211224195717112](/FILES/image/d34506b2.png)

### 2.9 窗口监听

```java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowFream extends Frame {
    public WindowFream() {
        setBackground(Color.BLUE);
        setBounds(100, 100, 200, 200);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });
    }
}
```

```java
public class WindowTest {
    public static void main(String[] args) {
        new WindowFream();
    }
}
```

![image-20211224230638866](/FILES/image/302c9b66.png)

### 2.10 键盘监听

```java
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyFrame extends Frame {
    public KeyFrame() {
        setBounds(1, 2, 300, 400);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            //键盘按下
            @Override
            public void keyPressed(KeyEvent e) {
                //获取键盘码，可以计算出按下的键
                int keyCode = e.getKeyCode();
                if (keyCode == e.VK_UP) {
                    System.out.println("你按下了上键");
                }
            }
        });
    }
}
```

```java
public class keyListenerTest {
    public static void main(String[] args) {
        new KeyFrame();
    }
}
```

效果如下：

![image-20211224232954120](/FILES/image/e2b34c5a.png)

按下上键后输出：

![image-20211224233023068](/FILES/image/4b39c023.png)

## 3、Swing

### 3.1 窗口、面板

```java
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public void init() {
        this.setBounds(10, 10, 200, 300);
        this.setVisible(true);
        JLabel jLabel = new JLabel("JLabel", JLabel.CENTER);
        this.add(jLabel);
        Container contentPane = this.getContentPane();
        contentPane.setBackground(Color.BLUE);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
```

```java
public class JFrameTest {
    public static void main(String[] args) {
        new MyFrame().init();
    }
}
```

效果如下：

![image-20211225105555228](/FILES/image/10e0552d.png)

### 3.2 弹窗

`JDialog`，弹窗，默认就有关闭事件

```java
import javax.swing.*;
import java.awt.*;

public class MyDialog extends JDialog {
    public MyDialog() {
        this.setVisible(true);
        this.setBounds(100, 100, 500, 500);

        Container contentPane = this.getContentPane();
        contentPane.add(new Label("this is a Label"));
    }
}
```

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogTest extends JFrame {

    public DialogTest() {
        this.setVisible(true);
        setSize(700, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //获取容器
        Container contentPane = this.getContentPane();
        //设置绝对布局
        contentPane.setLayout(null);
        JButton jButton = new JButton("点击弹出一个对话框");
        jButton.setBounds(30, 30, 200, 50);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyDialog();
            }
        });
        contentPane.add(jButton);
    }

    public static void main(String[] args) {
        new DialogTest();
    }
}
```

效果如下：

![image-20211225111112198](/FILES/image/8f764481.png)

![image-20211225111151337](/FILES/image/1f9ebcfc.png)

### 3.3 标签(label)

icon 图标(可以放在标签中也可以放在按钮中)，可以自己绘制放到标签中

```java
import javax.swing.*;
import java.awt.*;

public class IconTest extends JFrame implements Icon {

    private int width;
    private int height;

    public IconTest() {}

    public IconTest(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void init() {
        IconTest iconTest = new IconTest(15, 15);
        JLabel jLabel = new JLabel("IconTest", iconTest, SwingConstants.CENTER);
        Container contentPane = this.getContentPane();
        contentPane.add(jLabel);
        this.setVisible(true);
        this.setBounds(100, 100, 300, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new IconTest().init();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x, y, this.width, this.height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }
}
```

效果如图：

![image-20211225115957214](/FILES/image/a600935f.png)

可以将图片当做图标来使用 ImageIcon

```java
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MyImageIcon extends JFrame {

    public MyImageIcon() {
        JLabel jLabel = new JLabel("ImageIcon");
        URL resource = MyImageIcon.class.getResource("1640404870375.png");

        ImageIcon imageIcon = new ImageIcon(resource);
        jLabel.setIcon(imageIcon);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Container contentPane = getContentPane();
        contentPane.add(jLabel);
        setBounds(100, 100, 200, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyImageIcon();
    }
}
```

效果如下：

![image-20211225120417924](/FILES/image/32780177.png)

### 3.4 面板

JPanel

```java
import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JFrame {

    public MyJPanel() {
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(2, 1, 10, 10));

        JPanel jPanel1 = new JPanel(new GridLayout(1, 3));
        JPanel jPanel2 = new JPanel(new GridLayout(1, 2));
        JPanel jPanel3 = new JPanel(new GridLayout(2, 1));
        JPanel jPanel4 = new JPanel(new GridLayout(3, 2));

        jPanel1.add(new Button("1"));
        jPanel1.add(new Button("1"));
        jPanel1.add(new Button("1"));
        jPanel2.add(new Button("2"));
        jPanel2.add(new Button("2"));
        jPanel3.add(new Button("3"));
        jPanel3.add(new Button("3"));
        jPanel4.add(new Button("4"));
        jPanel4.add(new Button("4"));
        jPanel4.add(new Button("4"));
        jPanel4.add(new Button("4"));
        jPanel4.add(new Button("4"));
        jPanel4.add(new Button("4"));

        contentPane.add(jPanel1);
        contentPane.add(jPanel2);
        contentPane.add(jPanel3);
        contentPane.add(jPanel4);

        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyJPanel();
    }
}
```

JScrollPanel，滚动条面板

```java
import javax.swing.*;
import java.awt.*;

public class JScrollTest extends JFrame {

    public JScrollTest() {
        Container contentPane = this.getContentPane();

        //文本域
        JTextArea jTextArea = new JTextArea(20, 50);
        jTextArea.setText("文本框");
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        contentPane.add(jScrollPane);

        this.setVisible(true);
        this.setBounds(100, 100, 300, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollTest();
    }
}
```

效果如下：

![image-20211225121929153](/FILES/image/9f178f90.png)

### 3.5 按钮

#### 自定义图片标签按钮

```java
import javax.swing.*;
import java.awt.*;
import java.net.URL;

    public class JButtonTest extends JFrame {

    public JButtonTest() {
        Container contentPane = this.getContentPane();
        URL resource = JButtonTest.class.getResource("1640404870375.png");
        Icon Icon = new ImageIcon(resource);

        JButton button = new JButton();
        button.setIcon(Icon);
        button.setToolTipText("图片按钮");
        contentPane.add(button);
        this.setSize(500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonTest();
    }
}
```

效果如下：

![image-20211225122813338](/FILES/image/1db0c6d1.png)

#### 单选按钮

```java
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonTest2 extends JFrame {

    public JButtonTest2() {
        Container contentPane = this.getContentPane();
        URL resource = JButtonTest2.class.getResource("1640404870375.png");
        Icon Icon = new ImageIcon(resource);

        JRadioButton jRadioButton1 = new JRadioButton("JRadioButton01");
        JRadioButton jRadioButton2 = new JRadioButton("JRadioButton02");
        JRadioButton jRadioButton3 = new JRadioButton("JRadioButton03");

        //由于单选框只能选择一个，一般分组，一个组中只能选择一个
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);

        contentPane.add(jRadioButton1, BorderLayout.CENTER);
        contentPane.add(jRadioButton2, BorderLayout.NORTH);
        contentPane.add(jRadioButton3, BorderLayout.SOUTH);

        this.setSize(500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonTest2();
    }
}
```

效果如下：

![image-20211225125815005](/FILES/image/70d62b32.png)

![image-20211225125820565](/FILES/image/d64632a9.png)

![image-20211225125834553](/FILES/image/44ba5378.png)

#### 复选按钮

```java
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonTest3 extends JFrame {

    public JButtonTest3() {
        Container contentPane = this.getContentPane();
        URL resource = JButtonTest3.class.getResource("1640404870375.png");
        Icon Icon = new ImageIcon(resource);

        JCheckBox checkBox1 = new JCheckBox("checkBox01");
        JCheckBox checkBox2 = new JCheckBox("checkBox02");

        contentPane.add(checkBox1, BorderLayout.NORTH);
        contentPane.add(checkBox2, BorderLayout.SOUTH);

        this.setSize(500, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonTest3();
    }
}
```

效果如下：

![image-20211225130152945](/FILES/image/591579a9.png)

![image-20211225130202104](/FILES/image/74c791ac.png)

### 3.6 列表

#### 下拉框

```java
import javax.swing.*;
import java.awt.*;

public class ComboboxTest01 extends JFrame {
    public ComboboxTest01() {

        Container contentPane = this.getContentPane();

        JComboBox status = new JComboBox();

        status.addItem(null);
        status.addItem("正在上映");
        status.addItem("已下架");
        status.addItem("即将上映");

        contentPane.add(status);

        this.setVisible(true);
        this.setSize(500, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ComboboxTest01();
    }
}
```

效果如下：

![image-20211225131041198](/FILES/image/0eb2dff7.png)

#### 列表框

```java
import javax.swing.*;
import java.awt.*;

public class ComboboxTest02 extends JFrame {
    public ComboboxTest02() {

        Container contentPane = this.getContentPane();

        String[] contents = {"1", "2", "3"};

        JList jList = new JList(contents);

        contentPane.add(jList);

        this.setVisible(true);
        this.setSize(500, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ComboboxTest02();
    }
}
```

效果如下：

![image-20211225131551204](/FILES/image/5f136609.png)

### 3.7 文本框

#### 文本框

```java
import javax.swing.*;
import java.awt.*;

public class TextTest01 extends JFrame {
    public TextTest01() {

        Container contentPane = this.getContentPane();

        JTextField jTextField1 = new JTextField("hello");
        JTextField jTextField2 = new JTextField("world", 20);

        contentPane.add(jTextField1, BorderLayout.NORTH);
        contentPane.add(jTextField2, BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(500, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TextTest01();
    }
}
```

效果如下：

![image-20211225132312290](/FILES/image/72240ecb.png)

#### 密码框

```java
import javax.swing.*;
import java.awt.*;

public class TextTest02 extends JFrame {
    public TextTest02() {

        Container contentPane = this.getContentPane();

        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setEchoChar('*');

        contentPane.add(jPasswordField);

        this.setVisible(true);
        this.setSize(500, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TextTest02();
    }
}
```

效果如下：

![image-20211225132513703](/FILES/image/9ea43081.png)

#### 文本域

```java
import javax.swing.*;
import java.awt.*;

public class TextTest03 extends JFrame {
    public TextTest03() {

        Container contentPane = this.getContentPane();

        //文本域
        JTextArea jTextArea = new JTextArea(20, 50);
        jTextArea.setText("文本框");
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        contentPane.add(jScrollPane);

        this.setVisible(true);
        this.setBounds(100, 100, 300, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TextTest03();
    }
}
```

效果如下：

![image-20211225132833620](/FILES/image/a39360f4.png)
