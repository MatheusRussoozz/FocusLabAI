CREATE TABLE subject (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL ,
    description VARCHAR(255) NOT NULL ,
    weekly_goal VARCHAR(255) NOT NULL


);

CREATE TABLE study_session (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    subject_id BIGINT NOT NULL,
    FOREIGN KEY (subject_id) REFERENCES subject(id),
    date TIMESTAMP NOT NULL ,
    minutes INTEGER NOT NULL ,
    notes VARCHAR(255) NOT NULL

);