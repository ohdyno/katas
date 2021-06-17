export class Grid {
   let board=[];
  constructor(row, col) {
   this.board = new Array(row); // create an empty array of length n
   for (let i = 0; i < row; i++) {
    this.board[i] = new Array(col); // make each element an array
   }
  }

  isEmpty() {
    return true;
  }

  addSeed(number, number2) {

  }

  isAlive(number, number2) {
    return true;
  }
}
