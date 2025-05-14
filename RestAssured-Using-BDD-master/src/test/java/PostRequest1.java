import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PostRequest1 {
    public static void main(String[] args) {
        Response response = RestAssured.given().
                baseUri("https://reqres.in").basePath("/api/users").body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}").header("Content-Type","application/json").when().post();
                        response.prettyPrint();
                        response.then().statusCode(201);
                        response.then().body("name", Matchers.equalTo("morpheus"));
    }

    @Test
    public void postRequest(){
        Response response = RestAssured.given().log().all().
                baseUri("https://reqres.in").basePath("/api/users").body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}").header("Content-Type","application/json").when().post().then().extract().response();
        //Extract response body
        System.out.println(response.asString());
        //Extract specific body attributes use path
        String name = response.path("data[0].name");
        System.out.println(name);

        //Extract response body

        JsonPath jsonPath = new JsonPath(response.asString());
        String name = jsonPath.getString("data[0].name");
        //Extract response body new way
       String name= JsonPath.from(response.asString()).getString("data[0].name");

        System.out.println(name);
    }




}
