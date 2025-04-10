## [Index](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/tree/main)  
1. [Eventos](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/blob/main/src/Docs/8.%20PL%5CSQL%20Avanzado.md)
2. [Triggers](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/blob/main/src/Docs/8.%20PL%5CSQL%20Avanzado.md#definición-de-2-disparadores-sobre-operaciones-asociadas-al-modelo-de-datos)  
3. [Procedure + Transaction](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/blob/main/src/Docs/8.%20PL%5CSQL%20Avanzado.md#definici%C3%B3n-de-2-procedimientos-almacenados-que-realicen-m%C3%A1s-de-una-operaci%C3%B3n-dentro-de-una-transacci%C3%B3n-haciendo-una-gesti%C3%B3n-adecuada-de-los-errores) 
4. [Procedure + Cursor](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/blob/main/src/Docs/8.%20PL%5CSQL%20Avanzado.md#definici%C3%B3n-de-2-procedimientos-almacenados-que-utilicen-cursores-que-recorran-cierta-cantidad-de-datos)





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

    -- Sumo el total de las cantidades guardadas en las variables locales y lo guardo en facturacionTotal
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

    -- Ademas como se activa al inicio del mes, ponemos los contadores de acceso de todos los clientes
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



### Definición de 2 procedimientos almacenados que realicen más de una operación dentro de una transacción, haciendo una gestión adecuada de los errores.
**Procedimiento para registrar el acceso de los clientes**
```sql
DELIMITER //
CREATE PROCEDURE registrarAcceso(
    IN nifClientee VARCHAR(9),
    IN codGimnasioo INT,
    IN fEntradaa DATE
)
BEGIN
    DECLARE mensaje VARCHAR(100);
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error al registrar el acceso';
    END;

    START TRANSACTION;

    --Verifico si existe el cliente
    IF NOT EXISTS (SELECT 1 FROM CLIENTE WHERE nif = nifClientee) THEN
        SET mensaje = CONCAT('El cliente', nifClientee, 'no existe');
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT= mensaje;
    END IF;
    --Si existe, registro el acceso
    INSERT INTO ACCESO (fEntrada, nifCliente, codGimnasio) 
    VALUES (fEntradaa, nifClientee, codGimnasioo);
    COMMIT;
END //
DELIMITER;
```
**Procedimiento para cambiar la membresia de los clientes**
```sql
DELIMITER //
CREATE PROCEDURE cambiarMembresia(
    IN nifClientee VARCHAR(9),
    IN tipoMembresiaa VARCHAR(12)
)
BEGIN
    DECLARE mensaje VARCHAR(100);
    DECLARE mensaje2 VARCHAR(100);
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error al actualizar la membresía';
    END;

    START TRANSACTION;
    
    --verifico que existe el cliente
    IF NOT EXISTS (SELECT 1 FROM CLIENTE WHERE nif = nifClientee) THEN
        SET mensaje = CONCAT('El cliente', nifClientee, 'no existe');
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT= mensaje;
    END IF;
    --Verifico que existe la membresia
    IF NOT EXISTS (SELECT 1 FROM MEMBRESIA WHERE tipo = tipoMembresiaa) THEN
        SET mensaje2 = CONCAT('El tipo de membresía', tipoMembresiaa, 'no es válido');
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT= mensaje2;
    END IF;
    --si ambos existen, cambio o actualizo la membresia
    UPDATE CLIENTE SET tipoMembresia = tipoMembresiaa WHERE nif = nifClientee;
    COMMIT;
END//
DELIMITER ;
```
### Definición de 2 Procedimientos con transacciones --> Cristian




### Definición de 2 procedimientos almacenados que utilicen cursores que recorran cierta cantidad de datos.
**Cursor que duplique la tabla cliente y añada su id de reserva si existe**
```sql
-- Crear una tabla copia a partir de la tabla cliente 
CREATE OR REPLACE TABLE cliente_reserva AS SELECT * FROM CLIENTE;

-- Sobre la nueva tabla, añadir un campo para saber el id de la sala que ha reservado (si lo ha hecho, en caso que no queda null)
ALTER TABLE cliente_reserva 
ADD COLUMN idReserva INT;

DELIMITER //
CREATE OR REPLACE PROCEDURE ac1114procReserva()
BEGIN
    DECLARE rowRe ROW TYPE OF RESERVA;
    DECLARE fin INT DEFAULT FALSE;
    DECLARE cur CURSOR FOR SELECT * FROM `RESERVA`; 
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = TRUE;

    OPEN cur;

    WHILE fin = FALSE DO
        FETCH cur INTO rowRe;

        IF fin = FALSE THEN
            -- Actualizar la tabla cliente_copia con el ID de su sala correspondiente
            UPDATE cliente_reserva SET idReserva = rowRe.idSala WHERE nif = rowRe.nifCliente;
        END IF;
    END WHILE;

    CLOSE cur;
END;
//
DELIMITER ;

-- Llamar al proceso
CALL ac1114procReserva();

-- Consultar la tabla
SELECT * FROM cliente_reserva;
```
![image](https://github.com/user-attachments/assets/05d9b51b-ce8a-43f5-94dd-b1a7056ba77b)


**Cursor que duplique la tabla trabajador y añada su turno si tiene**
```sql
-- Crear una tabla copia a partir de la tabla Trabajador 
CREATE OR REPLACE TABLE trabajador_turno AS SELECT * FROM `TRABAJADOR`;


-- Sobre la nueva tabla, añadir un campo para saber el horario que tendra el
-- trabajador (null en caso contrario) 
ALTER TABLE trabajador_turno 
ADD COLUMN Turno ENUM ("MAÑANA", "TARDE");

DELIMITER //
CREATE OR REPLACE PROCEDURE ac1114procTurno()
BEGIN
    -- Se declara el cursor del tipo de tabla SUPERVISAR
    DECLARE rowSu ROW TYPE OF SUPERVISAR;
    DECLARE fin INT DEFAULT FALSE;
    -- El cursor recorrera toda la tabla
    DECLARE cur CURSOR FOR SELECT * FROM `SUPERVISAR`; 
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = TRUE;

    OPEN cur;

    -- Entramos a un bucle WHILE hasta que se recorra todo
    WHILE fin = FALSE DO
        FETCH cur INTO rowSu;

        IF fin = FALSE THEN
            -- Actualizar la tabla trabajador_turno con su turno correspondiente
            UPDATE trabajador_turno SET Turno = rowSu.turno WHERE nif = rowSu.nifSupervisor;
        END IF;
    END WHILE;

    CLOSE cur;
END;
//
DELIMITER ;

-- Llamar al proceso
CALL ac1114procTurno();

-- Consultar la tabla
SELECT * FROM trabajador_turno;
```
![image](https://github.com/user-attachments/assets/b7fadf78-522c-4e3a-a1f1-67a5b6b37054)

### Definición de 2 Procedimientos con cursores --> Franco



