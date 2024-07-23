package designPattern.creational;

// https://medium.com/@kevalpatel2106/how-to-make-the-perfect-singleton-de6b951dfdb0

public class SingletonClass {

    private static volatile SingletonClass sSoleInstance;

    //private constructor.
    private SingletonClass(){

        //Prevent form the reflection api.
        if (sSoleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SingletonClass getInstance() {
        //Double check locking pattern
        if (sSoleInstance == null) { //Check for the first time

            synchronized (SingletonClass.class) {   //Check for the second time.
                //if there is no instance available... create new one
                if (sSoleInstance == null) sSoleInstance = new SingletonClass();
            }
        }

        return sSoleInstance;
    }
    //Make singleton from serialize and deserialize operation.
    protected SingletonClass readResolve() {
        return getInstance();
    }

    // will return same object when try to clone
    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        return sSoleInstance;
    }
}