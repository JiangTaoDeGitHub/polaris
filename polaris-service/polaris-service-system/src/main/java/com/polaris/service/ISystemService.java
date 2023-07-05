package com.polaris.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.polaris.model.Demo;

import java.util.List;
public interface ISystemService {
    List<Demo> list();

    Page<Demo> page();

    String exception();

    String feginById(String id);
}
