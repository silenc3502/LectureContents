package com.example.demo.repository;

import com.example.demo.entity.ArtworkPurchaseBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ArtworkPurchaseRepository {

    @Autowired
    private JdbcTemplate PurchaseJdbcTemplate;

    public void drawingPurchaseCreate(ArtworkPurchaseBoard artworkPurchaseBoard) {
        String DrawingPurchaseBoardQuery = "insert into artworkPurchaseBoard(product_no, price, title, content, writer, createDate) values(?, ?, ?, ?, ?, ?)";
    }

    //  미완 create처리
}
