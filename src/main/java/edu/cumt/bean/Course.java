package edu.cumt.bean;

public class Course {
	private int cid;
	private String cname;
	private String tname;
	private String tjob;
	private int score;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTjob() {
		return tjob;
	}
	public void setTjob(String tjob) {
		this.tjob = tjob;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Course() {
		super();
	}
	public Course(int cid, String cname, String tname, String tjob) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.tname = tname;
		this.tjob = tjob;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", tname=" + tname
				+ ", tjob=" + tjob + ", score=" + score + "]";
	}
	
	
}
