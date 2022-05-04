package com.wyz.test;

import com.wyz.rpc.annotation.Service;
import com.wyz.rpc.api.ByeService;

@Service
public class ByeServiceImpl implements ByeService {
    @Override
    public String bye(String name) {
        return "bye, " + name;
    }
}
