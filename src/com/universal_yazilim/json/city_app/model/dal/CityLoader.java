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
	 * 		"Parse" edilen JSON sayfas�ndaki (URL'de) �ehir listesi
	 *  	 bir hata meydana gelirse, bo� liste
	 */
	public static List<City> load()
	{
		List<City> cityList = new ArrayList<City>();
		
			try
			{
				// *****1
				ObjectMapper objectMapper = new ObjectMapper(); 
				
				
				// *****5 request (istek) olu�turuldu.
				HttpGet request = new HttpGet(URL);
				
				
				// *****4 client (istemci) olu�turuldu.
				DefaultHttpClient client = new DefaultHttpClient(); 
				
				
				// *****3 response �retimi i�in, client(istemci) nesnesi �zerinden 
				// request'in (iste�in) �al��t�r�lmas� gerekir.
				HttpResponse response = client.execute(request);
				
				
				// *****2 Burada liste �retilir.
				// Bunun i�in, request �zerinden �retilen response'a ihtiya� vard�r. (1.param i�in)
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
