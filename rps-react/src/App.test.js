import { render, screen } from "@testing-library/react";
import App from "./App";

it("spec name", () => {
  //given player 1 chooses rock and player 2 chooses scissors

  //when the component renders

  const rpsStub = (player1, player2, ui) => {
    ui.playerOneWins();
  };
  render(<App rps={rpsStub} />);
  //then player 1 wins is displayed
  const winnerText = screen.getByText(/player 1 wins/i);
  expect(winnerText).toBeInTheDocument();
});
