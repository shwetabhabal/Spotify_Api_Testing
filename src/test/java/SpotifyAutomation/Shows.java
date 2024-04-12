package SpotifyAutomation;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Shows {
    String token = "BQBWlSdNK9wbSI6BSZCjK8IJc9ANCs1fGwJEfUtJwl3RJHTpJvno6-SLCBDNkBG0v-GubpqzgPARHVAreflU_8MSkRkkoO-s9G9M05EWTmLBj_h8vufzJBVhGDVsP0ygAZqrwU9RKQ5yjep9Y4g75XMS5EAzl7G9AUuxJtezWo_OnkamvvGlglqAnxXufHlaY6DO-8VcrsDYI9jzx18PX-OGSR_DdBjFsLqcoWf3M5luaLzRfaiil97yk8K2dQcUXxkgmPDAS08lsdRW9EPlaqrqYev1bfTF5NuFYTm5UQZILEDDjg3Z8_Z6jbLfhVM";

    @Test
    public void Get_Show(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Several_Shows(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .queryParam("ids","5CfCWKI5pZ28U0uOzXkDHe,5as3aKmN2k11yfDDDSrvaZ")
                .when()
                .get("https://api.spotify.com/v1/shows");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Shows_Episodes(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ/episodes");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Get_Users_Saved_Shows(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .when()
                .get("https://api.spotify.com/v1/me/shows");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Save_Shows_for_Current_User(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .queryParam("ids","5CfCWKI5pZ28U0uOzXkDHe,5as3aKmN2k11yfDDDSrvaZ")
                .when()
                .put("https://api.spotify.com/v1/me/shows");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Check_Users_Saved_Shows(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .queryParam("ids","5CfCWKI5pZ28U0uOzXkDHe,5as3aKmN2k11yfDDDSrvaZ")
                .when()
                .get("https://api.spotify.com/v1/me/shows");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }
    @Test
    public void Remove_Users_Saved_Shows(){
        Response res = given()
                .header("Authorization", "Bearer "+token)
                .queryParam("ids","5CfCWKI5pZ28U0uOzXkDHe,5as3aKmN2k11yfDDDSrvaZ")
                .when()
                .delete("https://api.spotify.com/v1/me/shows");
        res.prettyPrint();
        res.then().assertThat().statusCode(200);
    }

}
