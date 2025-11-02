create SCHEMA if not exists Task;

create table if not exists tasks (
                                    id serial primary key,
                                    creator_id BIGINT not null,
                                    assigneed_id BIGINT,
                                    task_status VARCHAR(50),
                                    created TIMESTAMP,
                                    deadline_date TIMESTAMP,
                                    priority VARCHAR(50)
);

