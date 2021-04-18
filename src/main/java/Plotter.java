/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Stack;

/**
 *
 * @author Ghost
 */
public class Plotter {
    
    public double split(String s,int d){
        Stack<String> stack=new Stack();
        int c=0,i=0;
        for(;i<s.length()-4;i++){
            if(s.charAt(i)=='+'){
                stack.push(""+data(s.substring(c,i),d));
                stack.push("+");
                c=i+1;
            }
            else if(s.charAt(i)=='-'){
                stack.push(""+data(s.substring(c,i),d));
                stack.push("-");
                c=i+1;
            }
            else if(s.charAt(i)=='*'){
                stack.push(""+data(s.substring(c,i),d));
                stack.push("*");
                c=i+1;
            }
            else if(s.charAt(i)=='/'){
                stack.push(""+data(s.substring(c,i),d));
                stack.push("/");
                c=i+1;
            }
        }
//        System.out.println("-->"+s.substring(c)+"--->"+data(s.substring(c),d));
        stack.push(""+data(s.substring(c),d));
        Stack<String> stack1=new Stack<>();

//        System.out.println("-->"+stack.peek());

        stack1.push(stack.pop());//multiply the function
        while (!stack.isEmpty()){
//            System.out.println(t +" - "+stack.peek());
            if(stack.peek().equals("*")){
                stack.pop();
//                System.out.println(stack.peek()+" multi "+stack1.peek());
//                System.out.println("multi");
                stack.push(""+(Double.parseDouble(stack.pop())*Double.parseDouble(stack1.pop())));
            }
            stack1.push(stack.pop());
        }

        stack.push(stack1.pop());//deivdes the function
        while (!stack1.isEmpty()){
//            System.out.println(t +" - "+stack.peek());
            if(stack1.peek().equals("/")){
                stack1.pop();
//                System.out.println("devide");
//                System.out.println(stack.peek()+" multi "+stack1.peek());
                stack1.push(""+(Double.parseDouble(stack1.pop()) / Double.parseDouble(stack.pop())));
            }
            stack.push(stack1.pop());
        }

        stack1.push(stack.pop());//add the function
        while (!stack.isEmpty()){
//            System.out.println(t +" - "+stack.peek());
            if(stack.peek().equals("+")){
                stack.pop();
//                System.out.println("add");
//                System.out.println(stack.peek()+" multi "+stack1.peek());
                System.out.println(Double.parseDouble(stack.peek())+"<--->"+Double.parseDouble(stack1.peek()));
                stack.push(""+(Double.parseDouble(stack.pop()) + Double.parseDouble(stack1.pop())));
            }
            stack1.push(stack.pop());
        }

        stack.push(stack1.pop());//subtract the function
        while (!stack1.isEmpty()){
//            System.out.println(t +" - "+stack.peek());
            if(stack1.peek().equals("-")){
                stack1.pop();
//                System.out.println("subtract");
//                System.out.println(stack.peek()+" multi "+stack1.peek());
                stack1.push(""+(Double.parseDouble(stack1.pop()) - Double.parseDouble(stack.pop())));
            }
            stack.push(stack1.pop());
        }


        return Double.parseDouble(stack.pop());
    }

    public double data(String s,int m){
//        int m=10;
        Stack<String> stack=new Stack<>();
        int t=0;
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == 's' && s.charAt(i + 1) == 'i' && s.charAt(i + 2) == 'n') {
                stack.push("sin");
                t++;
            }
            else if (s.charAt(i) == 'c' && s.charAt(i + 1) == 'o' && s.charAt(i + 2) == 's'){
                stack.push("cos");
                t++;
            }
            else if(s.charAt(i)=='t' && s.charAt(i+1)=='a' && s.charAt(i+2)=='n') {
                stack.push("tan");
                t++;
            }
            else if (s.charAt(i) == 'c' && s.charAt(i + 1) == 'o' && s.charAt(i + 2) == 't'){
                stack.push("cot");
                t++;
            }
            else if(s.charAt(i)=='s' && s.charAt(i+1)=='e' && s.charAt(i+2)=='c') {
                stack.push("sec");
                t++;
            }
            else if (s.charAt(i) == 'c' && s.charAt(i + 1) == 's' && s.charAt(i + 2) == 'c'){
                stack.push("csc");
                t++;
            }
            else if(s.charAt(i)=='l' && s.charAt(i+1)=='o' && s.charAt(i+2)=='g') {
                stack.push("log");
                t++;
            }
            else if(s.charAt(i)=='m' && s.charAt(i+1)=='o' && s.charAt(i+2)=='d') {
                stack.push("mod");
                t++;
            }
        }
        stack.push(""+m);
        
        while(t-->0) {
            double x=Double.parseDouble(stack.pop());
            if (stack.peek() == "tan"){
                double y=Math.tan(Math.toRadians(x));
                stack.pop();
                stack.push(""+y);
            }
            else if (stack.peek() == "cos"){
                double y=Math.cos(Math.toRadians(x));
                stack.pop();
                stack.push(""+y);
            }
            else if (stack.peek() == "sin"){
                double y=Math.sin(Math.toRadians(x));
                stack.pop();
                stack.push(""+y);
            }else if (stack.peek() == "sec"){
                double y=1/(Math.cos(Math.toRadians(x)));
                stack.pop();
                stack.push(""+y);
            }
            else if (stack.peek() == "csc"){
                double y=1/(Math.sin(Math.toRadians(x)));
                stack.pop();
                stack.push(""+y);
            }else if (stack.peek() == "cot"){
                double y=1/(Math.tan(Math.toRadians(x)));
                stack.pop();
                stack.push(""+y);
            }
            else if (stack.peek() == "log"){
                double y=Math.log10(Math.toRadians(x));
                stack.pop();
                stack.push(""+y);
            }
            else if (stack.peek() == "mod"){
                double y=Math.abs(Math.toRadians(x));
                stack.pop();
                stack.push(""+y);
            }
        }

        return Double.parseDouble(stack.pop());
    }

}
