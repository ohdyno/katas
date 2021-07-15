import "./App.css";
import { useState } from "react";

function App(props) {
  const [winner, setWinner] = useState("no rounds played yet");
  const ui = {
    playerOneWins() {
      setWinner("player 1 wins");
    },

    playerTwoWins() {
      setWinner("player 2 wins");
    },

    tie() {
      setWinner("Tie");
    }
  };

  const [playerOneChoice, setPlayerOneChoice] = useState("");
  const [playerTwoChoice, setPlayerTwoChoice] = useState("");

  function setTie(tie) {

  }

  function playRps() {
    props.rps(playerOneChoice, playerTwoChoice, ui);
  }

  function updatePlayerTwoChoice(event) {
    setPlayerTwoChoice(event.target.value);
  }

  function updatePlayerOneChoice(event) {
    setPlayerOneChoice(event.target.value);
  }

  return (
    <div className="App">
      <label htmlFor={"playerOne"}>Player One Choice</label>
      <input id={"playerOne"} value={playerOneChoice} onChange={updatePlayerOneChoice} data-testid={"playerOne"} />

      <label htmlFor={"playerTwo"}>Player Two Choice</label>
      <input id={"playerTwo"} value={playerTwoChoice} onChange={updatePlayerTwoChoice} data-testid={"playerTwo"} />
      <button data-testid={"play"} onClick={playRps}>Play Round</button>
      <div>
        {winner}
      </div>
    </div>
  );
}

export default App;
