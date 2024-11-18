/* 1) Mybatis를 담당
 * ---->SqlSession 사용
 * 
 * 2) @Repository
 * 
 */
package kr.co.dong.emp;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class EmpDAOImpl implements EmpDAO{
	@Inject  // @Autowired
	private SqlSession sqlSession;
	
	private static final String nameSpace = "empMapper";
	
	@Override
	public int empCount() throws Exception {
		// 전체수 구하기
		return sqlSession.selectOne(nameSpace + ".cnt");
	}

	@Override
	public List<EmpVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpVO selectEmp(int empno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
