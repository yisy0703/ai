<%@page import="com.lec.dto.Emp"%>
<%@page import="com.lec.dao.EmpRepository"%>
<%@page import="com.lec.dto.Dept"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.DeptRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String conPath = request.getContextPath();%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet" type="text/css">
</head>
<body>
	<form action="">
		<p>
			<select name="deptno">
				<option></option>
				<%
				String deptnoStr = request.getParameter("deptno"); // null, "", 10, 20, 30, ...
				int deptnoInput = 0;
				if(deptnoStr!=null && !deptnoStr.equals("")){
					deptnoInput = Integer.parseInt(deptnoStr);
				}
				DeptRepository deptRepository = DeptRepository.getInstance();
				ArrayList<Dept> deptList = deptRepository.deptList();
				for(Dept dept : deptList){
					int deptno = dept.getDeptno();
					String dname = dept.getDname();
					out.print("<option value='"+ deptno + "' "); // <option value="10">
					// selected="selected" 넣을 조건
					// deptnoInput : 전달받은 파라미터를 숫자로 바꾼 값(파라미터를 전달 못 받았거나, ""을 받을 경우 0)
					//if(deptnoStr!=null && !deptnoStr.equals("") && deptno==Integer.parseInt(deptnoStr)){
					if(deptno == deptnoInput){
						out.print("selected='selected'");
					}
					out.print(">");
					out.print(deptno + "-" + dname); // 10-ACCOUNTING
					out.print("</option>");
				}
				%>
			</select>
			<input type="submit" value="검색">
		</p>
	</form>
	<table>
	<%	
	EmpRepository empRepository = EmpRepository.getInstance();
	ArrayList<Emp> empList = empRepository.empListByDeptno(deptnoStr);
	// rs = stmt.executeQuery(sql);
	out.print("<tr><th>사번</th><th>이름</th><th>직책</th><th>상사사번</th>");
	out.print("    <th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th></tr>");
	if(empList.size()!=0){
		for(Emp emp : empList){
			out.print("<tr><td>" + emp.getEmpno() + "</td>");
			out.print("    <td>" + emp.getEname() + "</td>");
			out.print("    <td>" + emp.getJob() + "</td>");
			out.print("    <td>" + (emp.getMgr()==0? "CEO":emp.getMgr()) + "</td>");
			out.print("    <td>" + emp.getHiredate() + "</td>");
			out.print("    <td>" + emp.getSal() + "</td>");
			out.print("    <td>" + emp.getComm() + "</td>");
			out.print("    <td>" + emp.getDeptno() + "</td></tr>");
		}
	}else{
		out.print("<tr><td colspan='8'>해당 부서번호의 사원은 없습니다</td></tr>");
	}
	%>
	</table>
</body>
</html>







