package com.example.sdorder.controller;

import com.example.sdorder.configuration.R;
import com.example.sdorder.entity.Customer;
import com.example.sdorder.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ApiOperation("返回customerid列表")
    @GetMapping("getCustomeridList")
    public R<List> getCustomeridList( ){
        List<Customer> list = customerService.getCustomerIdList();
        return R.success(list);
    }

    @ApiOperation("通过id查询customer")
    @GetMapping("getCustomerById")
    public R<Customer> getCustomerById(Long id){
        Customer  customer = customerService.getCustomerById(id);
        return R.success(customer);
    }
}
