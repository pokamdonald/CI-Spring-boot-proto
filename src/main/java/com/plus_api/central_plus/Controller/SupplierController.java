package com.plus_api.central_plus.Controller;

import com.plus_api.central_plus.Model.SuppliersModel;
import com.plus_api.central_plus.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    // Get all suppliers
    @GetMapping
    public List<SuppliersModel> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    // Get a supplier by ID
    @GetMapping("/{id}")
    public ResponseEntity<SuppliersModel> getSupplierById(@PathVariable Long id) {
        Optional<SuppliersModel> supplier = supplierService.getSupplierById(id);
        return supplier.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new supplier
    @PostMapping
    public SuppliersModel createSupplier(@RequestBody SuppliersModel supplier) {
        return supplierService.createSupplier(supplier);
    }

    // Update an existing supplier by ID
    @PutMapping("/{id}")
    public ResponseEntity<SuppliersModel> updateSupplier(@PathVariable Long id, @RequestBody SuppliersModel supplierDetails) {
        return ResponseEntity.ok(supplierService.updateSupplier(id, supplierDetails));
    }

    // Delete a supplier by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
