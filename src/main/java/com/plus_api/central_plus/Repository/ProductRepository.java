package com.plus_api.central_plus.Repository;

import com.plus_api.central_plus.Model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<ProductModel, Long> {
}
