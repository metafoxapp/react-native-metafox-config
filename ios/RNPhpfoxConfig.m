
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

    // User Config plist
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *documentsDirectory = [paths objectAtIndex:0];
    NSString *path = [documentsDirectory stringByAppendingPathComponent:@"UserConfig.plist"];
    NSFileManager *fileManager = [NSFileManager defaultManager];

    //check file exists
    //retrieve file content
    NSData *infoData = [[NSData alloc] initWithContentsOfFile:configurationFileName];

    if (![fileManager fileExistsAtPath: path]) {
        path = [documentsDirectory stringByAppendingPathComponent: [NSString stringWithFormat:@"UserConfig.plist"] ];
    }

    NSMutableDictionary *userConfig;

    if ([fileManager fileExistsAtPath: path]) {
        userConfig = [[NSMutableDictionary alloc] initWithContentsOfFile: path];
    }else {
        userConfig = [[NSMutableDictionary alloc] init];
    }

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

    [result setValue:userConfig
                forKey:@"userConfig"];

    [result setValue:@{}
              forKey:@"privateInfo"];

    return @{@"values": result};
}

RCT_EXPORT_METHOD(saveUserConfig:(NSString *)key value:(NSString *)value) {
    //Get the documents directory path
    NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
    NSString *documentsDirectory = [paths objectAtIndex:0];
    NSString *path = [documentsDirectory stringByAppendingPathComponent:@"UserConfig.plist"];
    NSFileManager *fileManager = [NSFileManager defaultManager];

    if (![fileManager fileExistsAtPath: path]) {
        path = [documentsDirectory stringByAppendingPathComponent: [NSString stringWithFormat:@"UserConfig.plist"] ];
    }

    NSMutableDictionary *data;

    if ([fileManager fileExistsAtPath: path]) {
        data = [[NSMutableDictionary alloc] initWithContentsOfFile: path];
    }
    else {
        // If the file does not exist, create an empty dictionary
        data = [[NSMutableDictionary alloc] init];
    }

    //To insert the data into the plist
    [data setObject:value forKey:key];
    [data writeToFile:path atomically:YES];
}

@end

