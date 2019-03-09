
#import "RNPhpfoxConfig.h"

@implementation RNPhpfoxConfig

RCT_EXPORT_MODULE()

+ (BOOL)requiresMainQueueSetup
{
    return NO;
}


- (NSDictionary *)constantsToExport {
    //get file name

    [[NSBundle mainBundle] bundlePath];

    NSString *fileName = [[NSBundle mainBundle] pathForResource:@"Config"
                                                         ofType:@"json"];
    NSDictionary *result = @{};
    //check file exists
    if (fileName) {
        //retrieve file content
        NSData *partyData = [[NSData alloc] initWithContentsOfFile:fileName];

        //convert JSON NSData to a usable NSDictionary
        NSError *error;
        result = [NSJSONSerialization JSONObjectWithData:partyData
                                                               options:0
                                                                 error:&error];
        if (error) {
            NSLog(@"Something went wrong! %@", error.localizedDescription);
        }
    } else {
        NSLog(@"Config.json file could not be found");
    }

    return @{@"configVariable": result};
}
@end

