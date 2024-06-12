package com.chilwee.jtyserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.chilwee.jtyserver.tcpserver.TcpServer;

@SpringBootApplication
public class JtyServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(JtyServerApplication.class, args);
    }

}
