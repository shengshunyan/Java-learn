package com.guoshi.openapi.web.master.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guoshi.openapi.web.master.mapper.CustomerMapper;
import com.guoshi.openapi.web.master.pojo.Customer;
import com.guoshi.openapi.web.master.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public void insertCustomer(Customer customer) {
        customerMapper.insertCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        if (customer.getId() != null) {
            customerMapper.updateCustomer(customer);
        } else {
            // TODO 需要id
        }
    }

    public void deleteCustomer(Long id) {
        if (id != null) {
            customerMapper.deleteCustomer(id);
        } else {
            // TODO 需要id
        }
    }

    @Override
    public void deleteCustomersByIds(long[] ids) {
        if (ids != null && ids.length > 0) {
            customerMapper.deleteCustomersByIds(ids);
        } else {
            // TODO 需要id
        }
    }

    public Customer getCustomerById(Long id) {
        if (id != null) {
            return customerMapper.getCustomerById(id);
        } else {
            // TODO 需要id
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public PageInfo<Customer> getAllCustomersByPage(Integer page, Integer limit, String name) {
        PageHelper.startPage(page, limit);
        List<Customer> customerList = customerMapper.getAllCustomers(name);
        return new PageInfo<Customer>(customerList);
    }
}
