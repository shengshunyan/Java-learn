package com.guoshi.openapi.web.master.controller;

import com.github.pagehelper.PageInfo;
import com.guoshi.openapi.web.master.bean.AjaxMessage;
import com.guoshi.openapi.web.master.bean.TableData;
import com.guoshi.openapi.web.master.pojo.Customer;
import com.guoshi.openapi.web.master.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public AjaxMessage addCustomer(Customer customer) {
        try {
            customerService.insertCustomer(customer);
            return new AjaxMessage(true, "添加成功");
        } catch (Exception e) {
            return new AjaxMessage(false, "添加失败");
        }
    }

    @GetMapping("/table")
    public TableData<Customer> tableData(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "2") Integer limit,
            String name
    ) {
        TableData<Customer> customerTableData = new TableData<Customer>();
        PageInfo<Customer> customerPageInfo = customerService.getAllCustomersByPage(page, limit, name);

        customerTableData.setCount(customerPageInfo.getTotal());
        customerTableData.setData(customerPageInfo.getList());
        return customerTableData;
    }

    @PostMapping("/update")
    public AjaxMessage updateCustomer(Customer customer) {
        try {
            customerService.updateCustomer(customer);
            return new AjaxMessage(true, "更新成功");
        } catch (Exception e) {
            return new AjaxMessage(false, "更新失败");
        }
    }

    @PostMapping("/del")
    public AjaxMessage deleteCustomer(long[] ids) {
        try {
            customerService.deleteCustomersByIds(ids);
            return new AjaxMessage(true, "删除成功");
        } catch (Exception e) {
            return new AjaxMessage(false, "删除失败");
        }
    }
}

