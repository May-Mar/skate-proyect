function guardarInformacionClient() {

    $("#resultadoClient").empty();
    let myData = { email: $("#emailClient").val(),
        password: $("#passwordClient").val(),
        name: $("#nameClient").val(),
        age: $("#ageClient").val() }

    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: 'Http://localhost:8080/api/Client/save',
        type: 'POST',
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function (respuesta) {
            limpiarClient();
            traerInformacionClient();
            alert("Inserción exitosa");
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria,' + xhr.status);
        }
    }
    );
}

function traerInformacionClient() {

    $.ajax({
        url: 'Http://localhost:8080/api/Client/all',
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            pintarRespuestaClient(respuesta);

        }

    }

    );
}

function pintarRespuestaClient(items) {

    $("#resultadoClient").empty();

    let myTable = "<table border=1px solid>";
    myTable += "<tr><th>IdClient</th><th>Email</th><th>Password</th><th>Name</th><th>Age</th><th>Message</th><th>Reservation</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].idClient + "</td>";
        myTable += "<td>" + items[i].email + "</td>";
        myTable += "<td>" + items[i].password + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].age + "</td>";               
        myTable += "<td>" + items[i].messages + "</td>";
        myTable += "<td>" + items[i].reservations + "</td>";
        //myTable+="<td><button onclick='borrarElement("+items[i].id+")'>Borrar</button>";
        myTable += "</tr>";

    }
    myTable += "</table>";
    $("#resultadoClient").append(myTable);
}

function limpiarClient() {
    $("#emailClient").val("");
    $("#passwordClient").val("");
    $("#nameClient").val("");
    $("#ageClient").val("");    
}