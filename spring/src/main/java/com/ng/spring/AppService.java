package com.ng.spring;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AppService {

	public static void main(String[] args) throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();
		
		 /*Post Entity  (Create User)**/
		
		URI postUserUri = new URI("https://gorest.co.in/public/v2/users?access-token=8da00d3668ac46395076cd599638907160ee6c02d31d07080e39fe6768305884");
	    User user = new User(27042022,"JohnCena","john.cena@gmail.com","Male","Active");
	    //ResponseEntity<User> response = restTemplate.postForEntity(postUserUri, user, User.class);
	    //System.out.println(response.getBody().toString());
		
		 /*Get Entity  (Get All users)**/
	    
	    URI getUserUri = new URI("https://gorest.co.in/public/v2/users");
	    ResponseEntity<User[]> userInfo = restTemplate.getForEntity(getUserUri, User[].class);
	    List<User> list = Arrays.asList(userInfo.getBody());
	    for(User u:list)
	    {
	    	System.out.println(u);
	    }
	    
	    /*Delete Entity  (Delete user)**/
	    
	    final String  deleteUserUri= "https://gorest.co.in/public/v2/users/2602?access-token=8da00d3668ac46395076cd599638907160ee6c02d31d07080e39fe6768305884";
	    Map <String,Integer > params = new HashMap <String,Integer>();
        params.put("id", 2602);
        //restTemplate.delete(deleteUserUri, params);
	    System.out.println("Record deleted");
	    
	    /*Update Entity  (UPdate user)**/
	    
	    final String  putUserUri= "https://gorest.co.in/public/v2/users/4274?access-token=8da00d3668ac46395076cd599638907160ee6c02d31d07080e39fe6768305884";
	    User userUpdated = new User(27042022,"JohnCenaUpdated","john.cena@gmail.com","Male","Active");
	    Map <String,Integer > params2 = new HashMap <String,Integer>();
        params.put("id", 4274);
        restTemplate.put(putUserUri, userUpdated, params2);
	    System.out.println("Record updated");
	}

}
