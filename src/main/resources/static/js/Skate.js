function traerInformacionSkate() {
    
    $.ajax({
        url: 'Http://localhost:8080/api/Skate/all',
        type: "GET",
        datatype: "JSON",
        success: function (respuesta) {
            pintarRespuestaSkate(respuesta);
        }
    }
    );
}

function pintarRespuestaSkate(items) {

    $("#resultadoSkate").empty();

    let myTable = "<table border=1px dotted>";
    myTable += "<tr><th>Id</th><th>Brand Skate</th><th>Year Skate</th><th>Name Skate</th><th>Description Skate</th><th>Id Category</th><th>Category Name</th><th>Category Description</th><th>Message</th><th>Reservation</th></tr>";
    for (i = 0; i < items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].id + "</td>";
        myTable += "<td>" + items[i].brand + "</td>";
        myTable += "<td>" + items[i].year + "</td>";
        myTable += "<td>" + items[i].name + "</td>";     
        myTable += "<td>" + items[i].description + "</td>";
        myTable += "<td>" + items[i].category.id + "</td>";
        myTable += "<td>" + items[i].category.name + "</td>";
        myTable += "<td>" + items[i].category.description + "</td>";
        myTable += "<td>" + items[i].messages + "</td>";
        myTable += "<td>" + items[i].reservations + "</td>";              
        myTable += "</tr>";
    }
    myTable += "</table>";
    $("#resultadoSkate").append(myTable);
}

function agregarInformacionSkate() {

    $("#resultadoSkate").empty();
    let myData = { 
        brand: $("#brandSkate").val(),
        year: $("#yearSkate").val(),
        name: $("#nameSkate").val(), 
        description: $("#descripcionSkate").val(),
        category: {id:$("#category").val()}
    };

    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: 'Http://localhost:8080/api/Skate/save',
        type: 'POST',
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function (respuesta) {
            traerInformacionSkate();
            limpiarSkate();
            alert("Inserción exitosa");
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria,' + xhr.status);
        }
    }
    );
}

function limpiarSkate() {
    $("#brandSkate").val("");
    $("#yearSkate").val("");
    $("#nameSkate").val(""); 
    $("#descripcionSkate").val("");
    $("#category").val("");
}