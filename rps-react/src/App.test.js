import { render, screen } from "@testing-library/react";
import App from "./App";

it("given player one wins, when the app renders, then the app shows 'player 1 wins'", () => {
  const rpsStub = (player1, player2, ui) => {
    ui.playerOneWins();
  };
  render(<App rps={rpsStub} />);
  const winnerText = screen.getByText(/player 1 wins/i);
  expect(winnerText).toBeInTheDocument();
});

it("given player two wins, when the app renders, then the app shows 'player 2 wins'", () => {
  const rpsStub = (player1, player2, ui) => {
    ui.playerTwoWins();
  };
  render(<App rps={rpsStub} />);
  const winnerText = screen.getByText(/player 2 wins/i);
  expect(winnerText).toBeInTheDocument();
});
