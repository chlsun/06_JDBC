package com.kh.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kh.mvc.model.dao.UserDAO;
import com.kh.mvc.model.dto.UserDTO;
import com.kh.mvc.model.service.MemberService;

/**
 * VIEW에서 온 요청을 처리해주는 클래스입니다.
 * 메소드로 전달된 데이터값을 가공처리한 후 DAO로 전달합니다.
 * DAO로부터 반환받은 결과를 사용자가 보게될 View(응답화면)에 반환합니다.
 */
public class UserController {
	
	private UserDAO userDao = new UserDAO();
	private MemberService userService = new MemberService(); 
	
	
	
	public List<UserDTO> findAll() {
		return userService.findAll();
	}
	
	
	
	public int insertUser(String userId, String userPw, String userName) {
		UserDTO user = new UserDTO();
		user.setUserId(userId);
		user.setUserPw(userPw);;
		user.setUserName(userName);
		
		return userService.insertUser(user);
	}
	
	
	
	public boolean isEmptyUserNo(int userNo) {
		return userService.isEmptyUserNo(userNo);
	}
	
	
	public int updatePw(String newPw, int userNo) {
		return userService.updatePw(newPw, userNo);
	}

	public int userDelete(int userNo) {
		return userService.userDelete(userNo);
	}

	public UserDTO selectUserNo(int userNo){
		return userService.selectUserNo(userNo);
	}

	public UserDTO selectUserId(String userId){
		return userService.selectUserId(userId);
	}
	
}
