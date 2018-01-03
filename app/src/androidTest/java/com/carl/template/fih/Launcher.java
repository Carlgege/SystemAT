package com.carl.template.fih;

import android.graphics.Point;
import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.view.KeyEvent;

import com.carl.template.Template;
import com.carl.template.xiaomi.Settings;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by F3060772 on 2015/12/1.
 */
public class Launcher extends Template {

    /*
        Find AP from launcher with double layer
        */
    public static void findAP(String APName, String operator) {
        findObjFromListByRes("Horizontal", "android:id/content", APName, 0, operator);
    }

    /*
        Find AP then click it from launcher with double layer
         */
    public static void launchAP(String APName) {

        //This function just suit for FIH launcher
        //UiObject2 allAppsButton = objByDesc("Apps");
        clickByDesc("Apps");

        UiScrollable appList=new UiScrollable(new UiSelector().resourceId("android:id/tabcontent"));
        appList.setAsHorizontalList();
        int appListNum = 0;
        if (objByRes("com.fihtdc.foxlauncher:id/indicator_container") != null) {
            appListNum = objByRes("com.fihtdc.foxlauncher:id/indicator_container").getChildCount();
        }

        UiObject2 pattern = objByRes("android:id/tabcontent");
        int i;
        for (i=0; i<appListNum; i++) {

            if (waitForExist(selectorByText(APName), 3)) {
                clickByText(APName);
                break;
            } else {
                switchScreenTo("right");
            }
        }
        if (i> appListNum) {
            logFail("LaunchAP failed:" + APName);
        }

    }

    public static void launchApplication(String application) {
        clickByDesc("应用");
        findObjFromListByRes("Horizontal", "com.android.launcher3:id/apps_customize_pane_content", application, 0, "click");
        //sleep(1000);
    }

    public static void addShortcut(String type, String shortcutName, int instance) {

        //Press menu from Home screen will show add shortcut screen
        Template.mDevice.pressMenu();

        if (type.equals("Widget")) {
            clickByText("Widget");
            findObjFromListByRes("Vertical", "com.fihtdc.foxlauncher:id/widgets", shortcutName, 0, "click");
            //if the widget has second floor
            if (objByRes("com.fihtdc.foxlauncher:id/second_floor_pane", 0) != null) {
                try {
                    Template.mDevice.findObject(new UiSelector().resourceId("com.fihtdc.foxlauncher:id/widgets")).getChild(new UiSelector().index(instance)).click();
                } catch (UiObjectNotFoundException e) {
                    e.printStackTrace();
                    logFail("The " + instance + "th " + shortcutName + " click failed");
                }
            }

        } else {
            clickByText("App");
            findObjFromListByRes("Vertical", "com.fihtdc.foxlauncher:id/app", shortcutName, 0, "click");
        }

    }

    public static void deleteShortcut(UiObject2 obj) {

        obj.drag(new Point(screenSizeWidth / 2, 50));

    }

    public static void inputPWDFromPIN(String pwd) {
        //input pwd one by one
        for (int i = 0; i < pwd.length(); i++) {
            // int character=Integer.parseInt(String.valueOf(phoneNumber.charAt(i)));
            char c = pwd.charAt(i);
            switch (c) {
                case '0':
                    clickByText("0");
                    break;
                case '1':
                    clickByText("1");
                    break;
                case '2':
                    clickByText("2");
                    break;
                case '3':
                    clickByText("3");
                    break;
                case '4':
                    clickByText("4");
                    break;
                case '5':
                    clickByText("5");
                    break;
                case '6':
                    clickByText("6");
                    break;
                case '7':
                    clickByText("7");
                    break;
                case '8':
                    clickByText("8");
                    break;
                case '9':
                    clickByText("9");
                    break;
            }
        }
    }

    public static void LCDOnOff() {
        //String packageName = mDevice.getCurrentPackageName();
        try {
            //if screen is on, press power key enter suspend mode
            if (mDevice.isScreenOn()) {
                mDevice.pressKeyCode(KeyEvent.KEYCODE_POWER);
                sleep(2000);
            }

            //if screen is not on, press power key to wake up
            if (!mDevice.isScreenOn()) {
                mDevice.pressKeyCode(KeyEvent.KEYCODE_POWER);
                sleep(2000);
            }

            if (packageVerify("com.android.systemui")) {

                if (objByDesc("解锁") != null) {
                    int startX = objByDesc("解锁").getVisibleBounds().centerX();
                    int startY = objByDesc("解锁").getVisibleBounds().centerY();

                    mDevice.drag(startX, startY, startX, screenSizeWidth / 2, 10);
                }
            }

            if (packageVerify("com.android.keyguard")) {
                UiObject2 obj = objByRes("com.android.keyguard:id/porch_keyguard_view_bottom");
                mDevice.drag(obj.getVisibleBounds().centerX(), obj.getVisibleBounds().centerY(),
                        obj.getVisibleBounds().centerX(), screenSizeHeight / 2, 20);
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void unlock() {
        try {
            mDevice.wakeUp();
            sleep(2000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            //unlock screen by default slide lock
            if (packageVerify("com.android.keyguard")) {
                UiObject2 obj = objByRes("com.android.keyguard:id/porch_keyguard_view_bottom");
                if (obj != null) {
                    mDevice.drag(obj.getVisibleBounds().centerX(), obj.getVisibleBounds().centerY(),
                            obj.getVisibleBounds().centerX(), 1, 20);
                }

                if (waitForExist(selectorByRes("com.android.keyguard:id/password_encrypt_dots"), 3)) {
                    Launcher.inputPWDFromPIN(Settings.passwordPIN);
                }
            }

            if (packageVerify("com.android.systemui")) {
                int startX = objByDesc("解锁").getVisibleBounds().centerX();
                int startY = objByDesc("解锁").getVisibleBounds().centerY();

                mDevice.swipe(startX, startY, startX, screenSizeWidth / 2, 10);

            }
        }
    }

}
