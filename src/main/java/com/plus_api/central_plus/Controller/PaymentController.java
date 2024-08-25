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

    @GetMapping
    public List<PaymentModel> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentModel> getPaymentById(@PathVariable Long id) {
        PaymentModel paymentModel = paymentService.getPaymentById(id);
        return ResponseEntity.ok(paymentModel);
    }

    @PostMapping
    public PaymentModel createPayment(@RequestBody PaymentModel paymentModel) {
        return paymentService.createPayment(paymentModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentModel> updatePayment(@PathVariable Long id, @RequestBody PaymentModel paymentDetails) {
        PaymentModel updatedPayment = paymentService.updatePayment(id, paymentDetails);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}
