package com.example;

public interface UserRepository {
    String getUsernameById(long id);
    boolean existsById(long id);
}