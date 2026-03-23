interface G { }
class A { }
class B extends A { }
class C extends B { }
class D extends B implements G { }
class E extends A implements G { }

class HovedSubInt {
    public static void main (String[] args) {
        A a = new B();
        B b = new C();
        C c = new C();
        D d = new D();
        E e = new E();
        G ii = d;
        G jj = e;
        //  Her skal det stå én linje       
    }
}