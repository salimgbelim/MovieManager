package com.saltech;

public class NoMovieFoundException extends RuntimeException {
    public NoMovieFoundException(String message){
        super(message);
    }
}
