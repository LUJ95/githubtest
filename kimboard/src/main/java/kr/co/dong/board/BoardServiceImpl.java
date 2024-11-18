package kr.co.dong.board;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
	private BoardDAO boardDAO; 
	
	@Override
	public Map login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDAO.login(map);
	}
	//기존 list
	/*
	 * @Override public List<BoardDTO> list() { // TODO Auto-generated method stub
	 * return boardDAO.list(); }
	 */

	@Override
	public int updateReadCnt(int bno) {
		// TODO Auto-generated method stub
		return boardDAO.updateReadCnt(bno);
	}

	@Override
	public BoardDTO getDetail(int bno) {
		// TODO Auto-generated method stub
		return boardDAO.getDetail(bno);
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return boardDAO.delete(bno);
	}

	@Override
	public int register(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return boardDAO.register(boardDTO);
	}
	@Override
	public int update(BoardDTO dto) {
		// TODO Auto-generated method stub
		return boardDAO.update(dto);
	}

	@Override
	public int reply(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return boardDAO.reply(boardReply);
	}

	@Override
	public List<BoardReply> getDetail1(int bno) {
		// TODO Auto-generated method stub
		return boardDAO.getDetail1(bno);
	}

	@Override
	public BoardReply detailreply(int reno) {
		// TODO Auto-generated method stub
		return boardDAO.detailreply(reno);
	}

	@Override
	public int replyupdate(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return boardDAO.replyupdate(boardReply);
	}

	@Override
	public int replyDelete(int reno) {
		// TODO Auto-generated method stub
		return boardDAO.replyDelete(reno);
	}

	@Override
	public int getRead(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int totalRecord() {
		// TODO Auto-generated method stub
		return boardDAO.totalRecord();
	}

	@Override
	public List<BoardDTO> listBoard(int start, int pageSIZE) {
		// TODO Auto-generated method stub
		return boardDAO.listBoard(start, pageSIZE);
	}
	
	

}
