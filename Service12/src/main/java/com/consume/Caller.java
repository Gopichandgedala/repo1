package com.consume;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.model.Customer;

@RestController
@RequestMapping("serv2")
public class Caller {

	Caller()
	{
		System.out.println("caller const------------------------------");
	}
	
	
	@Autowired
	private RestTemplate restt;
	@GetMapping(value="/getCustomerCaller1",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<Long,Customer> getCustomer1()
	{

	 Map m=new HashMap();
	 Customer c=new Customer();
	 c.setId(1);
	 c.setName("gg");
	 c.setAddress("gdv");
	 c.setAge(20);
		
	 Customer c1=new Customer();
	 c1.setId(2);
	 c1.setName("gg");
	 c1.setAddress("gdv");
	 c1.setAge(20);
	 
	 m.put(1, c);
	 m.put(2,c1);
	 
		
	      
	 return m;
	}

 @GetMapping("/getCustomerCaller")
 public @ResponseBody String getCustomer(@RequestParam String id) throws JsonMappingException, JsonProcessingException
	{
	System.out.println("call getcustomer caller-------------------------------");
	
	
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
	headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

	headers.set("X-Request-Source", "Desktop");

	HttpEntity request = new HttpEntity(headers);
	
	
	ResponseEntity<Map> result = restt.exchange(
			"http://localhost:8087/serv1/getCustomer",
	        HttpMethod.GET,
	        request,
	        Map.class,
	        1
	);

	
	
	//String result = restt.getForObject("http://localhost:8084/serv1/getCustomer",String.class);
   // System.out.println(result);
	        // Map m=result.getBody();
               Object m= result.getBody().get(id);
               
               if(m==null)
               {
            	  return "no object found"; 
               }
               
	
	return m.toString();
		
	}
	
	
	
}
