package kr.co.dong;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.ws.RequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/main")
	public String testmain(Model model) {
		String name = "Hello Word~~~";
		model.addAttribute("name", name);//모델에 저장
		return "main";
	}
	
	@RequestMapping(value="/P_main", method = RequestMethod.GET)
	public String testproject(Model model) {
		String name="hello fucking project";
		model.addAttribute("name",name);
		return "P_main";
	}
	@RequestMapping(value="/main2", method = RequestMethod.GET)
	public String testp2(Model model) {
		
		return "main2";
	}

	@RequestMapping(value="/reviewWrite", method = RequestMethod.GET)
	public String testreviewWrite(Model model) {
		
		return "reviewWrite";
	}
	@RequestMapping(value="/myPage", method = RequestMethod.GET)
	public String testmyPage(Model model) {
		
		return "myPage";
	}
	@RequestMapping(value="/myEdit", method = RequestMethod.GET)
	public String testmyEdit(Model model) {
		
		return "myEdit";
	}
	@RequestMapping(value="/orderList", method = RequestMethod.GET)
	public String testorderList(Model model) {
		
		return "orderList";
	}
	@RequestMapping(value="/orderDetail", method = RequestMethod.GET)
	public String testmyorderDetail(Model model) {
		
		return "orderDetail";
	}
	@RequestMapping(value="/reviewWriteV0_2", method = RequestMethod.GET)
	public String testreviewWriteV0_2(Model model) {
		
		return "reviewWriteV0_2";
	}
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String testindex(Model model) {
		
		return "index";
	}
}







