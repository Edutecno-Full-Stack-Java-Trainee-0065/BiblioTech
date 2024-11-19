-- 1. Obtener el total de préstamos por usuario en el mes de marzo, mostrando aquellos que han generado más de $50 en alquiler, ordenados por monto.
SELECT u.nombre, COUNT(p.id) as total_prestamos, SUM(p.total) as monto_total
FROM usuario u
         JOIN prestamo p ON u.id = p.usuario_id
WHERE p.fecha_prestamo >= '2024-03-01' AND p.fecha_prestamo < '2024-04-01'
GROUP BY u.id, u.nombre
HAVING SUM(p.total) > 50
ORDER BY monto_total DESC;
/*
     nombre      | total_prestamos | monto_total
-----------------+-----------------+-------------
 Roberto Méndez  |               1 |       66.50
 Patricia Flores |               1 |       59.50
 Laura Sánchez   |               1 |       56.00
 Fernando Ruiz   |               1 |       52.00
(4 rows)
*/

-- 2. Listar libros con bajo stock (menos de 5 copias) junto con su editorial y género.
SELECT
    l.titulo,
    l.copias_disponibles,
    e.nombre as editorial,
    g.nombre as genero,
    l.precio_alquiler
FROM libro l
         JOIN editorial e ON l.editorial_id = e.id
         JOIN genero_literario g ON l.genero_id = g.id
WHERE l.copias_disponibles < 5
ORDER BY l.copias_disponibles ASC;
/*
       titulo       | copias_disponibles | editorial |  genero   | precio_alquiler
--------------------+--------------------+-----------+-----------+-----------------
 El Ser y el Tiempo |                  3 | Paidós    | Filosofía |            4.00
 Poemas completos   |                  4 | Alfaguara | Poesía    |            3.50
(2 rows)
*/

-- 3. Mostrar multas pendientes de pago, incluyendo datos del usuario y monto adeudado.
SELECT u.nombre, u.email, m.numero_multa, m.fecha_emision, m.monto_total
FROM multa m
         JOIN prestamo p ON m.prestamo_id = p.id
         JOIN usuario u ON p.usuario_id = u.id
WHERE m.pagado = false;
/*
     nombre     |          email           | numero_multa |    fecha_emision    | monto_total
----------------+--------------------------+--------------+---------------------+-------------
 Ana García     | ana.garcia@email.com     | M2024001     | 2024-03-15 14:30:00 |       25.00
 Carlos López   | carlos.lopez@email.com   | M2024002     | 2024-03-17 11:20:00 |       15.00
 José Martínez  | jose.martinez@email.com  | M2024004     | 2024-03-22 16:40:00 |       10.00
 Roberto Méndez | roberto.mendez@email.com | M2024006     | 2024-03-27 13:45:00 |       20.00
 Fernando Ruiz  | fernando.ruiz@email.com  | M2024008     | 2024-03-30 11:10:00 |       15.00
 Daniel Torres  | daniel.torres@email.com  | M2024010     | 2024-03-10 16:50:00 |       10.00
(6 rows)
*/

-- 4. Obtener los 5 libros más prestados, mostrando cantidad de préstamos y monto generado.
SELECT l.titulo, COUNT(dp.id) as total_prestamos, SUM(dp.subtotal) as monto_total
FROM libro l
         JOIN detalle_prestamo dp ON l.id = dp.libro_id
GROUP BY l.id, l.titulo
ORDER BY total_prestamos DESC
LIMIT 5;
/*
        titulo        | total_prestamos | monto_total
----------------------+-----------------+-------------
 Don Quijote          |               4 |      140.00
 Cien años de soledad |               3 |       81.00
 El principito        |               3 |       36.00
 Algebra Lineal       |               2 |       90.00
 Dune                 |               1 |       33.00
(5 rows)
*/

-- 5. Mostrar resumen de pagos de multas por método de pago del mes de marzo.
SELECT
    pm.metodo_pago,
    COUNT(*) as num_transacciones,
    SUM(pm.monto) as monto_total,
    ROUND(AVG(pm.monto), 2) as monto_promedio,
    MIN(pm.monto) as monto_minimo,
    MAX(pm.monto) as monto_maximo,
    COUNT(DISTINCT multa_id) as multas_distintas
FROM pago_multa pm
WHERE pm.fecha >= DATE_TRUNC('month', DATE '2024-03-01')
  AND pm.fecha < DATE_TRUNC('month', DATE '2024-03-01' + INTERVAL '1 month')
GROUP BY pm.metodo_pago
ORDER BY monto_total DESC;
/*
  metodo_pago  | num_transacciones | monto_total | monto_promedio | monto_minimo | monto_maximo | multas_distintas
---------------+-------------------+-------------+----------------+--------------+--------------+------------------
 Transferencia |                 4 |       95.00 |          23.75 |        20.00 |        27.50 |                4
 Tarjeta       |                 3 |       88.00 |          29.33 |        15.00 |        40.00 |                3
 Efectivo      |                 3 |       63.00 |          21.00 |        10.00 |        35.00 |                3
(3 rows)
*/