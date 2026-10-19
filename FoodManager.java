import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 食材管理类
 * 负责食材的添加、查询和过期判断
 */
public class FoodManager {
    private List<Food> foodList = new ArrayList<>();

    /** 添加食材 */
    public void addFood(String name, int daysUntilExpire) {
        foodList.add(new Food(name, daysUntilExpire));
        System.out.println("已添加食材：" + name);
    }

    /** 查看所有食材 */
    public void listAllFoods() {
        if (foodList.isEmpty()) {
            System.out.println("暂无食材记录");
            return;
        }
        System.out.println("=== 当前食材列表 ===");
        for (Food f : foodList) {
            System.out.println(f.getName() + "（剩余保质期：" + f.getDaysUntilExpire() + "天）");
        }
    }

    /** 查找过期或即将过期的食材（3天内） */
    public void checkExpiringFoods() {
        System.out.println("=== 过期提醒 ===");
        boolean found = false;
        for (Food f : foodList) {
            if (f.getDaysUntilExpire() <= 3) {
                System.out.println("注意：" + f.getName() + " 即将过期（剩余" + f.getDaysUntilExpire() + "天）");
                found = true;
            }
        }
        if (!found) {
            System.out.println("所有食材都在保质期内");
        }
    }

    /** 食材内部类 */
    static class Food {
        private String name;
        private int daysUntilExpire;

        public Food(String name, int daysUntilExpire) {
            this.name = name;
            this.daysUntilExpire = daysUntilExpire;
        }

        public String getName() { return name; }
        public int getDaysUntilExpire() { return daysUntilExpire; }
    }
}
