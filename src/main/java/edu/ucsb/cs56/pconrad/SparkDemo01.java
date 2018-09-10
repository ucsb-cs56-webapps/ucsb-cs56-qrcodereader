package edu.ucsb.cs56.pconrad;

import static spark.Spark.port;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.common.collect.ImmutableMap;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.ByteArrayInputStream;

import java.util.*;
/**
 * Hello world!
 *
 */

public class SparkDemo01 {
   
    public static void main(String[] args) throws Exception {
	InputStream serviceAccount = new ByteArrayInputStream(getFireBaseCredentials().getBytes("UTF-8"));
	GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
	FirebaseOptions options = new FirebaseOptions.Builder()
    	.setCredentials(credentials)
    	.build();
	FirebaseApp.initializeApp(options);

	Firestore db = FirestoreClient.getFirestore();

	DocumentReference docRef = db.collection("users").document("alovelace");
	// Add document data  with id "alovelace" using a hashmap
	Map<String, Object> data = new HashMap<>();
	data.put("first", "Ada");
	data.put("last", "Lovelace");
	data.put("born", 1820);
	//asynchronously write data
	ApiFuture<WriteResult> result = docRef.set(data);
	// ...
	// result.get() blocks on response
	
	System.out.println("Update time : " + result.get().getUpdateTime());
	
	// asynchronously retrieve all users
	ApiFuture<QuerySnapshot> query = db.collection("users").get();
	// ...
	// query.get() blocks on response
	QuerySnapshot querySnapshot = query.get();
	List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
	for (QueryDocumentSnapshot document : documents) {
  	System.out.println("User: " + document.getId());
  	System.out.println("First: " + document.getString("first"));
  	if (document.contains("middle")) {
    	System.out.println("Middle: " + document.getString("middle"));
 	 }
 	System.out.println("Last: " + document.getString("last"));
  	System.out.println("Born: " + document.getLong("born"));
	}
	


        port(getHerokuAssignedPort());
		
		System.out.println("");
		System.out.println("(Don't worry about the warnings below about SLF4J... we'll deal with those later)");
		System.out.println("");						  
		System.out.println("In browser, visit: http://localhost:" + getHerokuAssignedPort() + "/hello");
		System.out.println("");
        spark.Spark.get("/", (req, res) -> "Coming up soon!");
		spark.Spark.get("/hello", (req, res) -> "Hello World");
		spark.Spark.get("/bye", (req, res) -> "Goodbye World");
		spark.Spark.get("/yo", (req, res) -> "S'up World");
		spark.Spark.get("/tension", (req, res) -> "Midterm next week.  No problem dude");		
		//spark.Spark.get("/read", (req, res) -> read.html)
	}
	
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static String getFireBaseCredentials() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("FIREBASE_JSON") != null) {
            return processBuilder.environment().get("FIREBASE_JSON");
        }
	throw new RuntimeException("no FireBase Credential found.");
	
         
    }


	
}
