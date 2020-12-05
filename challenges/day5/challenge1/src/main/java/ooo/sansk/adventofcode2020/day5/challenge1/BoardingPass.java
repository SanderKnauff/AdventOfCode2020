package ooo.sansk.adventofcode2020.day5.challenge1;

public class BoardingPass {

    private static final int ROWS = 127;
    private static final int COLUMNS = 7;

    private int id;
    private int row;
    private int column;

    public BoardingPass(int id, int row, int column) {
        this.id = id;
        this.row = row;
        this.column = column;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "BoardingPass{" +
            "id=" + id +
            ", row=" + row +
            ", column=" + column +
            '}';
    }

    public static BoardingPass parseBoardingPass(String pass) {
        int row = readBinaryPartition(pass.substring(0, 7), 0, ROWS, 'F');
        int column = readBinaryPartition(pass.substring(7, 10), 0, COLUMNS, 'L');
        int id = (row * 8) + column;

        return new BoardingPass(id, row, column);
    }

    private static int readBinaryPartition(String searchString, int searchRangeLower, int searchRangeHigher, char lower) {
        if(searchString.isEmpty()) {
            return searchRangeLower;
        }
        int middle = (searchRangeLower + searchRangeHigher) / 2;
        return searchString.charAt(0) == lower
            ? readBinaryPartition(searchString.substring(1), searchRangeLower, middle, lower)
            : readBinaryPartition(searchString.substring(1), middle + 1, searchRangeHigher, lower);
    }

}
