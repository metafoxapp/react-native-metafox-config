
package com.phpfoxconfig;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.content.SharedPreferences;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.InputStream;

import com.google.gson.stream.JsonReader;
import com.google.gson.Gson;


import javax.annotation.Nullable;

public class RNPhpfoxConfigModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    private static String FILE_NAME =  "configuration.jsbundle";

    private static String TAG = "RNPhpfoxConfig";

    private static String PREFERENCE_NAME = "USER_CONFIG";

    private SharedPreferences mSharedPreferences;

    public RNPhpfoxConfigModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        this.mSharedPreferences = reactContext.getSharedPreferences(PREFERENCE_NAME, reactContext.MODE_PRIVATE);
    }

    @Override
    public String getName() {
        return "RNPhpfoxConfig";
    }

    public Map<String, Object> loadJSONFromAsset(String fileName, Context context) {
        String jsonString = "{}";
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Gson gson = new Gson();

        Map<String, Object> map = new HashMap<String, Object>();
        return (Map<String, Object>) gson.fromJson(jsonString, map.getClass());
    }


    @Override
    public Map<String, Object> getConstants() {

        HashMap<String, Object> constants = new HashMap<String, Object>();
        Context context = getReactApplicationContext();

        Map<String, Object> map = loadJSONFromAsset(FILE_NAME, context);
        Map<String, ?> userConfigData = this.mSharedPreferences.getAll();

        map.put("userConfig", userConfigData);
        constants.put("values", map);

        return constants;
    }

    @ReactMethod
    public void saveUserConfig(String key, String value) {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        editor.putString(key, (String) value).commit();
    }
}
