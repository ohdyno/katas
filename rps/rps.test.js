const rps = require("./rps");
describe("player 1 win scenarios", () => {
  test("rock vs scissors", () => {
    expect(rps("rock", "scissors")).toEqual("player 1 wins");
  });
  test("scissors vs paper", () => {
    expect(rps("scissors", "paper")).toEqual("player 1 wins");
  });
  test("scissors vs paper", () => {
    expect(rps("scissors", "paper")).toEqual("player 1 wins");
  });
});

describe("player 2 win scenarios", () => {
  test("scissors vs rock", () => {
    expect(rps("scissors", "rock")).toEqual("player 2 wins");
  });
  test("rock vs paper", () => {
    expect(rps("rock", "paper")).toEqual("player 2 wins");
  });
});
