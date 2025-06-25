# XML & JSON 
Autor: akram allaoui
## XML

```xml
<?xml version="1.0" encoding="UTF-8"?>
<Entidades>
    <Clientes>
        <Cliente>
            <Cliente:id></Cliente:id>
            <Cliente:nombre></Cliente:nombre>
            <Cliente:apellidos></Cliente:apellidos>
            <Cliente:nif></Cliente:nif>
            <Cliente:email></Cliente:email>
            <Cliente:fnac></Cliente:fnac>
            <Cliente:fAlta></Cliente:fAlta>
            <Cliente:contAcceso></Cliente:contAcceso>
        </Cliente>
    </Clientes>
    <Membresias>
        <Membresia>
            <Membresia:id></Membresia:id>
            <Membresia:tipo></Membresia:tipo>
            <Membresia:precio></Membresia:precio>
        </Membresia>
    </Membresias>
    <Pagos>
        <Pagar>
            <Pagar:idCliente></Pagar:idCliente>
            <Pagar:idMembresia></Pagar:idMembresia>
        </Pagar>
    </Pagos>
    <Accesos>
        <Acceder>
            <Acceder:idCliente></Acceder:idCliente>
            <Acceder:fecha></Acceder:fecha>
            <Acceder:entrada></Acceder:entrada>
            <Acceder:salida></Acceder:salida>
        </Acceder>
    </Accesos>
    <Reservas>
        <Reservar>
            <Reservar:idCliente></Reservar:idCliente>
            <Reservar:idSala></Reservar:idSala>
            <Reservar:fecha></Reservar:fecha>
        </Reservar>
    </Reservas>
    <Salas>
        <Sala>
            <Sala:id></Sala:id>
            <Sala:plazas></Sala:plazas>
            <Sala:horario></Sala:horario>
        </Sala>
    </Salas>
    <Gimnasios>
        <Gimnasio>
            <Gimnasio:id></Gimnasio:id>
            <Gimnasio:nombre></Gimnasio:nombre>
            <Gimnasio:codigo></Gimnasio:codigo>
        </Gimnasio>
    </Gimnasios>
    <Trabajadores>
        <Trabajador>
            <Trabajador:id></Trabajador:id>
            <Trabajador:nombre></Trabajador:nombre>
            <Trabajador:apellidos></Trabajador:apellidos>
            <Trabajador:fnac></Trabajador:fnac>
            <Trabajador:nif></Trabajador:nif>
            <Trabajador:email></Trabajador:email>
        </Trabajador>
    </Trabajadores>
    <Monitores>
        <Monitor>
            <Monitor:idTrabajador></Monitor:idTrabajador>
        </Monitor>
    </Monitores>
    <Supervisores>
        <Supervisor>
            <Supervisor:idTrabajador></Supervisor:idTrabajador>
        </Supervisor>
    </Supervisores>
    <Clases>
        <Clase>
            <Clase:id></Clase:id>
            <Clase:idSala></Clase:idSala>
            <Clase:idMonitor></Clase:idMonitor>
            <Clase:fecha></Clase:fecha>
            <Clase:turno></Clase:turno>
        </Clase>
    </Clases>
    <Musculaciones>
        <Musculacion>
            <Musculacion:id></Musculacion:id>
            <Musculacion:idSala></Musculacion:idSala>
            <Musculacion:idSupervisor></Musculacion:idSupervisor>
        </Musculacion>
    </Musculaciones>
</Entidades>
```
## JSON
```json
{
"CLIENTE": {
"id": 0,
"nombre": "",
"apellidos": "",
"nif": "",
"email": "",
"fnac": "",
"fAlta": "",
"contAcceso": 0
},
"MEMBRESIA": {
"id": 0,
"tipo": "",
"precio": 0.0
},
"PAGAR": {
"idCliente": 0,
"idMembresia": 0
},
"ACCEDER": {
"idCliente": 0,
"fecha": "",
"entrada": "",
"salida": ""
},
"RESERVAR": {
"idCliente": 0,
"idSala": 0,
"fecha": ""
},
"SALA": {
"id": 0,
"plazas": 0,
"horario": ""
},
"GIMNASIO": {
"id": 0,
"nombre": "",
"codigo": ""
},
"TRABAJADOR": {
"id": 0,
"nombre": "",
"apellidos": "",
"fnac": "",
"nif": "",
"email": ""
},
"MONITOR": {
"idTrabajador": 0
},
"SUPERVISOR": {
"idTrabajador": 0
},
"CLASE": {
"id": 0,
"idSala": 0,
"idMonitor": 0,
"fecha": "",
"turno": ""
},
"MUSCULACION": {
"id": 0,
"idSala": 0,
"idSupervisor": 0
}
}
```