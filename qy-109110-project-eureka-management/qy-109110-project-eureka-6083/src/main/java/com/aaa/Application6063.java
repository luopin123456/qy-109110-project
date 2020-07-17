package com.aaa;

import com.sun.javaws.Main;
import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Application6063 {
    public static void main(String[] args) {
        SpringApplication.run(Application6063.class,args);
    }
}
