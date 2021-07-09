package com.example.jsmain.service;

import com.example.jsmain.entity.Board;
import com.example.jsmain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BoardService {
    public void register(Board board) throws Exception;

    public List<Board> list() throws Exception;

    public Board read(Integer boardNo) throws Exception;

    public void remove (Integer boardNo) throws Exception;

    public void modify(Board board) throws Exception;

}
