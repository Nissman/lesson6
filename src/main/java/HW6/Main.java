package HW6;

import okhttp3.*;

import java.io.IOException;

public class Main {
/*
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";
    private static final String SPB = "474212_PC";
    private static final String API_Key = "6LRnMnuEibVsqrAEhXx8Yqlkpc4cuRgq";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(SPB)
                .addQueryParameter("apikey", API_Key)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();
        Request requestHttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();
        String jsonResponse = client.newCall(requestHttp).execute().body().string();
        System.out.println(jsonResponse);
    }

 */

    private static final String BASE_HOST = "api.weather.yandex.ru";
    private static final String API_VERSION = "v2";
    private static final String FORECAST = "forecast";
    private static final String LAT = "59.9386"; //широта
    private static final String LON = "30.3141"; //долгота
    private static final String LANG = "ru_RU"; //язык ответа
    private static final String LIMIT = "7"; // cрок прогноза
    private static final String HOURS = "false"; //наличие почасового прогноза
    private static final String EXTRA = "true";//Расширенная информация об осадках.
    private static final String X_Yandex_API_Key = "f39ae217-b644-4331-bc7a-183c6c5b7216";

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(BASE_HOST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST)
                .addQueryParameter("lat", LAT)
                .addQueryParameter("lom", LON)
                .addQueryParameter("lang", LANG)
                .addQueryParameter("limit", LIMIT)
                .addQueryParameter("hours", HOURS)
                .addQueryParameter("extra", EXTRA)
                .build();
        System.out.println(url.toString());
        Request requestHTTPs = new Request.Builder()
                .addHeader("X-Yandex-API-Key", X_Yandex_API_Key)
                .url(url)
                .build();
        System.out.println(requestHTTPs);
        Response jsonResponse = client.newCall(requestHTTPs).execute();
        System.out.println(jsonResponse.body().string());
        System.out.println(jsonResponse.code());
        System.out.println(jsonResponse.headers());
    }
}
