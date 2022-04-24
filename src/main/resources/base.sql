-- Volcando estructura de base de datos para admglp

/*
DROP DATABASE IF EXISTS `admglp`;
CREATE DATABASE IF NOT EXISTS `admglp`;
USE `admglp`;
 */

CREATE TABLE c_global (
id_global  int(11) NOT NULL AUTO_INCREMENT ,
global_vc_nombre  VARCHAR(50) NOT NULL,
global_vc_valor  VARCHAR(200) NOT NULL,
PRIMARY KEY (id_global)
)ENGINE=InnoDB;

CREATE TABLE c_articulo (
id_articulo INT(11) NOT NULL AUTO_INCREMENT, 
articulo_vc_nombre VARCHAR(70) NOT NULL, 
articulo_d_precio_articulo DECIMAL(19, 2) NOT NULL, 
articulo_dt_fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), 
articulo_dt_fecha_actualizacion DATETIME NULL, 
articulo_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_articulo)
)ENGINE=INNODB;

CREATE TABLE c_asentamiento (
id_asentamiento INT(11) NOT NULL AUTO_INCREMENT, 
id_municipio INT(11) NOT NULL, 
asenta_c_clave CHAR(4) NOT NULL, 
asenta_c_codigo_postal CHAR(5) NOT NULL,  
asenta_vc_tipo VARCHAR(70) NOT NULL, 
asenta_vc_nombre VARCHAR(150) NOT NULL, 
asenta_dt_fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), 
asenta_dt_fecha_actualizacion DATETIME NULL, 
asenta_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_asentamiento)
)ENGINE=INNODB;

CREATE TABLE c_cliente (
id_cliente INT(11) NOT NULL AUTO_INCREMENT, 
id_usuario INT(11) NOT NULL UNIQUE, 
cliente_i_numero INT(11) NOT NULL, 
cliente_dt_fecha_registro DATETIME NULL DEFAULT CURRENT_TIMESTAMP(), 
cliente_dt_fecha_actualizacion DATETIME NULL, 
cliente_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_cliente)
)ENGINE=INNODB; 

CREATE TABLE c_empleado (
id_empleado INT(11) NOT NULL AUTO_INCREMENT, 
id_usuario INT(11) NOT NULL UNIQUE, 
empleado_i_num_trab INT(11) NOT NULL UNIQUE, 
empleado_i_numero_ss CHAR(15) NOT NULL UNIQUE, 
empleado_c_rfc_trab char(13) NOT NULL UNIQUE, 
empleado_dt_fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), 
empleado_dt_fecha_actualizacion DATETIME NULL, 
empleado_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_empleado)
)ENGINE=INNODB;

CREATE TABLE c_estado (
id_estado INT(11) NOT NULL AUTO_INCREMENT, 
estado_c_clave char(2) NOT NULL UNIQUE,
estado_vc_nombre VARCHAR(100) NOT NULL,
estado_dt_fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), 
estado_dt_fecha_actualizacion DATETIME NULL,  
estado_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_estado)
)ENGINE=INNODB;

CREATE TABLE c_estatus (
id_estatus INT(11) NOT NULL AUTO_INCREMENT, 
estatus_si_num_estatus SMALLINT(6) NOT NULL, 
estatus_vc_nom_tabla VARCHAR(50) NOT NULL, 
estatus_vc_nombre_estatus VARCHAR(50) NOT NULL, 
estatus_vc_descripcion VARCHAR(200), 
estatus_dt_fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), 
estatus_dt_fecha_actualizacion DATETIME NULL,  
estatus_c_activo char(1) NOT NULL, 
PRIMARY KEY (id_estatus)
)ENGINE=INNODB;

CREATE TABLE c_municipio (
id_municipio INT(11) NOT NULL AUTO_INCREMENT, 
id_estado INT(11) NOT NULL, 
municipio_c_clave char(3) NOT NULL, 
municipio_vc_nombre VARCHAR(100) NOT NULL, 
municipio_dt_fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), 
municipio_dt_fecha_actualizacion DATETIME NULL, 
municipio_si_estado SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_municipio)
)ENGINE=INNODB;

