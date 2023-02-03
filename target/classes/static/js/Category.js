function guardarInformacionCategory() {

    $("#resultadoCategory").empty();
    let myData = { name: $("#nameCategory").val(), description: $("#descripcionCategory").val() }
    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: 'http://localhost:8080/api/Category/save',
        type: 'POST',
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function (respuesta) {
            limpiarCategory();
            traerInformacionCategory();
            alert("Inserción exitosa");
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria,' + xhr.status);
        }
    }
    );
}

function traerInformacionCategory() {
    
    $.ajax({
        url: 'Http://localhost:8080/api/Category/all',
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            pintarRespuestaCategory(respuesta);
        }
    }
    );
}

function pintarRespuestaCategory(items) {

    $("#resultadoCategory").empty();

    let myTable = "<table border=1px solid>";
    myTable += "<tr><th>Id</th><th>Name</th><th>Description</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].id + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].description + "</td>";
        myTable += "<td><button onclick='borrarCategory(" + items[i].id + ")'><b>Delete</button>";
        myTable += "<td><button onclick='actualizarCategory(" + items[i].id + ")'><b>Update</button>";
        myTable += "</tr>";

    }
    myTable += "</table>";
    $("#resultadoCategory").append(myTable);
}

function actualizarCategory(idElemento) {

    $("#resultadoCategory").empty();

    let myData = { id: idElemento, 
        name: $("#nameCategory").val(), 
        description: $("#descripcionCategory").val() }

    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: 'Http://localhost:8080/api/Category/update',
        type: 'PUT',
        data: dataToSend,
        datatype: 'JSON',
        contentType: 'application/json',
        success: function (respuesta) {
            traerInformacionCategory();
            limpiarCategory();
            alert("Actualizacion exitosa");
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria,' + xhr.status);
        }
    }
    );
}

function borrarCategory(idElemento) {

    $.ajax({
        url: 'Http://localhost:8080/api/Category/' + idElemento,
        type: 'DELETE',
        datatype: "JSON",
        success: function (respuesta) {
            alert("Borrado exitoso");
            traerInformacionCategory();
            $("#resultado").empty();
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria,' + xhr.status);
        }
    }
    );
}

function limpiarCategory() {
    $("#nameCategory").val("");
    $("#descripcionCategory").val("");
}