package com.example.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/getUpdatetime")
	  public String getUpdatetime() throws Exception{
		String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
		 InputStream is = new URL(url).openStream();
		 BufferedReader rd = new BufferedReader(new InputStreamReader(is,"utf-8")); 
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        JSONObject json = new JSONObject(sb.toString());
        String updataTime = ((JSONObject)json.get("time")).getString("updated");
        return updataTime;
	  }
	
	
	@RequestMapping("/getCurrency")
	  public String getCurrency() throws Exception{
		String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
		 InputStream is = new URL(url).openStream();
		 BufferedReader rd = new BufferedReader(new InputStreamReader(is,"utf-8")); 
      StringBuilder sb = new StringBuilder();
      int cp;
      while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
      }
      JSONObject json = new JSONObject(sb.toString());
      JSONObject bpi = (JSONObject)json.get("bpi");
      return bpi.toString();
	  }

}
