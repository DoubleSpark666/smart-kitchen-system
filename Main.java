import java.util.Scanner;

/**
 * 智能食材厨电管理系统 - 主程序入口
 */
public class Main {
    public static void main(String[] args) {
        FoodManager manager = new FoodManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== 智能食材厨电管理系统 =====");

        while (true) {
            System.out.println("\n请选择操作：");
            System.out.println("1. 添加食材");
            System.out.println("2. 查看食材列表");
            System.out.println("3. 过期提醒");
            System.out.println("4. 退出");
            System.out.print("请输入选项：");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("请输入食材名称：");
                    String name = scanner.next();
                    System.out.print("请输入剩余保质期（天）：");
                    int days = scanner.nextInt();
                    manager.addFood(name, days);
                    break;
                case 2:
                    manager.listAllFoods();
                    break;
                case 3:
                    manager.checkExpiringFoods();
                    break;
                case 4:
                    System.out.println("感谢使用，再见！");
                    scanner.close();
                    return;
                default:
                    System.out.println("输入有误，请重新选择");
            }
        }
    }
}
