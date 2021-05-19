const Song = require("./Song.js");

class Lesson1Straight extends Song.Song {
  constructor() {
    super();
  }

  singCatSong() {
    this.sing("We gave the cat to a little kid");
    this.sing("But the cat came back");
    this.sing("The very next day");
    this.sing("Oh the cat came back");
    this.sing("We thought he was a goner");
    this.sing("But the cat came back, he just wouldn't go away");
    this.sing("We sent the cat out on a boat");
    this.sing("But the cat came back");
    this.sing("The very next day");
    this.sing("Oh the cat came back");
    this.sing("We thought he was a goner");
    this.sing("But the cat came back, he just wouldn't go away");
  }
}


module.exports = {
  Lesson1Straight
}
