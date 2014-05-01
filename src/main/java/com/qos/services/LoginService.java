package com.qos.services;

import com.qos.models.User;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LoginService {
    
    private static final Map<String, User> users;
    static {
        Map<String, User> u =  new HashMap();
        u.put("admin@test.com", new User("admin@test.com", "admin123", User.Privilege.ADMIN));
        u.put("operator@test.com", new User("operator@test.com", "operator123", User.Privilege.OPERATOR));
        users = Collections.unmodifiableMap(u);
    }
    
    public User login(String email, String password) {
        User u = users.get(email);
        System.out.println(u);
        if(u != null && u.checkPassword(password)) {
            return u;
        }
        return User.anonymous();
    }
    
    public User getUser(String email) {
         return users.get(email);
    }
}
