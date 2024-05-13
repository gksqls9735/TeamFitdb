package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import model.UserVO;

public class UserDAO {

	public static Scanner sc = new Scanner(System.in);

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

	public boolean setUserRegister(UserVO u) {
		String sql = "INSERT INTO USERT VALUES (USERT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		boolean success = false;
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
				success = true;
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
		return success;
	}

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

	public boolean getUserLogin(String id, String pw) {

		String sql = "SELECT * FROM USERT WHERE U_ID = ? AND U_PW = ?";

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

	public String getUserNO(String id, String pw) {

		String sql = "SELECT U_NO FROM USERT WHERE U_ID = ? AND U_PW = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String u_id = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
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

	public void getUser(String id, String pw) {
		String sql = "SELECT * FROM USERT WHERE U_ID = ? AND U_PW = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO u = new UserVO();

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			System.out.println("유저 정보 출력");
			if (rs.next()) {
				u.setU_no(rs.getInt("U_NO"));
				u.setU_id(rs.getString("U_ID"));
				u.setU_pw(rs.getString("U_PW"));
				u.setU_name(rs.getString("U_NAME"));
				u.setU_phone(rs.getString("U_PHONE"));
				u.setIs_instructor(rs.getString("IS_INSTRUCTOR"));
				System.out.println(u.toString());
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

	public void setuserDelete(int u_no) {
		
		String sql = "DELETE FROM USERT WHERE U_NO = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, u_no);

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println("강의 삭제 완료.");
				System.out.println("강의 삭제 성공!!!");
			} else {
				System.out.println("강의 삭제 실패!!!");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
