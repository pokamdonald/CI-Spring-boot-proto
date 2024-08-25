package com.plus_api.central_plus.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.plus_api.central_plus.Model.CustomerModel;
import com.plus_api.central_plus.Repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<CustomerModel> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public CustomerModel saveCustomer(CustomerModel customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
