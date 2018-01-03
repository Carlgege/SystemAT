package com.carl.template.xiaomi;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiObject2;

import com.carl.template.Template;

/**
 * Created by F3060772 on 2015/12/1.
 */
public class Camera extends Template {

    public static void capturePicture() {
        clickByRes("com.android.camera:id/v6_shutter_button_internal");
        sleep(2000);
    }

    public static void captureContinuously() {

        UiObject2 obj = objByRes("com.android.camera:id/v6_shutter_button_internal");
        int x = obj.getVisibleBounds().centerX();
        int y = obj.getVisibleBounds().centerY();
        mDevice.swipe(x, y, x, y, 400);
        sleep(2000);
    }

    public static void captureVideo(long time) {
        clickByRes("com.android.camera:id/v6_shutter_button_internal");
        sleep(time);
        clickByRes("com.android.camera:id/v6_shutter_button_internal");
    }

    public static void frontCamera() {
        //click to switch camera btn if it is rear camera
        if (objByRes("com.android.camera:id/v6_flash_mode_button") != null) {
            clickByRes("com.android.camera:id/v6_camera_picker");
        }
    }

    public static void rearCamera() {
        //click to switch camera btn if it is front camera
        if (objByRes("com.android.camera:id/skin_beatify_button") != null) {
            clickByRes("com.android.camera:id/v6_camera_picker");
        }
    }

    public static void thumbnail() {
        clickByRes("com.android.camera:id/v6_thumbnail_image");
    }

    public static void setFilter() {
        sleep(2000);
        switchScreenTo("right");
        sleep(1000);

        //choose one filter,then back to camera preview automatically
        clickByText(Camera.getFilter());
    }

    public static String getFilter() {

        return InstrumentationRegistry.getArguments().getString("Filter", "素描");
    }

    public static void captureMode(String mode) {
        sleep(2000);
        switchScreenTo("left");
        sleep(2000);

        //choose one mode,then back to camera preview automatically
        clickByDesc(mode);

    }

    public static String getMode() {

        return InstrumentationRegistry.getArguments().getString("Mode", "鱼眼镜头");
    }

    /*
    public static void additionalSettings() {

        switchScreenTo("left");

        //choose one filter,then back to camera preview automatically
        clickByRes("com.android.camera:id/setting_button");

    }
    */

    public static void confirm() {
        clickByRes("com.android.camera:id/v6_btn_done");
    }

    public static void settings(String option, String operator) {

        switch(option) {
            case "保存地理位置信息":
            case "相机声音":
            case "时间水印":
            case "参考线":
            case "扫描二维码":
            case "人脸识别":
                findObjFromListByRes("Vertical", "android:id/list", option, 0, "");
                UiObject2 objOption = objByText(option);
                if (objOption != null) {
                    UiObject2 obj = objOption.getParent().getParent().findObject(selectorByRes("android:id/checkbox"));

                    if (operator.equals("开") && !obj.isChecked()) {
                        obj.click();
                    } else if (operator.equals("关") && obj.isChecked()) {
                        obj.click();
                    }
                }

                break;
            case "长按快门功能":
            case "拍照画幅":
            case "照片质量":
            case "人脸信息":
            case "音量键功能":
            case "防止闪烁":
            case "测光模式":
            case "对比度":
            case "饱和度":
            case "锐度":
                findObjFromListByRes("Vertical", "android:id/list", option, 0, "click");
                clickByText(operator);
                break;
            case "还原默认设置":
                findObjFromListByRes("Vertical", "android:id/list", option, 0, "click");
                clickByText(operator);
                clickByText("确定");
                break;
        }
    }
}
