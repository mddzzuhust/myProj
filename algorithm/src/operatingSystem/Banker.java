package operatingSystem;

import java.util.Scanner;

/**
 * 操作系统实验-银行家算法
 * @author HP
 *
 */
public class Banker {

    private static int[] Avaiable;//系统可利用资源向量数组。其元素值代表每一类资源的个数
    private static int[][] Max;//最大需求矩阵。大小为n*m 其定义了系统中n个进程中，分别对m类资源的最大需求数
    private static int[][] Allocation;//分配矩阵。大小为n*m，其定义了系统中n个进程中，已分配的m类资源数
    private static int[][] Need;//需求矩阵。大小为n*m，其定义了n个进程m类资源的尚缺资源数

    //初始化系统的进程和资源数以及资源分配情况
    public static void initSource() {
        System.out.println("---<银行家算法之例>---"
                + "\n假设系统中有5个进程P0-P4、和三类资源A、B、C、\nT0时刻，系统的资源分配情况如下：");
        Avaiable=new int[] {3,3,2};
        Max=new int[][] {{7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3}};
        Allocation =new int[][] {{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}};
        Need= new int[][] {{7,4,3},{1,2,2},{6,0,0},{0,1,1},{4,3,1}};
    }
    //资源分配表
    public static void look() {
        System.out.println("\n资源\tMax\tAllocation\tNeed\tAvailable");
        System.out.println("      A、B、C\t  A、B、C\t       A、B、C\t  A、B、C");
        for(int i=0;i<5;i++) {
            System.out.print("P"+i+"    ");
            for(int j=0;j<3;j++) {
                System.out.print(Max[i][j]+" ");
            }
            System.out.print("\t  ");
            for(int j=0;j<3;j++) {
                System.out.print(Allocation[i][j]+" ");
            }
            System.out.print("       ");
            for(int j=0;j<3;j++) {
                System.out.print(Need[i][j]+" ");
            }
            if(i==0) {
                System.out.print("\t  ");
                for(int j=0;j<3;j++) {
                    System.out.print(Avaiable[j]+" ");
                }
            }
            System.out.println();
        }
    }
    //银行家算法
    public static void banker() {
        Scanner sc=new Scanner(System.in);
        int count=0;//标志变量
        int pceNum;//请求进程
        int[] Request=new int[3];//请求向量
        System.out.print("\n请选择请求资源的进程(进程号：0···)：");
        pceNum=sc.nextInt();//用户选择进程
        System.out.print("请输入A、B、C类资源的请求个数：");
        for(int i=0;i<3;i++) {
            Request[i]=sc.nextInt();
        }
        for(int j=0;j<3;j++) {
            if(Request[j]<=Need[pceNum][j]) {//判断请求资源是否小于所需资源
                if(Request[j]<=Avaiable[j]) {//判断请求资源是否小于可利用资源
                    //试探分配资源给该进程
                    Avaiable[j]-=Request[j];
                    Allocation[pceNum][j]+=Request[j];
                    Need[pceNum][j]-=Request[j];
                    count++;
                }else {
                    System.out.println("---------------请求资源大于系统可利用资源！");
                    break;
                }
            }else {
                System.out.println("---------------请求资源大于所需资源最大值！");
                break;
            }
        }
        if(count==3) {
            if(safe()) {//当试探分配完成后，检查系统是否安全
                System.out.println("\n--------------可分配资源，进程请求资源成功！");
            }else {//系统不安全，则返还试探分配的资源
                for(int j=0;j<3;j++) {
                    Avaiable[j]+=Request[j];
                    Allocation[pceNum][j]-=Request[j];
                    Need[pceNum][j]+=Request[j];
                }
                System.out.println("-------------请求失败！若分配资源系统将处于不安全状态！");
            }
        }
    }
    //安全性检查算法
    public static boolean safe() {
        //工作资源向量数组。其元素值代表每一类资源可利用的资源的个数。Work=Available
        int[] Work=new int[3];
        //大小为进程数量，表示系统是否有足够资源分配给进程，如是Finish[i]=true.初始化Finish，先假设所有进程资源都未释放。
        boolean[] Finish=new boolean[] {false,false,false,false,false};
        int seq[]=new int[5];//安全序列数组，存放安全进程序列
        int count0=0;//判断安全进程个数
        for(int i=0;i<3;i++) {//令工作向量值=可利用资源向量值
            Work[i]=Avaiable[i];
        }
        for(int i=0;i<5;i++) {//循环检索，依次找出可满足资源的进程
            //每次检索从5个进程中查找出为满足资源释放的进程
            for(int j=0;j<5;j++) {//j表示进程的序号
                if(Finish[j]==false) {//false未释放资源进程，开始判断
                    int count1=0;//用来计数每一类资源是否满足
                    for(int k=0;k<3;k++) {//检查是否ABC三类资源都满足，k表示每类资源
                        if(Need[j][k]<=Work[k])  count1++;
                    }
                    if(count1==3) {//如果三类资源都满足
                        for(int l=0;l<3;l++) {//l表示每类资源
                            //将进程已分配每类资源都释放
                            Work[l]+=Allocation[j][l];
                        }
                        Finish[j]=true;//释放完成，记为true
                        seq[i]=j;//将该进程记录到安全序列
                        count0++;//
                        break;//找到符合进程，记录序列号，跳出循环
                    }
                }else {
                    continue;//结束本次循环，检索下一进程
                }
            }
        }
        if(count0==5) {
            System.out.print("---系统状态安全！\n存在安全序列：");
            for (int i : seq) {
                System.out.print("P"+i+"、");
            }
            return true;
        }else {
            System.out.println("系统状态不安全！分配资源失败！");
            return false;
        }

    }
    //主调用函数
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int op;boolean yes=true;//控制菜单选择的变量
        initSource();//初始化系统状态
        look();//查看资源分配表
        System.out.println("\n----操作选择----\n"
                + "*1.查看资源分配表\n"
                + "*2.查看系统安全状态\n"
                + "*3.请求资源\n"
                + "*4.退出");
        while(yes){
            System.out.print("\n请选择操作：");
            op=scanner.nextInt();
            switch (op) {
                case 1: {look();break;}//查看资源分配表
                case 2: {safe();break;}//系统安全检查
                case 3: {banker();break;}//银行家算法请求资源
                case 4: {yes=false;break;}
                default:
                    throw new IllegalArgumentException("Unexpected value: " + op);
            }
        }
        System.out.println("----------结束！");
        scanner.close();
    }
}

