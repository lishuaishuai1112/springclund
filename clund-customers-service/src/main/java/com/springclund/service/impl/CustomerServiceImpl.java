package com.springclund.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springclund.mapper.CustomerMapper;
import com.springclund.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public int queryCustomer() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", 1);
        Integer count = customerMapper.selectCount(queryWrapper);
        return count;
    }
}
