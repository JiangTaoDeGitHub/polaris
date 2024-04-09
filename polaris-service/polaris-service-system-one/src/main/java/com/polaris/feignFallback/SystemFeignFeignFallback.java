package com.polaris.feignFallback;

import com.polaris.entity.Result;
import com.polaris.feign.ISystemFeign;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SystemFeignFeignFallback implements ISystemFeign {


    @Setter
    private Throwable cause;
    @Override
    public Result<String> querySystemById(Long id) {
        return Result.error("接口熔断");
    }
}
