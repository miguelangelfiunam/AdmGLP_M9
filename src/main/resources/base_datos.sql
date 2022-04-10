INSERT INTO c_estatus(
estatus_si_num_estatus, estatus_vc_nom_tabla, estatus_vc_nombre_estatus, 
estatus_vc_descripcion, estatus_dt_fecha_actualizacion, estatus_c_activo) 
VALUES 
(10, "t_usuario", "activo", "Usuario activo en el sistema",  NULL, 1),
(20, "t_usuario", "inactivo", "Usuario inactivo en el sistema", NULL, 1),
(10, "c_rol", "activo", "Rol activo en el sistema", NULL, 1),
(20, "c_rol", "inactivo", "Rol inactivo en el sistema", NULL, 1),
(10, "c_empleado", "activo", "Empleado activo en el sistema", NULL, 1),
(20, "c_empleado", "inactivo", "Empleado inactivo en el sistema", NULL, 1),
(10, "c_cliente", "activo", "Cliente activo en el sistema", NULL, 1),
(20, "c_cliente", "inactivo", "Cliente inactivo en el sistema", NULL, 1),
(10, "c_articulo", "activo", "Articulo activo en el sistema", NULL, 1),
(20, "c_articulo", "inactivo", "Articulo inactivo en el sistema", NULL, 1),
(10, "c_transporte", "activo", "Transporte activo en el sistema", NULL, 1),
(20, "c_transporte", "inactivo", "Transporte inactivo en el sistema", NULL, 1),
(10, "t_acceso", "correcto", "Acceso correcto al sistema", NULL, 1),
(20, "t_acceso", "error", "Acceso incorrecto al sistema", NULL, 1),
(10, "t_contra", "activo", "Contraseña activa", NULL, 1),
(20, "t_contra", "inactivo", "Contraseña inactiva", NULL, 1),
(10, "t_turno", "iniciado", "Turno creado", NULL, 1),
(20, "t_turno", "finalizado", "Turno finalizado", NULL, 1),
(30, "t_turno", "eliminado", "Turno eliminado", NULL, 1),
(10, "tr_turno_empleado_transporte", "asignado", "Relación activa de turno, empleado y transporte", NULL, 1),
(20, "tr_turno_empleado_transporte", "eliminado", "Relación inactiva de turno, empleado y transporte", NULL, 1),
(10, "tr_pedido_articulo", "activo", "Relación activa entre articulo y pedido", NULL, 1),
(20, "tr_pedido_articulo", "inactivo", "Relación inactiva entre articulo y pedido", NULL, 1),
(10, "t_comentario", "agregado", "Comentario agregado", NULL, 1),
(20, "t_comentario", "eliminado", "Comentario eliminado", NULL, 1),
(10, "tr_empleado_pedido", "activa", "Relación activa de empleado con un pedido", NULL, 1),
(20, "tr_empleado_pedido", "inactiva", "Relación inactiva de empleado con un pedido", NULL, 1),
(10, "t_direccion", "activa", "Dirección de un cliente activa", NULL, 1),
(20, "t_direccion", "inactiva", "Dirección de un cliente inactiva", NULL, 1),
(10, "c_asentamiento", "activa", "Asentamiento o localidad activa", NULL, 1),
(20, "c_asentamiento", "inactiva", "Asentamiento o localidad inactiva", NULL, 1),
(10, "c_municipio", "activo", "Municipio activo", NULL, 1),
(20, "c_municipio", "inactivo", "Municipio inactivo", NULL, 1),
(10, "c_estado", "activo", "Estado de la Republica activo", NULL, 1),
(20, "c_estado", "inactivo", "Estado de la Republica inactivo", NULL, 1),
(10, "t_pedido", "pendiente", "Pedido creado y esperando asignación de un empleado", NULL, 1),
(20, "t_pedido", "en curso", "El empleado toma pedido para entregar", NULL, 1),
(30, "t_pedido", "confirmacion", "El empleado confirma el pedido al momento de la entrega", NULL, 1),
(40, "t_pedido", "entregado", "El empleado entregó el pedido al cliente", NULL, 1),
(50, "t_pedido", "sin entrega", "El empleado por alguna razón no podrá entregar el pedido al cliente", NULL, 1),
(60, "t_pedido", "prestamo", "El empleado notifica que el pedido será un préstamo al cliente", NULL, 1),
(90, "t_pedido", "cancelado", "El cliente canceló su pedido", NULL, 1);

