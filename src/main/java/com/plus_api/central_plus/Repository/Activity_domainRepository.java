package com.plus_api.central_plus.Repository;

import com.plus_api.central_plus.Model.Activity_domainModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Activity_domainRepository extends JpaRepository<Activity_domainModel, Long> {
}
