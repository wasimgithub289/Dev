package com.ng.controllers;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.ng.entities.Product;
import com.ng.services.ProductService;


@RestController
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@GetMapping(
		value = "/findall",
		produces = { MimeTypeUtils.APPLICATION_JSON_VALUE },
		headers = "Accept=application/json"
	)
	public ResponseEntity<Iterable<Product>> findAll() {
		try {
			return new ResponseEntity<Iterable<Product>>(productService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<Product>>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(
			value = "/saveProduct",
			method = RequestMethod.POST,
			produces = { MimeTypeUtils.APPLICATION_JSON_VALUE },
			consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE },
			headers = "Accept=application/json"
		)
		public ResponseEntity<Product> create(@RequestBody Product product) {
			try {
				return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
			}

		}
	
	@GetMapping(
			value = "/getProductById/{id}",
			produces = { MimeTypeUtils.APPLICATION_JSON_VALUE },
			headers = "Accept=application/json"
		)
		public ResponseEntity<Optional<Product>> getProductById(@PathVariable int id) {
			try {
				return new ResponseEntity<Optional<Product>>(productService.getProduct(id), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Optional<Product>>(HttpStatus.BAD_REQUEST);
			}

		}
	

	@GetMapping(value = "/callApi")
	public void callApi() throws URISyntaxException 
	{
	    URI uri = new URI("http://localhost:8080/product/saveProduct");
	    HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Product product = new Product();
		product.setName("Aleena Didi Papa");
		product.setPrice(BigDecimal.valueOf(123));
		product.setQuantity(5);
		product.setStatus(true);
		
		RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<Product> responseEntity = restTemplate.postForEntity(uri, product, Product.class);
	     
	    System.out.println("Response-->"+responseEntity);
		if (responseEntity != null)
		{
			HttpStatus httpStatus = responseEntity.getStatusCode();
			System.out.println("Status Code: " + httpStatus);
			Product productInfo = responseEntity.getBody();
			System.out.println("Inserted Id: " + productInfo.getId());
		} 
		else 
		{
			System.out.println("Can not connect to find web method");
		}
		
		uri = new URI("http://localhost:8080/product/findall");
		ResponseEntity<Product[]> responseEntity2 = restTemplate.getForEntity(uri, Product[].class);
		
		for (Product e : responseEntity2.getBody()) 
		{
			System.out.println(e.toString());
		}
	     
	}

}