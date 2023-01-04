import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.when;

public class WheatherGET {

    // Status code 200
    // Simple GET request
    @Test
    public void test01(){
        Response resp = when()
                .get("https://api.openweathermap.org/data/2.5/weather?q=London&appid=35e9324cfee175658d734e36de47048b");
        System.out.println("Here is my API response for correct GET call--"+resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(),200);
    }

    //Status code 401
    // Incorrect API key
    @Test
    public void test02(){
        Response resp = when()
                .get("https://api.openweathermap.org/data/2.5/weather?q=London&appid=35e9324cfee175658d734e36de47048ba");
        System.out.println("Here is my API response for Incorrect API key---"+resp.getStatusCode());
        Assert.assertEquals(resp.getStatusCode(),401);
    }
}