INSERT INTO t_contra(contra_vc_contra_cifrado, contra_dt_fecha_registro, 
contra_dt_fecha_actualizacion, contra_si_estatus) 
VALUES 
("dani123", NOW(), NULL, 10),
("richi123", NOW(), NULL, 10),
("pascual123", NOW(), NULL, 10),
("lourdes123", NOW(), NULL, 10),
("mariano123", NOW(), NULL, 10),
("mmartinez123", NOW(), NULL, 10);

INSERT INTO c_rol(rol_vc_nombre, rol_c_tipo_rol, rol_dt_fecha_registro, rol_dt_fecha_actualizacion, rol_si_estatus) 
VALUES 
( "Administardor", 'A', NOW(), NULL, 10),
( "Empleado", 'E', NOW(), NULL, 10),
( "Cliente", 'C', NOW(), NULL, 10);

INSERT INTO t_usuario(
id_contra, usuario_vc_apodo, usuario_vc_correo1, usuario_vc_correo2, 
usuario_vc_nombre, usuario_vc_apellido1, usuario_vc_apellido2, 
usuario_ti_edad, usuario_d_fec_nacimiento, usuario_vc_telefono1, 
usuario_vc_telefono2, usuario_dt_fecha_registro, usuario_dt_fecha_actualizacion, 
usuario_si_estatus) 
VALUES 
(1, "dani_glp", "dani@adm.com.mx", NULL, "Daniel", "Arteaga", "Rodriguez", 26, "1995-10-05", "5613915719", NULL, NOW(), NULL, 10),
(2, "richi_glp", "rrodri@adm.com.mx", NULL, "Ricardo", "Arteaga", "Rodriguez", 25, "1996-02-05", "5516324858", NULL, NOW(), NULL, 10),
(3, "pascual_glp", "pascual@adm.com.mx", NULL, "Pascual", "Martinez", "Resendiz", 60, "1960-04-02", "5598424785", NULL, NOW(), NULL, 10),
(4, "lourdes", "lourdes@gmail.com", NULL, "Lourdes", "Ortega", "Ramirez", 45, "1976-08-05", "5563123548", NULL, NOW(), NULL, 10),
(5, "mariano_2922", "mmar92@gmail.com", NULL, "Mariano", "Delgado", "Velez", 35, "1986-06-06", "5315864265", NULL, NOW(), NULL, 10),
(6, "mmartinez", "miguelangel@dgp.unam.mx", NULL, "Miguel Angel", "Martinez", "Rivera", 28, "1993-08-02", "5534385266", NULL, NOW(), NULL, 10);

INSERT INTO tr_usuario_rol(id_rol, id_usuario) VALUES 
(2, 1),
(2, 2),
(2, 3),
(3, 4),
(3, 5),
(1, 6);

INSERT INTO c_empleado(
id_usuario, empleado_i_num_trab, empleado_i_numero_ss, 
empleado_c_rfc_trab, empleado_dt_fecha_registro, empleado_dt_fecha_actualizacion, 
empleado_si_estatus) 
VALUES 
(1, 658912, '07-21-95-1235-1', 'DARA951005123', NOW(), NULL, 10),
(2, 123456, '07-21-96-6345-8', 'RIRA960205AJ1', NOW(), NULL, 10),
(3, 654321, '07-96-60-9645-8', 'PARM600402AR2', NOW(), NULL, 10);

