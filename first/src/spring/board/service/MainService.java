package spring.board.service;

import java.math.BigDecimal;
import java.util.List;
import spring.board.dto.boardDto;

public interface MainService {
 
 //게시판 상세보기
 public boardDto getBoard(BigDecimal b_no) throws Exception;
 
 //게시판 리스트
 public List<boardDto> getBoardList(boardDto BoardDto) throws Exception;
 
 //입력
 public int insertBoard(boardDto BoardDto) throws Exception;
 
 //수정
 public void updateBoard(boardDto BoardDto)  throws Exception;
 
 //리플
 public int insertReplyBoard(boardDto BoardDto) throws Exception;
}

