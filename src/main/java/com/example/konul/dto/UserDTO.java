package com.example.konul.dto;

import lombok.*;
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class UserDTO {
    @NonNull
    private String userName;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;

//    public UserDTO() {
//    }
//
//    public String getUsername() {
//        return userName;
//    }
//    public void setUsername(String username) {
//        this.userName = username;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }

}
