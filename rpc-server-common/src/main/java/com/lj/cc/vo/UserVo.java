package com.lj.cc.vo;

import java.io.Serializable;

/**
 * @author deke
 * @description 实体
 * @date 2020/1/1
 */
public class UserVo implements Serializable {

    private static final long serialVersionUID = -5746254598860068051L;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserVo{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }
}
