declare module "react-native-phpfox-config" {
  import { ColorValue, ImageStyle, TextStyle } from "react-native";

  interface ThemeConfigs {
    splashScreenBackgroundColor?: ColorValue;
    primaryColor?: ColorValue;
    grayBaseColor?: ColorValue;
    welcomeText?: TextStyle;
    welcomeImage?: ImageStyle;
  }

  interface BuildConfigs {}

  interface UserConfigs {
    themeName?: string;
    layoutDirection?: string;
  }
  interface MuxInfo {
    client_id?: string;
    client_secret?: string;
  }

  interface PusherInfo {
    key?: string;
    secret?: string;
    app_id?: string;
    options?: {
      cluster?: string;
      host?: string;
      port?: number;
      scheme?: string;
      encrypted?: boolean;
      useTLS?: boolean;
    };
    driver?: string;
  }

  interface ConfigValues {
    // App config from android/configuration.json or ios/configuration.json when build
    appName: string;
    bundleId: string;
    shareExtensionId: string;
    groupId: string;
    merchantId: string;
    clientId: string;
    clientSecret: string;
    versionName: string;
    serverApiUrl: string;
    pingServerUrl: string;
    isMultiSiteApp: boolean;
    versionBuildNumber: string;
    firebaseEnabledAnalytic: boolean;
    themeVariant: string;

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
    muxInfo?: MuxInfo;
    pusherInfo?: PusherInfo;
  }

  export const Configs: ConfigValues;
  export function saveUserConfig(key: keyof UserConfigs, value: string): void;
}
