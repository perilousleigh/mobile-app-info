//
//  ApplicationInfo.m
//  Octane
//
//  Created by Erin Parrill on 4/19/13.
//
//

#import "ApplicationInfo.h"

@implementation ApplicationInfo

-(CDVPlugin*) initWithWebView:(UIWebView*)theWebView
{
    
    self = (ApplicationInfo*)[super initWithWebView:theWebView];
    
        // prepare clipboard
    pasteboard = [UIPasteboard generalPasteboard];
    
    return self;
}


- (void)getBuildVersion:(CDVInvokedUrlCommand*)command {
    // Get the main bundle for the app.
    NSDictionary* infoDict = [[NSBundle mainBundle] infoDictionary];
    
    // Get version string
    NSString* ver = [infoDict objectForKey:@"CFBundleVersion"];
    
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:ver];
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}


-(void)setText:(CDVInvokedUrlCommand*)command {
	
        // get text argument
    NSString* text = [command.arguments objectAtIndex:0];
    
        // store the text
	[pasteboard setValue:text forPasteboardType:@"public.utf8-plain-text"];
    
        // keep open the callback
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:text];
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    
}

-(void)getText:(CDVInvokedUrlCommand*)command {
    
        // get the text from pasteboard
	NSString* text = [pasteboard valueForPasteboardType:@"public.utf8-plain-text"];
    
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:text];
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    
}

@end
