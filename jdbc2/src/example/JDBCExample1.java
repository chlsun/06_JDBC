package example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample1 {
	
	public static void main(String[] args) {
		
		/* 입력 받은 아이디가 포함된 사용자의
		 * 사용자 번호, 아이디, 이름, 가입일을
		 * 회원 번호 오름차순으로 조회(SELECT)
		 * 
		 */
		
		
		Connection conn = null;	// DB 연결 정보를 가지고 연결하는 객체
		Statement stmt = null;	// SQL 수행, 결과 반환 받는 객체
		ResultSet rs = null;		// SELECT 결과를 저장하고 1행씩 접근하는 객체
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 내 컴퓨터 DB 연결
			// jdbc:oracle:thin:@localhost:1521:XE
			
			// 학원 DB 서버 URL
			// - jdbc 드라이버가 어떤 데이터베이스에 연결할지 지정
			String url = "jdbc:oracle:thin:@112.221.156.34:12345:XE";

			String userName = "KH26_CYS"; // 사용자 계정명
			String password = "KH1234"; // 계정 비밀번호
			
			conn = DriverManager.getConnection(
					url,
					userName,
					password);
			
			System.out.print("사용자의 아이디를 입력해주세요>>");
			String inputId = sc.next();
			
			
			String sql = String.format("""
SELECT USER_NO, USER_ID, USER_NAME, ENROLL_DATE
FROM TB_USER
WHERE USER_ID LIKE '%%%s%%'
ORDER BY USER_NO ASC
					""", inputId);
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {	// 커서를 다음행으로 이동, 행 있으면 true, 없으면 false
				
				int userNo = rs.getInt("USER_NO");
				String userId = rs.getString("USER_ID");
				String rsUserName = rs.getString("USER_NAME");
				Date enrollDate = rs.getDate("ENROLL_DATE");
				
				// java.sql.Date : DB의 Date 타입을 저장하는 클래스 
				
				System.out.printf("%d / %s / %s / %s\n", userNo, userId, rsUserName, enrollDate);
				// enrollDate가 Date타입인데 %s로 출력 되는 이유?
				// enrollDate를 호출하면 자동으로 .toString()메서드가 호출돼서!!
				
				
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
