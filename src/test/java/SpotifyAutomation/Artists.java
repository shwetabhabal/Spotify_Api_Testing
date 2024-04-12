package SpotifyAutomation;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Artists {
    String token = "BQB0p8lMfdW1V2fyYT8Y8YyPuoIsUkogJvbmKYfyIwkcRRfnHqAi5KxWANa9pQyJS_nSlEOPb7MfUa0JL7Dyo_4W0c2x2ayGKCLXuASXJz2-EbL7uvyiw_x7bbaCC0BpjTgvUy30erGtdKwl5oPdvCTRWuO99ZQgoqcRmHt_4XLgFylg7MMTSGxTsOFXnJuaYZobIg-LlbdzTHCUo-DXlywtMH0miJRIcjdAXvWZtc8YY9yqbHw8SjhSWHd3GOurXl__jFxVM7_BolxPzYVjKD3c47dARo8MeWY3HSfQOXK51YB9aJGFwWU-HKM45hHpMNVqHWjhXtkX";

    @Test
    public void getArtist(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void getSeveralArtist(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .queryParam("ids", "2CIMQHirSU0MQqyYHq0eOx")
                .when()
                .get("https://api.spotify.com/v1/artists");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Artists_Albums(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/albums");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Artists_Top_Tracks(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Artists_Related_Artists(){
        Response res = given()
                .header("Authorization","Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
}
