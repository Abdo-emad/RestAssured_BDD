import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

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




}
