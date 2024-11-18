package kr.co.dong;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dong.board.BoardDAO;
import kr.co.dong.board.BoardDTO;
//현재 테스트 코드를 실행할 때 스프링이 로딩 되도록 하는 부분.
@RunWith(SpringJUnit4ClassRunner.class)
//속성 경로에 xml파일을 이용해 스프링이 로딩 된다.
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })

public class BoardCreateTest {
    //위에서 스프링이 정상적으로 동작할 경우 스프링이 생성해서 주입해준다.
    //root-context.xml 파일에 <context:component-scan base-package="kr.co.dong" /> 작성해야합니다.
	@Inject
	private BoardDAO boardDAO;
	
	@Test
	public void testInsert() throws Exception{
		BoardDTO boardDTO;
		
		for(int i=1; i<1000;i++) {
			boardDTO = new BoardDTO();
			boardDTO.setTitle("Test title[" + i + "]");
			boardDTO.setContent("Test Content - " +i);
			boardDTO.setId("root");
			
			boardDAO.register(boardDTO); //글쓰기
			
			Thread.sleep(1000); //1초간 잠을 자기			
		}		
	}
}









