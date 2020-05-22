package com.onoh.ewallet02.apihelper;


import com.onoh.ewallet02.model.response.User;
import com.onoh.ewallet02.model.response.UserResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BaseApiService {
    // Fungsi ini untuk memanggil API localhost/api/login
    @FormUrlEncoded
    @POST("login")
    Call<UserResponse> postLogin(@Field("nomor_telepon") String nomor_telepon,
                                    @Field("password") String password);


    @FormUrlEncoded
    @POST("register")
    Call<UserResponse> postRegister(@Field("nama") String nama,
                            @Field("email") String email,
                            @Field("nomor_telepon") String nomor_telepon,
                            @Field("password") String pin,
                            @Field("password_confirmation") String pin_confirmation);

    @FormUrlEncoded
    @POST("cek_nomor")
    Call<UserResponse> post_check_mumber(@Field("nomor_telepon") String nomor_telepon);


    @FormUrlEncoded
    @POST("send_otp")
    Call<UserResponse> postOtp(@Field("nomor_telepon") String nomor_telepon);

    @FormUrlEncoded
    @POST("verifikasi_otp")
    Call<UserResponse> validateOtp(@Field("id_otp") int id_otp,
                                   @Field("kode_otp") String kode_otp);
}
