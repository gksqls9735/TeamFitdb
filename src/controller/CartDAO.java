package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.CartVO;
import model.ExerciseVO;

public class CartDAO {

	public void setCartRegister(CartVO c) {
		String sql = "INSERT INTO CART VALUES (CART_SEQ.NEXTVAL, ?, ?, SYSDATE, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, c.getU_id());
			pstmt.setInt(2, c.getE_no());
			pstmt.setString(3, c.getC_payment_status());

			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("강의 신청 완료.");
				System.out.println("강의 신청 성공!!!");
			} else {
				System.out.println("강의 신청 실패!!!");
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

	public void setCartDelete(int c_no) {
		String sql = "DELETE FROM CART WHERE C_NO = ?";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql.toString());

			pstmt.setInt(1, c_no);

			int i = pstmt.executeUpdate();
			if (i == 1) {
				System.out.println("강의 신청 취소 완료.");
				System.out.println("강의 신청 취소 성공!!!");
			} else {
				System.out.println("강의 신청 취소 실패!!!");
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

	// 카트가 존재하는지 확인
	public boolean checkCart(String u_id) {
		String sql = "SELECT COUNT(*) FROM CART WHERE U_ID = ?";
		boolean check = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt("COUNT(*)") == 0) {
					check = true;
				}				
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
		return check;
	}

	// 카트 전체 삭제
	public void allCartDelete(String u_id) {
		String sql = "DELETE FROM CART WHERE U_ID = ?";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, u_id);
			int i = pstmt.executeUpdate();
			if (i > 0) { // 변경된 조건
				System.out.println("강의 신청 취소 완료.");
				System.out.println("총 " + i + "개의 강의 신청이 취소되었습니다.");
			} else {
				System.out.println("강의 신청 취소 실패!!!");
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void getCartTotal(String u_id) {
		String sql = "SELECT C.C_NO AS C_NO, C.U_ID AS U_ID, U.U_NAME AS U_NAME, C.E_NO AS E_NO, "
				+ "E.E_NAME AS E_NAME, E.E_DATE AS E_DATE, E.E_TIME AS E_TIME, E.E_ADDR AS E_ADDR, "
				+ "E.E_PRICE AS E_PRICE, C.C_PAYMENT_STATUS AS C_PAYMENT_STATUS " + "FROM CART C, EXERCISE E, USERT U "
				+ "WHERE C.U_ID = ? AND C.E_NO = E.E_NO AND C.U_ID = U.U_ID " + "ORDER BY C_NO ASC";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("---------------------------------");
				System.out.println("일련번호\t|" + rs.getInt("C_NO") + "\n학생ID\t|" + u_id + "\n유저이름\t|"
						+ rs.getString("U_NAME") + "\n강의번호\t|" + rs.getInt("E_NO") + "\n운동종목\t|"
						+ rs.getString("E_NAME") + "\n강의날짜\t|" + rs.getString("E_DATE") + "\n강의시간\t|"
						+ rs.getString("E_TIME") + "\n강의장소\t|" + rs.getString("E_ADDR") + "\n가격\t|"
						+ rs.getInt("E_PRICE") + "\n결제여부\t|" + rs.getString("C_PAYMENT_STATUS"));
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
}
