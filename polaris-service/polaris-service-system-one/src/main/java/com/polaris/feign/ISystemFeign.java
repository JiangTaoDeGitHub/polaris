package com.polaris.feign;

import com.polaris.entity.Result;
import com.polaris.model.ApiSystemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "polaris-service-system")
public interface ISystemFeign {
    /**
     * OpenFeign测试Get
     *
     * @param id
     * @return
     */
    @GetMapping("/system/api/by/id")
    Result<Object> querySystemById(@RequestParam("id") Long id);

}
