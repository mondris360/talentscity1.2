package com.talentscity.com.Controllers;

import com.talentscity.com.Entities.User;
import com.talentscity.com.Services.ServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.Principal;

@Controller
public class DashboardController {
    @Autowired
    UserServiceImpl userServiceImpl;
    @GetMapping("/dashboard")
    public String showDashboard(HttpServletRequest request, RedirectAttributes redirectAttributes, HttpSession session){
        Principal principal =   request.getUserPrincipal();
        // if the user  just logged via Oauth
        if (!principal.getName().contains("@")){
            String userOauthID =  principal.getName();
            // check if the user has already completed his or  her profile
            User getUser =  userServiceImpl.findUserByOauthID(userOauthID);
            System.out.println("userOauthID" + userOauthID);
            System.out.println("======= user by oauthid" +  getUser);
            if (getUser ==  null){
                redirectAttributes.addFlashAttribute("error", "Please Complete Your SignUp");
                // store the user session ID
                session.setAttribute("oAuthID", userOauthID);
                return "redirect:/signup";
            }
        }
//        User getUser =  userServiceImpl.findUserEmail("justmondris@gmail.com");
////        Long userID = new Long(principal.getName());
////        Authentication newPrincipal =  new UsernamePasswordAuthenticationToken(getUser,getUser);
//////        newPrincipal.getPrincipal();
////        SecurityContextHolder.getContext().setAuthentication(newPrincipal);
//        System.out.println("Updated Principal" + request.getUserPrincipal().getName());

        return "dashboard";
    }
}
