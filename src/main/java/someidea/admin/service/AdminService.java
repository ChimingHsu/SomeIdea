package someidea.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import someidea.xepdb.entity.AuthPageEntity;
import someidea.xepdb.reposotory.AuthPageRep;

@Service
public class AdminService {
	
	@Autowired
	private AuthPageRep authPageRep;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public String queryAllPages() throws JsonProcessingException {
		List<AuthPageEntity> allDatas = authPageRep.findAll();
		
		return objectMapper.writeValueAsString(allDatas);
	}
	
	
	@Transactional(rollbackOn = Exception.class)
	public String createPage(String jsonStr) throws JsonMappingException, JsonProcessingException {
		AuthPageEntity insert = objectMapper.readValue(jsonStr,AuthPageEntity.class);
		authPageRep.saveAndFlush(insert);
		return "Success";
	}
	
	@Transactional(rollbackOn = Exception.class)
	public String updatePage(String jsonStr) throws JsonMappingException, JsonProcessingException {
		AuthPageEntity insert = objectMapper.readValue(jsonStr,AuthPageEntity.class);
		authPageRep.saveAndFlush(insert);
		return "Success";
	}
	
	@Transactional(rollbackOn = Exception.class)
	public String deletePage(String jsonStr) throws JsonMappingException, JsonProcessingException {
		AuthPageEntity insert = objectMapper.readValue(jsonStr,AuthPageEntity.class);
		authPageRep.delete(insert);
		return "Success";
	}
}
