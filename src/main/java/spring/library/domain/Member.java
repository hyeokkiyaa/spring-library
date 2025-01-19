package spring.library.domain;

import jakarta.persistence.*;
import lombok.*;
import spring.library.controller.request.MemberRequest;
import spring.library.dto.MemberDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private int age;

    public static Member from(MemberRequest memberRequest) {
        return Member.builder()
                .name(memberRequest.getName())
                .age(memberRequest.getAge())
                .books(new ArrayList<>())
                .build();
    }

    public Member(MemberDto memberDto) {
        this.name = memberDto.getName();
        this.age = memberDto.getAge();
        this.books = new ArrayList<>();
    }

    public void update(MemberDto memberDto) {
        this.name = memberDto.getName();
        this.age = memberDto.getAge();
    }

    @OneToMany(
            mappedBy = "member",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Book> books = new ArrayList<>();
}
