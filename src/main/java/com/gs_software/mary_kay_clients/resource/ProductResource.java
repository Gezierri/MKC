package com.gs_software.mary_kay_clients.resource;

import com.gs_software.mary_kay_clients.entity.Product;
import com.gs_software.mary_kay_clients.entity.dto.ProductDto;
import com.gs_software.mary_kay_clients.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping("products")
@RestController
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
        Product product = new Product(productDto);
        productService.save(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<ProductDto> findByName(@RequestParam String name) {
        Product product = productService.findByName(name);
        ProductDto productDto = new ProductDto(product);
        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Long id) {
        Product product = productService.findProductById(id);
        ProductDto productDto = new ProductDto(product);
        return ResponseEntity.ok(productDto);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable Long id){
        Product product = new Product(productDto);
        return ResponseEntity.ok(product);
    }*/

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
}
