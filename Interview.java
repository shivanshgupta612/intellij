//public class Interview {
//    public static void main(String args[]){
//        String str = "How are you?";
//        //woH era ?uoy
//                //012345
//        String s="ABCD45";
//        //ABC44
//        //ABC..YZ4428 -> ABC..YZ44
//        //012..25 26 27 28 29 30
//        //ABC..Y  Z  4  4  2  8
//        // 28
//        int n=s.length();
//        String numeral= "";
//        int idx=0;
//        for(int i=n-1;i>=0;i--){
//            if(!numeral.isEmpty() && String.valueOf(i+1) == numeral){
//                idx=i;
//                break;
//            }
//            numeral= s.charAt(i) +numeral;
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i=0;i<=idx;i++){
//            stringBuilder.append(s.charAt(i));
//        }
//        System.out.println(stringBuilder+" "+idx);
//    }
//}
// Base class
class A {
    void methodA() {
        System.out.println("Method in class A");
    }
}

// Derived class from A
class B extends A {
    void methodB() {
        System.out.println("Method in class B");
    }
}

// Derived class from B (multilevel inheritance)
class C extends B {
    void methodC() {
        System.out.println("Method in class C");
    }
}

// Test the inheritance
public class Interview {
    public static void main(String[] args) {
        C obj = new C();

        // Calling methods from class C
        obj.methodC();

        // Calling methods inherited from class B
        obj.methodB();

        // Calling methods inherited from class A
        obj.methodA();
    }
}
