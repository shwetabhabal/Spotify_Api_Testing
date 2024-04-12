package SpotifyAutomation;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class Albums {
    String token = "BQB0p8lMfdW1V2fyYT8Y8YyPuoIsUkogJvbmKYfyIwkcRRfnHqAi5KxWANa9pQyJS_nSlEOPb7MfUa0JL7Dyo_4W0c2x2ayGKCLXuASXJz2-EbL7uvyiw_x7bbaCC0BpjTgvUy30erGtdKwl5oPdvCTRWuO99ZQgoqcRmHt_4XLgFylg7MMTSGxTsOFXnJuaYZobIg-LlbdzTHCUo-DXlywtMH0miJRIcjdAXvWZtc8YY9yqbHw8SjhSWHd3GOurXl__jFxVM7_BolxPzYVjKD3c47dARo8MeWY3HSfQOXK51YB9aJGFwWU-HKM45hHpMNVqHWjhXtkX";

    @Test
    public void Get_Album(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Several_Album(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .queryParam("ids", "382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc")
                .when()
                .get("https://api.spotify.com/v1/albums");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Album_Tracks(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .queryParam("ids", "382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc")
                .when()
                .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_User_Saved_Albums(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/albums");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Save_Albums_for_Current_User() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc")
                .when()
                .get("https://api.spotify.com/v1/me/albums");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Remove_Users_Saved_Albums() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc")
                .when()
                .get("https://api.spotify.com/v1/me/albums");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Check_Users_Saved_Albums() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .queryParam("ids", "382ObEPsp2rxGrnsizN5TX,1A2GTWGtFfWp7KSQTwWOyo,2noRn2Aes5aoNVsU6iWThc")
                .when()
                .get("https://api.spotify.com/v1/me/albums/contains");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
}
