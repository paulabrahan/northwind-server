package com.ulasalle.lp3.evaluationfinal.repository;

import com.ulasalle.lp3.evaluationfinal.model.enitity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
