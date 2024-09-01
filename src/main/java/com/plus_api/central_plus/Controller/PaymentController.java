package com.plus_api.central_plus.Controller;

import com.plus_api.central_plus.Model.PaymentModel;
import com.plus_api.central_plus.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Get all payments
    @GetMapping
    public List<PaymentModel> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // Get payment by ID
    @GetMapping("/{id}")
    public ResponseEntity<PaymentModel> getPaymentById(@PathVariable Long id) {
        PaymentModel paymentModel = paymentService.getPaymentById(id);
        return ResponseEntity.ok(paymentModel);
    }

    // Create a new payment
    @PostMapping
    public ResponseEntity<PaymentModel> createPayment(@RequestBody PaymentModel paymentModel) {
        // Ensure that totalAmount, leftAmount, and productId are set before saving
        paymentModel.setTotalAmount(paymentModel.getAmount() * Double.parseDouble(paymentModel.getQuantity()));
        paymentModel.setLeftAmount(paymentModel.getTotalAmount() - paymentModel.getReceiveAmount());

        // Validate the payment method
        try {
            paymentModel.setPaymentMethod(paymentModel.getPaymentMethod());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }

        PaymentModel createdPayment = paymentService.createPayment(paymentModel);
        return ResponseEntity.ok(createdPayment);
    }

    // Update an existing payment
    @PutMapping("/{id}")
    public ResponseEntity<PaymentModel> updatePayment(@PathVariable Long id, @RequestBody PaymentModel paymentDetails) {
        // Ensure that totalAmount, leftAmount, and productId are set before updating
        paymentDetails.setTotalAmount(paymentDetails.getAmount() * Double.parseDouble(paymentDetails.getQuantity()));
        paymentDetails.setLeftAmount(paymentDetails.getTotalAmount() - paymentDetails.getReceiveAmount());

        // Validate the payment method
        try {
            paymentDetails.setPaymentMethod(paymentDetails.getPaymentMethod());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }

        PaymentModel updatedPayment = paymentService.updatePayment(id, paymentDetails);
        return ResponseEntity.ok(updatedPayment);
    }

    // Delete a payment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}
