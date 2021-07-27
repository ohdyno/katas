const { rps } = require("./rps");

describe("rock paper scissors", () => {
  let uiSpy;

  beforeEach(() => {
    uiSpy = {
      playerOneWins: jest.fn(),
      playerTwoWins: jest.fn(),
      tie: jest.fn()
    };
  });

  describe("player 1 win scenarios", () => {
    test("rock vs scissors", () => {
      rps("rock", "scissors", uiSpy)
      expect(uiSpy.playerOneWins).toHaveBeenCalled();
      expect(uiSpy.playerTwoWins).not.toHaveBeenCalled();
    });
    test("scissors vs paper", () => {
      rps("scissors", "paper", uiSpy)
      expect(uiSpy.playerOneWins).toHaveBeenCalled();
      expect(uiSpy.playerTwoWins).not.toHaveBeenCalled();
    });
  });
  describe("player 2 win scenarios", () => {
    test("scissors vs rock", () => {
      rps("scissors", "rock", uiSpy)
      expect(uiSpy.playerTwoWins).toHaveBeenCalled();
      expect(uiSpy.playerOneWins).not.toHaveBeenCalled();
    });
    test("rock vs paper", () => {
      rps("rock", "paper", uiSpy)
      expect(uiSpy.playerTwoWins).toHaveBeenCalled();
      expect(uiSpy.playerOneWins).not.toHaveBeenCalled();
    });

    it("players are tied", () => {
      rps("rock","rock", uiSpy)
      expect(uiSpy.tie).toHaveBeenCalled();
      expect(uiSpy.playerOneWins).not.toHaveBeenCalled();
      expect(uiSpy.playerTwoWins).not.toHaveBeenCalled();
    });

    it("spec name", () => {
      rps("paper", "rock", uiSpy)
      expect(uiSpy.playerTwoWins).not.toHaveBeenCalled();
      expect(uiSpy.playerOneWins).toHaveBeenCalled();
      expect(uiSpy.tie).not.toHaveBeenCalled();
    });
  });
});

