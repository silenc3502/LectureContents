package com.example.demo.service;


import com.example.demo.entity.Board;
import org.springframework.stereotype.Service;
import java.util.List;
public interface BoardService {
    public void register(Board board) throws Exception;
    public List<Board> list() throws Exception;

    //SeventhController 추가 내용. 게시물 본문 보기 등

    public Board read(Integer boardNo) throws Exception;

    public void remove(Integer boardNo) throws Exception;

    public void modify(Board board) throws Exception;
}