package com.example.KingsMen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.KingsMen.service.ProductService;
import com.example.KingsMen.service.CatagoryService;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.KingsMen.model.Product;




@Controller
public class ProductsController {

    @Autowired
    CatagoryService catagoryService;

    @Autowired
    ProductService productService;


    @GetMapping("/product")
    public String getProductsPage(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("categories", catagoryService.getAllCategory());
        return "/frontend-views/product-page";
    }

    @GetMapping("/product/product-detail/{id}")
    public String getProductDetailPage(Model model, @PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "/frontend-views/product-detail-page";
    }
}


  /*private List<Product> getAllProducts(){
    return productService.findAllByOrderByIdAsc();
    

  }*/


