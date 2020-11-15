import java.text.DecimalFormat;
public class Loaf extends Bread {
    public int weight;

    
    public Loaf(String flavor, int qty, int weight){
        super(flavor, qty);
        this.weight = weight;
    }
    
    @Override
    public int getQty(){ return qty;}
    
    @Override
    public double calcPrice(int qty){
        double payment = 0;
            
            if(flavor.equalsIgnoreCase("Savoury")){
                if(weight == 1){
                    payment = qty*2.60;
                }
                else if(weight == 2){
                    payment = qty*3.70;
                }  
            } else if(flavor.equalsIgnoreCase("Sweet")){ 
                if(weight == 1){
                    payment = qty*2.70;
                }
                else if(weight == 2){
                    payment = qty*3.80;
                }  
            }else if(flavor.equalsIgnoreCase("Plain")){
                if(weight == 1){
                    payment = qty*2.40;
                }
                else if(weight == 2){
                    payment = qty*3.50;
                } 
            }
        
     return payment;   
    }
    
    public String setWeight(){
        String sweight = "";
        if(this.weight == 1){
            sweight = "0.5kg";
        }
        else if(this.weight == 2){
            sweight = "1.0kg";
        }
     return sweight;
    }
    
    @Override
    public void display(){
        DecimalFormat df2 = new DecimalFormat("0.00");
        System.out.print("Loaf: " + this.flavor.substring(0, 1).toUpperCase() + this.flavor.substring(1) + "(" + setWeight() + ")" + " x" + this.qty +  "\t\t" + df2.format(calcPrice(this.qty)));
        System.out.println();
    }
    
    
}
