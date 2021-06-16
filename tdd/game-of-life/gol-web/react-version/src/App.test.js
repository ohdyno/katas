import { render, screen } from "@testing-library/react";
import App from "./App";
import { GameBoard } from "./GOL.js";

test("renders learn react link", () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});


describe("gol suite", () => {

  it("should create a gameboard", () => {
    const gameBoard = new GameBoard(5,5);
    expect(gameBoard).not.toBeNull();
  });

  it("should add a live cell and check its alive", () => {
    const gameBoard = new GameBoard(5,5);
    gameBoard.addliveCell(0,0);
    expect(gameBoard.isAlive(0,0)).toBeTruthy();
  });

  it("should not ", () => {
    const gameBoard = new GameBoard(5, 5);
    expect(gameBoard.isAlive(0, 0)).toBeFalsy()
  });
});
