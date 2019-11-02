--- Sentencias SQL para la creaci�n del esquema de EPSAndes
--- Las tablas tienen prefijo A_ para facilitar su acceso desde SQL Developer

-- USO
-- Copie el contenido de este archivo en una pesta�a SQL de SQL Developer
-- Ejec�telo como un script - Utilice el bot�n correspondiente de la pesta�a utilizada

-- Creaci�n del secuenciador
create sequence epsandes_sequence;

-- Creaaci�n de la tabla IPS y especificaci�n de sus restricciones
CREATE TABLE A_IPS
   (
    ID NUMBER,
    LOCALIZACION VARCHAR2(255 BYTE), 
	NOMBRE VARCHAR2(255 BYTE), 
	CONSTRAINT A_IPS_PK PRIMARY KEY (ID)
	);

COMMIT;
