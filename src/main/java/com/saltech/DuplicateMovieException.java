package com.saltech;

public class DuplicateMovieException extends RuntimeException {
    public DuplicateMovieException(String name) {
        super(name);
    }
}
