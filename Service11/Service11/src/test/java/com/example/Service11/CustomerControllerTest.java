package com.example.Service11;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.controller.CustomerController;
import com.model.Customer;
import com.service.CustomerService;
import com.util.Utility;

@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
@WebMvcTest(value= CustomerController.class)
@WithMockUser
public class CustomerControllerTest {

	 @Autowired
	 private MockMvc mockMvc;

	 
	 @MockBean
     private CustomerService customerService;
	 
	 Map<Long, Customer> mp=new HashMap();
		

	 @Before
	 public void beforeTest()
	 {
		 
		 System.out.println("before test.................");
		  Customer c1=new Customer();
		  c1.setId(1);
		  c1.setName("gopi");
		  c1.setMobile("121");
		  c1.setAge(3);
		  c1.setAddress("gdv");
		  
		  Customer c2=new Customer();
		  c2.setId(2);
		  c2.setName("gopi");
		  c2.setMobile("121");
		  c2.setAge(3);
		  c2.setAddress("gdv");
		  
		  Customer c3=new Customer();
		  c3.setId(3);
		  c3.setName("gopi");
		  c3.setMobile("121");
		  c3.setAge(3);
		  c3.setAddress("gdv");
		  
		  
		  
		 mp.put(c1.getId(), c1);
		 mp.put(c2.getId(), c2);
		 mp.put(c3.getId(), c3);
				  
		 
	 }
	 /*@Before
	 public void setup() {
	     MockitoAnnotations.initMocks(this);
	 } */
	 
	 @Test
	 public void testGetCustomer() throws Exception {

		 
			 
		  try {

				 
	  Mockito.when(customerService.getAllCustomers()).thenReturn(mp);
		 RequestBuilder requestBuilder = MockMvcRequestBuilders.get(Utility.ADD_CUSTOMER_PATH) .contentType(MediaType.APPLICATION_JSON);
	          
	    String given="{\"1\":{\"id\":1,\"name\":\"gopi\",\"address\":\"gdv\",\"mobile\":\"121\",\"age\":3},\"2\":{\"id\":2,\"name\":\"gopi\",\"address\":\"gdv\",\"mobile\":\"121\",\"age\":3},\"3\":{\"id\":3,\"name\":\"gopi\",\"address\":\"gdv\",\"mobile\":\"121\",\"age\":3},\"4\":{\"id\":4,\"name\":\"gopi\",\"address\":\"gdv\",\"mobile\":\"121\",\"age\":3}}";
		 
		 MvcResult result = mockMvc.perform(requestBuilder).andReturn();
            System.out.println("result...................................");
		 System.out.println(result.getResponse().getContentAsString());
		 
		 
		 System.out.println("result ended...................................1");
		JSONAssert.assertEquals(result.getResponse().getContentAsString(),given,false);
		 
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }

	 }
	 
	 @Test
	 public void testUpdateCustomer() throws Exception {

		 
			 
		  try {
			   
	Mockito.when(customerService.updateCustomer(Mockito.anyInt(),Mockito.anyString())).thenReturn(true);
		 RequestBuilder requestBuilder = MockMvcRequestBuilders.put(Utility.UPDATE_CUSTOMER_PATH).param("cid","193").param("cname", "gopy"); //.contentType(MediaType.TEXT_PLAIN);
	          
	    
		 MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println("result update...................................");
        
		 System.out.println(result.getResponse().getContentAsString().toString());
		 
		 
		 System.out.println("result update ended...................................1w");
		 
		JSONAssert.assertEquals(result.getResponse().getContentAsString().toString(),Utility.UPDATE_CUSTOMERE_RESPONSE_MSG,false);
		 
		 
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }

	 }

		
	/* @Test
	 public void testGetCustomer1() throws Exception {

		 
			 
		  try {
			  RestTemplate restt=new RestTemplate();
			
				 
	// Mockito.when(customerService.getAllCustomers()).thenReturn(mp);
		// RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/serv1/getCustomer") .contentType(MediaType.APPLICATION_JSON);
	          
	    String given="{\"1\":{\"id\":1,\"name\":\"gopi\",\"address\":\"gdv\",\"mobile\":\"121\",\"age\":3},\"2\":{\"id\":2,\"name\":\"gopi\",\"address\":\"gdv\",\"mobile\":\"121\",\"age\":3},\"3\":{\"id\":3,\"name\":\"gopi\",\"address\":\"gdv\",\"mobile\":\"121\",\"age\":3},\"4\":{\"id\":4,\"name\":\"gopi\",\"address\":\"gdv\",\"mobile\":\"121\",\"age\":3}}";
		 
		// MvcResult result = mockMvc.perform(requestBuilder).andReturn();
            System.out.println("result...................................");
		// System.out.println(result.getResponse().getContentAsString());
		 

        	HttpHeaders headers = new HttpHeaders();
        	headers.setContentType(MediaType.APPLICATION_JSON);
        	headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        	headers.set("X-Request-Source", "Desktop");

        	HttpEntity request = new HttpEntity(headers);
        	

        	ResponseEntity<String> result = restt.exchange(
        			"http://localhost:8084/serv1/getCustomer",
        	        HttpMethod.GET,
        	        request,
        	        String.class,
        	        1
        	);
        	System.out.println("result...................................");
        	JSONObject arr = new JSONObject(result.getBody().toString());
   		 System.out.println(arr);
   		 
            
		 System.out.println("result ended...................................2");
		JSONAssert.assertEquals(result.getBody().toString(),given,false);
		 
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }

	 }
	
*/
	
}