CREATE TABLE c_rol (
id_rol INT(11) NOT NULL AUTO_INCREMENT, 
rol_vc_nombre VARCHAR(50) NOT NULL, 
rol_c_tipo_rol char(1) NOT NULL, 
rol_dt_fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), 
rol_dt_fecha_actualizacion DATETIME NULL, 
rol_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_rol))ENGINE=INNODB;

CREATE TABLE c_transporte (
id_transporte INT(11) NOT NULL AUTO_INCREMENT, 
trans_i_numero_unidad INT(11) NOT NULL, 
trans_i_modelo INT(11) NOT NULL, 
trans_vc_placas VARCHAR(20) NOT NULL, 
trans_vc_marca VARCHAR(30) NOT NULL, 
trans_dt_fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), 
trans_dt_fecha_actualizacion DATETIME NULL, 
trans_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_transporte)
)ENGINE=INNODB;

CREATE TABLE t_acceso (
id_acceso INT(11) NOT NULL AUTO_INCREMENT, 
id_usuario INT(11) NOT NULL, 
acceso_dt_fecha_inicio_acceso DATETIME NULL, 
acceso_dt_fecha_fin_acceso DATETIME NULL, 
acceso_descripcion VARCHAR(150) NOT NULL,
acceso_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_acceso)
)ENGINE=INNODB;

CREATE TABLE t_comentario (
id_comentario INT(11) NOT NULL AUTO_INCREMENT, 
id_pedido INT(11) NOT NULL, 
comentario_i_numero INT(11) NOT NULL, 
comentario_vc_comentario VARCHAR(500) NOT NULL, 
comentario_c_tipo char(1) NOT NULL, 
comentario_dt_fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), 
comentario_dt_fecha_actualizacion DATETIME NULL, 
comentario_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_comentario)
)ENGINE=INNODB;

CREATE TABLE t_contra (
id_contra INT(11) NOT NULL AUTO_INCREMENT,  
contra_vc_contra_cifrado VARCHAR(500) NOT NULL, 
contra_dt_fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), 
contra_dt_fecha_actualizacion DATETIME NULL, 
contra_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_contra)
)ENGINE=INNODB;

CREATE TABLE t_direccion (
id_direccion INT(11) NOT NULL AUTO_INCREMENT, 
id_asentamiento INT(11) NOT NULL, 
direccion_vc_nombre VARCHAR(300) NOT NULL, 
direccion_vc_referencias VARCHAR(300), 
direccion_dt_fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), 
direccion_dt_fecha_actualizacion DATETIME NULL, 
direccion_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_direccion)
)ENGINE=INNODB;

CREATE TABLE t_pedido (
id_pedido INT(11) NOT NULL AUTO_INCREMENT, 
id_cliente INT(11) NOT NULL, 
id_direccion int(11) NOT NULL, 
pedido_d_total DECIMAL(19, 2) NOT NULL, 
pedido_dt_fecha_pedido DATETIME NOT NULL, 
pedido_dt_fecha_entrega DATETIME NULL, 
pedido_i_tipo_pago INT(11), 
pedido_dt_fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), 
pedido_dt_fecha_actualizacion DATETIME NULL, 
pedido_vc_observacion VARCHAR(250), 
pedido_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_pedido)
)ENGINE=INNODB;

CREATE TABLE t_turno (
id_turno INT(11) NOT NULL AUTO_INCREMENT, 
turno_dt_fecha_inicio_turno DATETIME NOT NULL, 
turno_dt_fecha_fin_turno DATETIME NULL, 
turno_dt_fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), 
turno_dt_fecha_actualizacion DATETIME NULL, 
turno_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_turno)
)ENGINE=INNODB;

