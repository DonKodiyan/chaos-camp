var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1260",
        "ok": "919",
        "ko": "341"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "103"
    },
    "maxResponseTime": {
        "total": "50439",
        "ok": "50439",
        "ko": "43596"
    },
    "meanResponseTime": {
        "total": "10520",
        "ok": "10138",
        "ko": "11547"
    },
    "standardDeviation": {
        "total": "10591",
        "ok": "11260",
        "ko": "8445"
    },
    "percentiles1": {
        "total": "7384",
        "ok": "7282",
        "ko": "9210"
    },
    "percentiles2": {
        "total": "15881",
        "ok": "14693",
        "ko": "18588"
    },
    "percentiles3": {
        "total": "32927",
        "ok": "37734",
        "ko": "25526"
    },
    "percentiles4": {
        "total": "45952",
        "ok": "46400",
        "ko": "27169"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 159,
        "percentage": 13
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 38,
        "percentage": 3
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 722,
        "percentage": 57
    },
    "group4": {
        "name": "failed",
        "count": 341,
        "percentage": 27
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "11.053",
        "ok": "8.061",
        "ko": "2.991"
    }
},
contents: {
"req_api-info-b72d2": {
        type: "REQUEST",
        name: "api-info",
path: "api-info",
pathFormatted: "req_api-info-b72d2",
stats: {
    "name": "api-info",
    "numberOfRequests": {
        "total": "630",
        "ok": "630",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "50439",
        "ok": "50439",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "8929",
        "ok": "8929",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "10680",
        "ok": "10680",
        "ko": "-"
    },
    "percentiles1": {
        "total": "7103",
        "ok": "7103",
        "ko": "-"
    },
    "percentiles2": {
        "total": "12488",
        "ok": "12488",
        "ko": "-"
    },
    "percentiles3": {
        "total": "42069",
        "ok": "42069",
        "ko": "-"
    },
    "percentiles4": {
        "total": "49877",
        "ok": "49877",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 150,
        "percentage": 24
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 15,
        "percentage": 2
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 465,
        "percentage": 74
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "5.526",
        "ok": "5.526",
        "ko": "-"
    }
}
    },"req_bulkhead-34972": {
        type: "REQUEST",
        name: "bulkhead",
path: "bulkhead",
pathFormatted: "req_bulkhead-34972",
stats: {
    "name": "bulkhead",
    "numberOfRequests": {
        "total": "630",
        "ok": "289",
        "ko": "341"
    },
    "minResponseTime": {
        "total": "103",
        "ok": "449",
        "ko": "103"
    },
    "maxResponseTime": {
        "total": "43599",
        "ok": "43599",
        "ko": "43596"
    },
    "meanResponseTime": {
        "total": "12110",
        "ok": "12775",
        "ko": "11547"
    },
    "standardDeviation": {
        "total": "10257",
        "ok": "12016",
        "ko": "8445"
    },
    "percentiles1": {
        "total": "8724",
        "ok": "8303",
        "ko": "9210"
    },
    "percentiles2": {
        "total": "19158",
        "ok": "20871",
        "ko": "18588"
    },
    "percentiles3": {
        "total": "32342",
        "ok": "37037",
        "ko": "25526"
    },
    "percentiles4": {
        "total": "39633",
        "ok": "40753",
        "ko": "27169"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 9,
        "percentage": 1
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 23,
        "percentage": 4
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 257,
        "percentage": 41
    },
    "group4": {
        "name": "failed",
        "count": 341,
        "percentage": 54
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "5.526",
        "ok": "2.535",
        "ko": "2.991"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
