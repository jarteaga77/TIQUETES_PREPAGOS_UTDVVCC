--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: bucardo; Type: SCHEMA; Schema: -; Owner: bucardo
--

CREATE SCHEMA bucardo;


ALTER SCHEMA bucardo OWNER TO bucardo;

--
-- Name: clientes; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA clientes;


ALTER SCHEMA clientes OWNER TO postgres;

--
-- Name: consignacion_saldos; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA consignacion_saldos;


ALTER SCHEMA consignacion_saldos OWNER TO postgres;

--
-- Name: controles_arqueos; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA controles_arqueos;


ALTER SCHEMA controles_arqueos OWNER TO postgres;

--
-- Name: dependencias; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA dependencias;


ALTER SCHEMA dependencias OWNER TO postgres;

--
-- Name: inventario; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA inventario;


ALTER SCHEMA inventario OWNER TO postgres;

--
-- Name: ventas; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA ventas;


ALTER SCHEMA ventas OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = bucardo, pg_catalog;

--
-- Name: bucardo_add_delta_cat_id(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_cat_id() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."cat_id"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."cat_id"::text);
     IF (OLD."cat_id" <> NEW."cat_id") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."cat_id"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."cat_id"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_cat_id() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_cban_id(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_cban_id() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."cban_id"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."cban_id"::text);
     IF (OLD."cban_id" <> NEW."cban_id") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."cban_id"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."cban_id"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_cban_id() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_cedula(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_cedula() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."cedula"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."cedula"::text);
     IF (OLD."cedula" <> NEW."cedula") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."cedula"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."cedula"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_cedula() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_ciu_id(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_ciu_id() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."ciu_id"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."ciu_id"::text);
     IF (OLD."ciu_id" <> NEW."ciu_id") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."ciu_id"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."ciu_id"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_ciu_id() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_cli_nit(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_cli_nit() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."cli_nit"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."cli_nit"::text);
     IF (OLD."cli_nit" <> NEW."cli_nit") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."cli_nit"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."cli_nit"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_cli_nit() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_codigo_peaje(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_codigo_peaje() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."codigo_peaje"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."codigo_peaje"::text);
     IF (OLD."codigo_peaje" <> NEW."codigo_peaje") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."codigo_peaje"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."codigo_peaje"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_codigo_peaje() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_cons_id(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_cons_id() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."cons_id"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."cons_id"::text);
     IF (OLD."cons_id" <> NEW."cons_id") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."cons_id"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."cons_id"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_cons_id() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_conse_num_consecutivo_tiqute(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_conse_num_consecutivo_tiqute() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."conse_num_consecutivo_tiqute"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."conse_num_consecutivo_tiqute"::text);
     IF (OLD."conse_num_consecutivo_tiqute" <> NEW."conse_num_consecutivo_tiqute") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."conse_num_consecutivo_tiqute"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."conse_num_consecutivo_tiqute"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_conse_num_consecutivo_tiqute() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_da_idanulacion(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_da_idanulacion() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."da_idanulacion"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."da_idanulacion"::text);
     IF (OLD."da_idanulacion" <> NEW."da_idanulacion") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."da_idanulacion"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."da_idanulacion"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_da_idanulacion() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_dep_id(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_dep_id() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."dep_id"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."dep_id"::text);
     IF (OLD."dep_id" <> NEW."dep_id") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."dep_id"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."dep_id"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_dep_id() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_dv_id(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_dv_id() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."dv_id"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."dv_id"::text);
     IF (OLD."dv_id" <> NEW."dv_id") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."dv_id"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."dv_id"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_dv_id() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_dvd_id(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_dvd_id() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."dvd_id"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."dvd_id"::text);
     IF (OLD."dvd_id" <> NEW."dvd_id") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."dvd_id"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."dvd_id"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_dvd_id() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_fp_id(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_fp_id() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."fp_id"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."fp_id"::text);
     IF (OLD."fp_id" <> NEW."fp_id") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."fp_id"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."fp_id"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_fp_id() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_acta_consecutivo(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_acta_consecutivo() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_acta_consecutivo"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_acta_consecutivo"::text);
     IF (OLD."id_acta_consecutivo" <> NEW."id_acta_consecutivo") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_acta_consecutivo"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_acta_consecutivo"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_acta_consecutivo() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_anulacion_recibo(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_anulacion_recibo() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_anulacion_recibo"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_anulacion_recibo"::text);
     IF (OLD."id_anulacion_recibo" <> NEW."id_anulacion_recibo") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_anulacion_recibo"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_anulacion_recibo"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_anulacion_recibo() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_anulacion_tiquete(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_anulacion_tiquete() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_anulacion_tiquete"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_anulacion_tiquete"::text);
     IF (OLD."id_anulacion_tiquete" <> NEW."id_anulacion_tiquete") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_anulacion_tiquete"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_anulacion_tiquete"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_anulacion_tiquete() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_arq(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_arq() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_arq"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_arq"::text);
     IF (OLD."id_arq" <> NEW."id_arq") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_arq"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_arq"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_arq() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_arqueo_categoria(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_arqueo_categoria() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_arqueo_categoria"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_arqueo_categoria"::text);
     IF (OLD."id_arqueo_categoria" <> NEW."id_arqueo_categoria") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_arqueo_categoria"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_arqueo_categoria"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_arqueo_categoria() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_arqueo_general(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_arqueo_general() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_arqueo_general"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_arqueo_general"::text);
     IF (OLD."id_arqueo_general" <> NEW."id_arqueo_general") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_arqueo_general"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_arqueo_general"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_arqueo_general() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_can_exce(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_can_exce() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_can_exce"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_can_exce"::text);
     IF (OLD."id_can_exce" <> NEW."id_can_exce") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_can_exce"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_can_exce"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_can_exce() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_cliente_sede(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_cliente_sede() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_cliente_sede"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_cliente_sede"::text);
     IF (OLD."id_cliente_sede" <> NEW."id_cliente_sede") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_cliente_sede"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_cliente_sede"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_cliente_sede() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_consignacion(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_consignacion() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_consignacion"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_consignacion"::text);
     IF (OLD."id_consignacion" <> NEW."id_consignacion") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_consignacion"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_consignacion"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_consignacion() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_dependencia(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_dependencia() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_dependencia"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_dependencia"::text);
     IF (OLD."id_dependencia" <> NEW."id_dependencia") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_dependencia"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_dependencia"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_dependencia() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_det_en_peaje(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_det_en_peaje() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_det_en_peaje"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_det_en_peaje"::text);
     IF (OLD."id_det_en_peaje" <> NEW."id_det_en_peaje") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_det_en_peaje"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_det_en_peaje"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_det_en_peaje() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_det_remision(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_det_remision() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_det_remision"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_det_remision"::text);
     IF (OLD."id_det_remision" <> NEW."id_det_remision") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_det_remision"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_det_remision"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_det_remision() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_detalle_devolucion(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_detalle_devolucion() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_detalle_devolucion"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_detalle_devolucion"::text);
     IF (OLD."id_detalle_devolucion" <> NEW."id_detalle_devolucion") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_detalle_devolucion"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_detalle_devolucion"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_detalle_devolucion() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_detalle_entregado(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_detalle_entregado() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_detalle_entregado"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_detalle_entregado"::text);
     IF (OLD."id_detalle_entregado" <> NEW."id_detalle_entregado") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_detalle_entregado"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_detalle_entregado"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_detalle_entregado() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_detalle_recibido(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_detalle_recibido() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_detalle_recibido"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_detalle_recibido"::text);
     IF (OLD."id_detalle_recibido" <> NEW."id_detalle_recibido") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_detalle_recibido"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_detalle_recibido"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_detalle_recibido() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_devolucion_dinero(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_devolucion_dinero() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_devolucion_dinero"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_devolucion_dinero"::text);
     IF (OLD."id_devolucion_dinero" <> NEW."id_devolucion_dinero") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_devolucion_dinero"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_devolucion_dinero"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_devolucion_dinero() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_dv(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_dv() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_dv"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_dv"::text);
     IF (OLD."id_dv" <> NEW."id_dv") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_dv"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_dv"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_dv() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_en_tiq(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_en_tiq() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_en_tiq"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_en_tiq"::text);
     IF (OLD."id_en_tiq" <> NEW."id_en_tiq") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_en_tiq"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_en_tiq"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_en_tiq() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_item_depen(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_item_depen() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_item_depen"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_item_depen"::text);
     IF (OLD."id_item_depen" <> NEW."id_item_depen") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_item_depen"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_item_depen"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_item_depen() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_pa_va(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_pa_va() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_pa_va"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_pa_va"::text);
     IF (OLD."id_pa_va" <> NEW."id_pa_va") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_pa_va"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_pa_va"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_pa_va() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_reg(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_reg() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_reg"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_reg"::text);
     IF (OLD."id_reg" <> NEW."id_reg") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_reg"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_reg"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_reg() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_remision_peaje(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_remision_peaje() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_remision_peaje"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_remision_peaje"::text);
     IF (OLD."id_remision_peaje" <> NEW."id_remision_peaje") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_remision_peaje"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_remision_peaje"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_remision_peaje() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_revalidacion(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_revalidacion() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_revalidacion"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_revalidacion"::text);
     IF (OLD."id_revalidacion" <> NEW."id_revalidacion") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_revalidacion"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_revalidacion"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_revalidacion() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_id_validacion(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_id_validacion() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_validacion"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_validacion"::text);
     IF (OLD."id_validacion" <> NEW."id_validacion") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."id_validacion"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."id_validacion"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_id_validacion() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_pa_id(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_pa_id() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."pa_id"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."pa_id"::text);
     IF (OLD."pa_id" <> NEW."pa_id") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."pa_id"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."pa_id"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_pa_id() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_pag_id(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_pag_id() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."pag_id"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."pag_id"::text);
     IF (OLD."pag_id" <> NEW."pag_id") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."pag_id"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."pag_id"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_pag_id() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_pago_ven_dep(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_pago_ven_dep() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."pago_ven_dep"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."pago_ven_dep"::text);
     IF (OLD."pago_ven_dep" <> NEW."pago_ven_dep") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."pago_ven_dep"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."pago_ven_dep"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_pago_ven_dep() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_pk_audit(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_pk_audit() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."pk_audit"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."pk_audit"::text);
     IF (OLD."pk_audit" <> NEW."pk_audit") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."pk_audit"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."pk_audit"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_pk_audit() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_tea_id(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_tea_id() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."tea_id"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."tea_id"::text);
     IF (OLD."tea_id" <> NEW."tea_id") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."tea_id"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."tea_id"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_tea_id() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_ven_dep_id(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_ven_dep_id() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."ven_dep_id"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."ven_dep_id"::text);
     IF (OLD."ven_dep_id" <> NEW."ven_dep_id") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."ven_dep_id"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."ven_dep_id"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_ven_dep_id() OWNER TO bucardo;

--
-- Name: bucardo_add_delta_ven_id(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_add_delta_ven_id() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
 oldtime TEXT;
                    BEGIN
   SELECT INTO oldtime setting FROM pg_settings WHERE name = 'TimeZone';
   SET TIME ZONE 'GMT';
   IF (TG_OP = 'INSERT') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."ven_id"::text);
   ELSIF (TG_OP = 'UPDATE') THEN
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."ven_id"::text);
     IF (OLD."ven_id" <> NEW."ven_id") THEN
       INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, NEW."ven_id"::text);
     END IF;
   ELSE
     INSERT INTO bucardo.bucardo_delta(tablename,rowid) VALUES (TG_RELID, OLD."ven_id"::text);
   END IF;
   EXECUTE($$SET TIME ZONE '$$||oldtime||$$'$$);
   RETURN NULL;
                    END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_add_delta_ven_id() OWNER TO bucardo;

