/*Table: board
Columns:
bno int AI PK 
bno varchar(45) 
content varchar(45) 
id varchar(45) 
reddate datetime 
readcnt int 
etc varchar(45)
 * 
 */
package kr.co.dong.board;

public class BoardDTO {
	private int bno;
	private String title;
	private String content;
	private String id;
	private String regdate;
	private int readcnt;
	private String etc;
	private int del;
	
	//페이징 처리 관련 시작
	
	//페이징 처리 관련 끝
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	 //페이징 관련 시작
	
	//페이징 관련 끝ㄴ
	
	
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", content=" + content + ", id=" + id + ", regdate="
				+ regdate + ", readcnt=" + readcnt + ", etc=" + etc + ", del=" + del + "]";
	}
	
	
	

}
