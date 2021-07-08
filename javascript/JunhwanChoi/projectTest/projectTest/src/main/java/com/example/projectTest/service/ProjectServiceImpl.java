package com.example.projectTest.service;

import com.example.projectTest.controller.ProjectController;
import com.example.projectTest.entity.Project;
import com.example.projectTest.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository repository;
    @Autowired
    private ProjectController controllerRepo;

    @Override
    public void register(Project project) {
        repository.create(project);
    }

    @Override
    public List<Project> list() throws Exception {
        return repository.list();
    }

    @Override
    public Project read(Integer signupNo) throws Exception {
        return repository.read(signupNo);
    }

    @Override
    public void remove(Integer signupNo) throws Exception {
        repository.delete(signupNo);
    }

    @Override
    public void modify(Project project) throws Exception {
        repository.update(project);
    }

    @Override
    public void login(Project project) throws Exception {
        repository.login(project);
    }
}