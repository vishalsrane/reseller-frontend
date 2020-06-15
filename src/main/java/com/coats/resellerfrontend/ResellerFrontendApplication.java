package com.coats.resellerfrontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class ResellerFrontendApplication {

	private
		static RestTemplate restTemplate = new RestTemplate();

		public static void main(String[] args) {
			SpringApplication.run(ResellerFrontendApplication.class, args);

			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			User response = restTemplate.exchange("http://localhost:8080/api/user", HttpMethod.GET, entity, User.class).getBody();
			System.out.println(response);
	}

}

class User{
	public String name;
	public String username;
	public String password;
	User(){

	}
	User(String name, String username, String password){
		this.name = name;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
