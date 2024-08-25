package com.plus_api.central_plus.Service;

import com.plus_api.central_plus.Model.PaymentModel;
import com.plus_api.central_plus.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Get all payments
    public List<PaymentModel> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get payment by ID
    public PaymentModel getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    // Create a new payment
    public PaymentModel createPayment(PaymentModel paymentModel) {
        return paymentRepository.save(paymentModel);
    }

    // Update a payment
    public PaymentModel updatePayment(Long id, PaymentModel paymentDetails) {
        PaymentModel paymentModel = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));

        paymentModel.setPaymentMethod(paymentDetails.getPaymentMethod()); // Updated method name
        paymentModel.setAmount(paymentDetails.getAmount());
        paymentModel.setPaymentDate(paymentDetails.getPaymentDate());
        paymentModel.setStatus(paymentDetails.getStatus());

        return paymentRepository.save(paymentModel);
    }

    // Delete a payment
    public void deletePayment(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Payment not found with id: " + id);
        }
        paymentRepository.deleteById(id);
    }
}
