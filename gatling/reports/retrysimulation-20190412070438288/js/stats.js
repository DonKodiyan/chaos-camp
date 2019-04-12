var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "480",
        "ok": "207",
        "ko": "273"
    },
    "minResponseTime": {
        "total": "211",
        "ok": "634",
        "ko": "211"
    },
    "maxResponseTime": {
        "total": "60008",
        "ok": "59848",
        "ko": "60008"
    },
    "meanResponseTime": {
        "total": "30245",
        "ok": "28169",
        "ko": "31820"
    },
    "standardDeviation": {
        "total": "18318",
        "ok": "17905",
        "ko": "18470"
    },
    "percentiles1": {
        "total": "20010",
        "ok": "25831",
        "ko": "20009"
    },
    "percentiles2": {
        "total": "46688",
        "ok": "44213",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60004",
        "ok": "57916",
        "ko": "60004"
    },
    "percentiles4": {
        "total": "60005",
        "ok": "59583",
        "ko": "60005"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 1,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 3,
        "percentage": 1
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 203,
        "percentage": 42
    },
    "group4": {
        "name": "failed",
        "count": 273,
        "percentage": 57
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "4",
        "ok": "1.725",
        "ko": "2.275"
    }
},
contents: {
"req_retry-165e6": {
        type: "REQUEST",
        name: "retry",
path: "retry",
pathFormatted: "req_retry-165e6",
stats: {
    "name": "retry",
    "numberOfRequests": {
        "total": "480",
        "ok": "207",
        "ko": "273"
    },
    "minResponseTime": {
        "total": "211",
        "ok": "634",
        "ko": "211"
    },
    "maxResponseTime": {
        "total": "60008",
        "ok": "59848",
        "ko": "60008"
    },
    "meanResponseTime": {
        "total": "30245",
        "ok": "28169",
        "ko": "31820"
    },
    "standardDeviation": {
        "total": "18318",
        "ok": "17905",
        "ko": "18470"
    },
    "percentiles1": {
        "total": "20010",
        "ok": "25831",
        "ko": "20009"
    },
    "percentiles2": {
        "total": "46688",
        "ok": "44213",
        "ko": "60001"
    },
    "percentiles3": {
        "total": "60004",
        "ok": "57916",
        "ko": "60004"
    },
    "percentiles4": {
        "total": "60005",
        "ok": "59583",
        "ko": "60005"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 1,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 3,
        "percentage": 1
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 203,
        "percentage": 42
    },
    "group4": {
        "name": "failed",
        "count": 273,
        "percentage": 57
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "4",
        "ok": "1.725",
        "ko": "2.275"
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
