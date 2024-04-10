package com.example.wedecomerce.service.impl;

import com.example.wedecomerce.domain.Category;
import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.dto.CategoriesHomeDTO;
import com.example.wedecomerce.repository.CategoryRepository;
import com.example.wedecomerce.repository.ProductRepository;
import com.example.wedecomerce.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<?> getAllProductByCategories(Integer numberProduct) {
        List<Category> list = categoryRepository.findAllByCategoryParentIsNull(PageRequest.of(0, 10)).getContent();
        Set<Long> arrCate = list.stream().map(Category::getId).collect(Collectors.toSet());
        List<CategoriesHomeDTO> products = new ArrayList<>();
        Pageable pageable = PageRequest.of(0,numberProduct);
        for (Category cate : list) {
            List<Product> productById = productRepository.findListProductByCategoryId(cate.getId());
            products.add(CategoriesHomeDTO.builder()
                                 .product(productById)
                                 .id(cate.getId())
                                 .name(cate.getName())
                                 .thumbnail(cate.getThumbnail())
                                 .build());
        }
        return products;
    }

    @Override
    public Product add(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product, Long idProduct) {
        return null;
    }

    @Override
    public void deleteById(Long idProduct) {

    }
}
