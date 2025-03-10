package com.kh.mvc.model.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kh.mvc.model.dao.EmpDAO;
import com.kh.mvc.model.dto.EmpDTO;

public class EmpService {
	
	EmpDAO empDAO = new EmpDAO();
	
	public List<EmpDTO> selectAll(){
		List<EmpDTO> list = empDAO.selectAll();
		
		List<Integer> numList = new ArrayList<Integer>();
		
		List<EmpDTO> newList = new ArrayList<EmpDTO>();
		
		int loopNum = 10;
		
		if(list.size() < 10) {
			loopNum = list.size();
		}
		
		while(true) {
			int randNum = (int)(Math.random() * list.size());
			
			if(numList.size() >= loopNum) {
				break;
			}
			if(numList.contains(numList)) {
				continue;
			}
			
			numList.add(randNum);
			newList.add(list.get(randNum));
		}
		
		return newList;
		
	}
	
}
