/*
 * Application Info plugin
 *
 * Gets native application configuration info available through Cordova.
 */

var exec = require('cordova/exec');

var ApplicationInfo = {
    getBuildVersion: function(successCallback) {
        exec(successCallback, null, 'ApplicationInfo', 'getBuildVersion', []);
    }
};

module.exports = ApplicationInfo;
