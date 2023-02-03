function guardarInformacionMessage() {

    $("#resultadoSkate").empty();
    let myData = { 
        messageText: $("#messageText").val(), 
        skate: {id:$("#idSkateM").val()},
        client: {idClient: $("#idClientM").val()}
        };

    let dataToSend = JSON.stringify(myData);

    $.ajax({
        url: 'Http://localhost:8080/api/Message/save',
        type: 'POST',
        data: dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function (respuesta) {
            limpiarMassage();
            traerInformacionMessage();
            alert("Inserción exitosa");
        },
        error: function (xhr, status) {
            alert('Operacion no satisfactoria,' + xhr.status);
        }
    }
    );
}

function traerInformacionMessage(){
    $.ajax({
            url: 'Http://localhost:8080/api/Message/all',
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
                console.log("Hola");
            pintarRespuestaMessage(respuesta);                       
            }
                                 
        }
               
    );
}

function pintarRespuestaMessage(items){

    $("#resultadoMessage").empty();

    let myTable="<table border=1px solid>";
    myTable += "<tr><th>IdMessage</th><th>MessageText</th><th>Id Skate</th><th>Name Skate</th><th>Id Client</th><th>Name Client</th></tr>";
   for(i=0;i<items.length;i++){
       myTable += "<tr>";
       myTable += "<td>" + items[i].idMessage + "</td>";
       myTable += "<td>" + items[i].messageText + "</td>";
       myTable += "<td>" + items[i].skate.id + "</td>";
       myTable += "<td>" + items[i].skate.name + "</td>";
       myTable += "<td>" + items[i].client.idClient + "</td>";
       myTable += "<td>" + items[i].client.name + "</td>";                          
       myTable+="</tr>";
       
   }
   myTable +="</table>";
   console.log(myTable);
   $("#resultadoMessage").append(myTable);

}

function limpiarMassage() {
    $("#messageText").val("");
    $("#idSkateM").val("");
    $("#idClientM").val("");
}