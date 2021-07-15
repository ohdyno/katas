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

it("given the user filled in 'rock' for player one and 'scissors' for player two," +
  "when the user clicks 'play'," +
  "then the user sees 'player 1 wins'", () => {
  render(<App rps={rps} />);
  userEvent.type(screen.getByLabelText(/player one choice/i), "rock");
  userEvent.type(screen.getByLabelText(/player two choice/i), "scissors");
  userEvent.click(screen.getByText(/play round/i));

  const winnerText = screen.getByText(/player 1 wins/i);
  expect(winnerText).toBeInTheDocument();
});

it("spec name", () => {
  //given component renders
  const rpsFunc = jest.fn();
  render(<App rps={rpsFunc} />);
  //when input is filled in as p1 rock p2 scissors
  userEvent.type(screen.getByLabelText(/player one choice/i), "rock");
  userEvent.type(screen.getByLabelText(/player two choice/i), "scissors");
  userEvent.click(screen.getByText(/play round/i));
  //then we expect that winner is equal to player 1 wins

  expect(rpsFunc).toBeCalledWith("rock","scissors", expect.anything());
});

it("should display tie when rps retuen result as tie", () => {
  const rpsStub = (player1, player2, ui) => {
    ui.tie();
  };
  // given rps return tie

  // when render UI
  render(<App rps={rpsStub} />);
  userEvent.type(screen.getByLabelText(/player one choice/i), "rock");
  userEvent.type(screen.getByLabelText(/player two choice/i), "scissors");
  userEvent.click(screen.getByText(/play round/i));
  // then display tie
  const winnerText = screen.getByText(/tie/i);
  expect(winnerText).toBeInTheDocument();
});

