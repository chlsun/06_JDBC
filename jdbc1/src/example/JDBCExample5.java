package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample5 {
	public static void main(String[] args) {
		
		
		// 부서명을 입력 받아
		// 해당 부서의 근무하는 사원의
		// 사번, 이름, 부서명, 직급명을
		// 직급코드 내림 차순으로 조회
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
				
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			String type = "jdbc:oracle:thin:@";
			String host = "112.221.156.34";
			String port = ":12345";
			String dbName = ":XE";
			String userName = "KH26_CYS";
			String password = "KH1234";
			
			conn = DriverManager.getConnection(
					type + host + port + dbName,
					userName,
					password
					);
			
			stmt = conn.createStatement();
			
			System.out.print("부서명을 입력해주세요.");
			String dTitle = sc.next();
			
			
			String sql = String.format("""
SELECT E.EMP_ID AS 사번, E.EMP_NAME, D.DEPT_TITLE 부서명, J.JOB_NAME 
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)		
WHERE D.DEPT_TITLE = '%s'			
ORDER BY E.DEPT_CODE ASC
					""", dTitle);
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String empId = rs.getString("사번");
				String empName = rs.getString("EMP_Name");
				String deptTitle = rs.getString("부서명");
				String jobName = rs.getString("JOB_NAME");
				
				System.out.printf("%s / %s / %s / %s\n",
						empId, empName, deptTitle, jobName);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
