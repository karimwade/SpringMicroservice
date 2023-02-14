package com.groupe5.SpringTestMicroservice.dao;

import com.groupe5.SpringTestMicroservice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductDaoImpl implements ProductDao{
    public static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"Ordinateur",500));
        products.add(new Product(2,"Frigidaire",100));
        products.add(new Product(3,"Micro Onde",400));
        products.add(new Product(4,"mixeur",200));

    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findBy(int id) {
        for(Product product : products){
            if(product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}