--
-- Name: bucardo_audit(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_audit() RETURNS text
    LANGUAGE plpgsql
    AS $_$
DECLARE
  fmsg TEXT = $clone2$SET LOCAL search_path = 'bucardo';$clone2$;
  myst TEXT;
  myrec RECORD;
  myrec2 RECORD;
  mycount INT;
  myvar TEXT;
  mytablename TEXT;
  delcount INT;
  delcount2 INT;

BEGIN

-- This function attempts to cleanup various Bucardo-related problems that may exist.
-- Usage is to simply call it, then examine and carefully apply the output
-- Items checked
-- * Partial indexes on bucardo_delta for tables (oids) that no longer exist.
-- * Indexes on bucardo_delta that refer to tables without a 'bucardo_add_delta' trigger.
-- * Every table with a 'bucardo_add_delta' trigger has rowid and txntime triggers on bucardo_delta.
-- * There are no other triggers on the bucardo_delta for such tables.
-- * Check for name/oid matching on the two bucardo_delta indexes above.
-- * Tables that have bucardo_add_delta but no entry in bucardo_delta_targets table
-- * Index exists: bucardo_delta_txntime
-- * Index exists: bucardo_delta_rowid_all
-- * Unknown indexes on bucardo_delta
-- * Rows in bucardo_delta that refer to invalid tables (oids)
-- * Rows in bucardo_delta that refer to tables without a bucardo_add_delta trigger
-- * Index exists: bucardo_track_target
-- * Unknown indexes on bucardo_track
-- * Rows in bucardo_track that refer to invalid tables (oids)
-- * Rows in bucardo_track that refer to tables without a bucardo_add_delta trigger
-- * Rows in bucardo_delta_targets that are invalid tablenames (oids)

-- Make sure that bucardo is in our search_path
PERFORM set_config('search_path','bucardo,'
  || (SELECT current_setting('search_path')),'f');

-- Gather important information into temp tables

-- Generate a list of all indexes on bucardo_delta
-- Identify which tables they are on, as well as which columns
-- This is a left join as there may be stale entries
-- If this table alredy exists in this session, drop it
PERFORM 1 FROM information_schema.tables WHERE table_type = 'LOCAL TEMPORARY'
  AND table_name = 'bucardo_audit_delta_index';
IF FOUND THEN 
  DROP TABLE bucardo_audit_delta_index;
END IF;
CREATE TEMP TABLE bucardo_audit_delta_index AS
  SELECT foo.*, c.relname AS tablename FROM
  ( SELECT c.relname AS indexname, c.oid AS indyoid,
    pg_get_indexdef(indexrelid) AS indexdef,
    substring(pg_get_indexdef(indexrelid) FROM E'\\((\\d+)') AS targetoid,
    substring(pg_get_indexdef(indexrelid) FROM E'\\(+([^\\)]+)') AS targetcol
    FROM pg_index i
    JOIN pg_class c ON (c.oid = indexrelid)
    WHERE indrelid = 'bucardo_delta'::regclass
    ORDER BY c.relname
  ) AS foo
  LEFT JOIN pg_class c ON (c.oid = foo.targetoid::oid);

-- Gather a list of indexes for bucardo_track
PERFORM 1 FROM information_schema.tables WHERE table_type = 'LOCAL TEMPORARY'
  AND table_name = 'bucardo_audit_track_index';
IF FOUND THEN 
  DROP TABLE bucardo_audit_track_index;
END IF;
CREATE TEMP TABLE bucardo_audit_track_index AS
  SELECT foo.*, c.relname AS tablename FROM
  ( SELECT c.relname AS indexname, c.oid AS indyoid,
    pg_get_indexdef(indexrelid) AS indexdef,
    substring(pg_get_indexdef(indexrelid) FROM E'\\((\\d+)') AS targetoid,
    substring(pg_get_indexdef(indexrelid) FROM E'\\(+([^\\)]+)') AS targetcol
    FROM pg_index i
    JOIN pg_class c ON (c.oid = indexrelid)
    WHERE indrelid = 'bucardo_track'::regclass
    ORDER BY c.relname
  ) AS foo
  LEFT JOIN pg_class c ON (c.oid = foo.targetoid::oid);

-- Gather a list of triggers that contain the string 'bucardo'
PERFORM 1 FROM information_schema.tables WHERE table_type = 'LOCAL TEMPORARY'
  AND table_name = 'bucardo_audit_table_triggers';
IF FOUND THEN 
  DROP TABLE bucardo_audit_table_triggers;
END IF;
CREATE TEMP TABLE bucardo_audit_table_triggers AS
  SELECT tgname AS trigname, nspname AS schemaname, relname AS tablename, c.oid AS toid
  FROM pg_trigger t
  JOIN pg_class c ON (c.oid = t.tgrelid)
  JOIN pg_namespace n ON (n.oid = c.relnamespace AND n.nspname <> 'bucardo')
  WHERE tgname ~ 'bucardo';

-- Drop any partial indexes on bucardo_delta that refer to invalid tables (oids)
FOR myrec IN
  SELECT indexname, targetoid
  FROM bucardo_audit_delta_index
  WHERE targetoid IS NOT NULL
  AND tablename IS NULL
LOOP
  fmsg = fmsg
    || chr(10)
    || 'Dropping index "'
    || myrec.indexname
    || '": refers to non-existent table '
    || myrec.targetoid
    || chr(10)
    || 'DROP INDEX '
    || quote_ident(myrec.indexname)
    || ';';
END LOOP;

-- Drop any indexes on bucardo_delta that refer to tables without bucardo triggers
FOR myrec IN
  SELECT tablename, indexname, targetoid
  FROM bucardo_audit_delta_index
  WHERE tablename IS NOT NULL
LOOP
  PERFORM 1 FROM bucardo_audit_table_triggers WHERE toid::text = myrec.targetoid
    AND trigname = 'bucardo_add_delta';
  IF NOT FOUND THEN
    fmsg = fmsg
      || chr(10)
      || '-- bucardo_delta has index for '
      || myrec.tablename
      || ' ('
      || myrec.targetoid
      || '), but it has no bucardo_add_delta trigger'
      || chr(10)
      || 'DROP INDEX '
      || quote_ident(myrec.indexname)
      || ';';
  END IF;
END LOOP;

-- Check for correct number of triggers on bucardo_delta for each table that has 
--     a bucardo_add_delta trigger
--   Check that one exists for the rowid
--   Check that one exists for the txntime
-- Check that each of those tables is mentioned in bucardo_delta_targets
FOR myrec IN
  SELECT schemaname, tablename, toid
  FROM bucardo_audit_table_triggers
  WHERE trigname = 'bucardo_add_delta'
LOOP
  SELECT INTO mycount count(*) FROM bucardo_audit_delta_index WHERE targetoid = myrec.toid::text;
  -- Should have no more than two
  IF mycount > 2 THEN
    fmsg = fmsg
      || chr(10)
      || '-- bucardo_delta has wrong number ('
      || mycount::text
      || ') of indexes for table '
      || myrec.schemaname
      || '.'
      || myrec.tablename
      || ' ('
      || myrec.toid
      || ')';
  END IF;
  -- Do we have one for rowid?
  SELECT INTO mycount count(*) FROM bucardo_audit_delta_index
    WHERE targetoid = myrec.toid::text AND targetcol = 'rowid';
  RAISE NOTICE 'Failed to find toid %', myrec.toid;
FOR myrec2 IN
  SELECT *
  FROM bucardo_audit_delta_index
LOOP
  RAISE NOTICE 'Found %, %, and %', myrec2.targetoid, myrec2.targetcol, myrec2.indexname;
END LOOP;
  IF mycount < 1 THEN
    fmsg = fmsg
     || chr(10)
     || '-- bucardo_delta is missing a partial index on rowid for table '
     || myrec.schemaname
     || '.'
     || myrec.tablename
     || ' ('
     || myrec.toid
     || ')'
     || chr(10)
     || 'CREATE INDEX bucardo_delta_'
     || myrec.schemaname
     || '_'
     || myrec.tablename
     || '_rowid ON bucardo_delta(rowid) WHERE tablename = '
     || myrec.toid
     || ';';
  ELSE
    IF mycount > 1 THEN
      fmsg = fmsg
        || chr(10)
        || '-- bucardo_delta has '
        || mycount::text
        || ' partial indexes on rowid for table '
        || myrec.schemaname
        || '.'
        || myrec.tablename
        || ' ('
        || myrec.toid
        || ') Drop one of:';
      FOR myrec2 IN SELECT indexname FROM bucardo_audit_delta_index
        WHERE targetoid = myrec.toid::text AND targetcol = 'rowid'
      LOOP
        fmsg = fmsg
          || chr(10)
          || '-- DROP INDEX '
          || quote_ident(myrec2.indexname)
          || ';';
      END LOOP;
    ELSE
      -- Check for the correct table oid
      SELECT INTO myst targetoid FROM bucardo_audit_delta_index
          WHERE targetoid = myrec.toid::text AND targetcol = 'rowid';
      IF myst <> myrec.toid::text THEN
        fmsg = fmsg
          || chr(10)
          || '-- Wrong oid on bucardo_delta rowid index for '
          || myrec.schemaname
          || '.'
          || myrec.tablename
          || ' ('
          || myst
          || '), but the index says'
          || myrec.toid
          || '!';
      END IF;
    END IF;
  END IF;
  -- Do we have one for txntime?
  SELECT INTO mycount count(*) FROM bucardo_audit_delta_index
    WHERE targetoid = myrec.toid::text AND targetcol = 'txntime';
  IF mycount < 1 THEN
    fmsg = fmsg
      || chr(10)
      || '-- bucardo_delta is missing a partial index on txntime for table '
      || myrec.schemaname
      || '.'
      || myrec.tablename
      || ' ('
      || myrec.toid
      || ')'
      || chr(10)
      || 'CREATE INDEX bucardo_delta_'
      || myrec.schemaname
      || '_'
      || myrec.tablename
      || '_txntime ON bucardo_delta(rowid) WHERE tablename = '
      || myrec.toid
      || ';';
  ELSE
    IF mycount > 1 THEN
      fmsg = fmsg
        || chr(10)
        || '-- bucardo_delta has '
        || mycount::text
        || ' partial indexes on txntime for table '
        || myrec.schemaname
        || '.'
        || myrec.tablename
        || ' ('
        || myrec.toid
        || ') Drop one of:';
      FOR myrec2 IN SELECT indexname FROM bucardo_audit_delta_index
        WHERE targetoid = myrec.toid::text AND targetcol = 'txntime'
      LOOP
        fmsg = fmsg
          || chr(10)
          || '-- DROP INDEX '
          || quote_ident(myrec2.indexname)
          || ';';
      END LOOP;
    ELSE
      -- Check for the correct table oid
      SELECT INTO myst targetoid FROM bucardo_audit_delta_index
        WHERE targetoid = myrec.toid::text AND targetcol = 'txnid';
      IF myst <> myrec.toid::text THEN
        fmsg = fmsg
          || chr(10)
          || '-- Wrong oid on bucardo_delta txnid index for '
          || myrec.schemaname
          || '.'
          || myrec.tablename
          || ' ('
          || myrec.toid
          || '), but the index says '
          || myrec.toid
          || '!';
      END IF;
    END IF;
  END IF;
  -- Does this table exist in bucardo_delta_targets?
  PERFORM 1 FROM bucardo.bucardo_delta_targets WHERE tablename = myrec.toid;
  IF NOT FOUND THEN
    fmsg = fmsg
      || chr(10)
      || '--Missing entry in bucardo_delta_targets for table '
      || myrec.tablename
      || chr(10)
      || '-- This may be also be caused by an old bucardo_add_delta trigger';
  END IF;
END LOOP;

-- Make sure bucardo_delta has a non-partial index on txntime
PERFORM 1 FROM bucardo_audit_delta_index
WHERE targetoid IS NULL
AND indexname = 'bucardo_delta_txntime'
AND targetcol = 'txntime';
IF NOT FOUND THEN
  fmsg = fmsg
    || chr(10)
    || '-- Index bucardo_delta_txntime on bucardo_delta was not found!'
    || chr(10)
    || 'CREATE INDEX bucardo_delta_txntime ON bucardo_delta(txntime);';
END IF;

-- Make sure bucardo_delta has a non-partial index on rowid
PERFORM 1 FROM bucardo_audit_delta_index
WHERE targetoid IS NULL
AND indexname = 'bucardo_delta_rowid_all'
AND targetcol = 'rowid';
IF NOT FOUND THEN
  fmsg = fmsg
    || chr(10)
    || '-- Index bucardo_delta_rowid_all on bucardo_delta was not found!'
    || chr(10)
    || 'CREATE INDEX bucardo_delta_rowid_all ON bucardo_delta(rowid);';
END IF;

-- Check for any unknown indexes on bucardo_delta
FOR myrec IN
  SELECT *
  FROM bucardo_audit_delta_index
  WHERE targetoid IS NULL
  AND indexname NOT IN ('bucardo_delta_txntime', 'bucardo_delta_rowid_all')
LOOP
  fmsg = fmsg
   || chr(10)
   || '-- Unknown index on bucardo_delta: '
   || myrec.indexname;
  -- Show stats about it
  FOR myrec2 IN 
    SELECT
      pg_stat_get_blocks_fetched(myrec.indyoid) AS blocks_fetched,
      pg_stat_get_blocks_hit(myrec.indyoid) AS blocks_hit,
      pg_stat_get_numscans(myrec.indyoid) AS numscans,
      pg_stat_get_tuples_returned(myrec.indyoid) AS tups_returned,
      pg_stat_get_tuples_fetched(myrec.indyoid) AS tups_fetched
  LOOP
    fmsg = fmsg
      || chr(10)
      || '-- Blocks fetched/hit: '
      || myrec2.blocks_fetched::text
      || '/'
      || myrec2.blocks_hit::text
      || ' Tuples scanned/fetched/returned: '
      || myrec2.numscans::text
      || '/'
      || myrec2.tups_returned::text
      || '/'
      || myrec2.tups_fetched::text
      || chr(10)
      || 'DROP INDEX '
      || quote_ident(myrec.indexname)
      || ';';
  END LOOP;
END LOOP;

-- That wraps up the indexes. Now the bucardo_delta data

-- Delete rows in bucardo_delta that refer to non-existent tables
FOR myrec IN SELECT DISTINCT tablename FROM bucardo_delta ORDER BY 1 LOOP
  SELECT relname FROM pg_class WHERE oid = myrec.tablename INTO mytablename;
  IF NOT FOUND THEN
    fmsg = fmsg
      || chr(10)
      || '-- Table in bucardo_delta does not exist: oid '
      || myrec.tablename
      || chr(10)
      || 'DELETE FROM bucardo_delta WHERE tablename = '
      || myrec.tablename
      || ';';
  ELSE
    -- A.1 Check that any such tables have a bucardo_add_delta trigger
    PERFORM 1 FROM pg_trigger WHERE tgrelid = myrec.tablename AND tgname = 'bucardo_add_delta';
    IF NOT FOUND THEN
     fmsg = fmsg
       || chr(10)
       || '-- Table '
       || myrec.tablename
       || ' ('
       || mytablename
       || ') needs a bucardo_add_delta trigger. Try running validate_sync()?';
    END IF;
  END IF;
END LOOP;

-- Time for bucardo_track

-- Make sure bucardo_track has its lone index
SELECT INTO mycount
  count(*) FROM bucardo_audit_track_index
  WHERE indexname = 'bucardo_track_target';
IF mycount < 1 THEN
  fmsg = fmsg
    || chr(10)
    || '-- Index bucardo_track_target not found!';
  fmsg = fmsg || chr(10) || 'CREATE INDEX bucardo_track_target ON bucardo_track(tablename,txntime,targetdb);';
END IF;

-- Should only be one index on bucardo_track
SELECT INTO mycount
  count(*) FROM bucardo_audit_track_index;
IF mycount <> 1 THEN
  fmsg = fmsg
    || chr(10)
    || '-- The bucardo_track table has the wrong number ('
    || mycount::text
    || ') of indexes';
END IF;

-- Delete rows in bucardo_track that refer to invalid tables
FOR myrec IN SELECT DISTINCT tablename FROM bucardo_track ORDER BY 1 LOOP
  SELECT relname FROM pg_class WHERE oid = myrec.tablename INTO mytablename;
  IF NOT FOUND THEN
    fmsg = fmsg
      || chr(10)
      || '-- Table in bucardo_track does not exist: oid '
      || myrec.tablename
      || chr(10)
      || 'DELETE FROM bucardo_track WHERE tablename = '
      || myrec.tablename
      || ';';
  ELSE
    -- A.1 Check that any such tables have a bucardo_add_delta trigger
    PERFORM 1 FROM pg_trigger WHERE tgrelid = myrec.tablename AND tgname = 'bucardo_add_delta';
    IF NOT FOUND THEN
      fmsg = fmsg
        || chr(10)
        || '-- Table '
        || myrec.tablename
        || ' ('
        || mytablename
        || ') needs a bucardo_add_delta trigger. Try running validate_sync()?';
    END IF;
  END IF;
END LOOP;

-- Remove any stale entries from bucardo_delta_targets
PERFORM 1 FROM bucardo_delta_targets t WHERE NOT EXISTS
  (SELECT 1 FROM pg_class WHERE oid = t.tablename AND relkind = 'r');
IF FOUND THEN
  fmsg = fmsg
    || chr(10)
    || '-- Remove stale entries from bucardo_delta_targets: '
    || chr(10)
    || 'DELETE FROM bucardo_delta_targets t WHERE tablename NOT IN '
    || chr(10)
    || $clone2$(SELECT oid FROM pg_class WHERE relkind = 'r');$clone2$;
END IF;

fmsg = fmsg || chr(10) || '-- End of audit';

RETURN fmsg;

END;
$_$;


ALTER FUNCTION bucardo.bucardo_audit() OWNER TO bucardo;

--
-- Name: bucardo_compress_delta(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_compress_delta() RETURNS SETOF text
    LANGUAGE sql SECURITY DEFINER
    AS $$
SELECT bucardo.bucardo_compress_delta(n.nspname, c.relname) FROM pg_class c
JOIN pg_namespace n ON n.oid = c.relnamespace
WHERE c.oid IN (SELECT DISTINCT tablename FROM bucardo.bucardo_delta);
                  $$;


ALTER FUNCTION bucardo.bucardo_compress_delta() OWNER TO bucardo;

--
-- Name: bucardo_compress_delta(text); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_compress_delta(text) RETURNS text
    LANGUAGE sql SECURITY DEFINER
    AS $_$
SELECT bucardo.bucardo_compress_delta(n.nspname, c.relname) FROM pg_class c
JOIN pg_namespace n ON n.oid = c.relnamespace
WHERE relname = $1 AND pg_table_is_visible(c.oid);
                  $_$;


ALTER FUNCTION bucardo.bucardo_compress_delta(text) OWNER TO bucardo;

--
-- Name: bucardo_compress_delta(oid); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_compress_delta(oid) RETURNS text
    LANGUAGE sql SECURITY DEFINER
    AS $_$
SELECT bucardo.bucardo_compress_delta(n.nspname, c.relname) FROM pg_class c
JOIN pg_namespace n ON n.oid = c.relnamespace
WHERE c.oid = $1;
                  $_$;


ALTER FUNCTION bucardo.bucardo_compress_delta(oid) OWNER TO bucardo;

--
-- Name: bucardo_compress_delta(text, text); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_compress_delta(text, text) RETURNS text
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                  DECLARE
 mymode TEXT;
 myoid OID;
 myst TEXT;
 got2 bool;
 drows BIGINT = 0;
 trows BIGINT = 0;
 rnames TEXT;
 rname TEXT;
 rnamerec RECORD;
 ids_where TEXT;
 ids_sel TEXT;
 ids_grp TEXT;
 idnum TEXT;
                  BEGIN
                  -- Are we running in serializable mode?
                  SELECT INTO mymode current_setting('transaction_isolation');
                  IF (mymode <> 'serializable') THEN
 RAISE EXCEPTION 'This function must be run in serializable mode';
                  END IF;
                  -- Grab the oid of this schema/table combo
                  SELECT INTO myoid
 c.oid FROM pg_class c JOIN pg_namespace n ON n.oid = c.relnamespace
 WHERE nspname = $1 AND relname = $2;
                  IF NOT FOUND THEN
 RAISE EXCEPTION 'No such table: %.%', $1, $2;
                  END IF;
                  ids_where = 'COALESCE(rowid,''NULL'') = COALESCE(id, ''NULL'')';
                  ids_sel = 'rowid AS id';
                  ids_grp = 'rowid';
                  FOR rnamerec IN SELECT attname FROM pg_attribute WHERE attrelid =
       (SELECT oid FROM pg_class WHERE relname = 'bucardo_delta'
       AND relnamespace =
       (SELECT oid FROM pg_namespace WHERE
       nspname = 'bucardo') AND attname ~ '^rowid'
   ) LOOP
   rname = rnamerec.attname;
   rnames = COALESCE(rnames || ' ', '') || rname ;
   SELECT INTO idnum SUBSTRING(rname FROM '[[:digit:]]+');
   IF idnum IS NOT NULL THEN
     ids_where = ids_where 
       || ' AND (' 
       || rname
       || ' = id'
       || idnum
       || ' OR ('
       || rname
       || ' IS NULL AND id'
       || idnum
       || ' IS NULL))';
     ids_sel = ids_sel
       || ', '
       || rname
       || ' AS id'
       || idnum;
     ids_grp = ids_grp
       || ', '
       || rname;
   END IF;
                  END LOOP;
                  myst = 'DELETE FROM bucardo.bucardo_delta 
                  USING (SELECT MAX(txntime) AS maxt, '||ids_sel||'
      FROM bucardo.bucardo_delta
      WHERE tablename = '||myoid||'
      GROUP BY ' || ids_grp || ') AS foo
                  WHERE tablename = '|| myoid || ' AND ' || ids_where ||' AND txntime <> maxt';
                  RAISE DEBUG 'Running %', myst;
                  EXECUTE myst;
                  GET DIAGNOSTICS drows := row_count;
                  myst = 'DELETE FROM bucardo.bucardo_track'
 || ' WHERE NOT EXISTS (SELECT 1 FROM bucardo.bucardo_delta d WHERE d.txntime = bucardo_track.txntime)';
                  EXECUTE myst;
                  GET DIAGNOSTICS trows := row_count;
                  RETURN 'Compressed '||$1||'.'||$2||'. Rows deleted from bucardo_delta: '||drows||
 ' Rows deleted from bucardo_track: '||trows;
                  END;
                  $_$;


ALTER FUNCTION bucardo.bucardo_compress_delta(text, text) OWNER TO bucardo;

--
-- Name: bucardo_purge_delta(interval); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_purge_delta(interval) RETURNS text
    LANGUAGE plpgsql SECURITY DEFINER
    AS $_$
                    DECLARE
   drows BIGINT;
   trows BIGINT;
                    BEGIN
   DELETE FROM bucardo.bucardo_delta
   USING 
   (SELECT b.tablename AS tn, b.txntime AS tt FROM
   (SELECT tablename, count(*) FROM bucardo.bucardo_delta_targets GROUP BY 1) AS a,
   (SELECT tablename, txntime, count(*) FROM bucardo.bucardo_track GROUP BY 1,2) AS b
   WHERE a.tablename = b.tablename
   AND a.count=b.count) AS foo
   WHERE tablename = tn AND txntime = tt
   AND txntime < now()-$1;
    GET DIAGNOSTICS drows := row_count;
    DELETE FROM bucardo.bucardo_track
   WHERE NOT EXISTS (SELECT 1 FROM bucardo.bucardo_delta d WHERE d.txntime = bucardo_track.txntime);
    GET DIAGNOSTICS trows := row_count;
    RETURN 'Rows deleted from bucardo_delta: '||drows||
     ' Rows deleted from bucardo_track: '||trows;

                  END;
                    $_$;


ALTER FUNCTION bucardo.bucardo_purge_delta(interval) OWNER TO bucardo;

--
-- Name: bucardo_triggerkick_localhostremoto001(); Type: FUNCTION; Schema: bucardo; Owner: bucardo
--

CREATE FUNCTION bucardo_triggerkick_localhostremoto001() RETURNS trigger
    LANGUAGE plpgsql SECURITY DEFINER
    AS $$
                        BEGIN
 EXECUTE 'NOTIFY "bucardo_kick_sync_localhostremoto001"';
 IF TG_OP = 'TRUNCATE' THEN
   INSERT INTO bucardo.bucardo_truncate_trigger(tablename,sname,tname,sync)
   VALUES (TG_RELID, TG_TABLE_SCHEMA, TG_TABLE_NAME, 'localhostremoto001');
 END IF;
                        RETURN NEW;
                        END;
                        $$;


ALTER FUNCTION bucardo.bucardo_triggerkick_localhostremoto001() OWNER TO bucardo;

SET search_path = inventario, pg_catalog;

--
-- Name: fn_log_audit(); Type: FUNCTION; Schema: inventario; Owner: postgres
--

CREATE FUNCTION fn_log_audit() RETURNS trigger
    LANGUAGE plpgsql
    AS $$BEGIN
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO audit_consecutivos ("TableName", "Operation", "OldValue", "NewValue", "UpdateDate", "UserName")
           VALUES (TG_TABLE_NAME, 'D', OLD, NULL, now(), USER);
    RETURN OLD;
  ELSIF (TG_OP = 'UPDATE') THEN
    INSERT INTO audit_consecutivos ("TableName", "Operation", "OldValue", "NewValue", "UpdateDate", "UserName")
           VALUES (TG_TABLE_NAME, 'U', OLD, NEW, now(), USER);
    RETURN NEW;
  ELSIF (TG_OP = 'INSERT') THEN
    INSERT INTO audit_consecutivos ("TableName", "Operation", "OldValue", "NewValue", "UpdateDate", "UserName")
           VALUES (TG_TABLE_NAME, 'I', NULL, NEW, now(), USER);
    RETURN NEW;
  END IF;
  RETURN NULL;
END;
$$;


ALTER FUNCTION inventario.fn_log_audit() OWNER TO postgres;

--
-- Name: FUNCTION fn_log_audit(); Type: COMMENT; Schema: inventario; Owner: postgres
--

COMMENT ON FUNCTION fn_log_audit() IS 'Funcion de auditoria, para llevar el control de los cambios de la tabla consecutivos (Stock de tiquetes).';


SET search_path = public, pg_catalog;

--
-- Name: fn_log_audit(); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION fn_log_audit() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO tbl_audit ("TableName", "Operation", "OldValue", "NewValue", "UpdateDate", "UserName")
           VALUES (TG_TABLE_NAME, 'D', OLD, NULL, now(), USER);
    RETURN OLD;
  ELSIF (TG_OP = 'UPDATE') THEN
    INSERT INTO tbl_audit ("TableName", "Operation", "OldValue", "NewValue", "UpdateDate", "UserName")
           VALUES (TG_TABLE_NAME, 'U', OLD, NEW, now(), USER);
    RETURN NEW;
  ELSIF (TG_OP = 'INSERT') THEN
    INSERT INTO tbl_audit ("TableName", "Operation", "OldValue", "NewValue", "UpdateDate", "UserName")
           VALUES (TG_TABLE_NAME, 'I', NULL, NEW, now(), USER);
    RETURN NEW;
  END IF;
  RETURN NULL;
END;
$$;


ALTER FUNCTION public.fn_log_audit() OWNER TO postgres;

SET search_path = bucardo, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: bucardo_delta; Type: TABLE; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE TABLE bucardo_delta (
    tablename oid NOT NULL,
    rowid text NOT NULL,
    txntime timestamp with time zone DEFAULT now() NOT NULL
);


ALTER TABLE bucardo.bucardo_delta OWNER TO bucardo;

--
-- Name: bucardo_delta_targets; Type: TABLE; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE TABLE bucardo_delta_targets (
    tablename oid NOT NULL,
    targetdb text NOT NULL,
    cdate timestamp with time zone DEFAULT now() NOT NULL
);


ALTER TABLE bucardo.bucardo_delta_targets OWNER TO bucardo;

--
-- Name: bucardo_sequences; Type: TABLE; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE TABLE bucardo_sequences (
    tablename oid NOT NULL,
    value bigint NOT NULL,
    iscalled boolean NOT NULL
);


ALTER TABLE bucardo.bucardo_sequences OWNER TO bucardo;

--
-- Name: bucardo_track; Type: TABLE; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE TABLE bucardo_track (
    txntime timestamp with time zone NOT NULL,
    tablename oid NOT NULL,
    targetdb text NOT NULL
);


ALTER TABLE bucardo.bucardo_track OWNER TO bucardo;

--
-- Name: bucardo_truncate_trigger; Type: TABLE; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE TABLE bucardo_truncate_trigger (
    tablename oid NOT NULL,
    sname text NOT NULL,
    tname text NOT NULL,
    sync text NOT NULL,
    replicated timestamp with time zone,
    cdate timestamp with time zone DEFAULT now() NOT NULL
);


ALTER TABLE bucardo.bucardo_truncate_trigger OWNER TO bucardo;

--
-- Name: bucardo_truncate_trigger_log; Type: TABLE; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE TABLE bucardo_truncate_trigger_log (
    tablename oid NOT NULL,
    sname text NOT NULL,
    tname text NOT NULL,
    sync text NOT NULL,
    targetdb text NOT NULL,
    replicated timestamp with time zone NOT NULL,
    cdate timestamp with time zone DEFAULT now() NOT NULL
);


ALTER TABLE bucardo.bucardo_truncate_trigger_log OWNER TO bucardo;

SET search_path = clientes, pg_catalog;

--
-- Name: cliente; Type: TABLE; Schema: clientes; Owner: postgres; Tablespace: 
--

CREATE TABLE cliente (
    cli_nit bigint NOT NULL,
    cli_razon_social character varying NOT NULL
);


ALTER TABLE clientes.cliente OWNER TO postgres;

--
-- Name: sedes_clientes; Type: TABLE; Schema: clientes; Owner: postgres; Tablespace: 
--

CREATE TABLE sedes_clientes (
    cli_direccion character varying NOT NULL,
    cli_telefono_1 character varying NOT NULL,
    cli_telefono_2 character varying,
    cli_fax character varying,
    cli_email character varying,
    id_cliente_sede bigint NOT NULL,
    sede_descripcion character varying NOT NULL,
    id_clie_ciudad integer,
    cli_nit bigint NOT NULL
);


ALTER TABLE clientes.sedes_clientes OWNER TO postgres;

--
-- Name: sedes_clientes_id_cliente_sede_seq; Type: SEQUENCE; Schema: clientes; Owner: postgres
--

CREATE SEQUENCE sedes_clientes_id_cliente_sede_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clientes.sedes_clientes_id_cliente_sede_seq OWNER TO postgres;

--
-- Name: sedes_clientes_id_cliente_sede_seq; Type: SEQUENCE OWNED BY; Schema: clientes; Owner: postgres
--

ALTER SEQUENCE sedes_clientes_id_cliente_sede_seq OWNED BY sedes_clientes.id_cliente_sede;


SET search_path = consignacion_saldos, pg_catalog;

--
-- Name: consignacion_saldo; Type: TABLE; Schema: consignacion_saldos; Owner: postgres; Tablespace: 
--

CREATE TABLE consignacion_saldo (
    cons_id integer NOT NULL,
    cons_recibo_caja bigint,
    cons_nit_cliente bigint,
    cons_obs character varying,
    cons_fecha_sistema timestamp without time zone,
    cons_fecha date
);


ALTER TABLE consignacion_saldos.consignacion_saldo OWNER TO postgres;

--
-- Name: consignacion_saldo_cons_id_seq; Type: SEQUENCE; Schema: consignacion_saldos; Owner: postgres
--

CREATE SEQUENCE consignacion_saldo_cons_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE consignacion_saldos.consignacion_saldo_cons_id_seq OWNER TO postgres;

--
-- Name: consignacion_saldo_cons_id_seq; Type: SEQUENCE OWNED BY; Schema: consignacion_saldos; Owner: postgres
--

ALTER SEQUENCE consignacion_saldo_cons_id_seq OWNED BY consignacion_saldo.cons_id;


--
-- Name: pagos_cons_saldo; Type: TABLE; Schema: consignacion_saldos; Owner: postgres; Tablespace: 
--

CREATE TABLE pagos_cons_saldo (
    pag_id integer NOT NULL,
    pag_cons_saldo integer,
    pag_id_cban integer,
    pag_id_fp integer,
    pag_monto bigint
);


ALTER TABLE consignacion_saldos.pagos_cons_saldo OWNER TO postgres;

--
-- Name: pagos_cons_saldo_pag_id_seq; Type: SEQUENCE; Schema: consignacion_saldos; Owner: postgres
--

CREATE SEQUENCE pagos_cons_saldo_pag_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE consignacion_saldos.pagos_cons_saldo_pag_id_seq OWNER TO postgres;

--
-- Name: pagos_cons_saldo_pag_id_seq; Type: SEQUENCE OWNED BY; Schema: consignacion_saldos; Owner: postgres
--

ALTER SEQUENCE pagos_cons_saldo_pag_id_seq OWNED BY pagos_cons_saldo.pag_id;


SET search_path = controles_arqueos, pg_catalog;

--
-- Name: arq_ven_dep_cat; Type: TABLE; Schema: controles_arqueos; Owner: postgres; Tablespace: 
--

CREATE TABLE arq_ven_dep_cat (
    id_arq integer NOT NULL,
    arq_fecha_ini date NOT NULL,
    arq_fecha_fin date NOT NULL,
    arq_fecha_gene timestamp without time zone NOT NULL,
    id_usuario bigint NOT NULL
);


ALTER TABLE controles_arqueos.arq_ven_dep_cat OWNER TO postgres;

--
-- Name: arq_ven_dep_cat_id_arq_seq; Type: SEQUENCE; Schema: controles_arqueos; Owner: postgres
--

CREATE SEQUENCE arq_ven_dep_cat_id_arq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE controles_arqueos.arq_ven_dep_cat_id_arq_seq OWNER TO postgres;

--
-- Name: arq_ven_dep_cat_id_arq_seq; Type: SEQUENCE OWNED BY; Schema: controles_arqueos; Owner: postgres
--

ALTER SEQUENCE arq_ven_dep_cat_id_arq_seq OWNED BY arq_ven_dep_cat.id_arq;


--
-- Name: arqueo_categoria; Type: TABLE; Schema: controles_arqueos; Owner: postgres; Tablespace: 
--

CREATE TABLE arqueo_categoria (
    id_arqueo_categoria bigint NOT NULL,
    id_usuario integer NOT NULL,
    total_venta bigint,
    fecha_inicial timestamp without time zone,
    fecha_final timestamp without time zone,
    fecha_realizacion timestamp without time zone
);


ALTER TABLE controles_arqueos.arqueo_categoria OWNER TO postgres;

--
-- Name: control_de_arqueo_general_id_arqueo_general_seq; Type: SEQUENCE; Schema: controles_arqueos; Owner: postgres
--

CREATE SEQUENCE control_de_arqueo_general_id_arqueo_general_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE controles_arqueos.control_de_arqueo_general_id_arqueo_general_seq OWNER TO postgres;

--
-- Name: control_de_arqueo_general_id_arqueo_general_seq; Type: SEQUENCE OWNED BY; Schema: controles_arqueos; Owner: postgres
--

ALTER SEQUENCE control_de_arqueo_general_id_arqueo_general_seq OWNED BY arqueo_categoria.id_arqueo_categoria;


--
-- Name: arqueo_categoria_dependencia; Type: TABLE; Schema: controles_arqueos; Owner: postgres; Tablespace: 
--

CREATE TABLE arqueo_categoria_dependencia (
    id_arqueo_categoria bigint DEFAULT nextval('control_de_arqueo_general_id_arqueo_general_seq'::regclass) NOT NULL,
    id_usuario integer NOT NULL,
    total_venta bigint,
    fecha_inicial timestamp without time zone,
    fecha_final timestamp without time zone,
    fecha_realizacion timestamp without time zone
);


ALTER TABLE controles_arqueos.arqueo_categoria_dependencia OWNER TO postgres;

--
-- Name: arqueo_general; Type: TABLE; Schema: controles_arqueos; Owner: postgres; Tablespace: 
--

CREATE TABLE arqueo_general (
    id_arqueo_general bigint NOT NULL,
    fecha_hora_arqueo timestamp without time zone NOT NULL,
    id_usuario integer NOT NULL,
    total_sistema bigint NOT NULL,
    total_vendidos bigint NOT NULL,
    total_inhabilitados bigint NOT NULL,
    total_disponibles bigint NOT NULL,
    total_remisionados bigint NOT NULL,
    total_falla bigint,
    total_proveedor bigint,
    total_cliente bigint
);


ALTER TABLE controles_arqueos.arqueo_general OWNER TO postgres;

--
-- Name: arqueo_general_id_arqueo_general_seq; Type: SEQUENCE; Schema: controles_arqueos; Owner: postgres
--

CREATE SEQUENCE arqueo_general_id_arqueo_general_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE controles_arqueos.arqueo_general_id_arqueo_general_seq OWNER TO postgres;

--
-- Name: arqueo_general_id_arqueo_general_seq; Type: SEQUENCE OWNED BY; Schema: controles_arqueos; Owner: postgres
--

ALTER SEQUENCE arqueo_general_id_arqueo_general_seq OWNED BY arqueo_general.id_arqueo_general;


SET search_path = dependencias, pg_catalog;

--
-- Name: dependencia; Type: TABLE; Schema: dependencias; Owner: postgres; Tablespace: 
--

CREATE TABLE dependencia (
    id_dependencia integer NOT NULL,
    depe_descripcion character varying,
    nit_depe bigint
);


ALTER TABLE dependencias.dependencia OWNER TO postgres;

--
-- Name: dependencia_id_dependencia_seq; Type: SEQUENCE; Schema: dependencias; Owner: postgres
--

CREATE SEQUENCE dependencia_id_dependencia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dependencias.dependencia_id_dependencia_seq OWNER TO postgres;

--
-- Name: dependencia_id_dependencia_seq; Type: SEQUENCE OWNED BY; Schema: dependencias; Owner: postgres
--

ALTER SEQUENCE dependencia_id_dependencia_seq OWNED BY dependencia.id_dependencia;


--
-- Name: item_dependencia; Type: TABLE; Schema: dependencias; Owner: postgres; Tablespace: 
--

CREATE TABLE item_dependencia (
    id_item_depen integer NOT NULL,
    item_depen_descrip character varying,
    id_dependencia integer
);


ALTER TABLE dependencias.item_dependencia OWNER TO postgres;

--
-- Name: item_dependencia_id_item_depen_seq; Type: SEQUENCE; Schema: dependencias; Owner: postgres
--

CREATE SEQUENCE item_dependencia_id_item_depen_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE dependencias.item_dependencia_id_item_depen_seq OWNER TO postgres;

--
-- Name: item_dependencia_id_item_depen_seq; Type: SEQUENCE OWNED BY; Schema: dependencias; Owner: postgres
--

ALTER SEQUENCE item_dependencia_id_item_depen_seq OWNED BY item_dependencia.id_item_depen;


--
-- Name: peajes; Type: TABLE; Schema: dependencias; Owner: postgres; Tablespace: 
--

CREATE TABLE peajes (
    codigo_peaje integer NOT NULL,
    estacion_peaje character varying
);


ALTER TABLE dependencias.peajes OWNER TO postgres;

SET search_path = inventario, pg_catalog;

--
-- Name: anulacion_tiquetes; Type: TABLE; Schema: inventario; Owner: postgres; Tablespace: 
--

CREATE TABLE anulacion_tiquetes (
    id_anulacion_tiquete integer NOT NULL,
    fecha_anulacion timestamp without time zone NOT NULL,
    id_usuario integer NOT NULL,
    observacion character varying
);


ALTER TABLE inventario.anulacion_tiquetes OWNER TO postgres;

--
-- Name: anulacion_tiquetes_id_anulacion_tiquete_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE anulacion_tiquetes_id_anulacion_tiquete_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario.anulacion_tiquetes_id_anulacion_tiquete_seq OWNER TO postgres;

--
-- Name: anulacion_tiquetes_id_anulacion_tiquete_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE anulacion_tiquetes_id_anulacion_tiquete_seq OWNED BY anulacion_tiquetes.id_anulacion_tiquete;


--
-- Name: categoria; Type: TABLE; Schema: inventario; Owner: postgres; Tablespace: 
--

CREATE TABLE categoria (
    cat_id integer NOT NULL,
    cat_nombre character varying NOT NULL
);


ALTER TABLE inventario.categoria OWNER TO postgres;

--
-- Name: categoria_cat_id_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE categoria_cat_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario.categoria_cat_id_seq OWNER TO postgres;

--
-- Name: categoria_cat_id_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE categoria_cat_id_seq OWNED BY categoria.cat_id;


--
-- Name: consecutivos; Type: TABLE; Schema: inventario; Owner: postgres; Tablespace: 
--

CREATE TABLE consecutivos (
    conse_idconsecutivo bigint NOT NULL,
    conse_num_consecutivo_tiqute bigint NOT NULL,
    conse_estado boolean DEFAULT true,
    conse_remision bigint,
    fecha_ingreso timestamp without time zone,
    id_usuario integer,
    fecha_remision date,
    observacion character varying
);


ALTER TABLE inventario.consecutivos OWNER TO postgres;

--
-- Name: consecutivos_conse_idconsecutivo_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE consecutivos_conse_idconsecutivo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario.consecutivos_conse_idconsecutivo_seq OWNER TO postgres;

--
-- Name: consecutivos_conse_idconsecutivo_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE consecutivos_conse_idconsecutivo_seq OWNED BY consecutivos.conse_idconsecutivo;


--
-- Name: detalle_anulacion_tiquetes; Type: TABLE; Schema: inventario; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_anulacion_tiquetes (
    da_idanulacion integer NOT NULL,
    da_serial1 bigint NOT NULL,
    da_serial2 bigint NOT NULL,
    id_anulacion bigint NOT NULL,
    id_tipo integer
);


ALTER TABLE inventario.detalle_anulacion_tiquetes OWNER TO postgres;

--
-- Name: detalle_anulacion_tiquetes_da_idanulacion_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE detalle_anulacion_tiquetes_da_idanulacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario.detalle_anulacion_tiquetes_da_idanulacion_seq OWNER TO postgres;

--
-- Name: detalle_anulacion_tiquetes_da_idanulacion_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE detalle_anulacion_tiquetes_da_idanulacion_seq OWNED BY detalle_anulacion_tiquetes.da_idanulacion;


--
-- Name: especificacion_tiquete_prepago; Type: TABLE; Schema: inventario; Owner: postgres; Tablespace: 
--

CREATE TABLE especificacion_tiquete_prepago (
    etp_id integer NOT NULL,
    etp_anio integer NOT NULL,
    etp_precio bigint NOT NULL,
    cat_id integer,
    tea_id integer
);


ALTER TABLE inventario.especificacion_tiquete_prepago OWNER TO postgres;

--
-- Name: especificacion_tiquete_prepago_etp_id_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE especificacion_tiquete_prepago_etp_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario.especificacion_tiquete_prepago_etp_id_seq OWNER TO postgres;

--
-- Name: especificacion_tiquete_prepago_etp_id_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE especificacion_tiquete_prepago_etp_id_seq OWNED BY especificacion_tiquete_prepago.etp_id;


--
-- Name: reg_rest_tiq; Type: TABLE; Schema: inventario; Owner: postgres; Tablespace: 
--

CREATE TABLE reg_rest_tiq (
    id_reg integer NOT NULL,
    desde bigint,
    hasta bigint,
    can_tiq integer,
    observacion character varying,
    act_desa character(1),
    fecha_reg timestamp without time zone
);


ALTER TABLE inventario.reg_rest_tiq OWNER TO postgres;

--
-- Name: reg_rest_tiq_id_reg_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE reg_rest_tiq_id_reg_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario.reg_rest_tiq_id_reg_seq OWNER TO postgres;

--
-- Name: reg_rest_tiq_id_reg_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE reg_rest_tiq_id_reg_seq OWNED BY reg_rest_tiq.id_reg;


--
-- Name: tipo_anulacion; Type: TABLE; Schema: inventario; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_anulacion (
    id integer NOT NULL,
    tipo_anulacion character varying
);


ALTER TABLE inventario.tipo_anulacion OWNER TO postgres;

--
-- Name: tipo_anulacion_id_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE tipo_anulacion_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario.tipo_anulacion_id_seq OWNER TO postgres;

--
-- Name: tipo_anulacion_id_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE tipo_anulacion_id_seq OWNED BY tipo_anulacion.id;


--
-- Name: tipo_eje_adicional; Type: TABLE; Schema: inventario; Owner: postgres; Tablespace: 
--

CREATE TABLE tipo_eje_adicional (
    tea_id integer NOT NULL,
    tea_nombre character varying NOT NULL
);


ALTER TABLE inventario.tipo_eje_adicional OWNER TO postgres;

--
-- Name: tipo_eje_adicional_tea_id_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE tipo_eje_adicional_tea_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario.tipo_eje_adicional_tea_id_seq OWNER TO postgres;

--
-- Name: tipo_eje_adicional_tea_id_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE tipo_eje_adicional_tea_id_seq OWNED BY tipo_eje_adicional.tea_id;


SET search_path = public, pg_catalog;

--
-- Name: municipio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE municipio (
    ciu_id integer NOT NULL,
    ciu_descripcion character varying NOT NULL,
    ciu_id_dep integer
);


ALTER TABLE public.municipio OWNER TO postgres;

--
-- Name: ciudad_ciu_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ciudad_ciu_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ciudad_ciu_id_seq OWNER TO postgres;

--
-- Name: ciudad_ciu_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ciudad_ciu_id_seq OWNED BY municipio.ciu_id;


--
-- Name: departamento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE departamento (
    dep_id integer NOT NULL,
    dep_descripcion character varying NOT NULL
);


ALTER TABLE public.departamento OWNER TO postgres;

--
-- Name: departamento_dep_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE departamento_dep_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.departamento_dep_id_seq OWNER TO postgres;

--
-- Name: departamento_dep_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE departamento_dep_id_seq OWNED BY departamento.dep_id;


--
-- Name: tbl_audit; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tbl_audit (
    pk_audit integer NOT NULL,
    "TableName" character(45) NOT NULL,
    "Operation" character(1) NOT NULL,
    "OldValue" text,
    "NewValue" text,
    "UpdateDate" timestamp without time zone NOT NULL,
    "UserName" character(45) NOT NULL
);


ALTER TABLE public.tbl_audit OWNER TO postgres;

--
-- Name: tbl_audit_pk_audit_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tbl_audit_pk_audit_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbl_audit_pk_audit_seq OWNER TO postgres;

--
-- Name: tbl_audit_pk_audit_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tbl_audit_pk_audit_seq OWNED BY tbl_audit.pk_audit;


--
-- Name: tbusuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tbusuario (
    idusuario integer NOT NULL,
    nombre character varying NOT NULL,
    apellido character varying NOT NULL,
    cedula numeric(14,0) NOT NULL,
    usuario character varying NOT NULL,
    clave character varying NOT NULL
);


ALTER TABLE public.tbusuario OWNER TO postgres;

--
-- Name: tbusuario_idusuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tbusuario_idusuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tbusuario_idusuario_seq OWNER TO postgres;

--
-- Name: tbusuario_idusuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tbusuario_idusuario_seq OWNED BY tbusuario.idusuario;


SET search_path = ventas, pg_catalog;

--
-- Name: anulacion_recibo_caja; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE anulacion_recibo_caja (
    id_anulacion_recibo integer NOT NULL,
    numero_recibo bigint NOT NULL,
    observacion character varying NOT NULL,
    fecha_hora timestamp without time zone NOT NULL,
    id_usuario integer NOT NULL
);


ALTER TABLE ventas.anulacion_recibo_caja OWNER TO postgres;

--
-- Name: anulacion_recibo_caja_id_anulacion_recibo_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE anulacion_recibo_caja_id_anulacion_recibo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.anulacion_recibo_caja_id_anulacion_recibo_seq OWNER TO postgres;

--
-- Name: anulacion_recibo_caja_id_anulacion_recibo_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE anulacion_recibo_caja_id_anulacion_recibo_seq OWNED BY anulacion_recibo_caja.id_anulacion_recibo;


--
-- Name: cambio_tiquete; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE cambio_tiquete (
    fecha timestamp with time zone NOT NULL,
    nombre_persona_recibe character varying NOT NULL,
    apellido_persona_recibe character varying NOT NULL,
    cedula_persona_recibe bigint NOT NULL,
    observaciones character varying,
    id_usuario numeric(14,0) NOT NULL,
    id_acta_consecutivo bigint NOT NULL,
    clie_sede bigint NOT NULL,
    diferencia bigint
);


ALTER TABLE ventas.cambio_tiquete OWNER TO postgres;

--
-- Name: cambio_tiquete_dependencias; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE cambio_tiquete_dependencias (
    fecha timestamp without time zone NOT NULL,
    nombre_persona_recibe character varying NOT NULL,
    apellido_persona_recibe character varying NOT NULL,
    cedula_persona_recibe bigint NOT NULL,
    observaciones character varying,
    id_usuario numeric(14,0) NOT NULL,
    id_dependencia integer NOT NULL,
    diferencia bigint,
    id_acta_consecutivo bigint NOT NULL
);


ALTER TABLE ventas.cambio_tiquete_dependencias OWNER TO postgres;

--
-- Name: cambio_tiquete_dependencias_id_acta_consecutivo_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE cambio_tiquete_dependencias_id_acta_consecutivo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.cambio_tiquete_dependencias_id_acta_consecutivo_seq OWNER TO postgres;

--
-- Name: cambio_tiquete_dependencias_id_acta_consecutivo_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE cambio_tiquete_dependencias_id_acta_consecutivo_seq OWNED BY cambio_tiquete_dependencias.id_acta_consecutivo;


--
-- Name: cambio_tiquete_id_acta_consecutivo_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE cambio_tiquete_id_acta_consecutivo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.cambio_tiquete_id_acta_consecutivo_seq OWNER TO postgres;

--
-- Name: cambio_tiquete_id_acta_consecutivo_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE cambio_tiquete_id_acta_consecutivo_seq OWNED BY cambio_tiquete.id_acta_consecutivo;


--
-- Name: cancelacion_excedente_dependencia; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE cancelacion_excedente_dependencia (
    id_acta_cambio bigint NOT NULL,
    id_fp integer NOT NULL,
    cban_id integer NOT NULL,
    pa_monto bigint NOT NULL,
    id_can_exce bigint NOT NULL
);


ALTER TABLE ventas.cancelacion_excedente_dependencia OWNER TO postgres;

--
-- Name: cancelacio_excedente_dependencia_id_can_exce_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE cancelacio_excedente_dependencia_id_can_exce_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.cancelacio_excedente_dependencia_id_can_exce_seq OWNER TO postgres;

--
-- Name: cancelacio_excedente_dependencia_id_can_exce_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE cancelacio_excedente_dependencia_id_can_exce_seq OWNED BY cancelacion_excedente_dependencia.id_can_exce;


--
-- Name: cancelacion_excedentes; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE cancelacion_excedentes (
    id_acta_cambio bigint NOT NULL,
    id_fp integer NOT NULL,
    cban_id integer NOT NULL,
    pa_monto bigint NOT NULL,
    recibo_caja bigint NOT NULL,
    id_can_exce integer NOT NULL
);


ALTER TABLE ventas.cancelacion_excedentes OWNER TO postgres;

--
-- Name: cancelacion_excedentes_id_can_exce_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE cancelacion_excedentes_id_can_exce_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.cancelacion_excedentes_id_can_exce_seq OWNER TO postgres;

--
-- Name: cancelacion_excedentes_id_can_exce_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE cancelacion_excedentes_id_can_exce_seq OWNED BY cancelacion_excedentes.recibo_caja;


--
-- Name: cancelacion_excedentes_id_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE cancelacion_excedentes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.cancelacion_excedentes_id_seq OWNER TO postgres;

--
-- Name: cancelacion_excedentes_id_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE cancelacion_excedentes_id_seq OWNED BY cancelacion_excedentes.id_can_exce;


--
-- Name: consignacion; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE consignacion (
    id_consignacion integer NOT NULL,
    cta_cliente character varying,
    banco_cliente character varying,
    tipo_cuenta_cliente character varying,
    vlor_cosnginado bigint,
    id_devolucion bigint,
    fecha_consignacion date DEFAULT now()
);


ALTER TABLE ventas.consignacion OWNER TO postgres;

--
-- Name: consignacion_id_consignacion_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE consignacion_id_consignacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.consignacion_id_consignacion_seq OWNER TO postgres;

--
-- Name: consignacion_id_consignacion_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE consignacion_id_consignacion_seq OWNED BY consignacion.id_consignacion;


--
-- Name: cuenta_bancaria; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE cuenta_bancaria (
    cban_id integer NOT NULL,
    cban_numero character varying(20) NOT NULL,
    cban_banco character varying(20) NOT NULL
);


ALTER TABLE ventas.cuenta_bancaria OWNER TO postgres;

--
-- Name: cuenta_bancaria_cban_id_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE cuenta_bancaria_cban_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.cuenta_bancaria_cban_id_seq OWNER TO postgres;

--
-- Name: cuenta_bancaria_cban_id_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE cuenta_bancaria_cban_id_seq OWNED BY cuenta_bancaria.cban_id;


--
-- Name: deta_entrega_tiq_peaje; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE deta_entrega_tiq_peaje (
    id_det_en_peaje integer NOT NULL,
    id_etp integer,
    serial_ini bigint NOT NULL,
    serial_fin bigint NOT NULL,
    id_ent_tiq_pea integer
);


ALTER TABLE ventas.deta_entrega_tiq_peaje OWNER TO postgres;

--
-- Name: deta_entrega_tiq_peaje_id_det_en_peaje_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE deta_entrega_tiq_peaje_id_det_en_peaje_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.deta_entrega_tiq_peaje_id_det_en_peaje_seq OWNER TO postgres;

--
-- Name: deta_entrega_tiq_peaje_id_det_en_peaje_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE deta_entrega_tiq_peaje_id_det_en_peaje_seq OWNED BY deta_entrega_tiq_peaje.id_det_en_peaje;


--
-- Name: detalle_devolucion; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_devolucion (
    id_detalle_devolucion bigint NOT NULL,
    id_etp integer,
    serial_inicial bigint,
    serial_final bigint,
    id_devolucion bigint
);


ALTER TABLE ventas.detalle_devolucion OWNER TO postgres;

--
-- Name: detalle_devolucion_id_detalle_devolucion_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE detalle_devolucion_id_detalle_devolucion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.detalle_devolucion_id_detalle_devolucion_seq OWNER TO postgres;

--
-- Name: detalle_devolucion_id_detalle_devolucion_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE detalle_devolucion_id_detalle_devolucion_seq OWNED BY detalle_devolucion.id_detalle_devolucion;


--
-- Name: detalle_entregados; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_entregados (
    id_detalle_entregado bigint NOT NULL,
    id_esp_tiquete integer NOT NULL,
    consecutivo_inicial bigint NOT NULL,
    consecutivo_final bigint NOT NULL,
    id_actacambio bigint NOT NULL
);


ALTER TABLE ventas.detalle_entregados OWNER TO postgres;

--
-- Name: detalle_entregados_dependencia; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_entregados_dependencia (
    id_esp_tiquete integer NOT NULL,
    consecutivo_inicial bigint NOT NULL,
    consecutivo_final bigint NOT NULL,
    id_actacambio bigint NOT NULL,
    id_detalle_entregado bigint NOT NULL
);


ALTER TABLE ventas.detalle_entregados_dependencia OWNER TO postgres;

--
-- Name: detalle_entregados_dependencia_id_detalle_entregado_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE detalle_entregados_dependencia_id_detalle_entregado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.detalle_entregados_dependencia_id_detalle_entregado_seq OWNER TO postgres;

--
-- Name: detalle_entregados_dependencia_id_detalle_entregado_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE detalle_entregados_dependencia_id_detalle_entregado_seq OWNED BY detalle_entregados_dependencia.id_detalle_entregado;


--
-- Name: detalle_entregados_id_detalle_entregado_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE detalle_entregados_id_detalle_entregado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.detalle_entregados_id_detalle_entregado_seq OWNER TO postgres;

--
-- Name: detalle_entregados_id_detalle_entregado_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE detalle_entregados_id_detalle_entregado_seq OWNED BY detalle_entregados.id_detalle_entregado;


--
-- Name: detalle_recibidos; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_recibidos (
    id_detalle_recibido integer NOT NULL,
    id_especificacion_tiquete integer NOT NULL,
    consecutivo_inicial bigint NOT NULL,
    consecutivo_final bigint NOT NULL,
    id_actacambio bigint NOT NULL
);


ALTER TABLE ventas.detalle_recibidos OWNER TO postgres;

--
-- Name: detalle_recibidos_dependencias; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_recibidos_dependencias (
    id_especificacion_tiquete integer NOT NULL,
    consecutivo_inicial bigint NOT NULL,
    consecutivo_final bigint NOT NULL,
    id_actacambio bigint NOT NULL,
    id_detalle_recibido bigint NOT NULL
);


ALTER TABLE ventas.detalle_recibidos_dependencias OWNER TO postgres;

--
-- Name: detalle_recibidos_dependencias_id_detalle_recibido_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE detalle_recibidos_dependencias_id_detalle_recibido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.detalle_recibidos_dependencias_id_detalle_recibido_seq OWNER TO postgres;

--
-- Name: detalle_recibidos_dependencias_id_detalle_recibido_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE detalle_recibidos_dependencias_id_detalle_recibido_seq OWNED BY detalle_recibidos_dependencias.id_detalle_recibido;


--
-- Name: detalle_recibidos_id_detalle_recibido_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE detalle_recibidos_id_detalle_recibido_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.detalle_recibidos_id_detalle_recibido_seq OWNER TO postgres;

--
-- Name: detalle_recibidos_id_detalle_recibido_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE detalle_recibidos_id_detalle_recibido_seq OWNED BY detalle_recibidos.id_detalle_recibido;


--
-- Name: detalle_remision; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_remision (
    id_det_remision bigint NOT NULL,
    dr_serial1 bigint NOT NULL,
    dr_serial2 bigint NOT NULL,
    id_etp integer NOT NULL,
    id_remision bigint NOT NULL
);


ALTER TABLE ventas.detalle_remision OWNER TO postgres;

--
-- Name: detalle_remision_id_det_remsion_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE detalle_remision_id_det_remsion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.detalle_remision_id_det_remsion_seq OWNER TO postgres;

--
-- Name: detalle_remision_id_det_remsion_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE detalle_remision_id_det_remsion_seq OWNED BY detalle_remision.id_det_remision;


--
-- Name: detalle_validacion; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_validacion (
    id_dv integer NOT NULL,
    cantidad bigint,
    id_etp integer,
    vlor_validacion bigint,
    id_validacion bigint
);


ALTER TABLE ventas.detalle_validacion OWNER TO postgres;

--
-- Name: detalle_validacion_dependencias; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_validacion_dependencias (
    cantidad bigint,
    id_etp integer,
    vlor_validacion bigint,
    id_validacion bigint,
    id_dv bigint NOT NULL
);


ALTER TABLE ventas.detalle_validacion_dependencias OWNER TO postgres;

--
-- Name: detalle_validacion_dependencias_id_dv_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE detalle_validacion_dependencias_id_dv_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.detalle_validacion_dependencias_id_dv_seq OWNER TO postgres;

--
-- Name: detalle_validacion_dependencias_id_dv_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE detalle_validacion_dependencias_id_dv_seq OWNED BY detalle_validacion_dependencias.id_dv;


--
-- Name: detalle_validacion_id_dv_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE detalle_validacion_id_dv_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.detalle_validacion_id_dv_seq OWNER TO postgres;

--
-- Name: detalle_validacion_id_dv_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE detalle_validacion_id_dv_seq OWNED BY detalle_validacion.id_dv;


--
-- Name: detalle_venta; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_venta (
    dv_id bigint NOT NULL,
    dv_serial_1 bigint NOT NULL,
    dv_serial_2 bigint NOT NULL,
    ven_id bigint NOT NULL,
    etp_id integer NOT NULL
);


ALTER TABLE ventas.detalle_venta OWNER TO postgres;

--
-- Name: detalle_venta_dependencia; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE detalle_venta_dependencia (
    dvd_id bigint NOT NULL,
    dvd_serial_1 bigint NOT NULL,
    dvd_serial_2 bigint NOT NULL,
    ven_dep_id bigint NOT NULL,
    etp integer NOT NULL
);


ALTER TABLE ventas.detalle_venta_dependencia OWNER TO postgres;

--
-- Name: detalle_venta_dependencia_dvd_id_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE detalle_venta_dependencia_dvd_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.detalle_venta_dependencia_dvd_id_seq OWNER TO postgres;

--
-- Name: detalle_venta_dependencia_dvd_id_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE detalle_venta_dependencia_dvd_id_seq OWNED BY detalle_venta_dependencia.dvd_id;


--
-- Name: detalle_venta_dv_id_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE detalle_venta_dv_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.detalle_venta_dv_id_seq OWNER TO postgres;

--
-- Name: detalle_venta_dv_id_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE detalle_venta_dv_id_seq OWNED BY detalle_venta.dv_id;


--
-- Name: devolucion_dinero; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE devolucion_dinero (
    id_devolucion_dinero bigint NOT NULL,
    recibo_caja bigint,
    observaciones character varying,
    id_sede_cliente bigint,
    oficio_cliente character varying,
    fecha timestamp without time zone,
    id_usuario integer
);


ALTER TABLE ventas.devolucion_dinero OWNER TO postgres;

--
-- Name: devolucion_dinero_id_devolucion_dinero_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE devolucion_dinero_id_devolucion_dinero_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.devolucion_dinero_id_devolucion_dinero_seq OWNER TO postgres;

--
-- Name: devolucion_dinero_id_devolucion_dinero_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE devolucion_dinero_id_devolucion_dinero_seq OWNED BY devolucion_dinero.id_devolucion_dinero;


--
-- Name: entrada_tiquetes_peajes; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE entrada_tiquetes_peajes (
    id_en_tiq integer NOT NULL,
    fecha_registro timestamp without time zone NOT NULL,
    fecha_remision date NOT NULL,
    consecutivo character varying NOT NULL,
    remitente character varying NOT NULL,
    id_peaje integer NOT NULL,
    observacion character varying,
    id_usuario bigint
);


ALTER TABLE ventas.entrada_tiquetes_peajes OWNER TO postgres;

--
-- Name: entrada_tiquetes_peajes_id_en_tiq_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE entrada_tiquetes_peajes_id_en_tiq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.entrada_tiquetes_peajes_id_en_tiq_seq OWNER TO postgres;

--
-- Name: entrada_tiquetes_peajes_id_en_tiq_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE entrada_tiquetes_peajes_id_en_tiq_seq OWNED BY entrada_tiquetes_peajes.id_en_tiq;


--
-- Name: forma_de_pago; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE forma_de_pago (
    fp_id integer NOT NULL,
    fp_descripcion character varying(50) NOT NULL
);


ALTER TABLE ventas.forma_de_pago OWNER TO postgres;

--
-- Name: forma_de_pago_fp_id_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE forma_de_pago_fp_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.forma_de_pago_fp_id_seq OWNER TO postgres;

--
-- Name: forma_de_pago_fp_id_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE forma_de_pago_fp_id_seq OWNED BY forma_de_pago.fp_id;


--
-- Name: pago; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE pago (
    pa_id bigint NOT NULL,
    pa_serial character varying(20),
    pa_monto bigint NOT NULL,
    ven_id bigint NOT NULL,
    fp_id integer NOT NULL,
    cban_id integer NOT NULL
);


ALTER TABLE ventas.pago OWNER TO postgres;

--
-- Name: pago_pa_id_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE pago_pa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.pago_pa_id_seq OWNER TO postgres;

--
-- Name: pago_pa_id_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE pago_pa_id_seq OWNED BY pago.pa_id;


--
-- Name: pago_validacion; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE pago_validacion (
    id_pa_va bigint NOT NULL,
    id_fp integer NOT NULL,
    id_ctaban integer NOT NULL,
    id_validacion bigint NOT NULL,
    pago_validacion bigint NOT NULL
);


ALTER TABLE ventas.pago_validacion OWNER TO postgres;

--
-- Name: pago_validacion_id_pa_va_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE pago_validacion_id_pa_va_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.pago_validacion_id_pa_va_seq OWNER TO postgres;

--
-- Name: pago_validacion_id_pa_va_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE pago_validacion_id_pa_va_seq OWNED BY pago_validacion.id_pa_va;


--
-- Name: pago_validacion_depe; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE pago_validacion_depe (
    id_pa_va bigint DEFAULT nextval('pago_validacion_id_pa_va_seq'::regclass) NOT NULL,
    id_fp integer NOT NULL,
    id_ctaban integer NOT NULL,
    id_validacion bigint NOT NULL,
    pago_validacion bigint NOT NULL
);


ALTER TABLE ventas.pago_validacion_depe OWNER TO postgres;

--
-- Name: pago_ven_dep; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE pago_ven_dep (
    pago_ven_dep bigint NOT NULL,
    fp_ven_dep integer NOT NULL,
    pago_monto bigint NOT NULL,
    ven_dep_id bigint NOT NULL
);


ALTER TABLE ventas.pago_ven_dep OWNER TO postgres;

--
-- Name: pago_ven_dep_pago_ven_dep_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE pago_ven_dep_pago_ven_dep_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.pago_ven_dep_pago_ven_dep_seq OWNER TO postgres;

--
-- Name: pago_ven_dep_pago_ven_dep_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE pago_ven_dep_pago_ven_dep_seq OWNED BY pago_ven_dep.pago_ven_dep;


--
-- Name: remision_peaje; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE remision_peaje (
    fecha_remision timestamp without time zone,
    id_peaje integer NOT NULL,
    observacion character varying,
    id_usuario integer NOT NULL,
    total_remision bigint,
    id_remision_peaje bigint NOT NULL
);


ALTER TABLE ventas.remision_peaje OWNER TO postgres;

--
-- Name: remision_peaje_id_remision_peaje_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE remision_peaje_id_remision_peaje_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.remision_peaje_id_remision_peaje_seq OWNER TO postgres;

--
-- Name: remision_peaje_id_remision_peaje_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE remision_peaje_id_remision_peaje_seq OWNED BY remision_peaje.id_remision_peaje;


--
-- Name: validacion_tiquetes; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE validacion_tiquetes (
    id_revalidacion bigint NOT NULL,
    recibo_caja bigint NOT NULL,
    observacion character varying NOT NULL,
    fecha_validacion timestamp without time zone NOT NULL,
    id_sede_cliente bigint NOT NULL,
    id_usuario integer NOT NULL
);


ALTER TABLE ventas.validacion_tiquetes OWNER TO postgres;

--
-- Name: revalidacion_tiquetes_id_revalidacion_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE revalidacion_tiquetes_id_revalidacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.revalidacion_tiquetes_id_revalidacion_seq OWNER TO postgres;

--
-- Name: revalidacion_tiquetes_id_revalidacion_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE revalidacion_tiquetes_id_revalidacion_seq OWNED BY validacion_tiquetes.id_revalidacion;


--
-- Name: validacion_tiquetes_dependencias; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE validacion_tiquetes_dependencias (
    recibo_caja bigint NOT NULL,
    observacion character varying NOT NULL,
    fecha_validacion timestamp without time zone NOT NULL,
    id_dependencia integer NOT NULL,
    id_usuario integer NOT NULL,
    id_validacion bigint NOT NULL
);


ALTER TABLE ventas.validacion_tiquetes_dependencias OWNER TO postgres;

--
-- Name: validacion_tiquetes_dependencias_id_validacion_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE validacion_tiquetes_dependencias_id_validacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.validacion_tiquetes_dependencias_id_validacion_seq OWNER TO postgres;

--
-- Name: validacion_tiquetes_dependencias_id_validacion_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE validacion_tiquetes_dependencias_id_validacion_seq OWNED BY validacion_tiquetes_dependencias.id_validacion;


--
-- Name: venta; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE venta (
    ven_id bigint NOT NULL,
    ven_fecha_hora timestamp without time zone DEFAULT now() NOT NULL,
    cli_nit bigint,
    ven_esta_paga boolean NOT NULL,
    ven_observaciones character varying,
    id_usuario numeric(14,0),
    clie_sede bigint,
    venta_total boolean DEFAULT true,
    venta_parcial boolean DEFAULT false,
    sobrante_afavor integer DEFAULT 0,
    ven_recibo_caja bigint,
    id_estacion integer
);


ALTER TABLE ventas.venta OWNER TO postgres;

--
-- Name: venta_dependencia; Type: TABLE; Schema: ventas; Owner: postgres; Tablespace: 
--

CREATE TABLE venta_dependencia (
    ven_dep_id bigint NOT NULL,
    ven_dep_fecha timestamp without time zone NOT NULL,
    item_dependecia integer NOT NULL,
    ven_dep_obse character varying,
    id_usuario integer NOT NULL
);


ALTER TABLE ventas.venta_dependencia OWNER TO postgres;

--
-- Name: venta_dependencia_ven_dep_id_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE venta_dependencia_ven_dep_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.venta_dependencia_ven_dep_id_seq OWNER TO postgres;

--
-- Name: venta_dependencia_ven_dep_id_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE venta_dependencia_ven_dep_id_seq OWNED BY venta_dependencia.ven_dep_id;


--
-- Name: venta_ven_id_seq; Type: SEQUENCE; Schema: ventas; Owner: postgres
--

CREATE SEQUENCE venta_ven_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ventas.venta_ven_id_seq OWNER TO postgres;

--
-- Name: venta_ven_id_seq; Type: SEQUENCE OWNED BY; Schema: ventas; Owner: postgres
--

ALTER SEQUENCE venta_ven_id_seq OWNED BY venta.ven_id;


SET search_path = clientes, pg_catalog;

--
-- Name: id_cliente_sede; Type: DEFAULT; Schema: clientes; Owner: postgres
--

ALTER TABLE ONLY sedes_clientes ALTER COLUMN id_cliente_sede SET DEFAULT nextval('sedes_clientes_id_cliente_sede_seq'::regclass);


SET search_path = consignacion_saldos, pg_catalog;

--
-- Name: cons_id; Type: DEFAULT; Schema: consignacion_saldos; Owner: postgres
--

ALTER TABLE ONLY consignacion_saldo ALTER COLUMN cons_id SET DEFAULT nextval('consignacion_saldo_cons_id_seq'::regclass);


--
-- Name: pag_id; Type: DEFAULT; Schema: consignacion_saldos; Owner: postgres
--

ALTER TABLE ONLY pagos_cons_saldo ALTER COLUMN pag_id SET DEFAULT nextval('pagos_cons_saldo_pag_id_seq'::regclass);


SET search_path = controles_arqueos, pg_catalog;

--
-- Name: id_arq; Type: DEFAULT; Schema: controles_arqueos; Owner: postgres
--

ALTER TABLE ONLY arq_ven_dep_cat ALTER COLUMN id_arq SET DEFAULT nextval('arq_ven_dep_cat_id_arq_seq'::regclass);


--
-- Name: id_arqueo_categoria; Type: DEFAULT; Schema: controles_arqueos; Owner: postgres
--

ALTER TABLE ONLY arqueo_categoria ALTER COLUMN id_arqueo_categoria SET DEFAULT nextval('control_de_arqueo_general_id_arqueo_general_seq'::regclass);


--
-- Name: id_arqueo_general; Type: DEFAULT; Schema: controles_arqueos; Owner: postgres
--

ALTER TABLE ONLY arqueo_general ALTER COLUMN id_arqueo_general SET DEFAULT nextval('arqueo_general_id_arqueo_general_seq'::regclass);


SET search_path = dependencias, pg_catalog;

--
-- Name: id_dependencia; Type: DEFAULT; Schema: dependencias; Owner: postgres
--

ALTER TABLE ONLY dependencia ALTER COLUMN id_dependencia SET DEFAULT nextval('dependencia_id_dependencia_seq'::regclass);


--
-- Name: id_item_depen; Type: DEFAULT; Schema: dependencias; Owner: postgres
--

ALTER TABLE ONLY item_dependencia ALTER COLUMN id_item_depen SET DEFAULT nextval('item_dependencia_id_item_depen_seq'::regclass);


SET search_path = inventario, pg_catalog;

--
-- Name: id_anulacion_tiquete; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY anulacion_tiquetes ALTER COLUMN id_anulacion_tiquete SET DEFAULT nextval('anulacion_tiquetes_id_anulacion_tiquete_seq'::regclass);


--
-- Name: cat_id; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY categoria ALTER COLUMN cat_id SET DEFAULT nextval('categoria_cat_id_seq'::regclass);


--
-- Name: conse_idconsecutivo; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY consecutivos ALTER COLUMN conse_idconsecutivo SET DEFAULT nextval('consecutivos_conse_idconsecutivo_seq'::regclass);


--
-- Name: da_idanulacion; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY detalle_anulacion_tiquetes ALTER COLUMN da_idanulacion SET DEFAULT nextval('detalle_anulacion_tiquetes_da_idanulacion_seq'::regclass);


--
-- Name: etp_id; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY especificacion_tiquete_prepago ALTER COLUMN etp_id SET DEFAULT nextval('especificacion_tiquete_prepago_etp_id_seq'::regclass);


--
-- Name: id_reg; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY reg_rest_tiq ALTER COLUMN id_reg SET DEFAULT nextval('reg_rest_tiq_id_reg_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY tipo_anulacion ALTER COLUMN id SET DEFAULT nextval('tipo_anulacion_id_seq'::regclass);


--
-- Name: tea_id; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY tipo_eje_adicional ALTER COLUMN tea_id SET DEFAULT nextval('tipo_eje_adicional_tea_id_seq'::regclass);


SET search_path = public, pg_catalog;

--
-- Name: dep_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY departamento ALTER COLUMN dep_id SET DEFAULT nextval('departamento_dep_id_seq'::regclass);


--
-- Name: ciu_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY municipio ALTER COLUMN ciu_id SET DEFAULT nextval('ciudad_ciu_id_seq'::regclass);


--
-- Name: pk_audit; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbl_audit ALTER COLUMN pk_audit SET DEFAULT nextval('tbl_audit_pk_audit_seq'::regclass);


--
-- Name: idusuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tbusuario ALTER COLUMN idusuario SET DEFAULT nextval('tbusuario_idusuario_seq'::regclass);


SET search_path = ventas, pg_catalog;

--
-- Name: id_anulacion_recibo; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY anulacion_recibo_caja ALTER COLUMN id_anulacion_recibo SET DEFAULT nextval('anulacion_recibo_caja_id_anulacion_recibo_seq'::regclass);


--
-- Name: id_acta_consecutivo; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cambio_tiquete ALTER COLUMN id_acta_consecutivo SET DEFAULT nextval('cambio_tiquete_id_acta_consecutivo_seq'::regclass);


--
-- Name: id_acta_consecutivo; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cambio_tiquete_dependencias ALTER COLUMN id_acta_consecutivo SET DEFAULT nextval('cambio_tiquete_dependencias_id_acta_consecutivo_seq'::regclass);


--
-- Name: id_can_exce; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cancelacion_excedente_dependencia ALTER COLUMN id_can_exce SET DEFAULT nextval('cancelacio_excedente_dependencia_id_can_exce_seq'::regclass);


--
-- Name: id_can_exce; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cancelacion_excedentes ALTER COLUMN id_can_exce SET DEFAULT nextval('cancelacion_excedentes_id_seq'::regclass);


--
-- Name: id_consignacion; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY consignacion ALTER COLUMN id_consignacion SET DEFAULT nextval('consignacion_id_consignacion_seq'::regclass);


--
-- Name: cban_id; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cuenta_bancaria ALTER COLUMN cban_id SET DEFAULT nextval('cuenta_bancaria_cban_id_seq'::regclass);


--
-- Name: id_det_en_peaje; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY deta_entrega_tiq_peaje ALTER COLUMN id_det_en_peaje SET DEFAULT nextval('deta_entrega_tiq_peaje_id_det_en_peaje_seq'::regclass);


--
-- Name: id_detalle_devolucion; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_devolucion ALTER COLUMN id_detalle_devolucion SET DEFAULT nextval('detalle_devolucion_id_detalle_devolucion_seq'::regclass);


--
-- Name: id_detalle_entregado; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_entregados ALTER COLUMN id_detalle_entregado SET DEFAULT nextval('detalle_entregados_id_detalle_entregado_seq'::regclass);


--
-- Name: id_detalle_entregado; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_entregados_dependencia ALTER COLUMN id_detalle_entregado SET DEFAULT nextval('detalle_entregados_dependencia_id_detalle_entregado_seq'::regclass);


--
-- Name: id_detalle_recibido; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_recibidos ALTER COLUMN id_detalle_recibido SET DEFAULT nextval('detalle_recibidos_id_detalle_recibido_seq'::regclass);


--
-- Name: id_detalle_recibido; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_recibidos_dependencias ALTER COLUMN id_detalle_recibido SET DEFAULT nextval('detalle_recibidos_dependencias_id_detalle_recibido_seq'::regclass);


--
-- Name: id_det_remision; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_remision ALTER COLUMN id_det_remision SET DEFAULT nextval('detalle_remision_id_det_remsion_seq'::regclass);


--
-- Name: id_dv; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_validacion ALTER COLUMN id_dv SET DEFAULT nextval('detalle_validacion_id_dv_seq'::regclass);


--
-- Name: id_dv; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_validacion_dependencias ALTER COLUMN id_dv SET DEFAULT nextval('detalle_validacion_dependencias_id_dv_seq'::regclass);


--
-- Name: dv_id; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_venta ALTER COLUMN dv_id SET DEFAULT nextval('detalle_venta_dv_id_seq'::regclass);


--
-- Name: dvd_id; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_venta_dependencia ALTER COLUMN dvd_id SET DEFAULT nextval('detalle_venta_dependencia_dvd_id_seq'::regclass);


--
-- Name: id_devolucion_dinero; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY devolucion_dinero ALTER COLUMN id_devolucion_dinero SET DEFAULT nextval('devolucion_dinero_id_devolucion_dinero_seq'::regclass);


--
-- Name: id_en_tiq; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY entrada_tiquetes_peajes ALTER COLUMN id_en_tiq SET DEFAULT nextval('entrada_tiquetes_peajes_id_en_tiq_seq'::regclass);


--
-- Name: fp_id; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY forma_de_pago ALTER COLUMN fp_id SET DEFAULT nextval('forma_de_pago_fp_id_seq'::regclass);


--
-- Name: pa_id; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY pago ALTER COLUMN pa_id SET DEFAULT nextval('pago_pa_id_seq'::regclass);


--
-- Name: id_pa_va; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY pago_validacion ALTER COLUMN id_pa_va SET DEFAULT nextval('pago_validacion_id_pa_va_seq'::regclass);


--
-- Name: pago_ven_dep; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY pago_ven_dep ALTER COLUMN pago_ven_dep SET DEFAULT nextval('pago_ven_dep_pago_ven_dep_seq'::regclass);


--
-- Name: id_remision_peaje; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY remision_peaje ALTER COLUMN id_remision_peaje SET DEFAULT nextval('remision_peaje_id_remision_peaje_seq'::regclass);


--
-- Name: id_revalidacion; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY validacion_tiquetes ALTER COLUMN id_revalidacion SET DEFAULT nextval('revalidacion_tiquetes_id_revalidacion_seq'::regclass);


--
-- Name: id_validacion; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY validacion_tiquetes_dependencias ALTER COLUMN id_validacion SET DEFAULT nextval('validacion_tiquetes_dependencias_id_validacion_seq'::regclass);


--
-- Name: ven_id; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY venta ALTER COLUMN ven_id SET DEFAULT nextval('venta_ven_id_seq'::regclass);


--
-- Name: ven_dep_id; Type: DEFAULT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY venta_dependencia ALTER COLUMN ven_dep_id SET DEFAULT nextval('venta_dependencia_ven_dep_id_seq'::regclass);


SET search_path = clientes, pg_catalog;

--
-- Name: pk_clie_sede; Type: CONSTRAINT; Schema: clientes; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sedes_clientes
    ADD CONSTRAINT pk_clie_sede PRIMARY KEY (id_cliente_sede);


--
-- Name: pk_cliente; Type: CONSTRAINT; Schema: clientes; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cliente
    ADD CONSTRAINT pk_cliente PRIMARY KEY (cli_nit);


SET search_path = consignacion_saldos, pg_catalog;

--
-- Name: consignacion_saldo_pkey; Type: CONSTRAINT; Schema: consignacion_saldos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY consignacion_saldo
    ADD CONSTRAINT consignacion_saldo_pkey PRIMARY KEY (cons_id);


--
-- Name: pagos_cons_saldo_pkey; Type: CONSTRAINT; Schema: consignacion_saldos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pagos_cons_saldo
    ADD CONSTRAINT pagos_cons_saldo_pkey PRIMARY KEY (pag_id);


--
-- Name: uni_reci_caja; Type: CONSTRAINT; Schema: consignacion_saldos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY consignacion_saldo
    ADD CONSTRAINT uni_reci_caja UNIQUE (cons_recibo_caja);


SET search_path = controles_arqueos, pg_catalog;

--
-- Name: arq_ven_dep_cat_pkey; Type: CONSTRAINT; Schema: controles_arqueos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY arq_ven_dep_cat
    ADD CONSTRAINT arq_ven_dep_cat_pkey PRIMARY KEY (id_arq);


--
-- Name: arqueo_categoria_dependencia_pkey; Type: CONSTRAINT; Schema: controles_arqueos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY arqueo_categoria_dependencia
    ADD CONSTRAINT arqueo_categoria_dependencia_pkey PRIMARY KEY (id_arqueo_categoria);


--
-- Name: arqueo_general_pkey; Type: CONSTRAINT; Schema: controles_arqueos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY arqueo_general
    ADD CONSTRAINT arqueo_general_pkey PRIMARY KEY (id_arqueo_general);


--
-- Name: control_de_arqueo_general_pkey; Type: CONSTRAINT; Schema: controles_arqueos; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY arqueo_categoria
    ADD CONSTRAINT control_de_arqueo_general_pkey PRIMARY KEY (id_arqueo_categoria);


SET search_path = dependencias, pg_catalog;

--
-- Name: Peajes_pkey; Type: CONSTRAINT; Schema: dependencias; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY peajes
    ADD CONSTRAINT "Peajes_pkey" PRIMARY KEY (codigo_peaje);


--
-- Name: dependencia_pkey; Type: CONSTRAINT; Schema: dependencias; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY dependencia
    ADD CONSTRAINT dependencia_pkey PRIMARY KEY (id_dependencia);


--
-- Name: item_dependencia_pkey; Type: CONSTRAINT; Schema: dependencias; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY item_dependencia
    ADD CONSTRAINT item_dependencia_pkey PRIMARY KEY (id_item_depen);


SET search_path = inventario, pg_catalog;

--
-- Name: anulacion_tiquetes_pkey; Type: CONSTRAINT; Schema: inventario; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY anulacion_tiquetes
    ADD CONSTRAINT anulacion_tiquetes_pkey PRIMARY KEY (id_anulacion_tiquete);


--
-- Name: detalle_anulacion_tiquetes_pkey; Type: CONSTRAINT; Schema: inventario; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_anulacion_tiquetes
    ADD CONSTRAINT detalle_anulacion_tiquetes_pkey PRIMARY KEY (da_idanulacion);


--
-- Name: pk_categoria; Type: CONSTRAINT; Schema: inventario; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY categoria
    ADD CONSTRAINT pk_categoria PRIMARY KEY (cat_id);


--
-- Name: pk_especificacion_tiquete_prepago; Type: CONSTRAINT; Schema: inventario; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY especificacion_tiquete_prepago
    ADD CONSTRAINT pk_especificacion_tiquete_prepago PRIMARY KEY (etp_id);


--
-- Name: pk_tipo_eje_adicional; Type: CONSTRAINT; Schema: inventario; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_eje_adicional
    ADD CONSTRAINT pk_tipo_eje_adicional PRIMARY KEY (tea_id);


--
-- Name: reg_rest_tiq_pkey; Type: CONSTRAINT; Schema: inventario; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY reg_rest_tiq
    ADD CONSTRAINT reg_rest_tiq_pkey PRIMARY KEY (id_reg);


--
-- Name: tipo_anulacion_pkey; Type: CONSTRAINT; Schema: inventario; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipo_anulacion
    ADD CONSTRAINT tipo_anulacion_pkey PRIMARY KEY (id);


SET search_path = public, pg_catalog;

--
-- Name: ciudad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY municipio
    ADD CONSTRAINT ciudad_pkey PRIMARY KEY (ciu_id);


--
-- Name: departamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (dep_id);


--
-- Name: pk_audit; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbl_audit
    ADD CONSTRAINT pk_audit PRIMARY KEY (pk_audit);


--
-- Name: pk_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tbusuario
    ADD CONSTRAINT pk_usuario PRIMARY KEY (cedula);


SET search_path = ventas, pg_catalog;

--
-- Name: UNIQUE_ven_recibo; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY venta
    ADD CONSTRAINT "UNIQUE_ven_recibo" UNIQUE (ven_recibo_caja);


--
-- Name: anulacion_recibo_caja_numero_recibo_key; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY anulacion_recibo_caja
    ADD CONSTRAINT anulacion_recibo_caja_numero_recibo_key UNIQUE (numero_recibo);


--
-- Name: anulacion_recibo_caja_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY anulacion_recibo_caja
    ADD CONSTRAINT anulacion_recibo_caja_pkey PRIMARY KEY (id_anulacion_recibo);


--
-- Name: cambio_tiquete_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cambio_tiquete
    ADD CONSTRAINT cambio_tiquete_pkey PRIMARY KEY (id_acta_consecutivo);


--
-- Name: consignacion_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY consignacion
    ADD CONSTRAINT consignacion_pkey PRIMARY KEY (id_consignacion);


--
-- Name: deta_entrega_tiq_peaje_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY deta_entrega_tiq_peaje
    ADD CONSTRAINT deta_entrega_tiq_peaje_pkey PRIMARY KEY (id_det_en_peaje);


--
-- Name: detalle_devolucion_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_devolucion
    ADD CONSTRAINT detalle_devolucion_pkey PRIMARY KEY (id_detalle_devolucion);


--
-- Name: detalle_remision_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_remision
    ADD CONSTRAINT detalle_remision_pkey PRIMARY KEY (id_det_remision);


--
-- Name: detalle_validacion_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_validacion
    ADD CONSTRAINT detalle_validacion_pkey PRIMARY KEY (id_dv);


--
-- Name: detalle_venta_dependencia_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_venta_dependencia
    ADD CONSTRAINT detalle_venta_dependencia_pkey PRIMARY KEY (dvd_id);


--
-- Name: devolucion_dinero_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY devolucion_dinero
    ADD CONSTRAINT devolucion_dinero_pkey PRIMARY KEY (id_devolucion_dinero);


--
-- Name: entrada_tiquetes_peajes_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY entrada_tiquetes_peajes
    ADD CONSTRAINT entrada_tiquetes_peajes_pkey PRIMARY KEY (id_en_tiq);


--
-- Name: pago_validacion_Depe_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pago_validacion_depe
    ADD CONSTRAINT "pago_validacion_Depe_pkey" PRIMARY KEY (id_pa_va);


--
-- Name: pago_validacion_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pago_validacion
    ADD CONSTRAINT pago_validacion_pkey PRIMARY KEY (id_pa_va);


--
-- Name: pago_ven_dep_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pago_ven_dep
    ADD CONSTRAINT pago_ven_dep_pkey PRIMARY KEY (pago_ven_dep);


--
-- Name: pk_cuenta_bancaria; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cuenta_bancaria
    ADD CONSTRAINT pk_cuenta_bancaria PRIMARY KEY (cban_id);


--
-- Name: pk_detalle_entregado; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_entregados
    ADD CONSTRAINT pk_detalle_entregado PRIMARY KEY (id_detalle_entregado);


--
-- Name: pk_detalle_validacion; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_validacion_dependencias
    ADD CONSTRAINT pk_detalle_validacion PRIMARY KEY (id_dv);


--
-- Name: pk_detalle_venta; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_venta
    ADD CONSTRAINT pk_detalle_venta PRIMARY KEY (dv_id);


--
-- Name: pk_forma_de_pago; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY forma_de_pago
    ADD CONSTRAINT pk_forma_de_pago PRIMARY KEY (fp_id);


--
-- Name: pk_id_detalle_entregado; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_entregados_dependencia
    ADD CONSTRAINT pk_id_detalle_entregado PRIMARY KEY (id_detalle_entregado);


--
-- Name: pk_id_detalle_recibido; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_recibidos
    ADD CONSTRAINT pk_id_detalle_recibido PRIMARY KEY (id_detalle_recibido);


--
-- Name: pk_id_detallle_recibidos; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detalle_recibidos_dependencias
    ADD CONSTRAINT pk_id_detallle_recibidos PRIMARY KEY (id_detalle_recibido);


--
-- Name: pk_id_remision_peaje; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY remision_peaje
    ADD CONSTRAINT pk_id_remision_peaje PRIMARY KEY (id_remision_peaje);


--
-- Name: pk_idacta; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cambio_tiquete_dependencias
    ADD CONSTRAINT pk_idacta PRIMARY KEY (id_acta_consecutivo);


--
-- Name: pk_idcan_exce; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cancelacion_excedente_dependencia
    ADD CONSTRAINT pk_idcan_exce PRIMARY KEY (id_can_exce);


--
-- Name: pk_idexcedente; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cancelacion_excedentes
    ADD CONSTRAINT pk_idexcedente PRIMARY KEY (id_can_exce);


--
-- Name: pk_pago; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pago
    ADD CONSTRAINT pk_pago PRIMARY KEY (pa_id);


--
-- Name: pk_validacion; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY validacion_tiquetes_dependencias
    ADD CONSTRAINT pk_validacion PRIMARY KEY (id_validacion);


--
-- Name: pk_venta; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY venta
    ADD CONSTRAINT pk_venta PRIMARY KEY (ven_id);


--
-- Name: revalidacion_tiquetes_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY validacion_tiquetes
    ADD CONSTRAINT revalidacion_tiquetes_pkey PRIMARY KEY (id_revalidacion);


--
-- Name: unico_recibo_caja; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cancelacion_excedentes
    ADD CONSTRAINT unico_recibo_caja UNIQUE (recibo_caja);


--
-- Name: uniq_recibo; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY validacion_tiquetes
    ADD CONSTRAINT uniq_recibo UNIQUE (recibo_caja);


--
-- Name: unique_recibo; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY devolucion_dinero
    ADD CONSTRAINT unique_recibo UNIQUE (recibo_caja);


--
-- Name: validacion_tiquetes_dependencias_recibo_caja_key; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY validacion_tiquetes_dependencias
    ADD CONSTRAINT validacion_tiquetes_dependencias_recibo_caja_key UNIQUE (recibo_caja);


--
-- Name: venta_dependencia_pkey; Type: CONSTRAINT; Schema: ventas; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY venta_dependencia
    ADD CONSTRAINT venta_dependencia_pkey PRIMARY KEY (ven_dep_id);


SET search_path = bucardo, pg_catalog;

--
-- Name: bucardo_d_controles_arqueos_arqueo_categoria_dependencia_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_d_controles_arqueos_arqueo_categoria_dependencia_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16439)::oid);


--
-- Name: bucardo_d_controles_arqueos_arqueo_categoria_dependencia_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_d_controles_arqueos_arqueo_categoria_dependencia_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16439)::oid);


