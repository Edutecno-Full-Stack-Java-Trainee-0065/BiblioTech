-- Usuarios
INSERT INTO usuario (nombre, email, telefono, direccion, fecha_registro) VALUES ('Ana García', 'ana.garcia@email.com', '555-0101', 'Calle Principal 123', '2024-01-15 09:30:00');
INSERT INTO usuario (nombre, email, telefono, direccion, fecha_registro) VALUES ('Carlos López', 'carlos.lopez@email.com', '555-0102', 'Avenida Central 456', '2024-01-20 14:15:00');
INSERT INTO usuario (nombre, email, telefono, direccion, fecha_registro) VALUES ('María Rodríguez', 'maria.rodriguez@email.com', '555-0103', 'Plaza Mayor 789', '2024-02-01 11:45:00');
INSERT INTO usuario (nombre, email, telefono, direccion, fecha_registro) VALUES ('José Martínez', 'jose.martinez@email.com', '555-0104', 'Calle Secundaria 321', '2024-02-10 16:20:00');
INSERT INTO usuario (nombre, email, telefono, direccion, fecha_registro) VALUES ('Laura Sánchez', 'laura.sanchez@email.com', '555-0105', 'Avenida Norte 654', '2024-02-15 10:00:00');
INSERT INTO usuario (nombre, email, telefono, direccion, fecha_registro) VALUES ('Roberto Méndez', 'roberto.mendez@email.com', '555-0201', 'Paseo del Sol 765', '2024-02-28 13:30:00');
INSERT INTO usuario (nombre, email, telefono, direccion, fecha_registro) VALUES ('Patricia Flores', 'patricia.flores@email.com', '555-0202', 'Boulevard Luna 432', '2024-03-05 15:45:00');
INSERT INTO usuario (nombre, email, telefono, direccion, fecha_registro) VALUES ('Fernando Ruiz', 'fernando.ruiz@email.com', '555-0203', 'Callejón Verde 987', '2024-03-10 12:15:00');
INSERT INTO usuario (nombre, email, telefono, direccion, fecha_registro) VALUES ('Carmen Vega', 'carmen.vega@email.com', '555-0204', 'Avenida Mar 543', '2024-03-15 09:00:00');
INSERT INTO usuario (nombre, email, telefono, direccion, fecha_registro) VALUES ('Daniel Torres', 'daniel.torres@email.com', '555-0205', 'Plaza del Rio 876', '2024-03-20 17:30:00');

-- Editoriales
INSERT INTO editorial (nombre, email, telefono, direccion, contacto) VALUES ('Planeta', 'contacto@planeta.com', '555-1001', 'Calle Editorial 123', 'Juan Editor');
INSERT INTO editorial (nombre, email, telefono, direccion, contacto) VALUES ('Penguin Random House', 'contacto@penguinrh.com', '555-1002', 'Avenida Libros 456', 'María Editora');
INSERT INTO editorial (nombre, email, telefono, direccion, contacto) VALUES ('Anagrama', 'contacto@anagrama.com', '555-1003', 'Plaza Letras 789', 'Pedro Editor');
INSERT INTO editorial (nombre, email, telefono, direccion, contacto) VALUES ('Alfaguara', 'contacto@alfaguara.com', '555-1004', 'Calle Literatura 321', 'Ana Editora');
INSERT INTO editorial (nombre, email, telefono, direccion, contacto) VALUES ('Salamandra', 'contacto@salamandra.com', '555-1005', 'Avenida Biblioteca 654', 'Luis Editor');
INSERT INTO editorial (nombre, email, telefono, direccion, contacto) VALUES ('Tusquets', 'contacto@tusquets.com', '555-2001', 'Avenida Cultura 789', 'Rosa Editora');
INSERT INTO editorial (nombre, email, telefono, direccion, contacto) VALUES ('Seix Barral', 'contacto@seixbarral.com', '555-2002', 'Calle Libro 234', 'Carlos Editor');
INSERT INTO editorial (nombre, email, telefono, direccion, contacto) VALUES ('Paidós', 'contacto@paidos.com', '555-2003', 'Boulevard Arte 567', 'Diana Editora');
INSERT INTO editorial (nombre, email, telefono, direccion, contacto) VALUES ('FCE', 'contacto@fce.com', '555-2004', 'Paseo Cultural 890', 'Miguel Editor');
INSERT INTO editorial (nombre, email, telefono, direccion, contacto) VALUES ('Grijalbo', 'contacto@grijalbo.com', '555-2005', 'Calle Autor 123', 'Paula Editora');


