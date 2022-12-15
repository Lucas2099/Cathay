package com.example.unit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.demo.DemoApplication;
import com.example.imodel.ICurrency;
import com.example.model.Currency;

import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext*.xml", "classpath:spring-servlet.xml"}) 
@SpringBootTest(classes = {DemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestTable {
	
	@Autowired
    private ICurrency currency;
	
	@Before
    public void setUp() throws Exception{
        // 刪除所有資料
		currency.deleteAll();
		
		String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
		 InputStream is = new URL(url).openStream();
		 BufferedReader rd = new BufferedReader(new InputStreamReader(is,"utf-8")); 
		 StringBuilder sb = new StringBuilder();
		 int cp;
		 while ((cp = rd.read()) != -1) {
			 sb.append((char) cp);
		 }
	      
       JSONObject json = new JSONObject(sb.toString());
       JSONObject bpiObject = json.getJSONObject("bpi");
       
       Iterator<String> countrys = bpiObject.keys();
       while(countrys.hasNext()) {
           String country = countrys.next();
           if (bpiObject.get(country) instanceof JSONObject) {
                 
        	   JSONObject data = (JSONObject)bpiObject.get(country);
               Iterator<String> datas = data.keys();
               while(datas.hasNext()) {
            	   currency.save(new Currency(data.getString("code"),
            			   data.getString("symbol"),
            			   data.getString("rate") , 
            			   data.getString("description") , 
            			   data.getDouble("rate_float") ));
               }
               
           }
       }
       
    }
	

	@org.junit.Test
	    public void test() throws Exception {
	        
	    }

}