--
-- Name: bucardo_delta_clientes_cliente_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_clientes_cliente_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16402)::oid);


--
-- Name: bucardo_delta_clientes_cliente_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_clientes_cliente_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16402)::oid);


--
-- Name: bucardo_delta_clientes_sedes_clientes_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_clientes_sedes_clientes_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16408)::oid);


--
-- Name: bucardo_delta_clientes_sedes_clientes_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_clientes_sedes_clientes_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16408)::oid);


--
-- Name: bucardo_delta_consignacion_saldos_consignacion_saldo_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_consignacion_saldos_consignacion_saldo_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16416)::oid);


--
-- Name: bucardo_delta_consignacion_saldos_consignacion_saldo_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_consignacion_saldos_consignacion_saldo_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16416)::oid);


--
-- Name: bucardo_delta_consignacion_saldos_pagos_cons_saldo_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_consignacion_saldos_pagos_cons_saldo_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16424)::oid);


--
-- Name: bucardo_delta_consignacion_saldos_pagos_cons_saldo_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_consignacion_saldos_pagos_cons_saldo_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16424)::oid);


--
-- Name: bucardo_delta_controles_arqueos_arq_ven_dep_cat_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_controles_arqueos_arq_ven_dep_cat_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16429)::oid);


--
-- Name: bucardo_delta_controles_arqueos_arq_ven_dep_cat_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_controles_arqueos_arq_ven_dep_cat_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16429)::oid);


