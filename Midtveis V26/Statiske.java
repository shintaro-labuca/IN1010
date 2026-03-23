class A {
    static int as = 0;
    int ai = 0;
    void tell () { as++; ai++; }
}

class B extends A {
    static int bs = 0;
    int bi = 0;
    void tell () { super.tell(); bs++; bi++; }
}

class Statiske {
    public static void main (String[] args) {
        A a1 = new A();
        A a2 = new B();
        a1.tell(); a2.tell(); a2.tell();
        B b2 = (B)a2;
        System.out.println("a1.as er " + a1.as);
        System.out.println("a1.ai er " + a1.ai);
        System.out.println("a2.as er " + a2.as);
        System.out.println("a2.ai er " + a2.ai);
        System.out.println("b2.as er " + b2.as);
        System.out.println("b2.ai er " + b2.ai);
        System.out.println("b2.bs er " + b2.bs);
        System.out.println("b2.bi er " + b2.bi);
    }
}