package hello.holyhellospring;

import hello.holyhellospring.repository.JdbcMemberRepository;
import hello.holyhellospring.repository.MemberRepository;
import hello.holyhellospring.repository.MemoryMemberRepository;
import hello.holyhellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    /**
     * Repository Bean 설정
     * 상황에 따라 MemoryMemberRepository, JdbcMemberRepository Type의 Bean을 생성한다.
     *
     * @return
     */
    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
