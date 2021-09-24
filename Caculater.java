package com.example.caculate;

import java.util.Stack;

public class Caculater {
    private String[] sArry;
    private Stack<String> houx=new Stack<String>();
    private Stack<String> fuhao=new Stack<String>();

    //结构初始化
    Caculater(String str){
        int i=str.length()-1;
        String temp="";
        int j=0;
        Boolean bool=true;
        //在符号的左右各添加一个#字符划分
        while(true){
            if(!bool) break;
            if(i==j){
                bool=false;
            }
            if(str.charAt(j)=='+'||str.charAt(j)=='-'||str.charAt(j)=='*'||str.charAt(j)=='/'||str.charAt(j)=='（'||str.charAt(j)==')'){
                temp+="#";
                temp+=str.charAt(j);
                temp+="#";
            }else{
                temp+=str.charAt(j);
            }
            j++;
        }
        sArry=temp.split("#+");
    }
    public void backsort(){
        for(int i=0;i<sArry.length;i++){
            if(!sArry[i].equals("+")&&
            !sArry[i].equals("-")&&!sArry[i].equals("*")&&
            !sArry[i].equals("/")&&!sArry[i].equals("(")&&
            !sArry[i].equals(")")){
                houx.push(sArry[i]);
                continue;
                //否则是字符，若符号栈为空直接入栈
            }else if(fuhao.isEmpty()){
                fuhao.push(sArry[i]);
                continue;
                //如果为（括号，直接入符号栈
            }else if(sArry[i].equals("(")){
                fuhao.push(sArry[i]);
                continue;
                //如果为）括号
            }else if(sArry[i].equals(")")){
                //不断出栈，直到（括号出现
                while(!fuhao.peek().equals("(")){
                    houx.push(fuhao.pop());
                }
                fuhao.pop();//清掉(括号
                //如果不为空，且要入的符号比符号栈顶的符号优先级高，则直接push
            }else if(!fuhao.isEmpty()&&check(sArry[i],fuhao.peek())){
                fuhao.push(sArry[i]);
                continue;
                //否则，将符号栈内优先级高的符号出栈，push入houx栈，再将符号存进符号栈
            }else{
                houx.push(fuhao.pop());
                fuhao.push(sArry[i]);
                continue;
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
        if((b.equals("*")||b.equals("/"))&&(a.equals("+")||a.equals("-"))){
            return false;
        }
        //b<a
        if((b.equals("+")||b.equals("-"))&&(a.equals("*")||a.equals("/"))){
            return true;
        }
        return false;
    }
    //出栈计算
    public Double suan() {
        backsort();//后续排序
        //结果栈end
        Stack<Double> end = new Stack<Double>();
        //遍历houx栈
        for (int i = 0; i < houx.size(); i++) {
            if (houx.get(i).equals("+")) {
                Double b = end.pop();
                Double a = end.pop();
                end.push(a + b);
                continue;
                //如果是减号，end pop出栈两个数字，计算后入栈
            } else if (houx.get(i).equals("-")) {
                Double b = end.pop();
                Double a = end.pop();
                end.push(a - b);
                continue;
                //如果是乘号，end pop出栈两个数字，计算后入栈
            } else if (houx.get(i).equals("*")) {
                Double b = end.pop();
                Double a = end.pop();
                end.push(a * b);
                continue;
                //如果是除号，end pop出栈两个数字，计算后入栈
            } else if (houx.get(i).equals("/")) {
                Double b = end.pop();
                Double a = end.pop();
                end.push(a / b);
                continue;
            } else if (houx.get(i).isEmpty()) {
                continue;
            } else {
                //不是符号，也就是数字的情况，转类型，push入栈
                end.push(Double.parseDouble(houx.get(i)));
            }

        }
        //输入结果
        return end.pop();
        }
    }
class Calculator{
    static String str="";
    public Double Eval(String str){
        //结构化
        Caculater cl=new Caculater(str);
        //计算
        Double result=cl.suan();
        return result;
    }
}

