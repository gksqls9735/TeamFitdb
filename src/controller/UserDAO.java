package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.UserVO;

public class UserDAO {

	public static Scanner sc = new Scanner(System.in);
	
	// 유저 전체 정보
	public void getUserTotalList() {
		String sql = "SELECT * FROM USERT ORDER BY U_NO ASC";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO u = new UserVO();

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				u.setU_no(rs.getInt("U_NO"));
				u.setU_id(rs.getString("U_ID"));
				u.setU_pw(rs.getString("U_PW"));
				u.setU_name(rs.getString("U_NAME"));
				u.setU_phone(rs.getString("U_PHONE"));
				u.setIs_instructor(rs.getString("IS_INSTRUCTOR"));
				System.out.println("---------------------------------");
				System.out.println(u.toString());
				System.out.println("---------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 유저 등록
	public void setUserRegister(UserVO u) {
		String sql = "INSERT INTO USERT VALUES (USERT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u.getU_id());
			pstmt.setString(2, u.getU_pw());
			pstmt.setString(3, u.getU_name());
			pstmt.setString(4, u.getU_phone());
			pstmt.setString(5, u.getIs_instructor());

			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println(u.getU_name() + "유저 등록 완료.");
				System.out.println("유저 등록 성공!");
			} else {
				System.out.println("유저 등록 실패!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// 유저 정보 수정
	public void setUserUpdate(UserVO u) {
		String sql = "UPDATE USERT SET U_PW = ?, U_NAME = ?, U_PHONE = ? WHERE U_ID = ?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u.getU_pw());
			pstmt.setString(2, u.getU_name());
			pstmt.setString(3, u.getU_phone());
			pstmt.setString(4, u.getU_id());
			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println(u.getU_name() + "유저 수정 완료.");
				System.out.println("유저 수정 성공!");
			} else {
				System.out.println("유저 수정 실패!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 아이디 확인
	public boolean getUserIdCheck(String id) {

		String sql = "SELECT * FROM USERT WHERE U_ID = ?"; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean idResult = false;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				idResult = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return idResult;
	}

	// 로그인
	public boolean getUserLogin(String id, String pw) {

		String sql = "SELECT COUNT(*) FROM USERT WHERE U_ID = ? AND U_PW = ?"; // count로 바꾸기

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean success = false;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				success = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}

	// 유저 일련번호 가져오기
	public String getUserNO(String id) {

		String sql = "SELECT U_NO FROM USERT WHERE U_ID = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String u_id = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				u_id = rs.getString("U_NO");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return u_id;
	}

	// 유저 정보 출력
	public void getUser(String u_id) {
		String sql = "SELECT * FROM USERT WHERE U_ID = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO u = new UserVO();

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_id);

			rs = pstmt.executeQuery();
			System.out.println("유저 정보 출력");
			if (rs.next()) {
				u.setU_no(rs.getInt("U_NO"));
				u.setU_id(rs.getString("U_ID"));
				u.setU_pw(rs.getString("U_PW"));
				u.setU_name(rs.getString("U_NAME"));
				u.setU_phone(rs.getString("U_PHONE"));
				u.setIs_instructor(rs.getString("IS_INSTRUCTOR"));
				System.out.println("---------------------------------");
				System.out.println(u.toString());
				System.out.println("---------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 유저 삭제
	public void setuserDelete(String u_id) {

		String sql = "DELETE FROM USERT WHERE U_ID = ?";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, u_id);

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println("유저 삭제 완료.");
				System.out.println("유저 삭제 성공!!!");
			} else {
				System.out.println("유저 삭제 실패!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 강사 정보를 확인
	public String isInstructor(String u_id) {
		String sql = "SELECT IS_INSTRUCTOR FROM USERT WHERE U_ID = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String checkInst = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				checkInst = rs.getString("IS_INSTRUCTOR");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return checkInst;
	}

	// 강사목록 보여주는 리스트
	public void getInstList() {
		String sql = "SELECT U_NO, U_ID, U_NAME FROM USERT WHERE IS_INSTRUCTOR = 'Y'";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int u_no = 0;
		String u_id = null;
		String u_name = null;
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				u_no = rs.getInt("U_NO");
				u_id = rs.getString("U_ID");
				u_name = rs.getString("U_NAME");
				System.out.println("---------------------------------");
				System.out.println("일련번호\t|" + u_no + "\n강사ID\t|" + u_id + "\n강사이름\t|" + u_name);
				System.out.println("---------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//일련번호로 강사의 아이디가져오기
	public String getInstId(int no) {
		String sql = "SELECT U_ID FROM USERT WHERE U_NO = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String inst_id = null;
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				inst_id = rs.getString("U_ID");				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return inst_id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
