package com.plus_api.central_plus.Repository;

import com.plus_api.central_plus.Model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Long> {
}
