package com.example.konul.repository;

import com.example.konul.entity.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @EntityGraph(attributePaths = { "sizes", "categories", "brands" })
    List<Product> findAllEagerBy();

    @EntityGraph(attributePaths = { "sizes", "categories", "brands" })
    Optional<Product> findById(Long id);

    @Query("SELECT DISTINCT s.value FROM Size s")
    List<String> findAllSizes();

    @Query("SELECT DISTINCT c.name FROM Category c")
    List<String> findAllCategories();

    @Query("SELECT DISTINCT b.name FROM Brand b")
    List<String> findAllBrands();
}