CREATE TABLE t_usuario (
id_usuario INT(11) NOT NULL AUTO_INCREMENT, 
id_contra INT(11) NOT NULL UNIQUE, 
usuario_vc_apodo VARCHAR(40) NOT NULL UNIQUE, 
usuario_vc_correo1 VARCHAR(80) NOT NULL, 
usuario_vc_correo2 VARCHAR(80), 
usuario_vc_nombre VARCHAR(50) NOT NULL, 
usuario_vc_apellido1 VARCHAR(50) NOT NULL, 
usuario_vc_apellido2 VARCHAR(50) NOT NULL, 
usuario_ti_edad TINYINT NOT NULL, 
usuario_d_fec_nacimiento DATE NOT NULL, 
usuario_vc_telefono1 VARCHAR(10) NOT NULL, 
usuario_vc_telefono2 VARCHAR(10), 
usuario_dt_fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), 
usuario_dt_fecha_actualizacion DATETIME NULL, 
usuario_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_usuario)
)ENGINE=INNODB;

CREATE TABLE tr_cliente_direccion (
id_cliente_direccion INT(11) NOT NULL AUTO_INCREMENT, 
id_cliente INT(11) NOT NULL, 
id_direccion INT(11) NOT NULL,
PRIMARY KEY (id_cliente_direccion)
)ENGINE=INNODB;

CREATE TABLE tr_empleado_pedido (
id_empleado_pedido INT(11) NOT NULL AUTO_INCREMENT, 
id_empleado INT(11) NOT NULL, 
id_pedido INT(11) NOT NULL, 
emp_ped_dt_fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP(), 
emp_ped_dt_fecha_actualizacion DATETIME NULL, 
emp_ped_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_empleado_pedido)
)ENGINE=INNODB;

CREATE TABLE tr_pedido_articulo (
id_ped_art INT(11) NOT NULL AUTO_INCREMENT, 
id_pedido INT(11) NOT NULL, 
id_articulo INT(11) NOT NULL, 
ped_art_ti_cantidad tinyint NOT NULL, 
ped_art_d_subtotal decimal(19, 2) NOT NULL,
ped_art_dt_fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP(), 
ped_art_dt_fecha_actualizacion DATETIME NULL, 
ped_art_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_ped_art)
)ENGINE=INNODB;

CREATE TABLE tr_turno_empleado_transporte (
id_turno_empleado_transporte INT(11) NOT NULL AUTO_INCREMENT, 
id_turno INT(11) NOT NULL, 
id_empleado INT(11) NOT NULL, 
id_transporte INT(11) NOT NULL, 
turno_emp_trans_dt_fecha_entrada DATETIME NOT NULL, 
turno_emp_trans_dt_fecha_salida DATETIME NULL, 
turno_emp_trans_si_estatus SMALLINT(6) NOT NULL, 
PRIMARY KEY (id_turno_empleado_transporte)
)ENGINE=INNODB;

CREATE TABLE tr_usuario_rol (
id_usuario_rol INT(11) NOT NULL AUTO_INCREMENT, 
id_rol INT(11) NOT NULL, 
id_usuario INT(11) NOT NULL,
PRIMARY KEY (id_usuario_rol)
)ENGINE=INNODB;

CREATE UNIQUE INDEX c_estatus ON c_estatus (estatus_si_num_estatus, estatus_vc_nom_tabla);

CREATE UNIQUE INDEX tr_cliente_direccion ON tr_cliente_direccion (id_cliente, id_direccion);

CREATE INDEX tr_empleado_pedido ON tr_empleado_pedido (id_empleado, id_pedido);

CREATE UNIQUE INDEX tr_pedido_articulo ON tr_pedido_articulo (id_pedido, id_articulo);

CREATE UNIQUE INDEX tr_turno_empleado_transporte ON tr_turno_empleado_transporte (id_turno, id_empleado);

CREATE UNIQUE INDEX tr_usuario_rol ON tr_usuario_rol (id_rol, id_usuario);

