package com.example.wedecomerce.service.impl;

import com.example.wedecomerce.controller.rest.exception.NotFoundException;
import com.example.wedecomerce.domain.Category;
import com.example.wedecomerce.domain.Product;
import com.example.wedecomerce.domain.ProductDetail;
import com.example.wedecomerce.domain.Promotion;
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

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    public ProductSellerDTO getOne(String code) {
        Optional<Product> product = productRepository.findByCode(code) ;
        if (product.isEmpty()) {
            throw new NotFoundException("not found product by code");
        }

        BigDecimal priceMin = new BigDecimal("10000000");
        BigDecimal priceMax = new BigDecimal("0");
        int stock = 0;
        BigDecimal discount = new BigDecimal("0");
        boolean typeDiscount = false; // true(1) = money || false(0) = %
        List<ProductDetailDTO> productDetailDTOS = new ArrayList<>();
        List<String> tierColor = variationRepository.findTierVariation(product.get().getId(), 1);
        List<String> tierSize = variationRepository.findTierVariation(product.get().getId(), 2);
        List<ProductDetail> productDetails = productDetailRepository.findByProductId(product.get().getId()); //get products details
        Optional<Promotion> promotion = Optional.ofNullable(product.get().getPromotion()); //get promotion
        discount = promotion.isEmpty() ? discount : promotion.get().getValue();

        for (ProductDetail item : productDetails) { //for list productDetail in product
            List<String> listName = item.getVariationOptions().stream().map(variation ->
                    variation.getValue()
            ).collect(Collectors.toList());
            priceMin = priceMin.compareTo(item.getPrice()) < 0 ? priceMin : item.getPrice();
            priceMax = priceMax.compareTo(item.getPrice()) < 0 ? item.getPrice() : priceMax;
            stock += item.getQuantity();
            String nameAttribute = String.join(",", listName);
            BigDecimal priceAfterDiscount = item.getPrice().subtract((item.getPrice().multiply(discount)).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP));
            productDetailDTOS.add(
                    ProductDetailDTO.builder() // Product-detail
                            .id(item.getId())
                            .name(nameAttribute)
                            .stock(item.getQuantity())
                            .productId(item.getProduct().getId())
                            .image(item.getImage())
                            .sku(item.getSku())
                            .sold(item.getSold())
                            .showDiscount(discount.intValue())
                            .price(priceAfterDiscount)
                            .priceBeforeDiscount(item.getPrice())
                            .build());
        }

        TierVariationsDTO color = TierVariationsDTO.builder()
                .name("Màu sắc")
                .options(tierColor)
                .build();

        TierVariationsDTO size = TierVariationsDTO.builder()
                .name("Size")
                .options(tierSize)
                .build();
        List<TierVariationsDTO> list = Arrays.asList(color, size);

        // Product Main
        ProductSellerDTO sellerDTO = ProductSellerDTO.builder()
                .id(product.get().getId())
                .name(product.get().getName())
                .priceMin(priceMin.subtract((priceMin.multiply(discount)).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP)))
                .priceMax(priceMax.subtract((priceMax.multiply(discount)).divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP)))
                .priceMinBeforeDiscount(priceMin)
                .priceMaxBeforeDiscount(priceMax)
                .showDiscount(discount.intValue())
                .image(product.get().getImage())
                .description(product.get().getDescription())
                .status(product.get().getStatus())
                .promotionId(product.get().getPromotion().getId())
                .stock(stock)
                .sold(12)
                .models(productDetailDTOS)
                .tierVariations(list)
                .build();
        return sellerDTO;
    }

    private int handlerDiscount(BigDecimal discount, boolean typePromotion) {
        return discount != null ? discount.intValue() : 0;
    }


}