--
-- Name: bucardo_delta_controles_arqueos_arqueo_categoria_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_controles_arqueos_arqueo_categoria_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16434)::oid);


--
-- Name: bucardo_delta_controles_arqueos_arqueo_categoria_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_controles_arqueos_arqueo_categoria_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16434)::oid);


--
-- Name: bucardo_delta_controles_arqueos_arqueo_general_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_controles_arqueos_arqueo_general_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16443)::oid);


--
-- Name: bucardo_delta_controles_arqueos_arqueo_general_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_controles_arqueos_arqueo_general_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16443)::oid);


--
-- Name: bucardo_delta_dependencias_dependencia_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_dependencias_dependencia_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16448)::oid);


--
-- Name: bucardo_delta_dependencias_dependencia_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_dependencias_dependencia_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16448)::oid);


--
-- Name: bucardo_delta_dependencias_item_dependencia_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_dependencias_item_dependencia_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16456)::oid);


--
-- Name: bucardo_delta_dependencias_item_dependencia_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_dependencias_item_dependencia_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16456)::oid);


--
-- Name: bucardo_delta_dependencias_peajes_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_dependencias_peajes_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16464)::oid);


--
-- Name: bucardo_delta_dependencias_peajes_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_dependencias_peajes_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16464)::oid);


