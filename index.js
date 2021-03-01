import { NativeModules } from 'react-native'

const originConfigs = NativeModules.RNPhpfoxConfig.values

const getServerApiUrlFromServerApiUrl = serverUrl => {
  return (serverUrl.replace(/([/]+$)/g, '') + '/index.php/restful_api/')
  .replace('index.php/index.php', 'index.php')
}

export const Configs = Object.assign(
  {},
  originConfigs,
  {
    privateInfo: {},
    googleServiceInfo: {}
  }
)

Configs.serverApiUrl = getServerApiUrlFromServerApiUrl(Configs.serverUrl)

export const saveUserConfig = NativeModules.RNPhpfoxConfig.saveUserConfig
