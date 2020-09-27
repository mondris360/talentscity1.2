package com.talentscity.com.Controllers;

import com.talentscity.com.Entities.User;
import com.talentscity.com.Services.ServiceImpl.UserServiceImpl;
import com.talentscity.com.dto.SignUpDTO;
import com.talentscity.com.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import util.HashPassword;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigInteger;

@Controller
public class SignUpController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @GetMapping("/signup")
    public String showSignUpPage(){
        return "signup";
    }


    @PostMapping("/signup")
    // method to handle signup post route
    public String createNewUser(@Valid SignUpDTO newUser, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpSession httpSession){
         // create a session
        HttpSession session =  request.getSession();
        if (!newUser.getPassword().equals(newUser.getConfirmPass())){
            redirectAttributes.addFlashAttribute("error", "Password And ConfirmPass Must Be Thesame");
            return "redirect:/signup";

        } else if (newUser.getPassword().length() < 8){
            redirectAttributes.addFlashAttribute("error", "Password Must Be More than 8 characters");
            return "redirect:/signup";
        }
        // encrypt the user password
        String encryptedPassword = HashPassword.encryptPassword(newUser.getPassword());
        User user = new User(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), encryptedPassword);
        // if the user is a new user That Logged in with Oauth
        if (session.getAttribute("oAuthID")!= null){
            String userOauthID = (String) session.getAttribute("oAuthID");
            user.setOauthUserId(userOauthID);
            System.out.println("New User" +  user);
        }

        // create the user
        User createdUser =  userServiceImpl.createUser(user);

        if (createdUser == null){
            redirectAttributes.addFlashAttribute("error", "A User With That Email Already Exists");
            return "redirect:/signup";
        }

        // create a user DTO
        UserDTO  userDTO =  new UserDTO(createdUser.getUserID(),createdUser.getFirstName(),createdUser.getLastName(),createdUser.getEmail());
        // save the user ID in the session
        session.setAttribute("user",userDTO);
        return "redirect:/dashboard";
    }
}
