/* DAO호출
 * 글 읽기 : DAO 글읽기와 DAO 조회수 증가를 실행
 * 
 */
package kr.co.dong.emp;

import java.util.List;

public interface EmpService {
	public int empCount() throws Exception;
	
	public List<EmpVO> listAll() throws Exception;
	
	public EmpVO selectEmp(int empno) throws Exception;

}
