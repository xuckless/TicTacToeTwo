public class TicTacToeLogic {
  String table[][];
  int counter;
  int moveCount;
  String moveLogger[];
  String removedElement = null;
  
  TicTacToeLogic(){
    this.table = new String[3][3];
    this.moveLogger = new String[7];
    this.counter = 0;
    this.moveCount = 0;
  }
  
  void appendCounter(){
    this.counter+=1;
  }
  void logMove(String key){
    if (this.moveCount < 7){
      moveLogger[moveCount] = key;
      moveCount++;
    }
    else {
      for (int i = 0; i < 6; i++) {
        removedElement = moveLogger[0];
        moveLogger[i] = moveLogger[i + 1];
      }
      moveLogger[6] = key;
      this.removeFromArray(removedElement);
    }
  }
  
  public String getRemovedElement() {
    return removedElement;
  }
  
  String[][] getTable(){
    return this.table;
  }
  
  boolean winCondition() {
    for (int i = 0; i < 3; i++ ){
      if (isRowWin(i) || isColumnWin(i)) {
        return true;
      }
    }
    
    if (isDiagonalWin()) {
      return true;
    }
    return false;
  }
  
  String returnStr(){
    if (counter % 2 == 0){
      return "O";
    }
    else return "X";
  }
  
  void updateArray(int row, int col, String returnStr){
    table[row][col] = returnStr;
  }
  
  void removeFromArray(String key){
    String i = String.valueOf(key.charAt(0));
    String j = String.valueOf(key.charAt(key.length()-1));
    
    int row = Integer.parseInt(i);
    int col = Integer.parseInt(j);
    
    this.table[row][col] = " ";
  }
  
   void flushGame(){
     this.table = new String[3][3];
     this.moveLogger = new String[7];
     this.counter = 0;
     this.moveCount = 0;
  }
  
  
  
  private boolean isRowWin(int row) {
    String first = table[row][0];
    if (first != null && first.equals(table[row][1]) && first.equals(table[row][2])) {
      return true;
    }
    return false;
  }
  
  private boolean isColumnWin(int col) {
    String first = table[0][col];
    if (first != null && first.equals(table[1][col]) && first.equals(table[2][col])) {
      return true;
    }
    return false;
  }
  
  private boolean isDiagonalWin() {
    String center = table[1][1];
    if (center != null) {
      if (center.equals(table[0][0]) && center.equals(table[2][2])) {
        return true;
      }
      if (center.equals(table[0][2]) && center.equals(table[2][0])) {
        return true;
      }
    }
    return false;
  }
}
