var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "630",
        "ok": "234",
        "ko": "396"
    },
    "minResponseTime": {
        "total": "107",
        "ok": "460",
        "ko": "107"
    },
    "maxResponseTime": {
        "total": "22804",
        "ok": "22804",
        "ko": "21512"
    },
    "meanResponseTime": {
        "total": "5968",
        "ok": "6645",
        "ko": "5568"
    },
    "standardDeviation": {
        "total": "5751",
        "ok": "6227",
        "ko": "5410"
    },
    "percentiles1": {
        "total": "3793",
        "ok": "3761",
        "ko": "3810"
    },
    "percentiles2": {
        "total": "8220",
        "ok": "10200",
        "ko": "7580"
    },
    "percentiles3": {
        "total": "17538",
        "ok": "19751",
        "ko": "17195"
    },
    "percentiles4": {
        "total": "21498",
        "ok": "21974",
        "ko": "18499"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 8,
        "percentage": 1
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 18,
        "percentage": 3
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 208,
        "percentage": 33
    },
    "group4": {
        "name": "failed",
        "count": 396,
        "percentage": 63
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "7.59",
        "ok": "2.819",
        "ko": "4.771"
    }
},
contents: {
"req_ratelimiter-78187": {
        type: "REQUEST",
        name: "ratelimiter",
path: "ratelimiter",
pathFormatted: "req_ratelimiter-78187",
stats: {
    "name": "ratelimiter",
    "numberOfRequests": {
        "total": "630",
        "ok": "234",
        "ko": "396"
    },
    "minResponseTime": {
        "total": "107",
        "ok": "460",
        "ko": "107"
    },
    "maxResponseTime": {
        "total": "22804",
        "ok": "22804",
        "ko": "21512"
    },
    "meanResponseTime": {
        "total": "5968",
        "ok": "6645",
        "ko": "5568"
    },
    "standardDeviation": {
        "total": "5751",
        "ok": "6227",
        "ko": "5410"
    },
    "percentiles1": {
        "total": "3793",
        "ok": "3761",
        "ko": "3810"
    },
    "percentiles2": {
        "total": "8220",
        "ok": "10200",
        "ko": "7580"
    },
    "percentiles3": {
        "total": "17538",
        "ok": "19751",
        "ko": "17195"
    },
    "percentiles4": {
        "total": "21498",
        "ok": "21974",
        "ko": "18499"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 8,
        "percentage": 1
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 18,
        "percentage": 3
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 208,
        "percentage": 33
    },
    "group4": {
        "name": "failed",
        "count": 396,
        "percentage": 63
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "7.59",
        "ok": "2.819",
        "ko": "4.771"
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
