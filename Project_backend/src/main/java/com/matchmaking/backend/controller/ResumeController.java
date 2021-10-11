package com.matchmaking.backend.controller;


import com.matchmaking.backend.common.lang.Result;
import com.matchmaking.backend.entity.Post;
import com.matchmaking.backend.entity.Resume;
import com.matchmaking.backend.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/seeker")
public class ResumeController {

    @Autowired
    ResumeService resumeService;

    @PreAuthorize("hasRole('Personal')")
    @PostMapping("/create")
    public Result createResume(@RequestBody Resume resume){
        return   resumeService.createResume(resume);
    }


    @PreAuthorize("hasRole('Personal')")
    @GetMapping("/resume")
    public Result getResume(){
        return  resumeService.getResume();
    }


    @PreAuthorize("hasRole('Personal')")
    @PutMapping("/update")
    public Result updateResume(@RequestBody Resume resume){
        return resumeService.updateResume(resume);
    }


    @PreAuthorize("hasAnyRole('Company')")
    @GetMapping("/all")
    public Result getAllResume(){
        return resumeService.getAllResume();
    }

    @PreAuthorize("hasAnyRole('Personal')")
    @GetMapping("/recommend/all")
    public Result getRecommendPosts(){
        List<Post> postList = resumeService.getAllRecommendPost();
        if (postList != null){
            return Result.success(postList);
        }
        return Result.success("","No Recommendation");
    }

    /**
     * Check if user has resume or not
     * @return boolean
     */
    @PreAuthorize("hasAnyRole('Personal')")
    @GetMapping("/check/resume")
    public Result checkResume(){
        return resumeService.checkResume();
    }


}
