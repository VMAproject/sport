package com.sport.mvc.Controllers.smoll_fintess;

import com.sport.mvc.models.Role;
import com.sport.mvc.models.User;
import com.sport.mvc.services.UserService;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
//@RequestMapping("loginController")
public class LoginController {
	
	@Autowired
	UserService userservice;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
	
	@ResponseBody
	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public Map<String, Object> registration(@RequestBody User user) {
		Map<String, Object> response= new HashMap<String, Object>();
        Role role = new Role();
        role.setId(Long.valueOf(1));

		user.setRole(role);
		user.setIsactive("Y");
		user.setIsnonexpired("Y");
		user.setIsnonlocked("Y");

		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

        Boolean save = userservice.addUser(user);

        if (save) {
			response.put("suceess", true);
	        response.put("message", "Registration Sucess");
			return response;
		}else {
            response.put("error", true);
	        response.put("message", "Registration Failed");
			return response;
		}
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
		return "redirect:/index";
    }

}
