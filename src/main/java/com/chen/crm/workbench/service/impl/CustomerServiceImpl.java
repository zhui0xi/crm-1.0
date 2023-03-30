package com.chen.crm.workbench.service.impl;

import com.chen.crm.utils.SqlSessionUtil;
import com.chen.crm.workbench.dao.CustomerDao;
import com.chen.crm.workbench.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = SqlSessionUtil.getSqlSession().getMapper(CustomerDao.class);


    @Override
    public List<String> getCustomerName(String name) {
        return customerDao.getCustomerName(name);
    }
}
