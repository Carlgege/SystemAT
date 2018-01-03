package com.carl.tc.qcom.camera;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class DelPicture extends Template {


    public void tcStep() {


        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            Launcher.launchApplication("文件管理器");
            clickByText("DCIM");
            clickByText("OnOff");
            clickByDesc("操作");
            sleep(2000);
            clickByText("全部选择");
            clickByDesc("操作");
            clickByText("删除选择项");
            clickByText("是");
            backTimes(5);

            //*****************************modify my step end here***********************************
        }


    }

}




