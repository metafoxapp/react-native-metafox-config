import { NativeModules } from 'react-native'

const { RNPhpfoxConfig } = NativeModules

///////////////////////////////////////////////////////////////////////////
//
// GLOBAL CONFIGURE
// WHENEVER YOU ADD NEW MODULES, re-run $> yarn code:generate-bulk-import to
//
///////////////////////////////////////////////////////////////////////////

export const Configs = {

  // test account
  testAccount: {
    email: '',
    password: ''
  },

  enabledAnalytic: true,
  isMultiSiteApp: true, // toggle this value to disable change site address

  // client id config
  clientId: RNPhpfoxConfig.phpFoxApiClientId, // client id
  clientSecret: RNPhpfoxConfig.phpFoxApiClientSecret, // secret key

  // server end point config
  serverUrl: RNPhpfoxConfig.phpFoxServerUrl,

  //home page config, visit ./modules/core/routes.js
  initialRouteStack: 'homeStack', // homeStack, friendStack,messageStack, notificationStack, menuStack
  initialRouteName: 'home',
  initialRouteParams: {},
  homePageNotLoggedIn: 'login',

  ///////////////////////////////////////////////////////////////////////////
  //
  // DOES NOT CONFIGURE FOLLOWING LINES
  //
  ///////////////////////////////////////////////////////////////////////////

  // cloud message config
  persistKey: 'root',
  persistVersion: 412,

  ///////////////////////////////////////////////////////////////////////////
  //
  // GETTER METHOD DATA
  //
  ///////////////////////////////////////////////////////////////////////////
  get serverApiUrl () {
    return (this.serverUrl.replace(/([/]+$)/g, '') +
      '/index.php/restful_api/').replace('index.php/index.php', 'index.php')
  },
  version: 412,
  compatibleStoreVersion: '0.10',
  requestTimeout: 30e3 // 30 seconds
}

export default RNPhpfoxConfig
