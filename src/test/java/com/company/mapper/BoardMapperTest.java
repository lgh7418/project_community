package com.company.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.config.RootConfig;
import com.company.domain.BoardVO;
import com.company.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class BoardMapperTest {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	//@Test
/*	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}*/
	
	//@Test
	public void testPaging() {
	    Criteria cri = new Criteria();
	    // 한 페이지당 10개씩 출력, 3페이지에 해당하는 데이터
	    cri.setPageNum(3);
	    cri.setAmount(10);
	    List<BoardVO> list = mapper.getListWithPaging(cri);
	    list.forEach(board -> log.info(board.getBno()));
	}
	
	//@Test
	public void testInsert() {

		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insert(board);

		// lombok의 toString()을 이용해서 bno값을 알아보기 위함(bno=null) 
		log.info(board);
	}
	
	//@Test
	public void testInsertDumy() {
		for(int i=1; i<200; i++) {
			BoardVO board = new BoardVO();
			board.setTitle("테스트 글 " + i);
			board.setContent("테스트 글 " + i + "입니다.");
			board.setWriter("newbie");
			mapper.insert(board);
		}
	}
	
	//@Test
	public void testInsertSelectKey() {

		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 select key");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("newbie");

		// 서브 쿼리인 select seq_board.nextval from dual가 먼저 실행되고 bno 값이 board에 저장됨(bno=22) 
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	//@Test
	public void testRead() {

		// 존재하는 게시물 번호로 테스트
		BoardVO board = mapper.read(22L);

		log.info(board);
	}
	
	//@Test
	public void testDelete() {
		
		// 정상적으로 삭제되면 1이 출력(그 외는 0 출력)
		log.info("DELETE COUNT: " + mapper.delete(21L));
	}
	
	//@Test
	public void testUpdate() {

		BoardVO board = new BoardVO();
		board.setBno(22L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");

		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);

	}
	
	 @Test
	  public void testSearch() {

	    Criteria cri = new Criteria();
	    cri.setKeyword("수정된");
	    cri.setType("TCW");

	    List<BoardVO> list = mapper.getListWithPaging(cri);

	    list.forEach(board -> log.info(board));
	  }
}
