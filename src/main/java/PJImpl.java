import kotlin.jvm.PurelyImplements;

/**
 * Created by Administrator on 2021/8/27.
 */
@PurelyImplements("syntax.OneIF")
public class PJImpl<T> implements TwoIF<T>{
    @Override
    public void show(T t) {
        System.out.println("~~PJImpl.show~~");
        System.out.println("t = " + t);
    }
}
