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
	자유롭게 구현하시면 됩니다.
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
	"received":[1,3],
	"exist":[4]
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
{
	"problemIds":[1,3]
}

RESPONSEBODY
[
	{
			"id" :1,
			"result": true
	},
	{
			"id" :3,
			"result": false
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
	"id": 13,
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
