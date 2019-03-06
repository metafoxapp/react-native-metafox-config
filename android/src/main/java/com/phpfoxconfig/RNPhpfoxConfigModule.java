
package com.phpfoxconfig;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import java.util.HashMap;
import java.util.Map;


import javax.annotation.Nullable;

public class RNPhpfoxConfigModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNPhpfoxConfigModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNPhpfoxConfig";
    }

    public String getResourceStringValue(Context context, String resourceName) {
        String result = "";
        try {
            int resId = context.getResources().getIdentifier(resourceName, "string", context.getPackageName());
            result = context.getString(resId);
        } catch (Resources.NotFoundException e) {
            result = "Not found exception";
        }
        return result;
    }

    public void addToConstants(HashMap<String, Object> constants, Context context, String keyName, String resourceName) {
        String value = this.getResourceStringValue(context, resourceName);
        constants.put(keyName, value);
    }

    @Override
    public Map<String, Object> getConstants() {
        HashMap<String, Object> constants = new HashMap<String, Object>();
        Context context = getReactApplicationContext();

        this.addToConstants(constants, context, "phpFoxServerUrl","PHPFOX_SERVER_URL");
        this.addToConstants(constants, context, "phpFoxApiClientId","PHPFOX_API_CLIENT_ID");
        this.addToConstants(constants, context, "phpFoxApiClientSecret","PHPFOX_API_CLIENT_SECRET");

//        constants.put("phpFoxServerUrl", "https://product-qc.younetco.com/mobile");
        return constants;
    }
}