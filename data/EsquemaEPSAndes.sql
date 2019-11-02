--- Sentencias SQL para la creación del esquema de EPSAndes
--- Las tablas tienen prefijo A_ para facilitar su acceso desde SQL Developer

-- USO
-- Copie el contenido de este archivo en una pestaña SQL de SQL Developer
-- Ejecútelo como un script - Utilice el botón correspondiente de la pestaña utilizada

-- Creación del secuenciador
create sequence epsandes_sequence;

-- Creaación de la tabla IPS y especificación de sus restricciones
CREATE TABLE A_IPS
   (
    ID NUMBER,
    LOCALIZACION VARCHAR2(255 BYTE), 
	NOMBRE VARCHAR2(255 BYTE), 
	CONSTRAINT A_IPS_PK PRIMARY KEY (ID)
	);

COMMIT;
