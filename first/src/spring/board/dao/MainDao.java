package spring.board.dao;

import java.util.List;
import java.util.Map;
import java.math.BigDecimal;

import spring.board.dto.boardDto;


public interface MainDao  {
	//게시판 상세보기
	 public boardDto getBoard(BigDecimal b_no) throws Exception;
	 
	 //게시판 리스트
	 public List<boardDto> getBoardList(boardDto BoardDto) throws Exception;
	 
	 //입력
	 public int insertBoard(boardDto BoardDto) throws Exception;
	 
	 //수정
	 public void updateBoard(boardDto BoardDto)  throws Exception;
	 
	 //최상위 부모글 번호생성
	 public int getRefMax()  throws Exception;
	 
	 //같은 ref(최상위부모값)을 가진 것 중 현재 답글을 달 게시물의 순번보다 큰것을 +1로 하며 하나씩 밀리게 한다.
	 public void updateCommunitySetp(boardDto BoardDto)  throws Exception;
	 
	 //현재 답글의 순번을 생성 
	 public int  getStepMax(boardDto BoardDto)  throws Exception;
	 
	 //리플저장
	 public int insertReplyBoard(boardDto BoardDto) throws Exception; 
	}

	

