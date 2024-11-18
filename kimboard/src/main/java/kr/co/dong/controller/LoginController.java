package kr.co.dong.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dong.domain.LoginVO;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="login/loginForm",method= RequestMethod.GET)
	public ModelAndView loginForm() {
		logger.info("로그인 폼 처리화면입니다.");
		ModelAndView mav = new ModelAndView();
		mav.addObject("test","test modle");
		mav.setViewName("login/loginForm");
		return mav;
	}
	
	//requst한 파라미터를 전달받는 방법1
	@RequestMapping(value="login/login1", method= RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		String userID = request.getParameter("userID");
		String name = request.getParameter("name");
		
		//요청 데이터를 view에 전달해보기  (DB X)
		ModelAndView mav = new ModelAndView();
		mav.addObject("userID", userID);
		mav.addObject("name", name);
		mav.setViewName("login/result");
		
		return mav;
	}
	
	//requst한 파라미터를 전달받는 방법2
	@RequestMapping(value="login/login2",method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login2(@RequestParam("userID") String userID,
			@RequestParam("name") String name,
			HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");

		ModelAndView mav = new ModelAndView();
		mav.addObject("userID", userID);
		mav.addObject("name", name);
		mav.setViewName("login/result");
		
		return mav;
	}
	//requst한 파라미터를 전달받는 방법3
	//@RequestParam Map<>
	@RequestMapping(value = "login/login3", method = RequestMethod.POST)
	public ModelAndView login3(@RequestParam Map<String,String> info, HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		logger.info("아이디 :" + info.get("userID"));
		logger.info("이름 :" + info.get("name"));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("info", info);
		mav.setViewName("login/result");
		return mav;
	}
	@RequestMapping(value = "login/login4", method = RequestMethod.POST)
//	public ModelAndView login4(LoginVO loginvo, HttpServletRequest request) throws Exception{
	public ModelAndView login4(@ModelAttribute("info")LoginVO loginVo, HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		ModelAndView mav = new ModelAndView();
//		mav.addObject("info", loginvo);
		mav.setViewName("login/result");
		return mav;
	}
	
	@RequestMapping(value = "login/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	// 1. redirect
	// 새로고침을 했을때 이전 요청이 다시 발생하지 않게 하도록 한다.
	// 2. forward
	// 새로고침을 했을때 이전 요청을 다시 발생시켜도 된다면
}






