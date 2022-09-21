import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*

 *@author:杨森垚
 *@version:
 *@Date:2022/9/21 16:45
 *@Package:
 *@Description:
 */

public class Demo {
    @Before
    public void test(){
        System.out.println("测试之前 说的话");
    }
    @Test
    public void Demo1(){
        System.out.println("嘿 我是你*");
    }
    @After
    public void test2(){
        System.out.println("测试之后说的  * ** * *");
    }
}
