package com.example.konul.dto;

import lombok.*;
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class UserDTO {
    @NonNull
    private String user_name;
    @NonNull
    private String first_name;
    @NonNull
    private String last_name;
    @NonNull
    private String email;

//    public UserDTO() {
//    }
//
//    public String getUsername() {
//        return user_name;
//    }
//    public void setUsername(String username) {
//        this.user_name = username;
//    }
//
//    public String getFirstName() {
//        return first_name;
//    }
//    public void setFirstName(String firstName) {
//        this.first_name = firstName;
//    }
//
//    public String getLastName() {
//        return last_name;
//    }
//    public void setLastName(String lastName) {
//        this.last_name = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }

}
