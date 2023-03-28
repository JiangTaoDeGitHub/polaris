package com.polaris.controller;

import com.polaris.entity.Result;
import com.polaris.service.ISystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "system")
@RestController
@RequestMapping(value = "system")
@AllArgsConstructor
public class SystemController {

    @Autowired
    private  ISystemService systemService;

    @ApiOperation(value = "system list接口")
    @GetMapping(value = "list")
    public Object list() {
        return systemService.list();
    }

    @ApiOperation(value = "system page")
    @GetMapping(value = "page")
    public Object page() {
        return systemService.page();
    }


    @GetMapping(value = "exception")
    @ApiOperation(value = "自定义异常及返回测试接口")
    public Result<String> exception() {
        return Result.data(systemService.exception());
    }

}
