package com.lec.ch12.service;
import java.util.ArrayList;

import com.lec.ch12.dao.MemberRepository;
import com.lec.ch12.dto.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class MemberListService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// dao를 통해서 memberList가져와 request에 setAttribute
		MemberRepository repository = MemberRepository.getInstance();
		//ArrayList<Member> memberList = repository.getMemberList();
		//request.setAttribute("memberList", memberList);
		request.setAttribute("memberList", repository.getMemberList());
	}
}












