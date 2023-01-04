import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class HowToUserParameterRest {

    //user rest assured parameter
    @Test
    public void test03(){
        Response resp = given()
                .param("q","London")
                .param("appid","35e9324cfee175658d734e36de47048b")
                .when()
                .get("https://api.openweathermap.org/data/2.5/weather");
        System.out.println("Here is my API response for correct GET call--"+resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(),200);
        if (resp.getStatusCode()==200){
            System.out.println("API is working good");
        }
        else {
            System.out.println("There is something wrong with our API");
        }
    }

    // rest assured print all responses as string
    @Test
    public void test04() {
        Response resp = given()
                .param("q", "London")
                .param("appid", "35e9324cfee175658d734e36de47048b")
                .when()
                .get("https://api.openweathermap.org/data/2.5/weather");
        System.out.println("Here is my API response for correct GET call--" + resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(), 200);
        System.out.println(resp.asString());
    }

    // rest assured API GET Call with the city id
    @Test
    public void test05() {
        Response resp = given()
                .param("id", "2172797")
                .param("appid", "35e9324cfee175658d734e36de47048b")
                .when()
                .get("https://api.openweathermap.org/data/2.5/weather");
        System.out.println("here is the api call using city ID--" + resp.getStatusCode());
        Assert.assertEquals( resp.getStatusCode(), 200);
    }

    // rest assured API GET Call with the ZIP code
    @Test
    public void test06() {
        Response resp = given()
                .param("zip", "201010,us")
                .param("appid", "35e9324cfee175658d734e36de47048b")
                .when()
                .get("https://api.openweathermap.org/data/2.5/weather");
        System.out.println("here is the api call using ZIP code--" + resp.getStatusCode());
        Assert.assertEquals( resp.getStatusCode(), 200);
    }

    // Testing Git
}
