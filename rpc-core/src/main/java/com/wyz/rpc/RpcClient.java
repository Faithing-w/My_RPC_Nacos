package com.wyz.rpc;

import com.wyz.rpc.entity.RpcRequest;

/**
 * 客户端通用接口
 */
public interface RpcClient {
    Object sendRequest(RpcRequest rpcRequest);
}