INSERT INTO c_cliente(
id_usuario, cliente_i_numero, cliente_dt_fecha_registro, 
cliente_dt_fecha_actualizacion, cliente_si_estatus) 
VALUES 
(4, 1, NOW(), NULL, 10),
(5, 2, NOW(), NULL, 10);

INSERT INTO c_estado(estado_c_clave, estado_vc_nombre, estado_dt_fecha_registro, 
estado_dt_fecha_actualizacion, estado_si_estatus) 
VALUES 
('01', "Aguascalientes", NOW(), NULL, 20),
('02', "Baja California", NOW(), NULL, 20),
('03', "Baja California Sur", NOW(), NULL, 20),
('04', "Campeche", NOW(), NULL, 20),
('05', "Coahuila de Zaragoza", NOW(), NULL, 20),
('06', "Colima", NOW(), NULL, 20),
('07', "Chiapas", NOW(), NULL, 20),
('08', "Chihuahua", NOW(), NULL, 20),
('09', "Ciudad de México", NOW(), NULL, 20),
('10', "Durango", NOW(), NULL, 20),
('11', "Guanajuato", NOW(), NULL, 20),
('12', "Guerrero", NOW(), NULL, 20),
('13', "Hidalgo", NOW(), NULL, 20),
('14', "Jalisco", NOW(), NULL, 20),
('15', "México", NOW(), NULL, 10);

INSERT INTO c_municipio(id_estado, municipio_c_clave, municipio_vc_nombre, municipio_dt_fecha_registro, municipio_dt_fecha_actualizacion, municipio_si_estado) 
VALUES 
(15, '106', "Toluca", NOW(), NULL, 20),
(15, '001', "Acambay de Ruíz Castañeda", NOW(), NULL, 20),
(15, '121', "Cuautitlán Izcalli", NOW(), NULL, 10);

INSERT INTO c_asentamiento(
id_municipio, asenta_c_clave, asenta_c_codigo_postal, asenta_vc_tipo, asenta_vc_nombre, asenta_dt_fecha_registro, asenta_dt_fecha_actualizacion, asenta_si_estatus) 
VALUES 
(3, '3050', '54700', "Colonia", "Cuautitlán Izcalli Centro Urbano", NOW(), NULL, 10),
(3, '4654', '54715', "Fraccionamiento", "Ex-Hacienda San Miguel", NOW(), NULL, 20),
(3, '3122', '54743', "Unidad habitacional", "Fidel Velázquez", NOW(), NULL, 10),
(3, '3124', '54743', "Colonia", "Francisco Villa", NOW(), NULL, 10),
(3, '3131', '54743', "Unidad habitacional", "Plaza Dorada", NOW(), NULL, 10),
(3, '3132', '54743', "Colonia", "Santa María Guadalupe las Torres", NOW(), NULL, 10),
(3, '4861', '54743', "Unidad habitacional", "INFONAVIT Centro", NOW(), NULL, 10),
(3, '5570', '54743', "Unidad habitacional", "INFONAVIT Tepalcapa", NOW(), NULL, 10),
(3, '6507', '54743', "Unidad habitacional", "Campo 1", NOW(), NULL, 10);

INSERT INTO t_direccion(
id_asentamiento, direccion_vc_nombre, direccion_vc_referencias, 
direccion_dt_fecha_registro, direccion_dt_fecha_actualizacion, direccion_si_estatus) 
VALUES 
(6, "Calle Torre del Sur Mzna 323 Lote 8", "Saguan negro con perros", NOW(), NULL, 10),
(6, "Calle Torre Militar Mzna 385 Lote 1", "Árbol de naranjas", NOW(), NULL, 10),
(4, "Calle Torre Primavera Mzna 200 Lote 25", "Árbol de naranjas", NOW(), NULL, 10);

INSERT INTO tr_cliente_direccion(id_cliente, id_direccion) 
VALUES 
(1, 1),
(1, 2),
(2, 3);