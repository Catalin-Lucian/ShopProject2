package com.example.shopproject.Controller;

import com.example.shopproject.Model.User;
import com.example.shopproject.Service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/security")
public class SecurityController {


    private final UserService userService;

    public SecurityController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signIn")
    public ResponseEntity<String> signIn(@RequestParam("username") final String username, @RequestParam("password") final String password){
        String token= userService.signIn(username,password);
        if(StringUtils.isEmpty(token)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(token);
    }

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestParam("username") final String username, @RequestParam("password") final String password){
        String token= userService.signUp(username,password);
        if(StringUtils.isEmpty(token)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(token);
    }

//    @GetMapping(value = "/user/id/{id}")
//    public ResponseEntity<User> getUserDetailById(@PathVariable Long id){
//        var user = userService.findById(id);
//        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @GetMapping(value = "/user/token/{token}")
    public ResponseEntity<User> getUserDetailByToken(@PathVariable String token){
        var user = userService.findByToken(token);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



}
