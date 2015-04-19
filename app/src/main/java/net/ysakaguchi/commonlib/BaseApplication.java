package net.ysakaguchi.commonlib;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * 共通アプリケーションクラス
 */
public class BaseApplication extends Application {
    private Tracker mTracker;
    public synchronized Tracker getTracker() {
        if (null == mTracker) {
            final int appTracker = getResources().getIdentifier("app_tracker", "xml", getPackageName());
            if (0 != appTracker) {
                mTracker = GoogleAnalytics.getInstance(this).newTracker(appTracker);
            }
        }
        return mTracker;
    }
}
