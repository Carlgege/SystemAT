package com.carl.tc.qcom.camera;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class DelPictureFromGallery extends Template {


    public void tcStep() {


        Launcher.launchApplication("图库");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByDesc("更多选项");
            clickByText("选择条目");

            Template.mDevice.click(screenSizeWidth / 4, screenSizeHeight / 3);

            clickByDesc("删除");
            clickByText("确定");

            sleep(2000);

            //*****************************modify my step end here***********************************
        }


    }

}




