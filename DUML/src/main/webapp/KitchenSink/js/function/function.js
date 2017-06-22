/**
 * Created by Billy on 02/06/2017.
 */
function f_OpenModal() {

    modal.style.display = "block";

    $("#div_empresas1").html('');
    $("#div_diagramas").html('');

    $.ajax({
        url : 'obtenerEmpresa',
        data: {'opcion':1},
        type : 'POST',
        success : function(response) {
            console.log(response);
            //$("#empresas").append(response);
            $("#div_empresas1").html(response);

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
    $("#div_empresas2").html('');
    var name=$("#nameDiagram").val('');

    $.ajax({
        url : 'obtenerEmpresa',
        data: {'opcion':2},
        type : 'POST',
        success : function(response) {
            console.log(response);
            //$("#empresas").append(response);
            $("#div_empresas2").html(response);

        },

        error : function(xhr, status) {
            alert('Disculpe, existió un problema');
        },

        complete : function(xhr, status) {
            console.log('Petición realizada');
        }
    });

}




function f_obtenerDiagramas() {
    var empresas = $("#empresas").val();

    if(empresas==''){
        return;
    }
    $.ajax({
        url : 'ObtenerDiagrama',
        data : {"id_empresa":empresas} ,
        type : 'POST',
        success : function(response) {
            /*console.log(response);
            app.graph.fromJSON(JSON.parse(response));
*/
            //$("#diagramas").append(response);
            $("#div_diagramas").html(response);

        },

        error : function(xhr, status) {
            alert('Disculpe, existió un problema');
        },

        complete : function(xhr, status) {
            alert('Petición realizada');
        }
    });
}



function f_leerDiagrama() {
    var empresas = $("#empresas").val();
    var diagrama = $("#diagramas").val();

    if(empresas=='' || diagrama==''){
        return;
    }
    $.ajax({
        url : 'LeerDiagrama',
        data : {"id_empresa":empresas,"id_diagrama":diagrama} ,
        type : 'POST',
        success : function(response) {
            console.log(response);
             app.graph.fromJSON(JSON.parse(response));
            $("#div_empresas1").html('');
            $("#div_diagramas").html('');
            modal.style.display = "none";


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
    var id_empresa=$("#empresas").val();


    if(name=='' || name==null){
        alert("Favor de escribir un nombre para el diagrama");
        return;
    }


    if(id_empresa=='' || id_empresa==null){
        alert("Favor de seleccionar una empresa");
        return;
    }

    $.ajax({
        url : 'GuardarDiagrama',
        data : {"datos":JSON.stringify(aux), "nombre":name,"id_empresa":id_empresa} ,
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