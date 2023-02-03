//const BASE_URL = 'Http://129.146.30.138:81'
//const BASE_URL = 'Http://localhost:8080'

function guardarInformacionAdmin(){

    $("#resultadoAdmin").empty();
    let myData ={email:$("#emailAdmin").val(),password:$("#passwordAdmin").val(),name:$("#nameAdmin").val(),}
    let dataToSend = JSON.stringify(myData);

    $.ajax ({
        url:  'Http://localhost:8080/api/Admin/save',
        type: 'POST',
        data:  dataToSend,
        datatype: "JSON",
        contentType: 'application/json',
        success: function(respuesta){
        console.log(respuesta);
        alert("Inserción exitosa");
        },
        error: function(xhr,status){
        alert('Operacion no satisfactoria,'+ xhr.status );
            }
        }
    );
}

function traerInformacionAdmin(){

    $.ajax({
            url: 'Http://localhost:8080/api/Admin/all',
            type:"GET",
            datatype:"JSON",
            success:function(respuesta){
            pintarRespuestaadmin(respuesta); 
                         
            }
                                 
        }
               
    );
}

function pintarRespuestaAdmin(items){

    $("#resultadoAdmin").empty();

    let myTable="<table border=5px solid>";
   myTable += "<tr><th>IdAdmin</th><th>Email</th><th>Password</th><th>name</th><th>Description</th></tr>";
   for(i=0;i<items.length;i++){
       myTable+="<tr>";
       myTable+="<td>"+items[i].idAdmin+"</td>";
       myTable+="<td>"+items[i].email+"</td>";
       myTable+="<td>"+items[i].password+"</td>";
       myTable+="<td>"+items[i].name+"</td>";              
       //myTable+="<td>"+items[i].category.id +"</td>";                
       //myTable+="<td>"+items[i].category.name +"</td>";                
       //myTable+="<td>"+items[i].category.description +"</td>";                
       //myTable+="<td>"+items[i].message +"</td>";                        
      //myTable+="<td>"+items[i].reservation+"</td>";                
       // myTable+="<td><button onclick='borrarElemento("+items[i].id+")'>Borrar</button>";
       //myTable+="<td><button onclick='borrarSkate("+items[i].id+")'>Borrar</button>";
       //myTable+="<td><button onclick='actualizarSkate("+items[i].id+")'>Actualizar</button>";
       myTable+="</tr>";
       
   }
   myTable +="</table>";
   $("#resultadoAdmin").append(myTable);
}