package DesignModel.simplefactory;

import DesignModel.simplefactory.Factory;

public class FactoryC implements Factory {

    @Override
    public void Method1(){
        System.out.println("it is method1 from FactoryC");
    }

    @Override
    public void Method2(){
        System.out.println("it is method2 from FactoryC");
    }

    @Override
    public void Method3(){
        System.out.println("it is method3 from FactoryC");
    }
}
