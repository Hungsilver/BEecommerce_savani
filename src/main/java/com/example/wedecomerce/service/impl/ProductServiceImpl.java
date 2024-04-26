package com.example.wedecomerce.service.impl;

import com.example.wedecomerce.domain.Category;
import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.dto.home_page.CategoriesHomeDTO;
import com.example.wedecomerce.dto.buy_product.ProductDetailDTO;
import com.example.wedecomerce.dto.buy_product.ProductSellerDTO;
import com.example.wedecomerce.dto.buy_product.TierVariationsDTO;
import com.example.wedecomerce.repository.CategoryRepository;
import com.example.wedecomerce.repository.ProductDetailRepository;
import com.example.wedecomerce.repository.ProductRepository;
import com.example.wedecomerce.repository.VariationOptionRepository;
import com.example.wedecomerce.repository.VariationRepository;
import com.example.wedecomerce.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
@Transactional
public class ProductServiceImpl implements IProductService {

    public ProductServiceImpl(ProductRepository productRepository, ProductDetailRepository productDetailRepository, VariationRepository variationRepository, VariationOptionRepository variationOptionRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productDetailRepository = productDetailRepository;
        this.variationRepository = variationRepository;
        this.variationOptionRepository = variationOptionRepository;
        this.categoryRepository = categoryRepository;
    }

    ProductRepository productRepository;
    ProductDetailRepository productDetailRepository;
    VariationRepository variationRepository;
    VariationOptionRepository variationOptionRepository;
    CategoryRepository categoryRepository;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<CategoriesHomeDTO> getAllProductByCategories(Integer numberProduct) {
        List<Category> list = categoryRepository.findAllByCategoryParentIsNull();
        List<CategoriesHomeDTO> products = new ArrayList<>();
        Pageable pageable = PageRequest.of(0, numberProduct);
        for (Category cate : list) {
            Page<Product> productById = productRepository.findListProductByCategoryId(pageable, cate.getId());
            products.add(CategoriesHomeDTO.builder()
                                 .products(null) //fix
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

    @Override
    public ProductSellerDTO getOne(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            return null;
        }
        List<String> tierColor = variationRepository.findTierVariation(id, 1);
        List<String> tierSize = variationRepository.findTierVariation(id, 2);
        List<ProductDetailDTO> productDetailDTOS = productDetailRepository.findByProductId(id).stream().map(item -> {
            List<String> listName = item.getVariationOptions().stream().map(variation -> {
                return variation.getValue();
            }).collect(Collectors.toList());
            String nameAttribute = String.join(",", listName);
            return ProductDetailDTO.builder()
                    .id(item.getId())
                    .name(nameAttribute)
                    .productId(item.getProduct().getId())
                    .sku(item.getSku())
                    .price(item.getPrice())
                    .build();
        }).collect(Collectors.toList());

        TierVariationsDTO color = TierVariationsDTO.builder()
                .name("Màu sắc")
                .options(tierColor)
                .build();

        TierVariationsDTO size = TierVariationsDTO.builder()
                .name("Size")
                .options(tierSize)
                .build();
        List<TierVariationsDTO> list = Arrays.asList(color, size);

        ProductSellerDTO sellerDTO = ProductSellerDTO.builder()
                .id(id)
                .name(product.get().getName())
                .priceMin(1.2)
                .priceMax(3.2)
                .models(productDetailDTOS)
                .tierVariations(list)
                .build();
        return sellerDTO;
    }
}
