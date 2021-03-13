import React from 'react';
import MovieLibrary from './components/MovieLibrary';
import data from './data';
import './App.css';

import Header from './components/Header';

function App() {
  return (
    <div className="App">
      <Header />
      <MovieLibrary movies={data} />
    </div>
  );
}

export default App;
