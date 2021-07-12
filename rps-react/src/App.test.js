import { render, screen } from "@testing-library/react";
import App from "./App";
import userEvent from "@testing-library/user-event";
import { rps } from "rps";

it("given player one wins, when the app renders, then the app shows 'player 1 wins'", () => {
  const rpsStub = (player1, player2, ui) => {
    ui.playerOneWins();
  };
  render(<App rps={rpsStub} />);
  userEvent.click(screen.getByTestId("play"));
  const winnerText = screen.getByText(/player 1 wins/i);
  expect(winnerText).toBeInTheDocument();
});

it("given player two wins, when the app renders, then the app shows 'player 2 wins'", () => {
  const rpsStub = (player1, player2, ui) => {
    ui.playerTwoWins();
  };
  render(<App rps={rpsStub} />);
  userEvent.click(screen.getByTestId("play"));
  const winnerText = screen.getByText(/player 2 wins/i);
  expect(winnerText).toBeInTheDocument();
});

it("given the user filled in 'rock' for player one and 'scissors' for player two, when the user clicks 'play', then the user sees 'player 1 wins'", () => {
  // given
  render(<App rps={rps} />);

  // fill text field with 'rock'
  userEvent.type(screen.getByTestId("playerOne"), "rock");
  // fill text field with 'scissor'
  userEvent.type(screen.getByTestId("playerTwo"), "scissors");

  // when
  // click the play button
  userEvent.click(screen.getByTestId("play"));

  // then
  const winnerText = screen.getByText(/player 1 wins/i);
  expect(winnerText).toBeInTheDocument();
});
