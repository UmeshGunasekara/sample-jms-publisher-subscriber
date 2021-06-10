DROP TABLE IF EXISTS sj_message;

CREATE TABLE sj_message (
    message_id INT NOT NULL AUTO_INCREMENT,
    message VARCHAR(250) NULL,
    message_type VARCHAR(20) NULL,
    message_status VARCHAR(20) NOT NULL,
    jms_destination VARCHAR(100) NOT NULL,
    create_date_time TIMESTAMP NOT NULL,
    update_date_time TIMESTAMP NOT NULL,
    PRIMARY KEY  (message_id)
);