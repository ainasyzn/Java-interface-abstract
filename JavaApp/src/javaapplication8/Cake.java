public abstract class Cake implements Bakery {
    String flavor;
    int qty;
    
    public Cake(String flavor, int qty){
       this.flavor = flavor;
       this.qty = qty;
    }
    
    @Override
    public abstract int getQty();
    
    @Override
    public abstract double calcPrice(int qty) throws  ArithmeticException;
    
    @Override
    public abstract void display();
    
}
