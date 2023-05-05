package com.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.entities.Author;
import com.entities.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utils.Constants;

@Service
public class BookServiceImpl implements BookService {

	ObjectMapper mapper = new ObjectMapper();

	public List<Book> getBookList() {
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(Constants.BASE_URL + Constants.BOOKS))
				.build();
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse<String> response;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			List<Book> list = mapper.readValue(response.body(), new TypeReference<ArrayList<Book>>() {
			});
			ResponseCodeHandler.printMssgToConsole(response);
			System.out.println(response.statusCode());
			return list;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Author> getAuthorList() {
		List<Author> list = new ArrayList<Author>();
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(Constants.BASE_URL + Constants.AUTHOR))
				.build();
		HttpClient client = HttpClient.newBuilder().build();
		HttpResponse<String> response;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			list = mapper.readValue(response.body(), new TypeReference<ArrayList<Author>>() {
			});
			ResponseCodeHandler.printMssgToConsole(response);
			System.out.println(response.statusCode());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addBook(Book book) {
		// Create an instance of HttpClient
		HttpClient client = HttpClient.newHttpClient();

		// Create an instance of the request body
		Book bookMap = mapper.convertValue(book, Book.class);

		// Convert the request body to JSON string
		String requestBodyJson;
		try {
			requestBodyJson = mapper.writeValueAsString(bookMap);
			// Create an instance of the request
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Constants.BASE_URL + "book"))
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(requestBodyJson)).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			ResponseCodeHandler.printMssgToConsole(response);
			System.out.println(response.body());
			System.out.println("Book added Success!");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public void deleteBook(int id) {
		// create an instance of HttpClient
		HttpClient client = HttpClient.newHttpClient();

		// specify the DELETE API endpoint with the id
		URI uri = URI.create(Constants.BASE_URL + "books/" + id);

		// create an instance of HttpRequest with the DELETE method
		HttpRequest request = HttpRequest.newBuilder().uri(uri).DELETE().build();

		// send the request and get the response
		HttpResponse<String> response;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			int statusCode = response.statusCode();
			ResponseCodeHandler.printMssgToConsole(response);
			if (statusCode == 200) {
				System.out.println("Book with id " + id + " has been deleted.");
			} else {
				System.out.println("Failed to delete book with id " + id + ". Status code: " + statusCode);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public Book getBookById(int id) {
		// Create an instance of HttpClient
		HttpClient client = HttpClient.newHttpClient();
		try {
			// Create an instance of the request
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(Constants.BASE_URL + Constants.BOOKS + "/" + id))

					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			// Print the response body
			System.out.println(response.body());
			ResponseCodeHandler.printMssgToConsole(response);
			Book book = mapper.readValue(response.body(), Book.class);
			System.out.println(book.toString());
			return book;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}

	public void updateBook(Book book) {
		// Create an instance of HttpClient
		HttpClient client = HttpClient.newHttpClient();

		// Create an instance of the request body
		Book bookMap = mapper.convertValue(book, Book.class);

		// Convert the request body to JSON string
		String requestBodyJson;
		try {
			requestBodyJson = mapper.writeValueAsString(bookMap);
			// Create an instance of the request
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Constants.BASE_URL + "book"))
					.header("Content-Type", "application/json")
					.PUT(HttpRequest.BodyPublishers.ofString(requestBodyJson)).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			// Print the response body
			ResponseCodeHandler.printMssgToConsole(response);
			System.out.println(response.body());
			System.out.println("Book updated Success!");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
