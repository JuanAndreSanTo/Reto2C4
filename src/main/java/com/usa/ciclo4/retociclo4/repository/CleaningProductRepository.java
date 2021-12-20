package com.usa.ciclo4.retociclo4.repository;

import com.usa.ciclo4.retociclo4.model.CleaningProduct;
import com.usa.ciclo4.retociclo4.repository.crudrepository.CleaningProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CleaningProductRepository {
    @Autowired
    private CleaningProductCrudRepository cleaningProductCrudRepository;

    public List<CleaningProduct> getAll(){

        return (List<CleaningProduct>) cleaningProductCrudRepository.findAll();
    }

    public Optional<CleaningProduct> getCleaningProduct(int id) {

        return cleaningProductCrudRepository.findById(id);
    }

    public CleaningProduct save(CleaningProduct cleaningProduct) {

        return cleaningProductCrudRepository.save(cleaningProduct);
    }

    public void update(CleaningProduct cleaningProduct) {
        cleaningProductCrudRepository.save(cleaningProduct);
    }

    public void delete(CleaningProduct cleaningProduct) {
        cleaningProductCrudRepository.delete(cleaningProduct);
    }

    /*public List<CleaningProduct> getByPrice(double price){
        return cleaningProductCrudRepository.findByPriceLessThanEqual(price);
    }

    public List<CleaningProduct> getByDescriptionContains(String description){
        return cleaningProductCrudRepository.findByDescriptionContainingIgnoreCase(description);
    }*/

}
