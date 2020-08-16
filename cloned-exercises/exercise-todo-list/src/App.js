import React, { Component } from 'react';
import InputTodo from './InputTodo';
import Item from './Item';

class App extends Component {
  constructor(props) {
    super(props)
    this.state = {
      listTodo: [],
      disabled:true,
      selectedItem:''
    };
    this.addTodo = this.addTodo.bind(this);
    this.removeTodo = this.removeTodo.bind(this)
    this.rmItem = this.rmItem.bind(this)
  }

  addTodo(todo) {
    this.setState((state) => ({ listTodo: [...state.listTodo, todo] }));
  }

  removeTodo(e) {
    if(e.target.style.backgroundColor !== 'lightgrey') {
      e.target.style.backgroundColor = 'lightgrey'
    } else {
      e.target.style.backgroundColor = 'white'
    }
    this.setState({ disabled : !this.state.disabled, selectedItem : e.target.innerHTML })
  }

  rmItem() {
    const list = this.state.listTodo
    const item = this.state.selectedItem
    list.splice((list.indexOf(item)), 1)
    this.setState({ listTodo: list, disabled: true})
  }

  render() {
    const { listTodo, disabled } = this.state;
    return (
      <div className="App">
        <InputTodo rmItem={this.rmItem} dis={disabled} addTodo={(todo) => this.addTodo(todo)} />
        {listTodo &&
          <ul>
            {
              listTodo.map((todo, index) => (
                <li key={index + 1}>
                  <Item content={todo} func={this.removeTodo} />
                </li>
              ))
            }
          </ul>
        }
      </div>
    );
  }
}
export default App;
