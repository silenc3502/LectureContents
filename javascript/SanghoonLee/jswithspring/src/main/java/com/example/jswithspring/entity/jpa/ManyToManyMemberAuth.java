package com.example.jswithspring.entity.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "tbl_many_to_many_member_auth")
public class ManyToManyMemberAuth {
    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberAuthNo;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JsonIgnore
    @JoinColumn(name = "many_to_many_member_no")
    //@JoinColumn(name = "MANY_TO_MANY_MEMBER_NO")
    private ManyToManyMember manyToManyMember;

    @Column(length = 64, nullable = false)
    private String auth;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public ManyToManyMemberAuth(String auth, ManyToManyMember member) {
        this.auth = auth;
        manyToManyMember = member;
    }
}
