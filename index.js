import { NativeModules } from 'react-native'

export const { RNPhpfoxConfig } = NativeModules

const getServerApiUrlFromServerApiUrl = (serverUrl) => {
  return (serverUrl.replace(/([/]+$)/g, '') + '/index.php/restful_api/').replace(
    'index.php/index.php', 'index.php')
}

export const ThemeValues: {
  primaryColor: String,
  grayBaseColor: String,
}  =  Object.assign({
  primaryColor: "#2681D5",
  grayBaseColor: "#111111",
}, RNPhpfoxConfig.themeValues)

export const CommonValues: {
  testAccount: {
    email: String,
    password: String,
    enabledAnalytic: Boolean,
    isMultiSiteApp: Boolean,
    initialRouteStack: String,
    initialRouteName: String,
    initialRouteParams: Object,
    homePageNotLoggedIn: String,
    serverApiUrl: String,
  }
} = Object.assign({
  testAccount: {
    email: '',
    password: ''
  },
  enabledAnalytic: true,
  isMultiSiteApp: false,
  initialRouteStack: 'homeStack',
  initialRouteName: 'home',
  initialRouteParams: {},
  homePageNotLoggedIn: 'login',
  serverApiUrl: getServerApiUrlFromServerApiUrl(RNPhpfoxConfig.commonValues.serverUrl)

}, RNPhpfoxConfig.commonValues)

export default RNPhpfoxConfig
