package concave.game.Input;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class ClickHandler extends MouseAdapter {

    private final int CELL_SIZE;  // 각 셀의 크기
    private final int BOARD_SIZE;  // 오목판 크기
    private final int[][] board;    // 돌 상태 저장 배열

    public ClickHandler(int boardSize, int cellSize, int[][] board) {
        this.BOARD_SIZE = boardSize;
        this.CELL_SIZE = cellSize;
        this.board = board;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // 마우스 클릭 위치 감지
        int mouseX = e.getX();
        int mouseY = e.getY();
        handleMouseClick(mouseX, mouseY);
    }

    private void handleMouseClick(int mouseX, int mouseY) {
        // 클릭한 위치의 셀 좌표 계산
        int clickedRow = mouseX / CELL_SIZE;
        int clickedCol = mouseY / CELL_SIZE;

        // 유효한 클릭인지 확인 (오목판 범위 내)
        if (clickedRow >= 0 && clickedRow < BOARD_SIZE && clickedCol >= 0 && clickedCol < BOARD_SIZE) {
            // 비어있는 셀인지 확인 후 돌 놓기 (1: 흑돌, 2: 백돌)
            if (board[clickedRow][clickedCol] == 0) {
                board[clickedRow][clickedCol] = 1;  // 예시로 흑돌을 놓음 (실제 게임에서는 흑백 차례를 고려해야 함)
                // 여기서 repaint() 메서드를 호출할 수 있는 인터페이스를 통해 전달할 수 있어
                // 예를 들어, Callback 메서드를 정의해 GUI에서 repaint를 호출하게 할 수 있음
            }
        }
    }
}
