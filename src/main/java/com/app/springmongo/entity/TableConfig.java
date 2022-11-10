package com.app.springmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("tableConfig")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TableConfig {
    @Id
    @Field("_id")
    private String _id;

    @Field
    private String tableId;

    @Field
    private List tableConfig;

    @Override
    public String toString() {
        return "TableConfig{" +
                "id='" + _id + '\'' +
                ", tableId='" + tableId + '\'' +
                ", configJson=" + tableConfig +
                '}';
    }
}
