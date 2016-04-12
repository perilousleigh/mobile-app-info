"use strict";

function getAppVersion() {
    return "1.0.0";
}

function getBuildVersion() {
    return "1";
}

module.exports = {
    getAppVersion: function (success, error) {
        setTimeout(function () {
            success(getAppVersion());
        }, 0);
    },
    
    getBuildVersion: function (success, error) {
        setTimeout(function () {
            success(getBuildVersion());
        }, 0);
    }
};

require("cordova/exec/proxy").add("ApplicationInfo", module.exports);
