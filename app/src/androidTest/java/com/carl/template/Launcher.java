package com.carl.template;

import android.graphics.Point;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

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

        for (int i = 0; i < Template.mDevice.findObjects(By.desc(Pattern.compile("第.*屏"))).size(); i++) {

            if (i == 0) {
                if (objByText(APName) != null) {
                    clickByText(APName);
                    return;
                } else {
                    Template.mDevice.pressHome();
                    Template.mDevice.pressHome();
                }
            }

            if (objByText(APName) != null) {
                clickByText(APName);
                return;
            } else {

                List<UiObject2> folder = Template.mDevice.findObjects(By.res("com.miui.home:id/preview_icons_container"));

                for (int j = 0; j < folder.size(); j++) {

                    folder.get(j).click();

                    if (findObjFromListByRes("Vertical", "com.miui.home:id/folder_content", APName, 0, "") != null) {
                        clickByText(APName);
                        return;
                    } else {
                        backTimes(1);
                    }
                }
            }
            Template.mDevice.swipe(screenSizeWidth - 1, screenSizeHeight / 2, 1, screenSizeHeight / 2, 50);
        }
        logFail("LaunchAP failed:" + APName);
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

}
