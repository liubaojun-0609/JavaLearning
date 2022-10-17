package com.liubj.package1;

public class ThreadTest1 {
    public static void main(String[] args) {

    }
}


class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
