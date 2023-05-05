package com.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.entities.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.Constants;

@Service
public class LoginServiceImpl implements LoginService {

	ObjectMapper mapper = new ObjectMapper();

	// Method to get All users!
	public void getAllUsers() {
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(Constants.BASE_URL + Constants.USERS))
				.build();
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse<String> response;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			List<User> list = mapper.readValue(response.body(), new TypeReference<ArrayList<User>>() {
			});
			System.out.println(list.size());
			System.out.println(response.statusCode());
			ResponseCodeHandler.printMssgToConsole(response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private String username = null;

	// Method to valid login details
	public User loginUser(String userId, String password) {
		// Create an instance of HttpClient
		HttpClient client = HttpClient.newHttpClient();

		// Create an instance of the request body
		Map<String, String> requestBody = new HashMap<String, String>();
		requestBody.put("userId", "userId");
		requestBody.put("password", "password");

		// Convert the request body to JSON string
		String requestBodyJson;
		try {
			requestBodyJson = mapper.writeValueAsString(requestBody);
			// Create an instance of the request
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(Constants.BASE_URL + Constants.USERS + "/" + userId + "/" + password))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(requestBodyJson)).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			// Print the response body
			ResponseCodeHandler.printMssgToConsole(response);
			System.out.println(response.body());
			User user = mapper.readValue(response.body(), User.class);
			username = user.getName();
			return user;
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return null;

	}

	public String getUserName() {
		return username;
	}
}
