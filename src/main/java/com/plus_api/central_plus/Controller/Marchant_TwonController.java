package com.plus_api.central_plus.Controller;

import com.plus_api.central_plus.Model.Marchant_TwonModel;
import com.plus_api.central_plus.Service.Marchant_TwonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merchants")
public class Marchant_TwonController {

    @Autowired
    private Marchant_TwonService marchant_twonService;

    // Get all merchants
    @GetMapping
    public List<Marchant_TwonModel> getAllMerchants() {
        return marchant_twonService.getAllMerchants();
    }

    // Get a single merchant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Marchant_TwonModel> getMerchantById(@PathVariable Long id) {
        Marchant_TwonModel merchant = marchant_twonService.getMerchantById(id);
        return ResponseEntity.ok(merchant);
    }

    // Create a new merchant
    @PostMapping
    public Marchant_TwonModel createMerchant(@RequestBody Marchant_TwonModel merchant) {
        return marchant_twonService.createMerchant(merchant);
    }

    // Update an existing merchant
    @PutMapping("/{id}")
    public ResponseEntity<Marchant_TwonModel> updateMerchant(@PathVariable Long id, @RequestBody Marchant_TwonModel merchantDetails) {
        Marchant_TwonModel updatedMerchant = marchant_twonService.updateMerchant(id, merchantDetails);
        return ResponseEntity.ok(updatedMerchant);
    }

    // Delete a merchant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable Long id) {
        marchant_twonService.deleteMerchant(id);
        return ResponseEntity.noContent().build();
    }
}

