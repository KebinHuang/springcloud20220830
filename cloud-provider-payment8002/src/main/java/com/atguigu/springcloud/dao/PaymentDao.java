package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface  PaymentDao {
    //插入数据
    public int create(Payment payment);
    //根据Id查询语句
    public Payment getPaymentById(@Param("id") Long id);
}
