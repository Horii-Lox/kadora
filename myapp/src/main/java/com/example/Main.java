package com.example;

public class Main {
    public static void main(String[] args) {
        UserRepository repo = new InMemoryUserRepository();
        UserService service = new UserService(repo);

        System.out.println(service.buildGreeting(1));  // ようこそ、太郎 さん！
        System.out.println(service.buildGreeting(99)); // ユーザーが見つかりません
    }
}