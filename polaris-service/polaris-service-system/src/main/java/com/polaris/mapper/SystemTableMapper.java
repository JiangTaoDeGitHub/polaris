package com.polaris.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.model.Demo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface SystemTableMapper {


    List<Demo> list();

    List<Demo> page(Page<Demo> page);
}
