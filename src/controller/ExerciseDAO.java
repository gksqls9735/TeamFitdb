package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ExerciseVO;

public class ExerciseDAO {

	public void getExerciseTotalList() {

		ExerciseVO ex = new ExerciseVO();

		String sql = "SELECT * FROM EXERCISE ORDER BY ? ASC";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("강의 목록 출력");
			while (true) {
				ex.setE_no(rs.getInt("E_NO"));
				ex.setE_name(rs.getString("E_NAME"));
				ex.setE_price(rs.getInt("E_PRICE"));
				ex.setE_date(rs.getString("E_DATE"));
				ex.setE_time(rs.getString("E_TIME"));
				ex.setE_addr(rs.getString("E_ADDR"));
				System.out.println(ex.toString());
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

	public void setExerciseRegister(ExerciseVO ex) {

		String sql = "INSERT INTO exercise VALUES (EXERCISE_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, ex.getE_name());
			pstmt.setInt(2, ex.getE_price());
			pstmt.setString(3, ex.getE_date());
			pstmt.setString(4, ex.getE_time());
			pstmt.setString(5, ex.getE_addr());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(ex.getE_name() + " 강의 등록 완료.");
				System.out.println("강의 등록 성공!!!");
			} else {
				System.out.println("강의 등록 실패!!!");
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

	public boolean setExerciseUpdate(ExerciseVO ex) {
		String sql = "UPDATE EXERCISE SET E_PRICE = ?, E_DATE = ?, E_TIME = ?, E_ADDR = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, ex.getE_price());
			pstmt.setString(2, ex.getE_date());
			pstmt.setString(3, ex.getE_time());
			pstmt.setString(4, ex.getE_addr());

			int i = pstmt.executeUpdate();

			if (i == 1) {
				System.out.println(ex.getE_name() + " 강의 등록 완료.");
				System.out.println("강의 등록 성공!!!");
				success = true;
			} else {
				System.out.println("강의 등록 실패!!!");
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

	public void setExerciseDelete(int e_no) {
		String sql = "DELETE FROM EXERCISE WHERE E_NO = ?";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, e_no);

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
