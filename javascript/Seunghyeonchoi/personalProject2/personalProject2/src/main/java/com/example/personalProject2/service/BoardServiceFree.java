package com.example.personalProject2.service;

import com.example.personalProject2.entity.BoardFree;

import java.util.List;

public interface BoardServiceFree{
    public void registerFree(BoardFree boardFree) throws Exception;
    public List<BoardFree> listFree() throws Exception;

    public BoardFree read(Integer boardNoFree) throws Exception;
    public void remove(Integer boardNoFree) throws Exception;
}