-- Géneros Literarios
INSERT INTO genero_literario (nombre, descripcion) VALUES ('Novela', 'Obras literarias extensas de ficción');
INSERT INTO genero_literario (nombre, descripcion) VALUES ('Poesía', 'Obras literarias en verso');
INSERT INTO genero_literario (nombre, descripcion) VALUES ('Ensayo', 'Obras de reflexión y análisis');
INSERT INTO genero_literario (nombre, descripcion) VALUES ('Académico', 'Libros de texto y consulta');
INSERT INTO genero_literario (nombre, descripcion) VALUES ('Infantil', 'Literatura para niños');
INSERT INTO genero_literario (nombre, descripcion) VALUES ('Ciencia Ficción', 'Narrativas futuristas y especulativas');
INSERT INTO genero_literario (nombre, descripcion) VALUES ('Historia', 'Obras sobre eventos históricos');
INSERT INTO genero_literario (nombre, descripcion) VALUES ('Filosofía', 'Textos de pensamiento y reflexión');
INSERT INTO genero_literario (nombre, descripcion) VALUES ('Biografía', 'Historias de vida de personajes relevantes');
INSERT INTO genero_literario (nombre, descripcion) VALUES ('Teatro', 'Obras dramáticas y guiones teatrales');

-- Libros
INSERT INTO libro (titulo, descripcion, precio_alquiler, copias_disponibles, editorial_id, genero_id) VALUES ('Don Quijote', 'Obra maestra de Cervantes', 5.00, 8, 1, 1);
INSERT INTO libro (titulo, descripcion, precio_alquiler, copias_disponibles, editorial_id, genero_id) VALUES ('Cien años de soledad', 'Realismo mágico de García Márquez', 4.50, 6, 2, 1);
INSERT INTO libro (titulo, descripcion, precio_alquiler, copias_disponibles, editorial_id, genero_id) VALUES ('Algebra Lineal', 'Libro de matemáticas avanzadas', 6.00, 12, 3, 4);
INSERT INTO libro (titulo, descripcion, precio_alquiler, copias_disponibles, editorial_id, genero_id) VALUES ('Poemas completos', 'Antología poética', 3.50, 4, 4, 2);
INSERT INTO libro (titulo, descripcion, precio_alquiler, copias_disponibles, editorial_id, genero_id) VALUES ('El principito', 'Clásico infantil', 3.00, 10, 5, 5);
INSERT INTO libro (titulo, descripcion, precio_alquiler, copias_disponibles, editorial_id, genero_id) VALUES ('Dune', 'Clásico de ciencia ficción', 5.50, 7, 6, 6);
INSERT INTO libro (titulo, descripcion, precio_alquiler, copias_disponibles, editorial_id, genero_id) VALUES ('Historia de Roma', 'Análisis histórico detallado', 6.50, 5, 7, 7);
INSERT INTO libro (titulo, descripcion, precio_alquiler, copias_disponibles, editorial_id, genero_id) VALUES ('El Ser y el Tiempo', 'Obra filosófica fundamental', 4.00, 3, 8, 8);
INSERT INTO libro (titulo, descripcion, precio_alquiler, copias_disponibles, editorial_id, genero_id) VALUES ('Einstein: Su vida', 'Biografía del físico', 5.00, 6, 9, 9);
INSERT INTO libro (titulo, descripcion, precio_alquiler, copias_disponibles, editorial_id, genero_id) VALUES ('Hamlet', 'Obra teatral de Shakespeare', 3.50, 8, 10, 10);

-- Préstamos
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024001', 1, 15.00, '2024-03-05 10:30:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024002', 2, 12.00, '2024-03-07 11:15:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024003', 3, 18.00, '2024-03-10 14:20:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024004', 4, 9.00, '2024-03-12 16:45:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024005', 5, 56.00, '2024-03-15 09:30:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024006', 6, 66.50, '2024-03-17 13:20:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024007', 7, 59.50, '2024-03-18 15:10:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024008', 8, 52.00, '2024-03-20 11:45:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024009', 9, 55.00, '2024-02-15 14:30:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024010', 10, 50.50, '2024-02-20 16:20:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024011', 1, 45.00, '2024-03-21 10:00:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024012', 2, 35.00, '2024-03-22 11:30:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024013', 3, 40.00, '2024-03-23 14:15:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024014', 4, 30.00, '2024-03-24 16:00:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024015', 5, 25.00, '2024-03-25 09:45:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024016', 6, 38.00, '2024-03-26 13:20:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024017', 7, 42.00, '2024-03-27 15:45:00');
INSERT INTO prestamo (numero_prestamo, usuario_id, total, fecha_prestamo) VALUES ('P2024018', 8, 33.00, '2024-03-28 10:30:00');

