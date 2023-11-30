window.addEventListener("load", function () {
  var paciente = {};

  const formulario = document.forms[0];
  const url = "http://localhost:8081/pacientes/registrar";
  formulario.addEventListener("submit", function (evento) {
    evento.preventDefault();
    agregarPaciente();
  });

  function capturarDatos() {
    const nombrePaciente = document.querySelector("#nombrePaciente");
    const apellidoPaciente = document.querySelector("#apellidoPaciente");
    const dniPaciente = document.querySelector("#dniPaciente");
    const fechaIngresoPaciente = document.querySelector("#fechaIngreso");
    const calleDomicilio = document.querySelector("#calleDomicilio");
    const numeroDomicilio = document.querySelector("#numeroDomicilio");
    const localidadDomicilio = document.querySelector("#localidadDomicilio");
    const provinciaDomicilio = document.querySelector("#provinciaDomicilio");

    paciente = {
      nombre: nombrePaciente.value,
      apellido: apellidoPaciente.value,
      dni: dniPaciente.value,
      fechaIngreso: fechaIngresoPaciente.value,
      domicilioEntradaDto: {
        calle: calleDomicilio.value,
        numero: numeroDomicilio.value,
        localidad: localidadDomicilio.value,
        provincia: provinciaDomicilio.value,
      },
    };

    return paciente;
  }

  function agregarPaciente() {
    const data = capturarDatos();

    const conf = {
      method: "POST",
      body: JSON.stringify(data),
      headers: {
        "Content-type": "application/json; charset=UTF-8",
      },
    };

    fetch(url, conf)
      .then((res) => res.json())
      .then((data) => {
        console.log(data);
      });
    formulario.reset();
  }
});
