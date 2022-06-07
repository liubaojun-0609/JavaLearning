package com.liubj.inet1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一、通信要素    IP、Port
 *  1.IP:唯一的标识一台Internet上的计算机
 *  2.在Java中使用InetAddress来表示IP
 *  3.端口号
 *      表示正在计算机上运行的程序；
 *      范围是0~65535  2^16；
 *  4.IP和端口号组合得到网络套接字：Socket
 *  5.传输控制层协议
 *      传输控制协议  TCP
 *      用户数据包协议   UDP
 *
 *
 */
public class InetTest {
    public static void main(String[] args) {
        try {

            //实例化InetAddress
            InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress.getHostName());
            System.out.println(inetAddress.getHostAddress());

            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost.getHostName());
            System.out.println(localHost.getHostAddress());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
