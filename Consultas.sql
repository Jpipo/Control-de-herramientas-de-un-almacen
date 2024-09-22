
select * from herramientas_equipos where descripcion like "%soldar%";
select * from herramientas_equipos where descripcion like 'm%o';
select * from herramientas_equipos;
-- Búsqueda de patrones (regexp)
select * from herramientas_equipos where descripcion regexp '\\bmartillo\\b';

select h.cod_herramienta as Código, h.descripcion as Nombre, m.nombre_marca as Marca, c.categoria_h as Categoria, hi.precio as Precio_unitario
from herramientas_equipos h
join marca_herramienta m on h.f_id_marca = m.id_marca
join categoria_herramienta c on h.f_id_categoria = c.id_categoria
join herramientas_ingresadas hi on h.cod_herramienta = hi.f_cod_herramienta
where m.nombre_marca regexp '\\btramontina\\b' and hi.precio < 5000;

select h.cod_herramienta as Código, h.descripcion as Nombre, m.nombre_marca as Marca, hi.precio as Precio_unitario, i.stock_actual as Stock
from herramientas_equipos h 
join herramientas_ingresadas hi on h.cod_herramienta = hi.f_cod_herramienta
join marca_herramienta m on h.f_id_marca = m.id_marca
join inventario_herramienta i on i.f_cod_herramienta = h.cod_herramienta
where h.cod_herramienta > 0;


select e.c_identidad as Carnet, e.nombre as Nombre, e.ap_paterno as Ap_Paterno, e.ap_materno As Ap_Materno, e.telefono as Teléfono, e.fecha_ingreso as Ingreso, c.nombre_cargo as Cargo
from empleado e 
join cargo c on f_cargo = c.cod_cargo;

select e.c_identidad as Carnet, e.nombre as Nombre, e.ap_paterno as Ap_Paterno, e.ap_materno As Ap_Materno, e.telefono as Teléfono, e.fecha_ingreso as Ingreso, c.nombre_cargo as Cargo
from empleado e 
join cargo c on f_cargo = c.cod_cargo
where c.nombre_cargo = 'Montador de torres';
