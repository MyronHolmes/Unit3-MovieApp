package com.devmountain.unit3.springmvc;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovieController {

    private final BestMovieService bestMovieService;

    public MovieController(BestMovieService bestMovieService) {
        this.bestMovieService = bestMovieService;
    }

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

}
