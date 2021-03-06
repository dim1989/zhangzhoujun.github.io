package com.android.myvolley.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @desc:Toast统一管理类
 */
public class BaseToast {
    // Toast
    private static Toast  toast;
    // 基础报错信息
    private static String mBaseErrorMsg = "BASE_ERROR";

    /**
     * 通用报错
     * 
     * @param context
     */
    public static void showBaseErrorShort(Context context) {
        if (null == toast) {
            toast = Toast.makeText(context, mBaseErrorMsg, Toast.LENGTH_SHORT);
            // toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(mBaseErrorMsg);
        }
        toast.show();
    }

    /**
     * 指定错误的提示（如果指定提示为空，那么显示默认的）
     * 
     * @param context
     * @param des
     */
    public static void showBaseErrorShortByDex(Context context, String des) {
        if (BaseComFunc.isNull(des)) {
            des = mBaseErrorMsg;
        }
        if (null == toast) {
            toast = Toast.makeText(context, des, Toast.LENGTH_SHORT);
            // toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(des);
        }
        toast.show();
    }

    /**
     * 短时间显示Toast
     * 
     * @param context
     * @param message
     */
    public static void showShort(Context context, CharSequence message) {
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            // toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    /**
     * 短时间显示Toast
     * 
     * @param context
     * @param message
     */
    public static void showShort(Context context, int message) {
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            // toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    /**
     * 长时间显示Toast
     * 
     * @param context
     * @param message
     */
    public static void showLong(Context context, CharSequence message) {
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
            // toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    /**
     * 长时间显示Toast
     * 
     * @param context
     * @param message
     */
    public static void showLong(Context context, int message) {
        if (null == toast) {
            toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
            // toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    /**
     * 自定义显示Toast时间
     * 
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, CharSequence message, int duration) {
        if (null == toast) {
            toast = Toast.makeText(context, message, duration);
            // toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    /**
     * 自定义显示Toast时间
     * 
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, int message, int duration) {
        if (null == toast) {
            toast = Toast.makeText(context, message, duration);
            // toast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            toast.setText(message);
        }
        toast.show();
    }

    /** Hide the toast, if any. */
    public static void hideToast() {
        if (null != toast) {
            toast.cancel();
        }
    }
}
