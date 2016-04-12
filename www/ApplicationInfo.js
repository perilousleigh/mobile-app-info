/*
 * Application Info plugin
 *
 * Gets native application configuration info available through Cordova.
 */

var exec = require('cordova/exec');

var ApplicationInfo = function () {
};

ApplicationInfo.getAppVersion = function (successCallback, errorCallback) {
    exec(successCallback, errorCallback, "ApplicationInfo", "getAppVersion", []);
};

ApplicationInfo.getBuildVersion = function (successCallback, errorCallback) {
    exec(successCallback, errorCallback, "ApplicationInfo", "getBuildVersion", []);
};

module.exports = ApplicationInfo;
