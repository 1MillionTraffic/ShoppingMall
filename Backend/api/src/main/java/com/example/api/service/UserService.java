package com.example.api.service;

import com.example.domain.user.User;
import com.example.mysql.repository.user.reader.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserReader userReader;

    public User getUser(Long id){
        return userReader.findById(id);
    }


}
