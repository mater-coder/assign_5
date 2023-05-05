package com.services;

import java.net.http.HttpResponse;

public class ResponseCodeHandler {

	public static void printMssgToConsole(HttpResponse<String> response) {
		int statusCode = response.statusCode();
		switch (statusCode) {
		case 200:
			System.out.println("The request was successful.");
			break;
		case 400:
			System.out.println(
					"Bad Request: The request could not be understood " + "or was missing required parameters.");
			break;
		case 401:
			System.out.println("Unauthorized: Authentication failed or "
					+ "user does not have permissions for the requested operation.");
			break;
		case 404:
			System.out.println("Not Found: The requested resource could not be found.");
			break;
		case 500:
			System.out.println(" Internal Server Error: An error occurred on the server.");
			break;
		default:
			System.out.println("Unknown Error: ");
			break;
		}

	}

}
