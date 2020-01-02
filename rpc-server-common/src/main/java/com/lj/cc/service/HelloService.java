package com.lj.cc.service;

import com.lj.cc.vo.UserVo;

/**
 * @author deke
 * @description 对外暴露的服务
 * @date 2020/1/1
 */
public interface HelloService {

    String sayHello(String content);

    String saveUser(UserVo entityVo);
}
