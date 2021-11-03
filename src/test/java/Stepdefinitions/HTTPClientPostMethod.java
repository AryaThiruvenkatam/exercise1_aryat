package Stepdefinitions;

import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.reporters.XMLConstants;
import java.io.Closeable;

public class HTTPClientPostMethod {
    @Then("Create Post method")
    public void postMethod() throws Exception{


        String bodyEmp ="{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\", \"name\":\"arya\",\"salary\":\"234\",\"age\":\"89\",\"name\":\"a2\",\"salary\":\"345\",\"age\":\"12\"" +
                "\"name\":\"a3\",\"salary\":\"5788\",\"age\":\"23\"\"name\":\"a4\",\"salary\":\"346547\",\"age\":\"44\"\"name\":\"a5\",\"salary\":\"356\",\"age\":\"35\"" +
                "\"name\":\"a6\",\"salary\":\"2345\",\"age\":\"34\"" +
                "\"name\":\"a7\",\"salary\":\"1425\",\"age\":\"54\"\"name\":\"a8\",\"salary\":\"476990\",\"age\":\"34\"" +
                "\"name\":\"a9\",\"salary\":\"45666\",\"age\":\"22\",\"name\":\"a10\",\"salary\":\"35667\",\"age\":\"44\"}";

        //create a client
        CloseableHttpClient client = HttpClients.createDefault();

        //create a request
        HttpPost request1 = new HttpPost("http://dummy.restapiexample.com/api/v1/create");

        //adding header and employee detail
        request1.addHeader("Content-Type","application/json");
        request1.setEntity(new StringEntity(bodyEmp));

        //execute command and storing response
        CloseableHttpResponse response1 = client.execute(request1);

           /* //asserting the response
            int code=response1.getStatusLine().getStatusCode();
            System.out.println("Response code for post is"+code);
            Assert.assertEquals(code,200);*/

        String responseString = EntityUtils.toString(response1.getEntity());
        System.out.println(responseString);
    }
}
