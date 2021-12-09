package com.ulasalle.lp3.evaluationfinal.repository;

import com.ulasalle.lp3.evaluationfinal.model.enitity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
}
