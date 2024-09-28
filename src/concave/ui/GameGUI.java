package concave.ui;

import concave.core.ConcaveGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameGUI extends JFrame {
    private static final int BOARD_SIZE = 15;
    private static final int CELL_SIZE = 40;
    private ConcaveGame game;

    public GameGUI(ConcaveGame game) {
        this.game = game;

        setTitle("오목 게임");
        setSize(BOARD_SIZE * CELL_SIZE, BOARD_SIZE * CELL_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

//        // 마우스 클릭 이벤트 처리
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (!game.isPlayerTurn()) {
//                    return; // 플레이어 턴이 아니면 무시
//                }
//
//                int x = e.getX() / CELL_SIZE;
//                int y = e.getY() / CELL_SIZE;
//
//                if (x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE && game.getBoard()[y][x] == game.getEmpty()) {
//                    game.makePlayerMove(x, y); // 사용자가 돌을 둠
//                    repaint(); // 화면 갱신
//                    if (game.checkWin(game.getPlayer())) {
//                        JOptionPane.showMessageDialog(null, "사용자가 승리했습니다!");
//                        game.resetBoard();
//                        repaint();
//                        return;
//                    }
//                    game.computerMove(); // 컴퓨터가 돌을 둠
//                    repaint(); // 화면 갱신
//                    if (game.checkWin(game.getComputer())) {
//                        JOptionPane.showMessageDialog(null, "컴퓨터가 승리했습니다!");
//                        game.resetBoard();
//                        repaint();
//                        return;
//                    }
//                }
//            }
//        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // 그리드 그리기
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                int x = j * CELL_SIZE;
                int y = i * CELL_SIZE;
                g.drawRect(x, y, CELL_SIZE, CELL_SIZE);

//                // 돌 그리기
//                if (game.getBoard()[i][j] == game.getPlayer()) {
//                    g.setColor(Color.BLACK);
//                    g.fillOval(x + 5, y + 5, CELL_SIZE - 10, CELL_SIZE - 10);
//                } else if (game.getBoard()[i][j] == game.getComputer()) {
//                    g.setColor(Color.WHITE);
//                    g.fillOval(x + 5, y + 5, CELL_SIZE - 10, CELL_SIZE - 10);
//                }
            }
        }
    }


}

