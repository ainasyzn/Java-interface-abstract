import java.text.DecimalFormat;
public class WholeCake extends Cake{
    public int weight;

    
    public WholeCake(String flavor, int qty, int weight){
        super(flavor, qty);
        this.weight = weight;
    }
    
    @Override
    public int getQty(){ return qty;}
    
    @Override
    public double calcPrice(int qty){
        double payment = 0;
        
            if(flavor.equalsIgnoreCase("Chocolate")){
                if(weight == 1){
                    payment = qty*20.00;
                }
                else if(weight == 2){
                     payment = qty*25.00;
                }
            }
            if(flavor.equalsIgnoreCase("redVelvet")){
                if(weight == 1){
                    payment = qty*50.00;
                }
                else if(weight == 2){
                    payment = qty*60.00;
                }     
            }
            if(flavor.equalsIgnoreCase("Cheese")){
                if(weight == 1){
                    payment = qty*60.00;
                }
                else if(weight == 2){
                    payment = qty*75.00;
                }     
            }
     return payment;
    }
    
    public String setWeight(){
        String sweight = "";
        if(this.weight == 1){
            sweight = "1.0kg";
        }
        else if(this.weight == 2){
            sweight = "1.5kg";
        }
     return sweight;
    }
    
    @Override
    public void display(){
        DecimalFormat df2 = new DecimalFormat("0.00");
        System.out.println("Whole Cake: " + this.flavor.substring(0, 1).toUpperCase() + this.flavor.substring(1) + "(" + setWeight() + ")" + " x" + this.qty +  "\t" + df2.format(calcPrice(this.qty)));
    }
}