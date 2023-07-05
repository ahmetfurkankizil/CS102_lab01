public class IntBag{

    private int arrayBoundary = 4;
    private static int currentNoInArray = 0;
    private int[] bag;

    public IntBag(){
        bag = new int[arrayBoundary];        
    }

    public int getArrayBoundary(){
        return this.arrayBoundary;
    }

    public void doubleTheArrayBoundary(){
        this.arrayBoundary = (getArrayBoundary()*2);
    }

    public static int getCurrentNoInArray() {
        return currentNoInArray;
    }

    public static void setCurrentNoInArray(int currentNoInArray) {
        IntBag.currentNoInArray = currentNoInArray;
    }

    public void addValueToEnd(int valueToBeAdded){

        if(getArrayBoundary() > getCurrentNoInArray()){
            bag[currentNoInArray] = valueToBeAdded;
            currentNoInArray++;
        }
        //Doubling the size of the array if necessary
        else{
            int[] temp = new int[getArrayBoundary()*2];
            for (int i = 0; i < getArrayBoundary(); i++) {
                temp[i] = bag[i];
            }
            doubleTheArrayBoundary();
            bag = temp;
            bag[currentNoInArray] = valueToBeAdded;
            currentNoInArray++;
        }
        System.out.println(valueToBeAdded + " is added to the end");
    }

    public void addValueToSpecificIndex(int valueToBeAdded, int desiredIndex) {
        // If the desired index is more than the array size and if there is no room for the value to be added, the size is doubled
        if(desiredIndex >= getArrayBoundary() || (getCurrentNoInArray()) >= getArrayBoundary()) {
            //Doubling the size to fit the value
            int[] temp = new int[getArrayBoundary()*2];
            for (int i = 0; i < getArrayBoundary(); i++) {
                temp[i] = bag[i];
            }
            doubleTheArrayBoundary();
            bag = temp;

            // Finding the index of empty slot in the array
            int firstEmptySlot = 0;
                for(int j = 0; j<bag.length; j++) {
                    if (bag[j] == 0) {
                        firstEmptySlot = j;
                        break;    
                    } 
                }
                // Moving up the other integers to open space
                for(int k = firstEmptySlot; k>=desiredIndex; k--) {
                    bag[k] = bag[k-1]; 
                }
                // Inserting the value
                bag[desiredIndex] = valueToBeAdded;
                currentNoInArray++;
                System.out.println(valueToBeAdded + " is added to the index: " + desiredIndex);
            }
        else{
            // Directly opening a space and inserting it without doubling the size
            int firstEmptySlot = 0;
                for(int j = 0; j<bag.length; j++) {
                    if (bag[j] == 0) {
                        firstEmptySlot = j;
                        break;    
                    } 
                }  
                for(int k = firstEmptySlot; k>=desiredIndex; k--) {
                    if(desiredIndex == 0) {
                        bag[desiredIndex] = valueToBeAdded;
                    }
                    else {
                        bag[k] = bag[k-1];  
                    }
            }
            bag[desiredIndex] = valueToBeAdded;
            currentNoInArray++;
            System.out.println(valueToBeAdded + " is added to the index: " + desiredIndex);
        }
    }
    
    public void removeValue(int indexToBeRemoved) {
        if (indexToBeRemoved <= getArrayBoundary()){
            bag[indexToBeRemoved] = bag[getArrayBoundary()-1];
            currentNoInArray--;
        }
        else {
            System.out.println("The index is bigger than the array length!");
        }
    }

    public int getSpecificLocation(int specificIndex){
        return bag[specificIndex];
    }

    public boolean isInTheArray(int askedValue) {
        boolean isHere = false;
        for(int j = 0; j<bag.length; j++) {
                    if (bag[j] == askedValue) {
                        isHere = true;
                        break;    
                    } 
        } 
        return isHere;
    }

    public String toString() {
        String returnString = "";
        for(int i=0; i<bag.length; i++) {
            returnString = returnString + i + ". " + bag[i] + "\n";
        }
        return "The array is the following: " + "\n" + returnString;
    }

    public void removeAllInstances(int removedValue){
        for(int i = 0; i < bag.length; i++) {
            if(bag[i] == removedValue){
                bag[i] = 0;
                currentNoInArray--;
            }
        }
    }

    public void removeAll() {
        for(int i = 0; i < bag.length; i++) {
            bag[i] = 0;
        }
        setCurrentNoInArray(0);
    }
}