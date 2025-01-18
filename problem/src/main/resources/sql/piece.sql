CREATE TABLE piece
(
    id           BIGINT AUTO_INCREMENT NOT NULL COMMENT '인덱싱 컬럼',
    title        VARCHAR(100)          NOT NULL COMMENT '문제지 제목',
    problem_list VARCHAR(100)          NOT NULL COMMENT '문제 아이디',
    teacher_id   BIGINT                NOT NULL COMMENT '선생님 id',
    created_at   DATETIME              NOT NULL COMMENT '생성일',
    updated_at   DATETIME              NULL COMMENT '수정일',
    deleted_at   DATETIME              NULL COMMENT '삭제일',
    PRIMARY KEY (id)
)
    COMMENT ='시험지'
    COLLATE = UTF8MB4_UNICODE_CI;

INSERT INTO piece
VALUES (1, '2학년기말고사 수학 특강 문제지', '1001,1002,1003,1004', 1, '2025-01-18 09:04:40.11134', null, null);
INSERT INTO piece
VALUES (2, '3학년중간고사 국어 문제지', '1003,1004,1005,1006', 1, '2025-01-17 09:04:40.11134', null, null);
INSERT INTO piece
VALUES (3, '2학년기 학력고사 문제지', '1021,1022,1023,1024', 1, '2025-01-16 09:04:40.11134', null, null);
INSERT INTO piece
VALUES (4, '3학년 수능 특강 문제지', '1031,1032,1033,1034', 1, '2025-01-15 09:04:40.11134', null, null);