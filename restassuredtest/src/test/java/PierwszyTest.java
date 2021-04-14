import groovy.util.logging.Slf4j;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static com.sun.deploy.trace.Trace.println;
import static io.restassured.RestAssured.given;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.hamcrest.Matchers.*;


/*@Test
    public void pierszytest(){
        given().contentType(ContentType.JSON).when().get("http://www.wp.pl").then().statusCode(400);
        given().when().get(host2).print();
        given().when().get(host1).print();
           given().contentType(ContentType.JSON).when()
                .get(host3).then()
                .assertThat().body("region",containsString("alif"));
                 given().contentType(ContentType.JSON).when()
                .get(host3).then()
                .assertThat().body("region", equalTo("California"));
                  given().contentType(ContentType.JSON).when()
                .get(host3).then().assertThat()
                .body("region", containsStringIgnoringCase("california"));



    }*/

@Slf4j
public class PierwszyTest {
    public String host1 = "http://ergast.com/api/f1/2017/circuits.json";
    public String host2 = "https://postman-echo.com/get?foo1=bar1&foo2=bar2";
    public String host3 = "https://ipinfo.io/8.8.8.8";
    public String clientid = "72e2da95954d320";
    public String imgurtoken = "7f67af828b89637dabd4568d062b02631a16891d";
    public String imgururl = "https://api.imgur.com/3/";

    /*@Test
    public void imgurTest(){
        //given().auth().oauth2
       // given().post("https://api.imgur.com/oauth2/authorize?client_id=" + clientid + "&response_type=token&state=APPLICATION_STATE").print(); // coś takiego nam nie przejdzie

    given().auth().oauth2(imgurtoken).contentType(ContentType.JSON).accept(ContentType.JSON).when().get(imgururl + "account/me/images").print();

         given().auth().oauth2(imgurtoken).contentType(ContentType.JSON).accept(ContentType.JSON).when().get(imgururl + "account/me/settings").print();
      //  given().auth().oauth2(imgurtoken).contentType(ContentType.JSON).accept(ContentType.JSON).when().get(imgururl + "account/me/settings").then().body("email", containsStringIgnoringCase("dropo3dd@gmail.com"));
        // musi byc drzewo po kolei dlatego dajemy latwo printem obczaic ze glowną 'galezia jest data kropkujemy i potem podglaz


    }*/
    @Test
    public void imgurTestv2(){
        given().auth().oauth2(imgurtoken).contentType(ContentType.JSON).accept(ContentType.JSON).when().get(imgururl + "account/me/settings").print();
        given().auth().oauth2(imgurtoken).contentType(ContentType.JSON).accept(ContentType.JSON).when().get(imgururl + "account/me/settings").then().body("email", containsStringIgnoringCase("dropo3dd@gmail.com"));
        // musi byc drzewo po kolei dlatego dajemy latwo printem obczaic ze glowną 'galezia jest data kropkujemy i potem podglaz
        given().auth().oauth2(imgurtoken).contentType(ContentType.JSON).accept(ContentType.JSON).when().get(imgururl + "account/me/settings").then().body("data.email", containsStringIgnoringCase("dropo3dd@gmail.com"));
        given().auth().oauth2(imgurtoken).contentType(ContentType.JSON).accept(ContentType.JSON).when().get(imgururl + "account/me/settings").then().body("data.email", containsStringIgnoringCase("dropo3dd@gmail.com"));

    }

    @Test
    public void imgurTestv3(){
        String id = "8yAXAmD";
        String com = "Brak smaku życia :D:(";

        given().auth().oauth2(imgurtoken).contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().post(imgururl + "comment"+"?"+"image_id=" + id +
                //"&" +
                "comment=" + com).print();

    }

    @Test
    public void imgurTestv4(){
        Integer commentid = 1979329875;
        given().auth().oauth2(imgurtoken).contentType(ContentType.JSON).accept(ContentType.JSON)
                .when().delete(imgururl + "/image/8yAXAmD/comment/" + commentid.toString());
        given().auth().oauth2(imgurtoken).contentType(ContentType.JSON).accept(ContentType.JSON)
                //.when().delete(imgururl + "/comment?ID="+ commentid.toString()).print();
                .when().delete(imgururl + "/image/8yAXAmD/comment/" + commentid.toString()).print();
    }
}
