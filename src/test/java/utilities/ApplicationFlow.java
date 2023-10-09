package utilities;

import java.util.Set;

public class ApplicationFlow {
    public static void pause(int millisecond) {
        try{
            Thread.sleep(millisecond);
        }catch (InterruptedException e){
            System.out.println("Interrupted happened");
        }
    }

    public static void switchToSecondWindow(){
        String currentID = Driver.getDriver().getWindowHandle();
        Set<String> handles = Driver.getDriver().getWindowHandles();
        for(String id: handles){
            if(!id.equals(currentID)){
                Driver.getDriver().switchTo().window(id);
                break;
            }
        }
    }
}
