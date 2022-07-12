package com.example.demo.service.implementation;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.Collection;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ProductServiceImp implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public Product create(Product product) {
        log.info("Creating product: {} - {}", product.getProductId(), product.getName());
        return productRepo.save(product);
    }

    @Override
    public Collection<Product> list(int limit) {
        log.info("Listing products");
        return productRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Product get(Long id) {
        log.info("Getting product: {}", id);
        return productRepo.findById(id).get();
    }

    @Override
    public Product getProductByProductId(String productId) {
        log.info("Getting product: {}", productId);
        return productRepo.findByProductId(productId);
    }

    @Override
    public Product update(Product product) {
        log.info("Updating product: {} - {}", product.getProductId(), product.getName());
        return productRepo.save(product);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting product: {}", id);
        productRepo.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteByProductId(String productId) {
        log.info("Deleting product: {}", productId);
        Long currentid = productRepo.findByProductId(productId).getId();
        productRepo.deleteById(currentid);
        return Boolean.TRUE;
    }
}
