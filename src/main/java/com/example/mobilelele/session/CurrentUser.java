package com.example.mobilelele.session;

import com.example.mobilelele.enums.RoleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class CurrentUser {

    private String name;

    private boolean loggedIn;

    private String email;
    private List<RoleEnum> roles = new ArrayList<>();

    public List<RoleEnum> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnum> roleEnums) {
        this.roles.clear();
        this.roles.addAll(roleEnums);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public boolean isAnonymous() {
        return !isLoggedIn();
    }

    public boolean isAdmin() {
        return this.roles.contains(RoleEnum.ADMIN);
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void clear() {
        email = null;
        name = null;
        loggedIn = false;
        this.roles.clear();
    }
}
