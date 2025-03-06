package com.kh.mvc.model.dto;

public class EmpDTO {
    private String empId;
    private String empName;
    private String empNo;
    private String empDept;

    public EmpDTO() {}

    public EmpDTO(String empId, String empName, String empNo, String empDept) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.empDept = empDept;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return String.format("사원번호 : %s / 이름 : %s / 주민번호 : %s / 부서번호 : %s", empId, empName, empNo, empDept);
    }
}
