package com.onoh.ewallet02.apihelper;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BaseApiService {
    // Fungsi ini untuk memanggil API localhost/api/login
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> loginRequest(@Field("email") String email,
                                    @Field("password") String password);


    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> postRegister(@Field("nama") String nama,
                                    @Field("email") String email,
                                    @Field("nomor_telepon") String nomor_telepon,
                                    @Field("password") String pin,
                                    @Field("password_confirmation") String pin_confirmation);
}
