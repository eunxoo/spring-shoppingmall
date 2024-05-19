package exercise.generics;

import java.util.ArrayList;

public class GenericsDemo {
    public static void main(String[] args) {
        // 3종류의 차가 순서대로 bbang()

        //배열은 차를 더 추가할 수가 없다.
        Car[] cars = new Car[3];
        cars[0] = new Bus();
        cars[1] = new Taxi();
        cars[2] = new MyCar();


        for (Car car : cars){
            car.bbang();
        }


        ArrayList<Car> carss = new ArrayList<>();
        carss.add(new Bus());
        carss.add(new Taxi());
        carss.add(new MyCar());

        for(Car car : carss){
            car.bbang();
        }

        for(int i = 0; i < carss.size(); i++){
            carss.get(i).bbang();
        }

        CarList<Car> carList = new CarList<>();
        carList.add(new Bus());
        carList.add(new Taxi());
        carList.add(new MyCar());

        for(int i = 0; i < carList.size(); i++){
            carList.get(i).bbang();
        }
    }
}

class Car{
    void bbang(){
        System.out.println("경적 소리");
    }
}

class Bus extends Car{
    @Override
    void bbang() {
        System.out.println("빵-");
    }
}

class Taxi extends Car{
    @Override
    void bbang() {
        System.out.println("빠방-");
    }
}

class MyCar extends Car{
    @Override
    void bbang() {
        System.out.println("빠밤-");
    }
}

class CarList<T> {
    ArrayList<T> arrayList = new ArrayList<>();

    void add(T data){
        // arrayList에 car 객체를 하나씩 추가
        arrayList.add(data);
    }

    public int size() {
        return arrayList.size();
    }

    public T get(int i) {
        return arrayList.get(i);
    }
}