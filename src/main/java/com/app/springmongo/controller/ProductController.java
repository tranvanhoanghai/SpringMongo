package com.app.springmongo.controller;

import ch.qos.logback.core.util.FileUtil;
import com.app.springmongo.dto.request.ProductRequest;
import com.app.springmongo.entity.Product;
import com.app.springmongo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ProductController {
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));
    private static String imageDirectory = System.getProperty("user.dir") + "/images/";

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
//    @PostMapping("/product")
//    public void test(@RequestParam("files") MultipartFile files){
//        System.out.println(files);
//
//    }
//    @PostMapping("/product")
    @RequestMapping(path = "/product", method = RequestMethod.POST,
            consumes = {"multipart/form-data"})
    public ResponseEntity<ProductRequest> save(@RequestPart("user") ProductRequest productRequest,  @RequestPart("images") MultipartFile[] files) {
        try {
            Product product = new Product();
            System.out.println(CURRENT_FOLDER);
            System.out.println(files);
            System.out.println(productRequest);
//            MultipartFile[] uploadfile =  productRequest.getImage();
//            System.out.println(productRequest.getImage().getOriginalFilename());

            List<String> fileNames = new ArrayList<>();

            // read and write the file to the local folder
            Arrays.asList(files).stream().forEach(file -> {
                byte[] bytes = new byte[0];
                try {
                    bytes = file.getBytes();
                    System.out.println(file.getOriginalFilename());
//                    Files.write(Paths.get(FileUtil.folderPath + file.getOriginalFilename()), bytes);
                    fileNames.add(file.getOriginalFilename());
                } catch (IOException e) {

                }
            });
//            Path staticPath = Paths.get("static");
//            Path imagePath = Paths.get("images");
//
//            if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
//                Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
//            }
//
//            Path file = CURRENT_FOLDER.resolve(staticPath).resolve(imagePath).resolve(Objects.requireNonNull(productRequest.getImage().getOriginalFilename()));
//            System.out.println(file);
//
//            try (OutputStream os = Files.newOutputStream(file)) {
//                os.write(productRequest.getImage().getBytes());
//            }
//
//            product.setImage(imagePath.resolve(productRequest.getImage().getOriginalFilename()).toString());

            return null;
//            return new ResponseEntity<ProductRequest>(productService.save(product), HttpStatus.OK);
        } catch (
                Exception e) {
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
