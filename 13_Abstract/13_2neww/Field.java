public class Field {
    private Object[][] field;

    public Field(int rows, int cols) {
        field = new Object[rows][cols];
    }

    public int getHeight() {
        return field.length;
    }

    public int getWidth() {
        return field[0].length;
    }

    public void place(Object obj, Location location) {
        field[location.getRow()][location.getCol()] = obj;
    }

    public Object getObjectAt(Location location) {
        return field[location.getRow()][location.getCol()];
    }

    public Location freeAdjacentLocation(Location location) {
        // Simplified: Check nearby cells for emptiness
        int row = location.getRow();
        int col = location.getCol();
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                int newRow = row + r;
                int newCol = col + c;
                if (newRow >= 0 && newRow < getHeight() && newCol >= 0 && newCol < getWidth()) {
                    if (field[newRow][newCol] == null) {
                        return new Location(newRow, newCol);
                    }
                }
            }
        }
        return null;
    }

    public Location findPrey(Location location) {
        // Check adjacent cells for a rabbit
        int row = location.getRow();
        int col = location.getCol();
        for (int r = -1; r <= 1; r++) {
            for (int c = -1; c <= 1; c++) {
                int newRow = row + r;
                int newCol = col + c;
                if (newRow >= 0 && newRow < getHeight() && newCol >= 0 && newCol < getWidth()) {
                    Object obj = field[newRow][newCol];
                    if (obj instanceof Rabbit) {
                        return new Location(newRow, newCol);
                    }
                }
            }
        }
        return null;
    }

    public void remove(Location location) {
        field[location.getRow()][location.getCol()] = null;
    }

    public void printField() {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] instanceof Rabbit) {
                    System.out.print("R ");
                } else if (field[row][col] instanceof Fox) {
                    System.out.print("F ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
