package com.gs_software.mary_kay_clients.service;

import com.gs_software.mary_kay_clients.entity.Product;
import com.gs_software.mary_kay_clients.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Page<Product> listAll(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return productRepository.findAll(pageRequest);
    }

    public Product findByName(String name) {
        Optional<Product> Product = productRepository.findByName(name);
        return Product.orElseThrow(() -> new NoSuchElementException("Not object with name " + name));
    }

    public Product findProductById(Long id) {
        Optional<Product> Product = productRepository.findById(id);
        return Product.orElseThrow(() -> new ObjectNotFoundException(id, "Product id not found! "));
    }

    public Product updateProduct(Product Product, Long id) {
        Product obj = findProductById(id);
        BeanUtils.copyProperties(obj, Product);
        return productRepository.save(obj);
    }
}
