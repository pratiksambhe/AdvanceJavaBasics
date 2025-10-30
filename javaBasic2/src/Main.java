import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
interface M{
    public abstract int add(int a,int b);
}
public class Main {
    public static void main(String[] args) {
        M m=(int a,int b)->{
            System.out.println(a+b);
            return a+b;
        };
        m.add(12,13);
    }
}