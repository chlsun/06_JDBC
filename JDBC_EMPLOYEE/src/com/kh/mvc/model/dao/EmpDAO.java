package com.kh.mvc.model.dao;

import com.kh.mvc.model.dto.EmpDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {

    private final String URL = "jdbc:oracle:thin:@112.221.156.34:12345:xe";
    private final String USERNAME = "KH26_CYS";
    private final String PASSWORD = "KH1234";

    static{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundException");
        }
    }

    public List<EmpDTO> selectAll(){

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = """
                SELECT 
                    EMP_ID, EMP_NAME, EMP_NO, DEPT_CODE
                FROM 
                    EMPLOYEE
                """;

        List<EmpDTO> list = new ArrayList<EmpDTO>();

        try{
        	
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            EmpDTO dto = null;


            while(rs.next()){
                dto = new EmpDTO(
                        rs.getString("EMP_ID"),
                        rs.getString("EMP_NAME"),
                        rs.getString("EMP_NO"),
                        rs.getString("DEPT_CODE")
                );

                list.add(dto);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return list;
    }


    public int dateInsert(String empId, String empName, String empNo){
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = """
                INSERT INTO EMPLOYEE
                VALUES (
                    ?, ?, ?, 'abcd@qwer.com', '01012345678', 'D1', 'J4', 'S4', 12345678, 0.1, '200', SYSDATE, NULL, 'Y'
                )
                """;

        int result = 0;

        try{
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, empId);
            pstmt.setString(2, empName);
            pstmt.setString(3, empNo);

            result = pstmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return result;
    }

    public String checkId(String empId){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String result = null;

        String sql = """
                SELECT 
                    EMP_ID
                FROM 
                    EMPLOYEE
                WHERE 
                    EMP_ID = ?
                """;

        try{
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, empId);

            rs = pstmt.executeQuery();

            if(rs.next()){
                result = rs.getString("EMP_ID");
            }

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return result;
    }

    public int dataUpdate(String empId, String newName){
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = """
                UPDATE EMPLOYEE
                SET EMP_NAME = ?
                WHERE EMP_ID = ?
                """;

        int result = 0;

        try{
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, newName);
            pstmt.setString(2, empId);

            result = pstmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return result;
    }

    public int dataDelete(String empId){
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = """
                DELETE 
                FROM EMPLOYEE
                WHERE EMP_ID = ?
                """;

        int result = 0;

        try{
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, empId);

            result = pstmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return result;
    }

}
