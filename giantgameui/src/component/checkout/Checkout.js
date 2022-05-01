import React, { Component } from "react";

class Checkout extends Component {
  state = { games: this.props.games };

  checkout = () => {
    this.setState({ games: [] });
  };

  search = () => {
    this.props.onChangeView("search");
  };

  render() {
    return (
      <div>
        <button onClick={this.search}>Back To Search</button>
        <button
          onClick={this.checkout}
          disabled={this.state.games.length === 0}
        >
          Rent
        </button>
        {this.state.games.map((game, index) => (
          <div key={index}>
            <img
              src={game.thumbnail}
              height="100"
              width="100"
              alt={game.description}
            />
            <label>{game.name}</label>
          </div>
        ))}
      </div>
    );
  }
}

export default Checkout;
