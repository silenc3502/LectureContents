package com.example.projectTest.service;

import com.example.projectTest.entity.Project;

import java.util.List;

public interface ProjectService {
    public void register(Project project);

    public List<Project> list() throws Exception;

    public Project read(Integer signupNo) throws Exception;

    public void remove(Integer signupNo) throws Exception;

    public void modify(Project project) throws Exception;

    public void login(Project project) throws Exception;

}
