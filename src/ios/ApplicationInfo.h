//
//  ApplicationInfo.h
//  Octane
//
//  Created by Erin Parrill on 4/19/13.
//
//

#import "Foundation/Foundation.h"
#import "Cordova/CDVPlugin.h"


@interface ApplicationInfo : CDVPlugin {
	UIPasteboard *pasteboard;
}

- (void)getBuildVersion:(CDVInvokedUrlCommand*)command;

-(void)setText:(CDVInvokedUrlCommand*)command;
-(void)getText:(CDVInvokedUrlCommand*)command;

@end
