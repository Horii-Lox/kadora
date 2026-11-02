package com.example;

import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private final Map<Long, String> users = Map.of(
        1L, "太郎",
        2L, "花子"
    );

    @Override
    public String getUsernameById(long id) {
        return users.get(id);
    }

    @Override
    public boolean existsById(long id) {
        return users.containsKey(id);
    }
}