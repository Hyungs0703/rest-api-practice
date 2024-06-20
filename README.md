
# API 명세서
<img width="467" alt="API명세서" src="https://github.com/Hyungs0703/rest-api-practice/assets/165638682/098cd0a6-c46c-42fd-8fed-753455db4275">

## 1. Entity를 만들고 관계(단방향)를 설정해보세요.
<img width="247" alt="ERD 다이어그램" src="https://github.com/Hyungs0703/rest-api-practice/assets/165638682/e11da2a3-fda7-4226-bcf1-c729a4d40382">

## 2. CRUD API를 구현해보세요.
### 1. 학생을 등록한다.
<img width="518" alt="학생 생성" src="https://github.com/Hyungs0703/rest-api-practice/assets/165638682/2b12888f-27d2-4120-a494-5a217cf090e0">

### 2. 등록한 학생을 조회한다.
<img width="358" alt="학생 조회" src="https://github.com/Hyungs0703/rest-api-practice/assets/165638682/808cbaaf-abae-4eb2-b666-4c1130c8dff8">

### 3. 등록한 학생의 과목타입(JPA) 과목 시험을 등록한다.
<img width="511" alt="학생 점수 등록" src="https://github.com/Hyungs0703/rest-api-practice/assets/165638682/fa0a7058-e36c-4ac8-bf99-24f3e92c1b1c">

### 4. 등록한 학생의 과목타입(JPA) 과목 시험을 조회한다.
<img width="549" alt="학생 시험 조회" src="https://github.com/Hyungs0703/rest-api-practice/assets/165638682/c19e1df4-f0ff-459d-9a8b-aa65c7834a80">

## 3. Query Method를 작성하고 예상 SQL을 작성해보세요.

### 1.학번과 이메일로 조회한다.
    -  findByStudentNumberAndEmail
        -  select *
        
        from Student

        where studentNumber = 1 and email = 'sparta@email.com'
