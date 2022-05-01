import "./App.css";
import React, { useState } from "react";
import Search from "./component/search/Search";
import Checkout from "./component/checkout/Checkout";

function App() {
  const [view, setView] = useState("search");
  const [games, setGames] = useState([]);

  const onChangeView = (target, games) => {
    setGames(games);
    setView(target);
  }

  return (
    <div>
      <h1>Welcome to the Giant Game Store</h1>
      {view === "search" ? (
        <Search onChangeView={onChangeView} />
      ) : (
        <Checkout onChangeView={onChangeView} games={games} />
      )}
    </div>
  );
}

export default App;
