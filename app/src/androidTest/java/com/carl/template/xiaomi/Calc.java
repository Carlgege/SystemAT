package com.carl.template.xiaomi;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiObject2;

import com.carl.template.Template;

/**
 * Created by F3060772 on 2015/12/1.
 */
public class Calc extends Template {

    public static void count(String str) {
        for (int i = 0; i < str.length(); i++) {
            // int character=Integer.parseInt(String.valueOf(phoneNumber.charAt(i)));
            char c = str.charAt(i);

            switch (c) {
                case '0':
                    clickByRes("com.android.calculator2:id/digit0");
                    break;
                case '1':
                    clickByRes("com.android.calculator2:id/digit1");
                    break;
                case '2':
                    clickByRes("com.android.calculator2:id/digit2");
                    break;
                case '3':
                    clickByRes("com.android.calculator2:id/digit3");
                    break;
                case '4':
                    clickByRes("com.android.calculator2:id/digit4");
                    break;
                case '5':
                    clickByRes("com.android.calculator2:id/digit5");
                    break;
                case '6':
                    clickByRes("com.android.calculator2:id/digit6");
                    break;
                case '7':
                    clickByRes("com.android.calculator2:id/digit7");
                    break;
                case '8':
                    clickByRes("com.android.calculator2:id/digit8");
                    break;
                case '9':
                    clickByRes("com.android.calculator2:id/digit9");
                    break;
                case '.':
                    clickByRes("com.android.calculator2:id/dot");
                    break;
                case '+':
                    clickByRes("com.android.calculator2:id/plus");
                    break;
                case '−':
                    clickByRes("com.android.calculator2:id/minus");
                    break;
                case '×':
                    clickByRes("com.android.calculator2:id/mul");
                    break;
                case '÷':
                    clickByRes("com.android.calculator2:id/div");
                    break;
                case '=':
                    clickByRes("com.android.calculator2:id/equal");
                    break;
                case '!':
                    if(waitForExist(selectorByRes("com.android.calculator2:id/factorial"), 2)){
                       clickByRes("com.android.calculator2:id/factorial");
                    } else {
                        clickByRes("com.android.calculator2:id/switch_btn");
                        clickByRes("com.android.calculator2:id/factorial");
                    }
                    break;
                case '^':
                    if(waitForExist(selectorByRes("com.android.calculator2:id/power"), 2)){
                        clickByRes("com.android.calculator2:id/power");
                    } else {
                        clickByRes("com.android.calculator2:id/switch_btn");
                        clickByRes("com.android.calculator2:id/power");
                    }
                    break;
                case '√':
                    if(waitForExist(selectorByRes("com.android.calculator2:id/sqrt"), 2)){
                        clickByRes("com.android.calculator2:id/sqrt");
                    } else {
                        clickByRes("com.android.calculator2:id/switch_btn");
                        clickByRes("com.android.calculator2:id/sqrt");
                    }
                    break;
                case 'π':
                    if(waitForExist(selectorByRes("com.android.calculator2:id/pi"),2)){
                        clickByRes("com.android.calculator2:id/pi");
                    } else {
                        clickByRes("com.android.calculator2:id/switch_btn");
                        clickByRes("com.android.calculator2:id/pi");
                    }
                    break;
                case 's':
                    if(waitForExist(selectorByRes("com.android.calculator2:id/sin"), 2)){
                        clickByRes("com.android.calculator2:id/sin");

                    } else {
                        clickByRes("com.android.calculator2:id/switch_btn");
                        clickByRes("com.android.calculator2:id/sin");

                    }
                    i = i + 2;
                    break;
                case 'c':
                    if(waitForExist(selectorByRes("com.android.calculator2:id/cos"), 2)){

                        clickByRes("com.android.calculator2:id/cos");

                    } else {
                        clickByRes("com.android.calculator2:id/switch_btn");
                        clickByRes("com.android.calculator2:id/cos");

                    }
                    i = i + 2;
                    break;
                case 't':
                    if(waitForExist(selectorByRes("com.android.calculator2:id/tan"), 2)){

                        clickByRes("com.android.calculator2:id/tan");

                    } else {
                        clickByRes("com.android.calculator2:id/switch_btn");
                        clickByRes("com.android.calculator2:id/tan");

                    }
                    i = i + 2;
                    break;
                case 'l':
                    char cs = str.charAt(i+1);
                    if (cs == 'n') {
                        if(waitForExist(selectorByRes("com.android.calculator2:id/ln"), 2)){

                            clickByRes("com.android.calculator2:id/ln");

                        } else {
                            clickByRes("com.android.calculator2:id/switch_btn");
                            clickByRes("com.android.calculator2:id/ln");

                        }
                        i = i + 1;

                    } else if (cs == 'o') {
                        if(waitForExist(selectorByRes("com.android.calculator2:id/lg"), 2)){
                            clickByRes("com.android.calculator2:id/lg");

                        } else {
                            clickByRes("com.android.calculator2:id/switch_btn");
                            clickByRes("com.android.calculator2:id/lg");

                        }
                        i = i + 2;
                    }
                    break;
                case '(':
                    if(waitForExist(selectorByRes("com.android.calculator2:id/leftParen"), 2)){
                        clickByRes("com.android.calculator2:id/leftParen");

                    } else {
                        clickByRes("com.android.calculator2:id/switch_btn");
                        clickByRes("com.android.calculator2:id/leftParen");
                    }
                    break;
                case ')':
                    if(waitForExist(selectorByRes("com.android.calculator2:id/rightParen"), 2)){
                        clickByRes("com.android.calculator2:id/rightParen");
                    } else {
                        clickByRes("com.android.calculator2:id/switch_btn");
                        clickByRes("com.android.calculator2:id/rightParen");
                    }
                    break;
                case 'e':
                    if(waitForExist(selectorByRes("com.android.calculator2:id/e"), 2)){
                        clickByRes("com.android.calculator2:id/e");

                    } else {
                        clickByRes("com.android.calculator2:id/switch_btn");
                        clickByRes("com.android.calculator2:id/e");
                    }
                    break;
            }
        }
    }


}
