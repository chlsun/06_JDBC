package com.kh.mvc.run;

import com.kh.mvc.view.UserView;

public class Run {

	public static void main(String[] args) {
		
		//EntryPoint : 시작점 
		// JVM이 EntryPoint인 main의 이름의 메서드를 찾아서 실행
		
		/*
		 * Model : 데이터 과련된 모든 작업 
		 * View	 : 화면 상 입 / 출력 (프레젠테이션 로직)
		 * Controller : View에서의 요청을 받아서 처리해주는 역할
		 */
		new UserView().mainMenu();
		
	}
	
}
