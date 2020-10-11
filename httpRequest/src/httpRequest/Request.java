package httpRequest;

//method 1
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
//method 1 

//method 2
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//method 2



public class Request {
	
	// method 1 : private static HttpURLConnection connection;
	
	public static void main(String[] args) {
		
		//Method 1 : java.net.HttpURLConnection
		
		
		/*
		//buffer Reader to get response because input 
		//coming from io
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums");
			connection = (HttpURLConnection)url.openConnection();
			
			//request setup
			
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			// Response
			
			int status = connection.getResponseCode();
			System.out.print(status);
			
			if(status>299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while((line = reader.readLine())!=null) {
					responseContent.append(line);
				}
				reader.close();
			}else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while((line = reader.readLine())!=null) {
					responseContent.append(line);
				}
				reader.close();
			}
			System.out.println(responseContent.toString());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
		
		*/
		
		// Method 2: java.net.http.HttpClient
		
		
		//request
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/albums")).build();	
		
		//sending request async
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
		.thenApply(HttpResponse::body)
		.thenAccept(System.out::println)
		.join();
		
		// method 2
	}

}
