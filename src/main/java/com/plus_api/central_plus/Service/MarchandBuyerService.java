package com.plus_api.central_plus.Service;

import com.plus_api.central_plus.Model.MarchandBuyerModel;
import com.plus_api.central_plus.Repository.MarchandBuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarchandBuyerService {

    @Autowired
    private MarchandBuyerRepository marchandBuyerRepository;

    public List<MarchandBuyerModel> getAllMarchandBuyers() {
        return marchandBuyerRepository.findAll();
    }

    public MarchandBuyerModel getMarchandBuyerById(Long id) {
        return marchandBuyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marchand Acheteur non disponible"));
    }

    public MarchandBuyerModel createMarchandBuyer(MarchandBuyerModel marchandBuyerModel) {
        return marchandBuyerRepository.save(marchandBuyerModel);
    }

    public MarchandBuyerModel updateMarchandBuyer(Long id, MarchandBuyerModel marchandBuyerDetails) {
        MarchandBuyerModel marchandBuyerModel = marchandBuyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marchand Acheteur non disponible "));

        marchandBuyerModel.setName(marchandBuyerDetails.getName());
        marchandBuyerModel.setEmail(marchandBuyerDetails.getEmail());
        marchandBuyerModel.setContact(marchandBuyerDetails.getContact());
        marchandBuyerModel.setStatus(marchandBuyerDetails.getStatus());

        return marchandBuyerRepository.save(marchandBuyerModel);
    }

    public void deleteMarchandBuyer(Long id) {
        if (!marchandBuyerRepository.existsById(id)) {
            throw new RuntimeException("Marchand Acheteur non disponible ");
        }
        marchandBuyerRepository.deleteById(id);
    }
}
