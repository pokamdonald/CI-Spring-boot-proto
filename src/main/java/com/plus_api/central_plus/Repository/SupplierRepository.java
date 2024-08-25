package com.plus_api.central_plus.Repository;

import com.plus_api.central_plus.Model.SuppliersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SuppliersModel, Long> {
}
