package HW22_RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UsersTest {

    @Test
    public void printEmails(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();
        JsonPath jsonPath = new JsonPath(response);
        List<String> emails = jsonPath.getList("email");
        for (String email : emails) {
            System.out.println(email);
        }
    }
    @Test
    public void printZipCodes(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();
        JsonPath jsonPath = new JsonPath(response);
        List<String> zipCodes = jsonPath.getList("address.zipcode");
        for (String zipCode : zipCodes) {
            System.out.println(zipCode);
        }
    }
    @Test
    public void printZipCodesWithoutDash(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();
        JsonPath jsonPath = new JsonPath(response);
        List<String> zipCodes = jsonPath.getList("findAll{!it.address.zipcode.contains('-')}.address.zipcode");
        System.out.println(zipCodes);
    }
    @Test
    public void latAndLng (){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();
        JsonPath jsonPath = new JsonPath(response);
        List<String> usersWithLatLng = jsonPath.getList("collect{it.name + ' is situated at: lat = ' " +
                "+ it.address.geo.lat + ' and lng = ' + it.address.geo.lng}");
        for (String userString : usersWithLatLng) {
            System.out.println(userString);
        }
    }

    @Test
    public void latAndLngNegative (){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();
        JsonPath jsonPath = new JsonPath(response);
        List<String> names = jsonPath.getList("findAll{it.address.geo.lat.contains('-')}.findAll" +
                "{it.address.geo.lng.contains('-')}.name");
        System.out.println(names);
    }
    @Test
    public void website (){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();
        JsonPath jsonPath = new JsonPath(response);
        List<String> names = jsonPath.getList("findAll{it.website.endsWith('.info')}.name");
        System.out.println(names);
    }
    @Test
    public void lngMax (){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();
        JsonPath jsonPath = new JsonPath(response);
        double maxLat = jsonPath.get("collect{it.address.geo.lat.toDouble()}.max()");
        System.out.println("Max lat: " + maxLat);
    }
    @Test
    public void longestCatchPhrase (){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();
        JsonPath jsonPath = new JsonPath(response);
        String name = jsonPath.get("max{it.company.catchPhrase.length()}.name");
        System.out.println(name + " has the longest catchPhrase" );
    }
}
