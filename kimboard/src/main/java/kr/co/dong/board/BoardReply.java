/*
* Table: board_reply
Columns:
reno int AI PK 
rewriter varchar(45) 
rememo varchar(45) 
redate datetime 
bno int
 */
package kr.co.dong.board;

public class BoardReply {
	private int reno;
	private String rewriter;
	private String rememo;
	private String redate;
	private int bno;  // 게시글번호(외래키)
	
	// Getter Setter  => lombok 라이브러리 사용하면 어노테이션에 처리됨.
	public int getReno() {
		return reno;
	}
	public void setReno(int reno) {
		this.reno = reno;
	}
	public String getRewriter() {
		return rewriter;
	}
	public void setRewriter(String rewriter) {
		this.rewriter = rewriter;
	}
	public String getRememo() {
		return rememo;
	}
	public void setRememo(String rememo) {
		this.rememo = rememo;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	@Override
	public String toString() {
		return "BoardReply [reno=" + reno + ", rewriter=" + rewriter + ", rememo=" + rememo + ", redate=" + redate
				+ ", bno=" + bno + "]";
	}
}
