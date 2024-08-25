package com.plus_api.central_plus.Service;

import com.plus_api.central_plus.Model.SuppliersModel;
import com.plus_api.central_plus.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    // Create a new supplier
    public SuppliersModel createSupplier(SuppliersModel supplier) {
        // Set the creation date if it's not already set
        if (supplier.getCreation_date() == null) {
            supplier.setCreation_date(LocalDate.now());
        }
        return supplierRepository.save(supplier);
    }

    // Get all suppliers
    public List<SuppliersModel> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    // Get a supplier by ID
    public Optional<SuppliersModel> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    // Update a supplier by ID
    public SuppliersModel updateSupplier(Long id, SuppliersModel supplierDetails) {
        SuppliersModel supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        supplier.setName(supplierDetails.getName());
        supplier.setEmail(supplierDetails.getEmail());
        supplier.setLocation(supplierDetails.getLocation());
        supplier.setCreation_date(LocalDate.now()); // Update creation date to the current date if needed
        supplier.setPhone_number(supplierDetails.getPhone_number());

        return supplierRepository.save(supplier);
    }

    // Delete a supplier by ID
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
