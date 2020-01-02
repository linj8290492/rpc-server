package com.lj.cc.controller;

import com.lj.cc.vo.RpcRequestVo;
import lombok.SneakyThrows;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @author deke
 * @description 真正的服务处理类
 * @date 2020/1/1
 */
public class ProcessorHandler implements Runnable {

    private Socket socket;
    private Object service;

    public ProcessorHandler() {
    }

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @SneakyThrows
    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            // 得到一个输入流，将socket中的信息读取出来
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequestVo rpcRequestVo = (RpcRequestVo) objectInputStream.readObject();

            Object result = invoke(rpcRequestVo);

            // 得到一个输出流，将信息写出去
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();

        } finally {
            if (null != objectInputStream) {
                objectInputStream.close();
            }
            if (null != objectOutputStream) {
                objectOutputStream.close();
            }
        }
    }

    @SneakyThrows
    private Object invoke(RpcRequestVo rpcRequestVo) {
        //利用反射调用
        //拿到客户端请求的参数
        Object[] params = rpcRequestVo.getParams();
        //得到一个相同长度的数据
        Class[] types = new Class[params.length];

        //拿到客户端请求的参数
        for (int i = 0; i < params.length; i++) {
            types[i] = params[i].getClass();
        }

        //根据请求的类进行加载
        Class<?> aClass = Class.forName(rpcRequestVo.getClassName());
        // sayHello,saveUser 找到对应的方法
        Method method = aClass.getMethod(rpcRequestVo.getMethodName(), types);

        //HelloServiceImpl 进行反射调用
        return method.invoke(service, params);
    }
}
