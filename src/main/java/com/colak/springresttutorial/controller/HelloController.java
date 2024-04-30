package com.colak.springresttutorial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HelloController {

    // The @RequestParam annotation in Spring MVC is used to extract query parameters from the request URL.
    // Query parameters are typically appended to the URL after a question mark (?) and separated by ampersands (&).
    // Parameters can be optional by setting the required attribute to false.
    // http://localhost:8080/api/products?id=123&name=Laptop
    @GetMapping("/products")
    public ResponseEntity<String> getProductById(@RequestParam Long id,
                                                 @RequestParam(required = false) String name) {
        String body = "id :" + id + " name : " + name;
        return ResponseEntity.ok(body);
    }

    // On the other hand, the @PathVariable annotation is used to extract values from URI templates.
    // URI templates are parts of the URL path enclosed in curly braces ({}).
    // Path variables are mandatory; they must be present in the URL path.
    // http://localhost:8080/api/products/2
    @GetMapping("/products/{id}")
    public ResponseEntity<String> getProductById(@PathVariable Long id) {
        String body = "id :" + id;
        return ResponseEntity.ok(body);
    }

    // Mixed usage
    // http://localhost:8080/api/category/shoe/sandals?sortBy=ASC
    @GetMapping("/category/{category}/{subcategory}")
    public ResponseEntity<String> getProductsByCategory(
            @PathVariable String category,
            @PathVariable String subcategory,
            @RequestParam(required = false) String sortBy
    ) {
        String body = "category :" + category + " subcategory :" + subcategory + " sortBy : " + sortBy;
        return ResponseEntity.ok(body);
    }
}