--
-- Name: bucardo_delta_inventario_anulacion_tiquetes_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_inventario_anulacion_tiquetes_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16470)::oid);


--
-- Name: bucardo_delta_inventario_anulacion_tiquetes_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_inventario_anulacion_tiquetes_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16470)::oid);


--
-- Name: bucardo_delta_inventario_categoria_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_inventario_categoria_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16478)::oid);


--
-- Name: bucardo_delta_inventario_categoria_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_inventario_categoria_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16478)::oid);


--
-- Name: bucardo_delta_inventario_consecutivos_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_inventario_consecutivos_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16486)::oid);


--
-- Name: bucardo_delta_inventario_consecutivos_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_inventario_consecutivos_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16486)::oid);


--
-- Name: bucardo_delta_inventario_detalle_anulacion_tiquetes_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_inventario_detalle_anulacion_tiquetes_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16496)::oid);


--
-- Name: bucardo_delta_inventario_detalle_anulacion_tiquetes_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_inventario_detalle_anulacion_tiquetes_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16496)::oid);


--
-- Name: bucardo_delta_inventario_reg_rest_tiq_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_inventario_reg_rest_tiq_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (17303)::oid);


--
-- Name: bucardo_delta_inventario_reg_rest_tiq_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_inventario_reg_rest_tiq_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (17303)::oid);


