package p2;
import java.lang.reflect.*;
import javax.swing.*;
/*
TestP2.java
Testprogram för metoderna i Programmeringsuppgift 2
Rolf Axelsson
 */
public class TestP2 {
    public static void testMethod1() throws Exception {
        Class cls1 = Class.forName("p2.SimpleDice");
        Class cls2 = Class.forName("p2.TestDice");
        Constructor constr = cls1.getConstructor(new Class[]{int.class});
        Method method = cls2.getDeclaredMethod("test", new Class[]{Dice.class,int.class});
// Fr.o.m version 1.5
        method.invoke(null, new Object[]{constr.newInstance(new Integer(6)),new Integer(1000000)});
        TextWindow.println();
        method.invoke(null, new Object[]{constr.newInstance(new Integer(4)),new Integer(1000000)});
// T.o.m version 1.4.2
//        method.invoke(null, new Object[]{constr.newInstance(new Object[]{new Integer(6)}),new Integer(1000000)});
//        TextWindow.println();
//        method.invoke(null, new Object[]{constr.newInstance(new Object[]{new Integer(4)}),new Integer(1000000)});
    }
    
    public static void testMethod2() throws Exception {
        Class cls1 = Class.forName("p2.OrdinaryPlayer");
        Class cls2 = Class.forName("p2.Cheater");
        Class cls3 = Class.forName("p2.TestDice");
        Class cls4 = Class.forName("p2.SimpleDice");
        Constructor constrOP = cls1.getConstructor(new Class[]{String.class,Dice.class});
        Constructor constrC = cls2.getConstructor(new Class[]{String.class,Dice.class});
        Constructor constrDice = cls4.getConstructor(new Class[]{int.class});
        Method method = cls3.getDeclaredMethod("test", new Class[]{p2.Player.class,int.class});
        Object dice = constrDice.newInstance(new Object[]{new Integer(6)});
        Object ordPlayer = constrOP.newInstance(new Object[]{new String("Rut"),dice});
        method.invoke(null, new Object[]{ordPlayer,new Integer(1000000)});
        TextWindow.println();
        Object cheater = constrC.newInstance(new Object[]{new String("Fuffe"),dice});
        method.invoke(null, new Object[]{cheater,new Integer(1000000)});
    }
    
    public void runMain(String classname) throws Exception {
        Class cls = Class.forName(classname);
        Method method = cls.getDeclaredMethod("main",new Class[]{String[].class});
        method.invoke(null,new Object[]{null}); 
    }
    
    public void programLoop() {
        Class cls;
        String menu = "Välj den metod som ska anropas:\n\n" +
                "1. Test av SimpleDice\n" +
                "2. Test av OrdinaryPlayer\n" +
                "3. Test av test(Dice)\n" +
                "4. Test av Cheater\n" +
                "5. Test av test(Player)\n" +
                "6. Test av ProbabilityDice\n" +
                "0. Avsluta programmet\n\n" +
                "Ange ditt val";
        int choice = Integer.parseInt( JOptionPane.showInputDialog(menu) );
        while(choice!=0) {
            try {
                switch(choice) {
                    case 1 : runMain("p2.TestSimpleDice"); break;
                    case 2 : runMain("p2.TestOrdinaryPlayer"); break;
                    case 3 : testMethod1(); break;
                    case 4 : runMain("p2.TestCheater"); break;
                    case 5 : testMethod2(); break;
                    case 6 : runMain("p2.TestProbabilityDice"); break;
                }
            } catch (Exception e) {
            	TextWindow.println(e);
            }
            choice = Integer.parseInt( JOptionPane.showInputDialog(menu) );
        }
        TextWindow.println("\nSTÄNG FÖNSTRET!");
    }
    
    public static void main(String[] args) {
        TestP2 prog = new TestP2();
        prog.programLoop();
    }
}
