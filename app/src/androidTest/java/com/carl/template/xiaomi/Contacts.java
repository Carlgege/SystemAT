package com.carl.template.xiaomi;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.carl.template.Template;
import com.carl.utils.GetDeviceInfo;

/**
 * Created by F3060772 on 2015/12/1.
 */
public class Contacts extends Template {

    public static void deleteAllContacts() {

        if (objByRes("com.android.contacts:id/create_contact_button") != null) {
            return;
        }

        //click menu option
        //clickMoreOptions();

        clickByText("Delete contacts");

        //click "0 selected"
        clickByRes("com.android.contacts:id/selection_menu");

        clickByText("Select all");

        //click Done
        clickByRes("com.android.contacts:id/done");

        //click OK
        if (objByRes("android:id/button1") != null) {
            clickByRes("android:id/button1");
        }


        sleep(1000);

        for (int i = 0; i < 120; i++) {
            if (objByText("Deleting contacts...") != null) {
                sleep(1000);
            } else {
                break;
            }
        }
    }

    public static void addContact(String location, String contactName, String contactNum) {

        //location: SIM,  OnOff

        if (objByRes("com.android.contacts:id/create_contact_button") != null) {
            clickByRes("com.android.contacts:id/create_contact_button", 0);
        } else {
            //click "+"
            clickByRes("com.android.contacts:id/fih_fab_layout_fragment");
        }

        if (objByRes("com.android.contacts:id/account_list") != null) {
            if (location.equals("SIM")) {
                clickByText("SIM.*-only, unsynced");
            } else if (location.equals("OnOff")) {
                clickByText("OnOff-only, unsynced");
            }
        } else {
            if (location.equals("SIM")) {
                //click OnOff-only
                clickByRes("com.android.contacts:id/account");
                //switch to SIM
                clickByText("SIM.*-only, unsynced");
            }
        }

        //input contact name
        objByText("Name").setText(contactName);

        //click OnOff textarea
        //cancel show input method


        clickByText("Done");

        Template.mDevice.waitForWindowUpdate(Template.mDevice.getCurrentPackageName(), Template.windowUpdateTimeout);

    }

    public static void importExport(String type, String fromLocation, String toLocation) {

        //type: import , export
        //fromLocation: SIM, Internal storage, SD card
        //toLocation: SIM, Internal storage, SD card

        GetDeviceInfo.getSIMType();

        if (type.equals("import")) {
            if (objByRes("com.android.contacts:id/import_contacts_button") != null) {
                //if no contacts exist, click IMPORT CONTACTS
                clickByRes("com.android.contacts:id/import_contacts_button");
            } else {
                //click Menu
                //clickMoreOptions();
                clickByText("Import/export");
            }

            if (fromLocation.equals("SIM")) {
                clickByText("Import from.*" + GetDeviceInfo.SIM1Operator);
                clickByText("OnOff-only.*");
                //click "0 selected"
                clickByRes("com.android.contacts:id/selection_menu");

                clickByText("Select all");

                //click Done
                clickByRes("com.android.contacts:id/done");

            } else if (fromLocation.equals("Internal storage")) {
                clickByText("Import from storage");
                clickByText("OnOff-only.*");
                if (objByText("Internal storage") != null) {
                    clickByText("Internal storage");

                    Template.mDevice.waitForWindowUpdate(Template.mDevice.getCurrentPackageName(), Template.windowUpdateTimeout);
                    if (objByText("OK") != null) {
                        clickByText("OK");
                    }
                }
                Template.mDevice.waitForWindowUpdate(Template.mDevice.getCurrentPackageName(), Template.windowUpdateTimeout);

                if (objByText("FIH.vcf\n.*") != null) {
                    System.out.println("carlLog--find FIH.*--click");
                    System.out.println("carlLog:" + objByText("FIH.vcf\n.*").getVisibleCenter().x + ":" + objByText("FIH.vcf\n.*").getVisibleCenter().y);

                    clickByText("FIH.vcf\n.*");
                    if (objByText("OK") != null) {
                        clickByText("OK");
                    }
                }

                //wait 2 seconds till import complete
                sleep(2000);
                for (int i = 0; i < 60; i++) {
                    if (objByText("Importing vCard file(s)") != null) {
                        sleep(1000);
                    } else {
                        break;
                    }
                }

            } else if (fromLocation.equals("SD card")) {
                clickByText("Import from storage");
                clickByText("OnOff-only.*");

                clickByText("SD card");
                if (objByText("OK") != null) {
                    clickByText("OK");
                }

                if (objByText("FIH.vcf\n.*") != null) {
                    clickByText("FIH.vcf\n.*");
                    if (objByText("OK") != null) {
                        clickByText("OK");
                    }
                }

                //wait 2 seconds till import complete
                sleep(2000);
                for (int i = 0; i < 60; i++) {
                    if (objByText("Importing vCard file(s)") != null) {
                        sleep(1000);
                    } else {
                        break;
                    }
                }
            }

        } else {
            //export contact
            //clickMoreOptions();
            clickByText("Import/export");

            if (toLocation.equals("SIM")) {
                clickByText("Export to.*" + GetDeviceInfo.SIM1Operator);
                //click "0 selected"
                clickByRes("com.android.contacts:id/selection_menu");

                clickByText("Select all");

                //click Done
                clickByRes("com.android.contacts:id/done");

                sleep(1500);

                for (int i = 0; i < 180; i++) {
                    if (objByText("Copying contacts to.*") != null) {
                        sleep(1000);
                    } else {
                        if (objByText("Insufficient SIM card space.") != null) {
                            clickByText("Insufficient SIM card space.");
                        }
                        break;
                    }
                }

            } else if (toLocation.equals("Internal storage")) {
                clickByText("Export to storage");
                clickByText("All contacts");
                clickByText("Internal storage");
                clickByText("OK");

                sleep(5000);
            } else if (toLocation.equals("SD card")) {
                clickByText("Export to storage");
                clickByText("All contacts");
                clickByText("SD card");
                clickByText("OK");

                sleep(5000);
            }
        }
    }

