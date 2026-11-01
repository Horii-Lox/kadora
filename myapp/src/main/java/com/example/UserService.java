package com.example;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String buildGreeting(long userId) {
        if (!repository.existsById(userId)) {
            return "ユーザーが見つかりません";
        }
        String name = repository.getUsernameById(userId);
        return "ようこそ、" + name + " さん！";
    }
}