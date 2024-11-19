CREATE TABLE "usuario" (
                           "id" SERIAL PRIMARY KEY,
                           "nombre" VARCHAR(100) NOT NULL,
                           "email" VARCHAR(100) UNIQUE NOT NULL,
                           "telefono" VARCHAR(15),
                           "direccion" VARCHAR(255),
                           "fecha_registro" TIMESTAMP DEFAULT (NOW()),
                           "activo" BOOLEAN DEFAULT true
);

CREATE TABLE "editorial" (
                             "id" SERIAL PRIMARY KEY,
                             "nombre" VARCHAR(100) NOT NULL,
                             "email" VARCHAR(100),
                             "telefono" VARCHAR(15),
                             "direccion" VARCHAR(255),
                             "contacto" VARCHAR(100)
);

CREATE TABLE "genero_literario" (
                                    "id" SERIAL PRIMARY KEY,
                                    "nombre" VARCHAR(100) NOT NULL,
                                    "descripcion" TEXT
);

CREATE TABLE "libro" (
                         "id" SERIAL PRIMARY KEY,
                         "titulo" VARCHAR(100) NOT NULL,
                         "descripcion" TEXT,
                         "precio_alquiler" NUMERIC(10,2) NOT NULL,
                         "copias_disponibles" INTEGER NOT NULL DEFAULT 0,
                         "fecha_adquisicion" TIMESTAMP DEFAULT (NOW()),
                         "editorial_id" INT REFERENCES "editorial" ("id"),
                         "genero_id" INT REFERENCES "genero_literario" ("id")
);

CREATE TABLE "prestamo" (
                            "id" SERIAL PRIMARY KEY,
                            "numero_prestamo" VARCHAR(50) UNIQUE NOT NULL,
                            "fecha_prestamo" TIMESTAMP DEFAULT (NOW()),
                            "usuario_id" INT REFERENCES "usuario" ("id"),
                            "total" NUMERIC(10,2) NOT NULL DEFAULT 0
);

CREATE TABLE "detalle_prestamo" (
                                    "id" SERIAL PRIMARY KEY,
                                    "dias_prestamo" INT NOT NULL,
                                    "precio_por_dia" NUMERIC(10,2) NOT NULL,
                                    "subtotal" NUMERIC(10,2),
                                    "libro_id" INT REFERENCES "libro" ("id"),
                                    "prestamo_id" INT REFERENCES "prestamo" ("id") ON DELETE CASCADE
);

CREATE TABLE multa (
                       id SERIAL PRIMARY KEY,
                       numero_multa VARCHAR(50) NOT NULL UNIQUE,
                       fecha_emision TIMESTAMP,
                       monto_total NUMERIC(10,2) NOT NULL,
                       estado VARCHAR(50) NOT NULL CHECK (estado IN ('PAGADA', 'PENDIENTE', 'SIN_MULTA')),
                       prestamo_id BIGINT UNIQUE REFERENCES prestamo(id) ON DELETE CASCADE,
                       CONSTRAINT multa_estado_check CHECK (estado IN ('PAGADA', 'PENDIENTE', 'SIN_MULTA'))
);

CREATE TABLE "pago_multa" (
                              "id" SERIAL PRIMARY KEY,
                              "monto" NUMERIC(10,2) NOT NULL,
                              "fecha" TIMESTAMP DEFAULT (NOW()),
                              "metodo_pago" VARCHAR(50),
                              "multa_id" INT REFERENCES "multa" ("id") ON DELETE CASCADE
);
