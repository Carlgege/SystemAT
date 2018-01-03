package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class DelPicture extends Template {

    public void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            Launcher.launchAP("文件管理");
            clickByText("手机");
            clickByText("DCIM");
            clickByText("OnOff");

            if (objByRes("com.android.fileexplorer:id/file_name") != null) {
                longPressObj(objByRes("com.android.fileexplorer:id/file_name"));
                sleep(1000);
                if (objByText("全选") != null) {
                    clickByText("全选");
                }

                clickByText("删除");
                clickByRes("android:id/button1");

            }

            //*****************************modify my step end here***********************************
        }
    }

}




