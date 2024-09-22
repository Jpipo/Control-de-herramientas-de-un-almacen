DELIMITER $$
create procedure registrarEmpleado(
in p_cIdentidad INT,
in p_nombre VARCHAR(100),
in p_apPaterno VARCHAR(50),
in p_apMaterno VARCHAR(50),
in p_telefono int,
in p_direccion VARCHAR(255),
in p_sexo CHAR(1),
in p_email VARCHAR(250),
in p_fechaIngreso DATE,
in p_fcargo INT
)
begin
insert into empleado (c_identidad, nombre, ap_paterno, ap_materno, telefono, direccion, sexo, email, fecha_ingreso, f_cargo)
values (p_cIdentidad, p_nombre, p_apPaterno, p_apMaterno, p_telefono, p_direccion, p_sexo, p_email, p_fechaIngreso, p_fcargo);
end $$
DELIMITER ;

call registrarEmpleado(6152052, 'Rodrigo', 'Rodriguez', 'Flores', 72152662, 'urbaniación urkupiña, Cotoca', 'M', 'rodris14@gmail.com','2018-08-12', 2);

DELIMITER $$
create procedure registrarHerramienta(
in p_codHerramienta int,
in p_descripcion varchar(250),
in p_idMarca int,
in p_codPais int,
in p_idCategoria int
)
begin
insert into herramientas_equipos
values (p_codHerramienta, p_descripcion, p_idMarca, p_codPais, p_idCategoria);
end $$
DELIMITER ;

call registrarHerramienta(101, 'martillo', 4, 5, 1);

DELIMITER $$
create procedure insertarStock(
in p_cantidad int,
in p_fechaCompra date,
in p_precio decimal(10,2),
in p_codHerraienta int,
in p_idProveedor int
)
begin
insert into herramientas_ingresadas (cantidad, fecha_compra, precio, f_cod_herramienta, f_id_proveedor)
values (p_cantidad, p_fechaCompra, p_precio, p_codHerraienta, p_idProveedor);
end $$
DELIMITER ;

call insertarStock(5, '2015-10-01', 25, 101, 5);


DELIMITER $$

CREATE PROCEDURE DarDeBajaHerramienta(
    IN p_cantidad INT,
    IN p_motivo VARCHAR(255),
    IN p_cod_herramienta INT
)
BEGIN
    DECLARE cantidad_actual INT;
    
    -- Obtener la cantidad actual de la herramienta
    SELECT cantidad_total INTO cantidad_actual
    FROM inventario_herramienta
    WHERE f_cod_herramienta = p_cod_herramienta;
    
    -- Verificar si hay suficiente cantidad para dar de baja
    IF cantidad_actual >= p_cantidad THEN
        -- Registrar la baja en la tabla Baja_herramienta
        INSERT INTO Baja_herramienta (fecha_baja, cantidad, motivo, f_cod_herramienta )
        VALUES (CURDATE(), p_cantidad, p_motivo, p_cod_herramienta );
        
        -- Actualizar la cantidad en la tabla Herramientas_equipos
        UPDATE inventario_herramienta
        SET cantidad_total = cantidad_total - p_cantidad, stock_actual = stock_actual - p_cantidad
        WHERE f_cod_herramienta = p_cod_herramienta;
    ELSE
        -- Mensaje en caso que no haya suficiente cantidad para dar de baja
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cantidad insuficiente para dar de baja';
    END IF;
END $$

DELIMITER ;

CALL DarDeBajaHerramienta(1, 'Herramienta dañada', 101);