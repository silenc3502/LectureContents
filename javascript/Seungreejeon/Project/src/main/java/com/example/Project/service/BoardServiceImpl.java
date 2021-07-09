package com.example.Project.service;

import com.example.Project.entity.Board;
import com.example.Project.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository repository;

    @Override
    public void B_register(Board board) throws Exception {
        repository.create(board);
    }

    @Override
    public List<Board> list() throws Exception {
        return repository.list();
    }

    @Override
    public Board read(Integer boardNo) throws Exception {
        return repository.read(boardNo);
    }
}
