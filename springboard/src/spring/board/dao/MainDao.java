package spring.board.dao;

import java.util.List;
import java.util.Map;

import spring.board.vo.Board;

public interface MainDao  {
	public String getToday();
	
	public int writeProc(Map<String, Object> paramMap);
	
	public int writeProc2(Board board);
	
	public List getList(Map<String, Object> paramMap);
	
	public String getUserPwd(String userid);
}
