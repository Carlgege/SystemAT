var deviceInfo = {};
var testResult = [
//insert test result to here
];
var deviceStatus = [
//insert device status to here
];
var passTCTotal = 0;
var failTCTotal = 0;
var passRate = "";
var totalDuration="0S";

function getTestResult() {
	
	//alert(JSON.stringify(testResult));
	document.getElementById("uploadresult").value = JSON.stringify(testResult);
	//alert(document.getElementById("uploadresult").value);
	document.getElementById("uploaddeviceinfo").value = JSON.stringify(deviceInfo);
	
}

function init() {

    //get deviceinfo from the variable
    var deviceinfo = document.getElementById("deviceinfo");

    //get result detail from the varaible testResult
    var resultbody = document.getElementById("resultbody");
    //var resultbody = document.getElementsByTagName("resultbody")[0];

    var resultsummary = document.getElementById("resultsummary");

    for (var i = deviceinfo.rows.length - 1; i > -1; i--) {
        deviceinfo.deleteRow(i);
    }

    for (var i = resultsummary.rows.length - 1; i > -1; i--) {
        resultsummary.deleteRow(i);
        passTCTotal = 0;
        failTCTotal = 0;
        //usedTimeTotal = "";
        passRate = "";
        totalDuration="0S";
     }

    for (var i = resultbody.rows.length - 1; i > -1; i--) {
        resultbody.deleteRow(i);
    }

    var tr = document.createElement("tr");
    tr.type = "tr";
    deviceinfo.appendChild(tr);

    var ProductName = document.createElement("td");
    ProductName.innerHTML = deviceInfo.ProductName;
    tr.appendChild(ProductName);

    var SN = document.createElement("td");
    SN.innerHTML = deviceInfo.SN;
    tr.appendChild(SN);

    var SW = document.createElement("td");
    SW.innerHTML = deviceInfo.SW;
    tr.appendChild(SW);

    var SKUID = document.createElement("td");
    SKUID.innerHTML = deviceInfo.SKUID;
    tr.appendChild(SKUID);

    var androidPlatformVersion = document.createElement("td");
    androidPlatformVersion.innerHTML = deviceInfo.androidPlatformVersion;
    tr.appendChild(androidPlatformVersion);

    var CPUModel = document.createElement("td");
    CPUModel.innerHTML = deviceInfo.CPUModel;
    tr.appendChild(CPUModel);

    var SIMOperator = document.createElement("td");
    SIMOperator.innerHTML = deviceInfo.SIMOperator;
    tr.appendChild(SIMOperator);

    var resultselect = document.getElementById("resultselect");

    for (var i = 0; i < testResult.length; i++) {

        //if user filter result by Fail, then skip the result of Pass
        if (resultselect.value === "Fail") {
            if (testResult[i].TCResult === "Pass") {
                continue;
            }
        }

        //if user filter result by Pass, then skip the result of Fail
        if (resultselect.value === "Pass") {
            if (testResult[i].TCResult === "Fail") {
                continue;
            }
        }

        var tr = document.createElement("tr");
        tr.type = "tr";
        resultbody.appendChild(tr);

        var tcDate = document.createElement("td");
        tcDate.innerHTML = testResult[i].TCDate;
        tr.appendChild(tcDate);

        var tcName = document.createElement("td");
        var tcNameLink = document.createElement("a");
        tcNameLink.innerHTML = testResult[i].TCName;
        tcNameLink.href = "TestDetail.html#" + testResult[i].TCStartTime;
        tcName.appendChild(tcNameLink);
        tr.appendChild(tcName);

        var tcRepeat = document.createElement("td");
        tcRepeat.innerHTML = testResult[i].TCRepeat;
        tr.appendChild(tcRepeat);

        var tcResult = document.createElement("td");
        tcResult.innerHTML = testResult[i].TCResult;
        if (testResult[i].TCResult === "Pass") {
            passTCTotal++;
        } else if (testResult[i].TCResult === "Fail") {
            failTCTotal++;
            tcResult.style.color = "red";
            tcResult.style.fontSize = "1.2em";
            tcResult.style.fontWeight = "bold";
        }
        tr.appendChild(tcResult);

        var tcDuration = document.createElement("td");
        tcDuration.innerHTML = testResult[i].TCDuration;
        tr.appendChild(tcDuration);

        totalDuration = getTotalDuration(totalDuration, testResult[i].TCDuration);

        var tcFailReason = document.createElement("td");
        tcFailReason.innerHTML = testResult[i].TCFailReason;
        tr.appendChild(tcFailReason);

        var tcFailScreenshot = document.createElement("td");
        if (testResult[i].TCResult === "Pass") {
            tcFailScreenshot.innerHTML = testResult[i].TCFailScreenshot;
            //tr.appendChild(tcFailScreenshot);
        } else if (testResult[i].TCResult === "Fail") {
            var tcFailScreenshotLink = document.createElement("a");
            tcFailScreenshotLink.innerHTML = testResult[i].TCFailScreenshot;
            tcFailScreenshotLink.href = "../Image/" + testResult[i].TCFailScreenshot + ".png";
            tcFailScreenshot.appendChild(tcFailScreenshotLink);
        }
        tr.appendChild(tcFailScreenshot);

    }

    var summarybody = document.getElementById("resultsummary");

    var tr_summarybody = document.createElement("tr");
    tr_summarybody.type = "tr";
    summarybody.appendChild(tr_summarybody);

    var tcTotal_summarybody = document.createElement("td");
    tcTotal_summarybody.innerHTML = "" + testResult.length;
    tr_summarybody.appendChild(tcTotal_summarybody);

    var passTotal_summarybody = document.createElement("td");
    passTotal_summarybody.innerHTML = "" + passTCTotal;
    tr_summarybody.appendChild(passTotal_summarybody);

    var failTotal_summarybody = document.createElement("td");
    failTotal_summarybody.innerHTML = "" + failTCTotal;
    tr_summarybody.appendChild(failTotal_summarybody);

    var usedTimeTotal_summarybody = document.createElement("td");
    usedTimeTotal_summarybody.innerHTML = totalDuration;
    tr_summarybody.appendChild(usedTimeTotal_summarybody);

    var passRate_summarybody = document.createElement("td");
    passRate_summarybody.innerHTML = parseInt((passTCTotal / testResult.length).toFixed(2) * 100) + "%";
    passRate_summarybody.style.color = "green";
    passRate_summarybody.style.fontSize = "1.4em";
    passRate_summarybody.style.fontWeight = "bold";
    passRate_summarybody.colSpan = 3;
    tr_summarybody.appendChild(passRate_summarybody);

}

