package com.liubj.package1;

public class ThreadTest1 {

}


class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
