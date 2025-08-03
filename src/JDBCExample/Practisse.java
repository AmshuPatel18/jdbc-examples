package JDBCExample;


class Demo implements Runnable {
    String name;
    String data;

    public Demo(String name, String data) {
        this.name = name;
        this.data = data;
    }
    private static ThreadLocal<String>tl=new ThreadLocal<>();
    public void run(){
        tl.set(data);
        System.out.println(name+" is running with data: "+tl.get());


    }
}



    public class Practisse {
        public static void main(String[] args) throws InterruptedException {

            Thread t1=new Thread(new Demo("A","Work 1"));
            Thread t2=new Thread(new Demo("B","Work 2"));
            t1.start();


            t2.start();

        }
}