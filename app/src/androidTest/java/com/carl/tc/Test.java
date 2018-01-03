package com.carl.tc;

import android.support.test.uiautomator.UiObject2;
import android.test.InstrumentationTestCase;
import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class Test extends InstrumentationTestCase {

    public long endTime;

    public void test() {

        Template temp = new Template();
        temp.setStartTime(System.nanoTime());
        temp.init(this.getClass().getSimpleName());

        //get repeat times from command line
        for (int i = 1; i <= temp.getRepeat(); i++) {

            temp.setCurrentCycle(i);

            //*****************************modify my step from here***********************************


            //Template.slideTo("down", "clazz", "android.widget.ScrollView", 0, "res", "com.android.settings:id/button_delete", 0, "click");
//            UiObject2 oneAttr = Template.objByText("视频电话").getParent().getParent();
//            //int c = oneAttr.getChildCount();
//            //System.out.println(c);
//            oneAttr.findObject(Template.selectorByRes("com.miui.securitycenter:id/check")).click();
//            UiObject2 sub = oneAttr.getChildren().get(4);
//            System.out.println(sub);
//            sub.click();
            //*****************************modify my step end here***********************************
        }

        //System.out.println("RunRegisterWatch"+temp.runRegisterWatcher());
    }
}




