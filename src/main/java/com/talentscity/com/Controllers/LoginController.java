package com.talentscity.com.Controllers;

import com.talentscity.com.Entities.User;
import com.talentscity.com.Services.ServiceImpl.UserServiceImpl;
import com.talentscity.com.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigInteger;
import java.security.Principal;

@Controller
public class LoginController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/login")
    public String showLoginPage(Principal principal){
        if (principal != null){
            return "redirect:/dashboard";
        }
        // login
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("principal" +  principal.);
//        System.out.println("principal == " +  principal.toString());
        return "login";
    }


//    @PostMapping("/login")
//    public String Login(@Valid User user, Model model, HttpServletRequest request){
//        // get user record from the db
//        System.out.println("=========================" +  user);
//        User getUser =  userServiceImpl.login(user);
//        if (getUser == null){
//            model.addAttribute("error", "Invalid Email Or Password");
//            return "login";
//        }
//        // create a http session
//        HttpSession session =  request.getSession();
//        // create a user DTO
//        UserDTO userDTO =  new UserDTO(getUser.getUserID(),getUser.getFirstName(), getUser.getLastName(), getUser.getEmail());
//
//        Authentication newPrincipal =  new UsernamePasswordAuthenticationToken(getUser,getUser);
////        newPrincipal.getPrincipal();
//        SecurityContextHolder.getContext().setAuthentication(newPrincipal);
//        System.out.println("Updated Principal================================" + request.getUserPrincipal().getName());
//        // save the user object in the session
//        session.setAttribute("user", userDTO);
//        // check if there is a specific page the user should be redirected back to after login inorder to complete an operation
//        if (session.getAttribute("goto") != null) {
//             // send the user back to the page he was so that he can complete his operation
//            String gotoPage = (String) session.getAttribute("goto");
//            return "redirect:/" +  gotoPage;
//        }
//
//        return "redirect:/dashboard";
//    }

    // display invalid login
    @GetMapping("/invalidlogin")
    public String showInvalidLogin(){
        return "invalidlogin";
    }
}
