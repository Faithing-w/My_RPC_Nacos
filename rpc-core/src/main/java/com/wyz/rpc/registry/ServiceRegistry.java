package com.wyz.rpc.registry;

import java.net.InetSocketAddress;

/**
 * 服务注册接口
 */
public interface ServiceRegistry {
    /**
     * 将一个服务注册进注册表
     */
    void register(String serviceName, InetSocketAddress inetSocketAddress);

}
