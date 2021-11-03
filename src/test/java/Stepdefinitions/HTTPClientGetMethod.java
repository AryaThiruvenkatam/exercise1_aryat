package Stepdefinitions;

import io.cucumber.java.en.Then;
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

public class HTTPClientGetMethod {


    @Then("Create Get method")
    public void getMethod() throws Exception{

        //create a client
        CloseableHttpClient client = HttpClients.createDefault();

        //create a request
        HttpGet request = new HttpGet("http://dummy.restapiexample.com/api/v1/employees");

        //adding header
        request.addHeader("Content-Type","application/json");

        //execute command
        CloseableHttpResponse response = client.execute(request);

        //asserting the response
        int code=response.getStatusLine().getStatusCode();
        System.out.println("Response code is"+code);
        Assert.assertEquals(code,200);

        String responseString = EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(responseString);


    }
}