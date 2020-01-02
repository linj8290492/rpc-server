package com.lj.cc.serviceImpl;

import com.lj.cc.service.HelloService;
import com.lj.cc.vo.UserVo;

/**
 * @author deke
 * @description 服务的实现
 * @date 2020/1/1
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String content) {
        System.out.println(content+" begin say hello!");
        return "hello: "+content;
    }

    @Override
    public String saveUser(UserVo entityVo) {
        System.out.println("I'm save the UserVo"+entityVo);
        return "SUCCESS";
    }
}
