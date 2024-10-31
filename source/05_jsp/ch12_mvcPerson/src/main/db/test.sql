-- 1. LIST (PAGING추가) : public ArrayList<Person> getPersonList(int startRow, int endRow) : 2등~3등
SELECT * 
  FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM PERSON ORDER BY ID DESC) A)
  WHERE RN BETWEEN 2 AND 3;
-- 2. getCount (PAGING처리시 필요한 전체 갯수) : public int getCount()
SELECT COUNT(*) FROM PERSON;
-- 3. 추가 : public int insertPerson(Person person)
INSERT INTO PERSON (ID, NAME, TEL, ADDRESS, BIRTH, MEMO)
  VALUES (PERSON_ID_SEQ.NEXTVAL, '최길뚱', '010-6666-6666', '부산', '02/01/01', '테스트');
-- 4. 한명출력 : public Person getPerson(int id)
SELECT * FROM PERSON WHERE ID=1;
-- 5. 수정 : public int updatePerson(Person person)
UPDATE PERSON 
  SET NAME='홍길동',
    TEL='010-1234-7894',
    ADDRESS = '수원',
    BIRTH = '99/12/12',
    MEMO = ''
  WHERE ID=1;
-- 6. 삭제 : public int deletePerson(int id)
COMMIT;
DELETE FROM PERSON WHERE ID=1;
ROLLBACK;