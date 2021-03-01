declare module 'react-native-phpfox-config' {
  import {ColorValue, ImageStyle, TextStyle} from "react-native";

  interface ThemeConfigs {
    splashScreenBackgroundColor?: ColorValue;
    primaryColor?: ColorValue;
    grayBaseColor?: ColorValue;
    welcomeText?: TextStyle;
    welcomeImage?: ImageStyle;
  }

  interface BuildConfigs {

  }

  interface UserConfigs {
    themeName?: string;
    layoutDirection?: string;
  }

  interface ConfigValues {
    // App config from android/configuration.json or ios/configuration.json when build
    appName: string;
    bundleId: string;
    clientId: string;
    versionName: string;
    clientSecret: string;
    serverApiUrl: string;
    pingServerUrl: string;
    isMultiSiteApp: boolean;
    versionBuildNumber: string;
    firebaseEnabledAnalytic: boolean;
    //
    enableLog: boolean;
    enableAudio: boolean;
    enableLiveStream: boolean;
    enableRocketChat: boolean;
    enableInAppPurchase: boolean;
    //
    theme: ThemeConfigs;
    // Build config: Some information automatically generated when building app
    buildConfig?: BuildConfigs;
    // User config local storage when user save settings to local device
    userConfig?: UserConfigs;
  }

  export const Configs: ConfigValues;
  export function saveUserConfig(key: keyof UserConfigs, value: string) : void;
}
