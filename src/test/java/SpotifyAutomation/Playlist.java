package SpotifyAutomation;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Playlist {
    String token = "BQB0p8lMfdW1V2fyYT8Y8YyPuoIsUkogJvbmKYfyIwkcRRfnHqAi5KxWANa9pQyJS_nSlEOPb7MfUa0JL7Dyo_4W0c2x2ayGKCLXuASXJz2-EbL7uvyiw_x7bbaCC0BpjTgvUy30erGtdKwl5oPdvCTRWuO99ZQgoqcRmHt_4XLgFylg7MMTSGxTsOFXnJuaYZobIg-LlbdzTHCUo-DXlywtMH0miJRIcjdAXvWZtc8YY9yqbHw8SjhSWHd3GOurXl__jFxVM7_BolxPzYVjKD3c47dARo8MeWY3HSfQOXK51YB9aJGFwWU-HKM45hHpMNVqHWjhXtkX";
    @Test
    public void create_playlist() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"name\": \"shweta_playlist\"\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/312jqdjelnjctt7ckomd3bzbopla/playlists");
        res.prettyPrint();
        res.then().assertThat().statusCode(201);
    }

    @Test
    public void Get_Playlist() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void change_playlist() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .when()
                .post("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void Get_Playlist_Items() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

    @Test
    public void Update_Playlist_Items() {
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .body("{\n" +
                        "    \"range_start\": 1,\n" +
                        "    \"insert_before\": 3,\n" +
                        "    \"range_length\": 2\n" +
                        "}")
                .when()
                .put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Add_Items_to_Playlist(){
        Response res = given()
                .header("Authorization", "Bearer " + token)
                .body("{\"uris\": [\"spotify:track:4iV5W9uYEdYUVa79Axb7Rh\",\n" +
                        "        \"spotify:track:1301WleyT98MSxVHPZCA6M\", \n" +
                        "        \"spotify:episode:512ojhOuo1ktJprKbVcKyQ\"\n" +
                        "        ]\n" +
                        "        }")
                .when()
                .post("https://api.spotify.com/v1/playlists/0dZLrIFFLo2KAVEUHWXSgr/tracks");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Remove_Playlist(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .body("{\n" +
                        "    \"tracks\": [\n" +
                        "        {\n" +
                        "            \"uri\": \"spotify:track:1301WleyT98MSxVHPZCA6M\"\n" +
                        "        }\n" +
                        "    ],\n" +
                        "    \"snapshot_id\": \"MywzNzE5NTRmNzBhNjA3N2U4NDY4NmEzNWQxOWEwMmVmYTg2ZDNmOTQ4\"\n" +
                        "}")
                .when()
                .delete("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Current_User_Playlists(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/playlists");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_User_Playlists(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/users/312jqdjelnjctt7ckomd3bzbopla/playlists");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Featured_Playlists(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/browse/featured-playlists");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Playlist_Cover_Image(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/images");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

}
