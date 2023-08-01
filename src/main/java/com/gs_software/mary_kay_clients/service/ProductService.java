package com.gs_software.mary_kay_clients.service;

import com.gs_software.mary_kay_clients.entity.Client;
import com.gs_software.mary_kay_clients.entity.Product;
import com.gs_software.mary_kay_clients.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Value("${project.image}")
    private String imageFolderPath;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Page<Product> listAll(Integer page, Integer linesPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return productRepository.findAll(pageRequest);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    public Product findProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new ObjectNotFoundException(id, "Product id not found! "));
    }

    public Product updateProduct(Product product, Long id) {
        Product obj = findProductById(id);
        BeanUtils.copyProperties(product, obj, "id");
        return productRepository.save(obj);
    }

    public String saveImage(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty.");
        }

        String imageName = file.getOriginalFilename();
        String imagePath = imageFolderPath + imageName;

        byte[] bytes = file.getBytes();
        Path path = Paths.get(imagePath);
        Files.write(path, bytes);

        return imageName;
    }

    public void delete(Long id) {
        Product product = findProductById(id);
        productRepository.delete(product);
    }
}
