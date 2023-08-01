package com.gs_software.mary_kay_clients.resource;

import com.gs_software.mary_kay_clients.entity.Product;
import com.gs_software.mary_kay_clients.entity.dto.ProductDto;
import com.gs_software.mary_kay_clients.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("products")
@RestController
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> save(
            @RequestParam MultipartFile file,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam BigDecimal price,
            @RequestParam Integer stock
    ) {

        String imagePath = "";
        try {
            imagePath = productService.saveImage(file);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }

        Product product = new Product(
                null,
                name,
                description,
                price,
                stock,
                file.getOriginalFilename()
        );

        productService.save(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findByName(@RequestParam String name) {
        List<Product> productList = productService.findByName(name);
        List<ProductDto> productDtos = productList.stream().map(ProductDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Long id) {
        Product product = productService.findProductById(id);
        ProductDto productDto = new ProductDto(product);
        return ResponseEntity.ok(productDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateClient(
            @RequestParam MultipartFile file,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam BigDecimal price,
            @RequestParam Integer stock,
            @PathVariable Long id) {
        Product product = productService.updateProduct(new Product(
                id, name, description, price, stock, file.getOriginalFilename()
        ), id);
        return ResponseEntity.ok(new ProductDto(product));
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ProductDto>> listAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "listPerPage", defaultValue = "10") Integer listPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy
    ) {
        Page<Product> products = productService.listAll(page, listPerPage, direction, orderBy);
        Page<ProductDto> productDtos = products.map(ProductDto::new);
        return ResponseEntity.ok(productDtos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
