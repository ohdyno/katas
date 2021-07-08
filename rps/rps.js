module.exports = {
  rps: function(player1, player2, ui) {
    if (player1 === "rock" && player2 === "scissors"
      || player1 === "scissors" && player2 === "paper") {
      ui.playerOneWins();
      return;
    }
    ui.playerTwoWins();
  }
};

