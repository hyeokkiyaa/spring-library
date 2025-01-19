package spring.library.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.library.controller.request.MemberRequest;
import spring.library.domain.Member;
import spring.library.dto.MemberDto;
import spring.library.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<MemberDto> findAll() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map(MemberDto::from).toList();
    }

    public MemberDto save(MemberRequest memberRequest) {
        return MemberDto.from(memberRepository.save(Member.from(memberRequest)));
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
