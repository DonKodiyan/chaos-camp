var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "930",
        "ok": "426",
        "ko": "504"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "198",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "18912",
        "ok": "18912",
        "ko": "6559"
    },
    "meanResponseTime": {
        "total": "2485",
        "ok": "4190",
        "ko": "1043"
    },
    "standardDeviation": {
        "total": "3603",
        "ok": "4441",
        "ko": "1659"
    },
    "percentiles1": {
        "total": "840",
        "ok": "2829",
        "ko": "10"
    },
    "percentiles2": {
        "total": "3635",
        "ok": "5821",
        "ko": "1781"
    },
    "percentiles3": {
        "total": "10252",
        "ok": "14715",
        "ko": "4742"
    },
    "percentiles4": {
        "total": "16964",
        "ok": "18086",
        "ko": "6104"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 125,
        "percentage": 13
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 13,
        "percentage": 1
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 288,
        "percentage": 31
    },
    "group4": {
        "name": "failed",
        "count": 504,
        "percentage": 54
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "11.772",
        "ok": "5.392",
        "ko": "6.38"
    }
},
contents: {
"req_circuit-breaker-dc071": {
        type: "REQUEST",
        name: "circuit-breaker",
path: "circuit-breaker",
pathFormatted: "req_circuit-breaker-dc071",
stats: {
    "name": "circuit-breaker",
    "numberOfRequests": {
        "total": "930",
        "ok": "426",
        "ko": "504"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "198",
        "ko": "3"
    },
    "maxResponseTime": {
        "total": "18912",
        "ok": "18912",
        "ko": "6559"
    },
    "meanResponseTime": {
        "total": "2485",
        "ok": "4190",
        "ko": "1043"
    },
    "standardDeviation": {
        "total": "3603",
        "ok": "4441",
        "ko": "1659"
    },
    "percentiles1": {
        "total": "840",
        "ok": "2829",
        "ko": "10"
    },
    "percentiles2": {
        "total": "3635",
        "ok": "5821",
        "ko": "1781"
    },
    "percentiles3": {
        "total": "10252",
        "ok": "14715",
        "ko": "4742"
    },
    "percentiles4": {
        "total": "16964",
        "ok": "18086",
        "ko": "6104"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 125,
        "percentage": 13
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 13,
        "percentage": 1
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 288,
        "percentage": 31
    },
    "group4": {
        "name": "failed",
        "count": 504,
        "percentage": 54
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "11.772",
        "ok": "5.392",
        "ko": "6.38"
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
