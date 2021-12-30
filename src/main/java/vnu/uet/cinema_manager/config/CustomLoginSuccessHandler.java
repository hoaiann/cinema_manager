package vnu.uet.cinema_manager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import vnu.uet.cinema_manager.service.AdminService;
import vnu.uet.cinema_manager.service.CustomerService;
import vnu.uet.cinema_manager.service.UserService;
import vnu.uet.cinema_manager.utils.JwtUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Configuration
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    public static String sessionFullName;
    public static String sessionUsername;

    @Autowired
    private JwtUtil jwtTokenUtil;

    private String jwt;

//    private AdminService adminService;
//
//    @Autowired
//    public void setAdminService(AdminService adminService){
//        this.adminService= adminService;
//    }
//
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    private CustomerService customerService;
//
//    @Autowired
//    public void setCustomerService(CustomerService customerService) {
//        this.customerService = customerService;
//    }

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            return;
        }

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        jwt = jwtTokenUtil.generateToken(userDetails);
//        System.out.println(jwt);

//        String fullName = "";
//
//        String username = userDetails.getUsername();
//
//        if (Objects.requireNonNull(userService.findByUsername(username)).getRoles().equals("ROLE_ADMIN")) {
//            fullName = adminService.getFullNameByUsername(username);
//        } else if (Objects.requireNonNull(userService.findByUsername(username)).getRoles().equals("ROLE_CUSTOMER")) {
//            fullName = customerService.getFullNameByUsername(username);
//        }
//
//        sessionFullName=fullName;
//        sessionUsername= username;
//
//        HttpSession session= request.getSession();
//        session.setAttribute("username", username);
//        session.setAttribute("fullName", fullName);

        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }


    protected String determineTargetUrl(Authentication authentication) {
        String url = "login?error=true";
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();

        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        }

        if (roles.contains("ROLE_ADMIN")) {
            url = "/admin/manager/film";
        } else if (roles.contains("ROLE_CUSTOMER")) {
            url = "/customer";
        }else if(roles.contains("ROLE_EMPLOYEE")){
            url = "/admin/manager/filmCalendar";
        }
        return url;
    }


}
