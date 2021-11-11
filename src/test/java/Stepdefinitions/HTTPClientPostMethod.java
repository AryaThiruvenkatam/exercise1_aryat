package Stepdefinitions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static util.ConfigReader.geturl;


public class HTTPClientPostMethod {

    String csvFile= "D:\\Users\\KarT\\Documents\\Arya\\Exercise1_aryat\\src\\main\\resources\\TestData\\SampleCSV.csv";

    @Then("Create Post method")
    public void postMethod() throws InterruptedException, IOException, CsvValidationException {
        String name1="";
        String salary1="";
        String age1="";


            CSVReader reader = new CSVReader(new FileReader(csvFile));
            String[] cell;
            while((cell=reader.readNext())!=null)
            {
                for(int i=0;i<1;i++){
                    name1= cell[i];
                    salary1 = cell[i+1];
                    age1 = cell[i+2];
                }

            }
            String bodyEmp="{\"name\":\""+name1+"\",\"salary\":\""+salary1+"\",\"age\":\""+age1+"\"}";

        //create a client
        CloseableHttpClient client = HttpClients.createDefault();

        System.out.println(geturl());
        //create a request
        HttpPost request1 = new HttpPost(geturl());


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
