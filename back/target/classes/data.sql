--------------------------------------------------
-- DONNEES DE TEST
--------------------------------------------------
USE xpr;

declare @LASTID INTEGER

INSERT INTO authorisations ("authName") VALUES ('lecture_colis');
INSERT INTO authorisations ("authName") VALUES ('modification_colis');

INSERT INTO authorisations ("authName") VALUES ('lecture_facture');
INSERT INTO authorisations ("authName") VALUES ('modification_facture');

INSERT INTO authorisations ("authName") VALUES ('lecture_bl');
INSERT INTO authorisations ("authName") VALUES ('modification_bl');

INSERT INTO authorisations ("authName") VALUES ('lecture_expedition');
INSERT INTO authorisations ("authName") VALUES ('modification_expedition');

INSERT INTO authorisations ("authName") VALUES ('lecture_livreurs');
INSERT INTO authorisations ("authName") VALUES ('modification_livreurs');

INSERT INTO authorisations ("authName") VALUES ('lecture_demande');
INSERT INTO authorisations ("authName") VALUES ('modification_demande');
