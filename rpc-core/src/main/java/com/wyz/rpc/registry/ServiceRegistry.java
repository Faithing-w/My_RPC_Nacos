package com.wyz.rpc.registry;

/**
 * 将服务的注册和服务器启动分离，使得服务端可以提供多个服务
 */
public interface ServiceRegistry {
    //注册服务信息
    <T> void register(T service);
    //获取服务信息
    Object getService(String serviceName);
}
