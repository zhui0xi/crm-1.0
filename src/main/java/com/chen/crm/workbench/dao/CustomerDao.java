package com.chen.crm.workbench.dao;

import com.chen.crm.workbench.domain.Customer;

import java.util.List;

public interface CustomerDao {

    int save(Customer cus);

    Customer getByName(String company);

    List<String> getCustomerName(String name);
}
