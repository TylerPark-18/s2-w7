public class SummerSpecial {
    private FurnitureItem item1;
    private FurnitureItem item2;
    public SummerSpecial(FurnitureItem item1, FurnitureItem item2){
        this.item1 = item1;
        this.item2 = item2;
    }

    public boolean isSet(FurnitureItem item1, FurnitureItem item2){
        if(item1.substring(item1.getProductId().length()-5).equals(item2.substring(item2.getProductId().length()-5))){
            return true;
        }
        return false;
    }
    public double getPrice(FurnitureItem item1, FurnitureItem item2){
       double totalPrice =0;
        if(isSet(item1, item2)){
            if(item1.getPrice()> item2.getPrice()){
                totalPrice = item1.getPrice()*0.75 + item2.getPrice();
            } 
            if(item2.getPrice()> item1.getPrice()){
                totalPrice = item2.getPrice()*0.75 + item1.getPrice();
            } 
        } else {
            if(item1.getPrice()< item2.getPrice()){
                totalPrice = item1.getPrice()*0.9 + item2.getPrice();
            } 
            if(item2.getPrice()< item1.getPrice()){
                totalPrice = item2.getPrice()*0.9 + item1.getPrice();
            } 
        }
    }

    public Route maxMilage(){
        if(routes.size()==0){
            return null;
        }
       Route miles= routes.get(0); 
        
        for(Route r: routes){
            if(r.getMiles()>miles.getMiles()){
                miles = r;
                
            }
        }
        return miles;
    }
}
