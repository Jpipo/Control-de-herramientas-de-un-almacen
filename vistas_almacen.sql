create view vistaHerramientas as 
select h.cod_herramienta as Código, h.descripcion as Nombre, m.nombre_marca as Marca, hi.precio as Precio_unitario, i.stock_actual as Stock, i.cantidad_total as Total
from herramientas_equipos h 
join herramientas_ingresadas hi on h.cod_herramienta = hi.f_cod_herramienta
join marca_herramienta m on h.f_id_marca = m.id_marca
join inventario_herramienta i on i.f_cod_herramienta = h.cod_herramienta;
-- Where P.idCategoria=C.idCategoria;

select nombre, Marca, Precio_unitario from vistaHerramientas ;

create view vistaEmpleados as 
select e.c_identidad as Carnet, e.nombre as Nombre, e.ap_paterno as Ap_Paterno, e.ap_materno As Ap_Materno, e.telefono as Teléfono, e.direccion as Domicilio, e.sexo as Sexo, 
e.email as Correo, e.fecha_ingreso as Fecha_Ingreso, c.nombre_cargo as Cargo, a.nombre_area as Area_Trabajo
from empleado e 
join cargo c on f_cargo = c.cod_cargo
inner join area_trabajo a on f_area = cod_area;

select carnet, nombre, ap_paterno, Ap_materno, Domicilio, Cargo from vistaEmpleados;
select carnet, nombre, ap_paterno, Ap_materno, Teléfono, Fecha_Ingreso, Cargo from vistaEmpleados;


select * from vistaherramientas;
select * from vistaempleados;