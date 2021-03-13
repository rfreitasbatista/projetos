import React from 'react';
import MovieCard from './MovieCard';

class MovieList extends React.Component {
  render() {
    const Movies = this.props.movies;
    return (
      <div className="movie-list">
        {Movies.map((each) => <MovieCard movie={each} key={each.title} />)}
      </div>
    );
  }
}

export default MovieList;
