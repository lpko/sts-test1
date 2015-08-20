package first2.sample.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import first2.common.util.FileUtils;
import first2.sample.dao.SampleDAO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="fileUtils")
    private FileUtils fileUtils;
	
	@Resource(name="sampleDAO")
    private SampleDAO sampleDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		return sampleDAO.selectBoardList(map);	
	}
	
	@Override
	public void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
	    sampleDAO.insertBoard(map);
	     
	    List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(map, request);
        for(int i=0, size=list.size(); i<size; i++){
            sampleDAO.insertFile(list.get(i));
        }
    }
	
	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
	    sampleDAO.updateHitCnt(map);
	    Map<String, Object> resultMap = sampleDAO.selectBoardDetail(map);
	    return resultMap;
	}
	
	@Override
	public void updateBoard(Map<String, Object> map) throws Exception{
	    sampleDAO.updateBoard(map);
	}
	
	@Override
	public void deleteBoard(Map<String, Object> map) throws Exception {
	    sampleDAO.deleteBoard(map);
	}

}
