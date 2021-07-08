package com.example.Project.service;

import com.example.Project.entity.Board;

import java.util.List;

public interface BoardService {

    public void B_register(Board board) throws Exception;

    public Board read(Integer boardNo) throws Exception;

    public List<Board> list() throws Exception;
}
