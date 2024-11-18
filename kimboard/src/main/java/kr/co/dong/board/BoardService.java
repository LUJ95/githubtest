package kr.co.dong.board;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

public interface BoardService {
	//전체목록을 가져오는 메소드
	/* public List<BoardDTO> list(); */
	//페이징 처리 list
	public int totalRecord();
	
	public List<BoardDTO> listBoard(int start,int pageSIZE);
	
	
	
	// 상세보기 처리를 위한 메소드(글읽기)
	public int updateReadCnt(int bno);  //조회수 증가
	public BoardDTO getDetail(int bno);  //getRead(), getView()
	public int getRead(int bno);  //조회수 증가 및 읽기를 처리하는 메소드

	
	// 글추가 insert
	public int register(BoardDTO boardDTO);
	
	// 글삭제
	public int delete(int bno);
	
	// 슬수정
	public int update(BoardDTO boardDTO);
	
	//로그인 처리를 위한 메소드
	public Map login(Map<String, Object> map);
	
	//댓글 쓰기를 위한 메소드
	public int reply(BoardReply boardReply);
	
	// 게시물번호에 해당하는 댓글 조회
	public List<BoardReply> getDetail1(int bno);
	
	// 댓글 수정보기를 위한 메소드
	public BoardReply detailreply(int reno);
	
	// 댓글 수정을 처리하기 위한 메소드
	public int replyupdate(BoardReply boardReply);
	
	// 댓글 삭제를 처리하기 위한 메소드
	public int replyDelete(int reno);

	
	

}
