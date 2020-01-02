package com.lj.cc.controller;

import lombok.SneakyThrows;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author deke
 * @description 服务提供者
 * @date 2020/1/1
 */
public class RpcProxyServer {

    private static ServerSocket serverSocket = null;

    ExecutorService executorService = Executors.newCachedThreadPool();

    @SneakyThrows
    public void publisher(Object service, int port) {

        serverSocket = new ServerSocket(port);
        while (true) {
            //BIO 的模式
            Socket socket = serverSocket.accept();
            // 使用线程池的方式来保证处理不阻塞
            executorService.execute(new ProcessorHandler(socket, service));
        }
    }
}
