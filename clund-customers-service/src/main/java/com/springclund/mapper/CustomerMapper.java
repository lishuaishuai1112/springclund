package com.springclund.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springclund.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    public int queryCustomer();
}
