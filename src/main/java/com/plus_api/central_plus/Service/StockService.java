package com.plus_api.central_plus.Service;

import com.plus_api.central_plus.Model.StockModel;
import com.plus_api.central_plus.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    // Get all stocks
    public List<StockModel> getAllStocks() {
        return stockRepository.findAll();
    }

    // Get a single stock by ID
    public StockModel getStockById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    // Create a new stock
    public StockModel createStock(StockModel stock) {
        stock.setCreationDate(LocalDate.now());
        return stockRepository.save(stock);
    }

    // Update an existing stock
    public StockModel updateStock(Long id, StockModel stockDetails) {
        StockModel stock = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found"));

        stock.setName(stockDetails.getName());
        stock.setLocation(stockDetails.getLocation());
        stock.setEntryDate(stockDetails.getEntryDate());
        stock.setOutingDate(stockDetails.getOutingDate());

        return stockRepository.save(stock);
    }

    // Delete a stock
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
