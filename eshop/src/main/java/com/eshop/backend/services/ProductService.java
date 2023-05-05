package com.eshop.backend.services;

import com.eshop.backend.dto.CategoryDTO;
import com.eshop.backend.dto.ProductDTO;
import com.eshop.backend.models.Category;
import com.eshop.backend.models.Product;
import com.eshop.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(this::toProductDTO).collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        return toProductDTO(getExistingProduct(id));
    }

    public List<ProductDTO> getProductsByCategory(Long categoryId) {
        Category category = new Category(categoryId);
        return productRepository.findByCategory(category).stream().map(this::toProductDTO).collect(Collectors.toList());
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(UUID.randomUUID().getMostSignificantBits());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(product.getCategory());
        return toProductDTO(productRepository.save(product));
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = getExistingProduct(id);
        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setCategory(productDTO.getCategory());
        return toProductDTO(productRepository.save(existingProduct));
    }

    public void deleteProduct(Long id) {
        Product existingProduct = getExistingProduct(id);
        productRepository.delete(existingProduct);
    }

    private Product getExistingProduct(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public ProductDTO toProductDTO(Product product) {
        return new ProductDTO(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory()
        );
    }
}
