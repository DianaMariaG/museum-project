$(document).ready(() => {
    let ticketTypeMap = {};
    let tourScheduleMap = {};
    let data = {};

    $.get( "http://localhost:8080/api/museum", function( response ) {
        data["museum"] = response;
        $('#museumName').text(response.name);
        $('#startTime').text(response.openTime);
        $('#endTime').text(response.closeTime);
    });

    $.get( "http://localhost:8080/api/museum/ticketTypes", function( response ) {
        $.each(response, function( index, value ) {
            ticketTypeMap[value.id] = value;
            $('#ticketTypeListId').append('<option value=' + value.id + '>' + value.name + "-" + value.price + '</option>');
        });
    });


    $.get("http://localhost:8080/api/museum/tourSchedules", function( response ) {
        $.each(response, function( index, value ) {
            tourScheduleMap[value.id] = value;
            $('#tourScheduleListId').append('<option value=' + value.id + '>' + value.startDate + '</option>');
        });
    });

    $('#ticketTypeListId').change(function() {
        let ticketTypeVal = $('#ticketTypeListId').val();
        data["ticket"] = {
            "ticketType": ticketTypeMap[ticketTypeVal]
        }
    });

    $('#quantityId').change(function() {
        data["ticket"]["quantity"] = $('#quantityId').val();
    });

    $('#tourScheduleListId').change(function() {
        let tourScheduleVal = $('#tourScheduleListId').val();
        data["tourSchedule"] = tourScheduleMap[tourScheduleVal];
    });

    $('#customerNameId').change(function() {
        data["customerName"] = $('#customerNameId').val();
    });

    let form = $('.needs-validation')[0]
    if (form) {
        form.addEventListener('submit', function (event) {
            event.preventDefault()
            event.stopPropagation()
            if (form.checkValidity()) {
                $.ajax("http://localhost:8080/api/booking", {
                    method: "POST",
                    headers: {'Content-Type': 'application/json'},
                    data: JSON.stringify(data)
                }).then(booking => {
                    $('#createBooking').hide();
                    $('#customerNameId').val('');
                    $('#quantityId').val('');
                    $('#ticketTypeListId').val('');
                    $('#tourScheduleListId').val('');

                    $('#displayBooking').show();
                    $('#displayCustomerName').text(booking.customerName);
                    $('#displayTicketType').text(booking.ticket.ticketType.name);
                    $('#displayQuantity').text(booking.ticket.quantity);
                    $('#displayTourSchedule').text(booking.tourSchedule.startDate);

                });
            } else {
                form.classList.add('was-validated');
            }
        });
    }

    let displayAllBookings = $('#displayAllBookings');
    if (displayAllBookings && Object.keys(displayAllBookings).length !== 0) {


        function deleteBooking(){
            alert("delete");
        }
        let that = this;
        displayAllBookings.DataTable( {
            ajax: {
                "url": "http://localhost:8080/api/booking",
                "dataSrc": ""
            },
            columns: [
                { data: 'ref', title: "Reference" },
                { data: 'customerName', title: "Customer Name"  },
                { data: 'ticketType', title: "Ticket Type" },
                { data: 'ticketQuantity', title: "Number of tickets" },
                { data: 'scheduleStartDate', title: "Tour Start Time" },
                { data: 'price', title: "Price" },
                { data: 'id', title: "Actions"}
            ],
            columnDefs: [ {
                "targets": 6,
                "data": "id",
                "render": function ( bookingId, type, row, meta ) {
                    return '<i onclick="that.deleteBooking()" ' +
                        'class="fa fa-trash delete-icon"></i>';
                }
            } ]
        });
        $('.delete-icon').click(function () {
            console.log(this);
        });
    }
});