package com.guoshi.openapi.web.master.service;

import com.github.pagehelper.PageInfo;
import com.guoshi.openapi.web.master.pojo.Customer;

import java.util.List;

public interface CustomerService {
    void insertCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Long id);

    void deleteCustomersByIds(long[] ids);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

    PageInfo<Customer> getAllCustomersByPage(Integer page, Integer limit, String name);
}
