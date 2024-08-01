package Hyunsu;
import java.util.Scanner;

public class J1733_오목 {
    static int[][] board = new int[19][19];
    static int[] dx = {1, 0, 1, -1}; // 우, 하, 우하, 좌하
    static int[] dy = {0, 1, 1, 1}; // 우, 하, 우하, 좌하

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 바둑판 입력 받기
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        // 게임 결과 확인
        int result = 0;
        int x = -1, y = -1;

        outerLoop:
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) {
                    int color = board[i][j];
                    for (int d = 0; d < 4; d++) {
                        if (checkWin(i, j, color, d)) {
                            result = color;
                            x = i + 1;
                            y = j + 1;
                            break outerLoop;
                        }
                    }
                }
            }
        }

        System.out.println(result);
        if (result != 0) {
            System.out.println(x + " " + y);
        }

        scanner.close();
    }

    // 이겼는지 확인하는 함수
    private static boolean checkWin(int x, int y, int color, int direction) {
        int count = 1;
        int nx = x + dx[direction];
        int ny = y + dy[direction];

        // 연속된 바둑알 개수 세기
        while (isInBounds(nx, ny) && board[nx][ny] == color) {
            count++;
            nx += dx[direction];
            ny += dy[direction];
        }

        // 반대 방향도 체크
        nx = x - dx[direction];
        ny = y - dy[direction];
        while (isInBounds(nx, ny) && board[nx][ny] == color) {
            count++;
            nx -= dx[direction];
            ny -= dy[direction];
        }

        if (count == 5) {
            // 여섯 알 이상인지 확인
            nx = x - dx[direction];
            ny = y - dy[direction];
            if (isInBounds(nx, ny) && board[nx][ny] == color) {
                return false;
            }
            nx = x + 5 * dx[direction];
            ny = y + 5 * dy[direction];
            if (isInBounds(nx, ny) && board[nx][ny] == color) {
                return false;
            }
            return true;
        }
        return false;
    }

    // 좌표가 바둑판 내에 있는지 확인하는 함수
    private static boolean isInBounds(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }
}
