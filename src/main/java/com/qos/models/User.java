
package com.qos.models;

public class User {
    
    public enum Privilege {
        ADMIN, OPERATOR, ANONYMOUS
    }
    
    private final String email;
    private final String password;
    private final Privilege privilege;
    
    public User(String email, String password, Privilege privilege) {
        this.email = email;
        this.password = password;
        this.privilege = privilege;
    }
    
    
    public User(String email, Privilege privilege) {
        this(email, null, privilege);
    }

    public String getEmail() {
        return email;
    }

    public Privilege getPrivilege() {
        return privilege;
    }
    
    public Boolean checkPassword(String password) {
        return password.equals(this.password);
    }
    
    public static User anonymous() {
        return new User("", Privilege.ANONYMOUS);
    }
    
    @Override
    public String toString() {
        return email + " is " + privilege;
    }
}
