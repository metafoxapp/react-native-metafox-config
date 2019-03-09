
package com.phpfoxconfig;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.InputStream;

import com.google.gson.stream.JsonReader;
import com.google.gson.Gson;


import javax.annotation.Nullable;

public class RNPhpfoxConfigModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    private static String TAG = "RNPhpfoxConfig";

    public RNPhpfoxConfigModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNPhpfoxConfig";
    }

    public Map<String, Object> loadJSONFromAsset(String fileName, Context context) {
        String jsonString = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        Gson gson = new Gson();

        Map<String, Object> map = new HashMap<String, Object>();
        return (Map<String, Object>) gson.fromJson(jsonString, map.getClass());
    }


    @Override
    public Map<String, Object> getConstants() {

        HashMap<String, Object> constants = new HashMap<String, Object>();
        Context context = getReactApplicationContext();

        constants.put("values", loadJSONFromAsset("configuration.json", context));

        return constants;
    }
}
