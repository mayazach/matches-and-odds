CREATE SEQUENCE IF NOT EXISTS match_id_seq;
CREATE TABLE IF NOT EXISTS match (
    id BIGINT PRIMARY KEY DEFAULT nextval('match_id_seq'),
    description VARCHAR(255),
    match_date DATE,
    match_time TIME,
    team_a VARCHAR(255),
    team_b VARCHAR(255),
    sport SMALLINT CHECK ( sport BETWEEN 0 AND 1)
);

CREATE SEQUENCE IF NOT EXISTS match_odds_id_seq;
CREATE TABLE IF NOT EXISTS match_odds (
    id BIGINT PRIMARY KEY DEFAULT nextval('match_odds_id_seq'),
    match_id BIGINT REFERENCES match(id) ON UPDATE CASCADE ON DELETE CASCADE NOT NULL,
    specifier VARCHAR(10),
    odd NUMERIC(4,2)
);