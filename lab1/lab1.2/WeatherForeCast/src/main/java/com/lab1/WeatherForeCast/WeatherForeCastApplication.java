package com.lab1.WeatherForeCast;

import com.lab1.WeatherForeCast.models.IpmaCityForeCast;
import com.lab1.WeatherForeCast.services.IpmaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.logging.Logger;

@SpringBootApplication
public class WeatherForeCastApplication {
	private static final int CITY_ID_AVEIRO = 1010500;
	private static final Logger logger = Logger.getLogger(WeatherForeCastApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(WeatherForeCastApplication.class, args);
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://api.ipma.pt/open-data/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		IpmaService service = retrofit.create(IpmaService.class);
		Call<IpmaCityForeCast> callSync = service.getForecastForACity(CITY_ID_AVEIRO);

		try {
			Response<IpmaCityForeCast> apiResponse = callSync.execute();
			IpmaCityForeCast forecast = apiResponse.body();

			if (forecast != null) {
				logger.info( "max temp for today: " + forecast.getData().
						listIterator().next().getTMax());
			} else {
				logger.info( "No results!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
