package com.example.jswithspring.service.jpa;

import com.example.jswithspring.controller.vue.jpa.request.MemberRequest;
import com.example.jswithspring.entity.jpa.ManyToManyMember;
import com.example.jswithspring.entity.jpa.ManyToManyMemberAuth;
//import com.example.jswithspring.entity.jpa.Member;
//import com.example.jswithspring.entity.jpa.MemberAuth;
//import com.example.jswithspring.repository.jpa.JPAMemberAuthRepository;
//import com.example.jswithspring.repository.jpa.JPAMemberRepository;
import com.example.jswithspring.repository.jpa.JpaManyToManyTestMemberAuthRepository;
import com.example.jswithspring.repository.jpa.JpaManyToManyTestMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JPAManyToManyTestMemberServiceImpl implements JPAManyToManyTestMemberService {

    @Autowired
    private JpaManyToManyTestMemberRepository memberManyToManyTestRepository;

    @Autowired
    private JpaManyToManyTestMemberAuthRepository memberManyToManyTestAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void register(MemberRequest memberRequest) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        ManyToManyMember memberEntity = new ManyToManyMember(
                memberRequest.getUserId(),
                memberRequest.getPassword());

        //memberEntity.addAuth(authEntity, memberEntity);
        memberManyToManyTestRepository.save(memberEntity);

        ManyToManyMemberAuth authEntity = new ManyToManyMemberAuth(memberRequest.getAuth(), memberEntity);

        memberManyToManyTestAuthRepository.save(authEntity);
    }

    @Transactional
    public List<ManyToManyMember> findBusiness() {
        //List<ManyToManyMemberAuth> businessAuth = memberManyToManyTestAuthRepository.findByAuth("ROLE_BUSINESS");

        //List<ManyToManyMember> businessMember = memberManyToManyTestRepository.findById("ROLE_BUSINESS");
        List<ManyToManyMember> businessMember = memberManyToManyTestRepository.selectMemberWithRole("ROLE_BUSINESS");

        return businessMember;
    }

    /*
    public MemberRequest login(MemberRequest memberRequest) throws Exception {
        Optional<ManyToManyMember> maybeMember = memberManyToManyTestRepository.findByUserId(memberRequest.getUserId());

        if (maybeMember == null) {
            log.info("login(): 그런 사람 없다.");
            return null;
        }

        ManyToManyMember loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword())) {
            log.info("login(): 비밀번호 잘못 입력하였습니다.");
            return null;
        }

        Optional<ManyToManyMemberAuth> maybeMemberAuth =
                memberManyToManyTestAuthRepository.findByMemberNo(loginMember.getNo());

        if (maybeMemberAuth == null) {
            log.info("auth 없음");
            return null;
        }

        ManyToManyMemberAuth memberAuth = maybeMemberAuth.get();
        MemberRequest response = new MemberRequest(
                memberRequest.getUserId(),
                memberRequest.getPassword(),
                memberAuth.getAuth());

        return response;
    }

    public boolean checkUserIdValidation(String userId) throws Exception {
        Optional<ManyToManyMember> maybeMember = memberManyToManyTestRepository.findByUserId(userId);

        if (maybeMember == null)
        {
            log.info("login(): 그런 사람 없다.");
            return false;
        }

        return true;
    }
     */

    /*
    @Override
    public List<Member> list() throws Exception {
        return repository.list();
    }
     */

    public List<Object[]> findSpecificByJPQL() throws Exception {
        return null;
    }
}
