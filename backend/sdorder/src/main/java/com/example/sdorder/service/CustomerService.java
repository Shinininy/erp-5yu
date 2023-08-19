package com.example.sdorder.service;


import com.example.sdorder.entity.Customer;

import java.util.List;

/**
 * (Customer)表服务接口
 */
public interface CustomerService {

    /**
     * 通过id查询customer
     * @param id
     * @return
     */
    Customer getCustomerById(Long id);

    /**
     * 查询返回所有cutsomer
     * @return customer
     */
    List<Customer> getCustomerList();

    /**
     * 查询返回所有customerid
     * @return customeridlist
     */
    List<Customer> getCustomerIdList();

}
