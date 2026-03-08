CREATE TABLE DailyReport(
    id BIGSERIAL PRIMARY KEY,
    hdiary_user_id BIGINT REFERENCES HDiaryUsers(id) NOT NULL,
    creation_date DATE NOT NULL,
    note TEXT,
    mood VARCHAR(20) NOT NULL,
    energy VARCHAR(20) NOT NULL,
    sleep VARCHAR(20) NOT NULL,
    social VARCHAR(20) NOT NULL,
    focus VARCHAR(20) NOT NULL,
    physical VARCHAR(20) NOT NULL
 );