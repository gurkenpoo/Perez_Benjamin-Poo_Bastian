function deleteBy(id) {
  //llamamos la funcion y solicitamos confirmación para la eliminación
  mostrarModalConfirmacion(
    "¿Está seguro que desea eliminar el paciente?",
    () => {
      //con fetch invocamos a la API de paciente con el método DELETE
      //pasandole el id en la URL
      console.log("Eliminando Paciente " + id);
      const url = "http://localhost:8081/pacientes/eliminar/" + id;
      const settings = {
        method: "DELETE",
      };

      fetch(url, settings)
        .then((response) => {
          console.log(response);
          if (!response.ok) {
            throw new Error("Error al eliminar el paciente");
          }
          response.json();
        })
        .then((data) => {
          console.log(data);
          //borrar la fila de la paciente eliminada
          let row_id = "#tr_" + id;
          document.querySelector(row_id).remove();
          mostrarModal("Paciente eliminado");
          setTimeout(() => {
            window.location.reload();
          }, 2000);
        })
        .catch((error) => mostrarModal(error));
    }
  );
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

function mostrarModalConfirmacion(mensaje, callback) {
  // Función para mostrar un modal
  // Selecciona el modal
  const modal = document.getElementById("miModalConfirmacion");

  // Actualiza el mensaje en el modal
  const modalMensaje = modal.querySelector(".modal-body");
  modalMensaje.textContent = mensaje;

  // Agrega el evento de clic al botón "Aceptar"
  const btnAceptar = modal.querySelector("#btnAceptar");
  btnAceptar.addEventListener("click", callback);

  // Muestra el modal
  const miModal = new bootstrap.Modal(modal);
  miModal.show();
}
