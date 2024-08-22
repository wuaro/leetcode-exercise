import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入数字范围
        System.out.println("请输入数字范围：");
        int rangeStart = scanner.nextInt(); // 范围开始
        int rangeEnd = scanner.nextInt(); // 范围结束

        // 输入玩家名称和数量
        System.out.println("请输入玩家数量：");
        int playerNum = scanner.nextInt();
        scanner.nextLine(); // 需要在nextInt()之后使用nextLine()换行符才能读取正常名称

        // 初始化玩家分数
        Map<String, Integer> playerScores = new HashMap<>();
        for (int i = 1; i <= playerNum; i++) {
            System.out.println("请输入玩家" + i + "的名称：");
            String playerName = scanner.nextLine();
            playerScores.put(playerName, 0);
        }

        // 随机生成一个数字
        Random random = new Random();
        int targetNum = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;

        // 循环让每个玩家循环输入猜测的数字
        boolean isGameEnded = false;
        while (!isGameEnded) {
            for (String playerName : playerScores.keySet()) {
                System.out.println(playerName + "，请猜测一个数字：");
                int guessNum = scanner.nextInt(); // 玩家猜测的数字

                if (guessNum == targetNum) { // 如果猜对了，该玩家得分加 1，游戏结束
                    playerScores.put(playerName, playerScores.get(playerName) + 1);
                    isGameEnded = true;
                    break; // 跳出循环
                } else { // 猜错了，输出提示信息
                    String hint = guessNum < targetNum ? "小了" : "大了";
                    System.out.println("猜错了，" + hint + "！");
                }
            }
        }

        // 输出每个玩家的分数
        System.out.println("游戏结束！");
        for (String playerName : playerScores.keySet()) {
            System.out.println(playerName + "得分：" + playerScores.get(playerName));
        }
    }
}

