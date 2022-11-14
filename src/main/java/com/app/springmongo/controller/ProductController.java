package com.app.springmongo.controller;

import com.app.springmongo.entity.Product;
import com.app.springmongo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAll() {
        try {
            List<Product> tableConfigs = new ArrayList<>(productService.getAll());
            return new ResponseEntity<>(tableConfigs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{typeId}")
    public ResponseEntity<Product> getById(@PathVariable("typeId") String typeId) {
        try {
            Optional<Product> optional = productService.getById(typeId);
            return optional.map(Product -> new ResponseEntity<>(Product, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.OK));
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        try {
            return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product/{typeId}")
    public ResponseEntity<Product> update(@PathVariable("typeId") String typeId, @RequestBody Product product) {
        try {
            Optional<Product> productOptional = productService.getById(typeId);
            if (productOptional.isPresent()) {
                Product _proProduct = productOptional.get();
                _proProduct.setName(product.getName());
                return new ResponseEntity<>(productService.save(_proProduct), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/product/{typeId}")
    public ResponseEntity<Product> delete(@PathVariable("typeId") List<Product> typeId) {
        try {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
