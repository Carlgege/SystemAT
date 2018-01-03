package com.carl.tc.xiaomi.explorer;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class DeleteFolder extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("文件管理");
        clickByText("手机");
        findObjFromListByRes("Vertical", "android:id/list", "Download", 0, "click");
        if (objByRes("com.android.fileexplorer:id/file_name") != null) {
            longPressObj(objByRes("com.android.fileexplorer:id/file_name"));
            if (objByText("全选") != null) {
                clickByText("全选");
            }
            clickByText("删除");
            //sleep(1000);
            clickByRes("android:id/button1");
        }

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            //*****************************modify my step end here***********************************
        }

        //System.out.println("RunRegisterWatch"+runRegisterWatcher());
        if (!runRegisterWatcher()) {
            endTime = System.nanoTime();
            logPass(endTime);
        } else {
            logFail("crash happened");
        }

        mDevice.pressBack();
        mDevice.pressBack();

        backTimes(3);
        removeRegisterWatcher();
    }

}




