package com.app.springmongo.controller;

import com.app.springmongo.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;
}
