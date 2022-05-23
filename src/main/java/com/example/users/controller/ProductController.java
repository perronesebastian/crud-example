package com.example.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.users.dto.ProductDto;
import com.example.users.entity.EmployeeEntity;
import com.example.users.entity.ProductEntity;
import com.example.users.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductEntity> create(@RequestBody ProductDto productDto){
		productService.create(productDto);
		return new ResponseEntity<ProductEntity>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductEntity> update(@PathVariable("id") Long id, @RequestBody ProductDto product){
		productService.update(id, product);
		return new ResponseEntity<ProductEntity>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<EmployeeEntity> delete(@PathVariable("id") Long id){
		productService.delete(id);
		return new ResponseEntity<EmployeeEntity>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> get(@PathVariable("id") Long id){
		ProductDto dto = productService.get(id);
		return new ResponseEntity<ProductDto>(dto, HttpStatus.OK);
	}
}
