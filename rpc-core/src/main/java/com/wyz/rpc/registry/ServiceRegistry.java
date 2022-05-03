package com.wyz.rpc.registry;

import java.net.InetSocketAddress;

/**
 * 服务注册中心通用接口
 */
public interface ServiceRegistry {
    /**
     * 将一个服务注册进注册表
     */
    void register(String serviceName, InetSocketAddress inetSocketAddress);

    /**
     * 根据服务名称查找服务实体
     */
    InetSocketAddress lookupService(String serviceName);
}
