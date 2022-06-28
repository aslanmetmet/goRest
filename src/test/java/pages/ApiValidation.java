package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static io.restassured.RestAssured.given;

import java.nio.file.Paths;

public class ApiValidation {

    public Response response;

    public Response postMehtod(String name, String gender, String email, String status) {

        String requestBody = updateBody(name, gender, email, status);

        Response response = given()
                .headers("Authorization", "Bearer d8538c07c7408dee3510e4d4af76b844d4d52c20f7d6fa8200b3392236d08f67",
                        "Content-Type", "application/json", "Accept", ContentType.JSON)
                .body(requestBody)
                .post();

        return response;
    }


    private String updateBody(String name, String gender, String email, String status) {
        String body = "";
        try {
            body = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "src/test/resources/data/userDetail.json")));
            body = body.replaceAll("replaceName", name);
            body = body.replaceAll("replaceGender", gender);
            body = body.replaceAll("replaceEmail", email);
            body = body.replaceAll("replaceStatus", status);

        } catch (IOException e) {
            e.printStackTrace();

        }
        return body;
    }

}
