const originConfigs = require('react-native').NativeModules.RNPhpfoxConfig.values

export const Configs = Object.assign({}, originConfigs, {privateInfo: {}})

const getServerApiUrlFromServerApiUrl = (serverUrl) => {
  return (serverUrl.replace(/([/]+$)/g, '') + '/index.php/restful_api/').replace(
    'index.php/index.php', 'index.php')
}

Configs.serverApiUrl = getServerApiUrlFromServerApiUrl(Configs.serverUrl)
