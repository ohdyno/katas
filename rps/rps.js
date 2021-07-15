function playerOneOrTwoWins(player1, player2, ui) {
  if (player1 === "rock" && player2 === "scissors" || player1 === "scissors" && player2 === "paper" || player1 === "paper" && player2 === "rock") {
    ui.playerOneWins();
  } else {
    ui.playerTwoWins();
  }
}

module.exports = {
  rps: function(player1, player2, ui) {
    if (player1 === player2) {
      ui.playersAreTied();
    } else {
      playerOneOrTwoWins(player1, player2, ui);
    }
  }

};

