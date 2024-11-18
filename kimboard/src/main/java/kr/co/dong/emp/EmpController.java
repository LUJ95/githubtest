/* 요청한 정보를 매핑.
 * 해당 서비스 호출
 * 결과값을 모델에 저장 후 ,view 리턴 
 * 
 * Controller를 Service를 호출
 * 
 */
package kr.co.dong.emp;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpController {
	@Inject
	private EmpService service;
	
	@RequestMapping(value="/empcount")
	public String empCount(Model model) throws Exception{
		int count = service.empCount();
		model.addAttribute("cnt", count);		
		return "home";
	}
	

}









