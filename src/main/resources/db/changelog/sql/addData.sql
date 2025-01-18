INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Athens Kallithea-Volos',to_date('18/01/2025','DD/MM/YYYY'),
     to_timestamp('12:00','HH24:MI'), 'Athens Kallithea', 'Volos', 1);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',2.3),
    (currval('match_id_seq'),'X',3.07),
    (currval('match_id_seq'),'2',3.2);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Atromitos-Olympiacos Piraeus',to_date('19/01/2025','DD/MM/YYYY'),
     to_timestamp('15:00','HH24:MI'), 'Atromitos', 'Olympiacos Piraeus', 1);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',6.51),
    (currval('match_id_seq'),'X',3.88),
    (currval('match_id_seq'),'2',1.51);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Levadiakos-Asteras Tripolis',to_date('19/01/2025','DD/MM/YYYY'),
     to_timestamp('16:30','HH24:MI'), 'Levadiakos', 'Asteras Tripolis', 1);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',2.44),
    (currval('match_id_seq'),'X',2.99),
    (currval('match_id_seq'),'2',3.05);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Panetolikos-OFI Crete',to_date('19/01/2025','DD/MM/YYYY'),
     to_timestamp('16:30','HH24:MI'), 'Panetolikos', 'OFI Crete', 1);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',2.38),
    (currval('match_id_seq'),'X',3.14),
    (currval('match_id_seq'),'2',3);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Aris-PAOK',to_date('19/01/2025','DD/MM/YYYY'),
     to_timestamp('19:00','HH24:MI'), 'Aris', 'PAOK', 1);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',3.46),
    (currval('match_id_seq'),'X',3.26),
    (currval('match_id_seq'),'2',2.08);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Panathinaikos-AEK Athens FC',to_date('19/01/2025','DD/MM/YYYY'),
     to_timestamp('20:30','HH24:MI'), 'Panathinaikos', 'AEK Athens FC', 1);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',2.57),
    (currval('match_id_seq'),'X',3.23),
    (currval('match_id_seq'),'2',2.70);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Panserraikos-Lamia',to_date('20/01/2025','DD/MM/YYYY'),
     to_timestamp('18:00','HH24:MI'), 'Panserraikos', 'Lamia', 1);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',1.95),
    (currval('match_id_seq'),'X',3.25),
    (currval('match_id_seq'),'2',3.98);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Volos-Atromitos',to_date('24/01/2025','DD/MM/YYYY'),
     to_timestamp('20:00','HH24:MI'), 'Volos', 'Atromitos', 1);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',2.95),
    (currval('match_id_seq'),'X',3.2),
    (currval('match_id_seq'),'2',2.39);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Asteras Tripolis-Athens Kallithea',to_date('25/01/2025','DD/MM/YYYY'),
     to_timestamp('17:00','HH24:MI'), 'Asteras Tripolis', 'Athens Kallithea', 1);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',1.83),
    (currval('match_id_seq'),'X',3.25),
    (currval('match_id_seq'),'2',4.63);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('OFI Crete-Panserraikos',to_date('25/01/2025','DD/MM/YYYY'),
     to_timestamp('17:00','HH24:MI'), 'OFI Crete', 'Panserraikos', 1);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',1.88),
    (currval('match_id_seq'),'X',3.36),
    (currval('match_id_seq'),'2',4.12);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('AEK Athens FC-Panetolikos',to_date('25/01/2025','DD/MM/YYYY'),
     to_timestamp('20:00','HH24:MI'), 'AEK Athens FC', 'Panetolikos', 1);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',1.19),
    (currval('match_id_seq'),'X',6),
    (currval('match_id_seq'),'2',14.13);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Lamia-Aris',to_date('26/01/2025','DD/MM/YYYY'),
     to_timestamp('17:00','HH24:MI'), 'Lamia', 'Aris', 1);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',4.27),
    (currval('match_id_seq'),'X',3.18),
    (currval('match_id_seq'),'2',1.90);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('PAOK-Levadiakos',to_date('26/01/2025','DD/MM/YYYY'),
     to_timestamp('19:30','HH24:MI'), 'PAOK', 'Levadiakos', 1);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',1.3),
    (currval('match_id_seq'),'X',4.83),
    (currval('match_id_seq'),'2',10.25);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Olympiacos Piraeus-Panathinaikos',to_date('26/01/2025','DD/MM/YYYY'),
     to_timestamp('20:30','HH24:MI'), 'Olympiacos Piraeus', 'Panathinaikos', 1);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',2.03),
    (currval('match_id_seq'),'X',3.15),
    (currval('match_id_seq'),'2',3.9);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Aris-Kolossos Rhodes',to_date('18/01/2025','DD/MM/YYYY'),
     to_timestamp('17:00','HH24:MI'), 'Aris', 'Kolossos Rhodes', 2);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',1.36),
    (currval('match_id_seq'),'2',3.1),
    (currval('match_id_seq'),'B''s',9);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Lavrio-Peristeri',to_date('18/01/2025','DD/MM/YYYY'),
     to_timestamp('18:00','HH24:MI'), 'Lavrio', 'Peristeri', 2);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',1.77),
    (currval('match_id_seq'),'2',2.02),
    (currval('match_id_seq'),'B''s',8);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Maroussi-Panionios',to_date('18/01/2025','DD/MM/YYYY'),
     to_timestamp('20:15','HH24:MI'), 'Maroussi', 'Panionios', 2);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',1.66),
    (currval('match_id_seq'),'2',2.19),
    (currval('match_id_seq'),'B''s',8);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('AEK Athens-PAOK',to_date('19/01/2025','DD/MM/YYYY'),
     to_timestamp('17:15','HH24:MI'), 'AEK Athens', 'PAOK', 2);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',1.28),
    (currval('match_id_seq'),'2',3.52),
    (currval('match_id_seq'),'B''s',8);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('AS Karditsas-Promitheas',to_date('19/01/2025','DD/MM/YYYY'),
     to_timestamp('20:15','HH24:MI'), 'AS Karditsas', 'Promitheas', 2);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',1.81),
    (currval('match_id_seq'),'2',1.93),
    (currval('match_id_seq'),'B''s',8);

INSERT INTO match (description, match_date, match_time, team_a, team_b, sport)
VALUES
    ('Panathinaikos-Olympiacos',to_date('20/01/2025','DD/MM/YYYY'),
     to_timestamp('20:15','HH24:MI'), 'Panathinaikos', 'Olympiacos', 2);
INSERT INTO match_odds (match_id, specifier, odd)
VALUES
    (currval('match_id_seq'),'1',1.61),
    (currval('match_id_seq'),'2',2.22),
    (currval('match_id_seq'),'B''s',6);