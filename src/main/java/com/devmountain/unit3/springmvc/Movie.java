package com.devmountain.unit3.springmvc;

import org.springframework.beans.factory.annotation.Autowired;


public interface Movie {

    public String getTitle();
    public String getMaturityRating();
    public String getGenre();
}
