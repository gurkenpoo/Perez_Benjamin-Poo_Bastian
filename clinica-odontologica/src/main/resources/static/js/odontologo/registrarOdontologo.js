window.addEventListener("load", function () {
  const formulario = document.forms[0];
  const url = "http://localhost:8081/odontologos/registrar";
  formulario.addEventListener("submit", function (evento) {
    evento.preventDefault();
    agregarOdontologo();
  });

  function capturarDatos() {
    const numeroMatricula = document.querySelector("#numeroMatricula");
    const nombreOdontologo = document.querySelector("#nombreOdontologo");
    const apellidoOdontologo = document.querySelector("#apellidoOdontologo");

    const odontologo = {
      matricula: numeroMatricula.value,
      nombre: nombreOdontologo.value,
      apellido: apellidoOdontologo.value,
    };
    return odontologo;
  }

  function agregarOdontologo() {
    const data = capturarDatos();

    const conf = {
      method: "POST",
      body: JSON.stringify(data),
      headers: {
        "Content-type": "application/json; charset=UTF-8",
      },
    };

    fetch(url, conf)
      .then((response) => {
        if (!response.ok) {
          throw new Error("No se pudo registrar el odontologo");
        }
        return response.json();
      })
      .then((data) => {
        console.log(data);
        mostrarModal("Odontologo registrado con exito");
        formulario.reset();
      })
      .catch((error) => {
        mostrarModal(error);
      });
  }
});

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
