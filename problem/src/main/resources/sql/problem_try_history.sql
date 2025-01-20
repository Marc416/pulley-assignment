CREATE TABLE problem_try_history
(
    id           BIGINT AUTO_INCREMENT NOT NULL COMMENT '인덱싱 컬럼',
    problem_id   BIGINT                NOT NULL COMMENT '문제지 아이디',
    student_id   BIGINT                NOT NULL COMMENT '학생 아이디',
    is_correct   BOOLEAN               NOT NULL COMMENT '정답여부',
    ever_correct BOOLEAN               NOT NULL COMMENT '한번이라도 정답을 맞춘경우',
    created_at   DATETIME              NOT NULL COMMENT '생성일',
    PRIMARY KEY (id)
)
    COMMENT ='문제풀이 히스토리'
    COLLATE = UTF8MB4_UNICODE_CI;