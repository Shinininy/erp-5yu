package com.sunline.vuedemo.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunline.vuedemo.bean.ContactpersonEntity;
import com.sunline.vuedemo.dao.ContactpersonDao;
import com.sunline.vuedemo.service.ContactpersonService;
import org.springframework.stereotype.Service;



@Service("contactpersonService")
public class ContactpersonServiceImpl extends ServiceImpl<ContactpersonDao, ContactpersonEntity> implements ContactpersonService {

}