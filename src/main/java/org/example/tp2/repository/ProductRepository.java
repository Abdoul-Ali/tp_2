package org.example.tp2.repository;

import org.example.tp2.JPA_entite.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<product,Long> {

    List<product> findByNameContains(String mc);

    @Query("select p from product p where p.name like :x")
    List<product> search(@Param("x") String mc);
}
