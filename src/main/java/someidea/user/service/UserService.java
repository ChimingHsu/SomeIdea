package someidea.user.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import someidea.xepdb.entity.AuthGroupEntity;
import someidea.xepdb.entity.AuthUserEntity;
import someidea.xepdb.entity.AuthUserGroupEntity;
import someidea.xepdb.reposotory.AuthGroupRep;
import someidea.xepdb.reposotory.AuthUserGroupRep;
import someidea.xepdb.reposotory.AuthUserRep;

@Service
@Slf4j
public class UserService {
	@Autowired private AuthUserRep userRep;
	@Autowired private AuthUserGroupRep userGroupRep;
	@Autowired private AuthGroupRep groupRep;
	@Autowired private PasswordEncoder passwordEncoder;
	
	
	public String allUsers() throws Exception{
		List<AuthUserEntity> userLsit = userRep.findAll();
		
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(userLsit);
	}
	
	@Transactional
	public String createUserGroup(String json) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(json);
			String groupName = jsonNode.get("groupName").asText();
			String description = jsonNode.get("description").asText("");
			String createUser = jsonNode.get("createUser").asText();
			
			AuthGroupEntity authGroup = new AuthGroupEntity();
			authGroup.setGroupName(groupName);
			authGroup.setCreateUser(createUser);
			authGroup.setCreateDate(new Date());
			authGroup.setDescription(description);
			
			groupRep.saveAndFlush(authGroup);
			
			return "Create Success";
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.error(e.getMessage(), e);
			return e.getMessage();
		}
		
	}
	
	@Transactional
	public String setUserGroup(String json) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(json);
			String createUser = jsonNode.get("createUser").asText();
			String userName = jsonNode.get("userName").asText();
			
			JsonNode groupsNode = jsonNode.get("groupNames");
			if (groupsNode.isArray()) {
				List<AuthUserGroupEntity> insertList = new ArrayList<>();
			    for (JsonNode objNode : groupsNode) {
			    	AuthUserGroupEntity entity = new AuthUserGroupEntity();
			    	entity.setCreateDate(new Date());
			    	entity.setCreateUser(createUser);
			    	entity.setUserName(userName);
			    	entity.setGroupName(objNode.asText());
			    	insertList.add(entity);
			    }
			    
			    userGroupRep.saveAllAndFlush(insertList);
			}else {
				AuthUserGroupEntity userGroup = new AuthUserGroupEntity();
				userGroup.setCreateDate(new Date());
				userGroup.setCreateUser(createUser);
				userGroup.setGroupName("DEFAULT");
				userGroup.setUserName(userName);
				userGroupRep.saveAndFlush(userGroup);
			}
			return "Success";
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			log.error(e.getMessage(),e);
			return e.getMessage();
		}
	}
	
	
	@Transactional
	public String createUser(String json) {
		String returnString;
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(json);
			
			String userName = jsonNode.get("userName").asText();
			String password = jsonNode.get("password").asText();
			String email = jsonNode.get("email").asText();
			
			
			AuthUserEntity user = new AuthUserEntity();
			user.setCreateDate(new Date());
			user.setEmail(email);
			user.setPassword(passwordEncoder.encode(password));
			user.setUserName(userName);
			user.setPswExpiryDays(new BigDecimal(90));
			user.setLocked("N");
			user.setEnabled("Y");
			user.setAccountExpiryDays(new BigDecimal(360));
			userRep.saveAndFlush(user);
						
			returnString = "success";
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			returnString = e.getMessage();
		}
		
		return returnString;
	}
}
