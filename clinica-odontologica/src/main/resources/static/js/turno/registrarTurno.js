window.addEventListener("load", function () {
  const turno = {
    odontologoId: 1,
    pacienteId: 1,
    fechaYHora: "2037-12-03T10:15:30",
  };

  const pacientesSelect = document.getElementById("pacientesSelect");
  const odontologosSelect = document.getElementById("odontologosSelect");
  const fechaSelect = document.getElementById("fechaSelect");
  const horaTurno = document.getElementById("horaTurno");
  const formulario = document.getElementById("formularioTurnos");

  formulario.addEventListener("submit", function (evento) {
    evento.preventDefault();
    registrarTurno();
  });

  function obtenerPacientes() {
    const url = "http://localhost:8081/pacientes/listar";
    const settings = {
      method: "GET",
    };

    fetch(url, settings)
      .then((response) => response.json())
      .then((data) => {
        renderizarPacientes(data);
      });
  }

  function registrarTurno() {
    const turnoARegistrar = {
      odontologoId: odontologosSelect.value,
      pacienteId: pacientesSelect.value,
      fechaYHora: `${fechaSelect.value}T${horaTurno.value}`,
    };
    const url = "http://localhost:8081/turnos/registrar";
    const settings = {
      method: "POST",
      body: JSON.stringify(turnoARegistrar),
      headers: {
        "Content-type": "application/json; charset=UTF-8",
      },
    };

    fetch(url, settings)
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
      });
  }

  function obtenerOdontologos() {
    const url = "http://localhost:8081/odontologos/listar";
    const settings = {
      method: "GET",
    };

    fetch(url, settings)
      .then((response) => response.json())
      .then((data) => {
        renderizarOdontologos(data);
      });
  }

  obtenerPacientes();
  obtenerOdontologos();

  function renderizarPacientes(pacientes) {
    pacientes.forEach((p) => {
      pacientesSelect.innerHTML += `
        <option value = ${p.id}>${p.nombre} ${p.apellido} - DNI: ${p.dni}</option>
        `;
    });
  }

  function renderizarOdontologos(odontologos) {
    odontologos.forEach((o) => {
      odontologosSelect.innerHTML += `
        <option value = ${o.id}>${o.nombre} ${o.apellido} - Matricula: ${o.matricula}</option>
        `;
    });
  }
});
