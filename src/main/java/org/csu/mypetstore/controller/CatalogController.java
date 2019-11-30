package org.csu.mypetstore.controller;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    /*
    客户端请求提供categoryId，返回一个category对象
     */
    @GetMapping("/catalog/category/{categoryId}")
    public Category category(@PathVariable("categoryId") String categoryId)
    {
        return catalogService.getCategory(categoryId);
    }

    @GetMapping("/catalog/category/{categoryId}/products")
    public List<Product> products(@PathVariable("categoryId") String categoryId){
        return catalogService.getProductListByCategory(categoryId);
    }

    @GetMapping("/catalog/{productId}")
    public Product product(@PathVariable("productId") String productId){
        return catalogService.getProduct(productId);
    }

    @GetMapping("/catalog/{productId}/items")
    public List<Item> items(@PathVariable("productId") String productId){
        return catalogService.getItemListByProduct(productId);
    }
}
