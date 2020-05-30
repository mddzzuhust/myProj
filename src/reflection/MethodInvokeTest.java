package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvokeTest {
    public static void main(String[] args) throws NoSuchMethodException,InvocationTargetException,IllegalAccessException {
        Class<InvokeObj> clazz=InvokeObj.class;
//输出InvokeObj类的方法
        System.out.println("以下输出的InvokeObj类的方法");
        Method[] methods=clazz.getMethods();
/*for(Method method:methods){
System.out.println(method);
}*/

//InvokeObj类的无参show()方法
        System.out.println("InvokeObj类的无参show()方法:");
//getMethod方法中参数，第一个是方法名，第二个是方法名中的参数类型
        Method method1=clazz.getMethod("show", null);
//会执行的无参show()方法
        Object object1=method1.invoke(new InvokeObj(), null);
        System.out.println("输出无参show()方法的返回值："+object1);

//会执行的InvokeObj类的show()方法
        System.out.println("InvokeObj类的show()方法：");
        Method method2=clazz.getMethod("show", String.class);
//对InvokeObj类中的带参的show方法进行传值，值为Hello World
        Object object2=method2.invoke(new InvokeObj(), "Hello World");
        System.out.println("输出有参数的show()方法："+object2);

//InvokeObj类的arrayShow()方法：
        System.out.println("InvokeObj类的arrayShow()方法：");
        Method method3=clazz.getMethod("arrayShow", String[].class);
        String[] str1=new String[]{"Hello","World","!"};
//数组类型的参数必须包含在new Object[]{}中，否则就会报IllegalAccessException异常
        String[] str2=(String[]) method3.invoke(new InvokeObj(),new Object[]{str1});
        for(String str : str2){
            System.out.println("arrayShow方法中的数组元素："+str);
        }

//InvokeObj类的StringShow()方法：
        System.out.println("InvokeObj类的StringShow()方法：");
        Method method4=clazz.getMethod("StringShow", String.class);
        String str3=(String) method4.invoke(new InvokeObj(), "thinking in java");
        System.out.println("StringShow()方法的返回值："+str3);

//InvokeObj类的intShow()方法：
        System.out.println("InvokeObj类的intShow()方法：");
        Method method5=clazz.getMethod("intShow", int.class);
        int num=(Integer) method5.invoke(new InvokeObj(), 89);
        System.out.println("intShow()方法的返回值："+num);
    }
}