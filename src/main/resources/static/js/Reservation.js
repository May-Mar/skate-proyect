function guardarInformacionReservation() {

    $("#resultadoReservation").empty();
    let myData = {
        startDate: $("#startDate").val(),
        devolutionDate: $("#endDate").val(),
        client: { idClient: $("#idClientR").val() },
        skate: { id: $("#idSkateR").val() }
    };
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: 'Http://localhost:8080/api/Reservation/save',
        type: 'POST',
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function (respuesta) {
            limpiarReservation();
            alert("Inserción exitosa");
            traerInformacionReservation();
            },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria,' + xhr.status);
        }
    }
    );
}

function traerInformacionReservation() {
    $.ajax({
        url: 'Http://localhost:8080/api/Reservation/all',
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            pintarRespuestaReservation(respuesta);

        }

    }

    );
}

function pintarRespuestaReservation(items) {

    $("#resultadoReservation").empty();

    let myTable = "<table border=1px solid>";
    myTable += "<tr><th>IdReservation</th><th>StartDate</th><th>EndDate</th><th>Status</th><th>Id Skate</th><th>Name Skate</th><th>Id Client</th><th>Name Client</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].idReservation + "</td>";
        myTable += "<td>" + items[i].startDate + "</td>";
        myTable += "<td>" + items[i].devolutionDate + "</td>";
        myTable += "<td>" + items[i].status + "</td>";
        myTable += "<td>" + items[i].skate.id + "</td>";
        myTable += "<td>" + items[i].skate.name + "</td>";
        myTable += "<td>" + items[i].client.idClient + "</td>";
        myTable += "<td>" + items[i].client.name + "</td>";
        myTable += "</tr>";

    }
    myTable += "</table>";
    $("#resultadoReservation").append(myTable);

}
function limpiarReservation() {
    $("#startDate").val("");
    $("#endDate").val("");
    $("#idClientR").val("");
    $("#idSkateR").val("");
}

function consultarTopClients() {
    $.ajax({
            url: "http://localhost:8080/api/Reservation/report-clients",
            type: "GET",
            datatype: "JSON",
            success: function (respuesta) {
                pintarTopclients(respuesta);

            },
            error: function (xhr, status) {
                alert('Operacion no satisfactoria,' + xhr.status);
            }


        }

    );
}

function pintarTopclients(items) {

    $("#resultadoTopClients").empty();

    let myTable = "<table border=1px solid>";
    myTable += "<tr><th>Id Client</th><th>Name Client</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].client.idClient + "</td>";
        myTable += "<td>" + items[i].client.name + "</td>";       
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultadoTopClients").append(myTable);
}