    public static void searchContact(String searchKeyword) {

        //click search
        clickByRes("com.android.contacts:id/menu_search");

        //input keyword to search
        objByRes("android:id/search_src_text").setText(searchKeyword);
        sleep(1000);
    }

    public static void deleteContact(String phoneNum) {

        if (phoneNum.equals("")) {
            //delete contact without search
            firstContact("longPress");
            clickByText("Delete contact");
            clickByRes("android:id/button1");
        } else {
            //search contact at first then delete
            Contacts.searchContact(getPhoneNum());

            firstContactFromSearchResult("click");

            //click menu
            //clickMoreOptions();
            clickByText("Delete contact");
            //click OK
            clickByRes("android:id/button1");
        }
    }

    public static void clearCallLog() {

        //click Menu
        //clickMoreOptions();

        clickByText("Remove call history");

        //click "0 selected"
        clickByRes("com.android.contacts:id/selection_menu");

        clickByText("Select all");

        //click Done
        clickByRes("com.android.contacts:id/done");

        //click OK
        clickByRes("android:id/button1");

    }

    public static void shareContact(String shareWith) {

        if (objByText("Share with " + shareWith) != null) {
            clickByText("Just once");
        } else {
            objByRes("android:id/resolver_list").swipe(Direction.UP, 1);
            //findObjFromListByRes("Vertical", "android:id/resolver_list", shareWith, 0, "click");
            clickByText(shareWith);
            if (objByText("Just once") != null) {
                clickByText("Just once");
            }
        }

        if (shareWith.equals("Bluetooth")) {
            if (objByText("Turn on") != null) {
                clickByText("Turn on");
            }
        }
    }

    public static void sourceChoose(String source) {

        //source: OnOff, SIM1, SIM2, All, None
        sleep(1000);
        clickByRes("com.android.contacts:id/action_text");

        GetDeviceInfo.getSIMType();

        UiObject phone = Template.mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/checkbox").instance(0));
        UiObject sim1 = Template.mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/checkbox").instance(1));
        UiObject sim2 = Template.mDevice.findObject(new UiSelector().resourceId("com.android.contacts:id/checkbox").instance(2));

        try {
            if (source.equals("OnOff")) {

                if (!phone.isChecked()) {
                    phone.click();
                }
                if (sim1.isChecked()) {
                    sim1.click();
                }
                if (sim2.isChecked() && GetDeviceInfo.SIMCounter > 1) {
                    sim2.click();
                }
            } else if (source.equals("SIM1")) {

                if (phone.isChecked()) {
                    phone.click();
                }
                if (!sim1.isChecked()) {
                    sim1.click();
                }
                if (sim2.isChecked() && GetDeviceInfo.SIMCounter > 1) {
                    sim2.click();
                }
            } else if (source.equals("SIM2")) {

                if (phone.isChecked()) {
                    phone.click();
                }
                if (sim1.isChecked()) {
                    sim1.click();
                }
                if (!sim2.isChecked() && GetDeviceInfo.SIMCounter > 1) {
                    sim2.click();
                }
            } else if (source.equals("All")) {

                if (!phone.isChecked()) {
                    phone.click();
                }
                if (!sim1.isChecked()) {
                    sim1.click();
                }
                if (!sim2.isChecked() && GetDeviceInfo.SIMCounter > 1) {
                    sim2.click();
                }
            } else if (source.equals("None")) {

                if (phone.isChecked()) {
                    phone.click();
                }
                if (sim1.isChecked()) {
                    sim1.click();
                }
                if (sim2.isChecked() && GetDeviceInfo.SIMCounter > 1) {
                    sim2.click();
                }
            }
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

        backTimes(1);

    }

    public static void firstContact(String operator) {

        UiObject2 firstContact = null;
        try {
            firstContact = objByRes("android:id/list").findObject(By.clazz("android.view.ViewGroup"));
            if (operator.equals("click")) {
                firstContact.click();
                Template.mDevice.waitForWindowUpdate(Template.mDevice.getCurrentPackageName(), Template.windowUpdateTimeout);
            } else if (operator.equals("longPress")) {
                longPressObj(firstContact);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        if (firstContact == null) {
            logFail(operator + " first contact failed.");
        }

        sleep(1000);
    }

    public static void firstContactFromSearchResult(String operator) {
        UiObject firstContact = null;
        //click OnOff number to show contact detail
        try {
            firstContact = Template.mDevice.findObject(new UiSelector().text(getPhoneNum()).instance(1));
            firstContact.click();
            Template.mDevice.waitForWindowUpdate(Template.mDevice.getCurrentPackageName(), Template.windowUpdateTimeout);
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

        if (firstContact == null) {
            logFail("Click first contact from search result is failed.");
        }
        sleep(1000);
    }

    public static void editTabs(String tab) {

        if (objByText(tab) == null) {
            //clickMoreOptions();
            findObjFromListByClazz("Vertical", "android.widget.ListView", "Edit tabs", 0, "click");
            //clickByText("Edit tabs");
            clickByText(tab);
            sleep(1000);
            clickByText("OK");
        }
    }


}
