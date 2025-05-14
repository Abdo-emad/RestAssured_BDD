package API;

import java.util.ResourceBundle;
import java.util.logging.Logger;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseClass {
    public  String baseUri;
    public BaseClass(String baseUri){
        this.baseUri=baseUri;

    }
    public Response getRequest(String basePath){

        Logger logger = Logger.getLogger(String.valueOf(BaseClass.class));
        logger.info("Sending Get Request"+ baseUri );

        return given().when().get(basePath);
    }
    public Response PostRequest(String basePath , String payload){
        Response response = given().contentType("application/json").body(payload).when().post(basePath);
        return response;
    }


}
