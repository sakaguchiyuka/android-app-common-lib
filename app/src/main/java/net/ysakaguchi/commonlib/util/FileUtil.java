package net.ysakaguchi.commonlib.util;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ファイル操作用
 */
public class FileUtil {
    public static String getText(final Context context, final String fileName) {
        if (null == context || null == fileName) {
            return null;
        }
        InputStream is = null;
        BufferedReader br = null;
        String text = "";
        try {
            try {
                is = context.getAssets().open(fileName);
                br = new BufferedReader(new InputStreamReader(is));

                // 改行を付加
                String str;
                while ((str = br.readLine()) != null) {
                    text += str + "\n";
                }
            } finally {
                if (is != null) is.close();
                if (br != null) br.close();
            }
        } catch (Exception e){
            e.printStackTrace();
            // エラー発生時の処理
            return null;
        }
        return text;
    }
}
