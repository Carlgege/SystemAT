package com.carl.tc.xiaomi.notes;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class AddOpenDelete extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("便签");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByText("新建便签");

            if (i == 1) {
                if (objByText("暂不") != null) {
                    clickByText("暂不");
                }
            }

            objByRes("com.miui.notes:id/rich_editor").setText("FIH" + i);
            sleep(2000);

            clickByRes("com.miui.notes:id/home");

            longPressObj(objByRes("com.miui.notes:id/time"));
            //dumpXML();
            clickByText("删除");
            //dumpXML();
            clickByText("删除");

            //*****************************modify my step end here***********************************
        }

        //System.out.println("RunRegisterWatch"+runRegisterWatcher());
        if (!runRegisterWatcher()) {
            endTime = System.nanoTime();
            logPass(endTime);
        } else {
            logFail("crash happened");
        }

        //backTimes(3);
        removeRegisterWatcher();
    }

}




