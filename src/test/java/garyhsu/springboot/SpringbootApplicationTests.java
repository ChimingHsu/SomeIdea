package garyhsu.springboot;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import someidea.SomeIdeaApplication;
import someidea.user.service.UserService;
import someidea.xepdb.entity.AuthGroupEntity;
import someidea.xepdb.reposotory.AuthGroupRep;

@SpringBootTest(classes= SomeIdeaApplication.class)
class SpringbootApplicationTests {
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthGroupRep authGroupRep;

//	@Test
	void contextLoads() throws Exception {
		String response = userService.allUsers();
		assertNotNull(response);
		System.out.println(response);
	}
	

	@Test
	void qureyAuthGroup() throws Exception {
		List<AuthGroupEntity> datas = authGroupRep.findAll();
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(objectMapper.writeValueAsString(datas));
	}
	
}
