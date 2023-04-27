package com.universal_yazilim.json.city_app.program;

import java.util.List;

import com.universal_yazilim.json.city_app.model.dal.CityLoader;
import com.universal_yazilim.json.city_app.model.entity.City;
import com.universal_yazilim.json.city_app.utility.Util;

public class Main
{

	public static void main(String[] args) 
	{
		List<City> cities = CityLoader.load();
		
		Util.showList(cities);
	}

}
