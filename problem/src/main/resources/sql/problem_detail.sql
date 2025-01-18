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

INSERT INTO problem_detail (problem_id, title, options)
VALUES (1005, '문제제목1005',
        '{"1": "Option 1 for problem 1005", "2": "Option 2 for problem 1005", "3": "Option 3 for problem 1005", "4": "Option 4 for problem 1005"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1006, '문제제목1006',
        '{"1": "Option 1 for problem 1006", "2": "Option 2 for problem 1006", "3": "Option 3 for problem 1006", "4": "Option 4 for problem 1006"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1007, '문제제목1007',
        '{"1": "Option 1 for problem 1007", "2": "Option 2 for problem 1007", "3": "Option 3 for problem 1007", "4": "Option 4 for problem 1007"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1008, '문제제목1008',
        '{"1": "Option 1 for problem 1008", "2": "Option 2 for problem 1008", "3": "Option 3 for problem 1008", "4": "Option 4 for problem 1008"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1009, '문제제목1009',
        '{"1": "Option 1 for problem 1009", "2": "Option 2 for problem 1009", "3": "Option 3 for problem 1009", "4": "Option 4 for problem 1009"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1013, '문제제목1013',
        '{"1": "Option 1 for problem 1013", "2": "Option 2 for problem 1013", "3": "Option 3 for problem 1013", "4": "Option 4 for problem 1013"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1014, '문제제목1014',
        '{"1": "Option 1 for problem 1014", "2": "Option 2 for problem 1014", "3": "Option 3 for problem 1014", "4": "Option 4 for problem 1014"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1016, '문제제목1016',
        '{"1": "Option 1 for problem 1016", "2": "Option 2 for problem 1016", "3": "Option 3 for problem 1016", "4": "Option 4 for problem 1016"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1017, '문제제목1017',
        '{"1": "Option 1 for problem 1017", "2": "Option 2 for problem 1017", "3": "Option 3 for problem 1017", "4": "Option 4 for problem 1017"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1018, '문제제목1018',
        '{"1": "Option 1 for problem 1018", "2": "Option 2 for problem 1018", "3": "Option 3 for problem 1018", "4": "Option 4 for problem 1018"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1021, '문제제목1021',
        '{"1": "Option 1 for problem 1021", "2": "Option 2 for problem 1021", "3": "Option 3 for problem 1021", "4": "Option 4 for problem 1021"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1022, '문제제목1022',
        '{"1": "Option 1 for problem 1022", "2": "Option 2 for problem 1022", "3": "Option 3 for problem 1022", "4": "Option 4 for problem 1022"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1023, '문제제목1023',
        '{"1": "Option 1 for problem 1023", "2": "Option 2 for problem 1023", "3": "Option 3 for problem 1023", "4": "Option 4 for problem 1023"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1024, '문제제목1024',
        '{"1": "Option 1 for problem 1024", "2": "Option 2 for problem 1024", "3": "Option 3 for problem 1024", "4": "Option 4 for problem 1024"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1031, '문제제목1031',
        '{"1": "Option 1 for problem 1031", "2": "Option 2 for problem 1031", "3": "Option 3 for problem 1031", "4": "Option 4 for problem 1031"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1032, '문제제목1032',
        '{"1": "Option 1 for problem 1032", "2": "Option 2 for problem 1032", "3": "Option 3 for problem 1032", "4": "Option 4 for problem 1032"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1033, '문제제목1033',
        '{"1": "Option 1 for problem 1033", "2": "Option 2 for problem 1033", "3": "Option 3 for problem 1033", "4": "Option 4 for problem 1033"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1034, '문제제목1034',
        '{"1": "Option 1 for problem 1034", "2": "Option 2 for problem 1034", "3": "Option 3 for problem 1034", "4": "Option 4 for problem 1034"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1036, '문제제목1036',
        '{"1": "Option 1 for problem 1036", "2": "Option 2 for problem 1036", "3": "Option 3 for problem 1036", "4": "Option 4 for problem 1036"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1037, '문제제목1037',
        '{"1": "Option 1 for problem 1037", "2": "Option 2 for problem 1037", "3": "Option 3 for problem 1037", "4": "Option 4 for problem 1037"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1038, '문제제목1038',
        '{"1": "Option 1 for problem 1038", "2": "Option 2 for problem 1038", "3": "Option 3 for problem 1038", "4": "Option 4 for problem 1038"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1046, '문제제목1046',
        '{"1": "Option 1 for problem 1046", "2": "Option 2 for problem 1046", "3": "Option 3 for problem 1046", "4": "Option 4 for problem 1046"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1047, '문제제목1047',
        '{"1": "Option 1 for problem 1047", "2": "Option 2 for problem 1047", "3": "Option 3 for problem 1047", "4": "Option 4 for problem 1047"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1048, '문제제목1048',
        '{"1": "Option 1 for problem 1048", "2": "Option 2 for problem 1048", "3": "Option 3 for problem 1048", "4": "Option 4 for problem 1048"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1051, '문제제목1051',
        '{"1": "Option 1 for problem 1051", "2": "Option 2 for problem 1051", "3": "Option 3 for problem 1051", "4": "Option 4 for problem 1051"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1052, '문제제목1052',
        '{"1": "Option 1 for problem 1052", "2": "Option 2 for problem 1052", "3": "Option 3 for problem 1052", "4": "Option 4 for problem 1052"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1053, '문제제목1053',
        '{"1": "Option 1 for problem 1053", "2": "Option 2 for problem 1053", "3": "Option 3 for problem 1053", "4": "Option 4 for problem 1053"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1056, '문제제목1056',
        '{"1": "Option 1 for problem 1056", "2": "Option 2 for problem 1056", "3": "Option 3 for problem 1056", "4": "Option 4 for problem 1056"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1057, '문제제목1057',
        '{"1": "Option 1 for problem 1057", "2": "Option 2 for problem 1057", "3": "Option 3 for problem 1057", "4": "Option 4 for problem 1057"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1058, '문제제목1058',
        '{"1": "Option 1 for problem 1058", "2": "Option 2 for problem 1058", "3": "Option 3 for problem 1058", "4": "Option 4 for problem 1058"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1061, '문제제목1061',
        '{"1": "Option 1 for problem 1061", "2": "Option 2 for problem 1061", "3": "Option 3 for problem 1061", "4": "Option 4 for problem 1061"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1062, '문제제목1062',
        '{"1": "Option 1 for problem 1062", "2": "Option 2 for problem 1062", "3": "Option 3 for problem 1062", "4": "Option 4 for problem 1062"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1063, '문제제목1063',
        '{"1": "Option 1 for problem 1063", "2": "Option 2 for problem 1063", "3": "Option 3 for problem 1063", "4": "Option 4 for problem 1063"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1066, '문제제목1066',
        '{"1": "Option 1 for problem 1066", "2": "Option 2 for problem 1066", "3": "Option 3 for problem 1066", "4": "Option 4 for problem 1066"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1067, '문제제목1067',
        '{"1": "Option 1 for problem 1067", "2": "Option 2 for problem 1067", "3": "Option 3 for problem 1067", "4": "Option 4 for problem 1067"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1068, '문제제목1068',
        '{"1": "Option 1 for problem 1068", "2": "Option 2 for problem 1068", "3": "Option 3 for problem 1068", "4": "Option 4 for problem 1068"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1071, '문제제목1071',
        '{"1": "Option 1 for problem 1071", "2": "Option 2 for problem 1071", "3": "Option 3 for problem 1071", "4": "Option 4 for problem 1071"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1072, '문제제목1072',
        '{"1": "Option 1 for problem 1072", "2": "Option 2 for problem 1072", "3": "Option 3 for problem 1072", "4": "Option 4 for problem 1072"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1073, '문제제목1073',
        '{"1": "Option 1 for problem 1073", "2": "Option 2 for problem 1073", "3": "Option 3 for problem 1073", "4": "Option 4 for problem 1073"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1074, '문제제목1074',
        '{"1": "Option 1 for problem 1074", "2": "Option 2 for problem 1074", "3": "Option 3 for problem 1074", "4": "Option 4 for problem 1074"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1076, '문제제목1076',
        '{"1": "Option 1 for problem 1076", "2": "Option 2 for problem 1076", "3": "Option 3 for problem 1076", "4": "Option 4 for problem 1076"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1077, '문제제목1077',
        '{"1": "Option 1 for problem 1077", "2": "Option 2 for problem 1077", "3": "Option 3 for problem 1077", "4": "Option 4 for problem 1077"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1078, '문제제목1078',
        '{"1": "Option 1 for problem 1078", "2": "Option 2 for problem 1078", "3": "Option 3 for problem 1078", "4": "Option 4 for problem 1078"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1081, '문제제목1081',
        '{"1": "Option 1 for problem 1081", "2": "Option 2 for problem 1081", "3": "Option 3 for problem 1081", "4": "Option 4 for problem 1081"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1082, '문제제목1082',
        '{"1": "Option 1 for problem 1082", "2": "Option 2 for problem 1082", "3": "Option 3 for problem 1082", "4": "Option 4 for problem 1082"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1083, '문제제목1083',
        '{"1": "Option 1 for problem 1083", "2": "Option 2 for problem 1083", "3": "Option 3 for problem 1083", "4": "Option 4 for problem 1083"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1086, '문제제목1086',
        '{"1": "Option 1 for problem 1086", "2": "Option 2 for problem 1086", "3": "Option 3 for problem 1086", "4": "Option 4 for problem 1086"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1087, '문제제목1087',
        '{"1": "Option 1 for problem 1087", "2": "Option 2 for problem 1087", "3": "Option 3 for problem 1087", "4": "Option 4 for problem 1087"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1088, '문제제목1088',
        '{"1": "Option 1 for problem 1088", "2": "Option 2 for problem 1088", "3": "Option 3 for problem 1088", "4": "Option 4 for problem 1088"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1091, '문제제목1091',
        '{"1": "Option 1 for problem 1091", "2": "Option 2 for problem 1091", "3": "Option 3 for problem 1091", "4": "Option 4 for problem 1091"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1092, '문제제목1092',
        '{"1": "Option 1 for problem 1092", "2": "Option 2 for problem 1092", "3": "Option 3 for problem 1092", "4": "Option 4 for problem 1092"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1093, '문제제목1093',
        '{"1": "Option 1 for problem 1093", "2": "Option 2 for problem 1093", "3": "Option 3 for problem 1093", "4": "Option 4 for problem 1093"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1096, '문제제목1096',
        '{"1": "Option 1 for problem 1096", "2": "Option 2 for problem 1096", "3": "Option 3 for problem 1096", "4": "Option 4 for problem 1096"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1097, '문제제목1097',
        '{"1": "Option 1 for problem 1097", "2": "Option 2 for problem 1097", "3": "Option 3 for problem 1097", "4": "Option 4 for problem 1097"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1098, '문제제목1098',
        '{"1": "Option 1 for problem 1098", "2": "Option 2 for problem 1098", "3": "Option 3 for problem 1098", "4": "Option 4 for problem 1098"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1111, '문제제목1111',
        '{"1": "Option 1 for problem 1111", "2": "Option 2 for problem 1111", "3": "Option 3 for problem 1111", "4": "Option 4 for problem 1111"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1112, '문제제목1112',
        '{"1": "Option 1 for problem 1112", "2": "Option 2 for problem 1112", "3": "Option 3 for problem 1112", "4": "Option 4 for problem 1112"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1113, '문제제목1113',
        '{"1": "Option 1 for problem 1113", "2": "Option 2 for problem 1113", "3": "Option 3 for problem 1113", "4": "Option 4 for problem 1113"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1116, '문제제목1116',
        '{"1": "Option 1 for problem 1116", "2": "Option 2 for problem 1116", "3": "Option 3 for problem 1116", "4": "Option 4 for problem 1116"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1117, '문제제목1117',
        '{"1": "Option 1 for problem 1117", "2": "Option 2 for problem 1117", "3": "Option 3 for problem 1117", "4": "Option 4 for problem 1117"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1118, '문제제목1118',
        '{"1": "Option 1 for problem 1118", "2": "Option 2 for problem 1118", "3": "Option 3 for problem 1118", "4": "Option 4 for problem 1118"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1121, '문제제목1121',
        '{"1": "Option 1 for problem 1121", "2": "Option 2 for problem 1121", "3": "Option 3 for problem 1121", "4": "Option 4 for problem 1121"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1122, '문제제목1122',
        '{"1": "Option 1 for problem 1122", "2": "Option 2 for problem 1122", "3": "Option 3 for problem 1122", "4": "Option 4 for problem 1122"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1123, '문제제목1123',
        '{"1": "Option 1 for problem 1123", "2": "Option 2 for problem 1123", "3": "Option 3 for problem 1123", "4": "Option 4 for problem 1123"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1126, '문제제목1126',
        '{"1": "Option 1 for problem 1126", "2": "Option 2 for problem 1126", "3": "Option 3 for problem 1126", "4": "Option 4 for problem 1126"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1127, '문제제목1127',
        '{"1": "Option 1 for problem 1127", "2": "Option 2 for problem 1127", "3": "Option 3 for problem 1127", "4": "Option 4 for problem 1127"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1128, '문제제목1128',
        '{"1": "Option 1 for problem 1128", "2": "Option 2 for problem 1128", "3": "Option 3 for problem 1128", "4": "Option 4 for problem 1128"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1136, '문제제목1136',
        '{"1": "Option 1 for problem 1136", "2": "Option 2 for problem 1136", "3": "Option 3 for problem 1136", "4": "Option 4 for problem 1136"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1137, '문제제목1137',
        '{"1": "Option 1 for problem 1137", "2": "Option 2 for problem 1137", "3": "Option 3 for problem 1137", "4": "Option 4 for problem 1137"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1138, '문제제목1138',
        '{"1": "Option 1 for problem 1138", "2": "Option 2 for problem 1138", "3": "Option 3 for problem 1138", "4": "Option 4 for problem 1138"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1141, '문제제목1141',
        '{"1": "Option 1 for problem 1141", "2": "Option 2 for problem 1141", "3": "Option 3 for problem 1141", "4": "Option 4 for problem 1141"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1142, '문제제목1142',
        '{"1": "Option 1 for problem 1142", "2": "Option 2 for problem 1142", "3": "Option 3 for problem 1142", "4": "Option 4 for problem 1142"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1143, '문제제목1143',
        '{"1": "Option 1 for problem 1143", "2": "Option 2 for problem 1143", "3": "Option 3 for problem 1143", "4": "Option 4 for problem 1143"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1146, '문제제목1146',
        '{"1": "Option 1 for problem 1146", "2": "Option 2 for problem 1146", "3": "Option 3 for problem 1146", "4": "Option 4 for problem 1146"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1147, '문제제목1147',
        '{"1": "Option 1 for problem 1147", "2": "Option 2 for problem 1147", "3": "Option 3 for problem 1147", "4": "Option 4 for problem 1147"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1148, '문제제목1148',
        '{"1": "Option 1 for problem 1148", "2": "Option 2 for problem 1148", "3": "Option 3 for problem 1148", "4": "Option 4 for problem 1148"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1151, '문제제목1151',
        '{"1": "Option 1 for problem 1151", "2": "Option 2 for problem 1151", "3": "Option 3 for problem 1151", "4": "Option 4 for problem 1151"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1152, '문제제목1152',
        '{"1": "Option 1 for problem 1152", "2": "Option 2 for problem 1152", "3": "Option 3 for problem 1152", "4": "Option 4 for problem 1152"}');
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1153, '문제제목1153', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1156, '문제제목1156', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1157, '문제제목1157', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1158, '문제제목1158', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1161, '문제제목1161', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1162, '문제제목1162', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1163, '문제제목1163', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1171, '문제제목1171', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1172, '문제제목1172', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1173, '문제제목1173', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1176, '문제제목1176', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1177, '문제제목1177', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1178, '문제제목1178', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1181, '문제제목1181', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1182, '문제제목1182', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1183, '문제제목1183', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1186, '문제제목1186', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1187, '문제제목1187', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1188, '문제제목1188', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1191, '문제제목1191', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1192, '문제제목1192', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1193, '문제제목1193', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1196, '문제제목1196', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1197, '문제제목1197', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1198, '문제제목1198', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1201, '문제제목1201', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1202, '문제제목1202', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1203, '문제제목1203', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1206, '문제제목1206', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1207, '문제제목1207', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1208, '문제제목1208', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1211, '문제제목1211', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1212, '문제제목1212', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1213, '문제제목1213', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1216, '문제제목1216', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1217, '문제제목1217', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1218, '문제제목1218', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1221, '문제제목1221', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1222, '문제제목1222', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1223, '문제제목1223', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1226, '문제제목1226', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1227, '문제제목1227', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1228, '문제제목1228', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1231, '문제제목1231', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1232, '문제제목1232', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1233, '문제제목1233', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1236, '문제제목1236', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1237, '문제제목1237', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1238, '문제제목1238', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1241, '문제제목1241', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1242, '문제제목1242', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1243, '문제제목1243', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1246, '문제제목1246', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1247, '문제제목1247', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1248, '문제제목1248', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1251, '문제제목1251', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1252, '문제제목1252', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1253, '문제제목1253', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1256, '문제제목1256', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1257, '문제제목1257', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1258, '문제제목1258', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1261, '문제제목1261', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1262, '문제제목1262', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1263, '문제제목1263', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1266, '문제제목1266', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1267, '문제제목1267', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1268, '문제제목1268', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1271, '문제제목1271', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1272, '문제제목1272', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1273, '문제제목1273', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1276, '문제제목1276', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1277, '문제제목1277', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1278, '문제제목1278', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1281, '문제제목1281', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1282, '문제제목1282', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1283, '문제제목1283', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1286, '문제제목1286', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1287, '문제제목1287', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1288, '문제제목1288', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1291, '문제제목1291', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1292, '문제제목1292', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1293, '문제제목1293', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1296, '문제제목1296', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1297, '문제제목1297', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1298, '문제제목1298', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1301, '문제제목1301', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1302, '문제제목1302', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1303, '문제제목1303', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1306, '문제제목1306', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1307, '문제제목1307', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1308, '문제제목1308', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1311, '문제제목1311', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1312, '문제제목1312', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1313, '문제제목1313', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1316, '문제제목1316', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1317, '문제제목1317', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1318, '문제제목1318', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1321, '문제제목1321', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1322, '문제제목1322', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1323, '문제제목1323', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1326, '문제제목1326', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1327, '문제제목1327', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1328, '문제제목1328', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1331, '문제제목1331', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1332, '문제제목1332', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1333, '문제제목1333', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1336, '문제제목1336', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1337, '문제제목1337', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1338, '문제제목1338', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1341, '문제제목1341', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1342, '문제제목1342', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1343, '문제제목1343', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1346, '문제제목1346', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1347, '문제제목1347', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1348, '문제제목1348', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1351, '문제제목1351', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1356, '문제제목1356', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1361, '문제제목1361', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1362, '문제제목1362', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1363, '문제제목1363', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1366, '문제제목1366', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1367, '문제제목1367', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1368, '문제제목1368', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1371, '문제제목1371', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1372, '문제제목1372', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1373, '문제제목1373', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1376, '문제제목1376', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1377, '문제제목1377', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1378, '문제제목1378', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1381, '문제제목1381', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1382, '문제제목1382', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1383, '문제제목1383', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1386, '문제제목1386', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1387, '문제제목1387', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1388, '문제제목1388', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1391, '문제제목1391', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1392, '문제제목1392', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1393, '문제제목1393', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1396, '문제제목1396', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1397, '문제제목1397', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1398, '문제제목1398', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1401, '문제제목1401', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1402, '문제제목1402', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1403, '문제제목1403', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1406, '문제제목1406', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1407, '문제제목1407', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1408, '문제제목1408', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1411, '문제제목1411', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1412, '문제제목1412', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1413, '문제제목1413', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1416, '문제제목1416', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1417, '문제제목1417', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1418, '문제제목1418', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1421, '문제제목1421', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1422, '문제제목1422', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1423, '문제제목1423', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1426, '문제제목1426', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1427, '문제제목1427', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1428, '문제제목1428', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1431, '문제제목1431', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1432, '문제제목1432', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1433, '문제제목1433', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1436, '문제제목1436', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1437, '문제제목1437', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1438, '문제제목1438', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1441, '문제제목1441', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1442, '문제제목1442', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1443, '문제제목1443', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1446, '문제제목1446', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1447, '문제제목1447', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1448, '문제제목1448', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1451, '문제제목1451', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1452, '문제제목1452', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1453, '문제제목1453', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1456, '문제제목1456', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1457, '문제제목1457', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1458, '문제제목1458', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1461, '문제제목1461', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1462, '문제제목1462', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1463, '문제제목1463', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1466, '문제제목1466', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1467, '문제제목1467', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1468, '문제제목1468', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1471, '문제제목1471', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1472, '문제제목1472', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1473, '문제제목1473', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1476, '문제제목1476', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1477, '문제제목1477', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1478, '문제제목1478', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1481, '문제제목1481', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1482, '문제제목1482', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1483, '문제제목1483', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1486, '문제제목1486', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1487, '문제제목1487', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1488, '문제제목1488', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1491, '문제제목1491', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1492, '문제제목1492', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1493, '문제제목1493', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1496, '문제제목1496', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1497, '문제제목1497', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1498, '문제제목1498', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1501, '문제제목1501', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1502, '문제제목1502', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1503, '문제제목1503', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1506, '문제제목1506', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1507, '문제제목1507', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1508, '문제제목1508', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1511, '문제제목1511', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1512, '문제제목1512', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1513, '문제제목1513', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1516, '문제제목1516', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1517, '문제제목1517', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1518, '문제제목1518', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1521, '문제제목1521', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1522, '문제제목1522', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1523, '문제제목1523', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1526, '문제제목1526', NULL);
INSERT INTO problem_detail (problem_id, title, options)
VALUES (1531, '문제제목1531',
        '{"1": "Option 1 for problem 1531", "2": "Option 2 for problem 1531", "3": "Option 3 for problem 1531", "4": "Option 4 for problem 1531"}');
