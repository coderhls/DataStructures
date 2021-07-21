package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @className: PolandNotation
 * @author: coderhls
 * @date: 2021/7/10
 * @description: 中缀表达式 转 逆波兰表达式
 **/
public class PolandNotation2 {
    public static void main(String[] args) {
        // 定义表达式 (3+4)×5-6
        String expression  = "1+((2+3)*4)-5";
        List<String> list = toInfixExpressionList(expression);
        System.out.println(list);
        List<String> list1 = parseSuffixExpressionList(list);
        System.out.println(list1);
        System.out.println(calculate(list1));
    }

    public static List<String> parseSuffixExpressionList(List<String> list){
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();
        for (String s : list) {
            // 如果是一个数，就加入s2
            if (s.matches("\\d+")) {
                s2.add(s);
            } else if ("(".equals(s)) {
                s1.push(s);
            } else if (")".equals(s)) {
                while (!"(".equals(s1.peek())) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                // 当s的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(s)) {
                    s2.add(s1.pop());
                }
                s1.push(s);
            }
        }
        // 将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    /**
     * 将表达式转换为中缀表达式
     * @param expression 表达式
     * @return 中缀表达式
     */
    public static List<String> toInfixExpressionList(String expression) {
        List<String> list = new ArrayList<>();
        int i = 0;
        // 对多位数的拼接
        String str;
        // 每遍历一个字符，就放入c
        char c;
        do {
            // c 为非数字
            if ((c=expression.charAt(i)) < 48 || (c=expression.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else { // c为多位数
                str = "";
                while (i < expression.length() && (c=expression.charAt(i)) >= 48 && (c=expression.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }
        } while (i < expression.length());
        return list;
    }

    public static int calculate(List<String> list) {

        Stack<String> stack = new Stack<>();
        for (String s : list) {
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if ("+".equals(s)) {
                    res = num1 + num2;
                } else if ("-".equals(s)) {
                    res = num1 - num2;
                } else if ("*".equals(s)) {
                    res = num1 * num2;
                } else if ("/".equals(s)) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符错误");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

/**
 * 封装运算符对应的悠闲居
 */
class Operation {
    private static final int ADD = 1;
    private static final int SUB = 1;
    private static final int MUL = 2;
    private static final int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
            result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符: " + operation);
                break;
        }
        return result;
    }
}
