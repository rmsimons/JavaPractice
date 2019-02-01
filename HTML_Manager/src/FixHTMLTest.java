/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class FixHTMLTest {
    public static void main(String[] args){
        for(int i = 1; i <= 7; i++){
            report(testFileNamed("test" + i + ".html"),"PASS: test"+ i + " fixed!","FAIL: test"+ i + " NOT fixed!");
            System.out.println();
        }
    }
    
    public static boolean testFileNamed(String filename){
        HTMLManager test = HTMLUtils.pageToManager("tests/" + filename);
        HTMLManager ref = HTMLUtils.pageToManager("fixed/" + filename);
        System.out.println("Expected Output: " + HTMLUtils.managerToString(ref));
        return HTMLUtils.equalsAfterOperation(ref, test, (manager)->{
            manager.fixHTML();
            System.out.println("Actual Output: " + HTMLUtils.managerToString(manager));
            return manager;
        });
    }
    
    public static void report(boolean success, String successMessage, String failMessage){
        if(success){
            System.out.println(successMessage);
        } else {
            System.out.println(failMessage);
        }
    }
}
