package com.onoh.ewallet01.apihelper;

public class UtilsApi {
    public static final String BASE_URL_API = "http://localhost:8000/api/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
