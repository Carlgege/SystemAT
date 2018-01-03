package com.carl.template.xiaomi;

import com.carl.template.Template;

/**
 * Created by F3060772 on 2015/12/1.
 */
public class Messaging extends Template {
    
    public static void send() {
        clickByRes("com.android.mms:id/send_button");

    }

    public static void backToNewMessage() {
        for (int k = 0; k < 5; k++) {
            if (objByText("新信息") == null) {
                backTimes(1);
            } else {
                break;
            }
        }
    }

}
