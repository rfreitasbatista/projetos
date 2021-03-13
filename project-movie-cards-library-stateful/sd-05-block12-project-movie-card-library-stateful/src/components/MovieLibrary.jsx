import React from 'react';
import SearchBar from './SearchBar';
import MovieList from './MovieList';
import AddMovie from './AddMovie';

class MovieLibrary extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      searchText: '',
      bookmarkedOnly: false,
      selectedGenre: '',
      movies: this.props.movies,
    };
    this.onClick = this.onClick.bind(this);
    this.OnChangeText = this.OnChangeText.bind(this);
    this.OnChangeBook = this.OnChangeBook.bind(this);
    this.OnChangeGenre = this.OnChangeGenre.bind(this);
  }

  onClick(newMovie) {
    this.setState({ movies: [...this.props.movies, newMovie] });
  }

  OnChangeText(event) {
    this.setState({ searchText: event.target.value });
  }

  OnChangeBook() {
    this.setState({ bookmarkedOnly: !this.state.bookmarkedOnly });
  }

  OnChangeGenre(event) {
    this.setState({ selectedGenre: event.target.value });
  }

  render() {
    const { searchText, bookmarkedOnly, selectedGenre, movies } = this.state;

    const textfiltered = movies.filter((movie) =>
        movie.title.includes(searchText) ||
        movie.subtitle.includes(searchText) ||
        movie.storyline.includes(searchText),
    );
    const genrefiltered = selectedGenre === '' ? textfiltered
        : textfiltered.filter((genre) => genre.genre === selectedGenre);
    const bookfilter = bookmarkedOnly === true ? genrefiltered.filter((book) =>
      book.bookmarked === bookmarkedOnly)
        : genrefiltered;
    return (
      <div>
        <SearchBar
          searchText={searchText} onSearchTextChange={this.OnChangeText}
          bookmarkedOnly={bookmarkedOnly} onBookmarkedChange={this.OnChangeBook}
          selectedGenre={selectedGenre} onSelectedGenreChange={this.OnChangeGenre}
        />
        <MovieList movies={bookfilter} />
        <AddMovie onClick={this.onClick} />
      </div>
    );
  }
}

export default MovieLibrary;
