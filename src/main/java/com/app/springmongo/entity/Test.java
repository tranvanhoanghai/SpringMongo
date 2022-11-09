package com.app.springmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("test")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    private String id;
    private String name;
//    @CreatedDate // <-- this is not working
//    private Instant createdAt;
    @LastModifiedDate // <-- this is not working
    private Instant updatedAt;


}
