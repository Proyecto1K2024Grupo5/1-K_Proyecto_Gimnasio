## [Index](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/tree/main)  
1. [Eventos](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/blob/main/src/Docs/7.%20DQL.md#definición-de-5-consultas-que-utilicen-subconsultas-tanto-escalares-como-fila-y-de-tabla)
2. [CTE](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/blob/main/src/Docs/7.%20DQL.md#definición-de-2-consultas-que-utilicen-cte)  
3. [Tabla](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/blob/main/src/Docs/7.%20DQL.md#creación-de-una-tabla-a-partir-del-resultado-de-una-consulta-compleja)  
4. [Indices](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/blob/main/src/Docs/7.%20DQL.md#definición-de-dos-índices-que-mejoren-el-rendimiento-de-las-consultas-ya-definidas)
5. [Plan de ejecucion](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/blob/main/src/Docs/7.%20DQL.md#planes-de-ejecución-antes-y-después-de-la-creación-de-los-índices-comprobando-su-uso)
6. [Resolución mediante SQL](https://github.com/Proyecto1K2024Grupo5/1-K_Proyecto_Gimnasio/blob/main/src/Docs/7.%20DQL.md#resolución-mediante-sql-de-cada-una-de-las-consultas)  





### Definición de 2 eventos que automaticen tareas con diferente periodicidad.

**Evento para añadir a una tabla facturacionMensual la facturacion total de cada mes**
```sql
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

    insert into facturacionMensual(facturacion) values (@facturacionTotal);

end
//
delimiter ;
```

create or replace table totalClientesMembresia (
    idRegistro int auto_increment primary key,
    fechaRegistro date default now(),
    clientesGold int,
    clientesSilver int,
    clientesBronze int,
    totalClientes int
);


**Evento para mantener actualizados mes a mes el numero totales de clientes por tipo de membresia y total**
```sql
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
    insert into `totalClientesMembresia` (clientesGold, clientesSilver, clientesBronze, totalClientes) values (
        @miembrosGold, @miembrosSilver, @miembrosBronze, @clientesTotales);

end;
//
delimiter ;
```
