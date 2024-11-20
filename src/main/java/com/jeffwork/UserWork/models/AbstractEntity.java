package com.jeffwork.UserWork.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
//import org.hibernate.annotations.JdbcTypeCode;
//import org.hibernate.type.SqlTypes;


import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity {


    @Id
    @GeneratedValue
    private int id;


    @NotNull
    @NotBlank(message = "name cannot be blank")
    @Size(min = 3, max = 100, message = "Must between 3 and 100 characters")
    private String name;

    public int getId() {
        return id;
    }

    public @NotNull @NotBlank(message = "name cannot be blank") @Size(min = 3, max = 100, message = "Must between 3 and 100 characters") String getName() {
        return name;
    }

    public void setName(@NotNull @NotBlank(message = "name cannot be blank") @Size(min = 3, max = 100, message = "Must between 3 and 100 characters") String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity entity = (AbstractEntity) o;
        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
