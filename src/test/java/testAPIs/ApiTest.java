package testAPIs;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ApiTest {

    @Test
    public void testApiGetRequest() {

        //Realiza un Get a la direccion referenciada, y verifica que contenga el mail michael.lawson@reqres.in

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200, "El código de respuesta no es 200");

        assertTrue(response.getBody().asString().contains("michael.lawson@reqres.in"));

        response.prettyPrint();
    }

    @Test
    public void testPostRequest() {

        //Realiza un Post a la direccion referenciada, y verifica que la respuesta sea un 201

        String requestPayload = "{\"name\": \"morpheus\", \"job\": \"leader\"}";

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestPayload)
                .post("https://reqres.in/api/users");

        // Verificar el código de respuesta
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 201, "El código de respuesta no es 201");

        response.prettyPrint();
    }

    @Test
    public void testGetRequestMercadoLibre() {

        //Realiza un Get a la direccion referenciada, y verifica que el array contenga departamentos

        Response response = RestAssured.get("https://www.mercadolibre.com.ar/menu/departments");

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200, "El código de respuesta no es 200");

        JsonPath jsonPath = response.jsonPath();

        // Verifica que el array "departments" no esté vacío
        assertTrue(jsonPath.getList("departments").size() > 0, "El array 'departments' está vacío");

        response.prettyPrint();
    }
}
