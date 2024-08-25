package com.plus_api.central_plus.Service;

import com.plus_api.central_plus.Model.Marchant_TwonModel;
import com.plus_api.central_plus.Repository.Marchant_TwonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Marchant_TwonService {

    @Autowired
    private Marchant_TwonRepository marchant_twonRepository;

    // Get all merchants
    public List<Marchant_TwonModel> getAllMerchants() {

        return marchant_twonRepository.findAll();
    }

    // Get a single merchant by ID
    public Marchant_TwonModel getMerchantById(Long id) {
        return marchant_twonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Merchant not found"));
    }

    // Create a new merchant
    public Marchant_TwonModel createMerchant(Marchant_TwonModel merchant) {
        return marchant_twonRepository.save(merchant);
    }

    // Update an existing merchant
    public Marchant_TwonModel updateMerchant(Long id, Marchant_TwonModel merchantDetails) {
        Marchant_TwonModel merchant = getMerchantById(id);
        merchant.setName(merchantDetails.getName());
        return marchant_twonRepository.save(merchant);
    }

    // Delete a merchant
    public void deleteMerchant(Long id) {
        Marchant_TwonModel merchant = getMerchantById(id);
        marchant_twonRepository.delete(merchant);
    }
}
