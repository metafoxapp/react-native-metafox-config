
#import "RNPhpfoxConfig.h"

@implementation RNPhpfoxConfig

RCT_EXPORT_MODULE()

+ (BOOL)requiresMainQueueSetup
{
    return NO;
}

- (NSDictionary *)constantsToExport {
    NSDictionary *infoPlistDict = [[NSBundle mainBundle] infoDictionary];
    return @{
             @"phpFoxServerUrl": infoPlistDict[@"phpFoxServerUrl"],
             @"phpFoxApiClientId": infoPlistDict[@"phpFoxApiClientId"],
             @"phpFoxApiClientSecret": infoPlistDict[@"phpFoxApiClientSecret"]
             };
}
@end
  
