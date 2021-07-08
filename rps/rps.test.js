const { requestResponseRps, observerRps } = require("./rps");

describe("in request/response pattern", () => {
  describe("player 1 win scenarios", () => {
    test("rock vs scissors", () => {
      expect(requestResponseRps("rock", "scissors")).toEqual("player 1 wins");
    });
    test("scissors vs paper", () => {
      expect(requestResponseRps("scissors", "paper")).toEqual("player 1 wins");
    });
  });
  describe("player 2 win scenarios", () => {
    test("scissors vs rock", () => {
      expect(requestResponseRps("scissors", "rock")).toEqual("player 2 wins");
    });
    test("rock vs paper", () => {
      expect(requestResponseRps("rock", "paper")).toEqual("player 2 wins");
    });
  });
});

describe("in observer pattern", () => {
  let uiSpy;

  beforeEach(() => {
    uiSpy = {
      playerOneWins: jest.fn(),
      playerTwoWins: jest.fn()
    };
  });

  describe("player 1 win scenarios", () => {
    test("rock vs scissors", () => {
      observerRps("rock", "scissors", uiSpy);
      expect(uiSpy.playerOneWins).toHaveBeenCalled();
      expect(uiSpy.playerTwoWins).not.toHaveBeenCalled();
    });
    test("scissors vs paper", () => {
      observerRps("scissors", "paper", uiSpy);
      expect(uiSpy.playerOneWins).toHaveBeenCalled();
      expect(uiSpy.playerTwoWins).not.toHaveBeenCalled();
    });
  });
  describe("player 2 win scenarios", () => {
    test("scissors vs rock", () => {
      observerRps("scissors", "rock", uiSpy);
      expect(uiSpy.playerTwoWins).toHaveBeenCalled();
      expect(uiSpy.playerOneWins).not.toHaveBeenCalled();
    });
    test("rock vs paper", () => {
      observerRps("rock", "paper", uiSpy);
      expect(uiSpy.playerTwoWins).toHaveBeenCalled();
      expect(uiSpy.playerOneWins).not.toHaveBeenCalled();
    });
  });
});

function capitalizeFromRequestResponse() {
  let bar = requestResponseRps("rock", "scissors");
  if (bar === "player 1 wins") {
    console.log("PLAYER ONE HAS WON");
  } else {
    console.log("PLAYER TWO HAS WON");
  }
}

function lowercaseFromRequestResponse() {
  let bar = requestResponseRps("rock", "scissors");
  if (bar === "player 1 wins") {
    console.log("player one has won");
  } else {
    console.log("player two has won");
  }
}

function capitalizeFromObserver() {
  let ui = {
    playerOneWins: () => {
      console.log("PLAYER ONE HAS WON");
    },
    playerTwoWins: () => {
      console.log("PLAYER TWO HAS WON");
    }
  };
  observerRps("rock", "scissors", ui);
}

function lowercaseFromObserver() {
  let ui = {
    playerOneWins: () => {
      console.log("player one has won");
    },
    playerTwoWins: () => {
      console.log("player two has won");
    }
  };
  observerRps("rock", "scissors", ui);
}
