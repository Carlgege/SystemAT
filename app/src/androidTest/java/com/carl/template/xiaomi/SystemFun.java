package com.carl.template.xiaomi;

import com.carl.template.Template;

/**
 * Created by F3060772 on 2015/12/1.
 */
public class SystemFun extends Template {

    public static void sendVia(String way) {
        switch (way) {
            case "蓝牙":
                clickByText(way);
                if (waitForExist(selectorByText("开启"), 3)) {
                    clickByText("开启");
                }
                break;
            case "短信":
                clickByText(way);
                break;
            case "电子邮件":
                clickByText(way);
                break;
            case "便签":
                clickByText(way);
                break;
            case "米聊":
                clickByText(".*"+way);
                break;
        }

    }




}
