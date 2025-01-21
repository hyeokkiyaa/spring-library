package spring.library.domain;

import jakarta.persistence.*;
import lombok.*;
import spring.library.controller.request.BookRequest;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Loan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private Date loanDate;
    private Date dueDate;
    private int renewalCount;
    private boolean isReturned;

    public Loan(boolean isReturned, int renewalCount, Date dueDate, Date loanDate, String author, String title, Member member) {
        this.isReturned = isReturned;
        this.renewalCount = renewalCount;
        this.dueDate = dueDate;
        this.loanDate = loanDate;
        this.author = author;
        this.title = title;
        this.member = member;
    }

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;



}
