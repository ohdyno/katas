const Song = require("./Song.js");

class Lesson31 extends Song.Song {
  constructor() {
    super();
  }

  singSong(style, names) {
    switch (style) {
      case 1 :
        for (var i = 0; i < names.length; i++) {
          var name = names[i];
          if (name.startsWith("L")) {
            this.sing("Hip Hip Horray! For " + name);
          }
          else {
            this.sing("Hello " + name + ", it's nice to meet you.");
          }
        }
        break;
      case 2 :
        for (var i = 0; i < names.length; i++) {
          var name = names[i];
          if (name.includes("a")) {
            this.sing(name.toUpperCase() + "! Yay " + name + "!");
          }
          else {
            this.sing("Hello " + name + ", it's nice to meet you.");
          }
        }
        break;
      case 3 :
        for (var i = 0; i < names.length; i++) {
          var name = names[i];
          this.sing("Hello " + name + ", it's nice to meet you.");
        }
        break;
    }
  }
}


module.exports = {
  Lesson31
}
