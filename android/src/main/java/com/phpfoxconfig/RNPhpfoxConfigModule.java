
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
        int resId = context.getResources().getIdentifier(resourceName, "string", context.getPackageName());
        String result = null;
        try {
            result = context.getString(resId);
        } catch (Resources.NotFoundException e) {
            //
        }
        return result;
    }

    public void addToConstants(HashMap<String, Object> constants, Context context, String resourceName) {
        String value = this.getResourceStringValue(context, resourceName);
        constants.put(resourceName, value);

    }

    @Override
    public @Nullable
    Map<String, Object> getConstants() {
        HashMap<String, Object> constants = new HashMap<String, Object>();
        Context context = getReactApplicationContext();

        this.addToConstants(constants, context, "PHPFOX_SERVER_URL");
        this.addToConstants(constants, context, "PHPFOX_API_CLIENT_ID");
        this.addToConstants(constants, context, "PHPFOX_API_CLIENT_SECRET");

        return constants;
    }
}