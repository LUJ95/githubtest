package kr.co.dong.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Inject
	private SqlSession sqlSession;
	
	private static final String nameSpace="kr.co.dong.boardMapper";
	
	@Override
	public Map login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace +".login",map);
	}
	//기존 list
	/*
	 * @Override public List<BoardDTO> list() { // TODO Auto-generated method stub
	 * return sqlSession.selectList(nameSpace +".list"); }
	 */
	
	@Override
	public int register(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace+".register", boardDTO);
	}

	@Override
	public int updateReadCnt(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace+".updateReadCnt", bno);
	}

	@Override
	public BoardDTO getDetail(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".detail", bno);
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace + ".delete", bno);
	}

	@Override
	public int update(BoardDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace + ".update",dto);
	}

	@Override
	public int reply(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return sqlSession.insert(nameSpace + ".reply", boardReply);
	}

	@Override
	public List<BoardReply> getDetail1(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".detail1", bno);
	}

	@Override
	public BoardReply detailreply(int reno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".detailReply", reno);
	}

	@Override
	public int replyupdate(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return sqlSession.update(nameSpace + ".replyupdate",boardReply);
	}

	@Override
	public int replyDelete(int reno) {
		// TODO Auto-generated method stub
		return sqlSession.delete(nameSpace + ".replyDelete", reno);
	}

	@Override
	public int totalRecord() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace+".totalRecord");
	}

	@Override
	public List<BoardDTO> listBoard(int start, int pageSIZE) {
		// TODO Auto-generated method stub
		HashMap<String , Integer>map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("pageSIZE", pageSIZE);
		
		return sqlSession.selectList(nameSpace+".findAll",map);
	}

}
