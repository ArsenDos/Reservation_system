create SCHEMA if not exists reservation;

create table if not exists reservation.task (
                                    id serial primary key,
                                    creator_id BIGINT not null,
                                    assigneed_id BIGINT,
                                    task_status VARCHAR(50),
                                    created TIMESTAMP,
                                    deadline_date TIMESTAMP,
                                    priority VARCHAR(50)
);

