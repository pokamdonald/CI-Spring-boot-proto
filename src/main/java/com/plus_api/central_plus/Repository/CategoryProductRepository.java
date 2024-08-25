package com.plus_api.central_plus.Repository;

import com.plus_api.central_plus.Model.CategoryProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductRepository extends JpaRepository<CategoryProductModel,Long> {

}
