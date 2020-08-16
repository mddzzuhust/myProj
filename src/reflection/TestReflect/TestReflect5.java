package reflection.TestReflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/*
 * 人在黑板上画圆，涉及三个对象,画圆需要圆心和半径，但是是私有的，画圆的方法
 * 分配给人不合适。
 *
 * 司机踩刹车，司机只是给列车发出指令，刹车的动作还需要列车去完成。
 *
 * 面试经常考面向对象的设计，比如人关门，人只是去推门。
 *
 * 这就是专家模式：谁拥有数据，谁就是专家,方法就分配给谁
 */
public class TestReflect5 {
    public static void main(String[] args) throws SecurityException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, Exception {
        String str = "shfsfs";
        //包开头是com表示是sun内部用的，java打头的才是用户的
        Method mtCharAt = String.class.getMethod("charAt", int.class);
        Object ch = mtCharAt.invoke(str,1);//若第一个参数是null，则肯定是静态方法
        System.out.println(ch);

        System.out.println(mtCharAt.invoke(str, new Object[]{2}));//1.4语法

    }

}