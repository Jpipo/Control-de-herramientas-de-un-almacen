DELIMITER $$

CREATE TRIGGER despues_insertar_herramienta
AFTER INSERT ON Herramientas_equipos
FOR EACH ROW
BEGIN
    INSERT INTO Inventario_herramienta (stock_actual, cantidad_total, f_cod_herramienta)
    VALUES (0, 0, NEW.cod_herramienta);
END $$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER actualizar_stock
AFTER INSERT ON Herramientas_ingresadas
FOR EACH ROW
BEGIN
    UPDATE Inventario_herramienta
    SET stock_actual = stock_actual + NEW.cantidad,
        cantidad_total = cantidad_total + NEW.cantidad
    WHERE f_cod_herramienta = NEW.f_cod_herramienta;
END $$

DELIMITER ;
