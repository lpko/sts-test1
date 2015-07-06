package spring.board.dao;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import spring.board.dto.boardDto;
import org.mybatis.spring.support.SqlSessionDaoSupport;



public  class MainDaoImpl extends SqlSessionDaoSupport implements MainDao {
	
	 private static Logger logger = Logger.getLogger(MainDaoImpl.class);

	 
	@Override
	 public List<boardDto> getBoardList(boardDto BoardDto) throws Exception {
	  // TODO Auto-generated method stub
	  return  getSqlSession().selectList("newboard.getBoardList",BoardDto);
	 }

	 @Override
	 public int insertBoard(boardDto BoardDto) throws Exception {
	  // TODO Auto-generated method stub
	  logger.info("insertBoard invoked...");
	  getSqlSession().insert("newboard.insertBoard", BoardDto);
	  int b_no = BoardDto.getB_no().intValue();
	  return b_no;
	 }
	 
	 @Override
	 public  boardDto getBoard(BigDecimal b_no) throws Exception {
	  // TODO Auto-generated method stub  
	  return (boardDto)getSqlSession().selectOne("newboard.getBoard", b_no);
	 }
	 
	 @Override
	 public void updateBoard(boardDto BoardDto)  throws Exception {
	  getSqlSession().update("newboard.updateBoard", BoardDto);
	 }
	 
	 @Override
	 public int getRefMax()  throws Exception {
	  return Integer.parseInt(getSqlSession().selectOne("newboard.getRefMax").toString());
	 }
	 
	 @Override
	 public void updateCommunitySetp(boardDto BoardDto)  throws Exception {
	  getSqlSession().update("newboard.updateCommunitySetp",BoardDto);
	 }
	 
	 @Override
	 public int  getStepMax(boardDto BoardDto)  throws Exception {
	  return Integer.parseInt(getSqlSession().selectOne("newboard.getStepMax",BoardDto).toString());
	 }
	 
	 //¸®ÇÃ
	 @Override
	 public int insertReplyBoard(boardDto BoardDto) throws Exception {
	  logger.info("insertReplyBoard invoked...");
	  getSqlSession().insert("newboard.insertReplyBoard", BoardDto);
	  int b_no = BoardDto.getB_no().intValue();
	  return b_no;  
	 }
	
	
}

