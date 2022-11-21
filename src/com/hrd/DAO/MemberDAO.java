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
			//1. ����̹� �ε�(�ѹ���) 2. Ŀ�ؼ� 3.�������� 4.���ϰ� ó��
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("�ε强��");
			} catch(Exception e) {
				System.out.println("�ε����");
			}
			
		}
		
		public boolean connect() { // 
			try {
				// Ŀ�ؼ��� �õ��ϰ� �� ����� ��� ���� �ڵ�... 
				conn =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
				return true;
			} catch (Exception e) {
				
			}
			return false;
		}
		
		
		
		public void insert(MemberVO membervo) { //�ۼ��� �Խñ��� DB�� ����
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
					System.out.println("�Է� ����");
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("�Է� ����");
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


