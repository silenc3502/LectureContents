package com.example.personalProject2.service;

import com.example.personalProject2.entity.BoardFree;
import com.example.personalProject2.entity.BoardNotice;

import java.util.List;

public interface BoardServiceNotice {
    public void registerNotice(BoardNotice boardNotice) throws Exception;
    public List<BoardNotice> listNotice() throws Exception;

    public BoardNotice read(Integer boardNoNotice) throws Exception;
    public void remove(Integer boardNoNotice) throws Exception;
}
