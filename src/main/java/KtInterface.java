import jvm.ktInterfaces;

/**
 * Created by Administrator on 2021/7/28.
 */
public class KtInterface implements ktInterfaces{
    @Override
    public void show() {
        System.out.println("~~KtInterface.show~~");
    }

    @Override
    public void see() {
        ktInterfaces.DefaultImpls.see(this);
        System.out.println("~~KtInterface.see~~");
    }
}
