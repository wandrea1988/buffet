package hu.helixlab.buffet.Repository;

import hu.helixlab.buffet.Domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query(value="select * from product order by product_name ASC", nativeQuery = true)
    public List<Product> findAll();
}
