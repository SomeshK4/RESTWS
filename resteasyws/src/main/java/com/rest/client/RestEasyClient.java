package com.rest.client;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

public class RestEasyClient {
	private static final String URL = "http://localhost:8088/resteasyws/rest/json/getJson";

	public static void main(String[] args) {
		ClientRequest clientReq = new ClientRequest(URL);
		clientReq.accept(MediaType.APPLICATION_JSON);

		ClientResponse<String> response;
		try {
			response = clientReq.get(String.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					new ByteArrayInputStream(response.getEntity().getBytes())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
