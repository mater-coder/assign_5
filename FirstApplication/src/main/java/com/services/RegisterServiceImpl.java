package com.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.Constants;

@Service
public class RegisterServiceImpl implements RegisterService {

	ObjectMapper mapper = new ObjectMapper();

	public void registerUser(User user) {
		// Create an instance of HttpClient
		HttpClient client = HttpClient.newHttpClient();

		// Create an instance of the request body
		User map = mapper.convertValue(user, User.class);

		// Convert the request body to JSON string
		String requestBodyJson;
		try {
			requestBodyJson = mapper.writeValueAsString(map);
			// Create an instance of the request
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Constants.BASE_URL + Constants.USERS))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(requestBodyJson)).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			// Print the response body
			ResponseCodeHandler.printMssgToConsole(response);
			System.out.println("Registration Success!");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public boolean checkIfExist(String id) {
		HttpClient client = HttpClient.newHttpClient();
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(Constants.BASE_URL + Constants.USERS + "/" + id)).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			ResponseCodeHandler.printMssgToConsole(response);
			System.out.println(response.body());
			boolean isExist = mapper.readValue(response.body(), Boolean.class);
			System.out.println(isExist);
			return isExist;
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return false;
	}

}
