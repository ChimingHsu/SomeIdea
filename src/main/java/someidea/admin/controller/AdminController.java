package someidea.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import someidea.user.service.UserService;


@Tag(name = "管理者專用", description = "使用者相關API")
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService userService;
	
    @Operation(
    		summary = "取得所有使用者",
    		description ="取得所有代辦事項列表")
    @ApiResponses(value = {
            @ApiResponse(responseCode="401",description="沒有權限"),
            @ApiResponse(responseCode="404",description="找不到路徑")})
	@GetMapping("/users")
	public String allUsers() {
		try {
			return userService.allUsers();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Query users fails";
	}
    
	@PostMapping("/user")
	public String userCreate(@RequestBody String jsonString) {
		return userService.createUser(jsonString);
	}
	
	@PostMapping("/user-group")
	public String setUserGroup(@RequestBody String jsonString) {
		return userService.setUserGroup(jsonString);
	}
    
	@PostMapping("/group")
    public String createUserGroup(@RequestBody String jsonString) {
		try {
			return userService.createUserGroup(jsonString);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Query users fails";
    	
    }
	
}
