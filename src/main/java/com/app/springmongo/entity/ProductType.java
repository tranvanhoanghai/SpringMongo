package com.app.springmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductType {
    @Field
    private String name;

    @Field
    private Integer status;
}
