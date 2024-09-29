package concave.ui;

import concave.game.Input.ClickHandler;
import concave.game.StoneDto;

import javax.swing.*;
import java.awt.*;


/**
 * 2024.09.30 김규형
 * GUI 담당 swing
 */
public class GameGUI extends JFrame {
    private final int BOARD_SIZE;  // 오목판 크기
    private final int CELL_SIZE = 40;  // 각 셀의 크기
    private int[][] board;  // 돌 상태 저장 배열

    private StoneDto stoneDto;
    private ClickHandler clickHandler;  // 클릭 핸들러



    public GameGUI(int boardSize) {
        this.BOARD_SIZE = boardSize;
        setupFrame();  // 프레임 설정
        JPanel boardPanel = createBoardPanel();  // 오목판 패널 생성
        add(boardPanel);  // 패널 추가
        pack();
        setLocationRelativeTo(null);  // 화면 중앙에 위치
        setVisible(true);

        //보드 2차원 배열 생성
        board = new int[boardSize][boardSize];
    }

    // 프레임 기본 설정 메서드
    private void setupFrame() {
        setTitle("Omok Game");
        setSize(BOARD_SIZE * CELL_SIZE, BOARD_SIZE * CELL_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    // 오목판 패널 생성 메서드
    private JPanel createBoardPanel() {
        JPanel boardPanel = new JPanel() {

            /*
                repaint() 할때마다 GUI 전체를 다시 그릴 필요가 있을까?

                -> 일반적인 GUI에서는 데이터의 변경 발생시 화면 전체를 다시 그리는 것이 일반적
                   각종 이벤트의 발생으로 화면 꺠짐이 발생할 수 있기 떄문...
             */
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawBoard(g);  // 오목판 그리기
                drawStones(g);  // 돌 그리기
            }

        };

        boardPanel.addMouseListener(clickHandler);
        boardPanel.setPreferredSize(new Dimension(BOARD_SIZE * CELL_SIZE, BOARD_SIZE * CELL_SIZE));
        return boardPanel;
    }

    // 외부에서 돌 상태를 받는 메서드
    public void setBoardState(StoneDto dollDto) {
        int y = dollDto.getY();
        int x = dollDto.getX();
        int value = dollDto.getValue();

        board[y][x] = value;

        repaint();  // 데이터 갱신 후 다시 그리기
    }

    // 오목판 그리기 메서드
    private void drawBoard(Graphics g) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, BOARD_SIZE * CELL_SIZE);
            g.drawLine(0, i * CELL_SIZE, BOARD_SIZE * CELL_SIZE, i * CELL_SIZE);
        }
    }

    // 돌 그리기 메서드
    private void drawStones(Graphics g) {
        if (board == null)
            return;  // board가 없으면 그리지 않음

        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                if (board[x][y] == 1) {
                    drawStone(g, x, y, Color.BLACK);  // 흑돌 그리기
                } else if (board[x][y] == 2) {
                    drawStone(g, x, y, Color.WHITE);  // 백돌 그리기
                }
            }
        }
    }

    // 개별 돌 그리기 메서드
    private void drawStone(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillOval(x * CELL_SIZE + 5, y * CELL_SIZE + 5, CELL_SIZE - 10, CELL_SIZE - 10);
    }

}

