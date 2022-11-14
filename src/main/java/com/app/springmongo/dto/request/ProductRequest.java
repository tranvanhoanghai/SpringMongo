package com.app.springmongo.dto.request;

import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;


@Data
public class ProductRequest implements Serializable {
    private String name;
    private String id_product_type;
    @Transient
    private MultipartFile[] image;
    private String description;
    private Integer importPrice;
    private Integer price;
    private Integer sale;
}
