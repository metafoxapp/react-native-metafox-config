
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

    public Map<String, Object> getCommonValues(Context context) {

        HashMap<String, Object> values = new HashMap<String, Object>();
        HashMap<String, Object> initialRouteParams = new HashMap<String, Object>();

        this.addToConstants(values, context, "serverUrl", "PHPFOX_SERVER_URL");
        this.addToConstants(values, context, "clientId", "PHPFOX_API_CLIENT_ID");
        this.addToConstants(values, context, "clientSecret", "PHPFOX_API_CLIENT_SECRET");

        values.put("enabledAnalytic", true);

        values.put("initialRouteName", "home");
        values.put("homePageNotLoggedIn", "login");
        values.put("initialRouteParams", initialRouteParams);

        return values;
    }

    public Map<String, Object> getThemeValues(Context context) {

        HashMap<String, Object> values = new HashMap<String, Object>();

        this.addToConstants(values, context, "grayBaseColor", "THEME_GRAY_BASE_COLOR");
        this.addToConstants(values, context, "primaryColor", "THEME_PRIMARY_COLOR");

        return values;
    }


    @Override
    public Map<String, Object> getConstants() {

        HashMap<String, Object> constants = new HashMap<String, Object>();

        Context context = getReactApplicationContext();

        constants.put("commonValues", getCommonValues(context));
        constants.put("themeValues", getThemeValues(context));

        return constants;
    }
}
