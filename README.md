```
선생님과 학생간의 햑습지 관련 서버를 만드는 과제입니다.
아래 기능적 요구 사항과 비기능적 요구 사항을 잘 확인하고 제출 부탁드립니다.
```

## 비기능적 요구사항

- 과제 진행은 개인 **github public repository** 생성하여 진행 해주시기 바랍니다.
- 데이터베이스는 **h2**를 사용해서 개발해주세요.
- 서버 호스트는 **localhost(127.0.0.1)**, 서버 포트는 **8080**으로 설정해주세요.
- 다른 사람이 **읽기 좋은 코드**로 개발해주세요.
- 개발 언어는 [Kotlin](https://kotlinlang.org/) 입니다.
- Spring Boot를 사용해서 개발해주세요.
    - [Spring Boot 2.x](https://spring.io/projects/spring-boot) 이상 버전을 사용해서 개발해주세요.
- **성능과 비용 측면**도 함께 고려해서 작성해주세요.
- api endpoint는 예시대로 작성하고 requestbody, response등은 자유롭게 작성해주시면 됩니다.

---

## 요구사항

- 유저는 선생님 혹은 학생입니다.
- 어떤 과목인지에 대해서는 고려하지 않으셔도 됩니다.
- 개발이 필요한 API 총 **6개**입니다.

- 과제 활용 데이터(문제, 유형 정보)  아래 엑셀파일을 다운받아 활용하세요
    
    [backend_recruit_data.xlsx](https://prod-files-secure.s3.us-west-2.amazonaws.com/0d5bf197-ab62-48c9-a91c-aa1a0f82358a/69ba1849-72f2-4a2f-9191-4cd4b87e2b05/backend_recruit_data.xlsx)
    
    problem : 문제
    
    unit_code: 유형정보
    
- 위 엑셀 파일의 데이터를 기반으로 과제를 풀어주시면 됩니다.
- 위의 파일의 데이터는 예시이고 직접 수정하거나 추가해서 과제를 해결하셔도 괜찮습니다.

---

### 1. `GET`  문제 조회

- 선생님은 총 문제 수, 유형코드 리스트, 난이도, 문제 유형(주관식, 객관식, 전체)을 조건으로 문제를 조회합니다.

**파라미터 설명**

- 총 문제수 (totalCount)
    - 총 문제 수는 최대 문제 수를 의미 하기도 합니다.
    - 아래 조건을 활용해서 만들 수 있는 문제의 수가 파라미터로 전달받은 총 문제 수보다 적다면 총 문제 수보다 적어도 괜찮습니다.
    - 아래 조건을 활용해서 만들 수 있는 문제의 수가 파라미터로 전달받은 총 문제 수보다 많다면 총 문제 수 만큼만 조회합니다.

- 유형 코드 리스트 (unitCodeList)
    - 파라미터로 전달받은 유형코드 리스트에서만 문제를 조회합니다.

- 문제 유형 (problemType)
    - 주관식, 객관식, 전체 총 3개 경우가 존재하며 전달받은 유형으로만 조회를 합니다.

- 난이도 (level)
    - 파라미터로 받을 수 있는 난이도에는 **상, 중, 하** 3가지가 존재합니다.
    - 문제에는 난이도가 1부터 5까지 존재하고 숫자가 클수록 어려운 문제입니다.
    - 난이도 1 인 문제 - 하
    - 난이도 2,3,4 인 문제 - 중
    - 난이도 5 인 인 문제 - 상
    - 난이도별 문제 비율은 아래와 같습니다. 전체 수는 파라미터로 받은 **총 문제 수**가 기준입니다.
    - 파라미터로 전달받은 총문제 수를 아래 비율로 나눌 수 없는 경우 자유롭게 구현하시면 됩니다.
- 상 선택시 : **하** 문제 20%, **중** 문제 30%, **상** 문제 50%
- 중 선택시 : **하** 문제 25%, **중** 문제 50%, **상** 문제 25%
- 하 선택시 : **하** 문제 50%, **중** 문제 30%, **상** 문제 20%

- 필터링 순서는 유형코드 리스트 → 문제 유형 → 난이도 로 해주시면 됩니다.

```markdown
REQUEST
ex ) http://localhost:8080/problems?totalCount=15&unitCodeList=a,b,c&level=HIGH&problemType=SELECTION

totalCount : 총문제 수
unitCodeList : 유형코드 리스트
level : 난이도 (LOW, MIDDLE, HIGH)
problemType: 주관식, 객관식, 전체 (ALL, SUBJECTIVE, SELECTION)

RESPONSE
{
	"problemList" : [
		{
			"id" : 1, 
			"answer" : "정답",
			"unitCode" : "유형코드",
			"level" : 1,  // (1~5)
			"problemType": "SELECTION", // SUBJECTIVE, SELECTION
		},
			{
			"id" : 2, 
			"answer" : "정답",
			"unitCode" : "유형코드",
			"level" : 1,  // (1~5)
			"problemType": "SELECTION", // SUBJECTIVE, SELECTION
		}
		...
	]
}**
```

### 2. `POST`  학습지 생성

- 선생님은 **1번에서 조회했던 문제 리스트**를 바탕으로 학습지를 생성합니다.
- 학습지 생성 시 포함될 수 있는 최대 문제 수는 50개 입니다.
- 학습지는 아래의 정보를 가지고 있습니다.
    - 학습지 이름
    - 만든 유저 정보

```
REQUEST
ex ) http://localhost:8080/piece

REQUESTBODY
{
	"pieceTitle":"pieceTitle",
	"problemListIds":[1,3,2,4]
}

RESPONSEBODY
{
	"result": "SUCCESS",
	"pieceId" :13
}

```

### 3. `POST`  학생에게 학습지 출제하기

- 선생님은 학생에게 **2번 문제에서 생성했던 학습지** **1개의 학습지**를 출제합니다.
- 선생님은 자신이 만든 학습지만 학생에게 출제가 가능합니다.
- 학습지는 **동시에 2명이상의 학생에게** 출제가 가능합니다.
- 이미 존재하는 학습지를 부여받는 경우 에러로 간주하지 않습니다.
- 만약 동시에 2명 이상의 학생에게 1개의 학습지를 출제하는데 이미 같은 학습지를 받은 경우가 있는 경우 이미 같은 학습지를 받은 학생을 제외하고 나머지 인원만 학습지를 받습니다.

```
REQUEST
ex ) http://localhost:8080/piece/{pieceId}?studentIds=1,2

REQUESTBODY
{

}

RESPONSEBODY
{
	"receivedStudents":[1,3],
	"existStudents":[4]
}

```

### 4. `GET` 학습지의 문제 조회하기

- 학생은 자신에게 출제된 학습지의 문제 목록을 확인할 수 있습니다.
- 학습지 1개에 대한 문제목록을 확인하는 것입니다.
- 클라이언트는 이 api를 바탕으로 문제풀이 화면을 구현합니다.

```
REQUEST
ex ) http://localhost:8080/piece/problems?pieceId=1

RESPONSEBODY
{
	"pieceId":1,
	"pieceTitle":"title",
	"problems":[
		{
			"id":1,
			"title":"problemTitle",
			"type": "SELECTION"
			"selections":[
				{
					1:"blahblah,
					2:"blahblah,
					3:"blahblah,
					4:"blahblah,
				}
			]
	]	
}

```

### 5. `PUT` 채점하기

- 학생은 4번 문제에서 조회했던 문제들을 채점할 수 있습니다.
- 문제는 2개이상 한번에 채점이 가능합니다.
- 채점 결과는 맞음, 틀림 2가지가 존재합니다.

```
REQUEST
ex ) http://localhost:8080/piece/problems?pieceId=1

REQUESTBODY
[
	{
		"problemId": 1,
		"answer": "hello",
	},
	{
		"problemId": 3,
		"answer": 3,
	},
]

RESPONSEBODY
[
	{
			"problemId" :1,
			"isCorrect": true
	},
	{
			"problemId" :3,
			"isCorrect": false
	},
]
```

### 6. `GET` 학습지 학습 통계 분석하기

- 선생님은 1개의 학습지에 대해 학생들의 **학습 통계**를 파악할 수 있습니다.
- 선생님은 자신이 만든 학습지에 대해 학생들의 학습 통계 데이터를 분석할 수 있습니다.
- 선생님은 조회한 1개의 학습지에 대해 아래의 정보들을 파악 할 수 있습니다.
    - 학습지 ID
    - 학습지 이름
    - 출제한 학생들의 목록
    - 학생들의 학습 데이터
        - 학생 개별의 학습지 정답률
    - 학습지의 문제별 정답률 (출제받은 학생들에 한에서)

```
REQUEST
ex ) http://localhost:8080/piece/analyze?pieceId=1

RESPONSEBODY
{
	"pieceId": 13,
	"title":"pieceTitle",
	"students":[
		{
			"id":3,
			"name":이름
		}
	],
	"resultsPerStudents":[
		{
			"studentId":3,
			"correctRate": 33
		}
	]
	"resultsPerProblems":[
		{
			"problemId":1,
			"correctRate": 33,
			"unitCode":"utc132",
			"unitName":"모수와 통계량 구별, 모집단과 표본"
		}
	]
	
}
```

---

## 필요 결과물

- 본인이 해당 프로젝트에서 발생할 수 있는 위험요소, 그리고 이를 어떻게 해결할지에 대해서 정리한 내용
- 발생할 수 있는 문제와 이에 대한 해결책(비용측면 또는 성능 측면등)
- 구현 코드, ERD

---

- 100% 완성되지 않은 경우, 고민거리와 이에 대한 부분을 문서에 잘 남겨주시면 됩니다.
- 명확하지 않은 요구 사항은 평가요소가 아니므로 자유롭게 구현해주셔도 됩니다.
- 로그인 API 등 유저관련 정보는 구현하지 않아도 괜찮습니다. 유저는 있다고 가정하고 개발해주시면 됩니다. 유저관련 정보는 평가항목이 아닙니다.

```
위의 내용은 모두 README에 작성해주시면 됩니다.
```

---

# ERD
![Image](https://github.com/user-attachments/assets/d430b18d-1f52-441d-9a6a-4ea8f6a2348f)

## 프로젝트에서 발생할 수 있는 위험요소, 그리고 이를 어떻게 해결할지에 대해서 정리한 내용
**1. 다량의 데이터가 적재된 통계성 데이터를 동시에 여러번 요청한 경우 DB 부하가 있을 수 있습니다**  
- 빠른 조회를 위해 인덱스를 지정해서 조회속도를 높일 수 있습니다.
- 통계성데이터 조회전용 캐시용테이블을 만들어서 조회속도를 높일 수 있습니다.
- 레디스 등 캐시서버를 이용해서 조회속도를 높일 수 있습니다.

**2. 점수체계가 변경이되어 100점만점이 아니게된경우**
- 어떤 점수체계를 썼는지에 대한 전략용 컬럼이 추가되고 이것을 비지니스로직에서 풀어줘야 합니다.

**3. 정답이 복수인경우**
- 현재는 단일정답만을 가정하고 있습니다. 만일 복수정답이 발생한 경우 answer Column 을 List<String>으로 변경해야 합니다.
- 복수 정답 모두 맞아야 하는 경우, 둘중 하나만 맞아도 되는 경우등의 비지니스 로직이 필요할 수 있습니다.

**4. 로그서비스, 문제지만 따로 저장하는 서비스등 모듈분리가 발생할 수 있음**
- 서비스가 커져감에 따라 따로 서버를 분리해야 할 수 있으므로 멀티모듈 구조로 프로젝트를 구성했고 이를 확용할 수 있습니다.

## 발생할 수 있는 문제와 이에 대한 해결책(비용측면 또는 성능 측면등)

**1. 많은 학생들에게 문제지를 동시에 배급을 해야 하는 경우**
- 쓰레드풀이 부족해 질 수 있습니다. 이때는 쓰레드풀을 늘려야 할 텐데 서비스에 사용되는 인스턴스의 동시 가용 쓰레드수를 확인합니다.  
같은 사이즈의 인스턴스를 더 띄우거나, 인스턴스 사이즈를 늘려야 합니다.
- 충분히 쓰레드풀을 늘렸음에도 서버오류가 발생할 수 있는데 이는 DB커넥션풀 부족일 수 있습니다. 모니터링을 꾸준히 하면서 커넥션풀이 여유가 있는지에 대한 확인이 필요합니다. 
해결 책으로 DB 커넥션풀을 늘리거나 DB 클러스터를 늘리는 방법을 사용할 수 있습니다.
- 자원 부족이 일어날지에 대한 모니터링을 위해 적절한 APM도구가 필요합니다.

**2. 생성되어지는 로그성 데이터가 많아 질 예정**
- 파티션 키를 설정하여 데이터베이스 또는 테이블 수준에서 데이터를 분산 저장합니다. 예를 들어, 날짜, 문제지 ID 또는 로그 유형 등을 파티션 키로 사용하여 데이터를 효율적으로 분리하고 관리할 수 있습니다.
또한 파티션키를 잘 설정한다면 쿼리 성능도 향상될 수 있습니다.

---
# 요청예시
### 문제지생성
```
POST http://localhost:8080/piece
Authorization : Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjEsInJvbGUiOiJURUFDSEVSIn0.OBY5iuemZl-F1Qc5Wp1gxRCIr_gefYHm6YfbS5o8u0g
{
  "pieceTitle":"pieceTitle",
  "problemListIds":[12]
}

RESPONSE
{
  "code": "RS_000",
  "message": null,
  "data": {
          "pieceId": 5
          }
  }
}
```
### 학생에게 문제지 부여
```
POST http://localhost:8080/piece/2?studentIds=5,1,3
Authorization : Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjEsInJvbGUiOiJURUFDSEVSIn0.OBY5iuemZl-F1Qc5Wp1gxRCIr_gefYHm6YfbS5o8u0g

RESPONSE
{
    "code": "RS_000",
    "message": null,
    "data": {
        "receivedStudents": [
            5,
            3
        ],
        "existStudents": [
            1
        ]
    }
}
```

### 학생이 지급된 문제지의 문제조회
```
GET http://localhost:8080/piece/problems?pieceId=2
Authorization : Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjEsInJvbGUiOiJTVFVERU5UIn0.Uhj_0xSBxhQTXQBao2zgsUuHOtHjeQcbCDTHGff0Mfc

RESPONSE
{
    "code": "RS_000",
    "message": null,
    "data": {
        "pieceId": 2,
        "pieceTitle": "3학년중간고사 국어 문제지",
        "problems": [
            {
                "id": 1003,
                "title": "원의 넓이를 구하는 공식을 고르시오",
                "type": "SELECTION",
                "selections": {
                    "1": "Option 1 for problem 1003",
                    "2": "Option 2 for problem 1003",
                    "3": "Option 3 for problem 1003",
                    "4": "Option 4 for problem 1003"
                }
            },
            {
                "id": 1004,
                "title": "원뿔의 넓이를 구하는 공식을 고르시오",
                "type": "SELECTION",
                "selections": {
                    "1": "Option 1 for problem 1004",
                    "2": "Option 2 for problem 1004",
                    "3": "Option 3 for problem 1004",
                    "4": "Option 4 for problem 1004"
                }
            },
            {
                "id": 1005,
                "title": "문제제목1005",
                "type": "SELECTION",
                "selections": {
                    "1": "Option 1 for problem 1005",
                    "2": "Option 2 for problem 1005",
                    "3": "Option 3 for problem 1005",
                    "4": "Option 4 for problem 1005"
                }
            },
            {
                "id": 1006,
                "title": "문제제목1006",
                "type": "SELECTION",
                "selections": {
                    "1": "Option 1 for problem 1006",
                    "2": "Option 2 for problem 1006",
                    "3": "Option 3 for problem 1006",
                    "4": "Option 4 for problem 1006"
                }
            }
        ]
    }
}
```

### 학생이 문제지 채점하기
```
PUT http://localhost:8080/piece/problems?pieceId=2
Authorization : Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjEsInJvbGUiOiJTVFVERU5UIn0.Uhj_0xSBxhQTXQBao2zgsUuHOtHjeQcbCDTHGff0Mfc
[
	{
		"problemId": 1003,
		"answer": 1
	},
	{
		"problemId": 1004,
		"answer": 2
	},
    	{
		"problemId": 1005,
		"answer": 1
	},
    	{
		"problemId": 1006,
		"answer": 1
	}
]

RESPONSE
{
    "code": "RS_000",
    "message": null,
    "data": [
        {
            "problemId": 1003,
            "isCorrect": true
        },
        {
            "problemId": 1004,
            "isCorrect": true
        },
        {
            "problemId": 1005,
            "isCorrect": false
        },
        {
            "problemId": 1006,
            "isCorrect": false
        }
    ]
}
```

### 학습지 통계 조회
```
GET http://localhost:8080/piece/analyze?pieceId=2
Authorization : Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjEsInJvbGUiOiJURUFDSEVSIn0.OBY5iuemZl-F1Qc5Wp1gxRCIr_gefYHm6YfbS5o8u0g

RESPONSE
{
    "code": "RS_000",
    "message": null,
    "data": {
        "pieceId": 2,
        "title": "3학년중간고사 국어 문제지",
        "students": [
            {
                "id": 1,
                "name": "임시이름1"
            },
            {
                "id": 2,
                "name": "임시이름2"
            },
            {
                "id": 5,
                "name": "임시이름5"
            },
            {
                "id": 3,
                "name": "임시이름3"
            }
        ],
        "resultsPerStudents": [
            {
                "studentId": 1,
                "correctRate": 50
            }
        ],
        "resultsPerProblems": [
            {
                "problemId": 1003,
                "correctRate": 25,
                "unitCode": "uc1580",
                "unitName": "표본추출 : 단순랜덤추출"
            },
            {
                "problemId": 1004,
                "correctRate": 25,
                "unitCode": "uc1580",
                "unitName": "표본추출 : 단순랜덤추출"
            },
            {
                "problemId": 1005,
                "correctRate": 0,
                "unitCode": "uc1580",
                "unitName": "표본추출 : 단순랜덤추출"
            },
            {
                "problemId": 1006,
                "correctRate": 0,
                "unitCode": "uc1581",
                "unitName": "표본추출 : 계통추출법"
            }
        ]
    }
}
```

### 권한이 없는경우
```
GET http://localhost:8080/piece/analyze?pieceId=2
Authorization : Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjEsInJvbGUiOiJTVFVERU5UIn0.Uhj_0xSBxhQTXQBao2zgsUuHOtHjeQcbCDTHGff0Mfc
{
    "code": "FRS_002",
    "message": "Access Denied: You do not have the required role",
    "data": null
}
```
