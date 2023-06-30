package com.devmountain.unit3.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BestMovieService {
    private final Movie movie;

    public BestMovieService(@Qualifier("titanicMovie") Movie movie) {
        this.movie = movie;
    }

    public Movie getBestMovie(){
        return movie;

    }
}