ALTER TABLE t_usuario ADD CONSTRAINT FKt_usuario_contra 
FOREIGN KEY (id_contra) REFERENCES t_contra (id_contra);

ALTER TABLE tr_usuario_rol ADD CONSTRAINT FKtr_usuario_rol 
FOREIGN KEY (id_rol) REFERENCES c_rol (id_rol);

ALTER TABLE tr_usuario_rol ADD CONSTRAINT FKtr_usuario_usuario 
FOREIGN KEY (id_usuario) REFERENCES t_usuario (id_usuario);

ALTER TABLE t_acceso ADD CONSTRAINT FKt_acceso_usuario 
FOREIGN KEY (id_usuario) REFERENCES t_usuario (id_usuario);

ALTER TABLE c_empleado ADD CONSTRAINT FKc_empleado_usuario 
FOREIGN KEY (id_usuario) REFERENCES t_usuario (id_usuario);

ALTER TABLE c_cliente ADD CONSTRAINT FKc_cliente_usuario 
FOREIGN KEY (id_usuario) REFERENCES t_usuario (id_usuario);

ALTER TABLE tr_cliente_direccion ADD CONSTRAINT FKtr_cliente_cliente 
FOREIGN KEY (id_cliente) REFERENCES c_cliente (id_cliente);

ALTER TABLE tr_cliente_direccion ADD CONSTRAINT FKtr_cliente_direccion 
FOREIGN KEY (id_direccion) REFERENCES t_direccion (id_direccion);

ALTER TABLE tr_empleado_pedido ADD CONSTRAINT FKtr_empleado_pedido_empleado 
FOREIGN KEY (id_empleado) REFERENCES c_empleado (id_empleado);

ALTER TABLE tr_empleado_pedido ADD CONSTRAINT FKtr_empleado_pedido_pedido 
FOREIGN KEY (id_pedido) REFERENCES t_pedido (id_pedido);

ALTER TABLE t_pedido ADD CONSTRAINT FKt_pedido_cliente 
FOREIGN KEY (id_cliente) REFERENCES c_cliente (id_cliente);

ALTER TABLE t_pedido ADD CONSTRAINT FKt_pedido_direccion 
FOREIGN KEY (id_direccion) REFERENCES t_direccion (id_direccion);

ALTER TABLE tr_turno_empleado_transporte ADD CONSTRAINT FKtr_turno_turno 
FOREIGN KEY (id_turno) REFERENCES t_turno (id_turno);

ALTER TABLE tr_turno_empleado_transporte ADD CONSTRAINT FKtr_turno_transporte 
FOREIGN KEY (id_transporte) REFERENCES c_transporte (id_transporte);

ALTER TABLE tr_turno_empleado_transporte ADD CONSTRAINT FKtr_turno_empleado 
FOREIGN KEY (id_empleado) REFERENCES c_empleado (id_empleado);

ALTER TABLE tr_pedido_articulo ADD CONSTRAINT FKtr_pedido_articulo_pedido 
FOREIGN KEY (id_pedido) REFERENCES t_pedido (id_pedido);

ALTER TABLE tr_pedido_articulo ADD CONSTRAINT FKtr_pedido_articulo_articulo 
FOREIGN KEY (id_articulo) REFERENCES c_articulo (id_articulo);

ALTER TABLE c_municipio ADD CONSTRAINT FKc_municipio_estado 
FOREIGN KEY (id_estado) REFERENCES c_estado (id_estado);

ALTER TABLE c_asentamiento ADD CONSTRAINT FKc_asentamiento_municipio 
FOREIGN KEY (id_municipio) REFERENCES c_municipio (id_municipio);

ALTER TABLE t_direccion ADD CONSTRAINT FKt_direccion_asentamiento 
FOREIGN KEY (id_asentamiento) REFERENCES c_asentamiento (id_asentamiento);

ALTER TABLE t_comentario ADD CONSTRAINT FKt_comentario_pedido 
FOREIGN KEY (id_pedido) REFERENCES t_pedido (id_pedido);
