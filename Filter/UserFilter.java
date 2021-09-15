package granguil.data.Filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import granguil.data.service.UserService;

@Component
@Order(1)
public class UserFilter implements Filter{
	private UserService us;
	
	public UserFilter(UserService userService) {
		this.us=userService;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
	
	HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse res = (HttpServletResponse) response;
    
    if (req.getMethod().equals("OPTIONS")) {
        String reqOrigin;
        reqOrigin = req.getHeader("Origin");
        res.setHeader("Access-Control-Allow-Origin", reqOrigin);
        

        String reqMethod;
        reqMethod = req.getHeader("Access-Control-Request-Method");
        res.setHeader("Access-Control-Allow-Method", reqMethod);
            

        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Headers", "cache-control,if-modified-since,pragma,Content-Type,X-Auth-Token,role,pseudo");

        //Checks if Allow-Method and Allow-Origin got set. 200 OK if both are set.
        if(!res.getHeader("Access-Control-Allow-Method").equals("") && !res.getHeader("Access-Control-Allow-Origin").equals("")){
            res.setStatus(200);
        }
    }else{
    try{
    String token=req.getHeader("x-auth-token");
    String pseudo=req.getHeader("pseudo");
    UUID role=UUID.fromString(req.getHeader("role"));
    if(us.isAuthenticated(pseudo, role, token)) {
    	filterChain.doFilter(request, response);
    }else {
    	res.setHeader("Access-Control-Allow-Origin", "*");
    	res.getWriter().append("Forbidden Path");
    	return;
    }
    }catch(Exception e) {
    	res.setHeader("Access-Control-Allow-Origin", "*");
    	res.getWriter().append(e.getMessage());
    	return;
    }
    
	}
	}
}
