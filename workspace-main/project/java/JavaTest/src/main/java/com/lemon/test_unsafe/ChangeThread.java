package com.lemon.test_unsafe;

import lombok.Getter;
import sun.misc.Unsafe;


@Getter
class ChangeThread implements Runnable {

    /**
     * volatile
     **/
    boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("subThread change flag to:" + flag);
        flag = true;
    }

    public static void main(String[] args) {
        Unsafe unsafe = new Test1().reflectGetUnsafe();
        ChangeThread changeThread = new ChangeThread();
        new Thread(changeThread).start();
        while (true) {
            boolean flag = changeThread.isFlag();
            unsafe.loadFence(); //加入读内存屏障
            if (flag) {
                System.out.println("detected flag changed");
                break;
            }
        }
        System.out.println("main thread end");
    }
}
