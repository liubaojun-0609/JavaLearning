package com.liubj.inet1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 模拟客户端 服务端  发送接收信息
 */
public class TCPTest1 {

    /**
     * 客户端
     */
    @Test
    public void client(){
        //设置请求服务端ip
        InetAddress inet = null;
        Socket socket = null;
        OutputStream os = null;
        try {
            inet = InetAddress.getByName("127.0.0.1");
            //获取客户端Socket
            socket = new Socket(inet, 8899);

            os = socket.getOutputStream();
            os.write("我是客户端，你好~".getBytes());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 服务端
     */
    @Test
    public void server(){
        //获取ServerSocket,设置端口
        ServerSocket ss = null;
        InputStream is = null;
        Socket socket = null;
        ByteArrayOutputStream byteOs = null;
        try {
            ss = new ServerSocket(8899);
            //接收客户端的Socket
            socket = ss.accept();

            //获取客户端的数据
            is = socket.getInputStream();

            byteOs = new ByteArrayOutputStream();
            byte[] buffer = new byte[10];
            int len;
            while ((len = is.read(buffer)) != -1){
                byteOs.write(buffer,0,len);
            }
            System.out.println(byteOs.toString());
            System.out.println(socket.getInetAddress().getHostName() + "-----" + socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(byteOs != null){
                    byteOs.close();
                }
                if(is != null){
                    is.close();
                }
                if(socket != null){
                    socket.close();
                }
                if (ss != null){
                    ss.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
