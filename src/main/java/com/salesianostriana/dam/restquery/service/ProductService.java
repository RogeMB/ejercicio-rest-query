package com.salesianostriana.dam.restquery.service;

import com.salesianostriana.dam.restquery.dto.PageDto;
import com.salesianostriana.dam.restquery.dto.ProductDto;
import com.salesianostriana.dam.restquery.model.Product;
import com.salesianostriana.dam.restquery.repo.ProductRepository;
import com.salesianostriana.dam.restquery.search.spec.ProductSpecificationBuilder;
import com.salesianostriana.dam.restquery.search.util.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public PageDto<ProductDto> search(List<SearchCriteria> params, Pageable pageable){
        ProductSpecificationBuilder psBuilder = new ProductSpecificationBuilder(params);

        Specification<Product> spec = psBuilder.build();
        Page<ProductDto> pageProductDto = productRepository.findAll(spec, pageable).map(ProductDto::of);

        return new PageDto<>(pageProductDto);
    }
}