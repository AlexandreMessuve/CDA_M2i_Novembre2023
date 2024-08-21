package com.example.service;

import com.example.dto.ProductGetDTO;
import com.example.dto.ProductPostDTO;
import com.example.entity.Product;
import com.example.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ProductService {
    @Inject
    ProductRepository productRepository;

    public List<ProductGetDTO> getProducts() {
        return productRepository.findAll().stream().map(this::productToGetDTO).toList();
    }
    public ProductGetDTO getProduct(Long id) {
        return productToGetDTO(productRepository.findById(id));
    }
    @Transactional
    public ProductGetDTO createProduct(ProductPostDTO productPostDTO) {
        Product product = productFromDTO(productPostDTO);
        productRepository.persistAndFlush(product);
        if (productRepository.isPersistent(product)){
            return productToGetDTO(product);
        }else{
            return null;
        }
    }
    @Transactional
    public ProductGetDTO updateProduct(Long id,ProductPostDTO productPostDTO) {
        Product product = getProductById(id);
        if (product != null){
            product.setName(productPostDTO.getName());
            product.setDescription(productPostDTO.getDescription());
            product.setPrice(productPostDTO.getPrice());
            productRepository.persistAndFlush(product);
            if (productRepository.isPersistent(product)){
                return productToGetDTO(product);
            }else{
                return null;
            }
        }
        return null;
    }

    @Transactional
    public boolean deleteProduct(Long id) {
        return productRepository.deleteById(id);
    }

    private Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    private ProductGetDTO productToGetDTO(Product product) {
        return new ProductGetDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    private Product productFromDTO(ProductPostDTO productPostDTO) {
        Product product = new Product();
        product.setName(productPostDTO.getName());
        product.setDescription(productPostDTO.getDescription());
        product.setPrice(productPostDTO.getPrice());
        return product;
    }
}
