package ets.log430.lab.repositories.product;

import ets.log430.lab.models.dto.product.ProductBasicInfo;
import ets.log430.lab.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    ProductBasicInfo findIdAndNameById(Long id);

    List<Product> findByNameContainingIgnoreCase(String name);

    @Query("SELECT p FROM Product p JOIN p.categories c WHERE LOWER(c.name) = LOWER(:categoryName)")
    List<Product> findByCategoryIgnoreCase(@Param("categoryName") String categoryName);

    @Query("SELECT p FROM Product p JOIN p.categories c " +
        "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')) " +
        "AND LOWER(c.name) = LOWER(:categoryName)")
    List<Product> findByNameContainingIgnoreCaseAndCategoryIgnoreCase(
        @Param("name") String name,
        @Param("categoryName") String categoryName
    );


}