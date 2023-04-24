package com.thiruacademy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiruacademy.Config;
import com.thiruacademy.LazyLoadingBean;
import com.thiruacademy.entity.Product;
import com.thiruacademy.exception.ProductNotFoundException;
import com.thiruacademy.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
@CrossOrigin
@PropertySource("classpath:custom.properties")
@Scope("singleton")
public class ProductController {
	@Autowired
	//@Qualifier("productServiceImpl")
	private ProductService productService;
	@Autowired
	private LazyLoadingBean lazyLoadingBean;
	
	@Value("${server.port}")
	private String port;
	@Value("${server.name}")
	private String name;
	
	@Value("${server.message}")
	private String message;
	
	@Autowired
	private Config config;
	
	public ProductController() {
		System.out.println("ProductController ONject Created");
	}
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product){
		return new ResponseEntity<Product> (productService.saveProduct(product), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAll")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<Product>> getAllCustomers(){
		System.out.println("Port and name values :: " + port + " " + name);
		System.out.println("message :: "+ message);
		System.out.println("Config Object :: "+config);
		return new ResponseEntity<List<Product>> (productService.fetchAllProducts(), HttpStatus.CREATED);
	}
	
	@GetMapping("/fetch/{id}")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	public Product getCustomer(@PathVariable Long id) throws ProductNotFoundException{
		return productService.fetchProduct(id);
	}
	
	@PutMapping("/putUpdate/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Product> putUpdateCustomer(@PathVariable Long id, @Valid @RequestBody Product product) throws ProductNotFoundException{
		return new ResponseEntity<Product> (productService.putUpdateProduct(id, product), HttpStatus.CREATED);
	}
	
	@PatchMapping("/patchUpdate/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Product> patchUpdateCustomer(@PathVariable Long id, @Valid @RequestBody Map<String, Object> product)throws ProductNotFoundException {
		return new ResponseEntity<Product> (productService.patchUpdateProduct(id, product), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> patchUpdateCustomer(@PathVariable Long id){
		return new ResponseEntity<String> (productService.deleteProduct(id), HttpStatus.CREATED);
	}
	

}
