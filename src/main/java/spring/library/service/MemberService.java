package spring.library.service;

import jakarta.transaction.Transactional;
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

    public MemberDto findById(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No member"));
        return MemberDto.from(member);
    }

    @Transactional
    public MemberDto update(Long id, MemberRequest memberRequest) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No Member"));
        member.update(MemberDto.from(memberRequest));
        return MemberDto.from(member);
    }
}
