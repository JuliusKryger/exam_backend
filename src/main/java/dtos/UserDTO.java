package dtos;

import entities.Role;
import entities.User;

import java.util.List;

public class UserDTO {

    private String userName;
    private String userPass;
    private List<Role> roleList;

    public UserDTO() {
    }

    public UserDTO(User entity) {
        this.userName = entity.getUserName();
        this.userPass = entity.getUserPass();
        //this.roleList = entity.getRoleList();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}
