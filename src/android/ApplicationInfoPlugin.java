package com.wex.plugins.applicationInfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.telephony.TelephonyManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

/**
 * Created with IntelliJ IDEA.
 * User: EParrill
 * Date: 7/3/12
 * Time: 10:39 AM
 */
public class ApplicationInfoPlugin extends CordovaPlugin {

    public static final String ACTION_GET_VERSION_NAME = "getBuildVersion";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        PackageManager packageManager = this.cordova.getActivity().getApplicationContext().getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager) this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        Resources applicationResources = this.cordova.getActivity().getResources();

        if (ACTION_GET_VERSION_NAME.equals(action)) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(this.cordova.getActivity().getPackageName(), 0);
                callbackContext.success(packageInfo.versionName);
                return true;
            }
            catch (NameNotFoundException nnfe) {
                callbackContext.error(nnfe.getMessage());
                return false;
            }
        }

        return false;
    }
}
