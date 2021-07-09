package com.example.demo.service;

import com.example.demo.entity.PurchaseMember;
import com.example.demo.repository.PurchaseMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Service는 여기서 register가 여러 방식으로 동작할 수 있음을 명시한다.
// 또한 Controller의 Autowired에 자동으로 연결되도록 서포트한다.
@Service
public class PurchaseMemberServiceImpl implements PurchaseMemberService {

    @Autowired
    private PurchaseMemberRepository PurchaseMemberRepository;



    @Override
    public void PurchaseMember(PurchaseMember purchaseMember) throws Exception {
        PurchaseMemberRepository.purchasingSignUpCreate(purchaseMember);
    }
}