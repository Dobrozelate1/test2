class Vehicle{
    public static void  kmToMiles(int km){
        System.out.println("Внутри родительского класса/статического метода");
    } }

class Car extends Vehicle{
    public static void  kmToMiles(int km){
        System.out.println("Внутри дочернего класса/статического метода ");
    } }

public class Class1 {

    private String model;
    private int weight;
     static int i = 23;

    public Class1(String model, int weight) {
        this.model = model;
        this.weight = weight;
    }

    public void start() {
        System.out.println("Поехали!");
    }

    public class SteeringWheel {

        public void right() {
            System.out.println("Руль вправо!");
        }

        public void left() {

            System.out.println("Руль влево!");
        }
    }

   public class Seat {

        public void  up() {

            System.out.println("сиденье поднято выше!");
//            return i;
        }

        public void down() {

            System.out.println("сиденье опущено ниже!");
        }

    }

    public class Seat2 extends  Seat{
        public void up() {

            System.out.println("Seat2");
        }
    }
   static public class StaticSeat {
        public void up() {

            System.out.println("Seat2");
        }
    }

     public class StaticSeat2 extends Seat2 {
        public void up() {

            System.out.println("Seat2");
        }
    }

    public interface MonitoringSystem {

        public void startMonitoring();
    }

    interface Operationable {
        int calculate(int x, int y);
    }

    @FunctionalInterface
    public interface WorkerInterface {

        public void doSomeWork();

    }
    public static void execute(WorkerInterface worker) {
        worker.doSomeWork();
    }
    public static void main(String[] args) {

//int i = 456;
//int b = 0;
//double d;
////d = i / 9;
////        System.out.println("double" + d);
//          System.out.println(i%9000);
        System.out.println(validatePin("-1234"));


    }

    public static boolean validatePin(String pin) {
        boolean check = false;
        if (pin.length() == 4 || pin.length() == 6) {
            for (int i = 0; i < pin.length(); i++) {
                if (pin.charAt(i) >= '0' && pin.charAt(i) <= '9') {
                    try {
                        Integer.valueOf(pin.charAt(i));
                    }
                    catch (Exception e) {
                        check = false;
                        break;
                    }
                    check = true;
                }
                else
                    check = false;
                break;

            }
        }
                else
                    check = false;
                return  check;

            }




    public int GetSum(int a, int b)
    {
            int min = Math.min(a, b),
            max = Math.max(a, b),
            sum = max;
        for (int i = min; i < max; ++i)
            sum += i;
        return sum;
//        return (a + b) * (Math.abs(a - b) + 1) / 2;
    }
    public static int digital_root(int n){
//        return n < 10 ? n : digital_root(digital_root(n/10)+n%10);
        return (n%9 == 0) ? 9 : n % 9;
    }


//
//    public void method1 ()
//    {
//        Inner i = new Inner();
//    }
}
