package com.app.springmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {
    @Id
    private String id;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    @Override
    public String toString() {
        return "BaseEntity{" +
                "_id='" + id + '\n' +
                ", createdDate=" + createdDate + '\n' +
                ", lastModifiedDate=" + lastModifiedDate + '\n' +
                '}';
    }
}
