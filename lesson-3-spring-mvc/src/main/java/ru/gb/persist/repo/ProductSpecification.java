package ru.gb.persist.repo;

import org.springframework.data.jpa.domain.Specification;
import ru.gb.persist.entity.Product;

import java.math.BigDecimal;

public class ProductSpecification {

    public static Specification<Product> nameLike(String name) {
        return (root, query, builder) -> builder.like(root.get("name"), "%" + name + "%");
    }

    // TODO добавить спецификации для условий согласно ДЗ
    public static Specification<Product> minPrice(BigDecimal price){
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> maxPrice(BigDecimal price){
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("price"), price);
    }

//    public static Specification<Product> between(int minPrice, int maxPrice){
//        return (root, query, builder)-> builder.between()
//    }

}
