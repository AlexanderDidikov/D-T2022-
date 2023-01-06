package StepDefinitions;

import Pojos.DeleteRequest;
import Pojos.GetMetaDataRequest;
import Pojos.UploadRequest;
import Utils.RestWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.File;

public class TestDropboxAPISteps {
    RequestSpecification requestSpecification = RestWrapper.REQ_SPEC;
    File file = new File("src/test/resources/ACDC.jpg");
    int statusCode;
    RequestSpecification request;

    @Given("set request specification")
    public void setRequestSpecification() {
        request = RestAssured.given(requestSpecification);
    }

    //Upload steps

    @When("set header Dropbox-API-Arg")
    public void setHeaderDropboxAPIArg() {
        UploadRequest upl = UploadRequest.builder().path("/Logo.jpg").autorename(true).build();
        request.header("Dropbox-API-Arg", upl);
    }

    @And("header param request content type is application\\/octet-stream")
    public void headerParamRequestContentTypeIsApplicationOctetStream() {
        request.header("Content-Type", "application/octet-stream");
    }

    @And("set request body params for uploading")
    public void setRequestBodyParamsForUploading() {
        request.body(file);
    }

    @And("send upload POST request")
    public void sendUploadPOSTRequest() {
        Response resp = request.post("/upload");
        statusCode = resp.getStatusCode();
        System.out.println(statusCode);
        System.out.println(resp.getBody().asPrettyString());
    }

    @Then("received response code {int}")
    public void receivedResponseCode(int responseCode) {
        Assert.assertEquals(responseCode, statusCode);
    }

    //Get metadata steps

    @When("header param request content type is application\\/json")
    public void headerParamRequestContentTypeIsApplicationJson() {
        request.header("Content-Type", "application/json");
    }

    @And("set request body params for getting metadata")
    public void setRequestBodyParamsForGettingMetadata() {
        GetMetaDataRequest getMetaDataRequest = GetMetaDataRequest.builder().path("/Logo.jpg").build();
        request.body(getMetaDataRequest);
    }

    @And("send getMetadata POST request")
    public void sendGetMetadataPOSTRequest() {
        Response response = request.post("/get_metadata");
        statusCode = response.getStatusCode();
        System.out.println(statusCode);
        System.out.println(response.getBody().asPrettyString());
    }

    //Delete steps

    @And("set request body params for deleting file")
    public void setRequestBodyParamsForDeletingFile() {
        DeleteRequest deleteRequest = DeleteRequest.builder().path("/Logo.jpg").build();
        request.body(deleteRequest);
    }

    @And("send delete POST request")
    public void sendDeletePOSTRequest() {
        Response resp = request.post("/delete_v2");
        statusCode = resp.getStatusCode();
        System.out.println(statusCode);
        System.out.println(resp.getBody().asPrettyString());
    }
}
