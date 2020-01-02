package com.lj.cc.vo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author deke
 * @description rpc请求所需要传输过来的东西
 * @date 2020/1/1
 */
public class RpcRequestVo implements Serializable {

    private static final long serialVersionUID = 1362432843386737188L;

    private String className;
    private String methodName;
    private Object[] params;
    private String version;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RpcRequestVo{");
        sb.append("className='").append(className).append('\'');
        sb.append(", methodName='").append(methodName).append('\'');
        sb.append(", params=").append(params == null ? "null" : Arrays.asList(params).toString());
        sb.append(", version='").append(version).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
