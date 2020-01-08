package com.example.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	
	@GetMapping(value = "/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId){
		return Collections.singletonList(
				new CatalogItem("Transformers","Good",4)
		);
	}
}
