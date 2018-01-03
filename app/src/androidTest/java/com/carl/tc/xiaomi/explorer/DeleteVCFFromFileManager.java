package com.carl.tc.xiaomi.explorer;

import com.carl.template.Template;
import com.carl.template.xiaomi.Explorer;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class DeleteVCFFromFileManager extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("文件管理");
        clickByText("手机");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            Explorer.slideTo("down", "android:id/list", 0, "text", "00.*vcf", 0, "longPress");
            clickByText("删除");
            //sleep(1000);
            clickByRes("android:id/button1");
            //*****************************modify my step end here***********************************
        }
    }
}




