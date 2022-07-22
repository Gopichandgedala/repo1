package com.consume;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.model.Customer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("serv2")
public class Caller {

	Caller() {
		System.out.println("caller const------------------------------");
	}

	@Autowired
	private RestTemplate restt;

	@GetMapping(value = "/getCustomerCaller1", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<Long, Customer> getCustomer1() {

		Map m = new HashMap();
		Customer c = new Customer();
		c.setId(1);
		c.setName("gg");
		c.setAddress("gdv");
		c.setAge(20);

		Customer c1 = new Customer();
		c1.setId(2);
		c1.setName("gg");
		c1.setAddress("gdv");
		c1.setAge(20);

		m.put(1, c);
		m.put(2, c1);

		return m;
	}

	/*@HystrixCommand(fallbackMethod="getFallbackGetCustomer",
	commandProperties= {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000"),
			@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="6"),
			@HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50"),
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5000")
			
	} 
    )*/
	@GetMapping( "/getCustomerCaller")
	@CircuitBreaker(name="fallbackForgetCustomer",fallbackMethod="getFallbackGetCustomer")
	public ResponseEntity<Object> getCustomer(@RequestParam String id) throws JSONException, InterruptedException {

	
				  
		  
		  Map<String,Customer> result = restt.getForObject("http://localhost:8087/serv1/getCustomer",Map.class);

		  JSONObject jsonObject = new JSONObject(result);
		  
		  JSONObject classJsonObj = jsonObject.optJSONObject(id);
		  if(classJsonObj==null) {
		  return new ResponseEntity<Object>("{\"msg\":\"no data found\"}",HttpStatus.OK);
		  }
		  
		  return new ResponseEntity<Object>(classJsonObj.toString(),HttpStatus.OK);
		  
		 
	}

	public ResponseEntity<Map> getFallbackGetCustomer(@RequestParam String id,RuntimeException e) throws JSONException {

		Customer c = new Customer();
		c.setId(0);
		c.setName("none");
		c.setAddress("none");
		c.setAge(-1);
		c.setMobile("none");
		HashMap m=new HashMap();
		 m.put("msg","Requested Server is down, please try after some time");
		
           
		return new ResponseEntity<Map>(m, HttpStatus.SERVICE_UNAVAILABLE);

	}

}
