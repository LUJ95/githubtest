/* emp테이블에 관련된 기능을 작성
 * 1. 테이블의 인원수를 구하기
 * 2. 전체조회
 * 3. 선택된 사원정보 조회
 * 4. 선택된 글 조회수 증가(X)
 * ...
 */
package kr.co.dong.emp;

import java.util.List;

public interface EmpDAO {
	public int empCount() throws Exception;
	
	public List<EmpVO> listAll() throws Exception;
	
	public EmpVO selectEmp(int empno) throws Exception;
	
}
