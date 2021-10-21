package com.lab1.ipmaapiclient;

import com.lab1.ipmaapiclient.services.IpmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IpmaApiClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(IpmaApiClientApplication.class, args);
    }

}
