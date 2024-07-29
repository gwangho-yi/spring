package hello.advanced.trace;

import lombok.Getter;

import java.util.UUID;

/**
 * packageName    : com.kovo.domain.ticketlink
 * fileName       : TraceId
 * author         : 이광호
 * date           : 2024-07-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-29        이광호       최초 생성
 */
@Getter
public class TraceId {
    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id=id;
        this.level = level;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0,8); // 8자리 사용
    }

    public TraceId createNextId() {
        return new TraceId(id, level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id, level + 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }



}
