package DesignModel.singleton;

public class SingletonA {
    private static SingletonA singletonA= new SingletonA();
    public SingletonA(){}

    public static SingletonA getInstance(){
        return singletonA;
    }
}
