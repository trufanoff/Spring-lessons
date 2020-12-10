package ru.gb.persist.repo;

import org.springframework.data.jpa.domain.Specification;
import ru.gb.persist.entity.Product;

public class ProductSpecification {

    public static Specification<Product> nameLike(String name) {
        return (root, query, builder) -> builder.like(root.get("name"), "%" + name + "%");
    }

    // TODO добавить спецификации для условий согласно ДЗ

}
