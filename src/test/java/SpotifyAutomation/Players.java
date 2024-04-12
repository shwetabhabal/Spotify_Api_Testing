package SpotifyAutomation;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class Players {
    String token = "BQB0p8lMfdW1V2fyYT8Y8YyPuoIsUkogJvbmKYfyIwkcRRfnHqAi5KxWANa9pQyJS_nSlEOPb7MfUa0JL7Dyo_4W0c2x2ayGKCLXuASXJz2-EbL7uvyiw_x7bbaCC0BpjTgvUy30erGtdKwl5oPdvCTRWuO99ZQgoqcRmHt_4XLgFylg7MMTSGxTsOFXnJuaYZobIg-LlbdzTHCUo-DXlywtMH0miJRIcjdAXvWZtc8YY9yqbHw8SjhSWHd3GOurXl__jFxVM7_BolxPzYVjKD3c47dARo8MeWY3HSfQOXK51YB9aJGFwWU-HKM45hHpMNVqHWjhXtkX";
    @Test
    public void Get_Playback_State(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/player");
        res.prettyPrint();
        res.then().assertThat().statusCode(204);
    }
    @Test
    public void Transfer_Playback(){
        Response res = given()
                .header("Content-Type","application/json")
                .header("Authorization", "Bearer "+token)
                .queryParam("device_ids","74ASZWbe4lXaubB36ztrGX")
                .when()
                .put("https://api.spotify.com/v1/me/player");
        res.prettyPrint();
//        res.then().assertThat().statusCode(204);
    }

}
