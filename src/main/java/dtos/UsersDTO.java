package dtos;

import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDTO {

    List<UserDTO> users = new ArrayList<>();

    public UsersDTO(List<User> entity) {
        entity.forEach((user -> {
            users.add(new UserDTO(user));
        }));
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "UsersDTO{" +
                "users=" + users +
                '}';
    }
}