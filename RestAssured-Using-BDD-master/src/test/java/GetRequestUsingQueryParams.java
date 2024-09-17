import groovy.transform.ASTTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class GetRequestUsingQueryParams {
    public static void main(String[] args) {
        Response response = RestAssured.given().baseUri("https://reqres.in").basePath("/api/users").queryParam("page","2").when().get();
        response.prettyPrint();
        response.then().statusCode(200);
        response.then().body("data[0].first_name", Matchers.equalTo("Michael"));

    }
@Test
    public void Test1(){
    Response response = RestAssured.given().log().all().
            baseUri("https://reqres.in").basePath("/api/users").queryParam("page","2").when().get();
    response.prettyPrint();
    response.then().log().all().statusCode(200);
}
}
