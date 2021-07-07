function rps(player1, player2) {
  if (player1 === "rock" && player2 === "scissors"
    || player1 === "scissors" && player2 === "paper") {
    return "player 1 wins";
  }
  return "player 2 wins";
}

module.exports = rps;