--
-- Name: bucardo_delta_inventario_tipo_eje_adicional_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_inventario_tipo_eje_adicional_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16506)::oid);


--
-- Name: bucardo_delta_inventario_tipo_eje_adicional_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_inventario_tipo_eje_adicional_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16506)::oid);


--
-- Name: bucardo_delta_public_departamento_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_public_departamento_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16522)::oid);


--
-- Name: bucardo_delta_public_departamento_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_public_departamento_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16522)::oid);


--
-- Name: bucardo_delta_public_municipio_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_public_municipio_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16514)::oid);


--
-- Name: bucardo_delta_public_municipio_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_public_municipio_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16514)::oid);


--
-- Name: bucardo_delta_public_tbl_audit_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_public_tbl_audit_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16530)::oid);


--
-- Name: bucardo_delta_public_tbl_audit_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_public_tbl_audit_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16530)::oid);


--
-- Name: bucardo_delta_public_tbusuario_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_public_tbusuario_rowid ON bucardo_delta USING btree (((rowid)::numeric)) WHERE (tablename = (16538)::oid);


--
-- Name: bucardo_delta_public_tbusuario_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_public_tbusuario_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16538)::oid);


--
-- Name: bucardo_delta_targetdb_unique; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE UNIQUE INDEX bucardo_delta_targetdb_unique ON bucardo_delta_targets USING btree (tablename, targetdb);


