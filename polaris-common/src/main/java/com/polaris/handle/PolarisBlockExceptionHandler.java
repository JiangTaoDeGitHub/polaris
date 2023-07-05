package com.polaris.handle;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.polaris.entity.Result;
import com.polaris.entity.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class PolarisBlockExceptionHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        response.setStatus(429);
        response.setContentType("application/json;charset=utf-8");
        Result result = Result.error(ResultCodeEnum.SYSTEM_BUSY, ResultCodeEnum.SYSTEM_BUSY.getMsg());
        new ObjectMapper().writeValue(response.getWriter(), result);
    }

}
