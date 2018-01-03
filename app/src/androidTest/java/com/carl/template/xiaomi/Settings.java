package com.carl.template.xiaomi;

import com.carl.template.Template;
import com.carl.utils.GetDeviceInfo;

/**
 * Created by F3060772 on 2015/12/1.
 */
public class Settings extends Template {

    public static String passwordPIN = "1234";

    public static void switchNetworkMode(String networkMode) {
        if (GetDeviceInfo.getCpuType().equals("MTK")) {

            clickByText("Cellular networks");
            clickByText("Preferred network type");
            clickByText(networkMode);

        } else if (GetDeviceInfo.getCpuType().equals("QT")) {

        }
    }


}
