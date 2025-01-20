CREATE TABLE piece_present_to_student
(
    id         BIGINT AUTO_INCREMENT NOT NULL COMMENT '인덱싱 컬럼',
    piece_id   BIGINT                NOT NULL COMMENT '문제지 아이디',
    student_id BIGINT                NOT NULL COMMENT '학생 아이디',
    teacher_id BIGINT                NOT NULL COMMENT '선생님 아이디',
    created_at DATETIME              NOT NULL COMMENT '생성일',
    deleted_at DATETIME              NULL COMMENT '삭제일',
    PRIMARY KEY (id)
)
    COMMENT ='학생에게 제출한 시험지'
    COLLATE = UTF8MB4_UNICODE_CI;


INSERT INTO piece_present_to_student
VALUES (1, 1, 1, 1, '2025-01-18 09:04:40.11134', null);
INSERT INTO piece_present_to_student
VALUES (2, 2, 1, 1, '2025-01-18 09:04:40.11134', null);
INSERT INTO piece_present_to_student
VALUES (3, 2, 2, 1, '2025-01-18 09:04:40.11134', null);
INSERT INTO piece_present_to_student
VALUES (4, 1, 2, 1, '2025-01-18 09:04:40.11134', null);
