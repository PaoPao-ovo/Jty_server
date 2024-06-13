package com.chilwee.jtyserver.tcpserver;

import com.chilwee.jtyserver.localthread.SocketThread;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


@Component
public class TcpServer {

    @Value("${Tcp.server.port}")
    private String port;

    public TcpServer() {

    }

    public TcpServer(String port) {
        this.port = port;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }


    @PostConstruct
    public void start() {
        try {
            //服务端对象
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));
            while (true) {
                System.out.println("连接中...");
                final Socket socket = serverSocket.accept();
                System.out.println("连接到一个客户端");
                new Thread(new SocketThread(socket)).start();
            }
        } catch (Exception e) {
            System.out.println("Could not listen on port: " + port);
        }
    }
}
