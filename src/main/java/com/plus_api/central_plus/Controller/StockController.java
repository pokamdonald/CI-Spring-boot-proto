package com.plus_api.central_plus.Controller;

import com.plus_api.central_plus.Model.StockModel;
import com.plus_api.central_plus.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    // Get all stocks
    @GetMapping
    public List<StockModel> getAllStocks() {
        return stockService.getAllStocks();
    }

    // Get a single stock by ID
    @GetMapping("/{id}")
    public ResponseEntity<StockModel> getStockById(@PathVariable Long id) {
        StockModel stock = stockService.getStockById(id);
        return ResponseEntity.ok(stock);
    }

    // Create a new stock
    @PostMapping
    public ResponseEntity<StockModel> createStock(@RequestBody StockModel stock) {
        StockModel createdStock = stockService.createStock(stock);
        return ResponseEntity.ok(createdStock);
    }

    // Update an existing stock
    @PutMapping("/{id}")
    public ResponseEntity<StockModel> updateStock(@PathVariable Long id, @RequestBody StockModel stockDetails) {
        StockModel updatedStock = stockService.updateStock(id, stockDetails);
        return ResponseEntity.ok(updatedStock);
    }

    // Delete a stock
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return ResponseEntity.noContent().build();
    }
}
