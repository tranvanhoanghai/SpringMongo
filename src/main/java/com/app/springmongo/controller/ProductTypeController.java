package com.app.springmongo.controller;

import com.app.springmongo.entity.ProductType;
import com.app.springmongo.entity.ProductType;
import com.app.springmongo.entity.TableConfig;
import com.app.springmongo.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/product-type")
    public ResponseEntity<List<ProductType>> getAll() {
        try {
            List<ProductType> productTypes = new ArrayList<>(productTypeService.getAll());
            return new ResponseEntity<>(productTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product-type/{typeId}")
    public ResponseEntity<ProductType> getById(@PathVariable("typeId") String typeId) {
        try {
            Optional<ProductType> optional = productTypeService.getById(typeId);
            return optional.map(ProductType -> new ResponseEntity<>(ProductType, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.OK));
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/product-type")
    public ResponseEntity<ProductType> save(@RequestBody ProductType productType) {
        try {
            return new ResponseEntity<>(productTypeService.save(productType), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product-type/{typeId}")
    public ResponseEntity<ProductType> update(@PathVariable("typeId") String typeId, @RequestBody ProductType productType) {
        try {
            Optional<ProductType> productTypeOptional = productTypeService.getById(typeId);
            if (productTypeOptional.isPresent()) {
                ProductType _productType = productTypeOptional.get();
                _productType.setName(productType.getName());
                return new ResponseEntity<>(productTypeService.save(_productType), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/product-type/{typeId}")
    public ResponseEntity<ProductType> delete(@PathVariable("typeId") List<ProductType> typeId) {
        try {


            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
