package net.ysakaguchi.commonlib.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import java.util.ArrayList;

/**
 * 通知処理用クラス
 */
public class NotificationUtil {

    public static class Params {
        public String mTickerText;
        public String mTitle;
        public String mMessage;
        public int mIconId = -1;
        public Bitmap mLargeIconBitmap;
        public PendingIntent mPendingIntent;
        public ArrayList<ActionParams> mActionParams;
        public ArrayList<ActionParams> mWearActionParams;
        public int mPriority = NotificationCompat.PRIORITY_DEFAULT;

        public void setLargeIcon(final Context context, final int resId) {
            mLargeIconBitmap = BitmapFactory.decodeResource(context.getResources(), resId);
        }
    }

    public static class ActionParams {
        final int mIconId;
        final String mTitle;
        final PendingIntent mPendingIntent;

        public ActionParams(final int iconId, final String title, final PendingIntent pi) {
            mIconId = iconId;
            mTitle = title;
            mPendingIntent = pi;
        }
    }

    public static Notification build(final Context context, final NotificationUtil.Params params) {
        if (null == params) {
            return null;
        }
        // NotificationBuilderを作成
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        if (null != params.mPendingIntent) {
            builder.setContentIntent(params.mPendingIntent);
        }
        if (null != params.mTickerText) {
            // ステータスバーに表示されるテキスト
            builder.setTicker(params.mTickerText);
        }
        if (0 < params.mIconId) {
            // アイコン
            builder.setSmallIcon(params.mIconId);
        }
        if (null != params.mTitle) {
            // Notificationを開いたときに表示されるタイトル
            builder.setContentTitle(params.mTitle);
        }
        if (null != params.mMessage) {
            // Notificationを開いたときに表示されるサブタイトル
            builder.setContentText(params.mMessage);
        }
        if (11 < Build.VERSION.SDK_INT && null != params.mLargeIconBitmap) {
            // Notificationを開いたときに表示されるアイコン
            builder.setLargeIcon(params.mLargeIconBitmap);
        }
        // 通知するタイミング
        builder.setWhen(System.currentTimeMillis());

        // タップするとキャンセル(消える)
        builder.setAutoCancel(true);

        // 優先度
        builder.setPriority(params.mPriority);

        // action
        if (null != params.mActionParams && 0 < params.mActionParams.size()) {
            for (ActionParams action : params.mActionParams) {
                builder.addAction(action.mIconId, action.mTitle, action.mPendingIntent);
            }
        }

        // wear action
        if (null != params.mWearActionParams && 0 < params.mWearActionParams.size()) {
            NotificationCompat.WearableExtender wearableExtender = new NotificationCompat.WearableExtender();
            for (ActionParams action : params.mWearActionParams) {
                wearableExtender.addAction(new NotificationCompat.Action.Builder(action.mIconId, action.mTitle, action.mPendingIntent).build());
            }
            builder.extend(wearableExtender);
        }

        return builder.build();
    }

    public static void notify(final Context context, final int notificationId, final Notification notification) {
        // NotificationManagerを取得
        final NotificationManager manager = (NotificationManager) context.getSystemService(Service.NOTIFICATION_SERVICE);
        // Notificationを作成して通知
        manager.notify(notificationId, notification);
    }

    public static void cancel(final Context context, final int notificationId) {
        final NotificationManager manager = (NotificationManager) context.getSystemService(Service.NOTIFICATION_SERVICE);
        manager.cancel(notificationId);
    }
}
