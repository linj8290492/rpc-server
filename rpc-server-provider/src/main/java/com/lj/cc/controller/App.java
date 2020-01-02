package com.lj.cc.controller;

import com.lj.cc.service.HelloService;
import com.lj.cc.serviceImpl.HelloServiceImpl;

/**
 * @author deke
 * @description rpc启动调用类
 * @date 2020/1/1
 */
public class App {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();

        RpcProxyServer rpcProxyServer = new RpcProxyServer();
        rpcProxyServer.publisher(helloService,8080);
    }
}
