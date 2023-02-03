function traerInformacionScore(){
    $.ajax({
            url: BASE_URL +'/api/Score/all',
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
            pintarRespuestaScore(respuesta); 
                         
            }
                                 
        }
               
    );
}

function pintarRespuestaScore(items){

    $("#resultadoScore").empty();

    let myTable="<table border=5px solid>";
    myTable += "<tr><th>IdScore</th><th>MessageText</th><th>Stars</th></tr>";
   for(i=0;i<items.length;i++){
       myTable+="<tr>";
       myTable+="<td>"+items[i].idScore+"</td>";
       myTable+="<td>"+items[i].messageText+"</td>"; 
       myTable+="<td>"+items[i].stars+"</td>";                         
        //myTable+="<td><button onclick='borrarCategory("+items[i].id+")'>Borrar</button>";
       //myTable+="<td><button onclick='actualizarCategory("+items[i].id+")'>Actualizar</button>";
       myTable+="</tr>";
       
   }
   myTable +="</table>";
   $("#resultadoScore").append(myTable);

}
function guardarInformacionScore(){

    $("#resultadoScore").empty();
    let myData ={messageText:$("#messageText").val(), stars:$("#stars").val()}
    let dataToSend = JSON.stringify(myData);

    $.ajax ({
        url: BASE_URL +'/api/Score/save',
        type: 'POST',
        data:  dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function(respuesta){
        alert("Inserción exitosa");
        },
        error: function(xhr,status){
        alert('Operacion no satisfactoria,'+ xhr.status );
            }
        }
    );
}/*  let messaget ="";
        var item = items[i]
        for (s = 0; s <item.messages.length; s++)
        {messaget +=item.messages[s].messagesText+" ";}
        // messaget = items[i].messages.join(",");*/