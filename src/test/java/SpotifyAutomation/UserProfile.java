package SpotifyAutomation;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserProfile {
    String token = "BQB0p8lMfdW1V2fyYT8Y8YyPuoIsUkogJvbmKYfyIwkcRRfnHqAi5KxWANa9pQyJS_nSlEOPb7MfUa0JL7Dyo_4W0c2x2ayGKCLXuASXJz2-EbL7uvyiw_x7bbaCC0BpjTgvUy30erGtdKwl5oPdvCTRWuO99ZQgoqcRmHt_4XLgFylg7MMTSGxTsOFXnJuaYZobIg-LlbdzTHCUo-DXlywtMH0miJRIcjdAXvWZtc8YY9yqbHw8SjhSWHd3GOurXl__jFxVM7_BolxPzYVjKD3c47dARo8MeWY3HSfQOXK51YB9aJGFwWU-HKM45hHpMNVqHWjhXtkX";
    @Test
    public void getUser() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/users/312jqdjelnjctt7ckomd3bzbopla");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void Get_User_Profile() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/users/312jqdjelnjctt7ckomd3bzbopla");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void Get_User_Top_Items() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/top/artists");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
//        String msg = res.path("message");
//        Assert.assertEquals(200, msg);
    }

    @Test
    public void follow_playlist() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"public\": false\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/0dZLrIFFLo2KAVEUHWXSgr/followers");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
//        String msg = res.path("message");
//        System.out.println(msg);
//        res.then().statusCode(200);
    }

    @Test
    public void Get_Followed_Artists() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/me/following");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void Check_If_User_Follows_Artists_or_Users() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .pathParam("type", "artist")
//                .pathParam("ids","2CIMQHirSU0MQqyYHq0eOx,57dN52uHvrHOxijzpIgu3E,1vCWHaC5f2uS3yhpwWbIA6")
                .when()
                .get("https://api.spotify.com/v1/me/following/contains");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void Unfollow_Playlist() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .delete("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
}
