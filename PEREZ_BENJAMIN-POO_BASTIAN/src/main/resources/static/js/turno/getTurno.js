window.addEventListener("load", function () {
  (function () {
    //con fetch invocamos a la API de turnos con el método GET
    //nos devolverá un JSON con una colección de turnos
    const url = "http://localhost:8081/turnos/listar";
    const settings = {
      method: "GET",
    };

    fetch(url, settings)
      .then((response) => response.json())
      .then((data) => {
        //recorremos la colección de turnos del JSON
        for (turno of data) {
          //por cada turno armaremos una fila de la tabla
          //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos el turno
          var table = document.getElementById("turnoTable");
          var turnoRow = table.insertRow();
          let tr_id = "tr_" + turno.id;
          turnoRow.id = tr_id;

          //por cada turno creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
          //dicho boton invocara a la funcion de java script deleteByKey que se encargará
          //de llamar a la API para eliminar un turno
          let deleteButton =
            "<button" +
            " id=" +
            '"' +
            "btn_delete_" +
            turno.id +
            '"' +
            ' type="button" onclick="deleteBy(' +
            turno.id +
            ')">' +
            '<i class="fas fa-trash-alt" id="delete"></i>' +
            "</button>";

          //por cada turno creamos un boton que muestra el id y que al hacerle clic invocará
          //a la función de java script findBy que se encargará de buscar el turno que queremos
          //modificar y mostrar los datos del mismo en un formulario.
          let updateButton =
            "<button" +
            " id=" +
            '"' +
            "btn_id_" +
            turno.id +
            '"' +
            ' type="button" onclick="findBy(' +
            turno.id +
            ')">' +
            '<i class="fas fa-pen-alt" id="edit"></i>' +
            "</button>";

          //armamos cada columna de la fila
          //luego los datos del turno
          //como ultimas columnas los botonnes editar y eliminar
          turnoRow.innerHTML =
            "<td>" +
            turno.id +
            "</td>" +
            "<td>" +
            turno.fechaYHora +
            "</td>" +
            "<td>" +
            turno.odontologo_id +
            "</td>" +
            "<td>" +
            turno.nombreOdontologo +
            "</td>" +
            "<td>" +
            turno.paciente_id +
            "</td>" +
            "<td>" +
            turno.nombrePaciente +
            "</td>" +
            "<td>" +
            updateButton +
            "</td>" +
            "<td>" +
            deleteButton +
            "</td>";
        }
      });
  })(function () {
    let pathname = window.location.pathname;
    if (pathname == "/pacienteList.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
    }
  });
});
