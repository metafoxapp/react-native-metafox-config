
#import "RNPhpfoxConfig.h"

@implementation RNPhpfoxConfig

RCT_EXPORT_MODULE()

+ (BOOL)requiresMainQueueSetup
{
    return NO;
}


- (NSDictionary *)constantsToExport {
    //get file name

    NSString *configurationFileName = [[NSBundle mainBundle] pathForResource:@"configuration"
                                                                      ofType:@"json"];
    
    NSString *googleServiceInfoFileName = [[NSBundle mainBundle] pathForResource:@"GoogleService-Info"
                                                                          ofType:@"plist"];
    
    NSDictionary *googleServiceInfoDict = [NSDictionary dictionaryWithContentsOfFile:googleServiceInfoFileName];
    
    //check file exists
    //retrieve file content
    NSData *infoData = [[NSData alloc] initWithContentsOfFile:configurationFileName];
    
    //convert JSON NSData to a usable NSDictionary
    NSError *error;
    NSMutableDictionary *result = [NSJSONSerialization JSONObjectWithData:infoData
                                                                  options:NSJSONReadingMutableContainers
                                                                    error:&error];
    if (error) {
        NSLog(@"Something went wrong! %@", error.localizedDescription);
    }

    [result setValue:googleServiceInfoDict
              forKey:@"googleServiceInfo"];
    
    [result setValue:@{}
              forKey:@"privateInfo"];
    
    return @{@"values": result};
}
@end

