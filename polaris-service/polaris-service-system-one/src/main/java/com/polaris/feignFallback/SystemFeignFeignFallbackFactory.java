package com.polaris.feignFallback;

import com.polaris.feign.ISystemFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class SystemFeignFeignFallbackFactory implements FallbackFactory<ISystemFeign> {

    @Override
    public ISystemFeign create(Throwable throwable) {
        SystemFeignFeignFallback feignFallback = new SystemFeignFeignFallback();
        feignFallback.setCause(throwable);
        return feignFallback;
    }
}
