package spring.board;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.board.dto.boardDto;
import spring.board.service.MainService;


@Controller
public class BoardController {
	private static Logger logger = Logger.getLogger(BoardController.class);

	@Autowired
	private MainService mainService;
	
	 //리스트
	 @RequestMapping("/newlist.do")
	 public ModelAndView getBoardList() {
	  ModelAndView mav = new ModelAndView();
	  try {
	   boardDto pageModel = new boardDto();
	   pageModel.setPage(1);
	   pageModel.setPageline(10);
	   
	   List<boardDto> newboardList = mainService.getBoardList(pageModel);   
	   mav.addObject("newboardList", newboardList);
	  }catch(Exception e) {
	   e.printStackTrace();
	  }
	  mav.setViewName("/newlist");
	  return mav;
	 }
	 
	 //게시판 내용 보기(b_no 키값이 없으면 리스트페이지로 이동시킨다.)
	 @RequestMapping("/newview.do")
	 public ModelAndView getBoard(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView();
	  try {
	   if(request.getParameter("b_no") != null && !request.getParameter("b_no") .equals("")) {
	    boardDto BoardDto = mainService.getBoard(new BigDecimal(request.getParameter("b_no")));
	    String content = BoardDto.getNewcontents();
	    content = content.replaceAll ("\"", "'");
	    BoardDto.setNewcontents(content);
	    mav.addObject("BoardDto", BoardDto);
	    mav.setViewName("/newview");
	   } else {
	    mav.setViewName("/newlist");
	    response.sendRedirect("/newlist.do");
	   }
	  }catch(Exception e) {
	  } 
	  return mav;
	 }
	 
	 //글쓰기페이지
	 @RequestMapping(value="/newwrite.do", method=RequestMethod.GET)
	 public ModelAndView writeBoard(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView();
	  if(request.getParameter("b_no") != null && !request.getParameter("b_no") .equals("")) {
	   try {  
	    boardDto BoardDto = mainService.getBoard(new BigDecimal(request.getParameter("b_no")));
	    String content = BoardDto.getNewcontents();
	    content = content.replaceAll ("\"", "'");
	    BoardDto.setNewcontents(content);
	    mav.addObject("BoardDto", BoardDto);
	   }catch(Exception e) {
	   
	   }
	  }
	  mav.setViewName("/newwrite");
	  return mav;
	 }
	 
	 //글쓰기 후 저장을 눌렀을 때 실행
	 @RequestMapping(value="/newwrite.do", method=RequestMethod.POST)
	 public void insertBoard(HttpServletRequest request, HttpServletResponse response, boardDto BoardDto, BindingResult errors) {
	  if(errors.hasErrors()) {
	   logger.info("errors..");
	  }  
	  try {  
	   int b_no = 0;   
	   if(request.getParameter("b_no") != null && !request.getParameter("b_no") .equals("")) {    
	    String content = request.getParameter("content");   
	    BoardDto.setNewcontents(content); 
	    b_no = Integer.parseInt(request.getParameter("b_no"));
	    mainService.updateBoard(BoardDto);
	   } else {
	    String content = request.getParameter("content");   
	    BoardDto.setNewcontents(content);
	    b_no = mainService.insertBoard(BoardDto);
	   }
	   response.sendRedirect("/newview.do?b_no="+b_no);
	  }catch(Exception e) {
	   logger.info("insert Fail...");
	   e.printStackTrace();
	  }
	 }
	 
	 //답글쓰기
	 @RequestMapping(value="/newReply.do", method=RequestMethod.GET)
	 public ModelAndView replyBoard(HttpServletRequest request, HttpServletResponse response) {
	  ModelAndView mav = new ModelAndView();
	  if(request.getParameter("b_no") != null && !request.getParameter("b_no") .equals("")) {
	   try {  
	    boardDto BoardDto = mainService.getBoard(new BigDecimal(request.getParameter("b_no")));
	    String content = BoardDto.getNewcontents();
	    content = content.replaceAll ("\"", "'");
	    BoardDto.setNewcontents(content);
	    mav.addObject("BoardDto", BoardDto);
	   }catch(Exception e) {
	   
	   }
	  }
	  mav.setViewName("/newReply");
	  return mav;
	 }
	 
	 //답글쓰기 후 저장을 눌렀을 때 실행
	 @RequestMapping(value="/newReply.do", method=RequestMethod.POST)
	 public void insertReplyBoard(HttpServletRequest request, HttpServletResponse response, boardDto BoardDto, BindingResult errors) {
	  if(errors.hasErrors()) {
	   logger.info("errors..");
	  }  
	  try {  
	   int b_no = 0;   
	   if(request.getParameter("b_no") != null && !request.getParameter("b_no") .equals("")) {    
	    String content = request.getParameter("content");
	    BoardDto.setNewcontents(content);
	    b_no = mainService.insertReplyBoard(BoardDto);
	   }
	   response.sendRedirect("/newview.do?b_no="+b_no);
	  }catch(Exception e) {
	   logger.info("insert Fail...");
	   e.printStackTrace();
	  }
	 } 


	
	
}
