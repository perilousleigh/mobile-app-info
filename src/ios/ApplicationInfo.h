//
//  ApplicationInfo.h
//  Octane
//
//  Created by Erin Parrill on 4/19/13.
//
//

#import "Foundation/Foundation.h"
#import "Cordova/CDVPlugin.h"


@interface ApplicationInfo : CDVPlugin

- (void)getBuildVersion:(CDVInvokedUrlCommand*)command;

@end
