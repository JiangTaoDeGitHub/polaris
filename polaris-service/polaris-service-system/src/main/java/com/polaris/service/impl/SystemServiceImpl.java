package com.polaris.service.impl;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.entity.Result;
import com.polaris.exception.BusinessException;
import com.polaris.mapper.SystemTableMapper;
import com.polaris.model.Demo;
import com.polaris.service.ISystemService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
@Service
public class SystemServiceImpl implements ISystemService {

    @Value("${server.port}")
    private String port;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SystemTableMapper systemTableMapper;
    @Override
    public List<Demo> list() {
        return systemTableMapper.list();
    }

    @Override
    public Page<Demo> page() {
        Page<Demo> page = new Page<>(1, 10);
        List<Demo> records = systemTableMapper.page(page);
        page.setRecords(records);
        return page;
    }
    @Override
    public String exception() {
        log.info("来了老弟");
        throw new BusinessException("自定义异常");
//        return "成功获得数据";
    }

    @Override
    public String feginById(String id) {
        return "请求id" +id+"，服务端口"+ port;
    }
}
