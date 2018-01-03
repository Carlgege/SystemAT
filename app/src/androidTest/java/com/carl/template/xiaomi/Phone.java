package com.carl.template.xiaomi;

import android.graphics.Point;
import android.support.test.uiautomator.UiObject2;
import android.view.KeyEvent;
import com.carl.template.Template;
import com.carl.utils.GetDeviceInfo;

/**
 * Created by F3060772 on 2015/12/1.
 */
public class Phone extends Template {

    public static String dial1 = "com.android.contacts:id/dial.*";
    public static String dial2 = "com.android.contacts:id/dialBtnSub2";

    public static int x_attr = -1;
    public static int y_attr = -1;
    
    /*
        input OnOff number from dialer without press dial
         */
    public static void inputPhoneNum(String phoneNum) {

        if (objByRes("com.android.contacts:id/clear_digits") != null) {
            clickByRes("com.android.contacts:id/clear_digits");
        }

        //input OnOff number one by one
        for (int i = 0; i < phoneNum.length(); i++) {
            // int character=Integer.parseInt(String.valueOf(phoneNumber.charAt(i)));
            char c = phoneNum.charAt(i);
            switch (c) {
                case '0':
                    clickByRes("com.android.contacts:id/zero");
                    break;
                case '1':
                    clickByRes("com.android.contacts:id/one");
                    break;
                case '2':
                    clickByRes("com.android.contacts:id/two");
                    break;
                case '3':
                    clickByRes("com.android.contacts:id/three");
                    break;
                case '4':
                    clickByRes("com.android.contacts:id/four");
                    break;
                case '5':
                    clickByRes("com.android.contacts:id/five");
                    break;
                case '6':
                    clickByRes("com.android.contacts:id/six");
                    break;
                case '7':
                    clickByRes("com.android.contacts:id/seven");
                    break;
                case '8':
                    clickByRes("com.android.contacts:id/eight");
                    break;
                case '9':
                    clickByRes("com.android.contacts:id/nine");
                    break;
                case '*':
                    clickByRes("com.android.contacts:id/star");
                    break;
                case '#':
                    clickByRes("com.android.contacts:id/pound");
                    break;
                case '+':
                    longPressObj(objByRes("com.android.contacts:id/zero"));
                    break;
                case ',':
                    Template.mDevice.pressMenu();
                    clickByText("Add 2-sec pause");
                    break;
                case ';':
                    Template.mDevice.pressMenu();
                    clickByText("Add wait");
                    break;
            }
        }
    }

    public static void dial(String SIMChoose) {

        /*
                press dial key to MO call
                */

        GetDeviceInfo.getSIMType();
        if (GetDeviceInfo.SIMCounter > 1 && getSIMChoose().equals("SIM2")) {
            clickByRes(dial2);
        } else {
            clickByRes(dial1);
        }

    }

    public static Point getAttrCoordinate(String type, String text) {
        UiObject2 obj;
        switch (type) {
            case "text":
                obj = objByText(text);
                break;
            case "res":
                obj = objByRes(text);
                break;
            case "desc":
                obj = objByDesc(text);
                break;
            case "clazz":
                obj = objByClazz(text);
                break;
            default:
                obj = null;
        }

        if (obj != null) {
            x_attr = obj.getVisibleBounds().centerX();
            y_attr = obj.getVisibleBounds().centerY();
        }
        return new Point(x_attr, y_attr);
    }

    public static void endCall() {

        Template.mDevice.pressKeyCode(KeyEvent.KEYCODE_ENDCALL);
        Template.mDevice.waitForWindowUpdate(Template.mDevice.getCurrentPackageName(), Template.windowUpdateTimeout);
        /*
                //here has one issue: during calling, LCD On Off will cause hang up screen can not dump successfully
        int i;
        for (i=0; i<3; i++) {
            dumpXML();
            UiObject2 hangUp = objByRes(".*end_call.*");

            if (hangUp != null) {
                hangUp.click();
                sleep(2000);
                break;
            }
            //clickByDesc("End.*");

        }
        if (i>=3) {
            logFail("Can not find the hang up icon.");
        }
        */

    }

    public static void searchCallHistory(String searchKeyword) {
        //click search
        clickByRes("com.android.contacts:id/menu_search");

        //input keyword to search
        objByRes("android:id/search_src_text").setText(searchKeyword);

        sleep(500);
    }


}
