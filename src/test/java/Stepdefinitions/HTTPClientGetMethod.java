package Stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.reporters.XMLConstants;
import java.io.Closeable;
import java.io.IOException;

import static util.ConfigReader.geturl;
import static util.ConfigReader.geturl1;

public class HTTPClientGetMethod {

    CloseableHttpClient client;
    HttpGet request;
    CloseableHttpResponse response;

    @Then("create the client")
    public void createClient() throws Exception {

        //create a client
        client = HttpClients.createDefault();
    }

    @Then("Hit the url1 with the get request")
    public void Hit_URL() throws Exception {

        //create a request
        request = new HttpGet(geturl1());

        //adding header
        request.addHeader("Content-Type","application/json");

        //execute command
        response = client.execute(request);

    }

    @Then("validate and print the response")
    public void Print_response() throws Exception {


       /* //asserting the response
        int code=response.getStatusLine().getStatusCode();
        System.out.println("Response code is"+code);
        Assert.assertEquals(code,200);*/

        String responseString = EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(responseString);

    }
}

