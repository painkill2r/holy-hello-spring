package hello.holyhellospring.repository;

import hello.holyhellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    /**
     * store에 id값으로 된 Key를 가진 Map이 있다면 Optional로 반환
     * 단, 없는 경우 Optional에 NULL이 포함되어 반환됨.
     *
     * @param id
     * @return
     */
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    /**
     * store를 Loop로 돌려서 name값과 같은 정보가 있다면 Optional로 반환
     * findAny()는 하나라도 찾고, 끝가지 돌려서 없으면 Optional에 NULL이 포함하여 반환됨.
     *
     * @param name
     * @return
     */
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
