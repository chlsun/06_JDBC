package com.kh.mvc.controller;

import com.kh.mvc.model.dao.EmpDAO;
import com.kh.mvc.model.dto.EmpDTO;
import com.kh.mvc.model.service.EmpService;

import java.util.List;

public class EmpController {

    EmpDAO empDAO = new EmpDAO();
    EmpService empService = new EmpService();

    public List<EmpDTO> selectAll(){
        return empService.selectAll();
    }

    public int dataInsert(String empId, String empName, String empNo){
        return empDAO.dateInsert(empId, empName, empNo);
    }

    public boolean checkId(String empId){

        String result = empDAO.checkId(empId);

        if(result == null){
            return false;
        }

        return true;
    }

    public int dataUpdate(String empId, String newName){
        return empDAO.dataUpdate(empId, newName);
    }

    public int dataDelete(String empId){
        return empDAO.dataDelete(empId);
    }

}
