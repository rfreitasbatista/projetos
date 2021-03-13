import React from 'react';

class InputComponent extends React.Component {
  render() {
    const {
      lN,
      name,
      value,
      type,
      CF,
    } = this.props;

    return (
      <label htmlFor={name}>
        {lN}
        <input type={type} value={value} onChange={CF} name={name} />
      </label>
    );
  }
}

export default InputComponent;
