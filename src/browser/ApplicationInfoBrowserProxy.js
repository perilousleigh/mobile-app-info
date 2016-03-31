"use strict";

function getBuildVersion() {
    return "1.0.0";
}

module.exports = {
    getBuildVersion: function (success, error) {
        setTimeout(function () {
            success(getBuildVersion());
        }, 0);
    }
};

require("cordova/exec/proxy").add("ApplicationInfo", module.exports);
