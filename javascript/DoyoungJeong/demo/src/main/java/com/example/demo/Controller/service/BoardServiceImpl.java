package com.example.demo.Controller.service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

        @Autowired
        private BoardRepository repository;

        @Override
        public void register(Board board) throws Exception {
            repository.create(board);
        }

}
