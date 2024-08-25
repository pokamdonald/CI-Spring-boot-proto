package com.plus_api.central_plus.Controller;

import com.plus_api.central_plus.Model.MarchandBuyerModel;
import com.plus_api.central_plus.Service.MarchandBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marchand-buyers")
public class MarchandBuyerController {

    @Autowired
    private MarchandBuyerService marchandBuyerService;

    @GetMapping
    public List<MarchandBuyerModel> getAllMarchandBuyers() {
        return marchandBuyerService.getAllMarchandBuyers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarchandBuyerModel> getMarchandBuyerById(@PathVariable Long id) {
        MarchandBuyerModel marchandBuyerModel = marchandBuyerService.getMarchandBuyerById(id);
        return ResponseEntity.ok(marchandBuyerModel);
    }

    @PostMapping
    public MarchandBuyerModel createMarchandBuyer(@RequestBody MarchandBuyerModel marchandBuyerModel) {
        return marchandBuyerService.createMarchandBuyer(marchandBuyerModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarchandBuyerModel> updateMarchandBuyer(
            @PathVariable Long id, @RequestBody MarchandBuyerModel marchandBuyerDetails) {
        MarchandBuyerModel updatedMarchandBuyer = marchandBuyerService.updateMarchandBuyer(id, marchandBuyerDetails);
        return ResponseEntity.ok(updatedMarchandBuyer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarchandBuyer(@PathVariable Long id) {
        marchandBuyerService.deleteMarchandBuyer(id);
        return ResponseEntity.noContent().build();
    }
}
