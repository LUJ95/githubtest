/*
 * Service는 DAO호출을 담당
 * 1) @Service
 */
package kr.co.dong.emp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService{
	@Inject
	private EmpDAO dao;
	
	@Override
	public int empCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.empCount();
	}

	@Override
	public List<EmpVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public EmpVO selectEmp(int empno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
