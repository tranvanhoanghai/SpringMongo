package com.app.springmongo.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;


@Data
public class ProductRequest implements Serializable {
    private String name;
    private String productType;
    private MultipartFile[] image;
    private String description;
    private Integer importPrice;
    private Integer price;
    private Integer sale;
}
