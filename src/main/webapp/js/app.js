$(document).ready(() => {
    let ticketTypeMap = {};
    let tourScheduleMap = {};
    let bookingDTO = {};

    $.get( "http://localhost:8080/api/museum", function( response ) {
        bookingDTO["museum"] = response;
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
        bookingDTO["ticket"] = {
            "ticketType": ticketTypeMap[ticketTypeVal]
        }
    });

    $('#quantityId').change(function() {
        bookingDTO["ticket"]["quantity"] = $('#quantityId').val();
    });

    $('#tourScheduleListId').change(function() {
        let tourScheduleVal = $('#tourScheduleListId').val();
        bookingDTO["tourSchedule"] = tourScheduleMap[tourScheduleVal];
    });

    $('#customerNameId').change(function() {
        bookingDTO["customerName"] = $('#customerNameId').val();
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
                    data: JSON.stringify(bookingDTO)
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

        displayAllBookings.DataTable( {
            ajax: {
                "url": "http://localhost:8080/api/booking",
                "dataSrc": ""
            },
            columns: [
                { data: 'ref', title: "Reference", width: "15%" },
                { data: 'customerName', title: "Customer Name", width: "20%" },
                { data: 'ticketType', title: "Ticket Type", width: "15%" },
                { data: 'ticketQuantity', title: "Ticket No", width: "15%" },
                { data: 'scheduleStartDate', title: "Start Time", width: "15%" },
                { data: 'price', title: "Price", width: "15%" },
                { data: 'id', title: "Actions", width: "5%" }
            ],

            columnDefs: [ {
                "targets": 6,
                "data": "id",
                "render": function ( bookingId ) {
                    return "<i class='fa fa-trash' onclick='deleteBooking(" + bookingId + ")'></i>";
                }
            } ]
        });
    }
});
function deleteBooking(bookingId){
    $.ajax("http://localhost:8080/api/booking/" + bookingId, {
        method: "DELETE",
        headers: {'Content-Type': 'application/json'},
    }).then(response => {
        $('#displayAllBookings').DataTable().ajax.reload();
    })
}
