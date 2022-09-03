import jvm.ktInterfaces;
import syntax.clazz.CCO;
import syntax.clazz.ACompanionClass;

/**
 * Created by Administrator on 2021/7/28.
 */
public class CallKT {

    public static void main(String[] args) {
//        callKtObject();//调用Kt对象
        callKtFun();//调用Kt函数
//        callKtFunWithParms();//调用Kt函数（带默认参数）
//        callKtInterface();//调用Kt接口
//        callCompanion();//调用伴随对象

    }

    private static void callCompanion() {
        ACompanionClass.show(new CCO(11));//访问伴随对象中的扩展函数
        ACompanionClass.A.one();
    }


    private static void callKtInterface() {
        ktInterfaces ktI = new KtInterface();
        ktI.see();
        ktI.show();

    }


    private static void callKtFunWithParms() {
        Cat cat = new Cat("Tom");
        System.out.println("cat.name = " + cat.getName() + ", cat.age = " + cat.getAge());
        Cat cat1 = new Cat("Tom", 12);
        System.out.println("cat1.name = " + cat1.getName() + ", cat1.age = " + cat1.getAge());
    }

    private static void callKtFun() {
        //合并到同一文件
        Utils.show();
        Utils.see();

        //方法别名
        Pet pet = new Pet();
        System.out.println("pet.petName() is " + pet.petName());


        //方法重载
//        Pet pet = new Pet();
//        pet.show();
//        pet.show("O");

    }

    private static void callKtObject() {
        Person person = new Person("DD");

        //使用非暴露属性（未使用@JvmField暴露的字段）
        System.out.println("person.getFirstName() is " + person.getFirstName());

        //暴露属性
        System.out.println("person.id = " + person.id);

        //懒加载属性
        System.out.println("person.gf = " + person.gf);
        person.gf = "Anna";
        System.out.println("person.gf = " + person.gf);


        //静态属性
        System.out.println("Person.borthday is " + Person.borthday);
        System.out.println("Person.bf is " + Person.bf);

    }
}
