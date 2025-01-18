CREATE TABLE problem_detail
(
    id         BIGINT AUTO_INCREMENT NOT NULL COMMENT '문제 선택지 ID',
    problem_id BIGINT                NOT NULL COMMENT '문제 ID',
    title      VARCHAR(255)          NULL COMMENT '문제 제목',
    options    VARCHAR(255)          NULL COMMENT '문제 선택지, 주관식인경우 NULL',
    PRIMARY KEY (id),
    CONSTRAINT uc_problem_id UNIQUE KEY (problem_id)
)
    COMMENT ='문제 선택지'
    COLLATE = UTF8MB4_UNICODE_CI;

INSERT INTO problem_detail (problem_id, title, options)
VALUES (1001, '원주율계산 공식으로 옳은 것은', '{
  "1": "Option 1 for problem 1001",
  "2": "Option 2 for problem 1001",
  "3": "Option 3 for problem 1001",
  "4": "Option 4 for problem 1001"
}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1002, '삼각형 높이를 구하는 공식을 고르시오', '{
  "1": "Option 1 for problem 1002",
  "2": "Option 2 for problem 1002",
  "3": "Option 3 for problem 1002",
  "4": "Option 4 for problem 1002"
}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1003, '원의 넓이를 구하는 공식을 고르시오', '{
  "1": "Option 1 for problem 1003",
  "2": "Option 2 for problem 1003",
  "3": "Option 3 for problem 1003",
  "4": "Option 4 for problem 1003"
}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1004, '원뿔의 넓이를 구하는 공식을 고르시오', '{
  "1": "Option 1 for problem 1004",
  "2": "Option 2 for problem 1004",
  "3": "Option 3 for problem 1004",
  "4": "Option 4 for problem 1004"
}');