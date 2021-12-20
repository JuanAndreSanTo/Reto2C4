package com.usa.ciclo4.retociclo4.service;

import com.usa.ciclo4.retociclo4.model.CleaningProduct;
import com.usa.ciclo4.retociclo4.repository.CleaningProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CleaningProductService {
    @Autowired
    private CleaningProductRepository cleaningProductRepository;

    public List<CleaningProduct> getAll(){
        return cleaningProductRepository.getAll();
    }
    public Optional<CleaningProduct> getCleaningProduct(int id){
        return cleaningProductRepository.getCleaningProduct(id);
    }
    public CleaningProduct save(CleaningProduct cleaningProduct){
        if(cleaningProduct.getId() == null) {
            return cleaningProduct;
        }else{
            return cleaningProductRepository.save(cleaningProduct);
        }
    }

    public CleaningProduct update(CleaningProduct cleaningProduct) {

        if (cleaningProduct.getId() != null) {
            Optional<CleaningProduct> dbCleaningProduct = cleaningProductRepository.getCleaningProduct(cleaningProduct.getId());
            if (!dbCleaningProduct.isEmpty()) {
                if (cleaningProduct.getBrand() != null) {
                    dbCleaningProduct.get().setBrand(cleaningProduct.getBrand());
                }
                if (cleaningProduct.getCategory() != null) {
                    dbCleaningProduct.get().setCategory(cleaningProduct.getCategory());
                }
                if (cleaningProduct.getName() != null) {
                    dbCleaningProduct.get().setName(cleaningProduct.getName());
                }
                if (cleaningProduct.getDescription() != null) {
                    dbCleaningProduct.get().setDescription(cleaningProduct.getDescription());
                }
                if (cleaningProduct.getPrice() != 0.0) {
                    dbCleaningProduct.get().setPrice(cleaningProduct.getPrice());
                }
                if (cleaningProduct.getQuantity() != 0) {
                    dbCleaningProduct.get().setQuantity(cleaningProduct.getQuantity());
                }
                if (cleaningProduct.getPhotography() != null) {
                    dbCleaningProduct.get().setPhotography(cleaningProduct.getPhotography());
                }
                dbCleaningProduct.get().setAvailability(cleaningProduct.isAvailability());
                cleaningProductRepository.update(dbCleaningProduct.get());
                return dbCleaningProduct.get();
            } else {
                return cleaningProduct;
            }
        } else {
            return cleaningProduct;
        }
    }

    public boolean delete(int id){
        return getCleaningProduct(id).map(cleaningProduct -> {
            cleaningProductRepository.delete(cleaningProduct);
            return true;
        }).orElse(false);
    }

    /*public List<CleaningProduct> getByPrice(double price){
        return cleaningProductRepository.getByPrice(price);
    }

    public List<CleaningProduct> getByDescriptionContains(String description){
        return cleaningProductRepository.getByDescriptionContains(description);
    }*/

}


