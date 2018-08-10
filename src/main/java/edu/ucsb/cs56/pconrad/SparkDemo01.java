package edu.ucsb.cs56.pconrad;


import static spark.Spark.*;

/**
 * Hello world!
 *
 */

public class SparkDemo01 {
    public static void main(String[] args) {
		System.out.println("");
		System.out.println("(Don't worry about the warnings below about SLF4J... we'll deal with those later)");
		System.out.println("");						  
		System.out.println("In browser, visit: http://localhost:4567/hello");
		System.out.println("");
        get("/hello", (req, res) -> "Hello World");
    }
}
