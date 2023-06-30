package com.devmountain.unit3.springmvc;

import com.devmountain.unit3.springmvc.model.MovieEntity;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.persistence.Persistence;

@Controller
public class MovieController {

    @Autowired
    private BestMovieService bestMovieService;

    @Autowired
    private SessionFactory sessionFactory;



    @RequestMapping({"/", ""})
    public String getIndexPage(){
       return "index";
    }

    @RequestMapping("/bestMovie")
    public String getBestMoviePage(Model model){
        model.addAttribute("BestMovie", bestMovieService.getBestMovie().getTitle());
        return "bestMovie";
    }

    @RequestMapping("/voteForTheBestMovieForm")
    public String voteForBestMoviePage(){
        return "voteForTheBestMovie";
    }

    @RequestMapping("/voteForTheBestMovie")
    public String voteForBestMovie(HttpServletRequest request, Model model){

        String movieTitle = request.getParameter("movieTitle");

        model.addAttribute("BestMovieVote", movieTitle);
        return "voteForTheBestMovie";
    };



    @RequestMapping("/addMovieForm")
    public String addMovieForm(){
        return "addMovie";
    }

    @RequestMapping("/addMovie")
    public String addMovie(HttpServletRequest httpServletRequest){
        String movieTitle = httpServletRequest.getParameter("movieTitle");
        String maturityRating = httpServletRequest.getParameter("maturityRating");
        String genre = httpServletRequest.getParameter("genre");

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(movieTitle);
        movieEntity.setMaturityRating(maturityRating);
        movieEntity.setGenre(genre);

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(movieEntity);
        session.getTransaction().commit();

        return "addMovie";
    }
}
