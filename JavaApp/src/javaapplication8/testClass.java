import java.util.*;
import java.text.DecimalFormat;
public class testClass{

    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        String answer;
        int initialSize = 0;
        //arr of obj bakery
        Bakery array[] = new Bakery[initialSize];
        //initial value will be overwritten
        Bakery c = new CupCake("Poppy", 1);
        
        try{           
            do{     
            System.out.print("What do you wish to order? [Cake | Bread]: ");
            String type = in.next();
            
            if(type.equalsIgnoreCase("Cake")){
                System.out.print("Select cake [Whole | Cup]: ");
                String select = in.next();
                
                if(select.equalsIgnoreCase("Whole")){
                    System.out.print("Enter Whole cake flavor [Chocolate | Red Velvet | Cheese]: ");
                    String flavor = in.next();
                    System.out.print("Select cake weight [1 - 1kg | 2 - 1.5kg]: ");
                    int weight = in.nextInt();
                    System.out.print("Enter quantity of cake: ");
                    int qty = in.nextInt();
                    
                    c = new WholeCake(flavor, qty, weight);
                    c.calcPrice(qty);
                }
                else if(select.equalsIgnoreCase("Cup")){
                    System.out.print("Enter Cup cake flavor [Chocolate | Sponge | Poppy]: ");
                    String flavor = in.next();
                    
                    if(flavor.equalsIgnoreCase("Chocolate"))
                            System.out.println("Chocolate cake filling will be cream.");
                    else if(flavor.equalsIgnoreCase("Sponge"))
                            System.out.println("Sponge cake filling will be strawberry.");
                    else if(flavor.equalsIgnoreCase("Poppy"))
                            System.out.println("Poppy cake filling will be raspberry.");

                    System.out.print("Enter quantity of cake: ");
                    int qty = in.nextInt();
                    
                    c = new CupCake(flavor, qty);
                    c.calcPrice(qty);
                } 
                else{ 
                    System.out.println("Invalid input! Program terminated.");
                    System.exit(0);
                }
            }        
            else if(type.equalsIgnoreCase("Bread")){
                System.out.print("Select bread [Bun | Loaf]: ");
                String select = in.next();
                
                if(select.equalsIgnoreCase("Bun")){
                    System.out.print("Enter Bun name [Sweet | Savoury]: ");
                    String bunName = in.next();
                    
                    if(bunName.equalsIgnoreCase("Sweet")){
                        System.out.print("Select bun flavor [Kaya | Coconut | Red bean | Cheese]: ");
                        String flavor = in.next();
                        
                        if(flavor.equalsIgnoreCase("Kaya"))
                                System.out.println("Kaya bun filling will be kaya.");
                        else if(flavor.equalsIgnoreCase("Coconut"))
                                System.out.println("Coconut bun filling will be coconut.");
                        else if(flavor.equalsIgnoreCase("Red bean"))
                                System.out.println("Red bean bun filling will be red bean.");
                        else if(flavor.equalsIgnoreCase("Cheese"))
                                System.out.println("Cheese bun filling will be cheeese.");
                    
                        System.out.print("Enter quantity of bun: ");
                        int qty = in.nextInt();
                        
                        c = new Bun(bunName, qty, flavor);
                        c.calcPrice(qty);
                    }
                    else if(bunName.equalsIgnoreCase("Savoury")){
                        System.out.print("Select bun flavor [Sausage | Curry | BBQ]: ");
                        String flavor = in.next();
                        System.out.print("Enter quantity of bun: ");
                        int qty = in.nextInt();
                        
                        c = new Bun(bunName,qty, flavor);  
                        c.calcPrice(qty);
                    }
                    else{ 
                        System.out.println("Invalid input! Program terminated.");
                        System.exit(0);
                    }
                }
                if(select.equalsIgnoreCase("Loaf")){
                    System.out.print("Select Loaf flavor [Savoury | Sweet | Plain]: ");
                    String flavor = in.next();
                    System.out.print("Select cake weight [1 - 0.5kg | 2 - 1kg]: ");
                    int weight = in.nextInt();
                    System.out.print("Enter quantity of loaf: ");
                    int qty = in.nextInt();
                    
                    c = new Loaf(flavor, qty, weight);
                    c.calcPrice(qty);
                }
                else{ 
                System.out.println("Invalid input! Program terminated.");
                System.exit(0);
            }
            } else{ 
                System.out.println("Invalid input! Program terminated.");
                System.exit(0);
            }
            


            array = addOrder(initialSize, array, c);
            initialSize++;
            System.out.print("Do you wish to make another order? [Yes | No]: ");
            answer = in.next();
            
        }while(answer.equalsIgnoreCase("Yes"));
            
        //display function sini
        display(array,c);
        
        }
        catch(InputMismatchException e){
            System.out.println("Error caught in main method: Input Mismatch Exception");
        }       
    }   
    
        
    //function update arr size
    public static Bakery[] addOrder(int n, Bakery arr[], Bakery b) 
    { 
        int i; 
        Bakery[] newarr = new Bakery[n + 1]; 
  
        //insert obj into new arr
        for (i=0; i< n; i++){
            newarr[i] = arr[i];}
  
        newarr[n] = b; 
        return newarr; 
    } 
    
    //function calc total payment
    public static double calcTotPayment(Bakery arr[], Bakery b){
        int i;
        double totPayment = 0;
        for(i=0; i<arr.length; i++){
            totPayment += arr[i].calcPrice(arr[i].getQty());
        }
       
      return totPayment;
    }
    
    //function calcDiscount
    public static double calcDisc(double totPay){
        double disc = 0;
        if(totPay > 50)
        { disc = (totPay*0.10);
        }
        else disc = 0.0;
        
      return disc;
    }
    
    //function display receipt
    public static void display(Bakery arr[], Bakery b){
        DecimalFormat df2 = new DecimalFormat("0.00");
        int i;
        double totPay = calcTotPayment(arr, b);
        
        System.out.println("------------Billing Receipt------------");
        System.out.println("List of orders \t\t\t(RM)");
        System.out.println();
     
        for(i=0; i<arr.length; i++){
            
            if(arr[i] instanceof CupCake){
                arr[i].display();
            }else if(arr[i] instanceof WholeCake){
                arr[i].display();
            }else if(arr[i] instanceof Loaf){
                arr[i].display();
            }else if(arr[i] instanceof Bun){
                arr[i].display();
            }
        }
        System.out.println();
        System.out.println("Total\t\t\t\t" + df2.format(totPay));
        System.out.println("Discount price \t\t\t" + df2.format(calcDisc(totPay)));
        System.out.println("Grand total \t\t\t" +  df2.format((totPay - calcDisc(totPay))));
        System.out.println("*Discount 10% for purchase of > RM50*");
        System.out.print("---------------------------------------");
    }
}
