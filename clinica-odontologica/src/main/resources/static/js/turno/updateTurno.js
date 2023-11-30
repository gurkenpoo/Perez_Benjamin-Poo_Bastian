window.addEventListener("load", function () {
  //Buscamos y obtenemos el formulario donde estan
  //los datos que el usuario pudo haber modificado del paciente
  const formulario = document.querySelector("#update_turnos_form");

  formulario.addEventListener("submit", function (event) {
    event.preventDefault();

    //creamos un JSON que tendrá los datos del paciente
    //a diferencia de un paciente nuevo en este caso enviamos el id
    //para poder identificarlo y modificarlo para no cargarlo como nueva
    const formData = {
      id: document.querySelector("#turnoId").value,
      odontologoId: document.querySelector("#odontologoId").value,
      pacienteId: document.querySelector("#pacienteId").value,
      fechaYHora: `${document.querySelector("#fechaTurno").value} ${
        document.querySelector("#horaTurno").value
      }`,
    };

    console.log(formData);

    //invocamos utilizando la función fetch la API peliculas con el método PUT que modificará
    //la película que enviaremos en formato JSON
    const url = "http://localhost:8081/turnos/actualizar";
    const settings = {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    };

    fetch(url, settings)
      .then((response) => {
        console.log(response);
        if (!response.ok) {
          throw new Error("Error al actualizar el turno");
        }
        return response.json();
      })
      .then((data) => {
        console.log(data);
        mostrarModal("Turno actualizado con exito");
        document.querySelector("#form_update").classList.remove("form-body");
        document.querySelector("#form_update").classList.add("form-body-hide");
        setTimeout(() => {
          window.location.reload();
        }, 2000);
      })
      .catch((error) => {
        mostrarModal(error);
      });
  });
});

//Es la funcion que se invoca cuando se hace click sobre el id de una pelicula del listado
//se encarga de llenar el formulario con los datos de la pelicula
//que se desea modificar
function findBy(id) {
  const url = "http://localhost:8081/turnos/buscar" + "/" + id;
  const settings = {
    method: "GET",
  };
  fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
      let turno = data;
      let fecha = turno.fechaYHora.substr(0, 10);
      let hora = turno.fechaYHora.substr(11, 5);
      document.querySelector("#turnoId").value = turno.id;
      document.querySelector("#odontologoId").value = turno.odontologo_id;
      document.querySelector("#pacienteId").value = turno.paciente_id;
      document.querySelector("#fechaTurno").value = fecha;
      document.querySelector("#horaTurno").value = hora;

      //el formulario por default esta oculto y al editar se habilita
      document.querySelector("#form_update").classList.remove("form-body-hide");
      document.querySelector("#form_update").classList.add("form-body");
    })
    .catch((error) => {
      alert("Error: " + error);
    });
}

function mostrarModal(mensaje) {
  // Función para mostrar un modal
  // Selecciona el modal
  const modal = document.getElementById("miModal");

  // Actualiza el mensaje en el modal
  const modalMensaje = modal.querySelector(".modal-body");
  modalMensaje.textContent = mensaje;

  // Muestra el modal
  const miModal = new bootstrap.Modal(modal);
  miModal.show();
}
