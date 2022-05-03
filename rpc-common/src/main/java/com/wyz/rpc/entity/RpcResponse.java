package com.wyz.rpc.entity;

import com.wyz.rpc.enumeration.ResponseCode;
import lombok.Data;

import java.io.Serializable;

/**
 * 服务器调用完成后，需要给客户端返回的信息
 * 成功：返回 返回值
 * 失败：返回 失败信息
 */

@Data
public class RpcResponse<T> implements Serializable {
    /**
     * 响应对应的请求号
     */
    private String requestId;

    /**
     * 响应状态码
     */
    private Integer statusCode;
    /**
     * 响应状态补充信息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    public static <T> RpcResponse<T> success(T data, String requestId) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setRequestId(requestId);
        response.setStatusCode(ResponseCode.SUCCESS.getCode());
        response.setData(data);
        return response;
    }

    public static <T> RpcResponse<T> fail(ResponseCode code,String requestId) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setRequestId(requestId);
        response.setStatusCode(code.getCode());
        response.setMessage(code.getMessage());
        return response;
    }

}