function getTotalDuration(total, one){

        var day=0;
        var hour=0;
        var minute=0;
        var second=0;

        if (total.indexOf("D") > -1) {
            day = parseInt(total.substring(0, total.indexOf("D")));
        }
        if (total.indexOf("H") > -1) {
            hour = parseInt(total.substring(total.indexOf("D") > -1 ? total.indexOf("D")+1 : 0, total.indexOf("H")));
        }
        if (total.indexOf("M") > -1) {
            minute = parseInt(total.substring(total.indexOf("H") > -1 ? total.indexOf("H")+1 : 0, total.indexOf("M")));
        }
        if (total.indexOf("S") > -1) {
            second = parseInt(total.substring(total.indexOf("M") > -1 ? total.indexOf("M")+1 : 0, total.indexOf("S")));
        }

//        console.log(day);
//        console.log(hour);
//        console.log(minute);
//        console.log(second);

        var subday=0;
        var subhour=0;
        var subminute=0;
        var subsecond=0;

        if (one.indexOf("D") > -1) {
            subday = parseInt(one.substring(0, one.indexOf("D")));
        }
        if (one.indexOf("H") > -1) {
            subhour = parseInt(one.substring(one.indexOf("D") > -1 ? one.indexOf("D")+1 : 0, one.indexOf("H")));
        }
        if (one.indexOf("M") > -1) {
            subminute = parseInt(one.substring(one.indexOf("H") > -1 ? one.indexOf("H")+1 : 0, one.indexOf("M")));
        }
        if (one.indexOf("S") > -1) {
            subsecond = parseInt(one.substring(one.indexOf("M") > -1 ? one.indexOf("M")+1 : 0, one.indexOf("S")));
        }

//        console.log(subday);
//        console.log(subhour);
//        console.log(subminute);
//        console.log(subsecond);

        day = day + subday;
        hour = hour + subhour;
        minute = minute + subminute;
        second = second +  subsecond;

//        console.log(day);
//        console.log(hour);
//        console.log(minute);
//        console.log(second);

        if (second > 60) {
            minute = minute + parseInt(second / 60);
            second = second % 60;
        }
        if (minute > 60) {
            hour = hour + parseInt(minute / 60);
            minute = minute % 60;
        }
        if (hour > 24) {
            day = day + parseInt(hour / 24);
            hour = hour % 24;
        }

        if (day == 0 && hour == 0 && minute == 0) {
            return second+"S";
        } else if (day == 0 && hour == 0) {
            return minute+"M"+second+"S";
        } else if (day == 0) {
            return hour+"H"+minute+"M"+second+"S";
        }

        return day+"D"+hour+"H"+minute+"M"+second+"S";
}

window.onload = init;
