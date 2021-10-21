package com.lab1.ipmaapiclient.services;

import com.lab1.ipmaapiclient.models.ForecastResponse;
import com.lab1.ipmaapiclient.models.Location;
import com.lab1.ipmaapiclient.models.LocationsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class IpmaService {
    private String getLocationIdByName(String name)
    {
        RestTemplate restTemplate = new RestTemplate();
        LocationsResponse locations = restTemplate.getForObject("https://api.ipma.pt/open-data/distrits-islands.json", LocationsResponse.class);
        Location location = locations.data.stream().filter(l -> l.local.equalsIgnoreCase(name)).findFirst().get();
        return location.globalIdLocal;
    }

    public String getLocationMaxTemperature(String name)
    {
        String id = getLocationIdByName(name);
        RestTemplate restTemplate = new RestTemplate();
        String url = new StringBuilder().append("http://api.ipma.pt/open-data/forecast/meteorology/cities/daily/").append(id).append(".json").toString();
        ForecastResponse forecastResponse = restTemplate.getForObject(url, ForecastResponse.class);
        return forecastResponse.data.get(0).tMax;
    }
}
