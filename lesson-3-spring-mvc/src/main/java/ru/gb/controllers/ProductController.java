package ru.gb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.persist.entity.Product;
import ru.gb.persist.repo.ProductRepository;
import ru.gb.persist.repo.ProductSpecification;

import java.math.BigDecimal;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String indexProductPage(Model model, @RequestParam(name = "nameFilter", required = false) String nameFilter ,
                                   @RequestParam(name = "minPrice", required = false) BigDecimal minPrice,
                                   @RequestParam(name = "maxPrice", required = false) BigDecimal maxPrice) {
        logger.info("Product page update");

        Specification<Product> spec = Specification.where(null);

        if (nameFilter != null && !nameFilter.isEmpty()) {
            spec = spec.and(ProductSpecification.nameLike(nameFilter));
        }
        // TODO добавить обработку параметров формы
        if (minPrice != null) {
            spec = spec.and(ProductSpecification.minPrice(minPrice));
        }

        if (maxPrice != null) {
            spec = spec.and(ProductSpecification.maxPrice(maxPrice));
        }

        model.addAttribute("products", productRepository.findAll(spec));
        return "product";
    }

    @GetMapping("/{id}")
    public String editProduct(@PathVariable(value = "id") Long id, Model model) {
        logger.info("Edit product with id {}", id);
        model.addAttribute("product", productRepository.findById(id));
        return "product_form";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute(new Product());
        return "product_form";
    }

    @PostMapping("/update")
    public String updateProduct(Product product) {
        productRepository.save(product);
        return "redirect:/product";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable(value = "id") Long id) {
        logger.info("Delete product with id {}", id);
        productRepository.deleteById(id);
        return "redirect:/product";
    }
}