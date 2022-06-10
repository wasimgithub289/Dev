package com.ng;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException 
	{
		String jsonString = "[{\"name\":\"mkyong\", \"id\":37}, {\"name\":\"fong\", \"id\":38}]";
		//String jsonString = "[{\\\"name\\\":\\\"mkyong\\\", \\\"age\\\":37}, {\\\"name\\\":\\\"fong\\\", \\\"age\\\":38}]";
		
		ObjectMapper objectMapper = new ObjectMapper();
		UserData[] users = objectMapper.readValue(jsonString, UserData[].class);
		//List<UserData> users = Arrays.asList(objectMapper.readValue(jsonString, UserData.class));
		 //List<UserData> users = objectMapper.readValue(jsonString, new TypeReference<List<UserData>>() {});
		
		for(UserData u:users)
		{
			System.out.println(u.toString());
		}
		
	}

}

class UserData
{
	Integer id;
	String name;
	String email;
	String gender;
	String status;
	
	public UserData()
	{
		
	}
	public UserData(Integer id, String name, String email, String gender, String status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", status=" + status
				+ "]";
	}
	
}
