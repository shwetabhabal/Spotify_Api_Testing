package SpotifyAutomation;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class Tracks {
    String token = "BQBO1BmCXsTPr4hMjGsa_L7Z_UTLOEJo4mf0w444eQGtHgqUvfj7JkqT5nCEYYeDjePbZZbCU8Tzx7pIXldcM-kPRFPYMcRk8W9pjV4y2YJa5FTweQWjMeGvaKv1UuJimsmaJ0AoBextl0x6EfUHoikw458MvmxRz5FlilvyfLhzCKGNBTsPPamLUJ8bf4SX2njni-0m18X50Ib6ZFz2DNyIlLIRrf6YvZ7zK28MUFTZ5pWNxZStKWV6uqzv6sMXf0JBib0guljIait1dtKl3x8LClUs6oZ00GiJwd6axm1MrafWoJ7Osg";
    @Test
    public void Save_Tracks_for_Current_User(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .body("{\n" +
                        "    \"ids\": [\n" +
                        "        \"7ouMYWpwJ422jRcDASZB7P\"\n" +
                        "    ]\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/me/tracks");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Track(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Users_Saved_Tracks(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/tracks");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Check_Users_Saved_Tracks(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .queryParam("ids", "7ouMYWpwJ422jRcDASZB7P,4VqPOruhp5EdPBeR92t6lQ,2takcwOaAZWiXQijPHIx7B")
                .when()
                .get("https://api.spotify.com/v1/me/tracks/contains");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Several_Tracks_Audio_Features(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .queryParam("ids", "7ouMYWpwJ422jRcDASZB7P,4VqPOruhp5EdPBeR92t6lQ,2takcwOaAZWiXQijPHIx7B")
                .when()
                .get("https://api.spotify.com/v1/audio-features");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Several_Audio_Features(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .queryParam("ids", "11dFghVXANMlKmJXsNCbNl")
                .when()
                .get("https://api.spotify.com/v1/audio-features");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }



}
