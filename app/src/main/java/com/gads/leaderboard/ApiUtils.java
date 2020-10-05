package com.gads.leaderboard;

public class ApiUtils {
    private ApiUtils() {}

    public static final String BASE_URL = "https://docs.google.com/forms/d/e/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
