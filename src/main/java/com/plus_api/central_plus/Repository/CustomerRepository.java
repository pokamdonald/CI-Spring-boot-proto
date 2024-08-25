package com.plus_api.central_plus.Repository;

import com.plus_api.central_plus.Model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends JpaRepository<CustomerModel,Long> {
}
