const lesson1 = require("../src/Lesson1Straight");
const lesson2 = require("../src/Lesson2Variable");
const lesson21 = require("../src/Lesson21");
const lesson3 = require("../src/Lesson3HigherOrderFunctions");
const lesson31 = require("../src/Lesson31");
const approvals = require("approvals");
approvals.configure({
  reporters: ["nodediff"]
});
approvals.mocha();

describe("RegressionTest", () => {
  it("test cat song", function() {
    const song = new lesson1.Lesson1Straight();
    song.singCatSong();
    this.verify(song.song);

  });
  it("test beer", function() {
    const song = new lesson2.Lesson2Variable();
    song.singBottlesOfBeer();
    this.verify(song.song);
  });
  it("test lesson21", function() {
    const song = new lesson21.Lesson21();
    const names = ["Llewellyn", "Samatha", "Tomas", "Emilia"];
    song.singSong(1, names);
    song.singSong(2, names);
    song.singSong(3, names);
    this.verify(song.song);
  });
  it("test lesson3", function() {
    const song = new lesson3.Lesson3HigherOrderFunctions();
    song.singSong();
    this.verify(song.song);

  });
  it("test lesson31", function() {
    const song = new lesson31.Lesson31();
    const names = ["Llewellyn", "Samatha", "Tomas", "Emilia"];
    song.singSong(1, names);
    song.singSong(2, names);
    song.singSong(3, names);
    this.verify(song.song);
  });
});
