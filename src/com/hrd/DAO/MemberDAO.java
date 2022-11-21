package com.hrd.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hrd.VO.MemberVO;

public class MemberDAO {
		Connection conn=null;
		
		public MemberDAO(){
			//1. 드라이버 로드(한번만) 2. 커넥션 3.쿼리전송 4.리턴값 처리
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("로드성공");
			} catch(Exception e) {
				System.out.println("로드실패");
			}
			
		}
		
		public boolean connect() { // 
			try {
				// 커넥션을 시도하고 그 결과를 얻어 오는 코드... 
				conn =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
				return true;
			} catch (Exception e) {
				
			}
			return false;
		}
		
		
		
		public void insert(MemberVO membervo) { //작성한 게시글을 DB에 저장
			if(connect()) {
				String sql="insert into MEMBER_TBL_02 values (?,?,?,?,?,?,?)";
				try {
					PreparedStatement psmt=conn.prepareStatement(sql);
					psmt.setInt(1, membervo.getCustno());
					psmt.setString(2, membervo.getCustname());
					psmt.setString(3, membervo.getPhone());
					psmt.setString(4, membervo.getAddress());
					psmt.setString(5, membervo.getJoindate());
					psmt.setString(6, membervo.getGrade());
					psmt.setString(7, membervo.getCity());
					int r=psmt.executeUpdate();
					System.out.println("입력 성공");
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("입력 실패");
				}
			}
		}
		
		public int nowCnt()  {
			int nowNumber=-1;
			ResultSet rs=null;
			if(connect()) {
				String sql="select member_seq.nextval as num from dual";
				try {
					Statement st=conn.createStatement();
					rs=st.executeQuery(sql);
					if(rs.next()) {
						nowNumber=rs.getInt("num");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			return nowNumber;
			
		}


		
	}


