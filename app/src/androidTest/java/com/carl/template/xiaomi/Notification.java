package com.carl.template.xiaomi;

import com.carl.template.Template;

/**
 * Created by F3060772 on 2015/12/1.
 */
public class Notification extends Template {

    public static void hangUp() {

        Template.mDevice.openNotification();

        if (objByDesc("Hang up") != null) {
            clickByDesc("Hang up");
        }
    }

    public static void dragNotification() {
        mDevice.swipe(screenSizeWidth / 2, 1, screenSizeWidth / 2, screenSizeHeight, 20);
    }



}
