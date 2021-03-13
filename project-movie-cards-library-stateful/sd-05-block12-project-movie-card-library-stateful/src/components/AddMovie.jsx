import React from 'react';
import IC from './InputComponent';
import TC from './TextareaComponent';

class AddMovie extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      subtitle: '',
      title: '',
      imagePath: '',
      storyline: '',
      rating: 0,
      genre: 'action',
    };
    this.addNewMovie = this.addNewMovie.bind(this);
    this.onChange = this.onChange.bind(this);
  }

  onChange(event) {
    const { name, value } = event.target;
    this.setState({ [name]: name === 'rating' ? Number(value) : value });
  }

  addNewMovie(event) {
    const callback = this.props.onClick;
    callback(this.state);
    this.setState({
      subtitle: '',
      title: '',
      imagePath: '',
      storyline: '',
      rating: 0,
      genre: 'action',
    });
    event.preventDefault();
  }

  render() {
    const { title, subtitle, imagePath, storyline, rating, genre } = this.state;
    return (
      <form>
        <IC lN="Título" name="title" value={title} type="text" CF={this.onChange} />
        <IC lN="Subtítulo" name="subtitle" value={subtitle} type="text" CF={this.onChange} />
        <IC lN="Imagem" name="imagePath" value={imagePath} type="text" CF={this.onChange} />
        <TC lN="Sinopse" name="storyline" value={storyline} CF={this.onChange} />
        <IC lN="Avaliação" name="rating" value={rating} type="number" CF={this.onChange} />
        <label htmlFor="genre">Gênero
          <select name="genre" value={genre} onChange={this.onChange}>
            <option value="action">Ação</option>
            <option value="comedy">Comédia</option>
            <option value="thriller">Suspense</option>
          </select></label>
        <button onClick={this.addNewMovie}>Adicionar filme</button>
      </form>
    );
  }
}

export default AddMovie;
