package com.example.miniProject.service;

import com.example.miniProject.entity.Board;

import java.util.List;

public interface BoardService {
    public void register(Board board) throws Exception;

    public List<Board> list() throws Exception;

    public Board read(Integer boardNo) throws Exception;

    public void remove(Integer boardNo) throws Exception;

    public void modify(Board board) throws Exception;
}