--
-- Name: bucardo_delta_txntime; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_txntime ON bucardo_delta USING btree (txntime);


--
-- Name: bucardo_delta_ventas_anulacion_recibo_caja_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_anulacion_recibo_caja_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16546)::oid);


--
-- Name: bucardo_delta_ventas_anulacion_recibo_caja_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_anulacion_recibo_caja_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16546)::oid);


--
-- Name: bucardo_delta_ventas_cambio_tiquete_dependencias_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_cambio_tiquete_dependencias_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16560)::oid);


--
-- Name: bucardo_delta_ventas_cambio_tiquete_dependencias_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_cambio_tiquete_dependencias_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16560)::oid);


--
-- Name: bucardo_delta_ventas_cambio_tiquete_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_cambio_tiquete_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16554)::oid);


--
-- Name: bucardo_delta_ventas_cambio_tiquete_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_cambio_tiquete_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16554)::oid);


--
-- Name: bucardo_delta_ventas_cancelacion_excedente_dependencia_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_cancelacion_excedente_dependencia_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16570)::oid);


--
-- Name: bucardo_delta_ventas_cancelacion_excedente_dependencia_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_cancelacion_excedente_dependencia_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16570)::oid);


--
-- Name: bucardo_delta_ventas_cancelacion_excedentes_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_cancelacion_excedentes_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16575)::oid);


--
-- Name: bucardo_delta_ventas_cancelacion_excedentes_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_cancelacion_excedentes_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16575)::oid);


--
-- Name: bucardo_delta_ventas_consignacion_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_consignacion_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16582)::oid);


--
-- Name: bucardo_delta_ventas_consignacion_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_consignacion_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16582)::oid);


--
-- Name: bucardo_delta_ventas_cuenta_bancaria_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_cuenta_bancaria_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16591)::oid);


--
-- Name: bucardo_delta_ventas_cuenta_bancaria_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_cuenta_bancaria_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16591)::oid);


--
-- Name: bucardo_delta_ventas_deta_entrega_tiq_peaje_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_deta_entrega_tiq_peaje_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16596)::oid);


--
-- Name: bucardo_delta_ventas_deta_entrega_tiq_peaje_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_deta_entrega_tiq_peaje_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16596)::oid);


--
-- Name: bucardo_delta_ventas_detalle_devolucion_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_devolucion_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16601)::oid);


--
-- Name: bucardo_delta_ventas_detalle_devolucion_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_devolucion_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16601)::oid);


--
-- Name: bucardo_delta_ventas_detalle_entregados_dependencia_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_entregados_dependencia_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16609)::oid);


--
-- Name: bucardo_delta_ventas_detalle_entregados_dependencia_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_entregados_dependencia_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16609)::oid);


--
-- Name: bucardo_delta_ventas_detalle_entregados_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_entregados_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16606)::oid);


--
-- Name: bucardo_delta_ventas_detalle_entregados_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_entregados_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16606)::oid);


--
-- Name: bucardo_delta_ventas_detalle_recibidos_dependencias_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_recibidos_dependencias_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16619)::oid);


--
-- Name: bucardo_delta_ventas_detalle_recibidos_dependencias_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_recibidos_dependencias_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16619)::oid);


--
-- Name: bucardo_delta_ventas_detalle_recibidos_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_recibidos_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16616)::oid);


--
-- Name: bucardo_delta_ventas_detalle_recibidos_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_recibidos_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16616)::oid);


--
-- Name: bucardo_delta_ventas_detalle_remision_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_remision_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16626)::oid);


--
-- Name: bucardo_delta_ventas_detalle_remision_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_remision_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16626)::oid);


--
-- Name: bucardo_delta_ventas_detalle_validacion_dependencias_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_validacion_dependencias_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16634)::oid);


--
-- Name: bucardo_delta_ventas_detalle_validacion_dependencias_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_validacion_dependencias_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16634)::oid);


--
-- Name: bucardo_delta_ventas_detalle_validacion_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_validacion_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16631)::oid);


--
-- Name: bucardo_delta_ventas_detalle_validacion_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_validacion_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16631)::oid);


--
-- Name: bucardo_delta_ventas_detalle_venta_dependencia_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_venta_dependencia_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16644)::oid);


--
-- Name: bucardo_delta_ventas_detalle_venta_dependencia_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_venta_dependencia_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16644)::oid);


--
-- Name: bucardo_delta_ventas_detalle_venta_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_venta_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16641)::oid);


--
-- Name: bucardo_delta_ventas_detalle_venta_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_detalle_venta_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16641)::oid);


--
-- Name: bucardo_delta_ventas_devolucion_dinero_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_devolucion_dinero_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16651)::oid);


--
-- Name: bucardo_delta_ventas_devolucion_dinero_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_devolucion_dinero_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16651)::oid);


--
-- Name: bucardo_delta_ventas_entrada_tiquetes_peajes_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_entrada_tiquetes_peajes_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16659)::oid);


--
-- Name: bucardo_delta_ventas_entrada_tiquetes_peajes_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_entrada_tiquetes_peajes_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16659)::oid);


--
-- Name: bucardo_delta_ventas_forma_de_pago_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_forma_de_pago_rowid ON bucardo_delta USING btree (((rowid)::integer)) WHERE (tablename = (16667)::oid);


--
-- Name: bucardo_delta_ventas_forma_de_pago_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_forma_de_pago_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16667)::oid);


--
-- Name: bucardo_delta_ventas_pago_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_pago_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16672)::oid);


--
-- Name: bucardo_delta_ventas_pago_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_pago_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16672)::oid);


--
-- Name: bucardo_delta_ventas_pago_validacion_depe_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_pago_validacion_depe_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16682)::oid);


--
-- Name: bucardo_delta_ventas_pago_validacion_depe_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_pago_validacion_depe_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16682)::oid);


--
-- Name: bucardo_delta_ventas_pago_validacion_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_pago_validacion_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16677)::oid);


--
-- Name: bucardo_delta_ventas_pago_validacion_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_pago_validacion_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16677)::oid);


--
-- Name: bucardo_delta_ventas_pago_ven_dep_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_pago_ven_dep_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16686)::oid);


--
-- Name: bucardo_delta_ventas_pago_ven_dep_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_pago_ven_dep_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16686)::oid);


--
-- Name: bucardo_delta_ventas_remision_peaje_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_remision_peaje_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16691)::oid);


--
-- Name: bucardo_delta_ventas_remision_peaje_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_remision_peaje_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16691)::oid);


--
-- Name: bucardo_delta_ventas_validacion_tiquetes_dependencias_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_validacion_tiquetes_dependencias_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16707)::oid);


--
-- Name: bucardo_delta_ventas_validacion_tiquetes_dependencias_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_validacion_tiquetes_dependencias_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16707)::oid);


--
-- Name: bucardo_delta_ventas_validacion_tiquetes_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_validacion_tiquetes_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16699)::oid);


--
-- Name: bucardo_delta_ventas_validacion_tiquetes_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_validacion_tiquetes_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16699)::oid);


--
-- Name: bucardo_delta_ventas_venta_dependencia_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_venta_dependencia_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16725)::oid);


--
-- Name: bucardo_delta_ventas_venta_dependencia_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_venta_dependencia_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16725)::oid);


--
-- Name: bucardo_delta_ventas_venta_rowid; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_venta_rowid ON bucardo_delta USING btree (((rowid)::bigint)) WHERE (tablename = (16715)::oid);


--
-- Name: bucardo_delta_ventas_venta_txn; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_delta_ventas_venta_txn ON bucardo_delta USING btree (txntime) WHERE (tablename = (16715)::oid);


--
-- Name: bucardo_sequences_tablename; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE UNIQUE INDEX bucardo_sequences_tablename ON bucardo_sequences USING btree (tablename);


--
-- Name: bucardo_track_target; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_track_target ON bucardo_track USING btree (tablename, txntime, targetdb);


--
-- Name: bucardo_truncate_trigger_index; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_truncate_trigger_index ON bucardo_truncate_trigger USING btree (sync, tablename) WHERE (replicated IS NULL);


--
-- Name: bucardo_truncate_trigger_log_index; Type: INDEX; Schema: bucardo; Owner: bucardo; Tablespace: 
--

CREATE INDEX bucardo_truncate_trigger_log_index ON bucardo_truncate_trigger_log USING btree (sync, targetdb, replicated);


SET search_path = clientes, pg_catalog;

--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: clientes; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON cliente FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_cli_nit();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: clientes; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON sedes_clientes FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_cliente_sede();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: clientes; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON cliente FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: clientes; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON sedes_clientes FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


SET search_path = consignacion_saldos, pg_catalog;

--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: consignacion_saldos; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON consignacion_saldo FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_cons_id();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: consignacion_saldos; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON pagos_cons_saldo FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_pag_id();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: consignacion_saldos; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON consignacion_saldo FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: consignacion_saldos; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON pagos_cons_saldo FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


SET search_path = controles_arqueos, pg_catalog;

--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: controles_arqueos; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON arq_ven_dep_cat FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_arq();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: controles_arqueos; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON arqueo_categoria FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_arqueo_categoria();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: controles_arqueos; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON arqueo_categoria_dependencia FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_arqueo_categoria();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: controles_arqueos; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON arqueo_general FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_arqueo_general();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: controles_arqueos; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON arq_ven_dep_cat FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: controles_arqueos; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON arqueo_categoria FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: controles_arqueos; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON arqueo_categoria_dependencia FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: controles_arqueos; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON arqueo_general FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


SET search_path = dependencias, pg_catalog;

--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: dependencias; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON dependencia FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_dependencia();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: dependencias; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON item_dependencia FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_item_depen();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: dependencias; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON peajes FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_codigo_peaje();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: dependencias; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON dependencia FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: dependencias; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON item_dependencia FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: dependencias; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON peajes FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


SET search_path = inventario, pg_catalog;

--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: inventario; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON anulacion_tiquetes FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_anulacion_tiquete();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: inventario; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON categoria FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_cat_id();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: inventario; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON consecutivos FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_conse_num_consecutivo_tiqute();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: inventario; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON detalle_anulacion_tiquetes FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_da_idanulacion();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: inventario; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON reg_rest_tiq FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_reg();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: inventario; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON tipo_eje_adicional FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_tea_id();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: inventario; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON anulacion_tiquetes FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: inventario; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON categoria FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: inventario; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON consecutivos FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: inventario; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON detalle_anulacion_tiquetes FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: inventario; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON reg_rest_tiq FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: inventario; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON tipo_eje_adicional FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: tbl_atributos_tg_audit; Type: TRIGGER; Schema: inventario; Owner: postgres
--

CREATE TRIGGER tbl_atributos_tg_audit AFTER INSERT OR DELETE OR UPDATE ON consecutivos FOR EACH ROW EXECUTE PROCEDURE public.fn_log_audit();

ALTER TABLE consecutivos DISABLE TRIGGER tbl_atributos_tg_audit;


SET search_path = public, pg_catalog;

--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON departamento FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_dep_id();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON municipio FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_ciu_id();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON tbl_audit FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_pk_audit();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON tbusuario FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_cedula();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON departamento FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON municipio FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON tbl_audit FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: public; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON tbusuario FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


SET search_path = ventas, pg_catalog;

--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON anulacion_recibo_caja FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_anulacion_recibo();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON cambio_tiquete FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_acta_consecutivo();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON cambio_tiquete_dependencias FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_acta_consecutivo();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON cancelacion_excedente_dependencia FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_can_exce();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON cancelacion_excedentes FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_can_exce();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON consignacion FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_consignacion();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON cuenta_bancaria FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_cban_id();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON deta_entrega_tiq_peaje FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_det_en_peaje();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON detalle_devolucion FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_detalle_devolucion();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON detalle_entregados FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_detalle_entregado();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON detalle_entregados_dependencia FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_detalle_entregado();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON detalle_recibidos FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_detalle_recibido();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON detalle_recibidos_dependencias FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_detalle_recibido();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON detalle_remision FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_det_remision();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON detalle_validacion FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_dv();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON detalle_validacion_dependencias FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_dv();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON detalle_venta FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_dv_id();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON detalle_venta_dependencia FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_dvd_id();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON devolucion_dinero FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_devolucion_dinero();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON entrada_tiquetes_peajes FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_en_tiq();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON forma_de_pago FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_fp_id();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON pago FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_pa_id();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON pago_validacion FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_pa_va();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON pago_validacion_depe FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_pa_va();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON pago_ven_dep FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_pago_ven_dep();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON remision_peaje FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_remision_peaje();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON validacion_tiquetes FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_revalidacion();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON validacion_tiquetes_dependencias FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_id_validacion();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON venta FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_ven_id();


--
-- Name: bucardo_add_delta; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_add_delta AFTER INSERT OR DELETE OR UPDATE ON venta_dependencia FOR EACH ROW EXECUTE PROCEDURE bucardo.bucardo_add_delta_ven_dep_id();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON anulacion_recibo_caja FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON cambio_tiquete FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON cambio_tiquete_dependencias FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON cancelacion_excedente_dependencia FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON cancelacion_excedentes FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON consignacion FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON cuenta_bancaria FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON deta_entrega_tiq_peaje FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON detalle_devolucion FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON detalle_entregados FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON detalle_entregados_dependencia FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON detalle_recibidos FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON detalle_recibidos_dependencias FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON detalle_remision FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON detalle_validacion FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON detalle_validacion_dependencias FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON detalle_venta FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON detalle_venta_dependencia FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON devolucion_dinero FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON entrada_tiquetes_peajes FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON forma_de_pago FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON pago FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON pago_validacion FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON pago_validacion_depe FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON pago_ven_dep FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON remision_peaje FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON validacion_tiquetes FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON validacion_tiquetes_dependencias FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON venta FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


--
-- Name: bucardo_triggerkick_localhostremoto001; Type: TRIGGER; Schema: ventas; Owner: postgres
--

CREATE TRIGGER bucardo_triggerkick_localhostremoto001 AFTER INSERT OR DELETE OR UPDATE OR TRUNCATE ON venta_dependencia FOR EACH STATEMENT EXECUTE PROCEDURE bucardo.bucardo_triggerkick_localhostremoto001();


SET search_path = clientes, pg_catalog;

--
-- Name: fk_cli_nit; Type: FK CONSTRAINT; Schema: clientes; Owner: postgres
--

ALTER TABLE ONLY sedes_clientes
    ADD CONSTRAINT fk_cli_nit FOREIGN KEY (cli_nit) REFERENCES cliente(cli_nit);


--
-- Name: fk_id_ciudad; Type: FK CONSTRAINT; Schema: clientes; Owner: postgres
--

ALTER TABLE ONLY sedes_clientes
    ADD CONSTRAINT fk_id_ciudad FOREIGN KEY (id_clie_ciudad) REFERENCES public.municipio(ciu_id);


SET search_path = consignacion_saldos, pg_catalog;

--
-- Name: fk_cban; Type: FK CONSTRAINT; Schema: consignacion_saldos; Owner: postgres
--

ALTER TABLE ONLY pagos_cons_saldo
    ADD CONSTRAINT fk_cban FOREIGN KEY (pag_id_cban) REFERENCES ventas.cuenta_bancaria(cban_id);


--
-- Name: fk_cli_nit; Type: FK CONSTRAINT; Schema: consignacion_saldos; Owner: postgres
--

ALTER TABLE ONLY consignacion_saldo
    ADD CONSTRAINT fk_cli_nit FOREIGN KEY (cons_nit_cliente) REFERENCES clientes.sedes_clientes(id_cliente_sede);


--
-- Name: fk_cs; Type: FK CONSTRAINT; Schema: consignacion_saldos; Owner: postgres
--

ALTER TABLE ONLY pagos_cons_saldo
    ADD CONSTRAINT fk_cs FOREIGN KEY (pag_cons_saldo) REFERENCES consignacion_saldo(cons_id);


--
-- Name: fk_fp; Type: FK CONSTRAINT; Schema: consignacion_saldos; Owner: postgres
--

