package com.wex.plugins.applicationInfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;

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

	public static final String TAG = "ApplicationInfoPlugin";
    public static final String ACTION_GET_APP_VERSION_NAME = "getAppVersion";
    public static final String ACTION_GET_BUILD_VERSION_NAME = "getBuildVersion";

	/**
     * Constructor.
     */
    public ApplicationInfoPlugin() {
    }

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        PackageManager packageManager = this.cordova.getActivity().getApplicationContext().getPackageManager();
        TelephonyManager telephonyManager = (TelephonyManager) this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        Resources applicationResources = this.cordova.getActivity().getResources();

        if (ACTION_GET_APP_VERSION_NAME.equals(action)) {
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
        
        if (ACTION_GET_BUILD_VERSION_NAME.equals(action)) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(this.cordova.getActivity().getPackageName(), 0);
                callbackContext.success(packageInfo.versionCode);
                return true;
            }
            catch (NameNotFoundException nnfe) {
                callbackContext.error(nnfe.getMessage());
                return false;
            }
        }

        return false;
    }

	public Boolean shouldAllowRequest(String url){
		return true;
	}
}
