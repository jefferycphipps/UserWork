import React, { Component } from 'react';
//import logo from './logo.svg';
import './App.css';

class App extends Component {
  state = {
    users: []
  };

  async componentDidMount() {
    const response = await fetch('/test');
    const body = await response.json();
    this.setState({users: body});
  }

  render() {
    const {clients} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            <div className="App-intro">
              <h2>Users</h2>
              {users.map(client =>
                  <div key={user.id}>
                    {user.name}
                  </div>
              )}
            </div>
          </header>
        </div>
    );
  }
}
export default App;
