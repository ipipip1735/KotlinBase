import syntax.Throws;

/**
 * Created by Administrator on 2021/9/1.
 */
public class ThrowsJava {
    public static void main(String[] args) {
        Throws t = new Throws();
//        t.show();
        t.view();

        ThrowsJava throwsJava = new ThrowsJava();
//        throwsJava.see();
    }


    void see() throws Exception {
        throw new Exception("ooo");
    }
}
