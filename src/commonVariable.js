import { configVariable } from './configVariable'

type CommonVariable = {
  testAccount: {
    email: String,
    password: String,
  }
}

const getServerApiUrlFromServerApiUrl = (serverUrl) => {
  return (serverUrl.replace(/([/]+$)/g, '') + '/index.php/restful_api/').replace(
    'index.php/index.php', 'index.php')
}

const validateIsMultiSiteApp = () => {
  if (configVariable.common.isMultiSiteApp === undefined) {
    return configVariable.common.serverUrl.startsWith('https://mobileapi.phpfox.com')
  }
  return configVariable.common.isMultiSiteApp
}

export const commonVariable: CommonVariable = Object.assign({
  testAccount: {
    email: '',
    password: ''
  },
  enabledAnalytic: true,
  isMultiSiteApp: validateIsMultiSiteApp(),
  initialRouteStack: 'homeStack',
  initialRouteName: 'home',
  initialRouteParams: {},
  homePageNotLoggedIn: 'login',
  serverApiUrl: getServerApiUrlFromServerApiUrl(configVariable.commonVariable.serverUrl)

}, configVariable.commonVariable)
