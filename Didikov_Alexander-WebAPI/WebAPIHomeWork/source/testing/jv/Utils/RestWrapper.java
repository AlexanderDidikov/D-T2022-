package Utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.config.EncoderConfig.encoderConfig;

public class RestWrapper {
    private static final String BASE_URL = "https://api.dropboxapi.com";
    private static final String TOKEN = "6WGn4ci8zBsAAAAAAAAAAYXFG5VSvLZJ94K10oTgv6uyZF_NyPz33Et8I9q4rxPV";
    public static RequestSpecification REQ_SPEC = new RequestSpecBuilder()
            .setConfig(RestAssured.config()
                    .encoderConfig(encoderConfig()
                            .appendDefaultContentCharsetToContentTypeIfUndefined(false)))
            .setBaseUri(BASE_URL)
            .setBasePath("/2/files")
            .setAuth(RestAssured.oauth2(TOKEN))
            .build();
}
