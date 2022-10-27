package com.springclund.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springclund.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
    public int create(Payment payment);
    Payment queryById(@Param("id") long id);
}
