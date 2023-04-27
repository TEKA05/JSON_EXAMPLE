package com.universal_yazilim.json.city_app.model.dal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.universal_yazilim.json.city_app.utility.Util;
import com.universal_yazilim.json.city_app.model.entity.City;

public final class CityLoader 
{
	
	private static final String URL = "https://bit.ly/3J18Rwi";
		
	private CityLoader() {}
	
	/**
	 * 
	 * @return
	 * 		"Parse" edilen JSON sayfasýndaki (URL'de) þehir listesi
	 *  	 bir hata meydana gelirse, boþ liste
	 */
	public static List<City> load()
	{
		List<City> cityList = new ArrayList<City>();
		
			try
			{
				// *****1
				ObjectMapper objectMapper = new ObjectMapper(); 
				
				
				// *****5 request (istek) oluþturuldu.
				HttpGet request = new HttpGet(URL);
				
				
				// *****4 client (istemci) oluþturuldu.
				DefaultHttpClient client = new DefaultHttpClient(); 
				
				
				// *****3 response üretimi için, client(istemci) nesnesi üzerinden 
				// request'in (isteðin) çalýþtýrýlmasý gerekir.
				HttpResponse response = client.execute(request);
				
				
				// *****2 Burada liste üretilir.
				// Bunun için, request üzerinden üretilen response'a ihtiyaç vardýr. (1.param için)
				cityList = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<List<City>>() {
				}); 
			
			}
			
			catch (JsonMappingException e) 
			{
				Util.showGeneralExceptionInfo(e);
			}
			catch (ClientProtocolException e)
			{
				Util.showGeneralExceptionInfo(e);
			}
			catch (IOException e)
			{
				Util.showGeneralExceptionInfo(e);
			}	
															  
			return cityList;
		}
	
}
