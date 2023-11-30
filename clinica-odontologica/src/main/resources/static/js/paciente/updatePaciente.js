window.addEventListener("load", function () {
  //Buscamos y obtenemos el formulario donde estan
  //los datos que el usuario pudo haber modificado del paciente
  const formulario = document.querySelector("#update_pacientes_form");

  formulario.addEventListener("submit", function (event) {
    event.preventDefault();

    //creamos un JSON que tendrá los datos del paciente
    //a diferencia de un paciente nuevo en este caso enviamos el id
    //para poder identificarlo y modificarlo para no cargarlo como nuevo
    const formData = {
      id: document.querySelector("#paciente_id").value,
      nombre: document.querySelector("#nombrePaciente").value,
      apellido: document.querySelector("#apellidoPaciente").value,
      dni: document.querySelector("#pacienteDni").value,
      fechaIngreso: document.querySelector("#fechaIngreso").value,

      domicilioEntradaDto: {
        id: document.querySelector("#domicilio_id").value,
        calle: document.querySelector("#calleDomicilio").value,
        numero: document.querySelector("#numeroDomicilio").value,
        localidad: document.querySelector("#localidadDomicilio").value,
        provincia: document.querySelector("#provinciaDomicilio").value,
      },
    };

    console.log(formData);

    //invocamos utilizando la función fetch la API con el método PUT que modificará
    //el paciente que enviaremos en formato JSON
    const url = "http://localhost:8081/pacientes/actualizar";
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
          throw new Error("Error al actualizar el odontologo");
        }
        return response.json();
      })
      .then((data) => {
        console.log(data);
        mostrarModal("Paciente actualizado con exito");
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

//Es la funcion que se invoca cuando se hace click sobre el botón modificar
//se encarga de llenar el formulario con los datos del paciente
//que se desea modificar
function findBy(id) {
  const url = "http://localhost:8081/pacientes/buscar" + "/" + id;
  const settings = {
    method: "GET",
  };
  fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
      let paciente = data;
      document.querySelector("#paciente_id").value = paciente.id;
      document.querySelector("#nombrePaciente").value = paciente.nombre;
      document.querySelector("#apellidoPaciente").value = paciente.apellido;
      document.querySelector("#pacienteDni").value = paciente.dni;

      document.querySelector("#fechaIngreso").value = paciente.fechaIngreso;
      document.querySelector("#domicilio_id").value =
        paciente.domicilioSalidaDto.id;
      document.querySelector("#calleDomicilio").value =
        paciente.domicilioSalidaDto.calle;
      document.querySelector("#numeroDomicilio").value =
        paciente.domicilioSalidaDto.numero;
      document.querySelector("#localidadDomicilio").value =
        paciente.domicilioSalidaDto.localidad;
      document.querySelector("#provinciaDomicilio").value =
        paciente.domicilioSalidaDto.provincia;

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
