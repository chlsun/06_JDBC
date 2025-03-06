package com.kh.mvc.view;

import com.kh.mvc.controller.EmpController;
import com.kh.mvc.model.dto.EmpDTO;

import java.util.List;
import java.util.Scanner;

public class EmpView {

    EmpController empController = new EmpController();
    Scanner sc = new Scanner(System.in);

    public void mainMenu(){

        System.out.println("EMPLOYEE테이블 데이터 조회, 추가 수정, 삭제 해보기");

        while(true){
            System.out.println();
            System.out.println("1. 전체조회");
            System.out.println("2. 데이터 추가");
            System.out.println("3. 데이터 수정");
            System.out.println("4. 데이터 삭제");
            System.out.println("0. 프로그램 종료\n");
            System.out.print("Menu를 선택해주세요 >> ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch(menu){
                case 1: selectAll(); break;
                case 2: dataInsert(); break;
                case 3: dataUpdate(); break;
                case 4: dataDelete(); break;
                case 0: System.out.println("프로그램을 종료합니다."); return;
                default: break;

            }
        }
    }

    /**
     *  회원전체의 EMP_ID, EMP_NAME, EMP_NO, DEPT_CODE 정보 조회
     */
    private void selectAll(){
        System.out.println("--- 전체 조회 ---");

        List<EmpDTO> list = empController.selectAll();

        if(list.isEmpty()){
            System.out.println("조회 결과가 없습니다");
            return;
        }

        for(EmpDTO empDTO : list){
            System.out.println(empDTO);
            System.out.println();
        }
    }

    private void dataInsert(){
        System.out.println("--- 직원 추가 ---\n");

        System.out.print("사원번호 입력(ex.301) >>");
        String empId = sc.nextLine();
        System.out.print("사원이름 입력 >>");
        String empName = sc.nextLine();
        System.out.print("주민번호 입력 >>");
        String empNo = sc.nextLine();
        
        int result = empController.dataInsert(empId, empName, empNo);

        if(result > 0) {
            System.out.println("추가 완료");
        }else{
            System.out.println("추가 실패");
        }
        
    }

    private void dataUpdate(){
        System.out.println("--- 직원 수정 ---\n");

        System.out.print("수정할 사원번호 입력 >>");
        String empId = sc.nextLine();

        if(!!!empController.checkId(empId)){
            System.out.println("입력된 사원이 존재하지 않습니다.");
            return;
        }

        System.out.print("사원이름 수정 >>");
        String newName = sc.nextLine();

        int result = empController.dataUpdate(empId, newName);

        if(result > 0) {
            System.out.println("수정 완료");
        }else{
            System.out.println("수정 실패");
        }
    }

    private void dataDelete(){

        System.out.println("--- 직원 삭제 ---\n");

        System.out.print("삭제할 사원번호 입력 >>");
        String empId = sc.nextLine();

        if(!!!empController.checkId(empId)){
            System.out.println("입력된 사원이 존재하지 않습니다.");
            return;
        }

        int result = empController.dataDelete(empId);

        if(result > 0) {
            System.out.println("삭제 완료");
        }else{
            System.out.println("삭제 실패");
        }
    }

}

