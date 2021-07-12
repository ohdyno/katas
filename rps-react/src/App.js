import "./App.css";

function App(props) {
  let winner;
  let ui = {
    playerOneWins() {
      winner = "player 1 wins";
    },

    playerTwoWins() {
      winner = "player 2 wins";
    }
  };
  props.rps("rock", "scissors", ui);
  return (
    <div className="App">
      <div>
        {winner}
      </div>
    </div>
  );
}

export default App;
