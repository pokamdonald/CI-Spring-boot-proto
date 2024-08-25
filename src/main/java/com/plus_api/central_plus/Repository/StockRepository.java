package com.plus_api.central_plus.Repository;

import com.plus_api.central_plus.Model.StockModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockModel,Long> {

}
