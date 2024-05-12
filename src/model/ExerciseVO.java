package model;

import java.util.Date;

public class ExerciseVO {
	private int e_no;
	private String e_name;
	private int e_price;
	private String e_date;
	private String e_time;
	private String e_addr;
	
	public ExerciseVO() {
		super();
	}

	public ExerciseVO(int e_no, String e_name, int e_price, String e_date, String e_time, String e_addr) {
		super();
		this.e_no = e_no;
		this.e_name = e_name;
		this.e_price = e_price;
		this.e_date = e_date;
		this.e_time = e_time;
		this.e_addr = e_addr;
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public int getE_price() {
		return e_price;
	}

	public void setE_price(int e_price) {
		this.e_price = e_price;
	}

	public String getE_date() {
		return e_date;
	}

	public void setE_date(String e_date) {
		this.e_date = e_date;
	}

	public String getE_time() {
		return e_time;
	}

	public void setE_time(String e_time) {
		this.e_time = e_time;
	}

	public String getE_addr() {
		return e_addr;
	}

	public void setE_addr(String e_addr) {
		this.e_addr = e_addr;
	}
	
	@Override
	public String toString() {
		return "일련번호\t|" + e_no + "\n운동종목\t|" + e_name + "\n가격\t|" + e_price +
				"\n날짜\t|" + e_date + "\n시작시간\t|" + e_time + "\n장소\t|" + e_addr;
	}
}
