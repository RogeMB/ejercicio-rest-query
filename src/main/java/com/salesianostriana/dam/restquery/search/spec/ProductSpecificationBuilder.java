package com.salesianostriana.dam.restquery.search.spec;

import com.salesianostriana.dam.restquery.model.Product;
import com.salesianostriana.dam.restquery.search.util.SearchCriteria;

import java.util.List;

public class ProductSpecificationBuilder extends GenericSpecificationBuilder<Product>{
    public ProductSpecificationBuilder(List<SearchCriteria> params) {
        super(params, Product.class, Product.hiddenFields);
    }
}