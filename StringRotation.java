public class StringRotation {
    public StringRotation(){
        int i;
    }
    public int findNumberOfRotations(String base, String rotation){
        if(base.length()!=rotation.length()){
            return -1;

        }
        for(int i =0; i<base.length();i++){
            if(base.equals(rotation.substring(i)+rotation.substring(0,i))){
                return i;
            }
        }
        return -1;
    }

    public boolean isReverseRotation(String base, String rotation){
        if(base.length()!=rotation.length()){
            return false;
        
        }
        String reverse ="";
        for(int i =0; i<base.length();i++){
            reverse=base.substring(i, i+1)+reverse;
        }
        if( findNumberofRotations(reverse, rotation)!=-1){
            return true;
        }
        return false;
    }
}

