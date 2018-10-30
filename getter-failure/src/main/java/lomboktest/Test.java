package lomboktest;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.StampedLock;



public abstract class Test implements HasId {

  @Getter(lazy = true)
  private final Inner1 i1 =
      new Inner1(getId(), new Inner2(ImmutableMap.of("fff", getId())));

  static class Inner1 {
    private final StampedLock s;
    private static final ConcurrentHashMap<String, StampedLock> m = new ConcurrentHashMap<>();
    private final Inner2 i2;

    public Inner1(String s2, Inner2 i2) {
      this.i2 = i2;
      this.s = m.computeIfAbsent(s2, k -> new StampedLock());
    }

  }

  static class Inner2 {
    Inner2(Map<String,String> m) {}
  }
}
