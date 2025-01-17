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
