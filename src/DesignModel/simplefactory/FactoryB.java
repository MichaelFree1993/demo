package DesignModel.simplefactory;

import DesignModel.simplefactory.Factory;

public class FactoryB implements Factory {

    @Override
    public void Method1(){
        System.out.println("it is method1 from FactoryB");
    }

    @Override
    public void Method2(){
        System.out.println("it is method2 from FactoryB");
    }

    @Override
    public void Method3(){
        System.out.println("it is method3 from FactoryB");
    }
}
