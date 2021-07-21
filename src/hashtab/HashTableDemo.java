package hashtab;

import java.util.Scanner;

/**
 * @className: HashTableDemo
 * @author: coderhls
 * @date: 2021/7/21
 * @description: 有一个公司，当有新的员工来报道时，要求将该员工的信息加入(id, 性别, 年龄, 住址……)，当输入该员工的id时，要求查找该员工的所有信息
 * 不使用数据库，速度越快越好；
 * 添加时，保证按照id从低到高插入
 **/
public class HashTableDemo {
    public static void main(String[] args) {
        // 创建哈希表
        HashTab hashTab = new HashTab(7);

        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list：显示雇员");
            System.out.println("find：查找雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }
}

class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    /**
     * 表示有多少条链表
     */
    private int size;

    /**
     * 构造器初始化链表大小
     * @param size
     */
    public HashTab(int size) {
        this.size = size;
        // 初始化链表数组
        empLinkedListArray = new EmpLinkedList[size];
        // 初始化每一条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加
     * 根据员工的id得到该员工应该添加到哪条链表
     * @param emp
     */
    public void add(Emp emp) {
        int empLinkedListNo = hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);

    }

    /**
     * 遍历hash表
     */
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    /**
     * 散列函数
     * 取模法实现
     * @param id
     * @return
     */
    public int hashFun(int id) {
        return id % size;
    }

    /**
     * 根据id查找
     * @param id
     */
    public void findById(int id) {
        // 使用散列函数确定到哪条链表查找
        int empNo = hashFun(id);
        Emp emp = empLinkedListArray[empNo].findById(id);
        if (emp != null) {
            System.out.printf("在第%d条链表中找到雇员 id=%d\n", empNo, id);
        } else {
            System.out.println("没有找到该雇员");
        }
    }
}

class EmpLinkedList {
    /**
     * 头指针，执行第一个Emp，因此这个链表的head直接指向第一个Emp
     */
    private Emp head;

    /**
     * 添加雇员
     * 假定添加雇员时，id是自增长得，即id从小到大分配
     * 因此将该雇员直接加入到本链表的最后即可
     * @param emp 需要添加的雇员
     */
    public void add(Emp emp) {
        // 第一个添加
        if (head == null) {
            head = emp;
            return;
        }
        // 不是第一个，找到最后一个节点
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) break;
            curEmp = curEmp.next;
        }
        // 退出即找到最后一个节点
        curEmp.next = emp;
    }

    public void list(int no){
        if (head == null) {
            System.out.println("当前链表: " + no + " 为空");
            return;
        }
        System.out.println("当前链表: " + no + " 的信息为：");
        Emp curEmp = head;
        while (true) {
            System.out.printf("=>id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) break;
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    /**
     * 根据id查找雇员
     * @param id
     * @return 找到返回雇员，没找到返回null
     */
    public Emp findById(int id) {
        // 判断是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break;
            }
            if (curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}

class Emp {
    public int id;
    public String name;
    /**
     * 默认为空
     */
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
