/**
 * Created by Billy on 02/06/2017.
 */
function f_abrir() {


    modal.style.display = "block";

        $.ajax({
            url : 'LeerDiagrama',
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

}


function f_guardar() {

    var aux=app.graph.toJSON();
    $.ajax({
        url : 'GuardarDiagrama',
        data : {"datos":JSON.stringify(aux)} ,
        type : 'POST',
        success : function(json) {
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