$(document).ready(() => {
    let ticketTypeMap = {};
    let tourScheduleMap = {};
    let data = {
        "tickets":[
        ]
    };

    $.get( "http://localhost:8080/api/museum", function( response ) {
        data["museum"] = response;
    });

    $.get( "http://localhost:8080/api/museum/ticketTypes", function( response ) {
        console.log(response);
        $.each(response, function( index, value ) {
            ticketTypeMap[value.id] = value;
            $('#ticketTypeListId').append('<option value=' + value.id + '>' + value.name + "-" + value.price + '</option>');
        });
    });


    $.get( "http://localhost:8080/api/museum/tourSchedules", function( response ) {
        console.log(response);
        $.each(response, function( index, value ) {
            tourScheduleMap[value.id] = value;
            $('#tourScheduleListId').append('<option value=' + value.id + '>' + value.startDate + '</option>');
        });
    });

    $('#ticketTypeListId').change(function() {
        let ticketTypeVal = $('#ticketTypeListId').val();
        data["tickets"].push({
            "ticketType": ticketTypeMap[ticketTypeVal]
        });
    });

    $('#quantityId').change(function() {
        data["tickets"][0]["quantity"] = $('#quantityId').val();
    });

    $('#tourScheduleListId').change(function() {
        let tourScheduleVal = $('#tourScheduleListId').val();
        data["tourSchedule"] = tourScheduleMap[tourScheduleVal];
    });

    $('#customerNameId').change(function() {
        data["customerName"] = $('#customerNameId').val();
    });


    $('#submitButton').click(function() {
        console.log(data);
        fetch("http://localhost:8080/api/museum/booking", {
            method: "POST",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(data)
        }).then(res => {
            console.log("Request complete! response:", res);
        });
    })
});