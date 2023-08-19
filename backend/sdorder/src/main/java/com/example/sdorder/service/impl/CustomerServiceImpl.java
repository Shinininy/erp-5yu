package com.example.sdorder.service.impl;

import com.example.sdorder.entity.Customer;
import com.example.sdorder.mapper.CustomerMapper;
import com.example.sdorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer getCustomerById(Long id) {
        return customerMapper.selectById(id);
    }

    @Override
    public List<Customer> getCustomerList() {
        return customerMapper.getCustomerList();
    }

    @Override
    public List<Customer> getCustomerIdList() {
        return customerMapper.getCustomerIdList();
    }
}
