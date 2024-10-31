package com.lec.ex.dao;
import java.io.IOException;
import java.util.ArrayList;
import com.lec.ex.dto.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/PersonDaoTest")
public class PersonRepositoryTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonRepository dao = PersonRepository.getInstance();
		ArrayList<Person> personList = dao.getPersonList();
		System.out.println("1. list(paging X)");
		for(Person person : personList) {
			System.out.println(person);
		}
		System.out.println("1. list(2등~3등)");
		personList = dao.getPersonList(2, 3);
		for(Person person : personList) {
			System.out.println(person);
		}
		System.out.println("3. getCount");
		System.out.println("전체 갯수 : " + dao.getCount());
		System.out.println("4. 한명 출력 ");
		Person person = dao.getPerson(1); // id가 1인 person 정보
		System.out.println("id가 1인 사람 : " + person);
		Person newPerson = new Person(0, "김수한", null, "무안", null, "memo", null);
		int result = dao.insertPerson(newPerson);
		if(result == PersonRepository.SUCCESS) {
			System.out.println(newPerson.getName() + " 추가 성공");
		}
		person.setName("이름싹");
		person.setAddress("이사간 곳");
		result = dao.updatePerson(person);
		if(result == PersonRepository.SUCCESS) {
			System.out.println(newPerson.getName() + " 수정 성공");
			System.out.println("id가 1인 person 수정한 후 :" + dao.getPerson(1));
		}
		
	}
}
