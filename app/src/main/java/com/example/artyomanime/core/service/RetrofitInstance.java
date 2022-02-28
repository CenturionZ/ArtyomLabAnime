package com.example.artyomanime.core.service;

import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Инстанс клиента Retrofit
 * Создает HTTP-клиент и клиент Retrofit
 */

public class RetrofitInstance {

    /** Объект клиента */
    public APIService retrofitAPI = null;

    /** Корневая ссылка API */
    private final static String BASE_URL = "https://animechan.vercel.app/api/";


    public RetrofitInstance() {
        if (retrofitAPI == null) {
            retrofitAPI = CreateRetrofitClient().create(APIService.class);
        }
    }

    /** Создает и возвращает HTTP-клиент с логированием
     * Необходим для клиента Retrofit
     * @return возвращает объект httpOk, HTTP-клиент с логированием
     */
    private OkHttpClient createOkHttpClient() {
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);

        return httpClient.build();
    }

    /** Создает и возвращает Retrofit-клиент без end-points
      * @return возвращает пустой Retrofit-клиент
     */
    private Retrofit CreateRetrofitClient(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(createOkHttpClient())
                .build();
    }

}
