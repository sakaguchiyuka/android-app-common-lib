package net.ysakaguchi.commonlib.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

public class AppUtil {
    /**
     * バージョンコードを取得する
     */
    public static int getVersionCode(final Context context) {
        PackageManager pm = context.getPackageManager();
        int versionCode = 0;
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * バージョン名を取得する
     */
    public static String getVersionName(final Context context) {
        PackageManager pm = context.getPackageManager();
        String versionName = "";
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * プレイストアを開く
     */
    public static void openPlayStore(final Context context, final String packageName) {
        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://market.android.com/details?id=" + packageName)));
    }
}
