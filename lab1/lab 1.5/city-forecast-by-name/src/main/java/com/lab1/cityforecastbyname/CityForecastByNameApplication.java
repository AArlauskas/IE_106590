package com.lab1.cityforecastbyname;

import com.lab1.ipmaapiclient.services.IpmaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.NoSuchElementException;

@SpringBootApplication
public class CityForecastByNameApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityForecastByNameApplication.class, args);
        IpmaService ipmaService = new IpmaService();
        try
        {
            String cityname = args[0];
            if(cityname == null)
            {
                throw new IllegalArgumentException();
            }
            String temperature = ipmaService.getLocationMaxTemperature(cityname);
            System.out.println("Maximum temperature will be " + temperature);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Provided argument is not valid");
        }
        catch (NoSuchElementException e)
        {
            System.out.println("City not found.");
        }
    }

}
