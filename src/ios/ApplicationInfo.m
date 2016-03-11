//
//  ApplicationInfo.m
//  Octane
//
//  Created by Erin Parrill on 4/19/13.
//
//

#import "ApplicationInfo.h"

@implementation ApplicationInfo

- (void)getBuildVersion:(CDVInvokedUrlCommand*)command {
    // Get the main bundle for the app.
    NSDictionary* infoDict = [[NSBundle mainBundle] infoDictionary];
    
    // Get version string
    NSString* ver = [infoDict objectForKey:@"CFBundleVersion"];
    
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:ver];
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}


@end
