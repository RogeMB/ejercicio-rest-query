package com.salesianostriana.dam.restquery.controller;

import com.salesianostriana.dam.restquery.dto.PageDto;
import com.salesianostriana.dam.restquery.dto.ProductDto;
import com.salesianostriana.dam.restquery.search.util.SearchCriteria;
import com.salesianostriana.dam.restquery.search.util.SearchCriteriaExtractor;
import com.salesianostriana.dam.restquery.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<PageDto<ProductDto>> getAllProducts(
            @RequestParam(value = "s", defaultValue = "") String search,
            @PageableDefault(size = 25, page = 0) Pageable pageable){

        List<SearchCriteria> params = SearchCriteriaExtractor.extractSearchCriteriaList(search);
        PageDto<ProductDto> res = productService.search(params, pageable);

        if(res.getContent().isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(res);
    }

}