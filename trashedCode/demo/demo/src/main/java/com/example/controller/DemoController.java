/*
 * To change this license header, choose Licene Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.objects.Customer;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Rohans
 */
@RestController
@RequestMapping(value = "/tollere")
public class DemoController {

	RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	public List<Customer> getCustomers(){
		String URL = "http://api.reimaginebanking.com/customers?key=b84d3a153e2842b8465bcc4fde3d1839";
		HttpHeaders header = new HttpHeaders();
		header.add("Accept", "application/json");
		HttpEntity<Customer> request = new HttpEntity<>(null, header);
ResponseEntity<List> response = restTemplate
  .exchange(URL, HttpMethod.GET, request, List.class);
return		response.getBody();


	}
		@RequestMapping(method = RequestMethod.POST, value = "/customers")
		@ResponseStatus(HttpStatus.CREATED)
	public Customer postCustomer(@RequestBody @Valid Customer customer){
		String URL = "http://api.reimaginebanking.com/customers?key=b84d3a153e2842b8465bcc4fde3d1839";
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		HttpEntity<Customer> request = new HttpEntity<>(customer, header);
ResponseEntity<Customer> response = restTemplate
  .exchange(URL, HttpMethod.POST, request, Customer.class);
return		response.getBody();


	}
//		@RequestMapping(method = RequestMethod.POST, value = "/customers")
//		@ResponseStatus(HttpStatus.CREATED)
//	public Customer postAccount(@RequestBody @Valid Customer customer){
//		String URL = "http://api.reimaginebanking.com/customers?key=b84d3a153e2842b8465bcc4fde3d1839";
//		HttpHeaders header = new HttpHeaders();
//		header.add("Content-Type", "application/json");
//		HttpEntity<Customer> request = new HttpEntity<>(customer, header);
//ResponseEntity<Customer> response = restTemplate
//  .exchange(URL, HttpMethod.POST, request, Customer.class);
//return		response.getBody();
//
//
//	}
	
	
}
