
#import "RNPhpfoxConfig.h"

@implementation RNPhpfoxConfig

RCT_EXPORT_MODULE()

+ (BOOL)requiresMainQueueSetup
{
    return NO;
}

- (NSDictionary *)constantsToExport {
    NSDictionary *infoPlistDict = [[NSBundle mainBundle] infoDictionary];
    
    NSDictionary * commonValues = @{
             @"serverUrl": infoPlistDict[@"phpFoxServerUrl"],
             @"clientId": infoPlistDict[@"phpFoxApiClientId"],
             @"clientSecret": infoPlistDict[@"phpFoxApiClientSecret"],
             @"enabledAnalytic": @true,
             // route
             @"initialRouteStack": @"homeStack",
             @"initialRouteName": @"home",
             @"initialRouteParams": @{},
             @"homePageNotLoggedIn":@"login"
             };
    
    NSDictionary * themeValues =  @{
                                    @"primaryColor": infoPlistDict[@"themePrimaryColor"],
                                    @"grayBaseColor": infoPlistDict[@"themeGrayBaseColor"],
                                    };
    
    return @{
             @"commonValues": commonValues,
             @"themeValues": themeValues,
             };
}
@end
  
