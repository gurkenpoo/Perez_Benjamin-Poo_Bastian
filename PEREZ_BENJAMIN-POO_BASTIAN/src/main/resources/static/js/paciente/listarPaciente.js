window.addEventListener("load", function () {
  (function () {
    //con fetch invocamos a la API de pacientes con el método GET
    //nos devolverá un JSON con una colección de pacientes
    const url = "http://localhost:8081/pacientes/listar";
    const settings = {
      method: "GET",
    };

    fetch(url, settings)
      .then((response) => response.json())
      .then((data) => {
        //recorremos la colección de pacientes del JSON
        for (paciente of data) {
          //por cada paciente armaremos una fila de la tabla
          //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la paciente
          var table = document.getElementById("pacienteTable");
          var pacienteRow = table.insertRow();
          let tr_id = "tr_" + paciente.id;
          pacienteRow.id = tr_id;

          //por cada paciente creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
          //dicho boton invocara a la funcion de java script deleteByKey que se encargará
          //de llamar a la API para eliminar una paciente
          let deleteButton =
            "<button" +
            " id=" +
            '"' +
            "btn_delete_" +
            paciente.id +
            '"' +
            ' type="button" onclick="deleteBy(' +
            paciente.id +
            ')">' +
            '<i class="fas fa-trash-alt" id="delete"></i>' +
            "</button>";

          //por cada paciente creamos un boton que muestra el id y que al hacerle clic invocará
          //a la función de java script findBy que se encargará de buscar la paciente que queremos
          //modificar y mostrar los datos de la misma en un formulario.
          let updateButton =
            "<button" +
            " id=" +
            '"' +
            "btn_id_" +
            paciente.id +
            '"' +
            ' type="button" onclick="findBy(' +
            paciente.id +
            ')">' +
            '<i class="fas fa-pen-alt" id="edit"></i>' +
            "</button>";

          //armamos cada columna de la fila
          //como primer columna pondremos el boton modificar
          //luego los datos de la paciente
          //como ultima columna el boton eliminar
          pacienteRow.innerHTML =
            "<td>" +
            paciente.id +
            "</td>" +
            '<td class="td_nombre">' +
            paciente.nombre.toUpperCase() +
            "</td>" +
            '<td class="td_apellido">' +
            paciente.apellido.toUpperCase() +
            "</td>" +
            '<td class="td_dni">' +
            paciente.dni +
            "</td>" +
            '<td class="td_fechaIngreso">' +
            paciente.fechaIngreso +
            "</td>" +
            '<td class="td_calle">' +
            paciente.domicilioSalidaDto.calle +
            "</td>" +
            '<td class="td_numero">' +
            paciente.domicilioSalidaDto.numero +
            "</td>" +
            '<td class="td_localidad">' +
            paciente.domicilioSalidaDto.localidad +
            "</td>" +
            '<td class="td_provincia">' +
            paciente.domicilioSalidaDto.provincia +
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
