package com.vault.donotgetwet.model.remote;

/**
 * Created by Vault on 19.12.2017.
 */

public class ForecastClient {
    private static final String BASE_URL = "https://api.darksky.net/forecast/";
    private static final String API_KEY = "c12e8ceecd0b1459344c0579064cf103";

    private static double latitude = 37.8267;
    private static double longitude = -122.4233;
    private static final String FORECAST_URL = BASE_URL + API_KEY + "/" + latitude + "/" + longitude;


}
