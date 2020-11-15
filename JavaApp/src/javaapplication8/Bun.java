import java.text.DecimalFormat;
public class Bun extends Bread{
    String bunName;

    public Bun(String bunName, int qty, String flavor){
        super(flavor, qty);
        this.bunName = bunName;
    }
    
    @Override
    public int getQty(){ return qty;}
    
    @Override
    public double calcPrice(int qty){
        double payment = 0;
        
        //if bunName = sweet
        if(bunName.equalsIgnoreCase("Sweet")){
            if(flavor.equalsIgnoreCase("Kaya")){
                payment = qty*0.90;
            }
            else if(flavor.equalsIgnoreCase("Coconut")){
                payment = qty*0.80;
            }
            else if(flavor.equalsIgnoreCase("redBean")){
                payment = qty*0.85;
            }
            else if(flavor.equalsIgnoreCase("Cheese")){
                payment = qty*1.00;
            }
        }//if bunName = savoury
        else if(bunName.equalsIgnoreCase("Savoury")){
            if(flavor.equalsIgnoreCase("Sausage") || flavor.equalsIgnoreCase("BBQ")){
                payment = qty*1.00;
            }
            else if(flavor.equalsIgnoreCase("Curry")){
                payment = qty*0.90;
            }
        }
        return payment;
    }
    
    @Override
    public void display(){
        DecimalFormat df2 = new DecimalFormat("0.00");
        System.out.print("Bun: " + this.flavor.substring(0, 1).toUpperCase() + this.flavor.substring(1) + " x" + this.qty + "\t\t\t" + df2.format(calcPrice(this.qty)));
        System.out.println();
    }
} 
