window.addEventListener("load", function () {
  //Buscamos y obtenemos el formulario donde estan
  //los datos que el usuario pudo haber modificado del odontologo
  const formulario = document.querySelector("#update_odontologos_form");

  formulario.addEventListener("submit", function (event) {
    event.preventDefault();

    //creamos un JSON que tendrá los datos del odontologo
    //a diferencia de un odontologo nuevo en este caso enviamos el id
    //para poder identificarlo y modificarlo para no cargarlo como nuevo
    const formData = {
      id: document.querySelector("#odontologo_id").value,
      matricula: document.querySelector("#numeroMatricula").value,
      nombre: document.querySelector("#nombreOdontologo").value,
      apellido: document.querySelector("#apellidoOdontologo").value,
    };

    //invocamos utilizando la función fetch la API con el método PUT que modificará
    //el odontologo que enviaremos en formato JSON
    const url = "http://localhost:8081/odontologos/actualizar";
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
        mostrarModal("Odontologo actualizado con exito");
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

//Es la funcion que se invoca cuando se hace click sobre el boton modificar
//se encarga de llenar el formulario con los datos del odontologo
//que se desea modificar
function findBy(id) {
  const url = "http://localhost:8081/odontologos/buscar" + "/" + id;
  const settings = {
    method: "GET",
  };
  fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
      let odontologo = data;
      document.querySelector("#odontologo_id").value = odontologo.id;
      document.querySelector("#numeroMatricula").value = odontologo.matricula;
      document.querySelector("#nombreOdontologo").value = odontologo.nombre;
      document.querySelector("#apellidoOdontologo").value = odontologo.apellido;

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
