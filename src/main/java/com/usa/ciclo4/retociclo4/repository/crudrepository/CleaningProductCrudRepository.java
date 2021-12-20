package com.usa.ciclo4.retociclo4.repository.crudrepository;

import com.usa.ciclo4.retociclo4.model.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CleaningProductCrudRepository extends MongoRepository<CleaningProduct, String> {
    /*public List<CleaningProduct> findByPriceLessThanEqual(double price);
    public List<CleaningProduct>findByDescriptionContainingIgnoreCase(String description);*/

    Optional<CleaningProduct> findById(int id);
}
