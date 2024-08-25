package com.plus_api.central_plus.Repository;

import com.plus_api.central_plus.Model.MarchandBuyerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarchandBuyerRepository extends JpaRepository<MarchandBuyerModel, Long> {
}
