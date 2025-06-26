# XML & JSON 
Autor: akram allaoui
## XML

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Entidades>
    <Clientes>
        <Cliente>
            <id></id>
            <nombre></nombre>
            <apellidos></apellidos>
            <nif></nif>
            <email></email>
            <fnac></fnac>
            <fAlta></fAlta>
            <contAcceso></contAcceso>
        </Cliente>
    </Clientes>
    <Membresias>
        <Membresia>
            <id></id>
            <tipo></tipo>
            <precio></precio>
        </Membresia>
    </Membresias>
    <Pagos>
        <Pagar>
            <idCliente></idCliente>
            <idMembresia></idMembresia>
        </Pagar>
    </Pagos>
    <Accesos>
        <Acceder>
            <idCliente></idCliente>
            <fecha></fecha>
            <entrada></entrada>
            <salida></salida>
        </Acceder>
    </Accesos>
    <Reservas>
        <Reservar>
            <idCliente></idCliente>
            <idSala></idSala>
            <fecha></fecha>
        </Reservar>
    </Reservas>
    <Salas>
        <Sala>
            <id></id>
            <plazas></plazas>
            <horario></horario>
        </Sala>
    </Salas>
    <Gimnasios>
        <Gimnasio>
            <id></id>
            <nombre></nombre>
            <codigo></codigo>
        </Gimnasio>
    </Gimnasios>
    <Trabajadores>
        <Trabajador>
            <id></id>
            <nombre></nombre>
            <apellidos></apellidos>
            <fnac></fnac>
            <nif></nif>
            <email></email>
        </Trabajador>
    </Trabajadores>
    <Monitores>
        <Monitor>
            <idTrabajador></idTrabajador>
        </Monitor>
    </Monitores>
    <Supervisores>
        <Supervisor>
            <idTrabajador></idTrabajador>
        </Supervisor>
    </Supervisores>
    <Clases>
        <Clase>
            <id></id>
            <idSala></idSala>
            <idMonitor></idMonitor>
            <fecha></fecha>
            <turno></turno>
        </Clase>
    </Clases>
    <Musculaciones>
        <Musculacion>
            <id></id>
            <idSala></idSala>
            <idSupervisor></idSupervisor>
        </Musculacion>
    </Musculaciones>
</Entidades>

```
## JSON
```json
{
  "CLIENTES": [
    {
      "id": 0,
      "nombre": "",
      "apellidos": "",
      "nif": "",
      "email": "",
      "fnac": "",
      "fAlta": "",
      "contAcceso": 0,
      "accesos": [],
      "reservas": [],
      "pagos": []
    }
  ],
  "MEMBRESIAS": [
    {
      "id": 0,
      "tipo": "",
      "precio": 0.0
    }
  ],
  "SALAS": [
    {
      "id": 0,
      "plazas": 0,
      "horario": ""
    }
  ],
  "GIMNASIOS": [
    {
      "id": 0,
      "nombre": "",
      "codigo": ""
    }
  ],
  "TRABAJADORES": [
    {
      "id": 0,
      "nombre": "",
      "apellidos": "",
      "fnac": "",
      "nif": "",
      "email": ""
    }
  ],
  "MONITORES": [
    {
      "idTrabajador": 0
    }
  ],
  "SUPERVISORES": [
    {
      "idTrabajador": 0
    }
  ],
  "CLASES": [
    {
      "id": 0,
      "idSala": 0,
      "idMonitor": 0,
      "fecha": "",
      "turno": ""
    }
  ],
  "MUSCULACIONES": [
    {
      "id": 0,
      "idSala": 0,
      "idSupervisor": 0
    }
  ]
}

```
