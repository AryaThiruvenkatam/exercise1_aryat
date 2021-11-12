package Stepdefinitions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.en.Then;
import io.restassured.internal.util.IOUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static util.ConfigReader.geturl;


public class HTTPClientPostMethod {

    String csvFile = "D:\\Users\\KarT\\Documents\\Arya\\Exercise1_aryat\\src\\main\\resources\\TestData\\SampleCSV.csv";


    HttpPost request1;
    //create a client
    CloseableHttpClient client = HttpClients.createDefault();

    @Then("Hit the url2 with the post request")
    public void Hit_URL2() throws InterruptedException, IOException, CsvValidationException {


        //create a request
        request1 = new HttpPost(geturl());
    }


    @Then("Pass the employee record to be added using post request")
    public void Employee_Add() throws InterruptedException, IOException, CsvValidationException {
        String file = "D:\\Users\\KarT\\Documents\\Arya\\Exercise1_aryat\\src\\main\\resources\\TestData\\sample.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));
        System.out.println(json);


        //adding header and employee detail
        request1.addHeader("Content-Type", "application/json");
        request1.setEntity(new StringEntity(json));

        //execute command and storing response
        CloseableHttpResponse response1 = client.execute(request1);

      /*  //asserting the response
            int code=response1.getStatusLine().getStatusCode();
            System.out.println("Response code for post is"+code);
            Assert.assertEquals(code,200);*/

        String responseString = EntityUtils.toString(response1.getEntity());
        System.out.println(responseString);

    }


}
