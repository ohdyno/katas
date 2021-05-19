const Song = require("./Song.js");

class Lesson2Variable extends Song.Song {
  constructor() {
    super();
  }

  singBottlesOfBeer() {
    this.sing("100 bottles of beer on the wall");
    this.sing("100 bottles of beer");
    this.sing("Take one down, pass it around");
    this.sing("99 bottles of beer on the wall");
    this.sing("99 bottles of beer on the wall");
    this.sing("99 bottles of beer");
    this.sing("Take one down, pass it around");
    this.sing("98 bottles of beer on the wall");
  }
}


module.exports = {
  Lesson2Variable
}
