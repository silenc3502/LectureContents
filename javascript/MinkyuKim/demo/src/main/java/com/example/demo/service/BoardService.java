package com.example.demo.service;

import com.example.demo.entity.Board;
import org.springframework.stereotype.Service;


import java.util.List;

// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시한다.
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트 한다.

public interface BoardService {
    public void register(Board board) throws Exception;

    //++ util의 list (알트 엔터)
    public List<Board> list() throws Exception;

    //++32일차(SeventhController)
    public Board read(Integer boardNo) throws Exception;

    public void remove(Integer boardNo) throws Exception;

    public void modify(Board board) throws Exception;
}