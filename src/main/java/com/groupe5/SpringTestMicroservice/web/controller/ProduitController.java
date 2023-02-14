package com.groupe5.SpringTestMicroservice.web.controller;
/** on importe la classe  controleur REST pour indiquer à spring que ce controleur est un controleur REST*/
import com.groupe5.SpringTestMicroservice.dao.ProductDao;
import com.groupe5.SpringTestMicroservice.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class ProduitController {
    ProductDao productDao;
            public ProduitController(ProductDao productDao){
                this.productDao = productDao;
            }
    @GetMapping("/Produits")
    public List<Product> listeProduits(){
                return productDao.findAll();
    }
    @GetMapping(value="/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productDao.findBy(id);
    }
    @PostMapping(value="/Produits")
    public ResponseEntity<Product> ajouterProduit(@RequestBody Product product){
                Product productAdded = productDao.save(product);
                if(Objects.isNull(productAdded)){
                    return ResponseEntity.noContent().build();
                }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id]")
                .buildAndExpand(productAdded.getId())
                .toUri();
                return ResponseEntity.created(location).build();
    }
}
