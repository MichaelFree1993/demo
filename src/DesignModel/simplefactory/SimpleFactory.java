package DesignModel.simplefactory;

public class SimpleFactory {

    private Factory factory1;

    public Factory creatFactoryMethod1(String factory) {
        switch (factory) {
            case "factoryA":
                return new FactoryA();
            case "factoryB":
                return new FactoryB();
            case "factoryC":
                return new FactoryC();
            default:
                return factory1;
        }
    }

    public void creatFactoryMethod2(String factory) {
        switch (factory) {
            case "factoryA":
                factory1 = new FactoryA();
                break;
            case "factoryB":
                factory1 = new FactoryB();
                break;
            case "factoryC":
                factory1 = new FactoryC();
                break;
            default:
                factory1 = null;
        }
    }

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Factory factory = simpleFactory.creatFactoryMethod1("factoryA");
        factory.Method1();
        factory.Method2();
        factory.Method3();

        System.out.println("********************************");
        simpleFactory.creatFactoryMethod2("factoryB");
        simpleFactory.factory1.Method1();
        simpleFactory.factory1.Method2();
        simpleFactory.factory1.Method3();

    }
}
