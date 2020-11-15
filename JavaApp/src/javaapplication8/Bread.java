public abstract class Bread implements Bakery {
    
    String flavor;
    int qty;
    
    public Bread(String flavor, int qty){
        this.flavor = flavor;
        this.qty = qty;
    }
    
    @Override
    public abstract double calcPrice(int qty) throws  ArithmeticException;
    
    @Override
    public abstract void display();
    
    @Override
    public abstract int getQty();
}
