## [Index](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/tree/main)  
1. [Eventos](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/blob/main/src/Docs/8.%20PL%5CSQL%20Avanzado.md)
2. [Triggers](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/blob/main/src/Docs/8.%20PL%5CSQL%20Avanzado.md#definición-de-2-disparadores-sobre-operaciones-asociadas-al-modelo-de-datos)  
3. [Procedure + Transaction] 
4. [Procedure + Cursor]





### Definición de 2 eventos que automaticen tareas con diferente periodicidad.

**Evento para añadir a una tabla facturacionMensual la facturacion total de cada mes**
```sql

create or replace table facturacionMensual (
    registro int auto_increment primary key,
    facturacion decimal(10,2),
    beneficio varchar(32)
);

delimiter //
create event gananciaTotalMes
on schedule every 1 MONTH 
do
begin

    -- Averiguo cuantos clientes tienen la tarifa Gold contratada y lo multiplico por el precio

    select count(*) * 60 into @miembrosGold from cliente where tipoMembresia = "GOLD";
    select count(*) * 40 into @miembrosSilver from cliente where tipoMembresia = "SILVER";
    select count(*) * 20 into @miembrosBronze from cliente where tipoMembresia = "BRONZE";
    set @facturacionTotal = @miembrosGold + @miembrosSilver + @miembrosBronze;

    -- Los inserto en la nueva tabla para llevar un control mensual de la facturacion de clientes que tenemos
    insert into facturacionMensual(facturacion) values (@facturacionTotal);

end
//
delimiter ;
```

**Evento para mantener actualizados mes a mes el numero totales de clientes por tipo de membresia y total**
```sql

create or replace table totalClientesMembresia (
    idRegistro int auto_increment primary key,
    fechaRegistro date default now(),
    clientesGold int,
    clientesSilver int,
    clientesBronze int,
    totalClientes int
);

delimiter //
create event totalClientes
on schedule every 1 month
do
begin

    -- Consigo la cantidad de clientes diferenciados por tipo de membresia
    select count(*) into @miembrosGold from cliente where tipoMembresia = "GOLD";
    select count(*) into @miembrosSilver from cliente where tipoMembresia = "SILVER";
    select count(*) into @miembrosBronze from cliente where tipoMembresia = "BRONZE";
    select count(*) into @clientesTotales from cliente;

    -- Los inserto en la nueva tabla para llevar un control mensual de la cantidad de clientes que tenemos
    insert into `totalClientesMembresia` (clientesGold, clientesSilver, clientesBronze, totalClientes)
    values (@miembrosGold, @miembrosSilver, @miembrosBronze, @clientesTotales);

    -- Ademas como se activa al inicio del mes, ponemos todos los contadores de acceso de todos los clientes
    -- a 0 para reiniciar el control de acceso
    update cliente set contAcceso = 0;

end;
//
delimiter ;
```

### Definición de 2 disparadores sobre operaciones asociadas al modelo de datos.

**Trigger para actualizar el contador de acceso de un cliente cada vez que accede a un gimnasio**
```sql

delimiter //
create or replace trigger actualizadorAcceso
after insert on ACCESO for each row
begin

    -- Declaro dos variables para averiguar el tipo de membresia que tiene el cliente y el
    -- numero de reservas que ha hecho
    declare _tipoMembresia varchar(64);
    declare _contAcceso int;
    select tipoMembresia into _tipoMembresia from cliente where nif = new.nif;
    select contAcceso into _contAcceso from cliente where nif = new.nif;

    -- Dependiendo del tipo de membresia que tenga, compruébo si ha alcanzado el numero de reservas de
    -- cada tipo
    if _tipoMembresia = "Silver" and _contAcceso = 20 then
        signal sqlstate '45000'
            set Message_TEXT = "Has alcanzado el maximo de reservas para este mes";
    elseif _tipoMembresia = "Bronze" and _contAcceso = 10 then
        signal sqlstate '45000'
            set Message_TEXT = "Has alcanzado el maximo de reservas para este mes";
    -- Si tiene la membresia gold o no ha llegado al limite de las otras dos membresias
    -- simplemente le sumo 1 al contador de acceso
    else
        update cliente set contAcceso = contAcceso + 1 where nif = new.nif;
    end if;

end;
 //
delimiter ;
```









### Definición de 2 eventos --> Fernando
### Definición de 2 disparadores --> Fernando
