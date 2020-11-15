import java.text.DecimalFormat;
public class CupCake extends Cake{
    
    public CupCake(String flavor, int qty){
        super( flavor, qty);
    }
    
    @Override
    public int getQty(){ return qty;}

    @Override
    public double calcPrice(int qty){
        double payment = 0;
        
            if(flavor.equalsIgnoreCase("Chocolate"))
            {
                payment = qty*1.20;
            }
            else if(flavor.equalsIgnoreCase("Sponge"))
            {
                payment = qty*1.40;
            }
            else if(flavor.equalsIgnoreCase("Poppy"))
            {
                payment = qty*1.50;
            }

     return payment;
    }
    
    @Override
    public void display(){
        DecimalFormat df2 = new DecimalFormat("0.00");
        System.out.print("Cup Cake: " + this.flavor.substring(0, 1).toUpperCase() + this.flavor.substring(1) + " x" + this.qty +  "\t\t" + df2.format(calcPrice(this.qty))); 
        System.out.println();
    }
}