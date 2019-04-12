var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1860",
        "ok": "592",
        "ko": "1268"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "235"
    },
    "maxResponseTime": {
        "total": "55341",
        "ok": "54544",
        "ko": "55341"
    },
    "meanResponseTime": {
        "total": "18104",
        "ok": "19276",
        "ko": "17557"
    },
    "standardDeviation": {
        "total": "12556",
        "ok": "16985",
        "ko": "9779"
    },
    "percentiles1": {
        "total": "20006",
        "ok": "16081",
        "ko": "20006"
    },
    "percentiles2": {
        "total": "20010",
        "ok": "32980",
        "ko": "20009"
    },
    "percentiles3": {
        "total": "44551",
        "ok": "47046",
        "ko": "34845"
    },
    "percentiles4": {
        "total": "51059",
        "ok": "53427",
        "ko": "48430"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 59,
        "percentage": 3
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 36,
        "percentage": 2
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 497,
        "percentage": 27
    },
    "group4": {
        "name": "failed",
        "count": 1268,
        "percentage": 68
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "13.881",
        "ok": "4.418",
        "ko": "9.463"
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
        "total": "930",
        "ok": "395",
        "ko": "535"
    },
    "minResponseTime": {
        "total": "2",
        "ok": "2",
        "ko": "354"
    },
    "maxResponseTime": {
        "total": "54544",
        "ok": "54544",
        "ko": "20018"
    },
    "meanResponseTime": {
        "total": "20725",
        "ok": "21987",
        "ko": "19792"
    },
    "standardDeviation": {
        "total": "9759",
        "ok": "14724",
        "ko": "1853"
    },
    "percentiles1": {
        "total": "20007",
        "ok": "22855",
        "ko": "20007"
    },
    "percentiles2": {
        "total": "20011",
        "ok": "32813",
        "ko": "20009"
    },
    "percentiles3": {
        "total": "41730",
        "ok": "44775",
        "ko": "20011"
    },
    "percentiles4": {
        "total": "46727",
        "ok": "51147",
        "ko": "20012"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 31,
        "percentage": 3
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 9,
        "percentage": 1
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 355,
        "percentage": 38
    },
    "group4": {
        "name": "failed",
        "count": 535,
        "percentage": 58
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "6.94",
        "ok": "2.948",
        "ko": "3.993"
    }
}
    },"req_plain-ac793": {
        type: "REQUEST",
        name: "plain",
path: "plain",
pathFormatted: "req_plain-ac793",
stats: {
    "name": "plain",
    "numberOfRequests": {
        "total": "930",
        "ok": "197",
        "ko": "733"
    },
    "minResponseTime": {
        "total": "235",
        "ok": "538",
        "ko": "235"
    },
    "maxResponseTime": {
        "total": "55341",
        "ok": "54445",
        "ko": "55341"
    },
    "meanResponseTime": {
        "total": "15484",
        "ok": "13840",
        "ko": "15926"
    },
    "standardDeviation": {
        "total": "14365",
        "ok": "19697",
        "ko": "12515"
    },
    "percentiles1": {
        "total": "20005",
        "ok": "2087",
        "ko": "20006"
    },
    "percentiles2": {
        "total": "20009",
        "ok": "35517",
        "ko": "20009"
    },
    "percentiles3": {
        "total": "46493",
        "ok": "51036",
        "ko": "43823"
    },
    "percentiles4": {
        "total": "52111",
        "ok": "53570",
        "ko": "49002"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 28,
        "percentage": 3
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 27,
        "percentage": 3
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 142,
        "percentage": 15
    },
    "group4": {
        "name": "failed",
        "count": 733,
        "percentage": 79
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "6.94",
        "ok": "1.47",
        "ko": "5.47"
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
