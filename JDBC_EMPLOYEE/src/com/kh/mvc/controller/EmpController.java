package com.kh.mvc.controller;

import com.kh.mvc.model.dao.EmpDAO;
import com.kh.mvc.model.dto.EmpDTO;

import java.util.List;

public class EmpController {

    EmpDAO empDAO = new EmpDAO();

    public List<EmpDTO> selectAll(){
        return empDAO.selectAll();
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
