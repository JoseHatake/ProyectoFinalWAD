/**
 * Created by Billy on 02/06/2017.
 */
function f_OpenModal() {

    modal.style.display = "block";
    $.ajax({
        url : 'obtenerEmpresa',
        type : 'POST',
        success : function(response) {
            console.log(response);
            $("#empresas").append(response);

        },

        error : function(xhr, status) {
            alert('Disculpe, existió un problema');
        },

        complete : function(xhr, status) {
            console.log('Petición realizada');
        }
    });



    /*
            $.ajax({
                url : 'leerDiagramas',
                type : 'POST',
                success : function(response) {
                    console.log(response);
                            app.graph.fromJSON(JSON.parse(response));

                    alert("Exitoso");
                },

                error : function(xhr, status) {
                    alert('Disculpe, existió un problema');
                },

                complete : function(xhr, status) {
                    alert('Petición realizada');
                }
            });

    $("#diagrams").html('<p>Not found diagrams</p>');
    */
}


function f_SaveModal() {
    modalSave.style.display= "block";


}




function f_obtenerDiagramas() {
    var empresas = $("#empresas").val();

    if(empresas==''){
        return;
    }
    $.ajax({
        url : 'leerDiagramas',
        data : {"id_empresa":empresas} ,
        type : 'POST',
        success : function(response) {
            console.log(response);
            app.graph.fromJSON(JSON.parse(response));

            alert("Exitoso");
        },

        error : function(xhr, status) {
            alert('Disculpe, existió un problema');
        },

        complete : function(xhr, status) {
            alert('Petición realizada');
        }
    });






}

function f_guardar() {
    var aux=app.graph.toJSON();


    var name=$("#nameDiagram").val();

    if(name=='' || name==null){
        alert("Favor de escribir un nombre para el diagrama");
        return;
    }

    $.ajax({
        url : 'GuardarDiagrama',
        data : {"datos":JSON.stringify(aux), "nombre":name} ,
        type : 'POST',
        success : function(json) {
            alert("El diagrama se guardo exitosamente");
            modalSave.style.display = "none";

        },

        error : function(xhr, status) {
            alert('Disculpe, existió un problema');
        },

        complete : function(xhr, status) {
            alert('Petición realizada');
        }
    });
}