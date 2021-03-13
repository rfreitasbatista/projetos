import React from 'react';

class TextAreaComponent extends React.Component {
  render() {
    const {
      lN,
      name,
      value,
      type,
      CF,
    } = this.props;

    return (
      <label htmlFor={name}>{lN}
        <textarea
          type={type}
          value={value}
          onChange={CF}
          name={name}
        />
      </label>
    );
  }
}

export default TextAreaComponent;
