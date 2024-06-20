
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

### 1. 학번과 이메일로 조회한다.
    -  findByStudentNumberAndEmail
    
        select *
        
        from Student

        where studentNumber = 1 and email = 'sparta@email.com'
<img width="628" alt="학번 이메일로 조회" src="https://github.com/Hyungs0703/rest-api-practice/assets/165638682/36b3abb9-f755-4992-8a24-00c238ce33ce">


### 2. 성의 첫글자로 학생들을 조회한다.
 -  findByNameStartsWith("김") // 사용할 때 예
 -  findByNameStartsWith(String name);
   
    
        select *
        
        from Student

        where name Like "김%"

        order by score desc

<img width="574" alt="첫글자로 이름조회" src="https://github.com/Hyungs0703/rest-api-practice/assets/165638682/59626c49-8bfa-44b2-9bf6-782b3d762c33">

### 3. 점수가 70점 이상이고 80점 이하인 시험들을 내림차순으로 정렬하여 조회한다.
 -  findByScoreBetweenOrderByScoreDesc(70, 80) //상관없다.
 -  findByScoreGreaterThanEqualAndScoreLessThanEqualOrderByScoreDesc(Long score1, Long score2)
 -  findByScoreGreaterThanEqualAndScoreLessThanEqualOrderByScoreDesc(70, 80) //사용할 때

        select *
        
        from Test

        where score between 70 and 80

        order by score desc
<img width="598" alt="첫번째 점수와 두번째 점수 사이" src="https://github.com/Hyungs0703/rest-api-practice/assets/165638682/0709bf3a-bd0c-4323-b4f1-a587fc26afd2">

