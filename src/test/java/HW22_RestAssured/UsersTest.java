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
        List<String> listOfEmails = jsonPath.getList("email");
        for (String email : listOfEmails) {
            System.out.println(email);
        }
    }
    @Test
    public void printZipCodes(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();

        JsonPath jsonPath = new JsonPath(response);
        List<String> listOfZipCodes = jsonPath.getList("address.zipcode");
        for (String zipCode : listOfZipCodes) {
            System.out.println(zipCode);
        }
    }
    @Test
    public void printZipCodesWithoutDash(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();

        JsonPath jsonPath = new JsonPath(response);
        List<String> listOfZipCodes = jsonPath.getList("address.zipcode");
        for (String zipCode : listOfZipCodes) {
            String zipCodeWithoutDash = zipCode.replaceAll("-", "");
            System.out.println(zipCodeWithoutDash);
        }
    }
    @Test
    public void latAndLng (){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();

        JsonPath jsonPath = new JsonPath(response);
        List<String> listOfNames = jsonPath.getList("name");
        List<String> listOfLats = jsonPath.getList("address.geo.lat");
        List<String> listOfLngs = jsonPath.getList("address.geo.lng");

        for (int i = 0; i < listOfNames.size(); i++) {
            String name = listOfNames.get(i);
            String lat = listOfLats.get(i);
            String lng = listOfLngs.get(i);
            System.out.println(name + " is situated at: " + " lat = " + lat + " and lng = " + lng);
        }
    }

    @Test
    public void latAndLngNegative (){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();

        JsonPath jsonPath = new JsonPath(response);
        List<String> listOfNames = jsonPath.getList("name");
        List<Double> listOfLats = jsonPath.getList("address.geo.lat", Double.class);
        List<Double> listOfLngs = jsonPath.getList("address.geo.lng", Double.class);

        for (int i = 0; i < listOfNames.size(); i++) {
            double lat = listOfLats.get(i);
            double lng = listOfLngs.get(i);
            if(lat < 0 && lng < 0){
            String name = listOfNames.get(i);
            System.out.println(name + " lat = " + lat + " lng = " + lng);
        }
        }
    }
    @Test
    public void website (){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();

        JsonPath jsonPath = new JsonPath(response);
        List<String> listOfNames = jsonPath.getList("name");
        List<String> listOfWebsites = jsonPath.getList("website");

        for (int i = 0; i < listOfNames.size(); i++) {
            String website = listOfWebsites.get(i);
            if(website.contains(".info")){
            String name = listOfNames.get(i);
            System.out.println(name + " - " + website);
        }
        }
    }
    @Test
    public void lngMax (){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();

        JsonPath jsonPath = new JsonPath(response);
        List<String> listOfNames = jsonPath.getList("name");
        List<Double> listOfLngs = jsonPath.getList("address.geo.lng", Double.class);
        double maxLng = 0;
        String name = null;

        for (int i = 0; i < listOfNames.size(); i++) {
            double lng = listOfLngs.get(i);
            if(lng > maxLng){
                maxLng = lng;
                name = listOfNames.get(i);
            }
        }
        System.out.println(name + " is a user with a max lng ");
    }
    @Test
    public void longestCatchPhrase (){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().get("/users").asString();

        JsonPath jsonPath = new JsonPath(response);
        List<String> listOfNames = jsonPath.getList("name");
        List<String> listOfCatchPhrases = jsonPath.getList("company.catchPhrase");
        int longestCatchPhrase = 0;
        String name = null;

        for (int i = 0; i < listOfNames.size(); i++) {
            String catchPhrase = listOfCatchPhrases.get(i);
            if(catchPhrase.length() > longestCatchPhrase){
                longestCatchPhrase = catchPhrase.length();
                name = listOfNames.get(i);
            }
        }
        System.out.println(name + " is a user with a longest catchPhrase ");
    }
}
