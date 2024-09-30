package com.lec.ex1selectAll;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "SELECT * FROM EMP";
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null; // select 결과를 받을 변수객체
		try {
			Class.forName(driver); // 1. 드라이버 로드(jdk17부터 생략가능)
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 2.DB연결
			stmt = conn.createStatement(); // 3.SQL전송 객체
			rs   = stmt.executeQuery(sql); // 4+5. SQL전송 + SQL결과 받기
			// 6. 원하는 로직 수행
			if(rs.next()) { // select 결과가 1행 이상
				System.out.println("사번\t이름\t직책\t\t상사사번\t입사일\t급여\t상여\t부서번호");
				do {
					int empno = rs.getInt(1); // 첫번째 필드
					String ename = rs.getString("ename"); // sql 결과의 title에 ename인 값
					String job   = rs.getString("job");
					String mgr   = rs.getString("mgr"); // null값은 null문자로 받음
					//String hiredate = rs.getString("hiredate");
					Date hiredate = rs.getDate("hiredate"); // 날짜만 받기(시간은 0시0분)
					//Timestamp hiredate1 = rs.getTimestamp("hitedate");//날짜와 시간 받기
					int sal    = rs.getInt("sal");
					int comm   = rs.getInt("comm"); // null값은 0으로 받음
					int deptno = rs.getInt("deptno");
					if(job.length() < 6) {
						System.out.printf("%d\t %s\t %s\t\t %s\t %TF\t %d\t %d\t %d\n",
								empno, ename, job, mgr, hiredate, sal, comm, deptno);
					}else {
						System.out.printf("%d\t %s\t %s\t %s\t %TF\t %d\t %d\t %d\n",
							empno, ename, job, mgr, hiredate, sal, comm, deptno);
					}
				}while(rs.next());
			}else {
				System.out.println("등록된 사원 정보가 없습니다");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try { // 7. 연결 해제(순서대로)
				if(rs  !=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}




