package SpotifyAutomation;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class Episodes {
    String token = "BQB0p8lMfdW1V2fyYT8Y8YyPuoIsUkogJvbmKYfyIwkcRRfnHqAi5KxWANa9pQyJS_nSlEOPb7MfUa0JL7Dyo_4W0c2x2ayGKCLXuASXJz2-EbL7uvyiw_x7bbaCC0BpjTgvUy30erGtdKwl5oPdvCTRWuO99ZQgoqcRmHt_4XLgFylg7MMTSGxTsOFXnJuaYZobIg-LlbdzTHCUo-DXlywtMH0miJRIcjdAXvWZtc8YY9yqbHw8SjhSWHd3GOurXl__jFxVM7_BolxPzYVjKD3c47dARo8MeWY3HSfQOXK51YB9aJGFwWU-HKM45hHpMNVqHWjhXtkX";
   @Test
    public void Get_Episode(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Save_Episodes_for_Current_User(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .header("Content-Type","application/json")
                .queryParam("ids", "77o6BIVlYM3msb4MMIL1jH,0Q86acNRm6V9GYx55SXKwf")
                .when()
                .put("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Check_Users_Saved_Episodes(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .queryParam("ids", "77o6BIVlYM3msb4MMIL1jH,0Q86acNRm6V9GYx55SXKwf")
                .when()
                .get("https://api.spotify.com/v1/me/episodes/contains");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Remove_Users_Saved_Episodes(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .header("Content-Type","application/json")
                .queryParam("ids", "77o6BIVlYM3msb4MMIL1jH,0Q86acNRm6V9GYx55SXKwf")
                .when()
                .delete("https://api.spotify.com/v1/me/episodes/contains");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

}
