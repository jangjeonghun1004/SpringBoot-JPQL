# JPQL

    "JPA Query Language" 는 엔티티 객체를 대상으로 수행하는 쿼리로서
    엔티티의 이름과 필드의 이름을 사용한다.

# 주제 키워드

    조회 쿼리
    - find...By
        findBy = 단일 건
        findAllBy = 복수 건
    - query...By
        @Query 어노테이션과 함께 사용
    - read...By
    - get...By
    - search...By
    - stream...By

    특정 데이터가 존재하는지 확인 쿼리
    - exists...By
    
    조회 결과 레코드 수 쿼리
    - count...By

    삭제 쿼리
    - delete...By
    - remove...By

    조회 결과 제한 쿼리
    - First<number>
    - Top<number>

# 조건자 키워드

    값의 일치 쿼리
    - Is
    - Equals

    값의 불일치 쿼리
    - Not
    - IsNot

    값이 null인지 검사하는 쿼리
    - Null
    - IsNull
    - NotNull
    - IsNotNull

    boolean 타입 쿼리
    - True
    - IsTrue
    - False
    - IsFalse

    여러 조건 쿼리
    - And
    - Or

    숫자나 datetime 비교 쿼리
    - GreaterThan
    - LessThan
    - Between

    부분 일치 쿼리
    - StartingWith
    - EndingWith
    - Containing
    - Like

# 정렬

    OrderBy...Asc
    OrderBy...Desc
    Sort 객체 활용

# 페이징 처리

    리턴 타입 = Page<T>
    매개 변수 = Pageable

# @Query 어노테이션

    직접 쿼리를 작성해야하는 경우 "@Query" 을 사용합니다.
    예) 쿼리 튜닝에 의한 쿼리문 사용시

    @Param("name") = 파라미터 지정
    특정 컬럼만 지정하는 경우 리턴 타입 = List<Object[]>

# QueryDSL

    QueryDSL은 정적 타입을 이용해 SQL과 같은 쿼리를 생성할 수 있도록 지원하는 프레임워크입니다.
    @Query 어노테이션의 경우 런타임 시점에 에러가 발생할 수 있다. QueryDSL은 @Query의 이런 단점을 보완해 준다.

# QueryDSL dependency

    <dependency>
        <groupId>com.querydsl</groupId>
        <artifactId>querydsl-apt</artifactId>
        <scope>provided</scope>
        <classifier>jakarta</classifier>
        <version>5.0.0</version>
    </dependency>
    <dependency>
        <groupId>com.querydsl</groupId>
        <artifactId>querydsl-jpa</artifactId>
        <classifier>jakarta</classifier>
        <version>5.0.0</version>
    </dependency>

    Maven -> Reload Project
    Build -> Rebuild Project

# QueryDSL-JPAQueryFactory

    "QueryDSLTests.java" 파일을 참조하세요.

# QueryDSL-편의성 인터페이스

    QuerydslPredicateExecutor
    QuerydslRepositorySupport

    "QProductRepositoryTests.java" 파일을 참조하세요.

# JPA Auditing

    엔티티 클래스에 공통적으로 들어가는 컬럼을 정의 하거나 값을 자동으로 넣어주는 기능을 제공한다.
    
    1. 단계
    @Configuration
    @EnableJpaAuditing
    public class JpaAuditingConfig { }

    2. 단계
    @Getter
    @Setter
    @ToString
    @MappedSuperclass
    @EntityListeners(AuditingEntityListener.class)
    public class BaseEntity {
        @CreatedDate
        @Column(updatable = false)
        private LocalDateTime createdAt;
        
        @LastModifiedDate
        private LocalDateTime updatedAt;
    }

    3. 단계(상속)
    extends BaseEntity

# API

    SimpleJpaRepository
    https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository.html

    



    

