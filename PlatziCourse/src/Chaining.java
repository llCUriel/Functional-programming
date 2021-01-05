public class Chaining {
    public static void main(String[] args) {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Hola")
                .append("alumno")
                .append("de")
                .append("platzi");
        Chainer chainer = new Chainer();
        chainer.sayHi().sayBye().sayHi();
    }

    static class Chainer{
        public Chainer sayHi(){
            System.out.println("Hola");
            return this;
        }
        public Chainer sayBye(){
            System.out.println("Bye");
            return this;
        }
    }
}
