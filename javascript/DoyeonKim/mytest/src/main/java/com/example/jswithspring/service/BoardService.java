package com.example.jswithspring.service;

import com.example.jswithspring.entity.Board;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardService {
    public void register(Board board) throws Exception;

    public List<Board> list() throws Exception;

    //read를 통해 보드를 얻어옴
    public Board read(Integer boardNo) throws Exception;

    public void remove(Integer boardNo) throws Exception;
}