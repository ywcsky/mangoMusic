package com.kh.mango.user.domain;

import lombok.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mypage {

    private int userNo;
    private String userId;
    private String userPw;
    private String userName;
    private String userEmail;
    private String userGender;
    private int userType;
    private Timestamp userDate;
    private String userFilename;
    private String userFilepath;
    private String userProfileLetter;
    private int pointVal;
}
