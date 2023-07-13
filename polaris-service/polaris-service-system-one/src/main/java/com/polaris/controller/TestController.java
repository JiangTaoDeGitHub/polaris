package com.polaris.controller;

import com.polaris.entity.Result;
import com.polaris.feign.ISystemFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "systemOne")
@RestController
@RequestMapping(value = "systemOne")
@AllArgsConstructor
public class TestController {

    @Autowired
    private final ISystemFeign systemFeign;

    @GetMapping(value = "api/by/id")
    @ApiOperation(value = "sysytemOne Fegin Get调用测试接口")
    public Result<Object> feginById(@RequestParam("id") Long id) {
        return Result.data(systemFeign.querySystemById(id));
    }
}
