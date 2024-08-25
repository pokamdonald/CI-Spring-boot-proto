package com.plus_api.central_plus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.plus_api.central_plus.Model.CustomerModel;
import com.plus_api.central_plus.Service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerModel> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Optional<CustomerModel> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public CustomerModel createCustomer(@RequestBody CustomerModel customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/{id}")
    public CustomerModel updateCustomer(@PathVariable Long id, @RequestBody CustomerModel customer) {
        customer.setId(id);
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
