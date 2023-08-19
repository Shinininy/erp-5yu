package com.sunline.vuedemo;

import com.sunline.vuedemo.dao.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VuedemoApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    void contextLoads() {
        System.out.println(sysUserMapper.queryAll(1));
    }

}
