package com.plus_api.central_plus.Repository;

import com.plus_api.central_plus.Model.CategoryMarchandModel;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMarchandRepository extends JpaRepository<CategoryMarchandModel, Long> {


}
