import React, { Component } from "react";
class Search extends Component {
  state = { searchValue: "", games: [] };

  handleOnChange = (event) => {
    this.setState({ searchValue: event.target.value });
  };

  handleSearch = () => {
    this.makeApiCall(this.state.searchValue);
  };

  makeApiCall = (searchInput) => {
    var searchUrl = `/search?filter=${searchInput}`;
    fetch(searchUrl, {method: 'GET'})
      .then((response) => {
        return response.json();
      })
      .then((jsonData) => {
        console.log(jsonData.results);
        this.setState({ games: jsonData.results });
      });
  };

  toggleSelect = (game) => {
      if ( game.selected === undefined) {
        game.selected = true
      } else {
        game.selected = !game.selected
      }
  }

  checkout = () => {
    const selectedGames = this.state.games.filter((g)=>g.selected);
    this.props.onChangeView("checkout",selectedGames);
  }

  render() {
    return (
      <div>
        
        <input
          name="text"
          type="text"
          placeholder="Search"
          onChange={(event) => this.handleOnChange(event)}
          value={this.state.searchValue}
        />
        <button onClick={this.handleSearch}>Search</button>
        <button onClick={this.checkout}>Checkout</button>

        {this.state.games ? (
            
          <div>
              <br></br>
            {this.state.games.map((game, index) => (
              <div key={index}>
                <img src={game.thumbnail} height="100" width="100" alt="game-thumbnail" />
                <input onChange={()=>this.toggleSelect(game)} id={"checkbox-"+game.id} type="checkbox" />
                <label htmlFor={"checkbox-"+game.id}>{game.name}</label>
              </div>
            ))}
          </div>
        ) : (
          <p>Try searching for a game</p>
        )}
      </div>
    )
  }
}
export default Search;
