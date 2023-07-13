package com.polaris.controller;

import com.polaris.entity.Result;
import com.polaris.service.ISystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    @GetMapping(value = "api/by/id")
    @ApiOperation(value = "Fegin Get调用测试接口")
    public Result<Object> feginById(@RequestParam("id") String id) {
        return Result.data(systemService.feginById(id));
    }


    @ApiOperation(value = "限流测试")
    @GetMapping(value = "sentinel/protected")
    public Result<String> sentinelProtected() {
        return Result.data("访问的是限流测试接口");
    }

    @ApiOperation(value = "限流测试")
    @GetMapping(value = "sentinel/demo")
    public Result<String> sentinelDemo() {
        return Result.data("sentinel限流demo接口,设置阈值为1");
    }

    @ApiOperation(value = "Gateway路由转发测试")
    @GetMapping(value = "gateway/demo")
    public Result gatewayForward() {
        return Result.success("polaris-service-system转发请求成功");
    }
}
