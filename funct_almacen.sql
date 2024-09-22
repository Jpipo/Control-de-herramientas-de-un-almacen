DELIMITER //

CREATE FUNCTION verificarDisponibilidad(cod_herramienta INT)
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
    DECLARE disponible BOOLEAN;
    DECLARE stock INT;
    SELECT stock_actual INTO stock
    FROM Inventario_herramienta
    WHERE f_cod_herramienta = cod_herramienta;
    SET disponible = (stock > 0);
    RETURN disponible;
END //

DELIMITER ;

SELECT verificarDisponibilidad(101) AS disponible;