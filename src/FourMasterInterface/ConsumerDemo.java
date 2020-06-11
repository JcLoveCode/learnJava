package FourMasterInterface;

import java.util.Objects;
import java.util.function.Consumer;

@FunctionalInterface
public interface ConsumerDemo<T>  {
    //消费型接口  对给定的参数T执行定义的操作
    void accept(T t);

    //对给定的参数T执行定义的操作执行再继续执行after定义的操作
    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> {
            accept(t);
            after.accept(t);
        };
    }


}