ALTER TABLE ONLY pagos_cons_saldo
    ADD CONSTRAINT fk_fp FOREIGN KEY (pag_id_fp) REFERENCES ventas.forma_de_pago(fp_id);


SET search_path = controles_arqueos, pg_catalog;

--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: controles_arqueos; Owner: postgres
--

ALTER TABLE ONLY arq_ven_dep_cat
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario) REFERENCES public.tbusuario(cedula);


--
-- Name: fk_usuario; Type: FK CONSTRAINT; Schema: controles_arqueos; Owner: postgres
--

ALTER TABLE ONLY arqueo_categoria
    ADD CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES public.tbusuario(cedula);


SET search_path = dependencias, pg_catalog;

--
-- Name: fk_iddependencia; Type: FK CONSTRAINT; Schema: dependencias; Owner: postgres
--

ALTER TABLE ONLY item_dependencia
    ADD CONSTRAINT fk_iddependencia FOREIGN KEY (id_dependencia) REFERENCES dependencia(id_dependencia);


SET search_path = inventario, pg_catalog;

--
-- Name: fk_especificacion_categoria; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY especificacion_tiquete_prepago
    ADD CONSTRAINT fk_especificacion_categoria FOREIGN KEY (cat_id) REFERENCES categoria(cat_id);


--
-- Name: fk_especificacion_eje_adicional; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY especificacion_tiquete_prepago
    ADD CONSTRAINT fk_especificacion_eje_adicional FOREIGN KEY (tea_id) REFERENCES tipo_eje_adicional(tea_id);


--
-- Name: fk_idanulacion; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY detalle_anulacion_tiquetes
    ADD CONSTRAINT fk_idanulacion FOREIGN KEY (id_anulacion) REFERENCES anulacion_tiquetes(id_anulacion_tiquete);


--
-- Name: fk_tipo_anulacion; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY detalle_anulacion_tiquetes
    ADD CONSTRAINT fk_tipo_anulacion FOREIGN KEY (id_tipo) REFERENCES tipo_anulacion(id);


--
-- Name: fk_usuario; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY consecutivos
    ADD CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES public.tbusuario(cedula);


SET search_path = public, pg_catalog;

--
-- Name: fk_iddepartamento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY municipio
    ADD CONSTRAINT fk_iddepartamento FOREIGN KEY (ciu_id_dep) REFERENCES departamento(dep_id);


SET search_path = ventas, pg_catalog;

--
-- Name: cambio_tiquete_id_usuario_fkey; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cambio_tiquete
    ADD CONSTRAINT cambio_tiquete_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.tbusuario(cedula);


--
-- Name: fk_cliesede; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY venta
    ADD CONSTRAINT fk_cliesede FOREIGN KEY (clie_sede) REFERENCES clientes.sedes_clientes(id_cliente_sede);


--
-- Name: fk_clinit; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY venta
    ADD CONSTRAINT fk_clinit FOREIGN KEY (cli_nit) REFERENCES clientes.cliente(cli_nit);


--
-- Name: fk_ctaban; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cancelacion_excedentes
    ADD CONSTRAINT fk_ctaban FOREIGN KEY (cban_id) REFERENCES cuenta_bancaria(cban_id);


--
-- Name: fk_ctaban; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cancelacion_excedente_dependencia
    ADD CONSTRAINT fk_ctaban FOREIGN KEY (cban_id) REFERENCES cuenta_bancaria(cban_id);


--
-- Name: fk_dependencia; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY validacion_tiquetes_dependencias
    ADD CONSTRAINT fk_dependencia FOREIGN KEY (id_dependencia) REFERENCES dependencias.item_dependencia(id_item_depen);


--
-- Name: fk_detalle_venta_especificacion_tiquete_prepago; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_venta
    ADD CONSTRAINT fk_detalle_venta_especificacion_tiquete_prepago FOREIGN KEY (etp_id) REFERENCES inventario.especificacion_tiquete_prepago(etp_id);


--
-- Name: fk_detalle_venta_venta; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_venta
    ADD CONSTRAINT fk_detalle_venta_venta FOREIGN KEY (ven_id) REFERENCES venta(ven_id);


--
-- Name: fk_devolucion; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_devolucion
    ADD CONSTRAINT fk_devolucion FOREIGN KEY (id_devolucion) REFERENCES devolucion_dinero(id_devolucion_dinero);


--
-- Name: fk_especificacion_tiquete; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_entregados
    ADD CONSTRAINT fk_especificacion_tiquete FOREIGN KEY (id_esp_tiquete) REFERENCES inventario.especificacion_tiquete_prepago(etp_id);


--
-- Name: fk_especificacion_tiquete; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_recibidos
    ADD CONSTRAINT fk_especificacion_tiquete FOREIGN KEY (id_especificacion_tiquete) REFERENCES inventario.especificacion_tiquete_prepago(etp_id);


--
-- Name: fk_etp; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_remision
    ADD CONSTRAINT fk_etp FOREIGN KEY (id_etp) REFERENCES inventario.especificacion_tiquete_prepago(etp_id);


--
-- Name: fk_etp; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_venta_dependencia
    ADD CONSTRAINT fk_etp FOREIGN KEY (etp) REFERENCES inventario.especificacion_tiquete_prepago(etp_id);


--
-- Name: fk_etp; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_validacion_dependencias
    ADD CONSTRAINT fk_etp FOREIGN KEY (id_etp) REFERENCES inventario.especificacion_tiquete_prepago(etp_id);


--
-- Name: fk_formaPago; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cancelacion_excedentes
    ADD CONSTRAINT "fk_formaPago" FOREIGN KEY (id_fp) REFERENCES forma_de_pago(fp_id);


--
-- Name: fk_fp; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY pago_ven_dep
    ADD CONSTRAINT fk_fp FOREIGN KEY (fp_ven_dep) REFERENCES forma_de_pago(fp_id);


--
-- Name: fk_id_dependencia; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cambio_tiquete_dependencias
    ADD CONSTRAINT fk_id_dependencia FOREIGN KEY (id_dependencia) REFERENCES dependencias.item_dependencia(id_item_depen);


--
-- Name: fk_id_etp; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_validacion
    ADD CONSTRAINT fk_id_etp FOREIGN KEY (id_etp) REFERENCES inventario.especificacion_tiquete_prepago(etp_id);


--
-- Name: fk_idacta; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_recibidos
    ADD CONSTRAINT fk_idacta FOREIGN KEY (id_actacambio) REFERENCES cambio_tiquete(id_acta_consecutivo);


--
-- Name: fk_idacta; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_entregados
    ADD CONSTRAINT fk_idacta FOREIGN KEY (id_actacambio) REFERENCES cambio_tiquete(id_acta_consecutivo);


--
-- Name: fk_idacta; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cancelacion_excedente_dependencia
    ADD CONSTRAINT fk_idacta FOREIGN KEY (id_acta_cambio) REFERENCES cambio_tiquete_dependencias(id_acta_consecutivo);


--
-- Name: fk_idacta; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_entregados_dependencia
    ADD CONSTRAINT fk_idacta FOREIGN KEY (id_actacambio) REFERENCES cambio_tiquete_dependencias(id_acta_consecutivo);


--
-- Name: fk_idacta; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_recibidos_dependencias
    ADD CONSTRAINT fk_idacta FOREIGN KEY (id_actacambio) REFERENCES cambio_tiquete_dependencias(id_acta_consecutivo);


--
-- Name: fk_idactaCambio; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cancelacion_excedentes
    ADD CONSTRAINT "fk_idactaCambio" FOREIGN KEY (id_acta_cambio) REFERENCES cambio_tiquete(id_acta_consecutivo);


--
-- Name: fk_idctaban; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY pago_validacion
    ADD CONSTRAINT fk_idctaban FOREIGN KEY (id_ctaban) REFERENCES cuenta_bancaria(cban_id);


--
-- Name: fk_idctaban; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY pago_validacion_depe
    ADD CONSTRAINT fk_idctaban FOREIGN KEY (id_ctaban) REFERENCES cuenta_bancaria(cban_id);


--
-- Name: fk_iddevolucion; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY consignacion
    ADD CONSTRAINT fk_iddevolucion FOREIGN KEY (id_devolucion) REFERENCES devolucion_dinero(id_devolucion_dinero);


--
-- Name: fk_identrega; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY deta_entrega_tiq_peaje
    ADD CONSTRAINT fk_identrega FOREIGN KEY (id_ent_tiq_pea) REFERENCES entrada_tiquetes_peajes(id_en_tiq);


--
-- Name: fk_idestacion; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY venta
    ADD CONSTRAINT fk_idestacion FOREIGN KEY (id_estacion) REFERENCES dependencias.peajes(codigo_peaje);


--
-- Name: fk_idetp; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_recibidos_dependencias
    ADD CONSTRAINT fk_idetp FOREIGN KEY (id_especificacion_tiquete) REFERENCES inventario.especificacion_tiquete_prepago(etp_id);


--
-- Name: fk_idetp; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_entregados_dependencia
    ADD CONSTRAINT fk_idetp FOREIGN KEY (id_esp_tiquete) REFERENCES inventario.especificacion_tiquete_prepago(etp_id);


--
-- Name: fk_idetp; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_devolucion
    ADD CONSTRAINT fk_idetp FOREIGN KEY (id_etp) REFERENCES inventario.especificacion_tiquete_prepago(etp_id);


--
-- Name: fk_idfp; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY pago_validacion
    ADD CONSTRAINT fk_idfp FOREIGN KEY (id_fp) REFERENCES forma_de_pago(fp_id);


--
-- Name: fk_idfp; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cancelacion_excedente_dependencia
    ADD CONSTRAINT fk_idfp FOREIGN KEY (id_fp) REFERENCES forma_de_pago(fp_id);


--
-- Name: fk_idfp; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY pago_validacion_depe
    ADD CONSTRAINT fk_idfp FOREIGN KEY (id_fp) REFERENCES forma_de_pago(fp_id);


--
-- Name: fk_idpeaje; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY remision_peaje
    ADD CONSTRAINT fk_idpeaje FOREIGN KEY (id_peaje) REFERENCES dependencias.peajes(codigo_peaje);


--
-- Name: fk_idpeaje; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY entrada_tiquetes_peajes
    ADD CONSTRAINT fk_idpeaje FOREIGN KEY (id_peaje) REFERENCES dependencias.peajes(codigo_peaje);


--
-- Name: fk_idremision; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_remision
    ADD CONSTRAINT fk_idremision FOREIGN KEY (id_remision) REFERENCES remision_peaje(id_remision_peaje);


--
-- Name: fk_idsede; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY validacion_tiquetes
    ADD CONSTRAINT fk_idsede FOREIGN KEY (id_sede_cliente) REFERENCES clientes.sedes_clientes(id_cliente_sede);


--
-- Name: fk_idsedecliente; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cambio_tiquete
    ADD CONSTRAINT fk_idsedecliente FOREIGN KEY (clie_sede) REFERENCES clientes.sedes_clientes(id_cliente_sede);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY venta_dependencia
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario) REFERENCES public.tbusuario(cedula);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY validacion_tiquetes
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario) REFERENCES public.tbusuario(cedula);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY cambio_tiquete_dependencias
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario) REFERENCES public.tbusuario(cedula);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY validacion_tiquetes_dependencias
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario) REFERENCES public.tbusuario(cedula);


--
-- Name: fk_idusuario; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY devolucion_dinero
    ADD CONSTRAINT fk_idusuario FOREIGN KEY (id_usuario) REFERENCES public.tbusuario(cedula);


--
-- Name: fk_idvalidacion; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_validacion
    ADD CONSTRAINT fk_idvalidacion FOREIGN KEY (id_validacion) REFERENCES validacion_tiquetes(id_revalidacion);


--
-- Name: fk_idvalidacion; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY pago_validacion
    ADD CONSTRAINT fk_idvalidacion FOREIGN KEY (id_validacion) REFERENCES validacion_tiquetes(id_revalidacion);


--
-- Name: fk_idvalidacion; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY pago_validacion_depe
    ADD CONSTRAINT fk_idvalidacion FOREIGN KEY (id_validacion) REFERENCES validacion_tiquetes_dependencias(id_validacion);


--
-- Name: fk_item_dep; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY venta_dependencia
    ADD CONSTRAINT fk_item_dep FOREIGN KEY (item_dependecia) REFERENCES dependencias.item_dependencia(id_item_depen);


--
-- Name: fk_pago_cuenta_bancaria; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY pago
    ADD CONSTRAINT fk_pago_cuenta_bancaria FOREIGN KEY (cban_id) REFERENCES cuenta_bancaria(cban_id);


--
-- Name: fk_pago_venta; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY pago
    ADD CONSTRAINT fk_pago_venta FOREIGN KEY (ven_id) REFERENCES venta(ven_id);


--
-- Name: fk_sede_cliente; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY devolucion_dinero
    ADD CONSTRAINT fk_sede_cliente FOREIGN KEY (id_sede_cliente) REFERENCES clientes.sedes_clientes(id_cliente_sede);


--
-- Name: fk_validacion; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_validacion_dependencias
    ADD CONSTRAINT fk_validacion FOREIGN KEY (id_validacion) REFERENCES validacion_tiquetes_dependencias(id_validacion);


--
-- Name: fk_ven_dep; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY detalle_venta_dependencia
    ADD CONSTRAINT fk_ven_dep FOREIGN KEY (ven_dep_id) REFERENCES venta_dependencia(ven_dep_id);


--
-- Name: fk_ven_dep; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY pago_ven_dep
    ADD CONSTRAINT fk_ven_dep FOREIGN KEY (ven_dep_id) REFERENCES venta_dependencia(ven_dep_id);


--
-- Name: fkidetp; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY deta_entrega_tiq_peaje
    ADD CONSTRAINT fkidetp FOREIGN KEY (id_etp) REFERENCES inventario.especificacion_tiquete_prepago(etp_id);


--
-- Name: id_usuario; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY remision_peaje
    ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario) REFERENCES public.tbusuario(cedula);


--
-- Name: id_usuario; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY entrada_tiquetes_peajes
    ADD CONSTRAINT id_usuario FOREIGN KEY (id_usuario) REFERENCES public.tbusuario(cedula);


--
-- Name: venta_id_usuario_fkey; Type: FK CONSTRAINT; Schema: ventas; Owner: postgres
--

ALTER TABLE ONLY venta
    ADD CONSTRAINT venta_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.tbusuario(cedula);


--
-- Name: clientes; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA clientes FROM PUBLIC;
REVOKE ALL ON SCHEMA clientes FROM postgres;
GRANT ALL ON SCHEMA clientes TO postgres;
GRANT ALL ON SCHEMA clientes TO PUBLIC;


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- Name: ventas; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA ventas FROM PUBLIC;
REVOKE ALL ON SCHEMA ventas FROM postgres;
GRANT ALL ON SCHEMA ventas TO postgres;


SET search_path = clientes, pg_catalog;

--
-- Name: cliente; Type: ACL; Schema: clientes; Owner: postgres
--

REVOKE ALL ON TABLE cliente FROM PUBLIC;
REVOKE ALL ON TABLE cliente FROM postgres;
GRANT ALL ON TABLE cliente TO PUBLIC;


--
-- Name: sedes_clientes; Type: ACL; Schema: clientes; Owner: postgres
--

REVOKE ALL ON TABLE sedes_clientes FROM PUBLIC;
REVOKE ALL ON TABLE sedes_clientes FROM postgres;
GRANT ALL ON TABLE sedes_clientes TO postgres;
GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE sedes_clientes TO PUBLIC;


--
-- Name: sedes_clientes_id_cliente_sede_seq; Type: ACL; Schema: clientes; Owner: postgres
--

REVOKE ALL ON SEQUENCE sedes_clientes_id_cliente_sede_seq FROM PUBLIC;
REVOKE ALL ON SEQUENCE sedes_clientes_id_cliente_sede_seq FROM postgres;
GRANT ALL ON SEQUENCE sedes_clientes_id_cliente_sede_seq TO postgres;
GRANT ALL ON SEQUENCE sedes_clientes_id_cliente_sede_seq TO PUBLIC;


SET search_path = public, pg_catalog;

--
-- Name: tbusuario; Type: ACL; Schema: public; Owner: postgres
--

REVOKE ALL ON TABLE tbusuario FROM PUBLIC;
REVOKE ALL ON TABLE tbusuario FROM postgres;
GRANT ALL ON TABLE tbusuario TO postgres;


SET search_path = ventas, pg_catalog;

--
-- Name: cambio_tiquete; Type: ACL; Schema: ventas; Owner: postgres
--

REVOKE ALL ON TABLE cambio_tiquete FROM PUBLIC;
REVOKE ALL ON TABLE cambio_tiquete FROM postgres;
GRANT ALL ON TABLE cambio_tiquete TO postgres;


SET search_path = clientes, pg_catalog;

--
-- Name: DEFAULT PRIVILEGES FOR SEQUENCES; Type: DEFAULT ACL; Schema: clientes; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA clientes REVOKE ALL ON SEQUENCES  FROM PUBLIC;
ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA clientes REVOKE ALL ON SEQUENCES  FROM postgres;
ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA clientes GRANT ALL ON SEQUENCES  TO PUBLIC;


--
-- Name: DEFAULT PRIVILEGES FOR FUNCTIONS; Type: DEFAULT ACL; Schema: clientes; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA clientes REVOKE ALL ON FUNCTIONS  FROM PUBLIC;
ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA clientes REVOKE ALL ON FUNCTIONS  FROM postgres;
ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA clientes GRANT ALL ON FUNCTIONS  TO PUBLIC;


--
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: clientes; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA clientes REVOKE ALL ON TABLES  FROM PUBLIC;
ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA clientes REVOKE ALL ON TABLES  FROM postgres;
ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA clientes GRANT SELECT,INSERT,DELETE,UPDATE ON TABLES  TO PUBLIC;


--
-- PostgreSQL database dump complete
--

