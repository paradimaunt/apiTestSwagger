import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import java.io.File;
import org.junit.jupiter.api.Test;

public class PetClass {

    @Test
    public void uploadPetImageFile() {
        File file = new File("/Users/Dmytro_Murza/Desktop/dog.jpg");
        String endpoint = "https://petstore.swagger.io/v2/pet/1632387445/uploadImage";
        String body = """
                 {
                "petId":"1632387445",
                 "additionalMetadata": "Hello"
                 }""";
        var response = given().body(body).multiPart("file", file, "multipart/form-data")
                .post(endpoint).thenReturn().then().statusCode(200);
        response.log().body();
    }

    @Test
    public void addNewPetToTheStory() {
        String endpoint = "https://petstore.swagger.io/v2/pet";
        String body = """
                {
                "id": "54647",
                  "category": {
                    "id": "0",
                    "name": "string"
                  },
                  "name": "Duggy",
                  "photoUrls": [
                    "string"
                  ],
                  "tags": [
                    {
                      "id": "0",
                      "name": "string"
                    }
                  ],
                  "status": "available"
                }""";
        var response = given().contentType("application/json").body(body).post(endpoint).then()
                .statusCode(200);

        response.log().body();
    }

    @Test
    public void updatePet() {
        String endpoint = "https://petstore.swagger.io/v2/pet";
        String body = """
                {
                "id": 54647,
                "category": {
                "id": 0,
                "name": "string"
                },
                "name": "Tort",
                "photoUrls": [
                "string"
                ],
                "tags": [
                {
                "id": 0,
                "name": "string"
                }
                ],
                "status": "available"
                }""";
        var response = given().contentType("application/json").body(body).put(endpoint).then();
        response.log().body();
    }

    @Test
    public void getAvailableStatus() {
        String endpoint = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";
        var response = given().when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void getPendingStatus() {
        String endpoint = "https://petstore.swagger.io/v2/pet/findByStatus?status=pending";
        var response = given().when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void getSoldStatus() {
        String endpoint = "https://petstore.swagger.io/v2/pet/findByStatus?status=sold";
        var response = given().when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void getIdOfPet() {
        String endpoint = "https://petstore.swagger.io/v2/pet/54647";
        var response = given().when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void updatePetStatus() {
        String endpoint = "https://petstore.swagger.io/v2/pet/54647";
        String body =
                """
                        {
                        "id": 54647,
                        "category": {
                        "id": 0,
                        "name": "string"
                        },
                        "name": "Tort",
                        "photoUrls": [
                        "string"
                        ],
                        "tags": [
                        {
                        "id": 0,
                        "name": "string"
                        }
                        ],
                        "status": "sold"          
                        }
                        """;
        var response = given().contentType("application/x-www-form-urlencoded").body(body).post(endpoint).then();
        response.log().body();
    }

    @Test
    public void deletePet() {
        String endpoint = "https://petstore.swagger.io/v2/pet/54647";
        String body = """
                {
                "id":54647,
                }
                """;
        var response = given().contentType("application/json").body(body).when().delete(endpoint)
                .then();
        response.log().body();
    }
}