-- Detalles de Préstamos
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (7, 5.00, 35.00, 1, 1);
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (5, 4.50, 22.50, 2, 2);
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (10, 6.00, 60.00, 3, 3);
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (4, 3.50, 14.00, 4, 4);
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (3, 3.00, 9.00, 5, 5);
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (6, 5.50, 33.00, 6, 6);
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (8, 6.50, 52.00, 7, 7);
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (5, 4.00, 20.00, 8, 8);
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (7, 5.00, 35.00, 9, 9);
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (4, 3.50, 14.00, 10, 10);
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (8, 5.00, 40.00, 1, 11);  -- Don Quijote
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (7, 5.00, 35.00, 1, 12);  -- Don Quijote
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (6, 4.50, 27.00, 2, 13);  -- Cien años de soledad
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (5, 6.00, 30.00, 3, 14);  -- Algebra Lineal
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (4, 3.00, 12.00, 5, 15);  -- El principito
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (6, 5.00, 30.00, 1, 16);  -- Don Quijote otra vez
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (7, 4.50, 31.50, 2, 17);  -- Cien años de soledad
INSERT INTO detalle_prestamo (dias_prestamo, precio_por_dia, subtotal, libro_id, prestamo_id) VALUES (5, 3.00, 15.00, 5, 18);  -- El principito

-- Multas
INSERT INTO multa (numero_multa, monto_total, prestamo_id, fecha_emision) VALUES ('M2024001', 25.00, 1, '2024-03-15 14:30:00');
INSERT INTO multa (numero_multa, monto_total, prestamo_id, fecha_emision) VALUES ('M2024002', 15.00, 2, '2024-03-17 11:20:00');
INSERT INTO multa (numero_multa, monto_total, prestamo_id, pagado, fecha_emision) VALUES ('M2024003', 30.00, 3, true, '2024-03-20 09:15:00');
INSERT INTO multa (numero_multa, monto_total, prestamo_id, fecha_emision) VALUES ('M2024004', 10.00, 4, '2024-03-22 16:40:00');
INSERT INTO multa (numero_multa, monto_total, prestamo_id, pagado, fecha_emision) VALUES ('M2024005', 5.00, 5, true, '2024-03-25 10:30:00');
INSERT INTO multa (numero_multa, monto_total, prestamo_id, fecha_emision) VALUES ('M2024006', 20.00, 6, '2024-03-27 13:45:00');
INSERT INTO multa (numero_multa, monto_total, prestamo_id, pagado, fecha_emision) VALUES ('M2024007', 35.00, 7, true, '2024-03-28 15:20:00');
INSERT INTO multa (numero_multa, monto_total, prestamo_id, fecha_emision) VALUES ('M2024008', 15.00, 8, '2024-03-30 11:10:00');
INSERT INTO multa (numero_multa, monto_total, prestamo_id, pagado, fecha_emision) VALUES ('M2024009', 25.00, 9, true, '2024-03-05 14:25:00');
INSERT INTO multa (numero_multa, monto_total, prestamo_id, fecha_emision) VALUES ('M2024010', 10.00, 10, '2024-03-10 16:50:00');

-- Pagos de Multas
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (25.00, 'Efectivo', 1, '2024-02-15 10:30:00');
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (15.00, 'Tarjeta', 2, '2024-02-16 11:45:00');
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (30.00, 'Transferencia', 3, '2024-02-18 14:20:00');
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (10.00, 'Efectivo', 4, '2024-02-20 16:30:00');
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (5.00, 'Tarjeta', 5, '2024-02-22 09:15:00');
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (20.00, 'Transferencia', 6, '2024-03-05 13:20:00');
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (35.00, 'Efectivo', 7, '2024-03-08 15:40:00');
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (15.00, 'Tarjeta', 8, '2024-03-10 11:25:00');
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (25.00, 'Transferencia', 9, '2024-03-12 14:50:00');
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (10.00, 'Efectivo', 10, '2024-03-15 16:30:00');
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (40.00, 'Tarjeta', 1, '2024-03-18 10:15:00');
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (22.50, 'Transferencia', 2, '2024-03-20 11:30:00');
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (18.00, 'Efectivo', 3, '2024-03-22 14:45:00');
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (33.00, 'Tarjeta', 4, '2024-03-24 16:20:00');
INSERT INTO pago_multa (monto, metodo_pago, multa_id, fecha) VALUES (27.50, 'Transferencia', 5, '2024-03-25 09:40:00');
