package spring.board.service;

import java.util.List;
import java.util.Map;
import java.math.BigDecimal;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring.board.dto.boardDto;
import spring.board.dao.MainDao;

@Service
public class MainServiceImpl implements MainService {
	private static Logger logger = Logger.getLogger(MainServiceImpl.class);

	
	@Autowired
	private MainDao mainDao;
	

	//게시판 상세보기
	 @Override
	 @Transactional(readOnly=true)
	 public boardDto getBoard(BigDecimal b_no) throws Exception {
	  return this.mainDao.getBoard(b_no);
	 }
	 
	 //게시판 리스트
	 @Override
	 @Transactional(readOnly=true) 
	 public List<boardDto> getBoardList(boardDto BoardDto) throws Exception {
	  return this.mainDao.getBoardList(BoardDto);
	 }
	 
	 //입력
	 @Override
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	 public int insertBoard(boardDto BoardDto) throws Exception {
	  int newref = this.mainDao.getRefMax();
	  BoardDto.setRef(new BigDecimal(newref));
	  return this.mainDao.insertBoard(BoardDto);
	 }
	 
	 //수정
	 @Override
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class}) 
	 public void updateBoard(boardDto BoardDto)  throws Exception {
	  this.mainDao.updateBoard(BoardDto);
	 }
	 
	 //리플
	 @Override
	 @Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})  
	 public int insertReplyBoard(boardDto BoardDto) throws Exception {
	  //순번(step)을 제 세팅한다
	  //같은 ref(최상위부모값)을 가진 것 중 현재 답글을 달 게시물의 순번보다 큰것을 +1로 하며 하나씩 밀리게 한다.
	  this.mainDao.updateCommunitySetp(BoardDto);
	  
	  //현재 답글의 순번을 생성하고 모델에 저장한다.
	  int netstep = this.mainDao.getStepMax(BoardDto);  
	  BoardDto.setStep(new BigDecimal(netstep));
	  
	  //답글 저장
	  return this.mainDao.insertReplyBoard(BoardDto);
	 } 




}
