class Song {
  constructor() {
    this.song = "";
  }

  sing(text) {
    this.song += text + "\n";
  }
}


module.exports = {
  Song
}
