package com.onoh.ewallet02.model.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {



//    public static final String SP_NAMA = "spNama";
//    public static final String SP_EMAIL = "spEmail";

    public static final String SP_LOGIN_APP = "spLoginApp";
    public static final String SP_ID = "spId";
    public static final String SP_TOKEN = "spToken";
    public static final String SP_ID_SPJ = "spIdSPJ";

    public static final String SP_SUDAH_LOGIN = "spSudahLogin";
    SharedPreferences sp;
    SharedPreferences.Editor spEditor;


    public SharedPrefManager(Context context){
        sp = context.getSharedPreferences(SP_LOGIN_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }



    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public Integer getUserId(){
        return sp.getInt(SP_ID,0 );
    }

    public String getToken(){
        return sp.getString(SP_TOKEN, "");
    }

    public Boolean getSPSudahLogin(){
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }



}