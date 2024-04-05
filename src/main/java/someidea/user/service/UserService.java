package someidea.user.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import someidea.xepdb.entity.AuthUserEntity;
import someidea.xepdb.reposotory.AuthGroupRep;
import someidea.xepdb.reposotory.AuthUserGroupRep;
import someidea.xepdb.reposotory.AuthUserRep;

@Service
public class UserService {
	@Autowired private AuthUserRep userRep;
	@Autowired private AuthUserGroupRep userGroupRep;
	@Autowired private AuthGroupRep groupRep;
	@Autowired private PasswordEncoder passwordEncoder;
	
	@Transactional
	public String createUser(String json) {
		String returnString;
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(json);
			String userNo = jsonNode.get("userNo").asText();
			String userName = jsonNode.get("userName").asText();
			String password = jsonNode.get("password").asText();
			String email = jsonNode.get("email").asText();
			
			AuthUserEntity user = new AuthUserEntity();
			user.setCreateDate(new Date());
			user.setEmail(email);
			user.setPassword(passwordEncoder.encode(password));
			user.setUserName(userName);
			user.setUserNo(userNo);
			user.setStatus(new BigDecimal(1));
			user.setPswExpiryDays(new BigDecimal(90));
			userRep.saveAndFlush(user);
			
			returnString = "success";
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			returnString = e.getMessage();
		}
		
		return returnString;
	}
}
