import "./App.css";

function App(props) {
  let winner = '';
  let ui = {
    playerOneWins() {
      winner = "player 1 wins";
    },

    playerTwoWins() {
      winner = "player 2 wins";
    }
  };

  let playerOneChoice = "";
  let playerTwoChoice = "";

  function playRps() {
    props.rps(playerOneChoice, playerTwoChoice, ui);
  }

  return (
    <div className="App">
      <input value={playerOneChoice} data-testid={"playerOne"} />
      <input value={playerTwoChoice} data-testid={"playerTwo"} />
      <button data-testid={"play"} onClick={playRps} />
      <div>
        {winner}
      </div>
    </div>
  );
}

export default App;
