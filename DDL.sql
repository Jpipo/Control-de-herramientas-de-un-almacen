CREATE DATABASE almacenHerramienta;
use almacenHerramienta;

CREATE TABLE Area_trabajo (
cod_area INT AUTO_INCREMENT PRIMARY KEY,
nombre_area VARCHAR(100) NOT NULL
);
CREATE TABLE Cargo (
cod_cargo INT AUTO_INCREMENT PRIMARY KEY,
nombre_cargo VARCHAR(50) NOT NULL,
f_area INT,
FOREIGN KEY (f_area) REFERENCES Area_trabajo (cod_area)
);
CREATE TABLE Empleado (
id_empleado INT AUTO_INCREMENT PRIMARY KEY,
c_identidad INT UNIQUE NOT NULL,
nombre VARCHAR(100) NOT NULL,
ap_paterno VARCHAR(50),
ap_materno VARCHAR(50),
telefono int,
direccion VARCHAR(255),
sexo CHAR(1) NOT NULL,
email VARCHAR(250),
fecha_ingreso DATE NOT NULL,
f_cargo INT NOT NULL,
FOREIGN KEY (f_cargo) REFERENCES Cargo (cod_cargo)
);
CREATE TABLE Usuarios (
id_usuario INT AUTO_INCREMENT PRIMARY KEY,
usuario VARCHAR(50) NOT NULL UNIQUE,
contraseña VARCHAR(100) NOT NULL,
f_id_empleado int NOT NULL,
FOREIGN KEY (f_id_empleado) REFERENCES Empleado (id_empleado)
);
CREATE TABLE Tipo_sitio(
id_tipo_sitio INT AUTO_INCREMENT PRIMARY KEY,
categoria_sitio VARCHAR(100) NOT NULL
);
CREATE TABLE Departamento(
cod_dpto CHAR(2) PRIMARY KEY,
nombre_dpto VARCHAR(100) NOT NULL
);
CREATE TABLE Cliente(
cod_cliente INT AUTO_INCREMENT PRIMARY KEY,
nombre_cliente VARCHAR(150) NOT NULL
);
CREATE TABLE Sitios(
id_sitio INT auto_increment primary key,
cod_asignacion INT,
nombre_sitio VARCHAR(100) NOT NULL,
latitud varchar(50),
longitud VARCHAR(50),
f_tipo_sitio INT NOT NULL,
f_cliente INT NOT NULL,
f_dpto CHAR(2) NOT NULL,
FOREIGN KEY (f_tipo_sitio) REFERENCES Tipo_sitio(id_tipo_sitio),
FOREIGN KEY (f_cliente) REFERENCES Cliente(cod_cliente),
FOREIGN KEY (f_dpto) REFERENCES Departamento(cod_dpto)
);
CREATE TABLE Pais_fabricacion(
cod_pais INT AUTO_INCREMENT PRIMARY KEY,
nombre_pais VARCHAR(100) NOT NULL
);
CREATE TABLE Marca_herramienta(
id_marca INT AUTO_INCREMENT PRIMARY KEY,
nombre_marca VARCHAR(100) NOT NULL
);
CREATE TABLE Categoria_herramienta(
id_categoria INT AUTO_INCREMENT PRIMARY KEY,
categoria_h VARCHAR(100) NOT NULL
);
CREATE TABLE Proveedor(
id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
nombre_p VARCHAR(100) NOT NULL,
telefono_p INT,
direccion_p VARCHAR (250)
);
CREATE TABLE Herramientas_equipos(
cod_herramienta INT PRIMARY KEY,
descripcion VARCHAR(250) NOT NULL,
f_id_marca INT,
f_cod_pais INT,
f_id_categoria INT,
FOREIGN KEY (f_id_marca) REFERENCES Marca_herramienta (id_marca),
FOREIGN KEY (f_cod_pais) REFERENCES Pais_fabricacion (cod_pais),
FOREIGN KEY (f_id_categoria) REFERENCES Categoria_herramienta (id_categoria)
);
CREATE TABLE Herramientas_ingresadas(
	id_ingreso INT AUTO_INCREMENT PRIMARY KEY,
	cantidad INT NOT NULL,
	fecha_compra DATE NOT NULL,
	precio DECIMAL (10,2),
	f_cod_herramienta INT NOT NULL,
	f_id_proveedor INT,
	FOREIGN KEY (f_cod_herramienta) REFERENCES Herramientas_equipos (cod_herramienta),
	FOREIGN KEY (f_id_proveedor) REFERENCES Proveedor (id_proveedor)
);
CREATE TABLE Inventario_herramienta(
	id_stock INT AUTO_INCREMENT PRIMARY KEY,
	stock_actual INT NOT NULL,
	cantidad_total INT NOT NULL,
	f_cod_herramienta INT unique NOT NULL,
	FOREIGN KEY (f_cod_herramienta) REFERENCES Herramientas_equipos (cod_herramienta)
);
CREATE TABLE Baja_herramienta (
    id_baja INT AUTO_INCREMENT PRIMARY KEY,
    fecha_baja DATETIME NOT NULL,
    cantidad INT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    f_cod_herramienta INT NOT NULL,
    FOREIGN KEY (f_cod_herramienta) REFERENCES Herramientas_equipos(cod_herramienta) ON UPDATE CASCADE
);
CREATE TABLE Orden_salida_herramienta(
	nro_orden INT AUTO_INCREMENT PRIMARY KEY,
	fecha_salida DATE NOT NULL,
	f_id_empleado INT NOT NULL,
	f_sitio INT NOT NULL,
	FOREIGN KEY (f_id_empleado) REFERENCES Empleado (id_empleado),
	FOREIGN KEY (f_sitio) REFERENCES Sitios (id_sitio)
);
CREATE TABLE Detalle_orden_salida(
nro_orden INT NOT NULL,
cod_herramienta INT NOT NULL,
cantidad INT NOT NULL,
primary key (nro_orden, cod_herramienta),
FOREIGN KEY (nro_orden) REFERENCES Orden_salida_herramienta (nro_orden),
FOREIGN KEY (cod_herramienta) REFERENCES Herramientas_equipos (cod_herramienta)
);
CREATE TABLE Devolucion_herramienta(
id_devolucion INT AUTO_INCREMENT PRIMARY KEY,
fecha_devolucion DATE NOT NULL,
cantidad INT NOT NULL,
f_nro_salida INT NOT NULL,
FOREIGN KEY (f_nro_salida) REFERENCES Orden_salida_herramienta (nro_orden)
);