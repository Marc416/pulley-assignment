CREATE TABLE piece_try_history
(
    id         BIGINT AUTO_INCREMENT NOT NULL COMMENT '인덱싱 컬럼',
    piece_id   BIGINT                NOT NULL COMMENT '문제지 아이디',
    student_id BIGINT                NOT NULL COMMENT '학생 아이디',
    score      Int                   NOT NULL COMMENT '점수',
    max_score  Int                   NOT NULL COMMENT '최고점수',
    created_at DATETIME              NOT NULL COMMENT '생성일',
    PRIMARY KEY (id)
)
    COMMENT ='시험지 시도 히스토리'
    COLLATE = UTF8MB4_UNICODE_CI;