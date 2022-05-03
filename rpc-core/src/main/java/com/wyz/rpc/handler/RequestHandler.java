package com.wyz.rpc.handler;

import com.wyz.rpc.entity.RpcRequest;
import com.wyz.rpc.entity.RpcResponse;
import com.wyz.rpc.enumeration.ResponseCode;
import com.wyz.rpc.provider.ServiceProvider;
import com.wyz.rpc.provider.ServiceProviderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 进行过程调用的处理器
 */
public class RequestHandler {
    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);
    private static final ServiceProvider serviceProvider;

    static {
        serviceProvider = new ServiceProviderImpl();
    }

    public Object handle(RpcRequest rpcRequest) {
        Object result = null;
        Object service = serviceProvider.getServiceProvider(rpcRequest.getInterfaceName());
        try {
            result = invokeTargetMethod(rpcRequest, service);
            logger.info("服务:{} 成功调用方法:{}", rpcRequest.getInterfaceName(), rpcRequest.getMethodName());
        }catch (IllegalAccessException | InvocationTargetException e) {
            logger.error("调用或发送时有错误发生：", e);
        }
        return result;
    }

    private Object invokeTargetMethod(RpcRequest rpcRequest, Object service) throws IllegalAccessException, InvocationTargetException {
        Method method;
        try {
            method = service.getClass().getMethod(rpcRequest.getMethodName(), rpcRequest.getParamTypes());
        }catch (NoSuchMethodException e) {
            return RpcResponse.fail(ResponseCode.NOT_FOUND_METHOD, rpcRequest.getRequestId());
        }
        return method.invoke(service, rpcRequest.getParameters());
    }
}
