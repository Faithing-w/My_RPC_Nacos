package com.wyz.rpc.provider;

/**
 * 保存和提供服务实例对象
 */
public interface ServiceProvider {
    //注册服务信息
    <T> void addServiceProvider(T service);
    //获取服务信息
    Object getServiceProvider(String serviceName);
}
