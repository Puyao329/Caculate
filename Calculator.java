package com.example.caculate;

import java.util.Stack;

class Caculater {
    private String[] sArry;
    private Stack<String> houx=new Stack<String>();
    private Stack<String> fuhao=new Stack<String>();

    //结构初始化
    Caculater(String str){
        int i=str.length()-1;
        StringBuilder temp= new StringBuilder();
        int j=0;
        Boolean bool=true;
        //在符号的左右各添加一个#字符划分
        while(true){
            if(!bool) break;
            if(i==j){
                bool=false;
            }
            if(str.charAt(j)=='+'||str.charAt(j)=='-'||str.charAt(j)=='*'||str.charAt(j)=='/'||str.charAt(j)=='('||str.charAt(j)==')'||str.charAt(j)=='%'
                    ||str.charAt(j)=='√'||str.charAt(j)=='²'||str.charAt(j)=='³'||str.charAt(j)=='㏑'||str.charAt(j)=='㏒'||str.charAt(j)=='∏'){
                temp.append("#");
                temp.append(str.charAt(j));
                temp.append("#");
            }else if(str.charAt(j)=='s'||str.charAt(j)=='c'||str.charAt(j)=='t'){
                temp.append("#");
                temp.append(str.charAt(j)).append(str.charAt(j + 1)).append(str.charAt(j + 2));
                temp.append("#");
                j=j+2;
            }
            else{
                temp.append(str.charAt(j));
            }
            j++;
        }
        //用正则表达式进行字符分割
        sArry= temp.toString().split("#+");
    }
    public void backsort(){
        for(int i=0;i<sArry.length;i++){
            if(!sArry[i].equals("+")&&
            !sArry[i].equals("-")&&!sArry[i].equals("*")&&
            !sArry[i].equals("/")&&!sArry[i].equals("(")&&
            !sArry[i].equals(")")&&!sArry[i].equals("%")&&!sArry[i].equals("²")&&!sArry[i].equals("√")&&
                    !sArry[i].equals("³")&&!sArry[i].equals("∏")&&!sArry[i].equals("㏑")&&!sArry[i].equals("㏒")&&
                !sArry[i].equals("sin")&&!sArry[i].equals("cos")&&!sArry[i].equals("tan")){
                houx.push(sArry[i]);
                //否则是字符，若符号栈为空直接入栈
            }else if(fuhao.isEmpty()) {

                fuhao.push(sArry[i]);
            }else if(sArry[i].equals("(")){
                fuhao.push(sArry[i]);
                //如果为）括号
            }else if(sArry[i].equals(")")){
                //不断出栈，直到（括号出现
                while(!fuhao.peek().equals("(")){
                    houx.push(fuhao.pop());
                }
                fuhao.pop();//清掉(括号
                //如果不为空，且要入的符号比符号栈顶的符号优先级高，则直接push
            }else if(check(sArry[i],fuhao.peek())){
                fuhao.push(sArry[i]);
                //否则，将符号栈内优先级高的符号出栈，push入houx栈，再将符号存进符号栈
            }else{
                houx.push(fuhao.pop());
                fuhao.push(sArry[i]);
            }
        }
        //遍历完成后，直接将符号栈内的依次出栈，push入houx栈
        while(!fuhao.isEmpty()){
            houx.push(fuhao.pop());
        }
    }
    //check对比优先级
    private boolean check(String a,String b){
        //如果符号栈内是（括号，直接返true
        if(b.equals("(")){
            return true;
        }
        //如果符号栈内的优先级要比入的高，就返回false
        //b>a
        if((b.equals("*")||b.equals("/")||b.equals("%")||b.equals("√")||b.equals("²")||b.equals("³")||b.equals("㏑")||b.equals("㏒")||b.equals("∏")||b.equals("sin")||b.equals("cos")||b.equals("tan"))
                &&(a.equals("+")||a.equals("-"))){
            return false;
        }
        //b<a
        if((b.equals("+")||b.equals("-"))
                &&(a.equals("*")||a.equals("/")||a.equals("%")||a.equals("√")||a.equals("²")||a.equals("³")||a.equals("㏑")||a.equals("㏒")||a.equals("∏")||a.equals("sin")||a.equals("cos")||a.equals("tan"))){
            return true;
        }
        return false;
    }
    //出栈计算
    public Double suan() {
        backsort();
        //结果栈end
        Stack<Double> end = new Stack<Double>();
        //遍历houx栈
        for (int i = 0; i < houx.size(); i++) {
            if (houx.get(i).equals("+")) {
                Double b = end.pop();
                Double a = end.pop();
                end.push(a + b);
                //如果是减号，end pop出栈两个数字，计算后入栈
            } else if (houx.get(i).equals("-")) {
                Double b = end.pop();
                Double a = end.pop();
                end.push(a - b);
                //如果是乘号，end pop出栈两个数字，计算后入栈
            } else if (houx.get(i).equals("*")) {
                Double b = end.pop();
                Double a = end.pop();
                end.push(a * b);
                //如果是除号，end pop出栈两个数字，计算后入栈
            } else if (houx.get(i).equals("/")) {
                Double b = end.pop();
                Double a = end.pop();
                end.push(a / b);
            } else if (houx.get(i).equals("%")) {
                Double b = end.pop();
                //Double a = end.pop();
                end.push(b * 0.01);
            } else if (houx.get(i).equals("√")) {
                Double b = end.pop();
                end.push(Math.sqrt(b));
            } else if (houx.get(i).equals("²")) {
                Double b = end.pop();
                end.push(b * b);
            } else if (houx.get(i).equals("³")) {
                Double b = end.pop();
                end.push(b * b * b);
            } else if (houx.get(i).equals("㏑")) {
                Double b = end.pop();
                end.push(Math.log(b) / Math.log(Math.E));
            } else if (houx.get(i).equals("㏒")) {
                Double b = end.pop();
                end.push(Math.log(b));
            }else if (houx.get(i).equals("∏")) {
                Double b = end.pop();
                end.push(b * Math.PI);
            } else if (houx.get(i).equals("sin")) {
                    Double b = end.pop();
                    end.push(Math.sin(b));
            }else if (houx.get(i).equals("cos")) {
                Double b = end.pop();
                end.push(Math.cos(b));
            }else if (houx.get(i).equals("tan")) {
                Double b = end.pop();
                end.push(Math.tan(b));
            }
            else if (houx.get(i).isEmpty()) {
                continue;
            }else {
                //不是符号，也就是数字的情况，转类型，push入栈
                end.push(Double.parseDouble(houx.get(i)));

            }

        }
        //输入结果
        return end.pop();
        }
    }
public class Calculator{
    static String str="";
    public Double Eval(String str){
        //结构化
        Caculater cl=new Caculater(str);
        //计算
        Double result=cl.suan();
        return result;
    }
}

