package com.example.readhaven.utils;

import java.util.UUID;

public class LibraryUtils {
    public static UUID generateUserId() {
        return UUID.randomUUID();
    }

    public static UUID generateBookId() {
        return UUID.randomUUID();
    }
}
