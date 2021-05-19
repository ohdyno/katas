const Song = require("./Song.js");

class Lesson21 extends Song.Song {
  constructor() {
    super();
  }

  singSong(style, names) {
    switch (style) {
      case 1 :
        for (var i = 0; i < names.length; i++) {
          var name = names[i];
          if (name.startsWith("L", 0)) {
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
          if (name.startsWith("am", 1)) {
            this.sing("Say yeah! Say yo! Say " + name);
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
  Lesson21
}
