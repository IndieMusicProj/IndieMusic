# db 연동을 위한 설명서




## 1.새로운 계정 권한주기

1. system 더블클릭
2. 열리는 창에 다음 코드 입력 후 한줄 씩 ctrl + enter로 계정 생성 후 권한 추가

```
CREATE USER Indie identified by 1234;
GRANT CONNECT, RESOURCE TO Indie;
GRANT CREATE VIEW TO Indie;

SELECT * FROM all_users;
```
3. 생성된 `Indie` 계정 확인

![image](https://user-images.githubusercontent.com/84966961/132122097-a96705e7-58f2-4a87-a9a2-ae722630a51e.png)

<br>

## 2. backup.dmp 파일 추가

1. 수업시간에 한 것 처럼 dmp 파일 c드라이브에 복사
2. window + r 눌러 cmd 입력 후 커맨드 창 오픈
3. 다음 코드 입력 후 (복사 붙여넣기 cmd 창에서는 `shift + insert` 키 눌러 붙여넣기)
```
imp system/1234 fromuser=Indie touser=Indie file=c:/backup.dmp
```
4. 다음 이미지 확인 후 sql developer 확인


<br>

## 3. 새로운 접속 생성

1. 새 접속 버튼(+) 클릭
2. Name : IndieMusic 입력
3. 사용자 이름 : Indie
4. 비밀번호 : 1234
5. 비밀번호 저장 클릭
6. 저장 클릭

![image](https://user-images.githubusercontent.com/84966961/132122425-65c8c2d4-e528-4427-b2e4-c9d82efb29d3.png)

7. 추가 확인
![image](https://user-images.githubusercontent.com/84966961/132122441-4d0651c3-58b8-434d-990b-02b63ca8c39e.png)



<br>

## 4. db 확인




















