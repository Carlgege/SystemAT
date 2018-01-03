package com.carl.template.xiaomi;

import android.support.test.uiautomator.UiObject2;

import com.carl.template.Template;

/**
 * Created by F3060772 on 2015/12/1.
 */
public class Explorer extends Template {


    public static boolean slideTo(String dire, String resourceId, int insParent, String type, String str, int insChild, String operator) {
        UiObject2 parent;
        if (objByRes(resourceId, insParent) != null) {
            parent = objByRes(resourceId, insParent);
        } else {
            return false;
        }

        int top = parent.getVisibleBounds().top;
        int bottom = parent.getVisibleBounds().bottom;
        int left = parent.getVisibleBounds().left;
        int right = parent.getVisibleBounds().right;
        int centerX = parent.getVisibleBounds().centerX();
        int centerY = parent.getVisibleBounds().centerY();

        UiObject2 child = null;
        for (int i = 0; i < 10; i++) {

            if (type.equals("res")) {
                if (objByRes(str, insChild) != null) {
                    child = objByRes(str, insChild);
                    break;
                }
            } else if (type.equals("text")) {
                if (objByText(str, insChild) != null) {
                    child = objByText(str, insChild);
                    break;
                }
            } else if (type.equals("clazz")) {
                if (objByClazz(str, insChild) != null) {
                    child = objByClazz(str, insChild);
                    break;
                }
            } else if (type.equals("desc")) {
                if (objByDesc(str, insChild) != null) {
                    child = objByDesc(str, insChild);
                    break;
                }
            }

            if (dire.equals("left")) {
                Template.mDevice.swipe(left + 1, centerY, right - 1, centerY, (right - left) / 4);
            } else if (dire.equals("right")) {
                Template.mDevice.swipe(right - 1, centerY, left + 1, centerY, (right - left) / 4);
            } else if (dire.equals("up")) {
                Template.mDevice.swipe(centerX, top + 1, centerX, bottom - 1, (bottom - top) / 4);
            } else if (dire.equals("down")) {
                Template.mDevice.swipe(centerX, bottom - 150, centerX, top + 1, (bottom - top) / 4);
            }
        }

        if (operator.equals("click")) {
            child.click();
        } else if (operator.equals("longPress")) {
            longPressObj(child);
        }

        return true;
    }

    /*
        Find AP then click it from launcher with double layer
         */
}
