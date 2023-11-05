package com.example.jswithspring.entity.jpa;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "authLists")
@NoArgsConstructor
@Entity
@Table(name = "tbl_many_to_many_member")
public class ManyToManyMember {
    @Id
    //@GeneratedValue
    //@Column(name = "many_to_many_member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(length = 64, nullable = false)
    private String userId;

    @Column(length = 64, nullable = false)
    private String password;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    /* Join Column 파트 */
    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "member")
    //@OneToMany(mappedBy = "many_to_many_member")
    //@OneToMany(mappedBy = "many_to_many_member", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "manyToManyMember", cascade = CascadeType.ALL)
    private List<ManyToManyMemberAuth> authLists = new ArrayList<>();

    public ManyToManyMember(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public ManyToManyMember(String userId, String password, ManyToManyMemberAuth auth) {
        this.userId = userId;
        this.password = password;

        if (auth != null) {
            changeAuth(auth);
        }
    }

    public void changeAuth(ManyToManyMemberAuth auth) {

    }

    public void addAuth(ManyToManyMemberAuth auth) {
        if (authLists == null) {
            authLists = new ArrayList<ManyToManyMemberAuth>();
        }

        authLists.add(auth);
    }

    public void clearAuthList () {
        authLists.clear();
    }
}
