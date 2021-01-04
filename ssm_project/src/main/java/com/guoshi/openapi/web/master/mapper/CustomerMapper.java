package com.guoshi.openapi.web.master.mapper;

import com.guoshi.openapi.web.master.pojo.Customer;

import java.util.List;

public interface CustomerMapper {
    void insertCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Long id);

    void deleteCustomersByIds(long[] ids);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers(String name);
}
