package com.plus_api.central_plus.Repository;

import com.plus_api.central_plus.Model.CommandModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<CommandModel, Long> {
}
