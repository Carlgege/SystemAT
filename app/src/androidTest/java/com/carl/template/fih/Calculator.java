package com.carl.template.fih;

import android.graphics.Point;
import android.os.RemoteException;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.view.KeyEvent;

import com.carl.template.Template;
import com.carl.template.xiaomi.Settings;

/**
 * Created by F3060772 on 2015/12/1.
 */
public class Calculator extends Template {

    public static void count(String digital) {
        //input pwd one by one
        for (int i = 0; i < digital.length(); i++) {
            // int character=Integer.parseInt(String.valueOf(phoneNumber.charAt(i)));
            char c = digital.charAt(i);
            switch (c) {
                case '0':
                    clickByRes("com.android.calculator2:id/digit0");
                    break;
                case '1':
                    clickByRes("com.android.calculator2:id/digit1");
                    break;
                case '2':
                    clickByRes("com.android.calculator2:id/digit2");
                    break;
                case '3':
                    clickByRes("com.android.calculator2:id/digit3");
                    break;
                case '4':
                    clickByRes("com.android.calculator2:id/digit4");
                    break;
                case '5':
                    clickByRes("com.android.calculator2:id/digit5");
                    break;
                case '6':
                    clickByRes("com.android.calculator2:id/digit6");
                    break;
                case '7':
                    clickByRes("com.android.calculator2:id/digit7");
                    break;
                case '8':
                    clickByRes("com.android.calculator2:id/digit8");
                    break;
                case '9':
                    clickByRes("com.android.calculator2:id/digit9");
                    break;
            }
        }
    }


}
